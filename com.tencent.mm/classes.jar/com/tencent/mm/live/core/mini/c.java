package com.tencent.mm.live.core.mini;

import android.app.Notification;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.notification.b.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/mini/LiveMiniNotificationHelper;", "", "()V", "TAG", "", "isBindForegroundService", "", "bindForegroundServiceIfNeed", "", "title", "content", "tickerContent", "activityName", "createNotification", "Landroid/app/Notification;", "intent", "Landroid/content/Intent;", "getAPI15NotificationFromBuilder", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "getAPI16NotificationFromBuilder", "getNotificationFromBuilder", "hideNotification", "showNotification", "unBindForegroundServiceIfNeed", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c mUS;
  
  static
  {
    AppMethodBeat.i(247638);
    mUS = new c();
    AppMethodBeat.o(247638);
  }
  
  public static void bfT()
  {
    AppMethodBeat.i(247632);
    ((b)h.az(b.class)).getNotification().cancel(46);
    AppMethodBeat.o(247632);
  }
  
  static Notification c(f.d paramd)
  {
    AppMethodBeat.i(247619);
    paramd = paramd.DA();
    s.s(paramd, "builder.build()");
    AppMethodBeat.o(247619);
    return paramd;
  }
  
  static Notification d(f.d paramd)
  {
    AppMethodBeat.i(247627);
    paramd = paramd.DA();
    s.s(paramd, "builder.build()");
    AppMethodBeat.o(247627);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.c
 * JD-Core Version:    0.7.0.1
 */