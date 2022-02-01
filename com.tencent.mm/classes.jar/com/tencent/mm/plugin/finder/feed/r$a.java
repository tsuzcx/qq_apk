package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "requestRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r$a
  extends c.a
{
  public r$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, 0, paramBaseFinderFeedLoader);
    AppMethodBeat.i(362590);
    AppMethodBeat.o(362590);
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(362612);
    BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)this.ALH, false, 1, null);
    AppMethodBeat.o(362612);
  }
  
  public final g dUK()
  {
    AppMethodBeat.i(362627);
    Object localObject = this.ATE;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((c.b)localObject).dUN())
    {
      s.checkNotNull(localObject);
      localObject = ((as)localObject).ech();
      AppMethodBeat.o(362627);
      return localObject;
    }
  }
  
  public final void dUL() {}
  
  public final void dUM()
  {
    AppMethodBeat.i(362598);
    c.b localb = this.ATE;
    if (localb != null) {
      localb.ae((ArrayList)this.ALH.getDataListJustForAdapter());
    }
    AppMethodBeat.o(362598);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(362604);
    this.ALH.requestRefresh();
    AppMethodBeat.o(362604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.r.a
 * JD-Core Version:    0.7.0.1
 */