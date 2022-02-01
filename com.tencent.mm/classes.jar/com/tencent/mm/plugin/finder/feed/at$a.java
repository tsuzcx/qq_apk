package com.tencent.mm.plugin.finder.feed;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "requestRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at$a
  extends c.a
{
  public at$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, 0, paramBaseFinderFeedLoader);
    AppMethodBeat.i(363057);
    AppMethodBeat.o(363057);
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(363080);
    BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)this.ALH, false, 1, null);
    AppMethodBeat.o(363080);
  }
  
  public final g dUK()
  {
    AppMethodBeat.i(363096);
    Object localObject = this.ATE;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((c.b)localObject).dUN())
    {
      s.checkNotNull(localObject);
      localObject = ((as)localObject).ech();
      AppMethodBeat.o(363096);
      return localObject;
    }
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(363088);
    BaseFeedLoader.requestInit$default((BaseFeedLoader)this.ALH, false, 1, null);
    AppMethodBeat.o(363088);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(363065);
    Object localObject = this.ATE;
    if (localObject != null) {
      ((c.b)localObject).ae((ArrayList)this.ALH.getDataListJustForAdapter());
    }
    localObject = this.ATE;
    if (localObject != null)
    {
      localObject = ((c.b)localObject).ATx;
      if (localObject != null)
      {
        localObject = (TextView)((RefreshLoadMoreLayout)localObject).findViewById(e.e.load_more_footer_tip_tv);
        if (localObject != null) {
          ((TextView)localObject).setTextColor(this.lzt.getResources().getColor(e.b.BW_100_Alpha_0_3));
        }
      }
    }
    AppMethodBeat.o(363065);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(363071);
    this.ALH.requestRefresh();
    AppMethodBeat.o(363071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.at.a
 * JD-Core Version:    0.7.0.1
 */