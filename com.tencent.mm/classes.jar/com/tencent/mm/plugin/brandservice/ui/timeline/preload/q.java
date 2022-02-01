package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.l;
import kotlin.l.k;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "PROPTYPE", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Resettable;", "manager", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", "init", "Lkotlin/Function0;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;Lkotlin/jvm/functions/Function0;)V", "getInit", "()Lkotlin/jvm/functions/Function0;", "lazyHolder", "Lkotlin/Lazy;", "getLazyHolder", "()Lkotlin/Lazy;", "setLazyHolder", "(Lkotlin/Lazy;)V", "getManager", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", "getValue", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "makeInitBlock", "reset", "", "plugin-brandservice_release"})
public final class q<PROPTYPE>
  implements p
{
  private volatile f<? extends PROPTYPE> pDp;
  final r pDq;
  final a<PROPTYPE> pDr;
  
  public q(r paramr, a<? extends PROPTYPE> parama)
  {
    AppMethodBeat.i(6730);
    this.pDq = paramr;
    this.pDr = parama;
    this.pDp = com();
    AppMethodBeat.o(6730);
  }
  
  private f<PROPTYPE> com()
  {
    AppMethodBeat.i(6729);
    f localf = g.ah((a)new a(this));
    AppMethodBeat.o(6729);
    return localf;
  }
  
  public final PROPTYPE a(k<?> paramk)
  {
    AppMethodBeat.i(6727);
    kotlin.g.b.p.h(paramk, "property");
    paramk = this.pDp.getValue();
    AppMethodBeat.o(6727);
    return paramk;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(6728);
    this.pDp = com();
    AppMethodBeat.o(6728);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "PROPTYPE", "invoke", "()Ljava/lang/Object;"})
  static final class a
    extends kotlin.g.b.q
    implements a<PROPTYPE>
  {
    a(q paramq)
    {
      super();
    }
    
    public final PROPTYPE invoke()
    {
      AppMethodBeat.i(6726);
      r localr = this.pDs.pDq;
      p localp = (p)this.pDs;
      kotlin.g.b.p.h(localp, "managed");
      synchronized (localr.pDt)
      {
        localr.pDt.add(localp);
        ??? = this.pDs.pDr.invoke();
        AppMethodBeat.o(6726);
        return ???;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.q
 * JD-Core Version:    0.7.0.1
 */