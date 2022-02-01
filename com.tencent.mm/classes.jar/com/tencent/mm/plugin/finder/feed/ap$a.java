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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ap$a
  extends c.a
{
  public ap$a(MMActivity paramMMActivity, int paramInt, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramInt, paramBaseFinderFeedLoader);
    AppMethodBeat.i(362814);
    AppMethodBeat.o(362814);
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(362835);
    BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)this.ALH, false, 1, null);
    AppMethodBeat.o(362835);
  }
  
  public final g dUK()
  {
    AppMethodBeat.i(362846);
    Object localObject = this.ATE;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((c.b)localObject).dUN())
    {
      s.checkNotNull(localObject);
      localObject = ((as)localObject).ech();
      AppMethodBeat.o(362846);
      return localObject;
    }
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(362841);
    BaseFeedLoader.requestInit$default((BaseFeedLoader)this.ALH, false, 1, null);
    AppMethodBeat.o(362841);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(362823);
    c.b localb = this.ATE;
    if (localb != null) {
      localb.ae((ArrayList)this.ALH.getDataListJustForAdapter());
    }
    AppMethodBeat.o(362823);
  }
  
  public final void requestRefresh() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ap.a
 * JD-Core Version:    0.7.0.1
 */