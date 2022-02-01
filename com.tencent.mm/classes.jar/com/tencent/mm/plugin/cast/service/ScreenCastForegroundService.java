package com.tencent.mm.plugin.cast.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.cast.PluginCast;
import com.tencent.mm.plugin.cast.PluginCast.a;
import com.tencent.mm.plugin.cast.b.g;
import com.tencent.mm.plugin.cast.d.a.b;
import com.tencent.mm.plugin.cast.d.a.f;
import com.tencent.mm.plugin.cast.i.c;
import com.tencent.mm.plugin.cast.ui.ScreenCastActivity;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/service/ScreenCastForegroundService;", "Landroid/app/Service;", "()V", "createNotificationChannel", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "", "flags", "startId", "Companion", "plugin-cast_release"})
public final class ScreenCastForegroundService
  extends Service
{
  public static final ScreenCastForegroundService.a tKb;
  
  static
  {
    AppMethodBeat.i(189833);
    tKb = new ScreenCastForegroundService.a((byte)0);
    AppMethodBeat.o(189833);
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(189805);
    super.onCreate();
    if (!com.tencent.mm.kernel.h.aHE().aGM())
    {
      stopSelf();
      AppMethodBeat.o(189805);
      return;
    }
    if (com.tencent.mm.compatible.util.d.qV(26))
    {
      Object localObject = new Intent((Context)this, ScreenCastActivity.class);
      ((Intent)localObject).setFlags(603979776);
      String str = getResources().getString(b.g.tIE);
      p.j(str, "resources.getString(R.st…creen_notification_title)");
      localObject = c.a((Intent)localObject, str, "", "");
      if (Build.VERSION.SDK_INT >= 29)
      {
        startForeground(47, (Notification)localObject, 32);
        AppMethodBeat.o(189805);
        return;
      }
      startForeground(47, (Notification)localObject);
    }
    AppMethodBeat.o(189805);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(189830);
    super.onDestroy();
    Log.i("MicroMsg.ScreenCastForegroundService", "Service onDestroy");
    AppMethodBeat.o(189830);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189827);
    p.k(paramIntent, "intent");
    Log.i("MicroMsg.ScreenCastForegroundService", "Service onStartCommand() is called");
    if (!com.tencent.mm.kernel.h.aHE().aGM())
    {
      Log.e("MicroMsg.ScreenCastForegroundService", "error called foreground service in startNotification process");
      stopSelf();
      AppMethodBeat.o(189827);
      return 2;
    }
    if (!com.tencent.mm.kernel.h.aHE().aGM())
    {
      Log.e("MicroMsg.ScreenCastForegroundService", "error called screen cast foreground service in setNotification process");
      stopSelf();
      AppMethodBeat.o(189827);
      return 2;
    }
    Object localObject1 = new Intent((Context)this, ScreenCastActivity.class);
    ((Intent)localObject1).setFlags(603979776);
    Object localObject2 = getResources().getString(b.g.tIE);
    p.j(localObject2, "resources.getString(R.st…creen_notification_title)");
    localObject1 = c.a((Intent)localObject1, (String)localObject2, "", "");
    localObject2 = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class);
    p.j(localObject2, "MMKernel.plugin(IPluginNotification::class.java)");
    ((com.tencent.mm.plugin.notification.b.a)localObject2).getNotification().a(47, (Notification)localObject1, false);
    localObject1 = PluginCast.tIg;
    localObject1 = PluginCast.a.cLu();
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.cast.d.a)localObject1).tJl = ((Intent)paramIntent.getParcelableExtra("data"));
    }
    localObject1 = PluginCast.tIg;
    localObject1 = PluginCast.a.cLu();
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.cast.d.a)localObject1).resultCode = paramIntent.getIntExtra("code", -1);
    }
    paramIntent = PluginCast.tIg;
    paramIntent = PluginCast.a.cLu();
    Object localObject3;
    Object localObject4;
    if (paramIntent != null)
    {
      localObject1 = (Context)this;
      p.k(localObject1, "context");
      try
      {
        localObject2 = paramIntent.tJj;
        if (localObject2 != null)
        {
          paramIntent.tJo = new com.tencent.mm.plugin.cast.f.b(((com.tencent.mm.media.b.d)localObject2).targetWidth, ((com.tencent.mm.media.b.d)localObject2).targetHeight, ((com.tencent.mm.media.b.d)localObject2).frameRate);
          localObject3 = paramIntent.tJl;
          if (localObject3 == null) {
            p.iCn();
          }
          paramInt1 = paramIntent.resultCode;
          p.k(localObject1, "context");
          p.k(localObject3, "intent");
          Log.i("MicroMsg.ScreenCastManager", "createMediaProjection");
          localObject4 = ((Context)localObject1).getSystemService("media_projection");
          if (localObject4 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type android.media.projection.MediaProjectionManager");
            AppMethodBeat.o(189827);
            throw ((Throwable)localObject1);
          }
        }
      }
      catch (Exception localException)
      {
        Log.printInfoStack("MicroMsg.ScreenCastManager", "start foregound service failed cause " + localException + " and stack is %s", new Object[] { localException.getStackTrace() });
        paramIntent = paramIntent.tJz;
        if (paramIntent != null) {
          paramIntent.invoke(com.tencent.mm.plugin.cast.h.a.b.tKv);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(189827);
      return 2;
      localObject3 = ((MediaProjectionManager)localObject4).getMediaProjection(paramInt1, (Intent)localObject3);
      p.j(localObject3, "(context.getSystemServic…ction(resultCode, intent)");
      p.k(localException, "context");
      p.k(localObject3, "mediaProject");
      p.k(localObject2, "config");
      Log.i("MicroMsg.ScreenCastManager", "createVirtualDisplay");
      paramInt1 = (int)com.tencent.mm.ci.a.getDensity(localException);
      localObject4 = ((MediaProjection)localObject3).createVirtualDisplay("MicroMsg.ScreenCastManager", ((com.tencent.mm.media.b.d)localObject2).targetWidth, ((com.tencent.mm.media.b.d)localObject2).targetHeight, paramInt1, 16, null, null, null);
      p.j(localObject4, "mediaProject.createVirtu…MIRROR, null, null, null)");
      paramIntent.mVirtualDisplay = ((VirtualDisplay)localObject4);
      paramIntent.tJk = ((MediaProjection)localObject3);
      localObject3 = paramIntent.tJo;
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.cast.f.b)localObject3).j((kotlin.g.a.a)new a.b(paramIntent, (com.tencent.mm.plugin.cast.b.b)localObject2, localException));
      }
      com.tencent.mm.plugin.cast.g.a locala = com.tencent.mm.plugin.cast.g.a.tKa;
      com.tencent.mm.plugin.cast.g.a.cLK();
      com.tencent.e.h.ZvG.bc((Runnable)a.f.tJH);
      paramIntent.tJr = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.service.ScreenCastForegroundService
 * JD-Core Version:    0.7.0.1
 */