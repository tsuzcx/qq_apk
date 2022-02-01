package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"})
public final class y$a
  extends b.a
{
  public y$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(202471);
    AppMethodBeat.o(202471);
  }
  
  public final void aTS()
  {
    AppMethodBeat.i(202468);
    this.scw.requestLoadMore();
    AppMethodBeat.o(202468);
  }
  
  public final void cCA()
  {
    AppMethodBeat.i(202469);
    BaseFeedLoader.requestInit$default(this.scw, false, 1, null);
    AppMethodBeat.o(202469);
  }
  
  public final void cCm()
  {
    AppMethodBeat.i(202467);
    b.b localb = this.scu;
    if (localb != null)
    {
      localb.U((ArrayList)this.scw.getDataListJustForAdapter());
      AppMethodBeat.o(202467);
      return;
    }
    AppMethodBeat.o(202467);
  }
  
  public final c cCq()
  {
    AppMethodBeat.i(202470);
    Object localObject = this.scu;
    if (localObject != null) {}
    for (localObject = ((b.b)localObject).cCD();; localObject = null)
    {
      if (localObject == null) {
        p.gkB();
      }
      localObject = ((z)localObject).cCV();
      AppMethodBeat.o(202470);
      return localObject;
    }
  }
  
  public final void requestRefresh() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.y.a
 * JD-Core Version:    0.7.0.1
 */