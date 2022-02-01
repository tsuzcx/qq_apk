package com.tencent.mm.plugin.lite;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.logic.b.a;
import com.tencent.mm.plugin.lite.logic.b.b;
import com.tencent.mm.plugin.lite.logic.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/lite/WxaLiteAppTaskPreloadReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "preloadLogin", "liteAppInfo", "Lcom/tencent/mm/plugin/lite/storage/LiteAppInfo;", "Companion", "plugin-luggage-wechat-impl_release"})
public final class WxaLiteAppTaskPreloadReceiver
  extends BroadcastReceiver
{
  public static final a uYr;
  
  static
  {
    AppMethodBeat.i(217233);
    uYr = new a((byte)0);
    AppMethodBeat.o(217233);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(217232);
    if (paramIntent == null)
    {
      ad.e("MicroMsg.WxaLiteAppTaskPreloadReceiver", "onReceive NULL intent.");
      AppMethodBeat.o(217232);
      return;
    }
    String str;
    if ((paramIntent.hasExtra("task")) && (paramIntent.hasExtra("appId")) && (p.i(paramIntent.getStringExtra("task"), "prelogin")))
    {
      str = paramIntent.getStringExtra("appId");
      c.dfF();
      paramContext = c.aoy(str);
      if (paramContext != null) {
        break label136;
      }
      ad.w("MicroMsg.WxaLiteAppTaskPreloadReceiver", str + " is not existed");
    }
    for (;;)
    {
      if ((paramIntent.hasExtra("task")) && (p.i(paramIntent.getStringExtra("task"), "updateBaseLibPath"))) {
        LiteAppCenter.setPath(paramIntent.getStringExtra("path"));
      }
      AppMethodBeat.o(217232);
      return;
      label136:
      p.h(paramContext, "liteAppInfo");
      str = LiteAppCenter.getAuthUrl(paramContext.field_pkgPath, paramContext.field_appId, paramContext.field_signatureKey);
      com.tencent.mm.plugin.lite.logic.b.uYI.a(str, (b.b)new b(paramContext));
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/lite/WxaLiteAppTaskPreloadReceiver$Companion;", "", "()V", "TAG", "", "kAppIdKey", "kPathKey", "kPreLoginTask", "kTaskKey", "kUpdateBaseLibPathTask", "plugin-luggage-wechat-impl_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/lite/WxaLiteAppTaskPreloadReceiver$preloadLogin$1", "Lcom/tencent/mm/plugin/lite/logic/LiteAppGetA8Key$LiteAppGetA8KeyCallback;", "onError", "", "onSuccess", "info", "Lcom/tencent/mm/plugin/lite/logic/LiteAppGetA8Key$AuthInfo;", "Lcom/tencent/mm/plugin/lite/logic/LiteAppGetA8Key;", "plugin-luggage-wechat-impl_release"})
  public static final class b
    implements b.b
  {
    b(com.tencent.mm.plugin.lite.d.b paramb) {}
    
    public final void a(b.a parama)
    {
      AppMethodBeat.i(217231);
      p.h(parama, "info");
      ad.i("MicroMsg.WxaLiteAppTaskPreloadReceiver", "geta8key success:" + this.uYs.field_appId);
      LiteAppCenter.setAuthInfo(this.uYs.field_appId, parama.uYN, parama.mHeaders, parama.uYO);
      AppMethodBeat.o(217231);
    }
    
    public final void onError()
    {
      AppMethodBeat.i(217230);
      ad.w("MicroMsg.WxaLiteAppTaskPreloadReceiver", "geta8key fail: " + this.uYs.field_appId);
      AppMethodBeat.o(217230);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.WxaLiteAppTaskPreloadReceiver
 * JD-Core Version:    0.7.0.1
 */