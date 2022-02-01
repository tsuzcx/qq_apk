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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/mini/LiveForegroundService;", "Landroid/app/Service;", "()V", "getNotificationIconRs", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "flags", "startId", "parseCreateNotification", "Landroid/app/Notification;", "startNotification", "Companion", "plugin-core_release"})
public final class LiveForegroundService
  extends Service
{
  public static final a qON;
  
  static
  {
    AppMethodBeat.i(205713);
    qON = new a((byte)0);
    AppMethodBeat.o(205713);
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(205711);
    ad.i("MicroMsg.LiveForegroundService", "foreground service onCreate");
    if (!g.afz().aeI())
    {
      stopSelf();
      AppMethodBeat.o(205711);
      return;
    }
    if (d.lf(26))
    {
      Object localObject = com.tencent.mm.br.a.bD(aj.getContext(), "reminder_channel_id").g(System.currentTimeMillis());
      if (Build.VERSION.SDK_INT < 19) {}
      for (int i = 2131233500;; i = 2131233502)
      {
        localObject = ((s.c)localObject).as(i).dN().build();
        k.g(localObject, "NotificationHelper.getNo….setOngoing(true).build()");
        try
        {
          startForeground(46, (Notification)localObject);
          AppMethodBeat.o(205711);
          return;
        }
        catch (Exception localException)
        {
          ad.i("MicroMsg.LiveForegroundService", "start foreground service happened error %s", new Object[] { localException.getMessage() });
        }
      }
    }
    AppMethodBeat.o(205711);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(205712);
    ad.i("MicroMsg.LiveForegroundService", "foreground service onDestroy");
    try
    {
      stopForeground(true);
      com.tencent.mm.kernel.b.a locala = g.ad(com.tencent.mm.plugin.notification.b.a.class);
      k.g(locala, "MMKernel.plugin(IPluginNotification::class.java)");
      ((com.tencent.mm.plugin.notification.b.a)locala).getNotification().cancel(46);
      super.onDestroy();
      AppMethodBeat.o(205712);
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
    AppMethodBeat.i(205710);
    ad.i("MicroMsg.LiveForegroundService", "foreground service onStartCommand");
    if (!g.afz().aeI())
    {
      ad.e("MicroMsg.LiveForegroundService", "error called foreground service in onStartCommand process");
      stopSelf();
      AppMethodBeat.o(205710);
      return 2;
    }
    if ((d.lf(26)) && (paramIntent != null))
    {
      if (!g.afz().aeI())
      {
        ad.e("MicroMsg.LiveForegroundService", "error called foreground service in startNotification process");
        stopSelf();
      }
    }
    else
    {
      AppMethodBeat.o(205710);
      return 3;
    }
    paramIntent.setClass(aj.getContext(), Class.forName(paramIntent.getStringExtra("PARAM_ACTIVITY_NAME")));
    paramIntent.setFlags(268435456);
    Object localObject = paramIntent.getStringExtra("PARAM_TITLE");
    String str1 = paramIntent.getStringExtra("PARAM_CONTENT");
    String str2 = paramIntent.getStringExtra("PARAM_TICKER");
    b localb = b.qPc;
    k.g(localObject, "title");
    k.g(str1, "content");
    k.g(str2, "ticker");
    k.h(paramIntent, "intent");
    k.h(localObject, "title");
    k.h(str1, "content");
    k.h(str2, "tickerContent");
    paramIntent = PendingIntent.getActivity(aj.getContext(), 46, paramIntent, 134217728);
    paramIntent = com.tencent.mm.br.a.bD(aj.getContext(), "reminder_channel_id").i((CharSequence)str2).g(System.currentTimeMillis()).f((CharSequence)localObject).g((CharSequence)str1).a(paramIntent).as(com.tencent.mm.br.a.cYf()).dN();
    k.g(paramIntent, "NotificationHelper.getNo…        .setOngoing(true)");
    if (d.lg(16)) {}
    for (paramIntent = b.e(paramIntent);; paramIntent = b.d(paramIntent))
    {
      localObject = g.ad(com.tencent.mm.plugin.notification.b.a.class);
      k.g(localObject, "MMKernel.plugin(IPluginNotification::class.java)");
      ((com.tencent.mm.plugin.notification.b.a)localObject).getNotification().a(46, paramIntent, false);
      break;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/mini/LiveForegroundService$Companion;", "", "()V", "PARAM_ACTIVITY_NAME", "", "PARAM_CONTENT", "PARAM_TICKER", "PARAM_TITLE", "TAG", "plugin-core_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.LiveForegroundService
 * JD-Core Version:    0.7.0.1
 */