package com.tencent.mm.plugin.emoji.ui.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emoji/ui/widget/GridDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "horizontalDivider", "Landroid/graphics/drawable/Drawable;", "verticalDivider", "numColumns", "", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;I)V", "bonds", "Landroid/graphics/Rect;", "mHorizontalDivider", "mNumColumns", "mVerticalDivider", "drawHorizontalDividers", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "drawVerticalDividers", "getItemOffsets", "outRect", "view", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "plugin-emoji_release"})
public final class a
  extends RecyclerView.h
{
  private final int mNumColumns;
  private final Drawable uQG;
  private final Drawable uQH;
  private final Rect uQI;
  
  public a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    AppMethodBeat.i(257753);
    this.uQG = paramDrawable1;
    this.uQH = paramDrawable2;
    this.mNumColumns = 5;
    this.uQI = new Rect();
    AppMethodBeat.o(257753);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(257750);
    p.k(paramCanvas, "canvas");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    int j = paramRecyclerView.getChildCount();
    params = (GridLayoutManager)paramRecyclerView.getLayoutManager();
    int i = 0;
    while (i < j)
    {
      View localView = paramRecyclerView.getChildAt(i);
      RecyclerView.getDecoratedBoundsWithMargins(localView, this.uQI);
      RecyclerView.bh(localView);
      int k;
      if (params != null)
      {
        k = params.ku();
        if (params.getSpanSizeLookup().cx(RecyclerView.bh(localView)) == k) {}
      }
      else
      {
        p.j(localView, "child");
        k = Math.round(localView.getTranslationY());
        int m = this.uQI.bottom + k;
        int n = this.uQI.top;
        if (this.uQI.right < paramRecyclerView.getWidth())
        {
          this.uQG.setBounds(this.uQI.right, k + n, this.uQI.right + this.uQG.getIntrinsicWidth(), m);
          this.uQG.draw(paramCanvas);
        }
        if (this.uQI.bottom < paramRecyclerView.getHeight())
        {
          this.uQH.setBounds(this.uQI.left, m, this.uQI.right, this.uQH.getIntrinsicHeight() + m);
          this.uQH.draw(paramCanvas);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(257750);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int j = 1;
    AppMethodBeat.i(257751);
    p.k(paramRect, "outRect");
    p.k(paramView, "view");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    super.a(paramRect, paramView, paramRecyclerView, params);
    if (RecyclerView.bh(paramView) % this.mNumColumns == this.mNumColumns - 1)
    {
      i = 1;
      if (i == 0) {
        paramRect.right = this.uQG.getIntrinsicWidth();
      }
      if (params.getItemCount() / this.mNumColumns != RecyclerView.bh(paramView) / this.mNumColumns) {
        break label133;
      }
    }
    label133:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        paramRect.bottom = this.uQH.getIntrinsicHeight();
      }
      AppMethodBeat.o(257751);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */