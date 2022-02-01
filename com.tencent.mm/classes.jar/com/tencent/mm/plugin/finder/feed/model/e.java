package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderAdCacheManager;", "", "()V", "cacheHelper", "Lcom/tencent/mm/plugin/finder/feed/model/ICacheHelper;", "add", "", "adCache", "Lcom/tencent/mm/plugin/finder/feed/model/internal/AdCache;", "clear", "contains", "", "id", "", "get", "removeCache", "plugin-finder_release"})
public final class e
{
  private final m xFP;
  
  public e()
  {
    AppMethodBeat.i(251015);
    this.xFP = ((m)new p());
    AppMethodBeat.o(251015);
  }
  
  public final a KU(long paramLong)
  {
    AppMethodBeat.i(251009);
    o localo = this.xFP.KZ(paramLong);
    Object localObject = localo;
    if (!(localo instanceof a)) {
      localObject = null;
    }
    localObject = (a)localObject;
    AppMethodBeat.o(251009);
    return localObject;
  }
  
  public final void KV(long paramLong)
  {
    AppMethodBeat.i(251013);
    this.xFP.KV(paramLong);
    AppMethodBeat.o(251013);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(251012);
    kotlin.g.b.p.k(parama, "adCache");
    this.xFP.a((o)parama);
    AppMethodBeat.o(251012);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(251014);
    this.xFP.clearCache();
    AppMethodBeat.o(251014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.e
 * JD-Core Version:    0.7.0.1
 */