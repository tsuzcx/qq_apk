package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "cacheId", "", "getCacheId", "()J", "setCacheId", "(J)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"})
public final class g$a
  extends c.a
{
  public g$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(243763);
    AppMethodBeat.o(243763);
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(243759);
    p.h(paramb, "callback");
    super.a(paramb);
    AppMethodBeat.o(243759);
  }
  
  public final void boE()
  {
    AppMethodBeat.i(243757);
    this.tFM.requestLoadMore();
    AppMethodBeat.o(243757);
  }
  
  public final void dcb()
  {
    AppMethodBeat.i(243755);
    c.b localb = this.tMd;
    if (localb != null)
    {
      localb.ab((ArrayList)this.tFM.getDataListJustForAdapter());
      AppMethodBeat.o(243755);
      return;
    }
    AppMethodBeat.o(243755);
  }
  
  public final f dce()
  {
    AppMethodBeat.i(243761);
    Object localObject = this.tMd;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).dcs();; localObject = null)
    {
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((al)localObject).dcK();
      AppMethodBeat.o(243761);
      return localObject;
    }
  }
  
  public final void dcp()
  {
    AppMethodBeat.i(243758);
    BaseFeedLoader.requestInit$default(this.tFM, false, 1, null);
    AppMethodBeat.o(243758);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(243762);
    super.onDetach();
    AppMethodBeat.o(243762);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(243756);
    this.tFM.requestRefresh();
    AppMethodBeat.o(243756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.g.a
 * JD-Core Version:    0.7.0.1
 */