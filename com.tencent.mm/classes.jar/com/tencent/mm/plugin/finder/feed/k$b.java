package com.tencent.mm.plugin.finder.feed;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;IIZ)V", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "onLoadInitDataError", "", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k$b
  extends b.b
{
  public k$b(MMActivity paramMMActivity, k.a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramMMActivity, (b.a)parama, paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.i(165720);
    AppMethodBeat.o(165720);
  }
  
  public final void ebi()
  {
    AppMethodBeat.i(165718);
    this.ATx.setEnableLoadMore(false);
    RecyclerView.a locala = this.ATx.getRecyclerView().getAdapter();
    if (locala != null) {
      locala.getItemCount();
    }
    AppMethodBeat.o(165718);
  }
  
  public final View getEmptyView()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.k.b
 * JD-Core Version:    0.7.0.1
 */