package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.s;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ak;

public final class g
  extends RecyclerView.m
{
  private int atQ;
  RecyclerView.s atl;
  private float lyr;
  Context mContext;
  int mOffsetX;
  private int ncV;
  private int nnj;
  int nnp;
  int ntL;
  int ntM;
  RecyclerView.s ntN;
  int ntO;
  private boolean ntQ;
  LinearLayoutManager ntR;
  private boolean ntS;
  private boolean ntU;
  private boolean ntV;
  private boolean ntW;
  BizTimeLineHotListView ong;
  private b onh;
  a oni;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(6143);
    this.ntM = 0;
    this.nnp = 0;
    this.lyr = ViewConfiguration.get(ak.getContext()).getScaledTouchSlop();
    this.onh = null;
    this.atQ = -1;
    this.ntQ = false;
    this.ntS = false;
    this.nnj = 0;
    this.oni = null;
    this.ncV = 0;
    this.ntU = false;
    this.ntV = false;
    this.ntW = false;
    this.nnj = paramInt;
    AppMethodBeat.o(6143);
  }
  
  private void bGz()
  {
    this.ntQ = false;
    this.ntS = false;
    this.onh = null;
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
  
  public static int xa(int paramInt)
  {
    AppMethodBeat.i(6150);
    int i = a.getCompletelyCountPerPage();
    AppMethodBeat.o(6150);
    return (paramInt + 1) * i + 1;
  }
  
  final void P(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(6148);
    if ((this.ong != null) && ((this.ntV) || (paramBoolean)))
    {
      this.ntN.atQ = paramInt;
      this.ntW = true;
      this.ong.getLayoutManager().a(this.ntN);
    }
    AppMethodBeat.o(6148);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6144);
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.mu(paramInt1);
    localb.mu(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
    super.a(paramRecyclerView, paramInt1, paramInt2);
    this.ntM += paramInt1;
    if ((this.oni != null) && ((paramInt1 != 0) || (paramInt2 != 0))) {
      this.oni.zF(this.ntM);
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
    localb.mu(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
    super.b(paramRecyclerView, paramInt);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if ((paramInt == 0) && (this.ncV != 2))
    {
      i = wW(this.mOffsetX);
      if ((this.ong != null) && (this.ntV))
      {
        this.atl.atQ = i;
        this.ntW = true;
        this.ong.getLayoutManager().a(this.atl);
      }
      this.ntU = true;
    }
    for (;;)
    {
      this.ncV = paramInt;
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(6145);
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        boolean bool;
        if (j != -1)
        {
          this.nnp = (j / this.ntO);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.nnp), Integer.valueOf(j) });
          if ((i != this.nnp) && (this.oni != null))
          {
            paramRecyclerView = this.oni;
            i = this.nnp;
            if (!this.ntV)
            {
              bool = true;
              label310:
              paramRecyclerView.N(i, bool);
            }
          }
          else
          {
            label319:
            this.ntV = false;
            this.ntM = 0;
            if (!this.ntS) {
              break label639;
            }
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollMore");
            this.ong.getAdapter().ap(this.ong.getDataCount(), 5);
            paramRecyclerView = this.onh;
            this.ntS = false;
            int k = this.ong.getDataCount();
            j = k / this.ntO;
            i = j;
            if (k % this.ntO == 0) {
              i = j + 1;
            }
            int m = i + 1;
            j = this.ntO * m;
            i = j;
            if (j <= 0) {
              i = 0;
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo smoothScrollToLastPage allCount: %d, lastPage: %d, targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
            this.onh = paramRecyclerView;
            this.ntQ = true;
            j = wY(i);
            this.atQ = wZ(j);
            this.nnp = wY(this.ntR.kn());
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.nnp), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.atQ) });
            if (j != this.nnp) {
              break label627;
            }
            bGA();
          }
        }
        for (;;)
        {
          if (!this.ntW) {
            break label644;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.ntW = false;
          this.ong.scrollBy(-1, 0);
          break;
          bool = false;
          break label310;
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.nnp) });
          break label319;
          label627:
          P(this.atQ, true);
          continue;
          label639:
          bGA();
        }
      }
      else
      {
        label644:
        if (paramInt == 1)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTimeLineViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.ntV = true;
        }
      }
    }
  }
  
  final void bGA()
  {
    AppMethodBeat.i(6146);
    if (this.ntQ)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollAnimationEnd");
      bGz();
    }
    AppMethodBeat.o(6146);
  }
  
  final int wW(int paramInt)
  {
    AppMethodBeat.i(6147);
    int i = this.nnp;
    float f = this.ong.getWidth();
    int k = this.nnp;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.ntL), Integer.valueOf(paramInt - this.ntL), Float.valueOf(f), Float.valueOf(this.lyr), Integer.valueOf(this.nnp) });
    if (paramInt - this.ntL >= f / 2.0F)
    {
      i = wY(this.ntR.ko());
      int m = this.ong.getAdapter().getItemCount();
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
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTimeLineViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(wZ(paramInt)) });
      paramInt = wX(paramInt);
      AppMethodBeat.o(6147);
      return paramInt;
      if ((paramInt - this.ntL >= 0) && (paramInt - this.ntL < this.lyr))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(wX(i)) });
        paramInt = wX(i);
        AppMethodBeat.o(6147);
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
    
    public abstract void zF(int paramInt);
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g
 * JD-Core Version:    0.7.0.1
 */