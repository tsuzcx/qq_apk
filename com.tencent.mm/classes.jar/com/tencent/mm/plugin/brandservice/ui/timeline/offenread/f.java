package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.r;
import android.view.ViewConfiguration;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends RecyclerView.m
{
  RecyclerView.r agY;
  private int ahA = -1;
  private float gFU = ViewConfiguration.get(ae.getContext()).getScaledTouchSlop();
  private boolean hDA = false;
  private boolean hDB = false;
  private boolean hDC = false;
  private int hDq;
  private int hDr = 0;
  RecyclerView.r hDs;
  int hDt;
  private boolean hDv = false;
  LinearLayoutManager hDw;
  private boolean hDx = false;
  private int hDz = 0;
  private int hxB = 0;
  int hxH = 0;
  BizTimeLineHotListView ihL;
  private f.b ihM = null;
  f.a ihN = null;
  Context mContext;
  int mOffsetX;
  
  public f(int paramInt)
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
    return a.getCompletelyCountPerPage() * paramInt + 1;
  }
  
  public static int no(int paramInt)
  {
    return (paramInt + 1) * a.getCompletelyCountPerPage() + 1;
  }
  
  final void I(int paramInt, boolean paramBoolean)
  {
    if ((this.ihL != null) && ((this.hDB) || (paramBoolean)))
    {
      this.hDs.ahA = paramInt;
      this.hDC = true;
      this.ihL.getLayoutManager().a(this.hDs);
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.a(paramRecyclerView, paramInt1, paramInt2);
    this.hDr += paramInt1;
    if ((this.ihN != null) && ((paramInt1 != 0) || (paramInt2 != 0))) {
      this.ihN.oA(this.hDr);
    }
    this.mOffsetX += paramInt1;
  }
  
  final void ata()
  {
    if (this.hDv)
    {
      y.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollAnimationEnd");
      this.hDv = false;
      this.hDx = false;
      this.ihM = null;
      this.ahA = -1;
    }
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    super.c(paramRecyclerView, paramInt);
    y.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if ((paramInt == 0) && (this.hDz != 2))
    {
      i = nk(this.mOffsetX);
      if ((this.ihL != null) && (this.hDB))
      {
        this.agY.ahA = i;
        this.hDC = true;
        this.ihL.getLayoutManager().a(this.agY);
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
        y.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        boolean bool;
        if (j != -1)
        {
          this.hxH = (j / this.hDt);
          y.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.hxH), Integer.valueOf(j) });
          if ((i != this.hxH) && (this.ihN != null))
          {
            paramRecyclerView = this.ihN;
            if (!this.hDB)
            {
              bool = true;
              label243:
              paramRecyclerView.eu(bool);
            }
          }
          else
          {
            label251:
            this.hDB = false;
            this.hDr = 0;
            if (!this.hDx) {
              break label570;
            }
            y.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollMore");
            this.ihL.getAdapter().ah(this.ihL.getDataCount(), 5);
            paramRecyclerView = this.ihM;
            this.hDx = false;
            int k = this.ihL.getDataCount();
            j = k / this.hDt;
            i = j;
            if (k % this.hDt == 0) {
              i = j + 1;
            }
            int m = i + 1;
            j = this.hDt * m;
            i = j;
            if (j <= 0) {
              i = 0;
            }
            y.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo smoothScrollToLastPage allCount: %d, lastPage: %d, targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
            this.ihM = paramRecyclerView;
            this.hDv = true;
            j = nm(i);
            this.ahA = nn(j);
            this.hxH = nm(this.hDw.gZ());
            y.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.hxH), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.ahA) });
            if (j != this.hxH) {
              break label558;
            }
            ata();
          }
        }
        for (;;)
        {
          if (!this.hDC) {
            break label575;
          }
          y.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.hDC = false;
          this.ihL.scrollBy(-1, 0);
          break;
          bool = false;
          break label243;
          y.e("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.hxH) });
          break label251;
          label558:
          I(this.ahA, true);
          continue;
          label570:
          ata();
        }
      }
      else
      {
        label575:
        if (paramInt == 1)
        {
          y.i("MicroMsg.BizTimeLineViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.hDB = true;
        }
      }
    }
  }
  
  final int nk(int paramInt)
  {
    int i = this.hxH;
    float f = this.ihL.getWidth();
    int k = this.hxH;
    y.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.hDq), Integer.valueOf(paramInt - this.hDq), Float.valueOf(f), Float.valueOf(this.gFU), Integer.valueOf(this.hxH) });
    if (paramInt - this.hDq >= f / 2.0F)
    {
      i = nm(this.hDw.ha());
      int m = this.ihL.getAdapter().getItemCount();
      int j = m / this.hDt;
      paramInt = j;
      if (m % this.hDt != 0) {
        paramInt = j + 1;
      }
      i = Math.max(Math.min(i, paramInt - 1), -1);
      if (i - k <= 1) {
        break label309;
      }
      paramInt = k + 1;
    }
    for (;;)
    {
      y.i("MicroMsg.BizTimeLineViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(nn(paramInt)) });
      return nl(paramInt);
      if ((paramInt - this.hDq >= 0) && (paramInt - this.hDq < this.gFU))
      {
        y.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(nl(i)) });
        return nl(i);
      }
      if (paramInt - this.hDq > -f / 2.0F) {
        break;
      }
      i = nm(this.hDw.gY());
      break;
      label309:
      paramInt = i;
      if (k - i > 1) {
        paramInt = k - 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f
 * JD-Core Version:    0.7.0.1
 */