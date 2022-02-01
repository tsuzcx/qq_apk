package com.tencent.mm.emoji.panel.layout;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/layout/SmileyLayoutManager;", "Landroid/support/v7/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "(Landroid/content/Context;I)V", "hideRect", "Landroid/graphics/Rect;", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollVerticallyBy", "dy", "updateChildren", "updateHideArea", "rect", "plugin-emojisdk_release"})
public final class SmileyLayoutManager
  extends GridLayoutManager
{
  public final Rect hao;
  
  public SmileyLayoutManager(Context paramContext, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(105722);
    this.hao = new Rect();
    AppMethodBeat.o(105722);
  }
  
  public final void avX()
  {
    AppMethodBeat.i(105721);
    if (this.hao.isEmpty())
    {
      AppMethodBeat.o(105721);
      return;
    }
    Rect localRect = new Rect();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView == null)
      {
        i += 1;
      }
      else
      {
        p.g(localView, "getChildAt(i) ?: continue");
        boolean bool;
        if (getItemViewType(localView) != 1)
        {
          localView.setAlpha(1.0F);
          bool = true;
        }
        for (;;)
        {
          localView.setEnabled(bool);
          break;
          getDecoratedBoundsWithMargins(localView, localRect);
          int m = getDecoratedRight(localView);
          int k = getDecoratedBottom(localView);
          if ((m > this.hao.left) && (k > this.hao.top)) {
            m = getDecoratedTop(localView);
          }
          for (float f = 1.0F - (k - this.hao.top) / ((k - m) * 0.4F);; f = 1.0F)
          {
            localView.setAlpha(f);
            if (f <= 0.7D) {
              break label203;
            }
            bool = true;
            break;
          }
          label203:
          bool = false;
        }
      }
    }
    AppMethodBeat.o(105721);
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(105718);
    super.onLayoutChildren(paramn, params);
    avX();
    AppMethodBeat.o(105718);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(105719);
    paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
    avX();
    AppMethodBeat.o(105719);
    return paramInt;
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(105720);
    paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
    avX();
    AppMethodBeat.o(105720);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.layout.SmileyLayoutManager
 * JD-Core Version:    0.7.0.1
 */