package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.cc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderEmptyLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "()V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderEmptyLoader
  extends BaseFinderFeedLoader
{
  public FinderEmptyLoader()
  {
    super(null);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(366101);
    i locali = (i)new a();
    AppMethodBeat.o(366101);
    return locali;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/model/FinderEmptyLoader$createDataFetch$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "fetchInit", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchLoadMore", "isAuto", "", "fetchRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends i<cc>
  {
    public final void fetchInit(h<cc> paramh)
    {
      AppMethodBeat.i(365850);
      s.u(paramh, "callback");
      AppMethodBeat.o(365850);
    }
    
    public final void fetchLoadMore(h<cc> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(365861);
      s.u(paramh, "callback");
      AppMethodBeat.o(365861);
    }
    
    public final void fetchRefresh(h<cc> paramh)
    {
      AppMethodBeat.i(365854);
      s.u(paramh, "callback");
      AppMethodBeat.o(365854);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderEmptyLoader
 * JD-Core Version:    0.7.0.1
 */