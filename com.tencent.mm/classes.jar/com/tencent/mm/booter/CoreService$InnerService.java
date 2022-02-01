package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class CoreService$InnerService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(131843);
    super.onCreate();
    try
    {
      startForeground(-1213, new Notification());
      stopSelf();
      AppMethodBeat.o(131843);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        ad.e("MicroMsg.CoreService", "set service for push exception:%s.", new Object[] { localNullPointerException });
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131844);
    stopForeground(true);
    super.onDestroy();
    AppMethodBeat.o(131844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.CoreService.InnerService
 * JD-Core Version:    0.7.0.1
 */