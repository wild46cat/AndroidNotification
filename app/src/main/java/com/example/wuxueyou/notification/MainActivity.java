package com.example.wuxueyou.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    static final int NOTIFICATION_ID =0x123;
    NotificationManager nm;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        button = (Button)this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });
    }

    public void send(){
        Intent intent = new Intent(this,Other.class);
        PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,intent,0);
        Notification nofity = new Notification.Builder(this)
                .setAutoCancel(true)
                .setTicker("有新消息")
                .setSmallIcon(R.drawable.p1)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.notify))
                .setContentTitle("一条新通知")
                .setContentText("恭喜您,您加薪了,工资增加20%")
                .setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_LIGHTS|Notification.DEFAULT_VIBRATE)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pi)
                .build();
        nm.notify(NOTIFICATION_ID,nofity);
    }
    public void del(View v){
        nm.cancel(NOTIFICATION_ID);
    }
}
