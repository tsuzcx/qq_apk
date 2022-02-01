package com.tencent.mm.plugin.finder.biz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/biz/FinderBizProfileContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "hasShowjustWatchedIndex", "", "position", "initViewCallback", "", "loadInitData", "loadMoreData", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
  extends c.a
{
  public a$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, 119, paramBaseFinderFeedLoader);
    AppMethodBeat.i(330501);
    AppMethodBeat.o(330501);
  }
  
  public final boolean MW(int paramInt)
  {
    AppMethodBeat.i(330540);
    if ((this.ALH instanceof FinderBizProfileLoader))
    {
      FinderBizProfileLoader localFinderBizProfileLoader = (FinderBizProfileLoader)this.ALH;
      cc localcc = (cc)localFinderBizProfileLoader.getDataList().get(paramInt);
      if (((localcc instanceof BaseFinderFeed)) && (((BaseFinderFeed)localcc).feedObject.getId() == localFinderBizProfileLoader.AxX))
      {
        ((BaseFinderFeed)localcc).markRead = true;
        localFinderBizProfileLoader.Aya = true;
        localFinderBizProfileLoader.AxY = false;
      }
      boolean bool = localFinderBizProfileLoader.Aya;
      AppMethodBeat.o(330540);
      return bool;
    }
    AppMethodBeat.o(330540);
    return true;
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(330509);
    BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)this.ALH, false, 1, null);
    AppMethodBeat.o(330509);
  }
  
  public final g dUK()
  {
    AppMethodBeat.i(330516);
    Object localObject = this.ATE;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((c.b)localObject).dUN())
    {
      s.checkNotNull(localObject);
      localObject = ((as)localObject).ech();
      AppMethodBeat.o(330516);
      return localObject;
    }
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(330521);
    BaseFeedLoader.requestInit$default((BaseFeedLoader)this.ALH, false, 1, null);
    AppMethodBeat.o(330521);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(330529);
    c.b localb = this.ATE;
    if (localb != null) {
      localb.ae((ArrayList)this.ALH.getDataListJustForAdapter());
    }
    AppMethodBeat.o(330529);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(330505);
    this.ALH.requestRefresh();
    AppMethodBeat.o(330505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.biz.a.a
 * JD-Core Version:    0.7.0.1
 */