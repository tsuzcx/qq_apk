package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerApplyLogic;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyLogic;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;)V", "applySticker", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "path", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  implements k
{
  private final o eAU;
  
  public t(o paramo)
  {
    AppMethodBeat.i(220844);
    this.eAU = paramo;
    AppMethodBeat.o(220844);
  }
  
  public final void a(o.c paramc, String paramString)
  {
    AppMethodBeat.i(220853);
    s.u(paramc, "type");
    s.u(paramString, "path");
    Log.d("MicroMsg.AppBrand.IWeEffectWorkaroundManager", "applySticker, type: " + paramc + ", path: " + paramString);
    this.eAU.a(paramc, paramString);
    AppMethodBeat.o(220853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.t
 * JD-Core Version:    0.7.0.1
 */