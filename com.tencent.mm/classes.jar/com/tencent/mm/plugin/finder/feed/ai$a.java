package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"})
public final class ai$a
  extends c.a
{
  public ai$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(244550);
    AppMethodBeat.o(244550);
  }
  
  public final void byN()
  {
    AppMethodBeat.i(244543);
    this.xnX.requestLoadMore();
    AppMethodBeat.o(244543);
  }
  
  public final void dsF()
  {
    AppMethodBeat.i(244544);
    BaseFeedLoader.requestInit$default(this.xnX, false, 1, null);
    AppMethodBeat.o(244544);
  }
  
  public final void dsr()
  {
    AppMethodBeat.i(244540);
    c.b localb = this.xvU;
    if (localb != null)
    {
      localb.ab((ArrayList)this.xnX.getDataListJustForAdapter());
      AppMethodBeat.o(244540);
      return;
    }
    AppMethodBeat.o(244540);
  }
  
  public final f dsu()
  {
    AppMethodBeat.i(244547);
    Object localObject = this.xvU;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).dsI();; localObject = null)
    {
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((ak)localObject).dtg();
      AppMethodBeat.o(244547);
      return localObject;
    }
  }
  
  public final void requestRefresh() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ai.a
 * JD-Core Version:    0.7.0.1
 */