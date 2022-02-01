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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/decoration/ItemDividerDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "divider", "Landroid/graphics/drawable/Drawable;", "dividerHeight", "", "(Landroid/graphics/drawable/Drawable;I)V", "orientation", "(Landroid/graphics/drawable/Drawable;II)V", "padding", "", "(Landroid/graphics/drawable/Drawable;I[I)V", "drawHorizontal", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "drawVertical", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "onDraw", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.h
{
  private int[] GGT;
  private int orientation;
  private Drawable pYO;
  
  public b(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(168501);
    this.pYO = paramDrawable;
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
    AppMethodBeat.i(344940);
    this.pYO = paramDrawable;
    this.GGT = paramArrayOfInt;
    this.orientation = 1;
    if (this.orientation == 0)
    {
      paramDrawable.setBounds(0, 0, paramInt, 0);
      AppMethodBeat.o(344940);
      return;
    }
    paramDrawable.setBounds(0, 0, 0, paramInt);
    AppMethodBeat.o(344940);
  }
  
  private final void a(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(344953);
    int n = paramRecyclerView.getChildCount();
    if (n > 0) {}
    int m;
    label264:
    label273:
    for (int i = 0;; i = m)
    {
      m = i + 1;
      Object localObject1 = paramRecyclerView.getChildAt(i);
      Object localObject2 = ((View)localObject1).getLayoutParams();
      if (localObject2 == null)
      {
        paramCanvas = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(344953);
        throw paramCanvas;
      }
      localObject2 = (RecyclerView.LayoutParams)localObject2;
      int i1 = ((View)localObject1).getLeft();
      int i2 = ((RecyclerView.LayoutParams)localObject2).leftMargin;
      int[] arrayOfInt = this.GGT;
      int i3;
      int j;
      label121:
      int i4;
      int i5;
      label159:
      int i6;
      if (arrayOfInt == null)
      {
        i = 0;
        k = ((View)localObject1).getBottom();
        i3 = ((RecyclerView.LayoutParams)localObject2).bottomMargin;
        arrayOfInt = this.GGT;
        if (arrayOfInt != null) {
          break label246;
        }
        j = 0;
        i3 = j + (i3 + k);
        i4 = ((View)localObject1).getRight();
        i5 = ((RecyclerView.LayoutParams)localObject2).rightMargin;
        localObject1 = this.GGT;
        if (localObject1 != null) {
          break label255;
        }
        j = 0;
        i6 = this.pYO.getBounds().height();
        localObject1 = this.GGT;
        if (localObject1 != null) {
          break label264;
        }
      }
      for (int k = 0;; k = localObject1[3])
      {
        this.pYO.setBounds(i1 - i2 + i, i3, i4 + i5 - j, i3 + i6 - k);
        this.pYO.draw(paramCanvas);
        if (m < n) {
          break label273;
        }
        AppMethodBeat.o(344953);
        return;
        i = arrayOfInt[0];
        break;
        label246:
        j = arrayOfInt[1];
        break label121;
        label255:
        j = localObject1[2];
        break label159;
      }
    }
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(344960);
    s.u(paramCanvas, "c");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    super.a(paramCanvas, paramRecyclerView, params);
    int k;
    int i;
    if (this.orientation == 0)
    {
      k = paramRecyclerView.getChildCount();
      i = 0;
      if (k <= 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      View localView = paramRecyclerView.getChildAt(i);
      params = paramRecyclerView.bj(localView);
      if (params == null)
      {
        params = null;
        if (params != null) {
          break label132;
        }
      }
      label90:
      label94:
      while (params.intValue() != -2)
      {
        if (params != null) {
          break label154;
        }
        if (params != null) {
          break label166;
        }
        if (params != null) {
          break label178;
        }
        params = localView.getLayoutParams();
        if (params != null) {
          break label190;
        }
        paramCanvas = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(344960);
        throw paramCanvas;
        params = Integer.valueOf(params.caO);
        break;
      }
      for (;;)
      {
        label132:
        if (j >= k)
        {
          AppMethodBeat.o(344960);
          return;
          label154:
          if (params.intValue() != -3)
          {
            break;
            label166:
            if (params.intValue() != -4)
            {
              break label90;
              label178:
              if (params.intValue() != -5) {
                break label94;
              }
              continue;
              label190:
              params = (RecyclerView.LayoutParams)params;
              i = localView.getRight() + params.rightMargin;
              int m = localView.getTop();
              int n = params.topMargin;
              int i1 = this.pYO.getBounds().width();
              int i2 = localView.getBottom();
              int i3 = params.bottomMargin;
              this.pYO.setBounds(i, m - n, i1 + i, i3 + i2);
              this.pYO.draw(paramCanvas);
              continue;
              a(paramCanvas, paramRecyclerView);
              AppMethodBeat.o(344960);
              return;
            }
          }
        }
      }
      i = j;
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(344971);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    super.a(paramRect, paramView, paramRecyclerView, params);
    paramView = paramRecyclerView.bj(paramView);
    if (paramView == null)
    {
      paramView = null;
      if (paramView != null) {
        break label108;
      }
    }
    label63:
    label67:
    label108:
    while (paramView.intValue() != -2)
    {
      if (paramView != null) {
        break label123;
      }
      if (paramView != null) {
        break label135;
      }
      if (paramView != null) {
        break label147;
      }
      if (this.orientation != 0) {
        break label159;
      }
      paramRect.set(0, 0, this.pYO.getBounds().width(), 0);
      AppMethodBeat.o(344971);
      return;
      paramView = Integer.valueOf(paramView.caO);
      break;
    }
    label135:
    label147:
    for (;;)
    {
      AppMethodBeat.o(344971);
      return;
      label123:
      if (paramView.intValue() != -3)
      {
        break;
        if (paramView.intValue() != -4)
        {
          break label63;
          if (paramView.intValue() != -5) {
            break label67;
          }
        }
      }
    }
    label159:
    paramRect.set(0, 0, 0, this.pYO.getBounds().height());
    AppMethodBeat.o(344971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.decoration.b
 * JD-Core Version:    0.7.0.1
 */