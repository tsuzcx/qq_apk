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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
public final class s$b
  extends v.b
{
  public s$b(MMActivity paramMMActivity, s.a parama, int paramInt)
  {
    super(paramMMActivity, (v.a)parama, paramInt, 16);
    AppMethodBeat.i(243922);
    AppMethodBeat.o(243922);
  }
  
  public final void aa(ArrayList<bo> paramArrayList)
  {
    AppMethodBeat.i(243921);
    p.h(paramArrayList, "data");
    super.aa(paramArrayList);
    if (dck())
    {
      paramArrayList = this.tLS;
      localView = aa.jQ((Context)this.gte).inflate(2131495035, null);
      p.g(localView, "MMLayoutInflater.getInfl…b_load_more_footer, null)");
      paramArrayList.setLoadMoreFooter(localView);
      AppMethodBeat.o(243921);
      return;
    }
    paramArrayList = this.tLS;
    View localView = aa.jQ((Context)this.gte).inflate(2131495297, null);
    p.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramArrayList.setLoadMoreFooter(localView);
    AppMethodBeat.o(243921);
  }
  
  public final View getEmptyView()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.s.b
 * JD-Core Version:    0.7.0.1
 */