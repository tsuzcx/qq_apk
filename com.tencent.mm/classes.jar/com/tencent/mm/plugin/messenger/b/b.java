package com.tencent.mm.plugin.messenger.b;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.media.RingtoneManager;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.messenger.b.d;
import com.tencent.mm.plugin.messenger.b.e;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.z;
import com.tencent.threadpool.i;
import com.tencent.tmassistantsdk.util.Base64;
import java.util.Map;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/messenger/extdevice/PushLoginUrlAutoLoginNewXmlReceived;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "()V", "TAG", "", "lastNotifyExeFuture", "Ljava/util/concurrent/Future;", "onNewXmlReceived", "", "subType", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "showNotify", "deviceId", "wording", "iconType", "", "plugin-messenger_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements t
{
  public static final b KQi;
  private static Future<?> KQj;
  
  static
  {
    AppMethodBeat.i(288568);
    KQi = new b();
    AppMethodBeat.o(288568);
  }
  
  private static final void aLg(String paramString)
  {
    AppMethodBeat.i(288564);
    kotlin.g.b.s.u(paramString, "$content");
    Object localObject = new Intent(MMApplicationContext.getContext(), Class.forName("com.tencent.mm.ui.LauncherUI"));
    ((Intent)localObject).addFlags(268435456).addFlags(67108864);
    localObject = PendingIntent.getActivity(MMApplicationContext.getContext(), 36, (Intent)localObject, 1073741824);
    f.d locald = com.tencent.mm.bq.a.cA(MMApplicationContext.getContext(), com.tencent.mm.bq.a.iGq()).o(null).bt(System.currentTimeMillis());
    locald.bor = ((PendingIntent)localObject);
    paramString = locald.l((CharSequence)MMApplicationContext.getContext().getString(b.e.app_name)).m((CharSequence)paramString).DA();
    kotlin.g.b.s.s(paramString, "getNotificationBuilder(M…tentText(content).build()");
    paramString.icon = com.tencent.mm.bq.a.guX();
    paramString.flags |= 0x10;
    paramString.sound = RingtoneManager.getDefaultUri(2);
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.notification.b.a.class)).e(paramString);
    AppMethodBeat.o(288564);
  }
  
  private static final void aq(String paramString1, String paramString2, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(288555);
    kotlin.g.b.s.s(paramString1, "deviceId");
    kotlin.g.b.s.s(paramString2, "wording");
    paramString1 = com.tencent.mm.kernel.h.baD();
    if (paramString1 == null) {
      paramString1 = null;
    }
    for (;;)
    {
      Log.i("MicroMsg.PushLoginUrlAutoLoginNewXmlReceived", kotlin.g.b.s.X("showNotify isForeground:", paramString1));
      paramString1 = d.UTF_8;
      if (paramString2 != null) {
        break;
      }
      paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(288555);
      throw paramString1;
      paramString1 = paramString1.mCm;
      if (paramString1 == null) {
        paramString1 = null;
      } else {
        paramString1 = Boolean.valueOf(paramString1.foreground);
      }
    }
    paramString1 = paramString2.getBytes(paramString1);
    kotlin.g.b.s.s(paramString1, "(this as java.lang.String).getBytes(charset)");
    paramString1 = Base64.decode(paramString1, 2);
    kotlin.g.b.s.s(paramString1, "decode(wording.toByteArray(), Base64.NO_WRAP)");
    paramString1 = new String(paramString1, d.UTF_8);
    paramString2 = com.tencent.mm.kernel.h.baD();
    if (paramString2 != null)
    {
      paramString2 = paramString2.mCm;
      if ((paramString2 != null) && (paramString2.foreground == true))
      {
        if (i == 0) {
          break label310;
        }
        switch (paramInt)
        {
        case 4: 
        case 5: 
        case 9: 
        default: 
          paramInt = b.d.icons_outlined_display;
        }
      }
    }
    for (;;)
    {
      paramString2 = MMApplicationContext.getContext().getDrawable(paramInt);
      if (paramString2 != null) {
        paramString2.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      z.a(paramString2, (CharSequence)paramString1, MMApplicationContext.getContext(), 0, null);
      AppMethodBeat.o(288555);
      return;
      i = 0;
      break;
      paramInt = b.d.icons_outlined_display;
      continue;
      paramInt = b.d.icons_outlined_imac;
      continue;
      paramInt = b.d.icons_outlined_pad;
      continue;
      paramInt = b.d.connect_kidwatch;
      continue;
      paramInt = b.d.connect_car;
      continue;
      paramInt = b.d.icons_outlined_android_pad;
      continue;
      paramInt = b.d.icons_outlined_folder;
    }
    label310:
    com.tencent.threadpool.h.ahAA.bm(new b..ExternalSyntheticLambda0(paramString1));
    AppMethodBeat.o(288555);
  }
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(288589);
    if ((kotlin.g.b.s.p("PushLoginUrlAutoLogin", paramString)) && (paramMap != null))
    {
      paramString = Util.nullAsNil((String)paramMap.get(".sysmsg.PushLoginUrlAutoLogin.deviceid"));
      parama = Util.nullAsNil((String)paramMap.get(".sysmsg.PushLoginUrlAutoLogin.wording"));
      int i = Util.safeParseInt((String)paramMap.get(".sysmsg.PushLoginUrlAutoLogin.icontype"));
      Log.i("MicroMsg.PushLoginUrlAutoLoginNewXmlReceived", "receive xml, deviceid:" + paramString + ", wording:" + parama + ", iconType:" + i);
      paramMap = KQj;
      if (paramMap != null) {
        paramMap.cancel(true);
      }
      KQj = (Future)com.tencent.threadpool.h.ahAA.o(new b..ExternalSyntheticLambda1(paramString, parama, i), 1000L);
    }
    AppMethodBeat.o(288589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.b
 * JD-Core Version:    0.7.0.1
 */