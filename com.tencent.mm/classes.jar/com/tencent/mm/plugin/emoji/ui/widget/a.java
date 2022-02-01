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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/widget/GridDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "horizontalDivider", "Landroid/graphics/drawable/Drawable;", "verticalDivider", "numColumns", "", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;I)V", "bonds", "Landroid/graphics/Rect;", "mHorizontalDivider", "mNumColumns", "mVerticalDivider", "drawHorizontalDividers", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "drawVerticalDividers", "getItemOffsets", "outRect", "view", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends RecyclerView.h
{
  private final int mNumColumns;
  private final Drawable yde;
  private final Drawable ydf;
  private final Rect ydg;
  
  public a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    AppMethodBeat.i(270744);
    this.yde = paramDrawable1;
    this.ydf = paramDrawable2;
    this.mNumColumns = 5;
    this.ydg = new Rect();
    AppMethodBeat.o(270744);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(270748);
    s.u(paramCanvas, "canvas");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    int k = paramRecyclerView.getChildCount();
    params = (GridLayoutManager)paramRecyclerView.getLayoutManager();
    int i = 0;
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      View localView = paramRecyclerView.getChildAt(i);
      RecyclerView.getDecoratedBoundsWithMargins(localView, this.ydg);
      RecyclerView.bA(localView);
      if (params != null)
      {
        i = params.bWl;
        if (params.bWq.fJ(RecyclerView.bA(localView)) == i) {}
      }
      else
      {
        i = Math.round(localView.getTranslationY());
        int m = this.ydg.bottom + i;
        int n = this.ydg.top;
        if (this.ydg.right < paramRecyclerView.getWidth())
        {
          this.yde.setBounds(this.ydg.right, i + n, this.ydg.right + this.yde.getIntrinsicWidth(), m);
          this.yde.draw(paramCanvas);
        }
        if (this.ydg.bottom < paramRecyclerView.getHeight())
        {
          this.ydf.setBounds(this.ydg.left, m, this.ydg.right, this.ydf.getIntrinsicHeight() + m);
          this.ydf.draw(paramCanvas);
        }
      }
      if (j >= k)
      {
        AppMethodBeat.o(270748);
        return;
      }
      i = j;
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int j = 1;
    AppMethodBeat.i(270751);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    super.a(paramRect, paramView, paramRecyclerView, params);
    if (RecyclerView.bA(paramView) % this.mNumColumns == this.mNumColumns - 1)
    {
      i = 1;
      if (i == 0) {
        paramRect.right = this.yde.getIntrinsicWidth();
      }
      if (params.getItemCount() / this.mNumColumns != RecyclerView.bA(paramView) / this.mNumColumns) {
        break label133;
      }
    }
    label133:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        paramRect.bottom = this.ydf.getIntrinsicHeight();
      }
      AppMethodBeat.o(270751);
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