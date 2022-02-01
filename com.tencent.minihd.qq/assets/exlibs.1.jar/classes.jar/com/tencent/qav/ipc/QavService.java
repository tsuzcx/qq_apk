package com.tencent.qav.ipc;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.qav.log.AVLog;
import ljj;
import mqq.app.AppService;

public class QavService
  extends AppService
{
  public static final String a = "qav.Action.QavService.Start";
  public static final String b = "extra_action";
  public static final String c = "extra_foreground";
  public static final String d = "extra_notification";
  public static final String e = "action_set_foreground";
  private static final String f = "QavService";
  private IQavService.Stub a;
  
  private void a()
  {
    Intent localIntent = new Intent("qav.Action.QavService.Start");
    localIntent.setPackage(getPackageName());
    sendBroadcast(localIntent);
  }
  
  private void a(boolean paramBoolean, Notification paramNotification)
  {
    AVLog.d("QavService", String.format("setForeground foreground=%s notification=%s", new Object[] { Boolean.valueOf(paramBoolean), paramNotification }));
    if (paramBoolean)
    {
      Notification localNotification = paramNotification;
      if (paramNotification == null) {
        localNotification = new Notification();
      }
      try
      {
        startForeground(1, localNotification);
        return;
      }
      catch (Exception paramNotification)
      {
        AVLog.e("QavService", "setForeground fail.", paramNotification);
        return;
      }
    }
    stopForeground(true);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.a;
  }
  
  public void onCreate()
  {
    super.onCreate();
    AVLog.d("QavService", "onCreate");
    this.a = new ljj(this, null);
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    AVLog.d("QavService", "onDestroy");
    this.a = null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      String str = paramIntent.getStringExtra("extra_action");
      AVLog.d("QavService", String.format("onStartCommand action=%s", new Object[] { str }));
      if ("action_set_foreground".equals(str)) {
        a(paramIntent.getBooleanExtra("extra_foreground", false), (Notification)paramIntent.getParcelableExtra("extra_notification"));
      }
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.ipc.QavService
 * JD-Core Version:    0.7.0.1
 */