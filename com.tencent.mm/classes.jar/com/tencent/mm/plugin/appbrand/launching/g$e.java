package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$TaskMapApiBase;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "()V", "map", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "Lkotlin/collections/HashMap;", "get", "key", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
final class g$e
  implements g.a
{
  private final HashMap<q, g.c> map;
  
  public g$e()
  {
    AppMethodBeat.i(50740);
    this.map = new HashMap();
    AppMethodBeat.o(50740);
  }
  
  public final g.c B(q paramq)
  {
    AppMethodBeat.i(50738);
    p.h(paramq, "key");
    synchronized (this.map)
    {
      paramq = this.map.get(paramq);
      if (paramq == null) {
        p.hyc();
      }
      paramq = (g.c)paramq;
      p.g(paramq, "synchronized(map) { map[key]!! }");
      AppMethodBeat.o(50738);
      return paramq;
    }
  }
  
  public final g.c C(q paramq)
  {
    AppMethodBeat.i(50739);
    p.h(paramq, "key");
    synchronized (this.map)
    {
      paramq = (g.c)this.map.remove(paramq);
      AppMethodBeat.o(50739);
      return paramq;
    }
  }
  
  public final void a(q paramq, a<g.c> parama)
  {
    AppMethodBeat.i(50737);
    p.h(paramq, "key");
    p.h(parama, "function");
    synchronized (this.map)
    {
      if ((g.c)this.map.get(paramq) == null) {
        ((Map)this.map).put(paramq, parama.invoke());
      }
      paramq = x.SXb;
      AppMethodBeat.o(50737);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.g.e
 * JD-Core Version:    0.7.0.1
 */