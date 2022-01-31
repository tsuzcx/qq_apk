package com.tencent.mm.plugin.appbrand.ui.collection;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-appbrand-integration_release"})
final class k
  extends RecyclerView.h
{
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(135114);
    if (paramRecyclerView != null)
    {
      paramView = paramRecyclerView.bb(paramView);
      if (paramView != null)
      {
        if ((paramView instanceof l))
        {
          paramRect = ((l)paramView).iSi;
          int j = ((l)paramView).jN();
          paramView = paramRecyclerView.getAdapter();
          if (paramView == null) {
            break label83;
          }
          i = paramView.getItemCount();
          if (j != i - 1) {
            break label89;
          }
        }
        label83:
        label89:
        for (int i = 8;; i = 0)
        {
          paramRect.setVisibility(i);
          AppMethodBeat.o(135114);
          return;
          i = -1;
          break;
        }
      }
    }
    AppMethodBeat.o(135114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.k
 * JD-Core Version:    0.7.0.1
 */