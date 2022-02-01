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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/decoration/ItemDividerDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "divider", "Landroid/graphics/drawable/Drawable;", "dividerHeight", "", "(Landroid/graphics/drawable/Drawable;I)V", "orientation", "(Landroid/graphics/drawable/Drawable;II)V", "padding", "", "(Landroid/graphics/drawable/Drawable;I[I)V", "drawHorizontal", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "drawVertical", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "onDraw", "plugin-finder_release"})
public final class b
  extends RecyclerView.h
{
  private Drawable kjR;
  private int orientation;
  private int[] wsj;
  
  public b(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(168501);
    this.kjR = paramDrawable;
    this.orientation = 1;
    if (this.orientation == 0)
    {
      paramDrawable.setBounds(0, 0, paramInt, 0);
      AppMethodBeat.o(168501);
      return;
    }
    paramDrawable.setBounds(0, 0, 0, paramInt);
    AppMethodBeat.o(168501);
  }
  
  public b(Drawable paramDrawable, int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(255211);
    this.kjR = paramDrawable;
    this.wsj = paramArrayOfInt;
    this.orientation = 1;
    if (this.orientation == 0)
    {
      paramDrawable.setBounds(0, 0, paramInt, 0);
      AppMethodBeat.o(255211);
      return;
    }
    paramDrawable.setBounds(0, 0, 0, paramInt);
    AppMethodBeat.o(255211);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int i = 0;
    AppMethodBeat.i(168499);
    p.h(paramCanvas, "c");
    p.h(paramRecyclerView, "parent");
    p.h(params, "state");
    super.a(paramCanvas, paramRecyclerView, params);
    int n;
    int j;
    label161:
    label165:
    label169:
    label208:
    label226:
    label238:
    label250:
    int k;
    label262:
    int i3;
    switch (this.orientation)
    {
    default: 
      n = paramRecyclerView.getChildCount();
      i = 0;
      if (i >= n) {
        break label562;
      }
      params = paramRecyclerView.getChildAt(i);
      p.g(params, "child");
      localObject = params.getLayoutParams();
      if (localObject == null)
      {
        paramCanvas = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(168499);
        throw paramCanvas;
      }
      break;
    case 0: 
      j = paramRecyclerView.getChildCount();
      if (i < j)
      {
        localObject = paramRecyclerView.getChildAt(i);
        params = paramRecyclerView.bi((View)localObject);
        if (params != null)
        {
          params = Integer.valueOf(params.lU());
          if (params != null) {
            break label208;
          }
        }
        while (params.intValue() != -2)
        {
          if (params != null) {
            break label226;
          }
          if (params != null) {
            break label238;
          }
          if (params != null) {
            break label250;
          }
          p.g(localObject, "child");
          params = ((View)localObject).getLayoutParams();
          if (params != null) {
            break label262;
          }
          paramCanvas = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
          AppMethodBeat.o(168499);
          throw paramCanvas;
          params = null;
          break;
        }
        for (;;)
        {
          i += 1;
          break;
          if (params.intValue() != -3)
          {
            break label161;
            if (params.intValue() != -4)
            {
              break label165;
              if (params.intValue() != -5) {
                break label169;
              }
              continue;
              params = (RecyclerView.LayoutParams)params;
              k = ((View)localObject).getRight() + params.rightMargin;
              m = ((View)localObject).getTop();
              n = params.topMargin;
              i1 = this.kjR.getBounds().width();
              i2 = ((View)localObject).getBottom();
              i3 = params.bottomMargin;
              this.kjR.setBounds(k, m - n, i1 + k, i3 + i2);
              this.kjR.draw(paramCanvas);
            }
          }
        }
      }
      AppMethodBeat.o(168499);
      return;
    }
    Object localObject = (RecyclerView.LayoutParams)localObject;
    int i1 = params.getLeft();
    int i2 = ((RecyclerView.LayoutParams)localObject).leftMargin;
    int[] arrayOfInt = this.wsj;
    label395:
    label425:
    int i4;
    int i5;
    label462:
    int i6;
    if (arrayOfInt != null)
    {
      j = arrayOfInt[0];
      m = params.getBottom();
      i3 = ((RecyclerView.LayoutParams)localObject).bottomMargin;
      arrayOfInt = this.wsj;
      if (arrayOfInt == null) {
        break label544;
      }
      k = arrayOfInt[1];
      i3 = k + (i3 + m);
      i4 = params.getRight();
      i5 = ((RecyclerView.LayoutParams)localObject).rightMargin;
      params = this.wsj;
      if (params == null) {
        break label550;
      }
      k = params[2];
      i6 = this.kjR.getBounds().height();
      params = this.wsj;
      if (params == null) {
        break label556;
      }
    }
    label544:
    label550:
    label556:
    for (int m = params[3];; m = 0)
    {
      this.kjR.setBounds(i1 - i2 + j, i3, i4 + i5 - k, i3 + i6 - m);
      this.kjR.draw(paramCanvas);
      i += 1;
      break;
      j = 0;
      break label395;
      k = 0;
      break label425;
      k = 0;
      break label462;
    }
    label562:
    AppMethodBeat.o(168499);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(168500);
    p.h(paramRect, "outRect");
    p.h(paramView, "view");
    p.h(paramRecyclerView, "parent");
    p.h(params, "state");
    super.a(paramRect, paramView, paramRecyclerView, params);
    paramView = paramRecyclerView.bi(paramView);
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.lU());
      label57:
      if (paramView != null) {
        break label124;
      }
    }
    label69:
    label73:
    label124:
    while (paramView.intValue() != -2)
    {
      if (paramView != null) {
        break label139;
      }
      if (paramView != null) {
        break label151;
      }
      if (paramView != null) {
        break label163;
      }
      switch (this.orientation)
      {
      default: 
        paramRect.set(0, 0, 0, this.kjR.getBounds().height());
        AppMethodBeat.o(168500);
        return;
        paramView = null;
        break label57;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(168500);
      return;
      label139:
      if (paramView.intValue() != -3)
      {
        break;
        label151:
        if (paramView.intValue() != -4)
        {
          break label69;
          label163:
          if (paramView.intValue() != -5) {
            break label73;
          }
        }
      }
    }
    paramRect.set(0, 0, this.kjR.getBounds().width(), 0);
    AppMethodBeat.o(168500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.decoration.b
 * JD-Core Version:    0.7.0.1
 */