package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.s;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.ak;

public final class e
  extends RecyclerView.m
{
  private int atQ;
  RecyclerView.s atl;
  private float lyr;
  Context mContext;
  public int mOffsetX;
  private int ncV;
  private int nnj;
  public int nnp;
  public BaseAppBrandRecentView ntK;
  public int ntL;
  public int ntM;
  RecyclerView.s ntN;
  public int ntO;
  private b ntP;
  private boolean ntQ;
  LinearLayoutManager ntR;
  public boolean ntS;
  a ntT;
  private boolean ntU;
  private boolean ntV;
  private boolean ntW;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(50012);
    this.ntM = 0;
    this.nnp = 0;
    this.lyr = ViewConfiguration.get(ak.getContext()).getScaledTouchSlop();
    this.ntP = null;
    this.atQ = -1;
    this.ntQ = false;
    this.ntS = false;
    this.nnj = 0;
    this.ntT = null;
    this.ncV = 0;
    this.ntU = false;
    this.ntV = false;
    this.ntW = false;
    this.nnj = paramInt;
    AppMethodBeat.o(50012);
  }
  
  private void bGz()
  {
    this.ntQ = false;
    this.ntS = false;
    this.ntP = null;
    this.atQ = -1;
  }
  
  private int wX(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return this.ntO * paramInt + this.nnj;
  }
  
  private int wY(int paramInt)
  {
    if (this.nnj != 0)
    {
      int j = paramInt / this.ntO;
      int i = j;
      if (paramInt % this.ntO == 0)
      {
        i = j;
        if (paramInt != 0) {
          i = j - 1;
        }
      }
      return i;
    }
    return paramInt / this.ntO;
  }
  
  public static int wZ(int paramInt)
  {
    AppMethodBeat.i(50019);
    if (paramInt == 0)
    {
      AppMethodBeat.o(50019);
      return 0;
    }
    int i = com.tencent.mm.plugin.appbrand.widget.desktop.b.getCompletelyCountPerPage();
    com.tencent.mm.plugin.appbrand.widget.desktop.b.bDA();
    AppMethodBeat.o(50019);
    return i * paramInt + 1;
  }
  
  public static int xa(int paramInt)
  {
    AppMethodBeat.i(50020);
    int i = com.tencent.mm.plugin.appbrand.widget.desktop.b.getCompletelyCountPerPage();
    com.tencent.mm.plugin.appbrand.widget.desktop.b.bDA();
    AppMethodBeat.o(50020);
    return (paramInt + 1) * i + 1;
  }
  
  public static int xb(int paramInt)
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
  
  final void P(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(50018);
    if ((this.ntK != null) && ((this.ntV) || (paramBoolean)))
    {
      this.ntN.atQ = paramInt;
      this.ntW = true;
      this.ntK.getLayoutManager().a(this.ntN);
    }
    AppMethodBeat.o(50018);
  }
  
  public final void a(int paramInt, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(50017);
    this.ntP = paramb;
    this.ntQ = true;
    int i = wY(paramInt);
    this.atQ = wZ(i);
    this.nnp = wY(this.ntR.kn());
    com.tencent.mm.sdk.platformtools.ae.i("ViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.nnp), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.atQ) });
    if ((i == this.nnp) && (!paramBoolean))
    {
      bGA();
      AppMethodBeat.o(50017);
      return;
    }
    P(this.atQ, true);
    AppMethodBeat.o(50017);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50013);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramRecyclerView);
    localb.mu(paramInt1);
    localb.mu(paramInt2);
    a.b("com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
    super.a(paramRecyclerView, paramInt1, paramInt2);
    this.ntM += paramInt1;
    if (this.ntT != null) {
      this.ntT.d(paramRecyclerView, this.ntM);
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
    localb.mu(paramInt);
    a.b("com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
    super.b(paramRecyclerView, paramInt);
    com.tencent.mm.sdk.platformtools.ae.i("ViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.ntT != null) {
      this.ntT.h(paramRecyclerView, paramInt, this.ntM);
    }
    int i;
    if ((paramInt == 0) && (this.ncV != 2))
    {
      i = wW(this.mOffsetX);
      if ((this.ntK != null) && (this.ntV))
      {
        this.atl.atQ = i;
        this.ntW = true;
        this.ntK.getLayoutManager().a(this.atl);
      }
      this.ntU = true;
    }
    for (;;)
    {
      this.ncV = paramInt;
      a.a(this, "com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(50014);
      return;
      if ((!this.ntU) && (paramInt == 2))
      {
        this.ntU = true;
      }
      else if (paramInt == 0)
      {
        this.ntL = this.mOffsetX;
        this.ntU = false;
        i = this.nnp;
        int j = this.ntR.km();
        com.tencent.mm.sdk.platformtools.ae.i("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        boolean bool;
        if (j != -1)
        {
          this.nnp = (j / this.ntO);
          com.tencent.mm.sdk.platformtools.ae.i("ViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.nnp), Integer.valueOf(j) });
          if ((i != this.nnp) && (this.ntT != null))
          {
            paramRecyclerView = this.ntT;
            i = this.nnp;
            if (!this.ntV)
            {
              bool = true;
              label330:
              paramRecyclerView.N(i, bool);
            }
          }
          else
          {
            label339:
            this.ntV = false;
            this.ntM = 0;
            if (!this.ntS) {
              break label448;
            }
            com.tencent.mm.sdk.platformtools.ae.d("ViewPagerHelper", "alvinluo scrollMore");
            com.tencent.mm.plugin.appbrand.widget.desktop.b.bDA();
            this.ntS = false;
            a(0, this.ntP, true);
            bGA();
          }
        }
        for (;;)
        {
          if (!this.ntW) {
            break label453;
          }
          com.tencent.mm.sdk.platformtools.ae.i("ViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.ntW = false;
          this.ntK.scrollBy(-1, 0);
          break;
          bool = false;
          break label330;
          com.tencent.mm.sdk.platformtools.ae.e("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.nnp) });
          break label339;
          label448:
          bGA();
        }
      }
      else
      {
        label453:
        if (paramInt == 1)
        {
          com.tencent.mm.sdk.platformtools.ae.i("ViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.ntV = true;
        }
      }
    }
  }
  
  final void bGA()
  {
    AppMethodBeat.i(50015);
    if (this.ntQ)
    {
      com.tencent.mm.sdk.platformtools.ae.i("ViewPagerHelper", "alvinluo onScrollAnimationEnd");
      if (this.ntP != null) {
        this.ntP.bEo();
      }
      bGz();
    }
    AppMethodBeat.o(50015);
  }
  
  final int wW(int paramInt)
  {
    AppMethodBeat.i(50016);
    int i = this.nnp;
    float f = this.ntK.getWidth();
    int k = this.nnp;
    com.tencent.mm.sdk.platformtools.ae.d("ViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.ntL), Integer.valueOf(paramInt - this.ntL), Float.valueOf(f), Float.valueOf(this.lyr), Integer.valueOf(this.nnp) });
    if (paramInt - this.ntL >= f / 2.0F)
    {
      i = wY(this.ntR.ko());
      int m = this.ntK.getAdapter().getItemCount();
      int j = m / this.ntO;
      paramInt = j;
      if (m % this.ntO != 0) {
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
      com.tencent.mm.sdk.platformtools.ae.i("ViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(wZ(paramInt)) });
      paramInt = wX(paramInt);
      AppMethodBeat.o(50016);
      return paramInt;
      if ((paramInt - this.ntL >= 0) && (paramInt - this.ntL < this.lyr))
      {
        com.tencent.mm.sdk.platformtools.ae.i("ViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(wX(i)) });
        paramInt = wX(i);
        AppMethodBeat.o(50016);
        return paramInt;
      }
      if (paramInt - this.ntL > -f / 2.0F) {
        break;
      }
      i = wY(this.ntR.km());
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
    public abstract void N(int paramInt, boolean paramBoolean);
    
    public abstract void d(RecyclerView paramRecyclerView, int paramInt);
    
    public abstract void h(RecyclerView paramRecyclerView, int paramInt1, int paramInt2);
  }
  
  public static abstract interface b
  {
    public abstract void bEo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.e
 * JD-Core Version:    0.7.0.1
 */