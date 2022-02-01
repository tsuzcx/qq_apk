package com.tencent.mm.plugin.finder.feed;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$SpaceItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "space", "", "column", "(II)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
final class q$b
  extends RecyclerView.h
{
  private final int column;
  private final int rie;
  
  public q$b(int paramInt)
  {
    this.rie = paramInt;
    this.column = 5;
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(201702);
    k.h(paramRect, "outRect");
    k.h(paramView, "view");
    k.h(paramRecyclerView, "parent");
    k.h(paramt, "state");
    paramRect.left = (RecyclerView.bw(paramView) % this.column * this.rie);
    AppMethodBeat.o(201702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.q.b
 * JD-Core Version:    0.7.0.1
 */