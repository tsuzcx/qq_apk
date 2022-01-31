package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.r;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class e
  extends RecyclerView.m
{
  private int ajQ;
  RecyclerView.r ajo;
  private float ifc;
  private int jfd;
  private int jpL;
  public int jpR;
  public BaseAppBrandRecentView jvQ;
  public int jvR;
  public int jvS;
  RecyclerView.r jvT;
  public int jvU;
  private e.b jvV;
  private boolean jvW;
  LinearLayoutManager jvX;
  public boolean jvY;
  e.a jvZ;
  private boolean jwa;
  private boolean jwb;
  private boolean jwc;
  Context mContext;
  public int mOffsetX;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(134392);
    this.jvS = 0;
    this.jpR = 0;
    this.ifc = ViewConfiguration.get(ah.getContext()).getScaledTouchSlop();
    this.jvV = null;
    this.ajQ = -1;
    this.jvW = false;
    this.jvY = false;
    this.jpL = 0;
    this.jvZ = null;
    this.jfd = 0;
    this.jwa = false;
    this.jwb = false;
    this.jwc = false;
    this.jpL = paramInt;
    AppMethodBeat.o(134392);
  }
  
  private void aSj()
  {
    this.jvW = false;
    this.jvY = false;
    this.jvV = null;
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
    AppMethodBeat.i(134399);
    if (paramInt == 0)
    {
      AppMethodBeat.o(134399);
      return 0;
    }
    int i = b.getCompletelyCountPerPage();
    b.aPh();
    AppMethodBeat.o(134399);
    return i * paramInt + 1;
  }
  
  public static int qV(int paramInt)
  {
    AppMethodBeat.i(134400);
    int i = b.getCompletelyCountPerPage();
    b.aPh();
    AppMethodBeat.o(134400);
    return (paramInt + 1) * i + 1;
  }
  
  public static int qW(int paramInt)
  {
    AppMethodBeat.i(134401);
    int j = paramInt / b.getCompletelyCountPerPage();
    int i = j;
    if (paramInt % b.getCompletelyCountPerPage() == 0)
    {
      i = j;
      if (paramInt != 0) {
        i = j - 1;
      }
    }
    AppMethodBeat.o(134401);
    return i;
  }
  
  final void N(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(134398);
    if ((this.jvQ != null) && ((this.jwb) || (paramBoolean)))
    {
      this.jvT.ajQ = paramInt;
      this.jwc = true;
      this.jvQ.getLayoutManager().a(this.jvT);
    }
    AppMethodBeat.o(134398);
  }
  
  public final void a(int paramInt, e.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(134397);
    this.jvV = paramb;
    this.jvW = true;
    int i = qT(paramInt);
    this.ajQ = qU(i);
    this.jpR = qT(this.jvX.iu());
    ab.i("ViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.jpR), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.ajQ) });
    if ((i == this.jpR) && (!paramBoolean))
    {
      aSk();
      AppMethodBeat.o(134397);
      return;
    }
    N(this.ajQ, true);
    AppMethodBeat.o(134397);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134393);
    super.a(paramRecyclerView, paramInt1, paramInt2);
    this.jvS += paramInt1;
    if (this.jvZ != null) {
      this.jvZ.e(paramRecyclerView, this.jvS);
    }
    this.mOffsetX += paramInt1;
    AppMethodBeat.o(134393);
  }
  
  final void aSk()
  {
    AppMethodBeat.i(134395);
    if (this.jvW)
    {
      ab.i("ViewPagerHelper", "alvinluo onScrollAnimationEnd");
      if (this.jvV != null) {
        this.jvV.aQl();
      }
      aSj();
    }
    AppMethodBeat.o(134395);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(134394);
    super.c(paramRecyclerView, paramInt);
    ab.i("ViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.jvZ != null) {
      this.jvZ.h(paramRecyclerView, paramInt, this.jvS);
    }
    int i;
    if ((paramInt == 0) && (this.jfd != 2))
    {
      i = qR(this.mOffsetX);
      if ((this.jvQ != null) && (this.jwb))
      {
        this.ajo.ajQ = i;
        this.jwc = true;
        this.jvQ.getLayoutManager().a(this.ajo);
      }
      this.jwa = true;
    }
    for (;;)
    {
      this.jfd = paramInt;
      AppMethodBeat.o(134394);
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
        ab.i("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        boolean bool;
        if (j != -1)
        {
          this.jpR = (j / this.jvU);
          ab.i("ViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.jpR), Integer.valueOf(j) });
          if ((i != this.jpR) && (this.jvZ != null))
          {
            paramRecyclerView = this.jvZ;
            i = this.jpR;
            if (!this.jwb)
            {
              bool = true;
              label280:
              paramRecyclerView.L(i, bool);
            }
          }
          else
          {
            label289:
            this.jwb = false;
            this.jvS = 0;
            if (!this.jvY) {
              break label397;
            }
            ab.d("ViewPagerHelper", "alvinluo scrollMore");
            b.aPh();
            this.jvY = false;
            a(0, this.jvV, true);
            aSk();
          }
        }
        for (;;)
        {
          if (!this.jwc) {
            break label402;
          }
          ab.i("ViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.jwc = false;
          this.jvQ.scrollBy(-1, 0);
          break;
          bool = false;
          break label280;
          ab.e("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.jpR) });
          break label289;
          label397:
          aSk();
        }
      }
      else
      {
        label402:
        if (paramInt == 1)
        {
          ab.i("ViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.jwb = true;
        }
      }
    }
  }
  
  final int qR(int paramInt)
  {
    AppMethodBeat.i(134396);
    int i = this.jpR;
    float f = this.jvQ.getWidth();
    int k = this.jpR;
    ab.d("ViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jvR), Integer.valueOf(paramInt - this.jvR), Float.valueOf(f), Float.valueOf(this.ifc), Integer.valueOf(this.jpR) });
    if (paramInt - this.jvR >= f / 2.0F)
    {
      i = qT(this.jvX.iv());
      int m = this.jvQ.getAdapter().getItemCount();
      int j = m / this.jvU;
      paramInt = j;
      if (m % this.jvU != 0) {
        paramInt = j + 1;
      }
      i = Math.max(Math.min(i, paramInt - 1), -1);
      if (i - k <= 1) {
        break label330;
      }
      paramInt = k + 1;
    }
    for (;;)
    {
      ab.i("ViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(qU(paramInt)) });
      paramInt = qS(paramInt);
      AppMethodBeat.o(134396);
      return paramInt;
      if ((paramInt - this.jvR >= 0) && (paramInt - this.jvR < this.ifc))
      {
        ab.i("ViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(qS(i)) });
        paramInt = qS(i);
        AppMethodBeat.o(134396);
        return paramInt;
      }
      if (paramInt - this.jvR > -f / 2.0F) {
        break;
      }
      i = qT(this.jvX.it());
      break;
      label330:
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