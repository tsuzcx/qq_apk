package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "requestRefresh", "plugin-finder_release"})
public final class s$a
  extends c.a
{
  public s$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(265759);
    AppMethodBeat.o(265759);
  }
  
  public final void byN()
  {
    AppMethodBeat.i(265756);
    this.xnX.requestLoadMore();
    AppMethodBeat.o(265756);
  }
  
  public final void dsF() {}
  
  public final void dsr()
  {
    AppMethodBeat.i(265754);
    c.b localb = this.xvU;
    if (localb != null)
    {
      localb.ab((ArrayList)this.xnX.getDataListJustForAdapter());
      AppMethodBeat.o(265754);
      return;
    }
    AppMethodBeat.o(265754);
  }
  
  public final f dsu()
  {
    AppMethodBeat.i(265757);
    Object localObject = this.xvU;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).dsI();; localObject = null)
    {
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((ak)localObject).dtg();
      AppMethodBeat.o(265757);
      return localObject;
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(265755);
    this.xnX.requestRefresh();
    AppMethodBeat.o(265755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.s.a
 * JD-Core Version:    0.7.0.1
 */