package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/MakeupApplyLogic;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyLogic;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;)V", "applyMakeup", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$MakeupType;", "path", "", "luggage-xweb-ext_release"})
public final class q
  implements f
{
  private final m cHw;
  
  public q(m paramm)
  {
    AppMethodBeat.i(222212);
    this.cHw = paramm;
    AppMethodBeat.o(222212);
  }
  
  public final void a(m.b paramb, String paramString)
  {
    AppMethodBeat.i(222209);
    p.k(paramb, "type");
    p.k(paramString, "path");
    Log.d("MicroMsg.AppBrand.IWeEffectWorkaroundManager", "applyMakeup, type: " + paramb + ", path: " + paramString);
    this.cHw.a(paramb, paramString);
    AppMethodBeat.o(222209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.q
 * JD-Core Version:    0.7.0.1
 */