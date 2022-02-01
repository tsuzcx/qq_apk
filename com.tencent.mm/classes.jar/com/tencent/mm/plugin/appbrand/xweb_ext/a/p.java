package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.p.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/WeEffectWorkaroundManagerFactory;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$IFactory;", "()V", "create", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  implements p.b
{
  public static final p uUC;
  
  static
  {
    AppMethodBeat.i(317077);
    uUC = new p();
    AppMethodBeat.o(317077);
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.p aun()
  {
    AppMethodBeat.i(317084);
    Object localObject = n.uUy;
    localObject = n.cTE();
    s.s(localObject, "INSTANCE.create()");
    localObject = (com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.p)new o((com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o)localObject);
    AppMethodBeat.o(317084);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.p
 * JD-Core Version:    0.7.0.1
 */