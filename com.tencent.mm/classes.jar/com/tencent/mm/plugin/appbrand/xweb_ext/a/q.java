package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/WeEffectWorkaroundManagerFactory;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$IFactory;", "()V", "create", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "plugin-appbrand-integration_release"})
public final class q
  implements m.b
{
  public static final q oHw;
  
  static
  {
    AppMethodBeat.i(229772);
    oHw = new q();
    AppMethodBeat.o(229772);
  }
  
  public final m Qh()
  {
    AppMethodBeat.i(229771);
    Object localObject = o.oHs;
    localObject = o.cdK();
    kotlin.g.b.p.g(localObject, "WeEffectManagerFactory.INSTANCE.create()");
    localObject = (m)new p((com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l)localObject);
    AppMethodBeat.o(229771);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.q
 * JD-Core Version:    0.7.0.1
 */