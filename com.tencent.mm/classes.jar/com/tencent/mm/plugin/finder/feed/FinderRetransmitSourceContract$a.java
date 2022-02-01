package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.ui.MMActivity;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "loadMoreData", "", "requestRefresh", "plugin-finder_release"})
public final class FinderRetransmitSourceContract$a
  extends v.a
{
  public FinderRetransmitSourceContract$a(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(165848);
    AppMethodBeat.o(165848);
  }
  
  public final void boE()
  {
    AppMethodBeat.i(165847);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(165847);
      return;
    }
    AppMethodBeat.o(165847);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(165846);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(165846);
      return;
    }
    AppMethodBeat.o(165846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract.a
 * JD-Core Version:    0.7.0.1
 */