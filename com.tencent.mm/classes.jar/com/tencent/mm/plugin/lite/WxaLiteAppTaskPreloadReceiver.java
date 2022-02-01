package com.tencent.mm.plugin.lite;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.logic.b.a;
import com.tencent.mm.plugin.lite.logic.b.b;
import com.tencent.mm.plugin.lite.logic.c;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/lite/WxaLiteAppTaskPreloadReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "preloadLogin", "liteAppInfo", "Lcom/tencent/mm/plugin/lite/storage/LiteAppInfo;", "Companion", "plugin-luggage-wechat-impl_release"})
public final class WxaLiteAppTaskPreloadReceiver
  extends BroadcastReceiver
{
  public static final a tVP;
  
  static
  {
    AppMethodBeat.i(205649);
    tVP = new a((byte)0);
    AppMethodBeat.o(205649);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(205648);
    if (paramIntent == null)
    {
      ac.e("MicroMsg.WxaLiteAppTaskPreloadReceiver", "onReceive NULL intent.");
      AppMethodBeat.o(205648);
      return;
    }
    String str;
    if ((paramIntent.hasExtra("task")) && (paramIntent.hasExtra("appId")) && (k.g(paramIntent.getStringExtra("task"), "prelogin")))
    {
      str = paramIntent.getStringExtra("appId");
      c.cWu();
      paramContext = c.ajL(str);
      if (paramContext != null) {
        break label136;
      }
      ac.w("MicroMsg.WxaLiteAppTaskPreloadReceiver", str + " is not existed");
    }
    for (;;)
    {
      if ((paramIntent.hasExtra("task")) && (k.g(paramIntent.getStringExtra("task"), "updateBaseLibPath"))) {
        LiteAppCenter.setPath(paramIntent.getStringExtra("path"));
      }
      AppMethodBeat.o(205648);
      return;
      label136:
      k.h(paramContext, "liteAppInfo");
      str = LiteAppCenter.getAuthUrl(paramContext.field_pkgPath, paramContext.field_appId, paramContext.field_signatureKey);
      com.tencent.mm.plugin.lite.logic.b.tVZ.a(str, (b.b)new b(paramContext));
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/lite/WxaLiteAppTaskPreloadReceiver$Companion;", "", "()V", "TAG", "", "kAppIdKey", "kPathKey", "kPreLoginTask", "kTaskKey", "kUpdateBaseLibPathTask", "plugin-luggage-wechat-impl_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/lite/WxaLiteAppTaskPreloadReceiver$preloadLogin$1", "Lcom/tencent/mm/plugin/lite/logic/LiteAppGetA8Key$LiteAppGetA8KeyCallback;", "onError", "", "onSuccess", "info", "Lcom/tencent/mm/plugin/lite/logic/LiteAppGetA8Key$AuthInfo;", "Lcom/tencent/mm/plugin/lite/logic/LiteAppGetA8Key;", "plugin-luggage-wechat-impl_release"})
  public static final class b
    implements b.b
  {
    b(com.tencent.mm.plugin.lite.d.b paramb) {}
    
    public final void onError()
    {
      AppMethodBeat.i(205646);
      ac.w("MicroMsg.WxaLiteAppTaskPreloadReceiver", "geta8key fail: " + this.tVQ.field_appId);
      AppMethodBeat.o(205646);
    }
    
    public final void onSuccess(b.a parama)
    {
      AppMethodBeat.i(205647);
      k.h(parama, "info");
      ac.i("MicroMsg.WxaLiteAppTaskPreloadReceiver", "geta8key success:" + this.tVQ.field_appId);
      LiteAppCenter.setAuthInfo(this.tVQ.field_appId, parama.tWe, parama.mHeaders, parama.tWf);
      AppMethodBeat.o(205647);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.WxaLiteAppTaskPreloadReceiver
 * JD-Core Version:    0.7.0.1
 */