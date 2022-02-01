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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderPoiTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiTimelineUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderPoiTimelineUIContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "getLoadMoreFooter", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
public final class af$b
  extends aa.b
{
  public af$b(MMActivity paramMMActivity, af.a parama, int paramInt)
  {
    super(paramMMActivity, (aa.a)parama, paramInt, 96);
    AppMethodBeat.i(287375);
    AppMethodBeat.o(287375);
  }
  
  public final void aa(ArrayList<bu> paramArrayList)
  {
    AppMethodBeat.i(287374);
    p.k(paramArrayList, "data");
    super.aa(paramArrayList);
    paramArrayList = this.xvJ;
    View localView = ad.kS((Context)this.iXq).inflate(b.g.load_more_footer, null);
    p.j(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramArrayList.setLoadMoreFooter(localView);
    AppMethodBeat.o(287374);
  }
  
  public final View getEmptyView()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.af.b
 * JD-Core Version:    0.7.0.1
 */