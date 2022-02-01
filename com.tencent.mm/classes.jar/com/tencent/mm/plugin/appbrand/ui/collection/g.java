package com.tencent.mm.plugin.appbrand.ui.collection;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class g
  extends RecyclerView.h
{
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(322641);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    paramView = paramRecyclerView.bj(paramView);
    if ((paramView != null) && ((paramView instanceof h)))
    {
      paramRect = ((h)paramView).uix;
      int j = ((h)paramView).KJ();
      paramView = paramRecyclerView.getAdapter();
      if (paramView != null) {
        break label101;
      }
      i = -1;
      if (j != i - 1) {
        break label110;
      }
    }
    label101:
    label110:
    for (int i = 8;; i = 0)
    {
      paramRect.setVisibility(i);
      AppMethodBeat.o(322641);
      return;
      i = paramView.getItemCount();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.g
 * JD-Core Version:    0.7.0.1
 */