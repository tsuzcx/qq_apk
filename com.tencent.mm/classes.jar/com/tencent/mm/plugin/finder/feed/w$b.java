package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.ui.MMActivity;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "getInitRequest", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "loadMoreData", "", "requestRefresh", "plugin-finder_release"})
public final class w$b
  extends r.a
{
  public w$b(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(165848);
    AppMethodBeat.o(165848);
  }
  
  public final void aQh()
  {
    AppMethodBeat.i(165847);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rgh;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(165847);
      return;
    }
    AppMethodBeat.o(165847);
  }
  
  public final g cup()
  {
    AppMethodBeat.i(165845);
    g localg = (g)new w.d((f)new w.b.a());
    AppMethodBeat.o(165845);
    return localg;
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(165846);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rgh;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(165846);
      return;
    }
    AppMethodBeat.o(165846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.w.b
 * JD-Core Version:    0.7.0.1
 */