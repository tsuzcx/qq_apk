package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/MakeupApplyLogic;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyLogic;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;)V", "applyMakeup", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$MakeupType;", "path", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  implements g
{
  private final o eAU;
  
  public s(o paramo)
  {
    AppMethodBeat.i(220832);
    this.eAU = paramo;
    AppMethodBeat.o(220832);
  }
  
  public final void a(o.b paramb, String paramString)
  {
    AppMethodBeat.i(220843);
    kotlin.g.b.s.u(paramb, "type");
    kotlin.g.b.s.u(paramString, "path");
    Log.d("MicroMsg.AppBrand.IWeEffectWorkaroundManager", "applyMakeup, type: " + paramb + ", path: " + paramString);
    this.eAU.a(paramb, paramString);
    AppMethodBeat.o(220843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.s
 * JD-Core Version:    0.7.0.1
 */