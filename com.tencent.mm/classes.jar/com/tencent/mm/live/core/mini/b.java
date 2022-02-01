package com.tencent.mm.live.core.mini;

import android.annotation.TargetApi;
import android.app.Notification;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/mini/LiveMiniNotificationHelper;", "", "()V", "TAG", "", "isBindForegroundService", "", "bindForegroundServiceIfNeed", "", "title", "content", "tickerContent", "activityName", "createNotification", "Landroid/app/Notification;", "intent", "Landroid/content/Intent;", "getAPI15NotificationFromBuilder", "builder", "Landroid/support/v4/app/NotificationCompat$Builder;", "getAPI16NotificationFromBuilder", "getNotificationFromBuilder", "hideNotification", "showNotification", "unBindForegroundServiceIfNeed", "plugin-core_release"})
public final class b
{
  public static final b gKw;
  
  static
  {
    AppMethodBeat.i(216917);
    gKw = new b();
    AppMethodBeat.o(216917);
  }
  
  public static void amk()
  {
    AppMethodBeat.i(216916);
    com.tencent.mm.kernel.b.a locala = g.ad(com.tencent.mm.plugin.notification.b.a.class);
    p.g(locala, "MMKernel.plugin(IPluginNotification::class.java)");
    ((com.tencent.mm.plugin.notification.b.a)locala).getNotification().cancel(46);
    AppMethodBeat.o(216916);
  }
  
  @TargetApi(16)
  static Notification c(s.c paramc)
  {
    AppMethodBeat.i(216914);
    paramc = paramc.build();
    p.g(paramc, "builder.build()");
    AppMethodBeat.o(216914);
    return paramc;
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(216913);
    p.h(paramString1, "title");
    p.h(paramString2, "content");
    p.h(paramString3, "tickerContent");
    p.h(paramString4, "activityName");
    AppMethodBeat.o(216913);
  }
  
  static Notification d(s.c paramc)
  {
    AppMethodBeat.i(216915);
    paramc = paramc.build();
    p.g(paramc, "builder.build()");
    AppMethodBeat.o(216915);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.b
 * JD-Core Version:    0.7.0.1
 */