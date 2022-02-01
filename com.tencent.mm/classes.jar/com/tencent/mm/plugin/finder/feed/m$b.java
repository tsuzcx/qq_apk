package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "getLoadMoreFooter", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
public final class m$b
  extends v.b
{
  public m$b(MMActivity paramMMActivity, m.a parama, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, (v.a)parama, paramInt1, paramInt2);
    AppMethodBeat.i(243834);
    AppMethodBeat.o(243834);
  }
  
  public final void aa(ArrayList<bo> paramArrayList)
  {
    AppMethodBeat.i(243833);
    p.h(paramArrayList, "data");
    super.aa(paramArrayList);
    paramArrayList = this.tLS;
    View localView = aa.jQ((Context)this.gte).inflate(2131495297, null);
    p.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramArrayList.setLoadMoreFooter(localView);
    AppMethodBeat.o(243833);
  }
  
  public final View getEmptyView()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.m.b
 * JD-Core Version:    0.7.0.1
 */