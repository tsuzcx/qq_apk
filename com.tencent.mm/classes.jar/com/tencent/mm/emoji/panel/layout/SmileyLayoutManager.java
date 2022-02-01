package com.tencent.mm.emoji.panel.layout;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/panel/layout/SmileyLayoutManager;", "Landroid/support/v7/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "(Landroid/content/Context;I)V", "hideRect", "Landroid/graphics/Rect;", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollVerticallyBy", "dy", "updateChildren", "updateHideArea", "rect", "plugin-emojisdk_release"})
public final class SmileyLayoutManager
  extends GridLayoutManager
{
  public final Rect fTv;
  
  public SmileyLayoutManager(Context paramContext, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(105722);
    this.fTv = new Rect();
    AppMethodBeat.o(105722);
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(105719);
    paramInt = super.a(paramInt, paramo, paramt);
    ado();
    AppMethodBeat.o(105719);
    return paramInt;
  }
  
  public final void ado()
  {
    AppMethodBeat.i(105721);
    if (this.fTv.isEmpty())
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
        k.g(localView, "getChildAt(i) ?: continue");
        boolean bool;
        if (bC(localView) != 1)
        {
          localView.setAlpha(1.0F);
          bool = true;
        }
        for (;;)
        {
          localView.setEnabled(bool);
          break;
          c(localView, localRect);
          int m = bI(localView);
          int k = bJ(localView);
          if ((m > this.fTv.left) && (k > this.fTv.top)) {
            m = bH(localView);
          }
          for (float f = 1.0F - (k - this.fTv.top) / ((k - m) * 0.4F);; f = 1.0F)
          {
            localView.setAlpha(f);
            if (f <= 0.7D) {
              break label198;
            }
            bool = true;
            break;
          }
          label198:
          bool = false;
        }
      }
    }
    AppMethodBeat.o(105721);
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(105720);
    paramInt = super.b(paramInt, paramo, paramt);
    ado();
    AppMethodBeat.o(105720);
    return paramInt;
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(105718);
    super.c(paramo, paramt);
    ado();
    AppMethodBeat.o(105718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.layout.SmileyLayoutManager
 * JD-Core Version:    0.7.0.1
 */