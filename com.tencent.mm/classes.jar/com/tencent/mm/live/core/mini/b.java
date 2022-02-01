package com.tencent.mm.live.core.mini;

import android.annotation.TargetApi;
import android.app.Notification;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/mini/LiveMiniNotificationHelper;", "", "()V", "TAG", "", "isBindForegroundService", "", "bindForegroundServiceIfNeed", "", "title", "content", "tickerContent", "activityName", "createNotification", "Landroid/app/Notification;", "intent", "Landroid/content/Intent;", "getAPI15NotificationFromBuilder", "builder", "Landroid/support/v4/app/NotificationCompat$Builder;", "getAPI16NotificationFromBuilder", "getNotificationFromBuilder", "hideNotification", "showNotification", "unBindForegroundServiceIfNeed", "plugin-core_release"})
public final class b
{
  public static final b qPc;
  
  static
  {
    AppMethodBeat.i(205723);
    qPc = new b();
    AppMethodBeat.o(205723);
  }
  
  public static void A(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(205719);
    k.h(paramString1, "title");
    k.h(paramString2, "content");
    k.h(paramString3, "tickerContent");
    k.h(paramString4, "activityName");
    AppMethodBeat.o(205719);
  }
  
  public static void csA()
  {
    AppMethodBeat.i(205722);
    com.tencent.mm.kernel.b.a locala = g.ad(com.tencent.mm.plugin.notification.b.a.class);
    k.g(locala, "MMKernel.plugin(IPluginNotification::class.java)");
    ((com.tencent.mm.plugin.notification.b.a)locala).getNotification().cancel(46);
    AppMethodBeat.o(205722);
  }
  
  @TargetApi(16)
  static Notification d(s.c paramc)
  {
    AppMethodBeat.i(205720);
    paramc = paramc.build();
    k.g(paramc, "builder.build()");
    AppMethodBeat.o(205720);
    return paramc;
  }
  
  static Notification e(s.c paramc)
  {
    AppMethodBeat.i(205721);
    paramc = paramc.build();
    k.g(paramc, "builder.build()");
    AppMethodBeat.o(205721);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.b
 * JD-Core Version:    0.7.0.1
 */