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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"})
public final class y$a
  extends b.a
{
  public y$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(202007);
    AppMethodBeat.o(202007);
  }
  
  public final void aTt()
  {
    AppMethodBeat.i(202004);
    this.rTS.requestLoadMore();
    AppMethodBeat.o(202004);
  }
  
  public final void cAA()
  {
    AppMethodBeat.i(202003);
    b.b localb = this.rTQ;
    if (localb != null)
    {
      localb.U((ArrayList)this.rTS.getDataListJustForAdapter());
      AppMethodBeat.o(202003);
      return;
    }
    AppMethodBeat.o(202003);
  }
  
  public final c cAE()
  {
    AppMethodBeat.i(202006);
    Object localObject = this.rTQ;
    if (localObject != null) {}
    for (localObject = ((b.b)localObject).cAR();; localObject = null)
    {
      if (localObject == null) {
        p.gfZ();
      }
      localObject = ((z)localObject).cBj();
      AppMethodBeat.o(202006);
      return localObject;
    }
  }
  
  public final void cAO()
  {
    AppMethodBeat.i(202005);
    BaseFeedLoader.requestInit$default(this.rTS, false, 1, null);
    AppMethodBeat.o(202005);
  }
  
  public final void requestRefresh() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.y.a
 * JD-Core Version:    0.7.0.1
 */