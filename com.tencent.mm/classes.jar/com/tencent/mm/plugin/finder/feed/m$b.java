package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "getLoadMoreFooter", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m$b
  extends ae.b
{
  public m$b(MMActivity paramMMActivity, m.a parama, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, (ae.a)parama, paramInt1, paramInt2);
    AppMethodBeat.i(363822);
    AppMethodBeat.o(363822);
  }
  
  public final void af(ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(363832);
    s.u(paramArrayList, "data");
    super.af(paramArrayList);
    paramArrayList = this.ATx;
    View localView = af.mU((Context)this.lzt).inflate(e.f.load_more_footer, null);
    s.s(localView, "getInflater(context).inf…t.load_more_footer, null)");
    paramArrayList.setLoadMoreFooter(localView);
    AppMethodBeat.o(363832);
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