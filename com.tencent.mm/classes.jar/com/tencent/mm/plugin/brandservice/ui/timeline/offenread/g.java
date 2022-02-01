package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class g
  extends RecyclerView.m
{
  RecyclerView.r aqy;
  private int ard;
  private float kvF;
  private int lVi;
  Context mContext;
  int mOffsetX;
  private int mfE;
  int mfK;
  private int mmd;
  private int mme;
  RecyclerView.r mmf;
  int mmg;
  private boolean mmi;
  LinearLayoutManager mmj;
  private boolean mmk;
  private boolean mmm;
  private boolean mmn;
  private boolean mmo;
  BizTimeLineHotListView nbU;
  private b nbV;
  a nbW;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(6143);
    this.mme = 0;
    this.mfK = 0;
    this.kvF = ViewConfiguration.get(aj.getContext()).getScaledTouchSlop();
    this.nbV = null;
    this.ard = -1;
    this.mmi = false;
    this.mmk = false;
    this.mfE = 0;
    this.nbW = null;
    this.lVi = 0;
    this.mmm = false;
    this.mmn = false;
    this.mmo = false;
    this.mfE = paramInt;
    AppMethodBeat.o(6143);
  }
  
  private void buF()
  {
    this.mmi = false;
    this.mmk = false;
    this.nbV = null;
    this.ard = -1;
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
    AppMethodBeat.i(6149);
    if (paramInt == 0)
    {
      AppMethodBeat.o(6149);
      return 0;
    }
    int i = a.getCompletelyCountPerPage();
    AppMethodBeat.o(6149);
    return i * paramInt + 1;
  }
  
  public static int vz(int paramInt)
  {
    AppMethodBeat.i(6150);
    int i = a.getCompletelyCountPerPage();
    AppMethodBeat.o(6150);
    return (paramInt + 1) * i + 1;
  }
  
  final void O(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(6148);
    if ((this.nbU != null) && ((this.mmn) || (paramBoolean)))
    {
      this.mmf.ard = paramInt;
      this.mmo = true;
      this.nbU.getLayoutManager().a(this.mmf);
    }
    AppMethodBeat.o(6148);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6144);
    b localb = new b();
    localb.be(paramRecyclerView);
    localb.lT(paramInt1);
    localb.lT(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
    super.a(paramRecyclerView, paramInt1, paramInt2);
    this.mme += paramInt1;
    if ((this.nbW != null) && ((paramInt1 != 0) || (paramInt2 != 0))) {
      this.nbW.xV(this.mme);
    }
    this.mOffsetX += paramInt1;
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(6144);
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(6145);
    b localb = new b();
    localb.be(paramRecyclerView);
    localb.lT(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
    super.b(paramRecyclerView, paramInt);
    ad.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if ((paramInt == 0) && (this.lVi != 2))
    {
      i = vv(this.mOffsetX);
      if ((this.nbU != null) && (this.mmn))
      {
        this.aqy.ard = i;
        this.mmo = true;
        this.nbU.getLayoutManager().a(this.aqy);
      }
      this.mmm = true;
    }
    for (;;)
    {
      this.lVi = paramInt;
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(6145);
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
        ad.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        boolean bool;
        if (j != -1)
        {
          this.mfK = (j / this.mmg);
          ad.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.mfK), Integer.valueOf(j) });
          if ((i != this.mfK) && (this.nbW != null))
          {
            paramRecyclerView = this.nbW;
            if (!this.mmn)
            {
              bool = true;
              label305:
              paramRecyclerView.iz(bool);
            }
          }
          else
          {
            label313:
            this.mmn = false;
            this.mme = 0;
            if (!this.mmk) {
              break label633;
            }
            ad.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollMore");
            this.nbU.getAdapter().ao(this.nbU.getDataCount(), 5);
            paramRecyclerView = this.nbV;
            this.mmk = false;
            int k = this.nbU.getDataCount();
            j = k / this.mmg;
            i = j;
            if (k % this.mmg == 0) {
              i = j + 1;
            }
            int m = i + 1;
            j = this.mmg * m;
            i = j;
            if (j <= 0) {
              i = 0;
            }
            ad.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo smoothScrollToLastPage allCount: %d, lastPage: %d, targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
            this.nbV = paramRecyclerView;
            this.mmi = true;
            j = vx(i);
            this.ard = vy(j);
            this.mfK = vx(this.mmj.jP());
            ad.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.mfK), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.ard) });
            if (j != this.mfK) {
              break label621;
            }
            buG();
          }
        }
        for (;;)
        {
          if (!this.mmo) {
            break label638;
          }
          ad.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.mmo = false;
          this.nbU.scrollBy(-1, 0);
          break;
          bool = false;
          break label305;
          ad.e("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.mfK) });
          break label313;
          label621:
          O(this.ard, true);
          continue;
          label633:
          buG();
        }
      }
      else
      {
        label638:
        if (paramInt == 1)
        {
          ad.i("MicroMsg.BizTimeLineViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.mmn = true;
        }
      }
    }
  }
  
  final void buG()
  {
    AppMethodBeat.i(6146);
    if (this.mmi)
    {
      ad.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollAnimationEnd");
      buF();
    }
    AppMethodBeat.o(6146);
  }
  
  final int vv(int paramInt)
  {
    AppMethodBeat.i(6147);
    int i = this.mfK;
    float f = this.nbU.getWidth();
    int k = this.mfK;
    ad.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mmd), Integer.valueOf(paramInt - this.mmd), Float.valueOf(f), Float.valueOf(this.kvF), Integer.valueOf(this.mfK) });
    if (paramInt - this.mmd >= f / 2.0F)
    {
      i = vx(this.mmj.jQ());
      int m = this.nbU.getAdapter().getItemCount();
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
      ad.i("MicroMsg.BizTimeLineViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(vy(paramInt)) });
      paramInt = vw(paramInt);
      AppMethodBeat.o(6147);
      return paramInt;
      if ((paramInt - this.mmd >= 0) && (paramInt - this.mmd < this.kvF))
      {
        ad.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(vw(i)) });
        paramInt = vw(i);
        AppMethodBeat.o(6147);
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
    public abstract void iz(boolean paramBoolean);
    
    public abstract void xV(int paramInt);
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g
 * JD-Core Version:    0.7.0.1
 */