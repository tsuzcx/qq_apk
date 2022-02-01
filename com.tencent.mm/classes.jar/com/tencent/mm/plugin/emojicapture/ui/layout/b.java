package com.tencent.mm.plugin.emojicapture.ui.layout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.a.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/layout/RecommendStickerDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "itemPadding", "", "itemWidth", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-emojicapture_release"})
public final class b
  extends RecyclerView.h
{
  private final int itemPadding;
  private final int tHY;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(883);
    this.tHY = paramContext.getResources().getDimensionPixelSize(a.d.uRo);
    this.itemPadding = paramContext.getResources().getDimensionPixelSize(a.d.Edge_A);
    AppMethodBeat.o(883);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(201533);
    p.k(paramRect, "outRect");
    p.k(paramView, "view");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    int j = RecyclerView.bh(paramView);
    paramView = paramRecyclerView.getAdapter();
    int i;
    if (paramView != null)
    {
      i = paramView.getItemCount();
      paramView = paramRecyclerView.getAdapter();
      if (paramView == null) {
        break label108;
      }
    }
    label108:
    for (paramView = Integer.valueOf(paramView.getItemViewType(j));; paramView = null)
    {
      if (j != 0) {
        break label113;
      }
      paramRect.set((paramRecyclerView.getWidth() - this.tHY) / 2, 0, this.itemPadding, 0);
      AppMethodBeat.o(201533);
      return;
      i = 0;
      break;
    }
    label113:
    if (j == i - 1)
    {
      if (paramView == null) {}
      for (i = (paramRecyclerView.getWidth() - this.tHY) / 2;; i = paramRecyclerView.getWidth() / 2 - this.tHY / 2 * 3 - this.itemPadding * 2)
      {
        paramRect.set(this.itemPadding, 0, i, 0);
        AppMethodBeat.o(201533);
        return;
        if (paramView.intValue() != 2) {
          break;
        }
      }
    }
    paramRect.set(this.itemPadding, 0, this.itemPadding, 0);
    AppMethodBeat.o(201533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.layout.b
 * JD-Core Version:    0.7.0.1
 */