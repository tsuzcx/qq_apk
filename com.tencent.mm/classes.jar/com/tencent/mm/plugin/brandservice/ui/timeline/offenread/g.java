package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.s;
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
  private int atQ;
  RecyclerView.s atl;
  private float ltS;
  Context mContext;
  int mOffsetX;
  private int mXO;
  private int nib;
  int nih;
  int noB;
  int noC;
  RecyclerView.s noD;
  int noE;
  private boolean noG;
  LinearLayoutManager noH;
  private boolean noI;
  private boolean noK;
  private boolean noL;
  private boolean noM;
  BizTimeLineHotListView ohh;
  private b ohi;
  a ohj;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(6143);
    this.noC = 0;
    this.nih = 0;
    this.ltS = ViewConfiguration.get(aj.getContext()).getScaledTouchSlop();
    this.ohi = null;
    this.atQ = -1;
    this.noG = false;
    this.noI = false;
    this.nib = 0;
    this.ohj = null;
    this.mXO = 0;
    this.noK = false;
    this.noL = false;
    this.noM = false;
    this.nib = paramInt;
    AppMethodBeat.o(6143);
  }
  
  private void bFE()
  {
    this.noG = false;
    this.noI = false;
    this.ohi = null;
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
  
  public static int wV(int paramInt)
  {
    AppMethodBeat.i(6150);
    int i = a.getCompletelyCountPerPage();
    AppMethodBeat.o(6150);
    return (paramInt + 1) * i + 1;
  }
  
  final void O(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(6148);
    if ((this.ohh != null) && ((this.noL) || (paramBoolean)))
    {
      this.noD.atQ = paramInt;
      this.noM = true;
      this.ohh.getLayoutManager().a(this.noD);
    }
    AppMethodBeat.o(6148);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6144);
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.mr(paramInt1);
    localb.mr(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
    super.a(paramRecyclerView, paramInt1, paramInt2);
    this.noC += paramInt1;
    if ((this.ohj != null) && ((paramInt1 != 0) || (paramInt2 != 0))) {
      this.ohj.zw(this.noC);
    }
    this.mOffsetX += paramInt1;
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(6144);
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(6145);
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.mr(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
    super.b(paramRecyclerView, paramInt);
    ad.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if ((paramInt == 0) && (this.mXO != 2))
    {
      i = wR(this.mOffsetX);
      if ((this.ohh != null) && (this.noL))
      {
        this.atl.atQ = i;
        this.noM = true;
        this.ohh.getLayoutManager().a(this.atl);
      }
      this.noK = true;
    }
    for (;;)
    {
      this.mXO = paramInt;
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(6145);
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
        ad.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        boolean bool;
        if (j != -1)
        {
          this.nih = (j / this.noE);
          ad.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.nih), Integer.valueOf(j) });
          if ((i != this.nih) && (this.ohj != null))
          {
            paramRecyclerView = this.ohj;
            i = this.nih;
            if (!this.noL)
            {
              bool = true;
              label310:
              paramRecyclerView.M(i, bool);
            }
          }
          else
          {
            label319:
            this.noL = false;
            this.noC = 0;
            if (!this.noI) {
              break label639;
            }
            ad.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollMore");
            this.ohh.getAdapter().ap(this.ohh.getDataCount(), 5);
            paramRecyclerView = this.ohi;
            this.noI = false;
            int k = this.ohh.getDataCount();
            j = k / this.noE;
            i = j;
            if (k % this.noE == 0) {
              i = j + 1;
            }
            int m = i + 1;
            j = this.noE * m;
            i = j;
            if (j <= 0) {
              i = 0;
            }
            ad.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo smoothScrollToLastPage allCount: %d, lastPage: %d, targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
            this.ohi = paramRecyclerView;
            this.noG = true;
            j = wT(i);
            this.atQ = wU(j);
            this.nih = wT(this.noH.kn());
            ad.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.nih), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.atQ) });
            if (j != this.nih) {
              break label627;
            }
            bFF();
          }
        }
        for (;;)
        {
          if (!this.noM) {
            break label644;
          }
          ad.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.noM = false;
          this.ohh.scrollBy(-1, 0);
          break;
          bool = false;
          break label310;
          ad.e("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.nih) });
          break label319;
          label627:
          O(this.atQ, true);
          continue;
          label639:
          bFF();
        }
      }
      else
      {
        label644:
        if (paramInt == 1)
        {
          ad.i("MicroMsg.BizTimeLineViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.noL = true;
        }
      }
    }
  }
  
  final void bFF()
  {
    AppMethodBeat.i(6146);
    if (this.noG)
    {
      ad.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollAnimationEnd");
      bFE();
    }
    AppMethodBeat.o(6146);
  }
  
  final int wR(int paramInt)
  {
    AppMethodBeat.i(6147);
    int i = this.nih;
    float f = this.ohh.getWidth();
    int k = this.nih;
    ad.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.noB), Integer.valueOf(paramInt - this.noB), Float.valueOf(f), Float.valueOf(this.ltS), Integer.valueOf(this.nih) });
    if (paramInt - this.noB >= f / 2.0F)
    {
      i = wT(this.noH.ko());
      int m = this.ohh.getAdapter().getItemCount();
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
      ad.i("MicroMsg.BizTimeLineViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(wU(paramInt)) });
      paramInt = wS(paramInt);
      AppMethodBeat.o(6147);
      return paramInt;
      if ((paramInt - this.noB >= 0) && (paramInt - this.noB < this.ltS))
      {
        ad.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(wS(i)) });
        paramInt = wS(i);
        AppMethodBeat.o(6147);
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
    
    public abstract void zw(int paramInt);
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g
 * JD-Core Version:    0.7.0.1
 */