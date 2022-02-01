package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "requestRefresh", "plugin-finder_release"})
public final class y$a
  extends c.a
{
  public y$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(272999);
    AppMethodBeat.o(272999);
  }
  
  public final void byN()
  {
    AppMethodBeat.i(272996);
    this.xnX.requestLoadMore();
    AppMethodBeat.o(272996);
  }
  
  public final void dsF()
  {
    AppMethodBeat.i(272997);
    this.xnX.requestInit(true);
    AppMethodBeat.o(272997);
  }
  
  public final void dsr()
  {
    AppMethodBeat.i(272994);
    c.b localb = this.xvU;
    if (localb != null)
    {
      localb.ab((ArrayList)this.xnX.getDataListJustForAdapter());
      AppMethodBeat.o(272994);
      return;
    }
    AppMethodBeat.o(272994);
  }
  
  public final f dsu()
  {
    AppMethodBeat.i(272998);
    Object localObject = this.xvU;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).dsI();; localObject = null)
    {
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((ak)localObject).dtg();
      AppMethodBeat.o(272998);
      return localObject;
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(272995);
    this.xnX.requestRefresh();
    AppMethodBeat.o(272995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.y.a
 * JD-Core Version:    0.7.0.1
 */