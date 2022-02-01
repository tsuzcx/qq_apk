package com.tencent.mm.plugin.finder.view.builder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "lastState", "", "getLastState", "()I", "setLastState", "(I)V", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "plugin-finder_release"})
public final class b$c
  extends RecyclerView.m
{
  private int rdt;
  
  b$c(Context paramContext) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204334);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bb(paramRecyclerView);
    localb.lS(paramInt1);
    localb.lS(paramInt2);
    a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
    super.a(paramRecyclerView, paramInt1, paramInt2);
    a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(204334);
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(178494);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bb(paramRecyclerView);
    localb.lS(paramInt);
    a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
    k.h(paramRecyclerView, "recyclerView");
    super.b(paramRecyclerView, paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.rdt = paramInt;
      a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(178494);
      return;
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(178494);
        throw paramRecyclerView;
      }
      paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
      this.saF.qZO.DF(paramRecyclerView.jY());
      continue;
      if (this.rdt != 3)
      {
        paramRecyclerView = this.cgl;
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(178494);
          throw paramRecyclerView;
        }
        ((MMActivity)paramRecyclerView).hideVKB();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.builder.b.c
 * JD-Core Version:    0.7.0.1
 */