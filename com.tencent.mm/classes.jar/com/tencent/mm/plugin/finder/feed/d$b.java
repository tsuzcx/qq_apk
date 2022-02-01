package com.tencent.mm.plugin.finder.feed;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.base.b.a;
import com.tencent.mm.plugin.finder.view.decoration.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;IIZ)V", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "onLoadInitDataError", "", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "plugin-finder_release"})
public final class d$b
  extends a.b
{
  public d$b(MMActivity paramMMActivity, d.a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramMMActivity, (a.a)parama, paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.i(165720);
    AppMethodBeat.o(165720);
  }
  
  public final void clP()
  {
    AppMethodBeat.i(165718);
    RecyclerView.a locala = this.quj.getRecyclerView().getAdapter();
    if (locala != null)
    {
      locala.getItemCount();
      AppMethodBeat.o(165718);
      return;
    }
    AppMethodBeat.o(165718);
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(165719);
    RecyclerView.h localh = (RecyclerView.h)new b((Drawable)new ColorDrawable(b.a.a(this).getColor(2131099648)), 0);
    AppMethodBeat.o(165719);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.d.b
 * JD-Core Version:    0.7.0.1
 */