package com.tencent.mm.plugin.cast.h;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/utils/CastUtil;", "", "()V", "createNotification", "Landroid/app/Notification;", "intent", "Landroid/content/Intent;", "title", "", "content", "tickerContent", "getAPI15NotificationFromBuilder", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "getAPI16NotificationFromBuilder", "getNotificationFromBuilder", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c wOl;
  
  static
  {
    AppMethodBeat.i(274211);
    wOl = new c();
    AppMethodBeat.o(274211);
  }
  
  public static final Notification a(Intent paramIntent, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(274200);
    s.u(paramIntent, "intent");
    s.u(paramString1, "title");
    s.u(paramString2, "content");
    s.u(paramString3, "tickerContent");
    paramIntent = PendingIntent.getActivity(MMApplicationContext.getContext(), 47, paramIntent, 134217728);
    paramString1 = a.cA(MMApplicationContext.getContext(), "reminder_channel_id").o((CharSequence)paramString3).bt(System.currentTimeMillis()).l((CharSequence)paramString1);
    paramString1.bor = paramIntent;
    paramIntent = paramString1.eb(a.guX());
    paramIntent.q(2, true);
    s.s(paramIntent, "getNotificationBuilder(M…        .setOngoing(true)");
    d.rc(16);
    paramIntent = paramIntent.DA();
    s.s(paramIntent, "builder.build()");
    AppMethodBeat.o(274200);
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.h.c
 * JD-Core Version:    0.7.0.1
 */