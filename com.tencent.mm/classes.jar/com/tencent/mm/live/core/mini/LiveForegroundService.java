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
import com.tencent.mm.model.ar;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/mini/LiveForegroundService;", "Landroid/app/Service;", "()V", "getNotificationIconRs", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "flags", "startId", "parseCreateNotification", "Landroid/app/Notification;", "startNotification", "Companion", "plugin-core_release"})
public final class LiveForegroundService
  extends Service
{
  public static final LiveForegroundService.a gKr;
  
  static
  {
    AppMethodBeat.i(216907);
    gKr = new LiveForegroundService.a((byte)0);
    AppMethodBeat.o(216907);
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(216905);
    ad.i("MicroMsg.LiveForegroundService", "foreground service onCreate");
    if (!g.ajA().aiK())
    {
      stopSelf();
      AppMethodBeat.o(216905);
      return;
    }
    if (d.ly(26))
    {
      Object localObject = com.tencent.mm.br.a.bI(aj.getContext(), "reminder_channel_id").i(System.currentTimeMillis());
      if (Build.VERSION.SDK_INT < 19) {}
      for (int i = 2131233500;; i = 2131233502)
      {
        localObject = ((s.c)localObject).as(i).ep().build();
        p.g(localObject, "NotificationHelper.getNo….setOngoing(true).build()");
        try
        {
          startForeground(46, (Notification)localObject);
          AppMethodBeat.o(216905);
          return;
        }
        catch (Exception localException)
        {
          ad.i("MicroMsg.LiveForegroundService", "start foreground service happened error %s", new Object[] { localException.getMessage() });
        }
      }
    }
    AppMethodBeat.o(216905);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(216906);
    ad.i("MicroMsg.LiveForegroundService", "foreground service onDestroy");
    try
    {
      stopForeground(true);
      com.tencent.mm.kernel.b.a locala = g.ad(com.tencent.mm.plugin.notification.b.a.class);
      p.g(locala, "MMKernel.plugin(IPluginNotification::class.java)");
      ((com.tencent.mm.plugin.notification.b.a)locala).getNotification().cancel(46);
      super.onDestroy();
      AppMethodBeat.o(216906);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.LiveForegroundService", "onDestroy happened error %s", new Object[] { localException });
      }
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216904);
    ad.i("MicroMsg.LiveForegroundService", "foreground service onStartCommand");
    if (!g.ajA().aiK())
    {
      ad.e("MicroMsg.LiveForegroundService", "error called foreground service in onStartCommand process");
      stopSelf();
      AppMethodBeat.o(216904);
      return 2;
    }
    if ((d.ly(26)) && (paramIntent != null))
    {
      if (!g.ajA().aiK())
      {
        ad.e("MicroMsg.LiveForegroundService", "error called foreground service in startNotification process");
        stopSelf();
      }
    }
    else
    {
      AppMethodBeat.o(216904);
      return 3;
    }
    paramIntent.setClass(aj.getContext(), Class.forName(paramIntent.getStringExtra("PARAM_ACTIVITY_NAME")));
    paramIntent.setFlags(268435456);
    Object localObject = paramIntent.getStringExtra("PARAM_TITLE");
    String str1 = paramIntent.getStringExtra("PARAM_CONTENT");
    String str2 = paramIntent.getStringExtra("PARAM_TICKER");
    b localb = b.gKw;
    p.g(localObject, "title");
    p.g(str1, "content");
    p.g(str2, "ticker");
    p.h(paramIntent, "intent");
    p.h(localObject, "title");
    p.h(str1, "content");
    p.h(str2, "tickerContent");
    paramIntent = PendingIntent.getActivity(aj.getContext(), 46, paramIntent, 134217728);
    paramIntent = com.tencent.mm.br.a.bI(aj.getContext(), "reminder_channel_id").i((CharSequence)str2).i(System.currentTimeMillis()).f((CharSequence)localObject).g((CharSequence)str1).a(paramIntent).as(com.tencent.mm.br.a.dwe()).ep();
    p.g(paramIntent, "NotificationHelper.getNo…        .setOngoing(true)");
    if (d.lz(16)) {}
    for (paramIntent = b.d(paramIntent);; paramIntent = b.c(paramIntent))
    {
      localObject = g.ad(com.tencent.mm.plugin.notification.b.a.class);
      p.g(localObject, "MMKernel.plugin(IPluginNotification::class.java)");
      ((com.tencent.mm.plugin.notification.b.a)localObject).getNotification().a(46, paramIntent, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.LiveForegroundService
 * JD-Core Version:    0.7.0.1
 */