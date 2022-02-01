package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends RecyclerView.h
{
  private Drawable ajR;
  private boolean rIY;
  private int rIZ;
  private int rJa;
  
  private c(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(111507);
    this.rIZ = paramInt1;
    this.rIY = paramBoolean;
    this.rJa = paramInt2;
    this.ajR = new ColorDrawable(paramInt3);
    AppMethodBeat.o(111507);
  }
  
  private static boolean ad(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 % paramInt2 == 0)
    {
      if (paramInt1 < paramInt3 - paramInt2) {}
    }
    else {
      while (paramInt1 >= paramInt3 - paramInt3 % paramInt2) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111511);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    boolean bool;
    if ((paramRecyclerView instanceof GridLayoutManager))
    {
      bool = ad(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(111511);
      return bool;
    }
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      if (((StaggeredGridLayoutManager)paramRecyclerView).mOrientation == 1)
      {
        bool = ad(paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(111511);
        return bool;
      }
      if ((paramInt1 + 1) % paramInt2 == 0)
      {
        AppMethodBeat.o(111511);
        return true;
      }
    }
    AppMethodBeat.o(111511);
    return false;
  }
  
  private static int r(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(111510);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      i = ((GridLayoutManager)paramRecyclerView).amN;
    }
    for (;;)
    {
      AppMethodBeat.o(111510);
      return i;
      if ((paramRecyclerView instanceof StaggeredGridLayoutManager)) {
        i = ((StaggeredGridLayoutManager)paramRecyclerView).amN;
      } else {
        i = -1;
      }
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(111509);
    int i = r(paramRecyclerView);
    int n = paramRecyclerView.getAdapter().getItemCount();
    int i1 = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).aqL.lm();
    if (i1 < 0)
    {
      AppMethodBeat.o(111509);
      return;
    }
    int m = i1 % i;
    int j = this.rJa * m / i;
    int k = this.rJa;
    m = (m + 1) * this.rJa / i;
    if ((b(paramRecyclerView, i1, i, n)) && (!this.rIY)) {}
    for (i = 0;; i = this.rIZ)
    {
      paramRect.set(j, 0, k - m, i);
      AppMethodBeat.o(111509);
      return;
    }
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int j = 0;
    AppMethodBeat.i(164809);
    int k = paramRecyclerView.getChildCount();
    int i = 0;
    RecyclerView.LayoutParams localLayoutParams;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    while (i < k)
    {
      params = paramRecyclerView.getChildAt(i);
      if ((!b(paramRecyclerView, i, r(paramRecyclerView), k)) || (this.rIY))
      {
        localLayoutParams = (RecyclerView.LayoutParams)params.getLayoutParams();
        m = params.getLeft();
        n = localLayoutParams.leftMargin;
        i1 = params.getRight();
        i2 = localLayoutParams.rightMargin;
        i3 = params.getBottom();
        i3 = localLayoutParams.bottomMargin + i3;
        i4 = this.rIZ;
        this.ajR.setBounds(m - n, i3, i1 + i2, i4 + i3);
        this.ajR.draw(paramCanvas);
      }
      i += 1;
    }
    int m = paramRecyclerView.getChildCount();
    i = j;
    while (i < m)
    {
      params = paramRecyclerView.getChildAt(i);
      if ((paramRecyclerView.bh(params).ln() + 1) % r(paramRecyclerView) != 0)
      {
        localLayoutParams = (RecyclerView.LayoutParams)params.getLayoutParams();
        n = params.getTop();
        i1 = localLayoutParams.topMargin;
        i2 = params.getBottom();
        i3 = localLayoutParams.bottomMargin;
        i4 = this.rIZ;
        int i5 = params.getRight() + localLayoutParams.rightMargin;
        k = this.rJa + i5;
        j = k;
        if (i == m - 1) {
          j = k - this.rJa;
        }
        this.ajR.setBounds(i5, n - i1, j, i2 + i3 + i4);
        this.ajR.draw(paramCanvas);
      }
      i += 1;
    }
    AppMethodBeat.o(164809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.c
 * JD-Core Version:    0.7.0.1
 */