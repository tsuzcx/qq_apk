package com.tencent.mm.emoji.panel.layout;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/layout/SmileyLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "(Landroid/content/Context;I)V", "hideRect", "Landroid/graphics/Rect;", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollVerticallyBy", "dy", "updateChildren", "updateHideArea", "rect", "plugin-emojisdk_release"})
public final class SmileyLayoutManager
  extends GridLayoutManager
{
  public final Rect jLp;
  
  public SmileyLayoutManager(Context paramContext, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(105722);
    this.jLp = new Rect();
    AppMethodBeat.o(105722);
  }
  
  public final void aCW()
  {
    AppMethodBeat.i(105721);
    if (this.jLp.isEmpty())
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
        p.j(localView, "getChildAt(i) ?: continue");
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
          if ((m > this.jLp.left) && (k > this.jLp.top)) {
            m = getDecoratedTop(localView);
          }
          for (float f = 1.0F - (k - this.jLp.top) / ((k - m) * 0.4F);; f = 1.0F)
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
    AppMethodBeat.i(224701);
    super.onLayoutChildren(paramn, params);
    aCW();
    AppMethodBeat.o(224701);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(224704);
    paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
    aCW();
    AppMethodBeat.o(224704);
    return paramInt;
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(224707);
    paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
    aCW();
    AppMethodBeat.o(224707);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.layout.SmileyLayoutManager
 * JD-Core Version:    0.7.0.1
 */