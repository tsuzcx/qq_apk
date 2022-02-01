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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class e
  extends RecyclerView.m
{
  private int arZ;
  RecyclerView.s aru;
  private float kWT;
  Context mContext;
  private int mHD;
  public int mHJ;
  public BaseAppBrandRecentView mOd;
  public int mOe;
  public int mOf;
  public int mOffsetX;
  RecyclerView.s mOg;
  public int mOh;
  private b mOi;
  private boolean mOj;
  LinearLayoutManager mOk;
  public boolean mOl;
  a mOm;
  private boolean mOn;
  private boolean mOo;
  private boolean mOp;
  private int mxk;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(50012);
    this.mOf = 0;
    this.mHJ = 0;
    this.kWT = ViewConfiguration.get(ai.getContext()).getScaledTouchSlop();
    this.mOi = null;
    this.arZ = -1;
    this.mOj = false;
    this.mOl = false;
    this.mHD = 0;
    this.mOm = null;
    this.mxk = 0;
    this.mOn = false;
    this.mOo = false;
    this.mOp = false;
    this.mHD = paramInt;
    AppMethodBeat.o(50012);
  }
  
  private void bBC()
  {
    this.mOj = false;
    this.mOl = false;
    this.mOi = null;
    this.arZ = -1;
  }
  
  private int wn(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return this.mOh * paramInt + this.mHD;
  }
  
  private int wo(int paramInt)
  {
    if (this.mHD != 0)
    {
      int j = paramInt / this.mOh;
      int i = j;
      if (paramInt % this.mOh == 0)
      {
        i = j;
        if (paramInt != 0) {
          i = j - 1;
        }
      }
      return i;
    }
    return paramInt / this.mOh;
  }
  
  public static int wp(int paramInt)
  {
    AppMethodBeat.i(50019);
    if (paramInt == 0)
    {
      AppMethodBeat.o(50019);
      return 0;
    }
    int i = com.tencent.mm.plugin.appbrand.widget.desktop.b.getCompletelyCountPerPage();
    com.tencent.mm.plugin.appbrand.widget.desktop.b.byD();
    AppMethodBeat.o(50019);
    return i * paramInt + 1;
  }
  
  public static int wq(int paramInt)
  {
    AppMethodBeat.i(50020);
    int i = com.tencent.mm.plugin.appbrand.widget.desktop.b.getCompletelyCountPerPage();
    com.tencent.mm.plugin.appbrand.widget.desktop.b.byD();
    AppMethodBeat.o(50020);
    return (paramInt + 1) * i + 1;
  }
  
  public static int wr(int paramInt)
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
    if ((this.mOd != null) && ((this.mOo) || (paramBoolean)))
    {
      this.mOg.arZ = paramInt;
      this.mOp = true;
      this.mOd.getLayoutManager().a(this.mOg);
    }
    AppMethodBeat.o(50018);
  }
  
  public final void a(int paramInt, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(50017);
    this.mOi = paramb;
    this.mOj = true;
    int i = wo(paramInt);
    this.arZ = wp(i);
    this.mHJ = wo(this.mOk.jX());
    ac.i("ViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.mHJ), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.arZ) });
    if ((i == this.mHJ) && (!paramBoolean))
    {
      bBD();
      AppMethodBeat.o(50017);
      return;
    }
    O(this.arZ, true);
    AppMethodBeat.o(50017);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50013);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bb(paramRecyclerView);
    localb.lS(paramInt1);
    localb.lS(paramInt2);
    a.b("com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
    super.a(paramRecyclerView, paramInt1, paramInt2);
    this.mOf += paramInt1;
    if (this.mOm != null) {
      this.mOm.d(paramRecyclerView, this.mOf);
    }
    this.mOffsetX += paramInt1;
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(50013);
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(50014);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bb(paramRecyclerView);
    localb.lS(paramInt);
    a.b("com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
    super.b(paramRecyclerView, paramInt);
    ac.i("ViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.mOm != null) {
      this.mOm.h(paramRecyclerView, paramInt, this.mOf);
    }
    int i;
    if ((paramInt == 0) && (this.mxk != 2))
    {
      i = wm(this.mOffsetX);
      if ((this.mOd != null) && (this.mOo))
      {
        this.aru.arZ = i;
        this.mOp = true;
        this.mOd.getLayoutManager().a(this.aru);
      }
      this.mOn = true;
    }
    for (;;)
    {
      this.mxk = paramInt;
      a.a(this, "com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(50014);
      return;
      if ((!this.mOn) && (paramInt == 2))
      {
        this.mOn = true;
      }
      else if (paramInt == 0)
      {
        this.mOe = this.mOffsetX;
        this.mOn = false;
        i = this.mHJ;
        int j = this.mOk.jW();
        ac.i("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        boolean bool;
        if (j != -1)
        {
          this.mHJ = (j / this.mOh);
          ac.i("ViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.mHJ), Integer.valueOf(j) });
          if ((i != this.mHJ) && (this.mOm != null))
          {
            paramRecyclerView = this.mOm;
            i = this.mHJ;
            if (!this.mOo)
            {
              bool = true;
              label330:
              paramRecyclerView.M(i, bool);
            }
          }
          else
          {
            label339:
            this.mOo = false;
            this.mOf = 0;
            if (!this.mOl) {
              break label448;
            }
            ac.d("ViewPagerHelper", "alvinluo scrollMore");
            com.tencent.mm.plugin.appbrand.widget.desktop.b.byD();
            this.mOl = false;
            a(0, this.mOi, true);
            bBD();
          }
        }
        for (;;)
        {
          if (!this.mOp) {
            break label453;
          }
          ac.i("ViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.mOp = false;
          this.mOd.scrollBy(-1, 0);
          break;
          bool = false;
          break label330;
          ac.e("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.mHJ) });
          break label339;
          label448:
          bBD();
        }
      }
      else
      {
        label453:
        if (paramInt == 1)
        {
          ac.i("ViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.mOo = true;
        }
      }
    }
  }
  
  final void bBD()
  {
    AppMethodBeat.i(50015);
    if (this.mOj)
    {
      ac.i("ViewPagerHelper", "alvinluo onScrollAnimationEnd");
      if (this.mOi != null) {
        this.mOi.bzs();
      }
      bBC();
    }
    AppMethodBeat.o(50015);
  }
  
  final int wm(int paramInt)
  {
    AppMethodBeat.i(50016);
    int i = this.mHJ;
    float f = this.mOd.getWidth();
    int k = this.mHJ;
    ac.d("ViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mOe), Integer.valueOf(paramInt - this.mOe), Float.valueOf(f), Float.valueOf(this.kWT), Integer.valueOf(this.mHJ) });
    if (paramInt - this.mOe >= f / 2.0F)
    {
      i = wo(this.mOk.jY());
      int m = this.mOd.getAdapter().getItemCount();
      int j = m / this.mOh;
      paramInt = j;
      if (m % this.mOh != 0) {
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
      ac.i("ViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(wp(paramInt)) });
      paramInt = wn(paramInt);
      AppMethodBeat.o(50016);
      return paramInt;
      if ((paramInt - this.mOe >= 0) && (paramInt - this.mOe < this.kWT))
      {
        ac.i("ViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(wn(i)) });
        paramInt = wn(i);
        AppMethodBeat.o(50016);
        return paramInt;
      }
      if (paramInt - this.mOe > -f / 2.0F) {
        break;
      }
      i = wo(this.mOk.jW());
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
    public abstract void bzs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.e
 * JD-Core Version:    0.7.0.1
 */