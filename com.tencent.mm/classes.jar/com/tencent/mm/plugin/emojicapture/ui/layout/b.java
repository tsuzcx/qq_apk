package com.tencent.mm.plugin.emojicapture.ui.layout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/layout/RecommendStickerDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "itemPadding", "", "itemWidth", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-emojicapture_release"})
public final class b
  extends RecyclerView.h
{
  private final int itemPadding;
  private final int qmd;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(883);
    this.qmd = paramContext.getResources().getDimensionPixelSize(2131166249);
    this.itemPadding = paramContext.getResources().getDimensionPixelSize(2131165314);
    AppMethodBeat.o(883);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(882);
    p.h(paramRect, "outRect");
    p.h(paramView, "view");
    p.h(paramRecyclerView, "parent");
    p.h(params, "state");
    int j = RecyclerView.bw(paramView);
    paramView = paramRecyclerView.getAdapter();
    int i;
    if (paramView != null)
    {
      i = paramView.getItemCount();
      paramView = paramRecyclerView.getAdapter();
      if (paramView == null) {
        break label110;
      }
    }
    label110:
    for (paramView = Integer.valueOf(paramView.getItemViewType(j));; paramView = null)
    {
      if (j != 0) {
        break label115;
      }
      paramRect.set((paramRecyclerView.getWidth() - this.qmd) / 2, 0, this.itemPadding, 0);
      AppMethodBeat.o(882);
      return;
      i = 0;
      break;
    }
    label115:
    if (j == i - 1)
    {
      if (paramView == null) {}
      for (i = (paramRecyclerView.getWidth() - this.qmd) / 2;; i = paramRecyclerView.getWidth() / 2 - this.qmd / 2 * 3 - this.itemPadding * 2)
      {
        paramRect.set(this.itemPadding, 0, i, 0);
        AppMethodBeat.o(882);
        return;
        if (paramView.intValue() != 2) {
          break;
        }
      }
    }
    paramRect.set(this.itemPadding, 0, this.itemPadding, 0);
    AppMethodBeat.o(882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.layout.b
 * JD-Core Version:    0.7.0.1
 */