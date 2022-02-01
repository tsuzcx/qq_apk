package com.tencent.mm.live.core.mini;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.core.a.c;
import com.tencent.mm.model.ay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/mini/LiveForegroundService;", "Landroid/app/Service;", "()V", "getNotificationIconRs", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "flags", "startId", "parseCreateNotification", "Landroid/app/Notification;", "startNotification", "Companion", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveForegroundService
  extends Service
{
  public static final a mUH;
  
  static
  {
    AppMethodBeat.i(247593);
    mUH = new a((byte)0);
    AppMethodBeat.o(247593);
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(247618);
    Log.i("MicroMsg.LiveForegroundService", "foreground service onCreate");
    if (!h.baC().aZN())
    {
      stopSelf();
      AppMethodBeat.o(247618);
      return;
    }
    if (d.rb(26))
    {
      Object localObject = a.cA(MMApplicationContext.getContext(), "reminder_channel_id").bt(System.currentTimeMillis());
      if (Build.VERSION.SDK_INT < 19) {}
      for (int i = a.c.notification_icon;; i = a.c.notification_icon_gray)
      {
        localObject = ((f.d)localObject).eb(i);
        ((f.d)localObject).q(2, true);
        localObject = ((f.d)localObject).DA();
        s.s(localObject, "getNotificationBuilder(M….setOngoing(true).build()");
        try
        {
          startForeground(46, (Notification)localObject);
          AppMethodBeat.o(247618);
          return;
        }
        catch (Exception localException)
        {
          Log.i("MicroMsg.LiveForegroundService", "start foreground service happened error %s", new Object[] { localException.getMessage() });
        }
      }
    }
    AppMethodBeat.o(247618);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(247625);
    Log.i("MicroMsg.LiveForegroundService", "foreground service onDestroy");
    try
    {
      stopForeground(true);
      ((com.tencent.mm.plugin.notification.b.b)h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(46);
      super.onDestroy();
      AppMethodBeat.o(247625);
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
    AppMethodBeat.i(247611);
    Log.i("MicroMsg.LiveForegroundService", "foreground service onStartCommand");
    if (!h.baC().aZN())
    {
      Log.e("MicroMsg.LiveForegroundService", "error called foreground service in onStartCommand process");
      stopSelf();
      AppMethodBeat.o(247611);
      return 2;
    }
    if ((d.rb(26)) && (paramIntent != null))
    {
      if (!h.baC().aZN())
      {
        Log.e("MicroMsg.LiveForegroundService", "error called foreground service in startNotification process");
        stopSelf();
      }
    }
    else
    {
      AppMethodBeat.o(247611);
      return 3;
    }
    paramIntent.setClass(MMApplicationContext.getContext(), Class.forName(paramIntent.getStringExtra("PARAM_ACTIVITY_NAME")));
    paramIntent.setFlags(268435456);
    Object localObject = paramIntent.getStringExtra("PARAM_TITLE");
    String str1 = paramIntent.getStringExtra("PARAM_CONTENT");
    String str2 = paramIntent.getStringExtra("PARAM_TICKER");
    c localc = c.mUS;
    s.checkNotNull(localObject);
    s.checkNotNull(str1);
    s.checkNotNull(str2);
    s.u(paramIntent, "intent");
    s.u(localObject, "title");
    s.u(str1, "content");
    s.u(str2, "tickerContent");
    paramIntent = PendingIntent.getActivity(MMApplicationContext.getContext(), 46, paramIntent, 134217728);
    localObject = a.cA(MMApplicationContext.getContext(), "reminder_channel_id").o((CharSequence)str2).bt(System.currentTimeMillis()).l((CharSequence)localObject).m((CharSequence)str1);
    ((f.d)localObject).bor = paramIntent;
    paramIntent = ((f.d)localObject).eb(a.guX());
    paramIntent.q(2, true);
    s.s(paramIntent, "getNotificationBuilder(M…        .setOngoing(true)");
    if (d.rc(16)) {}
    for (paramIntent = c.d(paramIntent);; paramIntent = c.c(paramIntent))
    {
      ((com.tencent.mm.plugin.notification.b.b)h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().a(46, paramIntent, false);
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/mini/LiveForegroundService$Companion;", "", "()V", "PARAM_ACTIVITY_NAME", "", "PARAM_CONTENT", "PARAM_TICKER", "PARAM_TITLE", "TAG", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.LiveForegroundService
 * JD-Core Version:    0.7.0.1
 */