package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g;
import d.g.a.a;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "PROPTYPE", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Resettable;", "manager", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", "init", "Lkotlin/Function0;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;Lkotlin/jvm/functions/Function0;)V", "getInit", "()Lkotlin/jvm/functions/Function0;", "lazyHolder", "Lkotlin/Lazy;", "getLazyHolder", "()Lkotlin/Lazy;", "setLazyHolder", "(Lkotlin/Lazy;)V", "getManager", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", "getValue", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "makeInitBlock", "reset", "", "plugin-brandservice_release"})
public final class n<PROPTYPE>
  implements m
{
  private volatile f<? extends PROPTYPE> neA;
  final o neB;
  final a<PROPTYPE> neC;
  
  public n(o paramo, a<? extends PROPTYPE> parama)
  {
    AppMethodBeat.i(6730);
    this.neB = paramo;
    this.neC = parama;
    this.neA = bDS();
    AppMethodBeat.o(6730);
  }
  
  private f<PROPTYPE> bDS()
  {
    AppMethodBeat.i(6729);
    f localf = g.E((a)new a(this));
    AppMethodBeat.o(6729);
    return localf;
  }
  
  public final PROPTYPE a(d.l.k<?> paramk)
  {
    AppMethodBeat.i(6727);
    d.g.b.k.h(paramk, "property");
    paramk = this.neA.getValue();
    AppMethodBeat.o(6727);
    return paramk;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(6728);
    this.neA = bDS();
    AppMethodBeat.o(6728);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "PROPTYPE", "invoke", "()Ljava/lang/Object;"})
  static final class a
    extends d.g.b.l
    implements a<PROPTYPE>
  {
    a(n paramn)
    {
      super();
    }
    
    public final PROPTYPE invoke()
    {
      AppMethodBeat.i(6726);
      o localo = this.neD.neB;
      m localm = (m)this.neD;
      d.g.b.k.h(localm, "managed");
      synchronized (localo.neE)
      {
        localo.neE.add(localm);
        ??? = this.neD.neC.invoke();
        AppMethodBeat.o(6726);
        return ???;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.n
 * JD-Core Version:    0.7.0.1
 */