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
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends RecyclerView.h
{
  private Drawable amC;
  private boolean tYi;
  private int tYj;
  private int tYk;
  
  private c(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(111507);
    this.tYj = paramInt1;
    this.tYi = paramBoolean;
    this.tYk = paramInt2;
    this.amC = new ColorDrawable(paramInt3);
    AppMethodBeat.o(111507);
  }
  
  private static boolean ae(int paramInt1, int paramInt2, int paramInt3)
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
  
  private static boolean c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111511);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    boolean bool;
    if ((paramRecyclerView instanceof GridLayoutManager))
    {
      bool = ae(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(111511);
      return bool;
    }
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      if (((StaggeredGridLayoutManager)paramRecyclerView).mOrientation == 1)
      {
        bool = ae(paramInt1, paramInt2, paramInt3);
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
  
  private static int z(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(111510);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      i = ((GridLayoutManager)paramRecyclerView).apA;
    }
    for (;;)
    {
      AppMethodBeat.o(111510);
      return i;
      if ((paramRecyclerView instanceof StaggeredGridLayoutManager)) {
        i = ((StaggeredGridLayoutManager)paramRecyclerView).apA;
      } else {
        i = -1;
      }
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(111509);
    int i = z(paramRecyclerView);
    int n = paramRecyclerView.getAdapter().getItemCount();
    int i1 = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).aty.lM();
    if (i1 < 0)
    {
      AppMethodBeat.o(111509);
      return;
    }
    int m = i1 % i;
    int j = this.tYk * m / i;
    int k = this.tYk;
    m = (m + 1) * this.tYk / i;
    if ((c(paramRecyclerView, i1, i, n)) && (!this.tYi)) {}
    for (i = 0;; i = this.tYj)
    {
      paramRect.set(j, 0, k - m, i);
      AppMethodBeat.o(111509);
      return;
    }
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
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
      paramt = paramRecyclerView.getChildAt(i);
      if ((!c(paramRecyclerView, i, z(paramRecyclerView), k)) || (this.tYi))
      {
        localLayoutParams = (RecyclerView.LayoutParams)paramt.getLayoutParams();
        m = paramt.getLeft();
        n = localLayoutParams.leftMargin;
        i1 = paramt.getRight();
        i2 = localLayoutParams.rightMargin;
        i3 = paramt.getBottom();
        i3 = localLayoutParams.bottomMargin + i3;
        i4 = this.tYj;
        this.amC.setBounds(m - n, i3, i1 + i2, i4 + i3);
        this.amC.draw(paramCanvas);
      }
      i += 1;
    }
    int m = paramRecyclerView.getChildCount();
    i = j;
    while (i < m)
    {
      paramt = paramRecyclerView.getChildAt(i);
      if ((paramRecyclerView.bh(paramt).lN() + 1) % z(paramRecyclerView) != 0)
      {
        localLayoutParams = (RecyclerView.LayoutParams)paramt.getLayoutParams();
        n = paramt.getTop();
        i1 = localLayoutParams.topMargin;
        i2 = paramt.getBottom();
        i3 = localLayoutParams.bottomMargin;
        i4 = this.tYj;
        int i5 = paramt.getRight() + localLayoutParams.rightMargin;
        k = this.tYk + i5;
        j = k;
        if (i == m - 1) {
          j = k - this.tYk;
        }
        this.amC.setBounds(i5, n - i1, j, i2 + i3 + i4);
        this.amC.draw(paramCanvas);
      }
      i += 1;
    }
    AppMethodBeat.o(164809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.c
 * JD-Core Version:    0.7.0.1
 */