package com.tencent.mm.plugin.finder.view.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/decoration/ItemDividerDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "divider", "Landroid/graphics/drawable/Drawable;", "dividerHeight", "", "(Landroid/graphics/drawable/Drawable;I)V", "padding", "", "(Landroid/graphics/drawable/Drawable;I[I)V", "drawHorizontal", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "drawVertical", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "onDraw", "plugin-finder_release"})
public final class b
  extends RecyclerView.h
{
  private Drawable ipA;
  private int[] qYN;
  
  public b(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(168501);
    this.ipA = paramDrawable;
    paramDrawable.setBounds(0, 0, 0, paramInt);
    AppMethodBeat.o(168501);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(168499);
    k.h(paramCanvas, "c");
    k.h(paramRecyclerView, "parent");
    k.h(params, "state");
    super.a(paramCanvas, paramRecyclerView, params);
    int n = paramRecyclerView.getChildCount();
    int i = 0;
    if (i < n)
    {
      params = paramRecyclerView.getChildAt(i);
      k.g(params, "child");
      Object localObject = params.getLayoutParams();
      if (localObject == null)
      {
        paramCanvas = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(168499);
        throw paramCanvas;
      }
      localObject = (RecyclerView.LayoutParams)localObject;
      int i1 = params.getLeft();
      int i2 = ((RecyclerView.LayoutParams)localObject).leftMargin;
      int[] arrayOfInt = this.qYN;
      int j;
      label124:
      int i3;
      int k;
      label154:
      int i4;
      int i5;
      label191:
      int i6;
      if (arrayOfInt != null)
      {
        j = arrayOfInt[0];
        m = params.getBottom();
        i3 = ((RecyclerView.LayoutParams)localObject).bottomMargin;
        arrayOfInt = this.qYN;
        if (arrayOfInt == null) {
          break label273;
        }
        k = arrayOfInt[1];
        i3 = k + (i3 + m);
        i4 = params.getRight();
        i5 = ((RecyclerView.LayoutParams)localObject).rightMargin;
        params = this.qYN;
        if (params == null) {
          break label279;
        }
        k = params[2];
        i6 = this.ipA.getBounds().height();
        params = this.qYN;
        if (params == null) {
          break label285;
        }
      }
      label273:
      label279:
      label285:
      for (int m = params[3];; m = 0)
      {
        this.ipA.setBounds(i1 - i2 + j, i3, i4 + i5 - k, i3 + i6 - m);
        this.ipA.draw(paramCanvas);
        i += 1;
        break;
        j = 0;
        break label124;
        k = 0;
        break label154;
        k = 0;
        break label191;
      }
    }
    AppMethodBeat.o(168499);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(168500);
    k.h(paramRect, "outRect");
    k.h(paramView, "view");
    k.h(paramRecyclerView, "parent");
    k.h(params, "state");
    super.a(paramRect, paramView, paramRecyclerView, params);
    paramView = paramRecyclerView.bh(paramView);
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.lp());
      if (paramView != null) {
        break label97;
      }
      label61:
      if (paramView != null) {
        break label112;
      }
    }
    label97:
    label112:
    while (paramView.intValue() != -2)
    {
      if (paramView != null) {
        break label127;
      }
      paramRect.set(0, 0, 0, this.ipA.getBounds().height());
      AppMethodBeat.o(168500);
      return;
      paramView = null;
      break;
      if (paramView.intValue() != -3) {
        break label61;
      }
      AppMethodBeat.o(168500);
      return;
    }
    for (;;)
    {
      AppMethodBeat.o(168500);
      return;
      label127:
      if (paramView.intValue() != -4) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.decoration.b
 * JD-Core Version:    0.7.0.1
 */