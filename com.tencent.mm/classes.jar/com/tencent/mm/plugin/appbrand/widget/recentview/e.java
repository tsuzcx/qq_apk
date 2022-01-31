package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.af;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends RecyclerView.m
{
  RecyclerView.r agY;
  private int ahA = -1;
  private float gFU = ViewConfiguration.get(ae.getContext()).getScaledTouchSlop();
  private boolean hDA = false;
  private boolean hDB = false;
  private boolean hDC = false;
  public BaseAppBrandRecentView hDp;
  public int hDq;
  public int hDr = 0;
  RecyclerView.r hDs;
  public int hDt;
  private e.b hDu = null;
  private boolean hDv = false;
  LinearLayoutManager hDw;
  public boolean hDx = false;
  e.a hDy = null;
  private int hDz = 0;
  private int hxB = 0;
  public int hxH = 0;
  Context mContext;
  public int mOffsetX;
  
  public e(int paramInt)
  {
    this.hxB = paramInt;
  }
  
  private int nl(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return this.hDt * paramInt + this.hxB;
  }
  
  private int nm(int paramInt)
  {
    if (this.hxB != 0)
    {
      int j = paramInt / this.hDt;
      int i = j;
      if (paramInt % this.hDt == 0)
      {
        i = j;
        if (paramInt != 0) {
          i = j - 1;
        }
      }
      return i;
    }
    return paramInt / this.hDt;
  }
  
  public static int nn(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    int i = b.getCompletelyCountPerPage();
    b.ark();
    return i * paramInt + 1;
  }
  
  public static int no(int paramInt)
  {
    int i = b.getCompletelyCountPerPage();
    b.ark();
    return (paramInt + 1) * i + 1;
  }
  
  public static int np(int paramInt)
  {
    int j = paramInt / b.getCompletelyCountPerPage();
    int i = j;
    if (paramInt % b.getCompletelyCountPerPage() == 0)
    {
      i = j;
      if (paramInt != 0) {
        i = j - 1;
      }
    }
    return i;
  }
  
  final void I(int paramInt, boolean paramBoolean)
  {
    if ((this.hDp != null) && ((this.hDB) || (paramBoolean)))
    {
      this.hDs.ahA = paramInt;
      this.hDC = true;
      this.hDp.getLayoutManager().a(this.hDs);
    }
  }
  
  public final void a(int paramInt, e.b paramb, boolean paramBoolean)
  {
    this.hDu = paramb;
    this.hDv = true;
    int i = nm(paramInt);
    this.ahA = nn(i);
    this.hxH = nm(this.hDw.gZ());
    y.i("ViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.hxH), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.ahA) });
    if ((i == this.hxH) && (!paramBoolean))
    {
      ata();
      return;
    }
    I(this.ahA, true);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.a(paramRecyclerView, paramInt1, paramInt2);
    this.hDr += paramInt1;
    if (this.hDy != null) {
      this.hDy.e(paramRecyclerView, this.hDr);
    }
    this.mOffsetX += paramInt1;
  }
  
  final void ata()
  {
    if (this.hDv)
    {
      y.i("ViewPagerHelper", "alvinluo onScrollAnimationEnd");
      if (this.hDu != null) {
        this.hDu.arA();
      }
      this.hDv = false;
      this.hDx = false;
      this.hDu = null;
      this.ahA = -1;
    }
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    super.c(paramRecyclerView, paramInt);
    y.i("ViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.hDy != null) {
      this.hDy.d(paramRecyclerView, paramInt, this.hDr);
    }
    int i;
    if ((paramInt == 0) && (this.hDz != 2))
    {
      i = nk(this.mOffsetX);
      if ((this.hDp != null) && (this.hDB))
      {
        this.agY.ahA = i;
        this.hDC = true;
        this.hDp.getLayoutManager().a(this.agY);
      }
      this.hDA = true;
    }
    for (;;)
    {
      this.hDz = paramInt;
      return;
      if ((!this.hDA) && (paramInt == 2))
      {
        this.hDA = true;
      }
      else if (paramInt == 0)
      {
        this.hDq = this.mOffsetX;
        this.hDA = false;
        i = this.hxH;
        int j = this.hDw.gY();
        y.i("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        boolean bool;
        if (j != -1)
        {
          this.hxH = (j / this.hDt);
          y.i("ViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.hxH), Integer.valueOf(j) });
          if ((i != this.hxH) && (this.hDy != null))
          {
            paramRecyclerView = this.hDy;
            i = this.hxH;
            if (!this.hDB)
            {
              bool = true;
              label270:
              paramRecyclerView.G(i, bool);
            }
          }
          else
          {
            label279:
            this.hDB = false;
            this.hDr = 0;
            if (!this.hDx) {
              break label387;
            }
            y.d("ViewPagerHelper", "alvinluo scrollMore");
            b.ark();
            this.hDx = false;
            a(0, this.hDu, true);
            ata();
          }
        }
        for (;;)
        {
          if (!this.hDC) {
            break label392;
          }
          y.i("ViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.hDC = false;
          this.hDp.scrollBy(-1, 0);
          break;
          bool = false;
          break label270;
          y.e("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.hxH) });
          break label279;
          label387:
          ata();
        }
      }
      else
      {
        label392:
        if (paramInt == 1)
        {
          y.i("ViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.hDB = true;
        }
      }
    }
  }
  
  final int nk(int paramInt)
  {
    int i = this.hxH;
    float f = this.hDp.getWidth();
    int k = this.hxH;
    y.d("ViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.hDq), Integer.valueOf(paramInt - this.hDq), Float.valueOf(f), Float.valueOf(this.gFU), Integer.valueOf(this.hxH) });
    if (paramInt - this.hDq >= f / 2.0F)
    {
      i = nm(this.hDw.ha());
      int m = this.hDp.getAdapter().getItemCount();
      int j = m / this.hDt;
      paramInt = j;
      if (m % this.hDt != 0) {
        paramInt = j + 1;
      }
      i = Math.max(Math.min(i, paramInt - 1), -1);
      if (i - k <= 1) {
        break label310;
      }
      paramInt = k + 1;
    }
    for (;;)
    {
      y.i("ViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(nn(paramInt)) });
      return nl(paramInt);
      if ((paramInt - this.hDq >= 0) && (paramInt - this.hDq < this.gFU))
      {
        y.i("ViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(nl(i)) });
        return nl(i);
      }
      if (paramInt - this.hDq > -f / 2.0F) {
        break;
      }
      i = nm(this.hDw.gY());
      break;
      label310:
      paramInt = i;
      if (k - i > 1) {
        paramInt = k - 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.e
 * JD-Core Version:    0.7.0.1
 */