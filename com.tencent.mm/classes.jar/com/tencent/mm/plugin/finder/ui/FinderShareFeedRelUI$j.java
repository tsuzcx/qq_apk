package com.tencent.mm.plugin.finder.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$6", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
public final class FinderShareFeedRelUI$j
  extends RecyclerView.m
{
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204808);
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.mu(paramInt1);
    localb.mu(paramInt2);
    a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
    p.h(paramRecyclerView, "recyclerView");
    this.sTe.cMY();
    a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(204808);
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(204809);
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.mu(paramInt);
    a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
    super.b(paramRecyclerView, paramInt);
    a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    AppMethodBeat.o(204809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI.j
 * JD-Core Version:    0.7.0.1
 */