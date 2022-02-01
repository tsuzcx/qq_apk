package com.tencent.mm.plugin.gamelive.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.gamelive.g.b;
import com.tencent.mm.plugin.gamelive.g.c;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/service/GameLiveForegroundService;", "Landroid/app/Service;", "()V", "getNotificationIconRs", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "flags", "startId", "Companion", "plugin-gamelive_release"})
public final class GameLiveForegroundService
  extends Service
{
  public static final GameLiveForegroundService.a DmO;
  
  static
  {
    AppMethodBeat.i(208595);
    DmO = new GameLiveForegroundService.a((byte)0);
    AppMethodBeat.o(208595);
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(208590);
    Log.i("MicroMsg.GameLiveForegroundService", "foreground service onCreate");
    if (!h.aHE().aGM())
    {
      stopSelf();
      AppMethodBeat.o(208590);
      return;
    }
    Object localObject = ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveExternalInfo();
    if (localObject != null)
    {
      localObject = ((azg)localObject).yxR;
      String str = com.tencent.mm.ci.a.ba((Context)this, g.c.Dlf);
      localObject = com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id").n((CharSequence)str).l((CharSequence)str).k((CharSequence)localObject).e(System.currentTimeMillis());
      if (Build.VERSION.SDK_INT >= 19) {
        break label149;
      }
    }
    label149:
    for (int i = g.b.notification_icon;; i = g.b.notification_icon_gray)
    {
      localObject = ((e.d)localObject).bn(i).gp().gr();
      p.j(localObject, "builder\n                ….setOngoing(true).build()");
      try
      {
        startForeground(46, (Notification)localObject);
        AppMethodBeat.o(208590);
        return;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.GameLiveForegroundService", "start foreground service happened error %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(208590);
      }
      localObject = null;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(208593);
    Log.i("MicroMsg.GameLiveForegroundService", "foreground service onDestroy");
    try
    {
      stopForeground(true);
      com.tencent.mm.kernel.b.a locala = h.ag(com.tencent.mm.plugin.notification.b.a.class);
      p.j(locala, "MMKernel.plugin(IPluginNotification::class.java)");
      ((com.tencent.mm.plugin.notification.b.a)locala).getNotification().cancel(46);
      super.onDestroy();
      AppMethodBeat.o(208593);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.GameLiveForegroundService", "onDestroy happened error %s", new Object[] { localException });
      }
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208588);
    Log.i("MicroMsg.GameLiveForegroundService", "foreground service onStartCommand");
    if (!h.aHE().aGM())
    {
      Log.e("MicroMsg.GameLiveForegroundService", "error called foreground service in onStartCommand process");
      stopSelf();
      AppMethodBeat.o(208588);
      return 2;
    }
    AppMethodBeat.o(208588);
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.service.GameLiveForegroundService
 * JD-Core Version:    0.7.0.1
 */