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
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/mini/LiveForegroundService;", "Landroid/app/Service;", "()V", "getNotificationIconRs", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "flags", "startId", "parseCreateNotification", "Landroid/app/Notification;", "startNotification", "Companion", "plugin-core_release"})
public final class LiveForegroundService
  extends Service
{
  public static final LiveForegroundService.a gNa;
  
  static
  {
    AppMethodBeat.i(196919);
    gNa = new LiveForegroundService.a((byte)0);
    AppMethodBeat.o(196919);
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(196917);
    ae.i("MicroMsg.LiveForegroundService", "foreground service onCreate");
    if (!g.ajP().aiZ())
    {
      stopSelf();
      AppMethodBeat.o(196917);
      return;
    }
    if (d.lA(26))
    {
      Object localObject = com.tencent.mm.bq.a.bJ(ak.getContext(), "reminder_channel_id").i(System.currentTimeMillis());
      if (Build.VERSION.SDK_INT < 19) {}
      for (int i = 2131233500;; i = 2131233502)
      {
        localObject = ((s.c)localObject).as(i).ep().build();
        p.g(localObject, "NotificationHelper.getNo….setOngoing(true).build()");
        try
        {
          startForeground(46, (Notification)localObject);
          AppMethodBeat.o(196917);
          return;
        }
        catch (Exception localException)
        {
          ae.i("MicroMsg.LiveForegroundService", "start foreground service happened error %s", new Object[] { localException.getMessage() });
        }
      }
    }
    AppMethodBeat.o(196917);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(196918);
    ae.i("MicroMsg.LiveForegroundService", "foreground service onDestroy");
    try
    {
      stopForeground(true);
      com.tencent.mm.kernel.b.a locala = g.ad(com.tencent.mm.plugin.notification.b.a.class);
      p.g(locala, "MMKernel.plugin(IPluginNotification::class.java)");
      ((com.tencent.mm.plugin.notification.b.a)locala).getNotification().cancel(46);
      super.onDestroy();
      AppMethodBeat.o(196918);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.LiveForegroundService", "onDestroy happened error %s", new Object[] { localException });
      }
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196916);
    ae.i("MicroMsg.LiveForegroundService", "foreground service onStartCommand");
    if (!g.ajP().aiZ())
    {
      ae.e("MicroMsg.LiveForegroundService", "error called foreground service in onStartCommand process");
      stopSelf();
      AppMethodBeat.o(196916);
      return 2;
    }
    if ((d.lA(26)) && (paramIntent != null))
    {
      if (!g.ajP().aiZ())
      {
        ae.e("MicroMsg.LiveForegroundService", "error called foreground service in startNotification process");
        stopSelf();
      }
    }
    else
    {
      AppMethodBeat.o(196916);
      return 3;
    }
    paramIntent.setClass(ak.getContext(), Class.forName(paramIntent.getStringExtra("PARAM_ACTIVITY_NAME")));
    paramIntent.setFlags(268435456);
    Object localObject = paramIntent.getStringExtra("PARAM_TITLE");
    String str1 = paramIntent.getStringExtra("PARAM_CONTENT");
    String str2 = paramIntent.getStringExtra("PARAM_TICKER");
    b localb = b.gNf;
    p.g(localObject, "title");
    p.g(str1, "content");
    p.g(str2, "ticker");
    p.h(paramIntent, "intent");
    p.h(localObject, "title");
    p.h(str1, "content");
    p.h(str2, "tickerContent");
    paramIntent = PendingIntent.getActivity(ak.getContext(), 46, paramIntent, 134217728);
    paramIntent = com.tencent.mm.bq.a.bJ(ak.getContext(), "reminder_channel_id").i((CharSequence)str2).i(System.currentTimeMillis()).f((CharSequence)localObject).g((CharSequence)str1).a(paramIntent).as(com.tencent.mm.bq.a.dzu()).ep();
    p.g(paramIntent, "NotificationHelper.getNo…        .setOngoing(true)");
    if (d.lB(16)) {}
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