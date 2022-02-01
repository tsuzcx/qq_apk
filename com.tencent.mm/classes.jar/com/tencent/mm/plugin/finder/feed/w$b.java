package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
public final class w$b
  extends aa.b
{
  public w$b(MMActivity paramMMActivity, w.a parama, int paramInt)
  {
    super(paramMMActivity, (aa.a)parama, paramInt, 16);
    AppMethodBeat.i(285509);
    AppMethodBeat.o(285509);
  }
  
  public final void aa(ArrayList<bu> paramArrayList)
  {
    AppMethodBeat.i(285508);
    p.k(paramArrayList, "data");
    super.aa(paramArrayList);
    if (dsA())
    {
      paramArrayList = this.xvJ;
      localView = ad.kS((Context)this.iXq).inflate(b.g.hot_tab_load_more_footer, null);
      p.j(localView, "MMLayoutInflater.getInfl…b_load_more_footer, null)");
      paramArrayList.setLoadMoreFooter(localView);
      AppMethodBeat.o(285508);
      return;
    }
    paramArrayList = this.xvJ;
    View localView = ad.kS((Context)this.iXq).inflate(b.g.load_more_footer, null);
    p.j(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramArrayList.setLoadMoreFooter(localView);
    AppMethodBeat.o(285508);
  }
  
  public final View getEmptyView()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.w.b
 * JD-Core Version:    0.7.0.1
 */