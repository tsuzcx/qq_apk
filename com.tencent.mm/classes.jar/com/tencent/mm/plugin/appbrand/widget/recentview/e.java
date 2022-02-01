package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class e
  extends RecyclerView.m
{
  private int atQ;
  RecyclerView.s atl;
  private float ltS;
  Context mContext;
  public int mOffsetX;
  private int mXO;
  private int nib;
  public int nih;
  public BaseAppBrandRecentView noA;
  public int noB;
  public int noC;
  RecyclerView.s noD;
  public int noE;
  private b noF;
  private boolean noG;
  LinearLayoutManager noH;
  public boolean noI;
  a noJ;
  private boolean noK;
  private boolean noL;
  private boolean noM;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(50012);
    this.noC = 0;
    this.nih = 0;
    this.ltS = ViewConfiguration.get(aj.getContext()).getScaledTouchSlop();
    this.noF = null;
    this.atQ = -1;
    this.noG = false;
    this.noI = false;
    this.nib = 0;
    this.noJ = null;
    this.mXO = 0;
    this.noK = false;
    this.noL = false;
    this.noM = false;
    this.nib = paramInt;
    AppMethodBeat.o(50012);
  }
  
  private void bFE()
  {
    this.noG = false;
    this.noI = false;
    this.noF = null;
    this.atQ = -1;
  }
  
  private int wS(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return this.noE * paramInt + this.nib;
  }
  
  private int wT(int paramInt)
  {
    if (this.nib != 0)
    {
      int j = paramInt / this.noE;
      int i = j;
      if (paramInt % this.noE == 0)
      {
        i = j;
        if (paramInt != 0) {
          i = j - 1;
        }
      }
      return i;
    }
    return paramInt / this.noE;
  }
  
  public static int wU(int paramInt)
  {
    AppMethodBeat.i(50019);
    if (paramInt == 0)
    {
      AppMethodBeat.o(50019);
      return 0;
    }
    int i = com.tencent.mm.plugin.appbrand.widget.desktop.b.getCompletelyCountPerPage();
    com.tencent.mm.plugin.appbrand.widget.desktop.b.bCI();
    AppMethodBeat.o(50019);
    return i * paramInt + 1;
  }
  
  public static int wV(int paramInt)
  {
    AppMethodBeat.i(50020);
    int i = com.tencent.mm.plugin.appbrand.widget.desktop.b.getCompletelyCountPerPage();
    com.tencent.mm.plugin.appbrand.widget.desktop.b.bCI();
    AppMethodBeat.o(50020);
    return (paramInt + 1) * i + 1;
  }
  
  public static int wW(int paramInt)
  {
    AppMethodBeat.i(50021);
    int j = paramInt / com.tencent.mm.plugin.appbrand.widget.desktop.b.getCompletelyCountPerPage();
    int i = j;
    if (paramInt % com.tencent.mm.plugin.appbrand.widget.desktop.b.getCompletelyCountPerPage() == 0)
    {
      i = j;
      if (paramInt != 0) {
        i = j - 1;
      }
    }
    AppMethodBeat.o(50021);
    return i;
  }
  
  final void O(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(50018);
    if ((this.noA != null) && ((this.noL) || (paramBoolean)))
    {
      this.noD.atQ = paramInt;
      this.noM = true;
      this.noA.getLayoutManager().a(this.noD);
    }
    AppMethodBeat.o(50018);
  }
  
  public final void a(int paramInt, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(50017);
    this.noF = paramb;
    this.noG = true;
    int i = wT(paramInt);
    this.atQ = wU(i);
    this.nih = wT(this.noH.kn());
    ad.i("ViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.nih), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.atQ) });
    if ((i == this.nih) && (!paramBoolean))
    {
      bFF();
      AppMethodBeat.o(50017);
      return;
    }
    O(this.atQ, true);
    AppMethodBeat.o(50017);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50013);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramRecyclerView);
    localb.mr(paramInt1);
    localb.mr(paramInt2);
    a.b("com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
    super.a(paramRecyclerView, paramInt1, paramInt2);
    this.noC += paramInt1;
    if (this.noJ != null) {
      this.noJ.d(paramRecyclerView, this.noC);
    }
    this.mOffsetX += paramInt1;
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(50013);
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(50014);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramRecyclerView);
    localb.mr(paramInt);
    a.b("com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
    super.b(paramRecyclerView, paramInt);
    ad.i("ViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.noJ != null) {
      this.noJ.h(paramRecyclerView, paramInt, this.noC);
    }
    int i;
    if ((paramInt == 0) && (this.mXO != 2))
    {
      i = wR(this.mOffsetX);
      if ((this.noA != null) && (this.noL))
      {
        this.atl.atQ = i;
        this.noM = true;
        this.noA.getLayoutManager().a(this.atl);
      }
      this.noK = true;
    }
    for (;;)
    {
      this.mXO = paramInt;
      a.a(this, "com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(50014);
      return;
      if ((!this.noK) && (paramInt == 2))
      {
        this.noK = true;
      }
      else if (paramInt == 0)
      {
        this.noB = this.mOffsetX;
        this.noK = false;
        i = this.nih;
        int j = this.noH.km();
        ad.i("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        boolean bool;
        if (j != -1)
        {
          this.nih = (j / this.noE);
          ad.i("ViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.nih), Integer.valueOf(j) });
          if ((i != this.nih) && (this.noJ != null))
          {
            paramRecyclerView = this.noJ;
            i = this.nih;
            if (!this.noL)
            {
              bool = true;
              label330:
              paramRecyclerView.M(i, bool);
            }
          }
          else
          {
            label339:
            this.noL = false;
            this.noC = 0;
            if (!this.noI) {
              break label448;
            }
            ad.d("ViewPagerHelper", "alvinluo scrollMore");
            com.tencent.mm.plugin.appbrand.widget.desktop.b.bCI();
            this.noI = false;
            a(0, this.noF, true);
            bFF();
          }
        }
        for (;;)
        {
          if (!this.noM) {
            break label453;
          }
          ad.i("ViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.noM = false;
          this.noA.scrollBy(-1, 0);
          break;
          bool = false;
          break label330;
          ad.e("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.nih) });
          break label339;
          label448:
          bFF();
        }
      }
      else
      {
        label453:
        if (paramInt == 1)
        {
          ad.i("ViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.noL = true;
        }
      }
    }
  }
  
  final void bFF()
  {
    AppMethodBeat.i(50015);
    if (this.noG)
    {
      ad.i("ViewPagerHelper", "alvinluo onScrollAnimationEnd");
      if (this.noF != null) {
        this.noF.bDw();
      }
      bFE();
    }
    AppMethodBeat.o(50015);
  }
  
  final int wR(int paramInt)
  {
    AppMethodBeat.i(50016);
    int i = this.nih;
    float f = this.noA.getWidth();
    int k = this.nih;
    ad.d("ViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.noB), Integer.valueOf(paramInt - this.noB), Float.valueOf(f), Float.valueOf(this.ltS), Integer.valueOf(this.nih) });
    if (paramInt - this.noB >= f / 2.0F)
    {
      i = wT(this.noH.ko());
      int m = this.noA.getAdapter().getItemCount();
      int j = m / this.noE;
      paramInt = j;
      if (m % this.noE != 0) {
        paramInt = j + 1;
      }
      i = Math.max(Math.min(i, paramInt - 1), -1);
      if (i - k <= 1) {
        break label334;
      }
      paramInt = k + 1;
    }
    for (;;)
    {
      ad.i("ViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(wU(paramInt)) });
      paramInt = wS(paramInt);
      AppMethodBeat.o(50016);
      return paramInt;
      if ((paramInt - this.noB >= 0) && (paramInt - this.noB < this.ltS))
      {
        ad.i("ViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(wS(i)) });
        paramInt = wS(i);
        AppMethodBeat.o(50016);
        return paramInt;
      }
      if (paramInt - this.noB > -f / 2.0F) {
        break;
      }
      i = wT(this.noH.km());
      break;
      label334:
      paramInt = i;
      if (k - i > 1) {
        paramInt = k - 1;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void M(int paramInt, boolean paramBoolean);
    
    public abstract void d(RecyclerView paramRecyclerView, int paramInt);
    
    public abstract void h(RecyclerView paramRecyclerView, int paramInt1, int paramInt2);
  }
  
  public static abstract interface b
  {
    public abstract void bDw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.e
 * JD-Core Version:    0.7.0.1
 */