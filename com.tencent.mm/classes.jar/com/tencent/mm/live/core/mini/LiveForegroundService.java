package com.tencent.mm.live.core.mini;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.core.a.c;
import com.tencent.mm.model.ay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/mini/LiveForegroundService;", "Landroid/app/Service;", "()V", "getNotificationIconRs", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "flags", "startId", "parseCreateNotification", "Landroid/app/Notification;", "startNotification", "Companion", "plugin-core_release"})
public final class LiveForegroundService
  extends Service
{
  public static final LiveForegroundService.a kqN;
  
  static
  {
    AppMethodBeat.i(200807);
    kqN = new LiveForegroundService.a((byte)0);
    AppMethodBeat.o(200807);
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(200802);
    Log.i("MicroMsg.LiveForegroundService", "foreground service onCreate");
    if (!h.aHE().aGM())
    {
      stopSelf();
      AppMethodBeat.o(200802);
      return;
    }
    if (d.qV(26))
    {
      Object localObject = com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id").e(System.currentTimeMillis());
      if (Build.VERSION.SDK_INT < 19) {}
      for (int i = a.c.notification_icon;; i = a.c.notification_icon_gray)
      {
        localObject = ((e.d)localObject).bn(i).gp().gr();
        p.j(localObject, "NotificationHelper.getNo….setOngoing(true).build()");
        try
        {
          startForeground(46, (Notification)localObject);
          AppMethodBeat.o(200802);
          return;
        }
        catch (Exception localException)
        {
          Log.i("MicroMsg.LiveForegroundService", "start foreground service happened error %s", new Object[] { localException.getMessage() });
        }
      }
    }
    AppMethodBeat.o(200802);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(200804);
    Log.i("MicroMsg.LiveForegroundService", "foreground service onDestroy");
    try
    {
      stopForeground(true);
      com.tencent.mm.kernel.b.a locala = h.ag(com.tencent.mm.plugin.notification.b.a.class);
      p.j(locala, "MMKernel.plugin(IPluginNotification::class.java)");
      ((com.tencent.mm.plugin.notification.b.a)locala).getNotification().cancel(46);
      super.onDestroy();
      AppMethodBeat.o(200804);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.LiveForegroundService", "onDestroy happened error %s", new Object[] { localException });
      }
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200801);
    Log.i("MicroMsg.LiveForegroundService", "foreground service onStartCommand");
    if (!h.aHE().aGM())
    {
      Log.e("MicroMsg.LiveForegroundService", "error called foreground service in onStartCommand process");
      stopSelf();
      AppMethodBeat.o(200801);
      return 2;
    }
    if ((d.qV(26)) && (paramIntent != null))
    {
      if (!h.aHE().aGM())
      {
        Log.e("MicroMsg.LiveForegroundService", "error called foreground service in startNotification process");
        stopSelf();
      }
    }
    else
    {
      AppMethodBeat.o(200801);
      return 3;
    }
    paramIntent.setClass(MMApplicationContext.getContext(), Class.forName(paramIntent.getStringExtra("PARAM_ACTIVITY_NAME")));
    paramIntent.setFlags(268435456);
    Object localObject = paramIntent.getStringExtra("PARAM_TITLE");
    String str1 = paramIntent.getStringExtra("PARAM_CONTENT");
    String str2 = paramIntent.getStringExtra("PARAM_TICKER");
    c localc = c.kqX;
    p.j(localObject, "title");
    p.j(str1, "content");
    p.j(str2, "ticker");
    p.k(paramIntent, "intent");
    p.k(localObject, "title");
    p.k(str1, "content");
    p.k(str2, "tickerContent");
    paramIntent = PendingIntent.getActivity(MMApplicationContext.getContext(), 46, paramIntent, 134217728);
    paramIntent = com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id").n((CharSequence)str2).e(System.currentTimeMillis()).k((CharSequence)localObject).l((CharSequence)str1).a(paramIntent).bn(com.tencent.mm.bx.a.fkG()).gp();
    p.j(paramIntent, "NotificationHelper.getNo…        .setOngoing(true)");
    if (d.qW(16)) {}
    for (paramIntent = c.d(paramIntent);; paramIntent = c.c(paramIntent))
    {
      localObject = h.ag(com.tencent.mm.plugin.notification.b.a.class);
      p.j(localObject, "MMKernel.plugin(IPluginNotification::class.java)");
      ((com.tencent.mm.plugin.notification.b.a)localObject).getNotification().a(46, paramIntent, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.LiveForegroundService
 * JD-Core Version:    0.7.0.1
 */