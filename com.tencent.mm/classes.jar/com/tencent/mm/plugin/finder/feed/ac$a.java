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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"})
public final class ac$a
  extends c.a
{
  public ac$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(244095);
    AppMethodBeat.o(244095);
  }
  
  public final void boE()
  {
    AppMethodBeat.i(244092);
    this.tFM.requestLoadMore();
    AppMethodBeat.o(244092);
  }
  
  public final void dcb()
  {
    AppMethodBeat.i(244091);
    c.b localb = this.tMd;
    if (localb != null)
    {
      localb.ab((ArrayList)this.tFM.getDataListJustForAdapter());
      AppMethodBeat.o(244091);
      return;
    }
    AppMethodBeat.o(244091);
  }
  
  public final f dce()
  {
    AppMethodBeat.i(244094);
    Object localObject = this.tMd;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).dcs();; localObject = null)
    {
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((al)localObject).dcK();
      AppMethodBeat.o(244094);
      return localObject;
    }
  }
  
  public final void dcp()
  {
    AppMethodBeat.i(244093);
    BaseFeedLoader.requestInit$default(this.tFM, false, 1, null);
    AppMethodBeat.o(244093);
  }
  
  public final void requestRefresh() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ac.a
 * JD-Core Version:    0.7.0.1
 */