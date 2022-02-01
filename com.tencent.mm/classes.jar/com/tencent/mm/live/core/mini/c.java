package com.tencent.mm.live.core.mini;

import android.annotation.TargetApi;
import android.app.Notification;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/mini/LiveMiniNotificationHelper;", "", "()V", "TAG", "", "isBindForegroundService", "", "bindForegroundServiceIfNeed", "", "title", "content", "tickerContent", "activityName", "createNotification", "Landroid/app/Notification;", "intent", "Landroid/content/Intent;", "getAPI15NotificationFromBuilder", "builder", "Landroid/support/v4/app/NotificationCompat$Builder;", "getAPI16NotificationFromBuilder", "getNotificationFromBuilder", "hideNotification", "showNotification", "unBindForegroundServiceIfNeed", "plugin-core_release"})
public final class c
{
  public static final c hCU;
  
  static
  {
    AppMethodBeat.i(196592);
    hCU = new c();
    AppMethodBeat.o(196592);
  }
  
  public static void aEk()
  {
    AppMethodBeat.i(196591);
    com.tencent.mm.kernel.b.a locala = g.ah(com.tencent.mm.plugin.notification.b.a.class);
    p.g(locala, "MMKernel.plugin(IPluginNotification::class.java)");
    ((com.tencent.mm.plugin.notification.b.a)locala).getNotification().cancel(46);
    AppMethodBeat.o(196591);
  }
  
  @TargetApi(16)
  static Notification c(s.c paramc)
  {
    AppMethodBeat.i(196589);
    paramc = paramc.build();
    p.g(paramc, "builder.build()");
    AppMethodBeat.o(196589);
    return paramc;
  }
  
  static Notification d(s.c paramc)
  {
    AppMethodBeat.i(196590);
    paramc = paramc.build();
    p.g(paramc, "builder.build()");
    AppMethodBeat.o(196590);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.c
 * JD-Core Version:    0.7.0.1
 */