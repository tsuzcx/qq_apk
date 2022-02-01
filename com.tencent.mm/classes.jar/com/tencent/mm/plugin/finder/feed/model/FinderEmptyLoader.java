package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.al;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderEmptyLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "()V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public final class FinderEmptyLoader
  extends BaseFinderFeedLoader
{
  public FinderEmptyLoader()
  {
    super(null);
  }
  
  public final g<al> createDataFetch()
  {
    AppMethodBeat.i(202329);
    g localg = (g)new a();
    AppMethodBeat.o(202329);
    return localg;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/model/FinderEmptyLoader$createDataFetch$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "fetchInit", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchLoadMore", "fetchRefresh", "plugin-finder_release"})
  public static final class a
    extends g<al>
  {
    public final void fetchInit(f<al> paramf)
    {
      AppMethodBeat.i(202326);
      p.h(paramf, "callback");
      AppMethodBeat.o(202326);
    }
    
    public final void fetchLoadMore(f<al> paramf)
    {
      AppMethodBeat.i(202328);
      p.h(paramf, "callback");
      AppMethodBeat.o(202328);
    }
    
    public final void fetchRefresh(f<al> paramf)
    {
      AppMethodBeat.i(202327);
      p.h(paramf, "callback");
      AppMethodBeat.o(202327);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderEmptyLoader
 * JD-Core Version:    0.7.0.1
 */