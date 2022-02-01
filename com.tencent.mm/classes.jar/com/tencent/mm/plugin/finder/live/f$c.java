package com.tencent.mm.plugin.finder.live;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/FinderLiveLivePlayRecyclerViewSelector$initSelector$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
public final class f$c
  extends RecyclerView.l
{
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(288503);
    b localb = new b();
    localb.bn(paramRecyclerView);
    localb.sg(paramInt);
    a.c("com/tencent/mm/plugin/finder/live/FinderLiveLivePlayRecyclerViewSelector$initSelector$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
    p.k(paramRecyclerView, "recyclerView");
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0) {
      f.a(this.xVj);
    }
    a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveLivePlayRecyclerViewSelector$initSelector$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
    AppMethodBeat.o(288503);
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(288504);
    b localb = new b();
    localb.bn(paramRecyclerView);
    localb.sg(paramInt1);
    localb.sg(paramInt2);
    a.c("com/tencent/mm/plugin/finder/live/FinderLiveLivePlayRecyclerViewSelector$initSelector$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
    p.k(paramRecyclerView, "recyclerView");
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    f.a(this.xVj);
    a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveLivePlayRecyclerViewSelector$initSelector$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
    AppMethodBeat.o(288504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.f.c
 * JD-Core Version:    0.7.0.1
 */