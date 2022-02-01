package com.tencent.mm.plugin.appbrand.ui.collection;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-appbrand-integration_release"})
final class g
  extends RecyclerView.h
{
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(279330);
    p.k(paramRect, "outRect");
    p.k(paramView, "view");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    paramView = paramRecyclerView.aQ(paramView);
    if (paramView != null)
    {
      if ((paramView instanceof h))
      {
        paramRect = ((h)paramView).rcN;
        int j = ((h)paramView).md();
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
        AppMethodBeat.o(279330);
        return;
        i = -1;
        break;
      }
    }
    AppMethodBeat.o(279330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.g
 * JD-Core Version:    0.7.0.1
 */