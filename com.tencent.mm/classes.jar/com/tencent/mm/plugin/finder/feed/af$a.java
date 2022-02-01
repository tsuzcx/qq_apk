package com.tencent.mm.plugin.finder.feed;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "requestRefresh", "plugin-finder_release"})
public final class af$a
  extends c.a
{
  public af$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(244159);
    AppMethodBeat.o(244159);
  }
  
  public final void boE()
  {
    AppMethodBeat.i(244156);
    this.tFM.requestLoadMore();
    AppMethodBeat.o(244156);
  }
  
  public final void dcb()
  {
    AppMethodBeat.i(244154);
    Object localObject = this.tMd;
    if (localObject != null) {
      ((c.b)localObject).ab((ArrayList)this.tFM.getDataListJustForAdapter());
    }
    localObject = this.tMd;
    if (localObject != null)
    {
      localObject = ((c.b)localObject).tLS;
      if (localObject != null)
      {
        localObject = (TextView)((RefreshLoadMoreLayout)localObject).findViewById(2131303685);
        if (localObject != null)
        {
          ((TextView)localObject).setTextColor(this.gte.getResources().getColor(2131099676));
          AppMethodBeat.o(244154);
          return;
        }
      }
    }
    AppMethodBeat.o(244154);
  }
  
  public final f dce()
  {
    AppMethodBeat.i(244158);
    Object localObject = this.tMd;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).dcs();; localObject = null)
    {
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((al)localObject).dcK();
      AppMethodBeat.o(244158);
      return localObject;
    }
  }
  
  public final void dcp()
  {
    AppMethodBeat.i(244157);
    BaseFeedLoader.requestInit$default(this.tFM, false, 1, null);
    AppMethodBeat.o(244157);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(244155);
    this.tFM.requestRefresh();
    AppMethodBeat.o(244155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.af.a
 * JD-Core Version:    0.7.0.1
 */