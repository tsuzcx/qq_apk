package com.tencent.mm.plugin.finder.view.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/decoration/ItemDividerDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "divider", "Landroid/graphics/drawable/Drawable;", "dividerHeight", "", "(Landroid/graphics/drawable/Drawable;I)V", "orientation", "(Landroid/graphics/drawable/Drawable;II)V", "padding", "", "(Landroid/graphics/drawable/Drawable;I[I)V", "drawHorizontal", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "drawVertical", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "onDraw", "plugin-finder_release"})
public final class b
  extends RecyclerView.h
{
  private int[] Bew;
  private int FO;
  private Drawable nbH;
  
  public b(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(168501);
    this.nbH = paramDrawable;
    this.FO = 1;
    if (this.FO == 0)
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
    AppMethodBeat.i(274569);
    this.nbH = paramDrawable;
    this.Bew = paramArrayOfInt;
    this.FO = 1;
    if (this.FO == 0)
    {
      paramDrawable.setBounds(0, 0, paramInt, 0);
      AppMethodBeat.o(274569);
      return;
    }
    paramDrawable.setBounds(0, 0, 0, paramInt);
    AppMethodBeat.o(274569);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int i = 0;
    AppMethodBeat.i(274567);
    p.k(paramCanvas, "c");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
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
    switch (this.FO)
    {
    default: 
      n = paramRecyclerView.getChildCount();
      i = 0;
      if (i >= n) {
        break label562;
      }
      params = paramRecyclerView.getChildAt(i);
      p.j(params, "child");
      localObject = params.getLayoutParams();
      if (localObject == null)
      {
        paramCanvas = new t("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(274567);
        throw paramCanvas;
      }
      break;
    case 0: 
      j = paramRecyclerView.getChildCount();
      if (i < j)
      {
        localObject = paramRecyclerView.getChildAt(i);
        params = paramRecyclerView.aQ((View)localObject);
        if (params != null)
        {
          params = Integer.valueOf(params.mg());
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
          p.j(localObject, "child");
          params = ((View)localObject).getLayoutParams();
          if (params != null) {
            break label262;
          }
          paramCanvas = new t("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
          AppMethodBeat.o(274567);
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
              i1 = this.nbH.getBounds().width();
              i2 = ((View)localObject).getBottom();
              i3 = params.bottomMargin;
              this.nbH.setBounds(k, m - n, i1 + k, i3 + i2);
              this.nbH.draw(paramCanvas);
            }
          }
        }
      }
      AppMethodBeat.o(274567);
      return;
    }
    Object localObject = (RecyclerView.LayoutParams)localObject;
    int i1 = params.getLeft();
    int i2 = ((RecyclerView.LayoutParams)localObject).leftMargin;
    int[] arrayOfInt = this.Bew;
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
      arrayOfInt = this.Bew;
      if (arrayOfInt == null) {
        break label544;
      }
      k = arrayOfInt[1];
      i3 = k + (i3 + m);
      i4 = params.getRight();
      i5 = ((RecyclerView.LayoutParams)localObject).rightMargin;
      params = this.Bew;
      if (params == null) {
        break label550;
      }
      k = params[2];
      i6 = this.nbH.getBounds().height();
      params = this.Bew;
      if (params == null) {
        break label556;
      }
    }
    label544:
    label550:
    label556:
    for (int m = params[3];; m = 0)
    {
      this.nbH.setBounds(i1 - i2 + j, i3, i4 + i5 - k, i3 + i6 - m);
      this.nbH.draw(paramCanvas);
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
    AppMethodBeat.o(274567);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(274568);
    p.k(paramRect, "outRect");
    p.k(paramView, "view");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    super.a(paramRect, paramView, paramRecyclerView, params);
    paramView = paramRecyclerView.aQ(paramView);
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.mg());
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
      switch (this.FO)
      {
      default: 
        paramRect.set(0, 0, 0, this.nbH.getBounds().height());
        AppMethodBeat.o(274568);
        return;
        paramView = null;
        break label57;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(274568);
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
    paramRect.set(0, 0, this.nbH.getBounds().width(), 0);
    AppMethodBeat.o(274568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.decoration.b
 * JD-Core Version:    0.7.0.1
 */