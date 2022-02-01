package com.tencent.mm.plugin.finder.feed;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "requestRefresh", "plugin-finder_release"})
public final class am$a
  extends c.a
{
  public am$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(288136);
    AppMethodBeat.o(288136);
  }
  
  public final void byN()
  {
    AppMethodBeat.i(288133);
    this.xnX.requestLoadMore();
    AppMethodBeat.o(288133);
  }
  
  public final void dsF()
  {
    AppMethodBeat.i(288134);
    BaseFeedLoader.requestInit$default(this.xnX, false, 1, null);
    AppMethodBeat.o(288134);
  }
  
  public final void dsr()
  {
    AppMethodBeat.i(288131);
    Object localObject = this.xvU;
    if (localObject != null) {
      ((c.b)localObject).ab((ArrayList)this.xnX.getDataListJustForAdapter());
    }
    localObject = this.xvU;
    if (localObject != null)
    {
      localObject = ((c.b)localObject).xvJ;
      if (localObject != null)
      {
        localObject = (TextView)((RefreshLoadMoreLayout)localObject).findViewById(b.f.load_more_footer_tip_tv);
        if (localObject != null)
        {
          ((TextView)localObject).setTextColor(this.iXq.getResources().getColor(b.c.BW_100_Alpha_0_3));
          AppMethodBeat.o(288131);
          return;
        }
      }
    }
    AppMethodBeat.o(288131);
  }
  
  public final f dsu()
  {
    AppMethodBeat.i(288135);
    Object localObject = this.xvU;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).dsI();; localObject = null)
    {
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((ak)localObject).dtg();
      AppMethodBeat.o(288135);
      return localObject;
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(288132);
    this.xnX.requestRefresh();
    AppMethodBeat.o(288132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.am.a
 * JD-Core Version:    0.7.0.1
 */