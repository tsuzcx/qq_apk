package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.r;
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
  RecyclerView.r aqy;
  private int ard;
  private float kvF;
  private int lVi;
  Context mContext;
  public int mOffsetX;
  private int mfE;
  public int mfK;
  public BaseAppBrandRecentView mmc;
  public int mmd;
  public int mme;
  RecyclerView.r mmf;
  public int mmg;
  private b mmh;
  private boolean mmi;
  LinearLayoutManager mmj;
  public boolean mmk;
  a mml;
  private boolean mmm;
  private boolean mmn;
  private boolean mmo;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(50012);
    this.mme = 0;
    this.mfK = 0;
    this.kvF = ViewConfiguration.get(aj.getContext()).getScaledTouchSlop();
    this.mmh = null;
    this.ard = -1;
    this.mmi = false;
    this.mmk = false;
    this.mfE = 0;
    this.mml = null;
    this.lVi = 0;
    this.mmm = false;
    this.mmn = false;
    this.mmo = false;
    this.mfE = paramInt;
    AppMethodBeat.o(50012);
  }
  
  private void buF()
  {
    this.mmi = false;
    this.mmk = false;
    this.mmh = null;
    this.ard = -1;
  }
  
  public static int vA(int paramInt)
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
  
  private int vw(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return this.mmg * paramInt + this.mfE;
  }
  
  private int vx(int paramInt)
  {
    if (this.mfE != 0)
    {
      int j = paramInt / this.mmg;
      int i = j;
      if (paramInt % this.mmg == 0)
      {
        i = j;
        if (paramInt != 0) {
          i = j - 1;
        }
      }
      return i;
    }
    return paramInt / this.mmg;
  }
  
  public static int vy(int paramInt)
  {
    AppMethodBeat.i(50019);
    if (paramInt == 0)
    {
      AppMethodBeat.o(50019);
      return 0;
    }
    int i = com.tencent.mm.plugin.appbrand.widget.desktop.b.getCompletelyCountPerPage();
    com.tencent.mm.plugin.appbrand.widget.desktop.b.brD();
    AppMethodBeat.o(50019);
    return i * paramInt + 1;
  }
  
  public static int vz(int paramInt)
  {
    AppMethodBeat.i(50020);
    int i = com.tencent.mm.plugin.appbrand.widget.desktop.b.getCompletelyCountPerPage();
    com.tencent.mm.plugin.appbrand.widget.desktop.b.brD();
    AppMethodBeat.o(50020);
    return (paramInt + 1) * i + 1;
  }
  
  final void O(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(50018);
    if ((this.mmc != null) && ((this.mmn) || (paramBoolean)))
    {
      this.mmf.ard = paramInt;
      this.mmo = true;
      this.mmc.getLayoutManager().a(this.mmf);
    }
    AppMethodBeat.o(50018);
  }
  
  public final void a(int paramInt, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(50017);
    this.mmh = paramb;
    this.mmi = true;
    int i = vx(paramInt);
    this.ard = vy(i);
    this.mfK = vx(this.mmj.jP());
    ad.i("ViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.mfK), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.ard) });
    if ((i == this.mfK) && (!paramBoolean))
    {
      buG();
      AppMethodBeat.o(50017);
      return;
    }
    O(this.ard, true);
    AppMethodBeat.o(50017);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50013);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.be(paramRecyclerView);
    localb.lT(paramInt1);
    localb.lT(paramInt2);
    a.b("com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
    super.a(paramRecyclerView, paramInt1, paramInt2);
    this.mme += paramInt1;
    if (this.mml != null) {
      this.mml.d(paramRecyclerView, this.mme);
    }
    this.mOffsetX += paramInt1;
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(50013);
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(50014);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.be(paramRecyclerView);
    localb.lT(paramInt);
    a.b("com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
    super.b(paramRecyclerView, paramInt);
    ad.i("ViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.mml != null) {
      this.mml.h(paramRecyclerView, paramInt, this.mme);
    }
    int i;
    if ((paramInt == 0) && (this.lVi != 2))
    {
      i = vv(this.mOffsetX);
      if ((this.mmc != null) && (this.mmn))
      {
        this.aqy.ard = i;
        this.mmo = true;
        this.mmc.getLayoutManager().a(this.aqy);
      }
      this.mmm = true;
    }
    for (;;)
    {
      this.lVi = paramInt;
      a.a(this, "com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(50014);
      return;
      if ((!this.mmm) && (paramInt == 2))
      {
        this.mmm = true;
      }
      else if (paramInt == 0)
      {
        this.mmd = this.mOffsetX;
        this.mmm = false;
        i = this.mfK;
        int j = this.mmj.jO();
        ad.i("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        boolean bool;
        if (j != -1)
        {
          this.mfK = (j / this.mmg);
          ad.i("ViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.mfK), Integer.valueOf(j) });
          if ((i != this.mfK) && (this.mml != null))
          {
            paramRecyclerView = this.mml;
            i = this.mfK;
            if (!this.mmn)
            {
              bool = true;
              label330:
              paramRecyclerView.M(i, bool);
            }
          }
          else
          {
            label339:
            this.mmn = false;
            this.mme = 0;
            if (!this.mmk) {
              break label448;
            }
            ad.d("ViewPagerHelper", "alvinluo scrollMore");
            com.tencent.mm.plugin.appbrand.widget.desktop.b.brD();
            this.mmk = false;
            a(0, this.mmh, true);
            buG();
          }
        }
        for (;;)
        {
          if (!this.mmo) {
            break label453;
          }
          ad.i("ViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.mmo = false;
          this.mmc.scrollBy(-1, 0);
          break;
          bool = false;
          break label330;
          ad.e("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.mfK) });
          break label339;
          label448:
          buG();
        }
      }
      else
      {
        label453:
        if (paramInt == 1)
        {
          ad.i("ViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.mmn = true;
        }
      }
    }
  }
  
  final void buG()
  {
    AppMethodBeat.i(50015);
    if (this.mmi)
    {
      ad.i("ViewPagerHelper", "alvinluo onScrollAnimationEnd");
      if (this.mmh != null) {
        this.mmh.bss();
      }
      buF();
    }
    AppMethodBeat.o(50015);
  }
  
  final int vv(int paramInt)
  {
    AppMethodBeat.i(50016);
    int i = this.mfK;
    float f = this.mmc.getWidth();
    int k = this.mfK;
    ad.d("ViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mmd), Integer.valueOf(paramInt - this.mmd), Float.valueOf(f), Float.valueOf(this.kvF), Integer.valueOf(this.mfK) });
    if (paramInt - this.mmd >= f / 2.0F)
    {
      i = vx(this.mmj.jQ());
      int m = this.mmc.getAdapter().getItemCount();
      int j = m / this.mmg;
      paramInt = j;
      if (m % this.mmg != 0) {
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
      ad.i("ViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(vy(paramInt)) });
      paramInt = vw(paramInt);
      AppMethodBeat.o(50016);
      return paramInt;
      if ((paramInt - this.mmd >= 0) && (paramInt - this.mmd < this.kvF))
      {
        ad.i("ViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(vw(i)) });
        paramInt = vw(i);
        AppMethodBeat.o(50016);
        return paramInt;
      }
      if (paramInt - this.mmd > -f / 2.0F) {
        break;
      }
      i = vx(this.mmj.jO());
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
    public abstract void bss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.e
 * JD-Core Version:    0.7.0.1
 */