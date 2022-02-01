package com.tencent.mm.plugin.finder.feed;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderLikeDrawerPresenter$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
public final class s$c
  extends RecyclerView.h
{
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(202370);
    p.h(paramRect, "outRect");
    p.h(paramView, "view");
    p.h(paramRecyclerView, "parent");
    p.h(paramt, "state");
    paramRect.set(0, 0, 0, 0);
    AppMethodBeat.o(202370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.s.c
 * JD-Core Version:    0.7.0.1
 */