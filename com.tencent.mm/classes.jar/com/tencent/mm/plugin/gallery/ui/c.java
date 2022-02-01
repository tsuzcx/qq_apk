package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
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
  private Drawable amP;
  private boolean xpw;
  private int xpx;
  private int xpy;
  
  private c(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(111507);
    this.xpx = paramInt1;
    this.xpw = paramBoolean;
    this.xpy = paramInt2;
    this.amP = new ColorDrawable(paramInt3);
    AppMethodBeat.o(111507);
  }
  
  private static boolean a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111511);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    boolean bool;
    if ((paramRecyclerView instanceof GridLayoutManager))
    {
      bool = aj(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(111511);
      return bool;
    }
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      if (((StaggeredGridLayoutManager)paramRecyclerView).mOrientation == 1)
      {
        bool = aj(paramInt1, paramInt2, paramInt3);
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
  
  private static boolean aj(int paramInt1, int paramInt2, int paramInt3)
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
  
  private static int u(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(111510);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      i = ((GridLayoutManager)paramRecyclerView).apM;
    }
    for (;;)
    {
      AppMethodBeat.o(111510);
      return i;
      if ((paramRecyclerView instanceof StaggeredGridLayoutManager)) {
        i = ((StaggeredGridLayoutManager)paramRecyclerView).apM;
      } else {
        i = -1;
      }
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(111509);
    int i = u(paramRecyclerView);
    int n = paramRecyclerView.getAdapter().getItemCount();
    int i1 = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).atw.lQ();
    if (i1 < 0)
    {
      AppMethodBeat.o(111509);
      return;
    }
    int m = i1 % i;
    int j = this.xpy * m / i;
    int k = this.xpy;
    m = (m + 1) * this.xpy / i;
    if ((a(paramRecyclerView, i1, i, n)) && (!this.xpw)) {}
    for (i = 0;; i = this.xpx)
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
      if ((!a(paramRecyclerView, i, u(paramRecyclerView), k)) || (this.xpw))
      {
        localLayoutParams = (RecyclerView.LayoutParams)params.getLayoutParams();
        m = params.getLeft();
        n = localLayoutParams.leftMargin;
        i1 = params.getRight();
        i2 = localLayoutParams.rightMargin;
        i3 = params.getBottom();
        i3 = localLayoutParams.bottomMargin + i3;
        i4 = this.xpx;
        this.amP.setBounds(m - n, i3, i1 + i2, i4 + i3);
        this.amP.draw(paramCanvas);
      }
      i += 1;
    }
    int m = paramRecyclerView.getChildCount();
    i = j;
    while (i < m)
    {
      params = paramRecyclerView.getChildAt(i);
      if ((paramRecyclerView.bi(params).lR() + 1) % u(paramRecyclerView) != 0)
      {
        localLayoutParams = (RecyclerView.LayoutParams)params.getLayoutParams();
        n = params.getTop();
        i1 = localLayoutParams.topMargin;
        i2 = params.getBottom();
        i3 = localLayoutParams.bottomMargin;
        i4 = this.xpx;
        int i5 = params.getRight() + localLayoutParams.rightMargin;
        k = this.xpy + i5;
        j = k;
        if (i == m - 1) {
          j = k - this.xpy;
        }
        this.amP.setBounds(i5, n - i1, j, i2 + i3 + i4);
        this.amP.draw(paramCanvas);
      }
      i += 1;
    }
    AppMethodBeat.o(164809);
  }
  
  public static final class a
  {
    private int mColor;
    private Context mContext;
    private Resources mResources;
    boolean xpw;
    private int xpx;
    private int xpy;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(111506);
      this.mContext = paramContext;
      this.mResources = paramContext.getResources();
      this.xpw = true;
      this.xpx = 0;
      this.xpy = 0;
      this.mColor = -1;
      AppMethodBeat.o(111506);
    }
    
    public final a NO(int paramInt)
    {
      AppMethodBeat.i(257749);
      this.xpy = this.mResources.getDimensionPixelSize(paramInt);
      AppMethodBeat.o(257749);
      return this;
    }
    
    public final a NP(int paramInt)
    {
      AppMethodBeat.i(257750);
      this.xpx = this.mResources.getDimensionPixelSize(paramInt);
      AppMethodBeat.o(257750);
      return this;
    }
    
    public final a dSd()
    {
      AppMethodBeat.i(257748);
      this.mColor = b.n(this.mContext, 2131100500);
      AppMethodBeat.o(257748);
      return this;
    }
    
    public final a dSe()
    {
      this.xpw = false;
      return this;
    }
    
    public final c dSf()
    {
      AppMethodBeat.i(257751);
      c localc = new c(this.xpx, this.xpy, this.mColor, this.xpw, (byte)0);
      AppMethodBeat.o(257751);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.c
 * JD-Core Version:    0.7.0.1
 */