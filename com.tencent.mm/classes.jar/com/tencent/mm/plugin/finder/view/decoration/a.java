package com.tencent.mm.plugin.finder.view.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/decoration/CommentItemDividerDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "divider", "Landroid/graphics/drawable/Drawable;", "dividerHeight", "", "(Landroid/graphics/drawable/Drawable;I)V", "padding", "", "(Landroid/graphics/drawable/Drawable;I[I)V", "extraLast", "(Landroid/graphics/drawable/Drawable;I[II)V", "drawHorizontal", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "drawVertical", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "onDraw", "plugin-finder_release"})
public final class a
  extends RecyclerView.h
{
  private Drawable kjR;
  private int[] wsj;
  private int wsk;
  
  public a(Drawable paramDrawable, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    AppMethodBeat.i(168498);
    this.kjR = paramDrawable;
    this.wsj = paramArrayOfInt;
    this.wsk = paramInt2;
    paramDrawable.setBounds(0, 0, 0, paramInt1);
    AppMethodBeat.o(168498);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(168496);
    p.h(paramCanvas, "c");
    p.h(paramRecyclerView, "parent");
    p.h(params, "state");
    super.a(paramCanvas, paramRecyclerView, params);
    AppMethodBeat.o(168496);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(168497);
    p.h(paramRect, "outRect");
    p.h(paramView, "view");
    p.h(paramRecyclerView, "parent");
    p.h(params, "state");
    super.a(paramRect, paramView, paramRecyclerView, params);
    AppMethodBeat.o(168497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.decoration.a
 * JD-Core Version:    0.7.0.1
 */