package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f;
import a.f.a.a;
import a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "PROPTYPE", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Resettable;", "manager", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", "init", "Lkotlin/Function0;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;Lkotlin/jvm/functions/Function0;)V", "getInit", "()Lkotlin/jvm/functions/Function0;", "lazyHolder", "Lkotlin/Lazy;", "getLazyHolder", "()Lkotlin/Lazy;", "setLazyHolder", "(Lkotlin/Lazy;)V", "getManager", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", "getValue", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "makeInitBlock", "reset", "", "plugin-brandservice_release"})
public final class k<PROPTYPE>
  implements j
{
  private volatile f<? extends PROPTYPE> kcp;
  final l kcq;
  final a<PROPTYPE> kcr;
  
  public k(l paraml, a<? extends PROPTYPE> parama)
  {
    AppMethodBeat.i(152706);
    this.kcq = paraml;
    this.kcr = parama;
    this.kcp = aXM();
    AppMethodBeat.o(152706);
  }
  
  private f<PROPTYPE> aXM()
  {
    AppMethodBeat.i(152705);
    f localf = g.j((a)new k.a(this));
    AppMethodBeat.o(152705);
    return localf;
  }
  
  public final PROPTYPE a(a.j.k<?> paramk)
  {
    AppMethodBeat.i(152703);
    a.f.b.j.q(paramk, "property");
    paramk = this.kcp.getValue();
    AppMethodBeat.o(152703);
    return paramk;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(152704);
    this.kcp = aXM();
    AppMethodBeat.o(152704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.k
 * JD-Core Version:    0.7.0.1
 */