package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderAdCacheManager;", "", "()V", "cacheHelper", "Lcom/tencent/mm/plugin/finder/feed/model/ICacheHelper;", "add", "", "adCache", "Lcom/tencent/mm/plugin/finder/feed/model/internal/AdCache;", "clear", "contains", "", "id", "", "get", "removeCache", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private final o BeI;
  
  public e()
  {
    AppMethodBeat.i(365927);
    this.BeI = ((o)new r());
    AppMethodBeat.o(365927);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(365950);
    s.u(parama, "adCache");
    this.BeI.a((q)parama);
    AppMethodBeat.o(365950);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(365963);
    this.BeI.clearCache();
    AppMethodBeat.o(365963);
  }
  
  public final boolean contains(long paramLong)
  {
    AppMethodBeat.i(365934);
    boolean bool = this.BeI.contains(paramLong);
    AppMethodBeat.o(365934);
    return bool;
  }
  
  public final void nA(long paramLong)
  {
    AppMethodBeat.i(365956);
    this.BeI.nA(paramLong);
    AppMethodBeat.o(365956);
  }
  
  public final a nz(long paramLong)
  {
    AppMethodBeat.i(365944);
    Object localObject = this.BeI.nK(paramLong);
    if ((localObject instanceof a))
    {
      localObject = (a)localObject;
      AppMethodBeat.o(365944);
      return localObject;
    }
    AppMethodBeat.o(365944);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.e
 * JD-Core Version:    0.7.0.1
 */