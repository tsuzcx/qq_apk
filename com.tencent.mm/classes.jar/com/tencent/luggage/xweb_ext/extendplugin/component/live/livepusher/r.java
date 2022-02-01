package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerApplyLogic;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyLogic;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;)V", "applySticker", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "path", "", "luggage-xweb-ext_release"})
public final class r
  implements j
{
  private final m cHw;
  
  public r(m paramm)
  {
    AppMethodBeat.i(222708);
    this.cHw = paramm;
    AppMethodBeat.o(222708);
  }
  
  public final void a(m.c paramc, String paramString)
  {
    AppMethodBeat.i(222705);
    p.k(paramc, "type");
    p.k(paramString, "path");
    Log.d("MicroMsg.AppBrand.IWeEffectWorkaroundManager", "applySticker, type: " + paramc + ", path: " + paramString);
    this.cHw.a(paramc, paramString);
    AppMethodBeat.o(222705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.r
 * JD-Core Version:    0.7.0.1
 */