package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFloatBallDetailContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFloatBallDetailContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFloatBallDetailContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p$b
  extends ae.b
{
  public p$b(MMActivity paramMMActivity, p.a parama)
  {
    super(paramMMActivity, (ae.a)parama, 2, 113);
    AppMethodBeat.i(362714);
    AppMethodBeat.o(362714);
  }
  
  public final void af(ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(362720);
    s.u(paramArrayList, "data");
    super.af(paramArrayList);
    paramArrayList = this.ATx;
    View localView = af.mU((Context)this.lzt).inflate(e.f.load_more_footer_dark, null);
    s.s(localView, "getInflater(context).inf…d_more_footer_dark, null)");
    paramArrayList.setLoadMoreFooter(localView);
    paramArrayList = this.ATx.getRecyclerView().getLayoutManager();
    if (paramArrayList == null)
    {
      paramArrayList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
      AppMethodBeat.o(362720);
      throw paramArrayList;
    }
    ((FinderLinearLayoutManager)paramArrayList).GHU = false;
    AppMethodBeat.o(362720);
  }
  
  public final View getEmptyView()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.p.b
 * JD-Core Version:    0.7.0.1
 */