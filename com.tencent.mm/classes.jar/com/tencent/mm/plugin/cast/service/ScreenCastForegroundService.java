package com.tencent.mm.plugin.cast.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.cast.PluginCast;
import com.tencent.mm.plugin.cast.PluginCast.a;
import com.tencent.mm.plugin.cast.b.g;
import com.tencent.mm.plugin.cast.c.a;
import com.tencent.mm.plugin.cast.h.c;
import com.tencent.mm.plugin.cast.ui.ScreenCastActivity;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/service/ScreenCastForegroundService;", "Landroid/app/Service;", "()V", "createNotificationChannel", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "", "flags", "startId", "Companion", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScreenCastForegroundService
  extends Service
{
  public static final ScreenCastForegroundService.a wNu;
  
  static
  {
    AppMethodBeat.i(274054);
    wNu = new ScreenCastForegroundService.a((byte)0);
    AppMethodBeat.o(274054);
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(274063);
    super.onCreate();
    if (!h.baC().aZN())
    {
      stopSelf();
      AppMethodBeat.o(274063);
      return;
    }
    if (d.rb(26))
    {
      Object localObject = new Intent((Context)this, ScreenCastActivity.class);
      ((Intent)localObject).setFlags(603979776);
      String str = getResources().getString(b.g.wMm);
      s.s(str, "resources.getString(R.st…creen_notification_title)");
      localObject = c.a((Intent)localObject, str, "", "");
      if (Build.VERSION.SDK_INT >= 29)
      {
        startForeground(47, (Notification)localObject, 32);
        AppMethodBeat.o(274063);
        return;
      }
      startForeground(47, (Notification)localObject);
    }
    AppMethodBeat.o(274063);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(274076);
    super.onDestroy();
    Log.i("MicroMsg.ScreenCastForegroundService", "Service onDestroy");
    AppMethodBeat.o(274076);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(274070);
    s.u(paramIntent, "intent");
    Log.i("MicroMsg.ScreenCastForegroundService", "Service onStartCommand() is called");
    if (!h.baC().aZN())
    {
      Log.e("MicroMsg.ScreenCastForegroundService", "error called foreground service in startNotification process");
      stopSelf();
      AppMethodBeat.o(274070);
      return 2;
    }
    if (!h.baC().aZN())
    {
      Log.e("MicroMsg.ScreenCastForegroundService", "error called screen cast foreground service in setNotification process");
      stopSelf();
      AppMethodBeat.o(274070);
      return 2;
    }
    Object localObject = new Intent((Context)this, ScreenCastActivity.class);
    ((Intent)localObject).setFlags(603979776);
    String str = getResources().getString(b.g.wMm);
    s.s(str, "resources.getString(R.st…creen_notification_title)");
    localObject = c.a((Intent)localObject, str, "", "");
    ((com.tencent.mm.plugin.notification.b.b)h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().a(47, (Notification)localObject, false);
    localObject = PluginCast.wLM;
    localObject = PluginCast.a.dpb();
    if (localObject != null) {
      ((a)localObject).wMO = ((Intent)paramIntent.getParcelableExtra("data"));
    }
    localObject = PluginCast.wLM;
    localObject = PluginCast.a.dpb();
    if (localObject != null) {
      ((a)localObject).resultCode = paramIntent.getIntExtra("code", -1);
    }
    paramIntent = PluginCast.wLM;
    paramIntent = PluginCast.a.dpb();
    if (paramIntent != null) {
      paramIntent.fS((Context)this);
    }
    AppMethodBeat.o(274070);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.service.ScreenCastForegroundService
 * JD-Core Version:    0.7.0.1
 */