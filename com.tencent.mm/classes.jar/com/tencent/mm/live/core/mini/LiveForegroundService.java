package com.tencent.mm.live.core.mini;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/mini/LiveForegroundService;", "Landroid/app/Service;", "()V", "getNotificationIconRs", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "flags", "startId", "parseCreateNotification", "Landroid/app/Notification;", "startNotification", "Companion", "plugin-core_release"})
public final class LiveForegroundService
  extends Service
{
  public static final LiveForegroundService.a gqH;
  
  static
  {
    AppMethodBeat.i(209249);
    gqH = new LiveForegroundService.a((byte)0);
    AppMethodBeat.o(209249);
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(209247);
    ac.i("MicroMsg.LiveForegroundService", "foreground service onCreate");
    if (!g.agP().afY())
    {
      stopSelf();
      AppMethodBeat.o(209247);
      return;
    }
    if (d.kZ(26))
    {
      Object localObject = com.tencent.mm.bq.a.bE(ai.getContext(), "reminder_channel_id").i(System.currentTimeMillis());
      if (Build.VERSION.SDK_INT < 19) {}
      for (int i = 2131233500;; i = 2131233502)
      {
        localObject = ((s.c)localObject).as(i).dU().build();
        k.g(localObject, "NotificationHelper.getNo….setOngoing(true).build()");
        try
        {
          startForeground(46, (Notification)localObject);
          AppMethodBeat.o(209247);
          return;
        }
        catch (Exception localException)
        {
          ac.i("MicroMsg.LiveForegroundService", "start foreground service happened error %s", new Object[] { localException.getMessage() });
        }
      }
    }
    AppMethodBeat.o(209247);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(209248);
    ac.i("MicroMsg.LiveForegroundService", "foreground service onDestroy");
    try
    {
      stopForeground(true);
      com.tencent.mm.kernel.b.a locala = g.ad(com.tencent.mm.plugin.notification.b.a.class);
      k.g(locala, "MMKernel.plugin(IPluginNotification::class.java)");
      ((com.tencent.mm.plugin.notification.b.a)locala).getNotification().cancel(46);
      super.onDestroy();
      AppMethodBeat.o(209248);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.LiveForegroundService", "onDestroy happened error %s", new Object[] { localException });
      }
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209246);
    ac.i("MicroMsg.LiveForegroundService", "foreground service onStartCommand");
    if (!g.agP().afY())
    {
      ac.e("MicroMsg.LiveForegroundService", "error called foreground service in onStartCommand process");
      stopSelf();
      AppMethodBeat.o(209246);
      return 2;
    }
    if ((d.kZ(26)) && (paramIntent != null))
    {
      if (!g.agP().afY())
      {
        ac.e("MicroMsg.LiveForegroundService", "error called foreground service in startNotification process");
        stopSelf();
      }
    }
    else
    {
      AppMethodBeat.o(209246);
      return 3;
    }
    paramIntent.setClass(ai.getContext(), Class.forName(paramIntent.getStringExtra("PARAM_ACTIVITY_NAME")));
    paramIntent.setFlags(268435456);
    Object localObject = paramIntent.getStringExtra("PARAM_TITLE");
    String str1 = paramIntent.getStringExtra("PARAM_CONTENT");
    String str2 = paramIntent.getStringExtra("PARAM_TICKER");
    b localb = b.gqM;
    k.g(localObject, "title");
    k.g(str1, "content");
    k.g(str2, "ticker");
    k.h(paramIntent, "intent");
    k.h(localObject, "title");
    k.h(str1, "content");
    k.h(str2, "tickerContent");
    paramIntent = PendingIntent.getActivity(ai.getContext(), 46, paramIntent, 134217728);
    paramIntent = com.tencent.mm.bq.a.bE(ai.getContext(), "reminder_channel_id").i((CharSequence)str2).i(System.currentTimeMillis()).f((CharSequence)localObject).g((CharSequence)str1).a(paramIntent).as(com.tencent.mm.bq.a.dlN()).dU();
    k.g(paramIntent, "NotificationHelper.getNo…        .setOngoing(true)");
    if (d.la(16)) {}
    for (paramIntent = b.d(paramIntent);; paramIntent = b.c(paramIntent))
    {
      localObject = g.ad(com.tencent.mm.plugin.notification.b.a.class);
      k.g(localObject, "MMKernel.plugin(IPluginNotification::class.java)");
      ((com.tencent.mm.plugin.notification.b.a)localObject).getNotification().a(46, paramIntent, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.LiveForegroundService
 * JD-Core Version:    0.7.0.1
 */