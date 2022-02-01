package com.tencent.mm.plugin.gamelive.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.gamelive.e.b;
import com.tencent.mm.plugin.gamelive.e.c;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/service/GameLiveForegroundService;", "Landroid/app/Service;", "()V", "getNotificationIconRs", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "flags", "startId", "Companion", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLiveForegroundService
  extends Service
{
  public static final a Jgy;
  
  static
  {
    AppMethodBeat.i(277234);
    Jgy = new a((byte)0);
    AppMethodBeat.o(277234);
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(277250);
    Log.i("MicroMsg.GameLiveForegroundService", "foreground service onCreate");
    if (!h.baC().aZN())
    {
      stopSelf();
      AppMethodBeat.o(277250);
      return;
    }
    Object localObject = ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveExternalInfo();
    if (localObject == null)
    {
      localObject = null;
      String str = com.tencent.mm.cd.a.bt((Context)this, e.c.Jep);
      localObject = com.tencent.mm.bq.a.cA(MMApplicationContext.getContext(), "reminder_channel_id").o((CharSequence)str).m((CharSequence)str).l((CharSequence)localObject).bt(System.currentTimeMillis());
      if (Build.VERSION.SDK_INT >= 19) {
        break label154;
      }
    }
    label154:
    for (int i = e.b.notification_icon;; i = e.b.notification_icon_gray)
    {
      localObject = ((f.d)localObject).eb(i);
      ((f.d)localObject).q(2, true);
      localObject = ((f.d)localObject).DA();
      s.s(localObject, "builder\n                ….setOngoing(true).build()");
      try
      {
        startForeground(46, (Notification)localObject);
        AppMethodBeat.o(277250);
        return;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.GameLiveForegroundService", "start foreground service happened error %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(277250);
      }
      localObject = ((bgt)localObject).Dky;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(277258);
    Log.i("MicroMsg.GameLiveForegroundService", "foreground service onDestroy");
    try
    {
      stopForeground(true);
      ((com.tencent.mm.plugin.notification.b.b)h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(46);
      super.onDestroy();
      AppMethodBeat.o(277258);
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
    AppMethodBeat.i(277239);
    Log.i("MicroMsg.GameLiveForegroundService", "foreground service onStartCommand");
    if (!h.baC().aZN())
    {
      Log.e("MicroMsg.GameLiveForegroundService", "error called foreground service in onStartCommand process");
      stopSelf();
      AppMethodBeat.o(277239);
      return 2;
    }
    AppMethodBeat.o(277239);
    return 3;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/service/GameLiveForegroundService$Companion;", "", "()V", "TAG", "", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.service.GameLiveForegroundService
 * JD-Core Version:    0.7.0.1
 */