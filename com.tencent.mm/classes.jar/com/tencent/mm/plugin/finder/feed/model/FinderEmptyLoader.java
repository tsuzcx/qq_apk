package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.am;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderEmptyLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "()V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public final class FinderEmptyLoader
  extends BaseFinderFeedLoader
{
  public FinderEmptyLoader()
  {
    super(null);
  }
  
  public final g<am> createDataFetch()
  {
    AppMethodBeat.i(202795);
    g localg = (g)new a();
    AppMethodBeat.o(202795);
    return localg;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/model/FinderEmptyLoader$createDataFetch$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "fetchInit", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchLoadMore", "fetchRefresh", "plugin-finder_release"})
  public static final class a
    extends g<am>
  {
    public final void fetchInit(f<am> paramf)
    {
      AppMethodBeat.i(202792);
      p.h(paramf, "callback");
      AppMethodBeat.o(202792);
    }
    
    public final void fetchLoadMore(f<am> paramf)
    {
      AppMethodBeat.i(202794);
      p.h(paramf, "callback");
      AppMethodBeat.o(202794);
    }
    
    public final void fetchRefresh(f<am> paramf)
    {
      AppMethodBeat.i(202793);
      p.h(paramf, "callback");
      AppMethodBeat.o(202793);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderEmptyLoader
 * JD-Core Version:    0.7.0.1
 */