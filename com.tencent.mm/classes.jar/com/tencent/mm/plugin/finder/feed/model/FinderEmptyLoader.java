package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.bo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderEmptyLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "()V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public final class FinderEmptyLoader
  extends BaseFinderFeedLoader
{
  public FinderEmptyLoader()
  {
    super(null);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(244565);
    g localg = (g)new a();
    AppMethodBeat.o(244565);
    return localg;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/FinderEmptyLoader$createDataFetch$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "fetchInit", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchLoadMore", "fetchRefresh", "plugin-finder_release"})
  public static final class a
    extends g<bo>
  {
    public final void fetchInit(f<bo> paramf)
    {
      AppMethodBeat.i(244562);
      p.h(paramf, "callback");
      AppMethodBeat.o(244562);
    }
    
    public final void fetchLoadMore(f<bo> paramf)
    {
      AppMethodBeat.i(244564);
      p.h(paramf, "callback");
      AppMethodBeat.o(244564);
    }
    
    public final void fetchRefresh(f<bo> paramf)
    {
      AppMethodBeat.i(244563);
      p.h(paramf, "callback");
      AppMethodBeat.o(244563);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderEmptyLoader
 * JD-Core Version:    0.7.0.1
 */