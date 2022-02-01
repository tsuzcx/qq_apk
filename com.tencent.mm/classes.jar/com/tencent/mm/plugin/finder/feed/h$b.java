package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.ui.MMActivity;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "getInitRequest", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "loadMoreData", "", "requestRefresh", "plugin-finder_release"})
public final class h$b
  extends e.a
{
  public h$b(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(165848);
    AppMethodBeat.o(165848);
  }
  
  public final void aJq()
  {
    AppMethodBeat.i(165847);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.qvo;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(165847);
      return;
    }
    AppMethodBeat.o(165847);
  }
  
  public final h clZ()
  {
    AppMethodBeat.i(165845);
    h localh = (h)new h.d((g)new h.b.a());
    AppMethodBeat.o(165845);
    return localh;
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(165846);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.qvo;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(165846);
      return;
    }
    AppMethodBeat.o(165846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.h.b
 * JD-Core Version:    0.7.0.1
 */