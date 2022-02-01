package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "requestRefresh", "plugin-finder_release"})
public final class n$a
  extends b.a
{
  public n$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(202296);
    AppMethodBeat.o(202296);
  }
  
  public final void aTS()
  {
    AppMethodBeat.i(202294);
    this.scw.requestLoadMore();
    AppMethodBeat.o(202294);
  }
  
  public final void cCA() {}
  
  public final void cCm()
  {
    AppMethodBeat.i(202292);
    b.b localb = this.scu;
    if (localb != null)
    {
      localb.U((ArrayList)this.scw.getDataListJustForAdapter());
      AppMethodBeat.o(202292);
      return;
    }
    AppMethodBeat.o(202292);
  }
  
  public final c cCq()
  {
    AppMethodBeat.i(202295);
    Object localObject = this.scu;
    if (localObject != null) {}
    for (localObject = ((b.b)localObject).cCD();; localObject = null)
    {
      if (localObject == null) {
        p.gkB();
      }
      localObject = ((z)localObject).cCV();
      AppMethodBeat.o(202295);
      return localObject;
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(202293);
    this.scw.requestRefresh();
    AppMethodBeat.o(202293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.n.a
 * JD-Core Version:    0.7.0.1
 */