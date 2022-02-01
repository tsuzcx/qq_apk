package com.tencent.mm.plugin.appbrand.ui.collection;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-appbrand-integration_release"})
final class l
  extends RecyclerView.h
{
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(51279);
    p.h(paramRect, "outRect");
    p.h(paramView, "view");
    p.h(paramRecyclerView, "parent");
    p.h(paramt, "state");
    paramView = paramRecyclerView.bh(paramView);
    if (paramView != null)
    {
      if ((paramView instanceof m))
      {
        paramRect = ((m)paramView).mOh;
        int j = ((m)paramView).lN();
        paramView = paramRecyclerView.getAdapter();
        if (paramView == null) {
          break label104;
        }
        i = paramView.getItemCount();
        if (j != i - 1) {
          break label110;
        }
      }
      label104:
      label110:
      for (int i = 8;; i = 0)
      {
        paramRect.setVisibility(i);
        AppMethodBeat.o(51279);
        return;
        i = -1;
        break;
      }
    }
    AppMethodBeat.o(51279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.l
 * JD-Core Version:    0.7.0.1
 */