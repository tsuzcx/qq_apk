package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.r;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class f
  extends RecyclerView.m
{
  private int ajQ;
  RecyclerView.r ajo;
  private float ifc;
  f.a jZA;
  BizTimeLineHotListView jZy;
  private f.b jZz;
  private int jfd;
  private int jpL;
  int jpR;
  private int jvR;
  private int jvS;
  RecyclerView.r jvT;
  int jvU;
  private boolean jvW;
  LinearLayoutManager jvX;
  private boolean jvY;
  private boolean jwa;
  private boolean jwb;
  private boolean jwc;
  Context mContext;
  int mOffsetX;
  
  public f(int paramInt)
  {
    AppMethodBeat.i(14351);
    this.jvS = 0;
    this.jpR = 0;
    this.ifc = ViewConfiguration.get(ah.getContext()).getScaledTouchSlop();
    this.jZz = null;
    this.ajQ = -1;
    this.jvW = false;
    this.jvY = false;
    this.jpL = 0;
    this.jZA = null;
    this.jfd = 0;
    this.jwa = false;
    this.jwb = false;
    this.jwc = false;
    this.jpL = paramInt;
    AppMethodBeat.o(14351);
  }
  
  private void aSj()
  {
    this.jvW = false;
    this.jvY = false;
    this.jZz = null;
    this.ajQ = -1;
  }
  
  private int qS(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return this.jvU * paramInt + this.jpL;
  }
  
  private int qT(int paramInt)
  {
    if (this.jpL != 0)
    {
      int j = paramInt / this.jvU;
      int i = j;
      if (paramInt % this.jvU == 0)
      {
        i = j;
        if (paramInt != 0) {
          i = j - 1;
        }
      }
      return i;
    }
    return paramInt / this.jvU;
  }
  
  public static int qU(int paramInt)
  {
    AppMethodBeat.i(14357);
    if (paramInt == 0)
    {
      AppMethodBeat.o(14357);
      return 0;
    }
    int i = a.getCompletelyCountPerPage();
    AppMethodBeat.o(14357);
    return i * paramInt + 1;
  }
  
  public static int qV(int paramInt)
  {
    AppMethodBeat.i(14358);
    int i = a.getCompletelyCountPerPage();
    AppMethodBeat.o(14358);
    return (paramInt + 1) * i + 1;
  }
  
  final void N(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(14356);
    if ((this.jZy != null) && ((this.jwb) || (paramBoolean)))
    {
      this.jvT.ajQ = paramInt;
      this.jwc = true;
      this.jZy.getLayoutManager().a(this.jvT);
    }
    AppMethodBeat.o(14356);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14352);
    super.a(paramRecyclerView, paramInt1, paramInt2);
    this.jvS += paramInt1;
    if ((this.jZA != null) && ((paramInt1 != 0) || (paramInt2 != 0))) {
      this.jZA.sh(this.jvS);
    }
    this.mOffsetX += paramInt1;
    AppMethodBeat.o(14352);
  }
  
  final void aSk()
  {
    AppMethodBeat.i(14354);
    if (this.jvW)
    {
      ab.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollAnimationEnd");
      aSj();
    }
    AppMethodBeat.o(14354);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(14353);
    super.c(paramRecyclerView, paramInt);
    ab.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if ((paramInt == 0) && (this.jfd != 2))
    {
      i = qR(this.mOffsetX);
      if ((this.jZy != null) && (this.jwb))
      {
        this.ajo.ajQ = i;
        this.jwc = true;
        this.jZy.getLayoutManager().a(this.ajo);
      }
      this.jwa = true;
    }
    for (;;)
    {
      this.jfd = paramInt;
      AppMethodBeat.o(14353);
      return;
      if ((!this.jwa) && (paramInt == 2))
      {
        this.jwa = true;
      }
      else if (paramInt == 0)
      {
        this.jvR = this.mOffsetX;
        this.jwa = false;
        i = this.jpR;
        int j = this.jvX.it();
        ab.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        boolean bool;
        if (j != -1)
        {
          this.jpR = (j / this.jvU);
          ab.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.jpR), Integer.valueOf(j) });
          if ((i != this.jpR) && (this.jZA != null))
          {
            paramRecyclerView = this.jZA;
            if (!this.jwb)
            {
              bool = true;
              label255:
              paramRecyclerView.fM(bool);
            }
          }
          else
          {
            label263:
            this.jwb = false;
            this.jvS = 0;
            if (!this.jvY) {
              break label582;
            }
            ab.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollMore");
            this.jZy.getAdapter().an(this.jZy.getDataCount(), 5);
            paramRecyclerView = this.jZz;
            this.jvY = false;
            int k = this.jZy.getDataCount();
            j = k / this.jvU;
            i = j;
            if (k % this.jvU == 0) {
              i = j + 1;
            }
            int m = i + 1;
            j = this.jvU * m;
            i = j;
            if (j <= 0) {
              i = 0;
            }
            ab.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo smoothScrollToLastPage allCount: %d, lastPage: %d, targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
            this.jZz = paramRecyclerView;
            this.jvW = true;
            j = qT(i);
            this.ajQ = qU(j);
            this.jpR = qT(this.jvX.iu());
            ab.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.jpR), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.ajQ) });
            if (j != this.jpR) {
              break label570;
            }
            aSk();
          }
        }
        for (;;)
        {
          if (!this.jwc) {
            break label587;
          }
          ab.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.jwc = false;
          this.jZy.scrollBy(-1, 0);
          break;
          bool = false;
          break label255;
          ab.e("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.jpR) });
          break label263;
          label570:
          N(this.ajQ, true);
          continue;
          label582:
          aSk();
        }
      }
      else
      {
        label587:
        if (paramInt == 1)
        {
          ab.i("MicroMsg.BizTimeLineViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.jwb = true;
        }
      }
    }
  }
  
  final int qR(int paramInt)
  {
    AppMethodBeat.i(14355);
    int i = this.jpR;
    float f = this.jZy.getWidth();
    int k = this.jpR;
    ab.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jvR), Integer.valueOf(paramInt - this.jvR), Float.valueOf(f), Float.valueOf(this.ifc), Integer.valueOf(this.jpR) });
    if (paramInt - this.jvR >= f / 2.0F)
    {
      i = qT(this.jvX.iv());
      int m = this.jZy.getAdapter().getItemCount();
      int j = m / this.jvU;
      paramInt = j;
      if (m % this.jvU != 0) {
        paramInt = j + 1;
      }
      i = Math.max(Math.min(i, paramInt - 1), -1);
      if (i - k <= 1) {
        break label333;
      }
      paramInt = k + 1;
    }
    for (;;)
    {
      ab.i("MicroMsg.BizTimeLineViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(qU(paramInt)) });
      paramInt = qS(paramInt);
      AppMethodBeat.o(14355);
      return paramInt;
      if ((paramInt - this.jvR >= 0) && (paramInt - this.jvR < this.ifc))
      {
        ab.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(qS(i)) });
        paramInt = qS(i);
        AppMethodBeat.o(14355);
        return paramInt;
      }
      if (paramInt - this.jvR > -f / 2.0F) {
        break;
      }
      i = qT(this.jvX.it());
      break;
      label333:
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