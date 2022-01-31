package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.y;

public class CoreService$InnerService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    try
    {
      startForeground(-1213, new Notification());
      stopSelf();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        y.e("MicroMsg.CoreService", "set service for push exception:%s.", new Object[] { localNullPointerException });
      }
    }
  }
  
  public void onDestroy()
  {
    stopForeground(true);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.CoreService.InnerService
 * JD-Core Version:    0.7.0.1
 */