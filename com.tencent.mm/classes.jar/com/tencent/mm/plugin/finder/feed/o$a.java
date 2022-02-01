package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "requestRefresh", "plugin-finder_release"})
public final class o$a
  extends c.a
{
  public o$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(243848);
    AppMethodBeat.o(243848);
  }
  
  public final void boE()
  {
    AppMethodBeat.i(243846);
    this.tFM.requestLoadMore();
    AppMethodBeat.o(243846);
  }
  
  public final void dcb()
  {
    AppMethodBeat.i(243844);
    c.b localb = this.tMd;
    if (localb != null)
    {
      localb.ab((ArrayList)this.tFM.getDataListJustForAdapter());
      AppMethodBeat.o(243844);
      return;
    }
    AppMethodBeat.o(243844);
  }
  
  public final f dce()
  {
    AppMethodBeat.i(243847);
    Object localObject = this.tMd;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).dcs();; localObject = null)
    {
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((al)localObject).dcK();
      AppMethodBeat.o(243847);
      return localObject;
    }
  }
  
  public final void dcp() {}
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(243845);
    this.tFM.requestRefresh();
    AppMethodBeat.o(243845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.o.a
 * JD-Core Version:    0.7.0.1
 */