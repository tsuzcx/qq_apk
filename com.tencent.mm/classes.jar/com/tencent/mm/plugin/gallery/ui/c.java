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
  private boolean CbQ;
  private int CbR;
  private int CbS;
  private Drawable sQ;
  
  private c(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(111507);
    this.CbR = paramInt1;
    this.CbQ = paramBoolean;
    this.CbS = paramInt2;
    this.sQ = new ColorDrawable(paramInt3);
    AppMethodBeat.o(111507);
  }
  
  private static boolean a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(244651);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    boolean bool;
    if ((paramRecyclerView instanceof GridLayoutManager))
    {
      bool = am(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(244651);
      return bool;
    }
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      if (((StaggeredGridLayoutManager)paramRecyclerView).mOrientation == 1)
      {
        bool = am(paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(244651);
        return bool;
      }
      if ((paramInt1 + 1) % paramInt2 == 0)
      {
        AppMethodBeat.o(244651);
        return true;
      }
    }
    AppMethodBeat.o(244651);
    return false;
  }
  
  private static boolean am(int paramInt1, int paramInt2, int paramInt3)
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
  
  private static int z(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(244650);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      i = ((GridLayoutManager)paramRecyclerView).ahF;
    }
    for (;;)
    {
      AppMethodBeat.o(244650);
      return i;
      if ((paramRecyclerView instanceof StaggeredGridLayoutManager)) {
        i = ((StaggeredGridLayoutManager)paramRecyclerView).ahF;
      } else {
        i = -1;
      }
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(244648);
    int i = z(paramRecyclerView);
    int n = paramRecyclerView.getAdapter().getItemCount();
    int i1 = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).aiC.mc();
    if (i1 < 0)
    {
      AppMethodBeat.o(244648);
      return;
    }
    int m = i1 % i;
    int j = this.CbS * m / i;
    int k = this.CbS;
    m = (m + 1) * this.CbS / i;
    if ((a(paramRecyclerView, i1, i, n)) && (!this.CbQ)) {}
    for (i = 0;; i = this.CbR)
    {
      paramRect.set(j, 0, k - m, i);
      AppMethodBeat.o(244648);
      return;
    }
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int j = 0;
    AppMethodBeat.i(244646);
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
      if ((!a(paramRecyclerView, i, z(paramRecyclerView), k)) || (this.CbQ))
      {
        localLayoutParams = (RecyclerView.LayoutParams)params.getLayoutParams();
        m = params.getLeft();
        n = localLayoutParams.leftMargin;
        i1 = params.getRight();
        i2 = localLayoutParams.rightMargin;
        i3 = params.getBottom();
        i3 = localLayoutParams.bottomMargin + i3;
        i4 = this.CbR;
        this.sQ.setBounds(m - n, i3, i1 + i2, i4 + i3);
        this.sQ.draw(paramCanvas);
      }
      i += 1;
    }
    int m = paramRecyclerView.getChildCount();
    i = j;
    while (i < m)
    {
      params = paramRecyclerView.getChildAt(i);
      if ((paramRecyclerView.aQ(params).md() + 1) % z(paramRecyclerView) != 0)
      {
        localLayoutParams = (RecyclerView.LayoutParams)params.getLayoutParams();
        n = params.getTop();
        i1 = localLayoutParams.topMargin;
        i2 = params.getBottom();
        i3 = localLayoutParams.bottomMargin;
        i4 = this.CbR;
        int i5 = params.getRight() + localLayoutParams.rightMargin;
        k = this.CbS + i5;
        j = k;
        if (i == m - 1) {
          j = k - this.CbS;
        }
        this.sQ.setBounds(i5, n - i1, j, i2 + i3 + i4);
        this.sQ.draw(paramCanvas);
      }
      i += 1;
    }
    AppMethodBeat.o(244646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.c
 * JD-Core Version:    0.7.0.1
 */