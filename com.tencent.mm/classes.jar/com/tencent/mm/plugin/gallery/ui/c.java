package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends RecyclerView.h
{
  private boolean HNS;
  private int HNT;
  private int HNU;
  private Drawable tP;
  
  private c(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(111507);
    this.HNT = paramInt1;
    this.HNS = paramBoolean;
    this.HNU = paramInt2;
    this.tP = new ColorDrawable(paramInt3);
    AppMethodBeat.o(111507);
  }
  
  private static int I(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(289495);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      i = ((GridLayoutManager)paramRecyclerView).bWl;
    }
    for (;;)
    {
      AppMethodBeat.o(289495);
      return i;
      if ((paramRecyclerView instanceof StaggeredGridLayoutManager)) {
        i = ((StaggeredGridLayoutManager)paramRecyclerView).bWl;
      } else {
        i = -1;
      }
    }
  }
  
  private static boolean a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(289498);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    boolean bool;
    if ((paramRecyclerView instanceof GridLayoutManager))
    {
      bool = aI(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(289498);
      return bool;
    }
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      if (((StaggeredGridLayoutManager)paramRecyclerView).mOrientation == 1)
      {
        bool = aI(paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(289498);
        return bool;
      }
      if ((paramInt1 + 1) % paramInt2 == 0)
      {
        AppMethodBeat.o(289498);
        return true;
      }
    }
    AppMethodBeat.o(289498);
    return false;
  }
  
  private static boolean aI(int paramInt1, int paramInt2, int paramInt3)
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
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(289511);
    int i = I(paramRecyclerView);
    int n = paramRecyclerView.getAdapter().getItemCount();
    int i1 = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).bXh.KI();
    if (i1 < 0)
    {
      AppMethodBeat.o(289511);
      return;
    }
    int m = i1 % i;
    int j = this.HNU * m / i;
    int k = this.HNU;
    m = (m + 1) * this.HNU / i;
    if ((a(paramRecyclerView, i1, i, n)) && (!this.HNS)) {}
    for (i = 0;; i = this.HNT)
    {
      paramRect.set(j, 0, k - m, i);
      AppMethodBeat.o(289511);
      return;
    }
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int j = 0;
    AppMethodBeat.i(289508);
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
      if ((!a(paramRecyclerView, i, I(paramRecyclerView), k)) || (this.HNS))
      {
        localLayoutParams = (RecyclerView.LayoutParams)params.getLayoutParams();
        m = params.getLeft();
        n = localLayoutParams.leftMargin;
        i1 = params.getRight();
        i2 = localLayoutParams.rightMargin;
        i3 = params.getBottom();
        i3 = localLayoutParams.bottomMargin + i3;
        i4 = this.HNT;
        this.tP.setBounds(m - n, i3, i1 + i2, i4 + i3);
        this.tP.draw(paramCanvas);
      }
      i += 1;
    }
    int m = paramRecyclerView.getChildCount();
    i = j;
    while (i < m)
    {
      params = paramRecyclerView.getChildAt(i);
      if ((paramRecyclerView.bj(params).KJ() + 1) % I(paramRecyclerView) != 0)
      {
        localLayoutParams = (RecyclerView.LayoutParams)params.getLayoutParams();
        n = params.getTop();
        i1 = localLayoutParams.topMargin;
        i2 = params.getBottom();
        i3 = localLayoutParams.bottomMargin;
        i4 = this.HNT;
        int i5 = params.getRight() + localLayoutParams.rightMargin;
        k = this.HNU + i5;
        j = k;
        if (i == m - 1) {
          j = k - this.HNU;
        }
        this.tP.setBounds(i5, n - i1, j, i2 + i3 + i4);
        this.tP.draw(paramCanvas);
      }
      i += 1;
    }
    AppMethodBeat.o(289508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.c
 * JD-Core Version:    0.7.0.1
 */