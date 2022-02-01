package com.tencent.mm.emoji.panel.layout;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/layout/SmileyLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "(Landroid/content/Context;I)V", "hideRect", "Landroid/graphics/Rect;", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollVerticallyBy", "dy", "updateChildren", "updateHideArea", "rect", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SmileyLayoutManager
  extends GridLayoutManager
{
  public final Rect mkA;
  
  public SmileyLayoutManager(Context paramContext, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(105722);
    this.mkA = new Rect();
    AppMethodBeat.o(105722);
  }
  
  public final void aVW()
  {
    AppMethodBeat.i(105721);
    if (this.mkA.isEmpty())
    {
      AppMethodBeat.o(105721);
      return;
    }
    Rect localRect = new Rect();
    int k = getChildCount();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      View localView = getChildAt(i);
      boolean bool;
      if (localView != null)
      {
        if (getItemViewType(localView) == 1) {
          break label97;
        }
        localView.setAlpha(1.0F);
        bool = true;
      }
      for (;;)
      {
        localView.setEnabled(bool);
        if (j < k) {
          break;
        }
        AppMethodBeat.o(105721);
        return;
        label97:
        getDecoratedBoundsWithMargins(localView, localRect);
        int m = getDecoratedRight(localView);
        i = getDecoratedBottom(localView);
        if ((m > this.mkA.left) && (i > this.mkA.top)) {
          m = getDecoratedTop(localView);
        }
        for (float f = 1.0F - (i - this.mkA.top) / ((i - m) * 0.4F);; f = 1.0F)
        {
          localView.setAlpha(f);
          if (f <= 0.7D) {
            break label199;
          }
          bool = true;
          break;
        }
        label199:
        bool = false;
      }
    }
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(242378);
    super.onLayoutChildren(paramn, params);
    aVW();
    AppMethodBeat.o(242378);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(242385);
    paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
    aVW();
    AppMethodBeat.o(242385);
    return paramInt;
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(242391);
    paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
    aVW();
    AppMethodBeat.o(242391);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.layout.SmileyLayoutManager
 * JD-Core Version:    0.7.0.1
 */