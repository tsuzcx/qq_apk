package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/WeEffectWorkaroundManagerFactory;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$IFactory;", "()V", "create", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "plugin-appbrand-integration_release"})
public final class q
  implements n.b
{
  public static final q rJm;
  
  static
  {
    AppMethodBeat.i(275638);
    rJm = new q();
    AppMethodBeat.o(275638);
  }
  
  public final n TI()
  {
    AppMethodBeat.i(275636);
    Object localObject = o.rJi;
    localObject = o.cqX();
    kotlin.g.b.p.j(localObject, "WeEffectManagerFactory.INSTANCE.create()");
    localObject = (n)new p((m)localObject);
    AppMethodBeat.o(275636);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.q
 * JD-Core Version:    0.7.0.1
 */