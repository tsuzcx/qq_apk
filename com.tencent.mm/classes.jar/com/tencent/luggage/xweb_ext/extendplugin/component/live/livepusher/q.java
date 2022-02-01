package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerApplyLogic;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyLogic;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;)V", "applySticker", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "path", "", "luggage-xweb-ext_release"})
public final class q
  implements j
{
  private final l cGQ;
  
  public q(l paraml)
  {
    AppMethodBeat.i(215969);
    this.cGQ = paraml;
    AppMethodBeat.o(215969);
  }
  
  public final void a(l.c paramc, String paramString)
  {
    AppMethodBeat.i(215968);
    p.h(paramc, "type");
    p.h(paramString, "path");
    Log.d("MicroMsg.AppBrand.IWeEffectWorkaroundManager", "applySticker, type: " + paramc + ", path: " + paramString);
    this.cGQ.a(paramc, paramString);
    AppMethodBeat.o(215968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.q
 * JD-Core Version:    0.7.0.1
 */