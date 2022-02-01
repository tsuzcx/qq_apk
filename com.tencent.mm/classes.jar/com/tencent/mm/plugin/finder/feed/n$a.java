package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "requestRefresh", "plugin-finder_release"})
public final class n$a
  extends b.a
{
  public n$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(201836);
    AppMethodBeat.o(201836);
  }
  
  public final void aTt()
  {
    AppMethodBeat.i(201834);
    this.rTS.requestLoadMore();
    AppMethodBeat.o(201834);
  }
  
  public final void cAA()
  {
    AppMethodBeat.i(201832);
    b.b localb = this.rTQ;
    if (localb != null)
    {
      localb.U((ArrayList)this.rTS.getDataListJustForAdapter());
      AppMethodBeat.o(201832);
      return;
    }
    AppMethodBeat.o(201832);
  }
  
  public final c cAE()
  {
    AppMethodBeat.i(201835);
    Object localObject = this.rTQ;
    if (localObject != null) {}
    for (localObject = ((b.b)localObject).cAR();; localObject = null)
    {
      if (localObject == null) {
        p.gfZ();
      }
      localObject = ((z)localObject).cBj();
      AppMethodBeat.o(201835);
      return localObject;
    }
  }
  
  public final void cAO() {}
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(201833);
    this.rTS.requestRefresh();
    AppMethodBeat.o(201833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.n.a
 * JD-Core Version:    0.7.0.1
 */