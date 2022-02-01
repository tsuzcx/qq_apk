package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/MakeupApplyLogic;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyLogic;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;)V", "applyMakeup", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$MakeupType;", "path", "", "luggage-xweb-ext_release"})
public final class p
  implements f
{
  private final l cGQ;
  
  public p(l paraml)
  {
    AppMethodBeat.i(215967);
    this.cGQ = paraml;
    AppMethodBeat.o(215967);
  }
  
  public final void a(l.b paramb, String paramString)
  {
    AppMethodBeat.i(215966);
    kotlin.g.b.p.h(paramb, "type");
    kotlin.g.b.p.h(paramString, "path");
    Log.d("MicroMsg.AppBrand.IWeEffectWorkaroundManager", "applyMakeup, type: " + paramb + ", path: " + paramString);
    this.cGQ.a(paramb, paramString);
    AppMethodBeat.o(215966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.p
 * JD-Core Version:    0.7.0.1
 */