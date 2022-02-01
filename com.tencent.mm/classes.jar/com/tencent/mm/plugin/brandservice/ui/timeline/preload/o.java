package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.q;
import d.l;
import d.l.k;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "PROPTYPE", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Resettable;", "manager", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", "init", "Lkotlin/Function0;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;Lkotlin/jvm/functions/Function0;)V", "getInit", "()Lkotlin/jvm/functions/Function0;", "lazyHolder", "Lkotlin/Lazy;", "getLazyHolder", "()Lkotlin/Lazy;", "setLazyHolder", "(Lkotlin/Lazy;)V", "getManager", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", "getValue", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "makeInitBlock", "reset", "", "plugin-brandservice_release"})
public final class o<PROPTYPE>
  implements n
{
  private volatile f<? extends PROPTYPE> opO;
  final p opP;
  final a<PROPTYPE> opQ;
  
  public o(p paramp, a<? extends PROPTYPE> parama)
  {
    AppMethodBeat.i(6730);
    this.opP = paramp;
    this.opQ = parama;
    this.opO = bQE();
    AppMethodBeat.o(6730);
  }
  
  private f<PROPTYPE> bQE()
  {
    AppMethodBeat.i(6729);
    f localf = g.O((a)new a(this));
    AppMethodBeat.o(6729);
    return localf;
  }
  
  public final PROPTYPE a(k<?> paramk)
  {
    AppMethodBeat.i(6727);
    d.g.b.p.h(paramk, "property");
    paramk = this.opO.getValue();
    AppMethodBeat.o(6727);
    return paramk;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(6728);
    this.opO = bQE();
    AppMethodBeat.o(6728);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "PROPTYPE", "invoke", "()Ljava/lang/Object;"})
  static final class a
    extends q
    implements a<PROPTYPE>
  {
    a(o paramo)
    {
      super();
    }
    
    public final PROPTYPE invoke()
    {
      AppMethodBeat.i(6726);
      p localp = this.opR.opP;
      n localn = (n)this.opR;
      d.g.b.p.h(localn, "managed");
      synchronized (localp.opS)
      {
        localp.opS.add(localn);
        ??? = this.opR.opQ.invoke();
        AppMethodBeat.o(6726);
        return ???;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.o
 * JD-Core Version:    0.7.0.1
 */