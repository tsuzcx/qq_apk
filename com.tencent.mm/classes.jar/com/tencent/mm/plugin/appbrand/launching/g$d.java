package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.y;
import java.util.HashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$TaskMapApiBase;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "()V", "map", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "Lkotlin/collections/HashMap;", "get", "key", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
final class g$d
  implements g.a
{
  private final HashMap<o, g.b> csJ;
  
  public g$d()
  {
    AppMethodBeat.i(50740);
    this.csJ = new HashMap();
    AppMethodBeat.o(50740);
  }
  
  public final g.b F(o paramo)
  {
    AppMethodBeat.i(50738);
    k.h(paramo, "key");
    synchronized (this.csJ)
    {
      paramo = this.csJ.get(paramo);
      if (paramo == null) {
        k.fOy();
      }
      paramo = (g.b)paramo;
      k.g(paramo, "synchronized(map) { map[key]!! }");
      AppMethodBeat.o(50738);
      return paramo;
    }
  }
  
  public final g.b G(o paramo)
  {
    AppMethodBeat.i(50739);
    k.h(paramo, "key");
    synchronized (this.csJ)
    {
      paramo = (g.b)this.csJ.remove(paramo);
      AppMethodBeat.o(50739);
      return paramo;
    }
  }
  
  public final void a(o paramo, a<g.b> parama)
  {
    AppMethodBeat.i(50737);
    k.h(paramo, "key");
    k.h(parama, "function");
    synchronized (this.csJ)
    {
      if ((g.b)this.csJ.get(paramo) == null) {
        ((Map)this.csJ).put(paramo, parama.invoke());
      }
      paramo = y.KTp;
      AppMethodBeat.o(50737);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.g.d
 * JD-Core Version:    0.7.0.1
 */