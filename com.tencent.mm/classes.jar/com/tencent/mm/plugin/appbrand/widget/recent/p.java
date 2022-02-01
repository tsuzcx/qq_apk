package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class p
  extends RecyclerView.l
{
  private int atO;
  Context mContext;
  private float mFs;
  private int mLastState;
  int mOffsetX;
  RecyclerView.r mSmoothScroller;
  BaseAppBrandRecentView oDO;
  private int oDP;
  private int oDQ;
  RecyclerView.r oDR;
  int oDS;
  private b oDT;
  private boolean oDU;
  LinearLayoutManager oDV;
  private boolean oDW;
  a oDX;
  private boolean oDY;
  private boolean oDZ;
  private boolean oEa;
  private int owQ;
  int owW;
  
  public p(int paramInt)
  {
    AppMethodBeat.i(227841);
    this.oDQ = 0;
    this.owW = 0;
    this.mFs = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.oDT = null;
    this.atO = -1;
    this.oDU = false;
    this.oDW = false;
    this.owQ = 0;
    this.oDX = null;
    this.mLastState = 0;
    this.oDY = false;
    this.oDZ = false;
    this.oEa = false;
    this.owQ = paramInt;
    AppMethodBeat.o(227841);
  }
  
  private int AF(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return this.oDS * paramInt + this.owQ;
  }
  
  private int AG(int paramInt)
  {
    if (this.owQ != 0)
    {
      int j = paramInt / this.oDS;
      int i = j;
      if (paramInt % this.oDS == 0)
      {
        i = j;
        if (paramInt != 0) {
          i = j - 1;
        }
      }
      return i;
    }
    return paramInt / this.oDS;
  }
  
  public static int AH(int paramInt)
  {
    AppMethodBeat.i(227847);
    if (paramInt == 0)
    {
      AppMethodBeat.o(227847);
      return 0;
    }
    int i = d.getCompletelyCountPerPage();
    d.ccS();
    AppMethodBeat.o(227847);
    return i * paramInt + 1;
  }
  
  private void ccY()
  {
    this.oDU = false;
    this.oDW = false;
    this.oDT = null;
    this.atO = -1;
  }
  
  final int AE(int paramInt)
  {
    AppMethodBeat.i(227845);
    int i = this.owW;
    float f = this.oDO.getWidth();
    int k = this.owW;
    Log.d("ViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.oDP), Integer.valueOf(paramInt - this.oDP), Float.valueOf(f), Float.valueOf(this.mFs), Integer.valueOf(this.owW) });
    if (paramInt - this.oDP >= f / 2.0F)
    {
      i = AG(this.oDV.ku());
      int m = this.oDO.getAdapter().getItemCount();
      int j = m / this.oDS;
      paramInt = j;
      if (m % this.oDS != 0) {
        paramInt = j + 1;
      }
      i = Math.max(Math.min(i, paramInt - 1), -1);
      if (i - k <= 1) {
        break label328;
      }
      paramInt = k + 1;
    }
    for (;;)
    {
      Log.i("ViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(AH(paramInt)) });
      paramInt = AF(paramInt);
      AppMethodBeat.o(227845);
      return paramInt;
      if ((paramInt - this.oDP >= 0) && (paramInt - this.oDP < this.mFs))
      {
        Log.i("ViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(AF(i)) });
        paramInt = AF(i);
        AppMethodBeat.o(227845);
        return paramInt;
      }
      if (paramInt - this.oDP > -f / 2.0F) {
        break;
      }
      i = AG(this.oDV.ks());
      break;
      label328:
      paramInt = i;
      if (k - i > 1) {
        paramInt = k - 1;
      }
    }
  }
  
  final void W(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(227846);
    if ((this.oDO != null) && ((this.oDZ) || (paramBoolean)))
    {
      this.oDR.atO = paramInt;
      this.oEa = true;
      this.oDO.getLayoutManager().startSmoothScroll(this.oDR);
    }
    AppMethodBeat.o(227846);
  }
  
  final void ccZ()
  {
    AppMethodBeat.i(227844);
    if (this.oDU)
    {
      Log.i("ViewPagerHelper", "alvinluo onScrollAnimationEnd");
      ccY();
    }
    AppMethodBeat.o(227844);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(227843);
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt);
    a.b("com/tencent/mm/plugin/appbrand/widget/recent/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    Log.i("ViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.oDX != null) {
      this.oDX.c(paramRecyclerView, paramInt, this.oDQ);
    }
    int i;
    if ((paramInt == 0) && (this.mLastState != 2))
    {
      i = AE(this.mOffsetX);
      if ((this.oDO != null) && (this.oDZ))
      {
        this.mSmoothScroller.atO = i;
        this.oEa = true;
        this.oDO.getLayoutManager().startSmoothScroll(this.mSmoothScroller);
      }
      this.oDY = true;
    }
    for (;;)
    {
      this.mLastState = paramInt;
      a.a(this, "com/tencent/mm/plugin/appbrand/widget/recent/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(227843);
      return;
      if ((!this.oDY) && (paramInt == 2))
      {
        this.oDY = true;
      }
      else if (paramInt == 0)
      {
        this.oDP = this.mOffsetX;
        this.oDY = false;
        i = this.owW;
        int j = this.oDV.ks();
        Log.i("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        boolean bool;
        if (j != -1)
        {
          this.owW = (j / this.oDS);
          Log.i("ViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.owW), Integer.valueOf(j) });
          if ((i != this.owW) && (this.oDX != null))
          {
            paramRecyclerView = this.oDX;
            i = this.owW;
            if (!this.oDZ)
            {
              bool = true;
              label332:
              paramRecyclerView.V(i, bool);
            }
          }
          else
          {
            label341:
            this.oDZ = false;
            this.oDQ = 0;
            if (!this.oDW) {
              break label539;
            }
            Log.d("ViewPagerHelper", "alvinluo scrollMore");
            d.ccS();
            this.oDW = false;
            this.oDT = this.oDT;
            this.oDU = true;
            i = AG(0);
            this.atO = AH(i);
            this.owW = AG(this.oDV.kt());
            Log.i("ViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.owW), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(this.atO) });
            W(this.atO, true);
            ccZ();
          }
        }
        for (;;)
        {
          if (!this.oEa) {
            break label544;
          }
          Log.i("ViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.oEa = false;
          this.oDO.scrollBy(-1, 0);
          break;
          bool = false;
          break label332;
          Log.e("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.owW) });
          break label341;
          label539:
          ccZ();
        }
      }
      else
      {
        label544:
        if (paramInt == 1)
        {
          Log.i("ViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.oDZ = true;
        }
      }
    }
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227842);
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt1);
    localb.pH(paramInt2);
    a.b("com/tencent/mm/plugin/appbrand/widget/recent/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    this.oDQ += paramInt1;
    if (this.oDX != null) {
      this.oDX.c(paramRecyclerView, this.oDQ);
    }
    this.mOffsetX += paramInt1;
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/recent/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(227842);
  }
  
  public static abstract interface a
  {
    public abstract void V(int paramInt, boolean paramBoolean);
    
    public abstract void c(RecyclerView paramRecyclerView, int paramInt);
    
    public abstract void c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2);
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.p
 * JD-Core Version:    0.7.0.1
 */