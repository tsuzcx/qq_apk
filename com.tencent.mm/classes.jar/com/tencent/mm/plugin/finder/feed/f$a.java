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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "cacheId", "", "getCacheId", "()J", "setCacheId", "(J)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"})
public final class f$a
  extends b.a
{
  public f$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(201759);
    AppMethodBeat.o(201759);
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(201755);
    p.h(paramb, "callback");
    super.a(paramb);
    AppMethodBeat.o(201755);
  }
  
  public final void aTt()
  {
    AppMethodBeat.i(201753);
    this.rTS.requestLoadMore();
    AppMethodBeat.o(201753);
  }
  
  public final void cAA()
  {
    AppMethodBeat.i(201751);
    b.b localb = this.rTQ;
    if (localb != null)
    {
      localb.U((ArrayList)this.rTS.getDataListJustForAdapter());
      AppMethodBeat.o(201751);
      return;
    }
    AppMethodBeat.o(201751);
  }
  
  public final c cAE()
  {
    AppMethodBeat.i(201757);
    Object localObject = this.rTQ;
    if (localObject != null) {}
    for (localObject = ((b.b)localObject).cAR();; localObject = null)
    {
      if (localObject == null) {
        p.gfZ();
      }
      localObject = ((z)localObject).cBj();
      AppMethodBeat.o(201757);
      return localObject;
    }
  }
  
  public final void cAO()
  {
    AppMethodBeat.i(201754);
    BaseFeedLoader.requestInit$default(this.rTS, false, 1, null);
    AppMethodBeat.o(201754);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(201758);
    super.onDetach();
    AppMethodBeat.o(201758);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(201752);
    this.rTS.requestRefresh();
    AppMethodBeat.o(201752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.f.a
 * JD-Core Version:    0.7.0.1
 */