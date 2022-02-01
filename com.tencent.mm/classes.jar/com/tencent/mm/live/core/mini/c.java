package com.tencent.mm.live.core.mini;

import android.annotation.TargetApi;
import android.app.Notification;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/mini/LiveMiniNotificationHelper;", "", "()V", "TAG", "", "isBindForegroundService", "", "bindForegroundServiceIfNeed", "", "title", "content", "tickerContent", "activityName", "createNotification", "Landroid/app/Notification;", "intent", "Landroid/content/Intent;", "getAPI15NotificationFromBuilder", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "getAPI16NotificationFromBuilder", "getNotificationFromBuilder", "hideNotification", "showNotification", "unBindForegroundServiceIfNeed", "plugin-core_release"})
public final class c
{
  public static final c kqX;
  
  static
  {
    AppMethodBeat.i(200594);
    kqX = new c();
    AppMethodBeat.o(200594);
  }
  
  public static void aMr()
  {
    AppMethodBeat.i(200591);
    com.tencent.mm.kernel.b.a locala = h.ag(com.tencent.mm.plugin.notification.b.a.class);
    p.j(locala, "MMKernel.plugin(IPluginNotification::class.java)");
    ((com.tencent.mm.plugin.notification.b.a)locala).getNotification().cancel(46);
    AppMethodBeat.o(200591);
  }
  
  @TargetApi(16)
  static Notification c(e.d paramd)
  {
    AppMethodBeat.i(200586);
    paramd = paramd.gr();
    p.j(paramd, "builder.build()");
    AppMethodBeat.o(200586);
    return paramd;
  }
  
  static Notification d(e.d paramd)
  {
    AppMethodBeat.i(200589);
    paramd = paramd.gr();
    p.j(paramd, "builder.build()");
    AppMethodBeat.o(200589);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.c
 * JD-Core Version:    0.7.0.1
 */