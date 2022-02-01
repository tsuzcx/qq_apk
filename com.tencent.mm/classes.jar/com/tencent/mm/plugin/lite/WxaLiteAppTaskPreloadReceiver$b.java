package com.tencent.mm.plugin.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.d.e;
import com.tencent.mm.plugin.lite.logic.b.a;
import com.tencent.mm.plugin.lite.logic.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/lite/WxaLiteAppTaskPreloadReceiver$preloadLogin$1", "Lcom/tencent/mm/plugin/lite/logic/LiteAppGetA8Key$LiteAppGetA8KeyCallback;", "onError", "", "onSuccess", "info", "Lcom/tencent/mm/plugin/lite/logic/LiteAppGetA8Key$AuthInfo;", "Lcom/tencent/mm/plugin/lite/logic/LiteAppGetA8Key;", "plugin-luggage-wechat-impl_release"})
public final class WxaLiteAppTaskPreloadReceiver$b
  implements b.b
{
  WxaLiteAppTaskPreloadReceiver$b(e parame) {}
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(217877);
    p.h(parama, "info");
    ae.i("MicroMsg.WxaLiteAppTaskPreloadReceiver", "geta8key success:" + this.vkg.field_appId);
    LiteAppCenter.setAuthInfo(this.vkg.field_appId, parama.vkD, parama.mHeaders, parama.vkE);
    AppMethodBeat.o(217877);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(217876);
    ae.w("MicroMsg.WxaLiteAppTaskPreloadReceiver", "geta8key fail: " + this.vkg.field_appId);
    AppMethodBeat.o(217876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.WxaLiteAppTaskPreloadReceiver.b
 * JD-Core Version:    0.7.0.1
 */