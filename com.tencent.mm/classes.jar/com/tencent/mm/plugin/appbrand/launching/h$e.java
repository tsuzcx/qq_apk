package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.w;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$TaskMapApiBase;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "()V", "map", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "Lkotlin/collections/HashMap;", "get", "key", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class h$e
  implements h.a
{
  private final HashMap<w, h.c> map;
  
  public h$e()
  {
    AppMethodBeat.i(50740);
    this.map = new HashMap();
    AppMethodBeat.o(50740);
  }
  
  public final h.c M(w paramw)
  {
    AppMethodBeat.i(50738);
    s.u(paramw, "key");
    synchronized (this.map)
    {
      paramw = this.map.get(paramw);
      s.checkNotNull(paramw);
      paramw = (h.c)paramw;
      s.s(paramw, "synchronized(map) { map[key]!! }");
      AppMethodBeat.o(50738);
      return paramw;
    }
  }
  
  public final h.c N(w paramw)
  {
    AppMethodBeat.i(50739);
    s.u(paramw, "key");
    synchronized (this.map)
    {
      paramw = (h.c)this.map.remove(paramw);
      AppMethodBeat.o(50739);
      return paramw;
    }
  }
  
  public final void a(w paramw, a<h.c> parama)
  {
    AppMethodBeat.i(50737);
    s.u(paramw, "key");
    s.u(parama, "function");
    synchronized (this.map)
    {
      if ((h.c)this.map.get(paramw) == null) {
        ((Map)this.map).put(paramw, parama.invoke());
      }
      paramw = ah.aiuX;
      AppMethodBeat.o(50737);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.h.e
 * JD-Core Version:    0.7.0.1
 */