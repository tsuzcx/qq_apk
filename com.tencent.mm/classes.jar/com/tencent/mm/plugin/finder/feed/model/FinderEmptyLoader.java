package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bu;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderEmptyLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "()V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public final class FinderEmptyLoader
  extends BaseFinderFeedLoader
{
  public FinderEmptyLoader()
  {
    super(null);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(270746);
    i locali = (i)new a();
    AppMethodBeat.o(270746);
    return locali;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/model/FinderEmptyLoader$createDataFetch$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "fetchInit", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchLoadMore", "fetchRefresh", "plugin-finder_release"})
  public static final class a
    extends i<bu>
  {
    public final void fetchInit(h<bu> paramh)
    {
      AppMethodBeat.i(289758);
      p.k(paramh, "callback");
      AppMethodBeat.o(289758);
    }
    
    public final void fetchLoadMore(h<bu> paramh)
    {
      AppMethodBeat.i(289760);
      p.k(paramh, "callback");
      AppMethodBeat.o(289760);
    }
    
    public final void fetchRefresh(h<bu> paramh)
    {
      AppMethodBeat.i(289759);
      p.k(paramh, "callback");
      AppMethodBeat.o(289759);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderEmptyLoader
 * JD-Core Version:    0.7.0.1
 */