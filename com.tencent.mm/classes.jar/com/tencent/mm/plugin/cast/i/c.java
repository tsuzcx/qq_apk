package com.tencent.mm.plugin.cast.i;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/utils/CastUtil;", "", "()V", "createNotification", "Landroid/app/Notification;", "intent", "Landroid/content/Intent;", "title", "", "content", "tickerContent", "getAPI15NotificationFromBuilder", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "getAPI16NotificationFromBuilder", "getNotificationFromBuilder", "plugin-cast_release"})
public final class c
{
  public static final c tKW;
  
  static
  {
    AppMethodBeat.i(189482);
    tKW = new c();
    AppMethodBeat.o(189482);
  }
  
  public static final Notification a(Intent paramIntent, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(189476);
    p.k(paramIntent, "intent");
    p.k(paramString1, "title");
    p.k(paramString2, "content");
    p.k(paramString3, "tickerContent");
    paramIntent = PendingIntent.getActivity(MMApplicationContext.getContext(), 47, paramIntent, 134217728);
    paramIntent = a.cp(MMApplicationContext.getContext(), "reminder_channel_id").n((CharSequence)paramString3).e(System.currentTimeMillis()).k((CharSequence)paramString1).a(paramIntent).bn(a.fkG()).gp();
    p.j(paramIntent, "NotificationHelper.getNo…        .setOngoing(true)");
    d.qW(16);
    paramIntent = paramIntent.gr();
    p.j(paramIntent, "builder.build()");
    AppMethodBeat.o(189476);
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.i.c
 * JD-Core Version:    0.7.0.1
 */