package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-appbrand-integration_release"})
final class f
  extends RecyclerView.h
{
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(51264);
    k.h(paramRect, "outRect");
    k.h(paramView, "view");
    k.h(paramRecyclerView, "parent");
    k.h(paramt, "state");
    paramRect.left = 0;
    paramRect.right = 0;
    paramRect.top = 0;
    paramt = paramRecyclerView.getLayoutManager();
    if (paramt == null)
    {
      paramRect = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
      AppMethodBeat.o(51264);
      throw paramRect;
    }
    paramt = (GridLayoutManager)paramt;
    paramView = paramRecyclerView.bh(paramView);
    k.g(paramView, "parent.getChildViewHolder(view!!)");
    int i = paramView.lv();
    paramView = paramRecyclerView.getAdapter();
    if (paramView == null) {
      k.fOy();
    }
    k.g(paramView, "parent.adapter!!");
    int j = paramView.getItemCount() / paramt.jJ();
    if (i >= paramt.jJ() * j) {}
    for (i = 0;; i = paramView.getResources().getDimensionPixelSize(2131165858))
    {
      paramRect.bottom = i;
      AppMethodBeat.o(51264);
      return;
      paramView = paramRecyclerView.getContext();
      k.g(paramView, "parent.context");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.f
 * JD-Core Version:    0.7.0.1
 */