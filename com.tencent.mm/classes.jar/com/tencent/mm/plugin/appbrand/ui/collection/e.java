package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-appbrand-integration_release"})
final class e
  extends RecyclerView.h
{
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(135100);
    if (paramRect == null) {
      j.ebi();
    }
    paramRect.left = 0;
    paramRect.right = 0;
    paramRect.top = 0;
    if (paramRecyclerView == null) {
      j.ebi();
    }
    params = paramRecyclerView.getLayoutManager();
    if (params == null)
    {
      paramRect = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
      AppMethodBeat.o(135100);
      throw paramRect;
    }
    params = (GridLayoutManager)params;
    if (paramView == null) {
      j.ebi();
    }
    paramView = paramRecyclerView.bb(paramView);
    j.p(paramView, "parent.getChildViewHolder(view!!)");
    int i = paramView.jN();
    paramView = paramRecyclerView.getAdapter();
    j.p(paramView, "parent.adapter");
    int j = paramView.getItemCount() / params.ig();
    if (i >= params.ig() * j) {}
    for (i = 0;; i = paramView.getResources().getDimensionPixelSize(2131428084))
    {
      paramRect.bottom = i;
      AppMethodBeat.o(135100);
      return;
      paramView = paramRecyclerView.getContext();
      j.p(paramView, "parent.context");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.e
 * JD-Core Version:    0.7.0.1
 */