package com.tencent.mm.live.core.mini;

import android.annotation.TargetApi;
import android.app.Notification;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/mini/LiveMiniNotificationHelper;", "", "()V", "TAG", "", "isBindForegroundService", "", "bindForegroundServiceIfNeed", "", "title", "content", "tickerContent", "activityName", "createNotification", "Landroid/app/Notification;", "intent", "Landroid/content/Intent;", "getAPI15NotificationFromBuilder", "builder", "Landroid/support/v4/app/NotificationCompat$Builder;", "getAPI16NotificationFromBuilder", "getNotificationFromBuilder", "hideNotification", "showNotification", "unBindForegroundServiceIfNeed", "plugin-core_release"})
public final class b
{
  public static final b gNf;
  
  static
  {
    AppMethodBeat.i(196929);
    gNf = new b();
    AppMethodBeat.o(196929);
  }
  
  public static void amz()
  {
    AppMethodBeat.i(196928);
    com.tencent.mm.kernel.b.a locala = g.ad(com.tencent.mm.plugin.notification.b.a.class);
    p.g(locala, "MMKernel.plugin(IPluginNotification::class.java)");
    ((com.tencent.mm.plugin.notification.b.a)locala).getNotification().cancel(46);
    AppMethodBeat.o(196928);
  }
  
  @TargetApi(16)
  static Notification c(s.c paramc)
  {
    AppMethodBeat.i(196926);
    paramc = paramc.build();
    p.g(paramc, "builder.build()");
    AppMethodBeat.o(196926);
    return paramc;
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(196925);
    p.h(paramString1, "title");
    p.h(paramString2, "content");
    p.h(paramString3, "tickerContent");
    p.h(paramString4, "activityName");
    AppMethodBeat.o(196925);
  }
  
  static Notification d(s.c paramc)
  {
    AppMethodBeat.i(196927);
    paramc = paramc.build();
    p.g(paramc, "builder.build()");
    AppMethodBeat.o(196927);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.b
 * JD-Core Version:    0.7.0.1
 */