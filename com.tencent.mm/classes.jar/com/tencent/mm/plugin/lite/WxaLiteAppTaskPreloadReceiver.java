package com.tencent.mm.plugin.lite;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.d.e;
import com.tencent.mm.plugin.lite.logic.b;
import com.tencent.mm.plugin.lite.logic.b.b;
import com.tencent.mm.plugin.lite.logic.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/lite/WxaLiteAppTaskPreloadReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "preloadLogin", "liteAppInfo", "Lcom/tencent/mm/plugin/lite/storage/LiteAppInfo;", "Companion", "plugin-luggage-wechat-impl_release"})
public final class WxaLiteAppTaskPreloadReceiver
  extends BroadcastReceiver
{
  public static final WxaLiteAppTaskPreloadReceiver.a vkf;
  
  static
  {
    AppMethodBeat.i(217879);
    vkf = new WxaLiteAppTaskPreloadReceiver.a((byte)0);
    AppMethodBeat.o(217879);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(217878);
    if (paramIntent == null)
    {
      ae.e("MicroMsg.WxaLiteAppTaskPreloadReceiver", "onReceive NULL intent.");
      AppMethodBeat.o(217878);
      return;
    }
    String str;
    if ((paramIntent.hasExtra("task")) && (paramIntent.hasExtra("appId")) && (p.i(paramIntent.getStringExtra("task"), "prelogin")))
    {
      str = paramIntent.getStringExtra("appId");
      c.diz();
      paramContext = c.apC(str);
      if (paramContext != null) {
        break label141;
      }
      ae.w("MicroMsg.WxaLiteAppTaskPreloadReceiver", str + " is not existed");
    }
    for (;;)
    {
      if ((paramIntent.hasExtra("task")) && (p.i(paramIntent.getStringExtra("task"), "updateBaseLibPath")))
      {
        ae.i("MicroMsg.WxaLiteAppTaskPreloadReceiver", "receive set baselib path");
        paramContext = d.vjW;
        d.a.diu();
      }
      AppMethodBeat.o(217878);
      return;
      label141:
      p.h(paramContext, "liteAppInfo");
      str = LiteAppCenter.getAuthUrl(paramContext.field_pkgPath, paramContext.field_appId, paramContext.field_signatureKey);
      b.vky.a(str, (b.b)new WxaLiteAppTaskPreloadReceiver.b(paramContext));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.WxaLiteAppTaskPreloadReceiver
 * JD-Core Version:    0.7.0.1
 */