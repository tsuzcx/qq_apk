package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o;
import d.g.a.a;
import d.g.b.k;
import d.l;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$TaskMapApi24;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "get", "key", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
final class g$c
  implements g.a
{
  private final ConcurrentHashMap<o, g.b> cfp;
  
  public g$c()
  {
    AppMethodBeat.i(50736);
    this.cfp = new ConcurrentHashMap();
    AppMethodBeat.o(50736);
  }
  
  public final g.b F(o paramo)
  {
    AppMethodBeat.i(50734);
    k.h(paramo, "key");
    paramo = this.cfp.get(paramo);
    if (paramo == null) {
      k.fOy();
    }
    k.g(paramo, "map[key]!!");
    paramo = (g.b)paramo;
    AppMethodBeat.o(50734);
    return paramo;
  }
  
  public final g.b G(o paramo)
  {
    AppMethodBeat.i(50735);
    k.h(paramo, "key");
    paramo = (g.b)this.cfp.remove(paramo);
    AppMethodBeat.o(50735);
    return paramo;
  }
  
  public final void a(o paramo, a<g.b> parama)
  {
    AppMethodBeat.i(50733);
    k.h(paramo, "key");
    k.h(parama, "function");
    this.cfp.computeIfAbsent(paramo, (Function)new a(parama));
    AppMethodBeat.o(50733);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "it", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "apply"})
  static final class a<T, R>
    implements Function<o, g.b>
  {
    a(a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.g.c
 * JD-Core Version:    0.7.0.1
 */