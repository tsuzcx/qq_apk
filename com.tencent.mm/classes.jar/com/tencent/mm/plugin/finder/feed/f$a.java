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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "cacheId", "", "getCacheId", "()J", "setCacheId", "(J)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"})
public final class f$a
  extends b.a
{
  public f$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(202218);
    AppMethodBeat.o(202218);
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(202214);
    p.h(paramb, "callback");
    super.a(paramb);
    AppMethodBeat.o(202214);
  }
  
  public final void aTS()
  {
    AppMethodBeat.i(202212);
    this.scw.requestLoadMore();
    AppMethodBeat.o(202212);
  }
  
  public final void cCA()
  {
    AppMethodBeat.i(202213);
    BaseFeedLoader.requestInit$default(this.scw, false, 1, null);
    AppMethodBeat.o(202213);
  }
  
  public final void cCm()
  {
    AppMethodBeat.i(202210);
    b.b localb = this.scu;
    if (localb != null)
    {
      localb.U((ArrayList)this.scw.getDataListJustForAdapter());
      AppMethodBeat.o(202210);
      return;
    }
    AppMethodBeat.o(202210);
  }
  
  public final c cCq()
  {
    AppMethodBeat.i(202216);
    Object localObject = this.scu;
    if (localObject != null) {}
    for (localObject = ((b.b)localObject).cCD();; localObject = null)
    {
      if (localObject == null) {
        p.gkB();
      }
      localObject = ((z)localObject).cCV();
      AppMethodBeat.o(202216);
      return localObject;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(202217);
    super.onDetach();
    AppMethodBeat.o(202217);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(202211);
    this.scw.requestRefresh();
    AppMethodBeat.o(202211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.f.a
 * JD-Core Version:    0.7.0.1
 */