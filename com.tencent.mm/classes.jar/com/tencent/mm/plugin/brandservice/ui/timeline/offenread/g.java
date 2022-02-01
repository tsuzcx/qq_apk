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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class g
  extends RecyclerView.m
{
  private int arZ;
  RecyclerView.s aru;
  private float kWT;
  Context mContext;
  private int mHD;
  int mHJ;
  int mOe;
  int mOf;
  int mOffsetX;
  RecyclerView.s mOg;
  int mOh;
  private boolean mOj;
  LinearLayoutManager mOk;
  private boolean mOl;
  private boolean mOn;
  private boolean mOo;
  private boolean mOp;
  private int mxk;
  BizTimeLineHotListView nEE;
  private b nEF;
  a nEG;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(6143);
    this.mOf = 0;
    this.mHJ = 0;
    this.kWT = ViewConfiguration.get(ai.getContext()).getScaledTouchSlop();
    this.nEF = null;
    this.arZ = -1;
    this.mOj = false;
    this.mOl = false;
    this.mHD = 0;
    this.nEG = null;
    this.mxk = 0;
    this.mOn = false;
    this.mOo = false;
    this.mOp = false;
    this.mHD = paramInt;
    AppMethodBeat.o(6143);
  }
  
  private void bBC()
  {
    this.mOj = false;
    this.mOl = false;
    this.nEF = null;
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
  
  public static int wq(int paramInt)
  {
    AppMethodBeat.i(6150);
    int i = a.getCompletelyCountPerPage();
    AppMethodBeat.o(6150);
    return (paramInt + 1) * i + 1;
  }
  
  final void O(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(6148);
    if ((this.nEE != null) && ((this.mOo) || (paramBoolean)))
    {
      this.mOg.arZ = paramInt;
      this.mOp = true;
      this.nEE.getLayoutManager().a(this.mOg);
    }
    AppMethodBeat.o(6148);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6144);
    b localb = new b();
    localb.bb(paramRecyclerView);
    localb.lS(paramInt1);
    localb.lS(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
    super.a(paramRecyclerView, paramInt1, paramInt2);
    this.mOf += paramInt1;
    if ((this.nEG != null) && ((paramInt1 != 0) || (paramInt2 != 0))) {
      this.nEG.yM(this.mOf);
    }
    this.mOffsetX += paramInt1;
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(6144);
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(6145);
    b localb = new b();
    localb.bb(paramRecyclerView);
    localb.lS(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
    super.b(paramRecyclerView, paramInt);
    ac.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if ((paramInt == 0) && (this.mxk != 2))
    {
      i = wm(this.mOffsetX);
      if ((this.nEE != null) && (this.mOo))
      {
        this.aru.arZ = i;
        this.mOp = true;
        this.nEE.getLayoutManager().a(this.aru);
      }
      this.mOn = true;
    }
    for (;;)
    {
      this.mxk = paramInt;
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(6145);
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
        ac.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        boolean bool;
        if (j != -1)
        {
          this.mHJ = (j / this.mOh);
          ac.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.mHJ), Integer.valueOf(j) });
          if ((i != this.mHJ) && (this.nEG != null))
          {
            paramRecyclerView = this.nEG;
            i = this.mHJ;
            if (!this.mOo)
            {
              bool = true;
              label310:
              paramRecyclerView.M(i, bool);
            }
          }
          else
          {
            label319:
            this.mOo = false;
            this.mOf = 0;
            if (!this.mOl) {
              break label639;
            }
            ac.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollMore");
            this.nEE.getAdapter().ao(this.nEE.getDataCount(), 5);
            paramRecyclerView = this.nEF;
            this.mOl = false;
            int k = this.nEE.getDataCount();
            j = k / this.mOh;
            i = j;
            if (k % this.mOh == 0) {
              i = j + 1;
            }
            int m = i + 1;
            j = this.mOh * m;
            i = j;
            if (j <= 0) {
              i = 0;
            }
            ac.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo smoothScrollToLastPage allCount: %d, lastPage: %d, targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
            this.nEF = paramRecyclerView;
            this.mOj = true;
            j = wo(i);
            this.arZ = wp(j);
            this.mHJ = wo(this.mOk.jX());
            ac.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.mHJ), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.arZ) });
            if (j != this.mHJ) {
              break label627;
            }
            bBD();
          }
        }
        for (;;)
        {
          if (!this.mOp) {
            break label644;
          }
          ac.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.mOp = false;
          this.nEE.scrollBy(-1, 0);
          break;
          bool = false;
          break label310;
          ac.e("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.mHJ) });
          break label319;
          label627:
          O(this.arZ, true);
          continue;
          label639:
          bBD();
        }
      }
      else
      {
        label644:
        if (paramInt == 1)
        {
          ac.i("MicroMsg.BizTimeLineViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.mOo = true;
        }
      }
    }
  }
  
  final void bBD()
  {
    AppMethodBeat.i(6146);
    if (this.mOj)
    {
      ac.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollAnimationEnd");
      bBC();
    }
    AppMethodBeat.o(6146);
  }
  
  final int wm(int paramInt)
  {
    AppMethodBeat.i(6147);
    int i = this.mHJ;
    float f = this.nEE.getWidth();
    int k = this.mHJ;
    ac.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mOe), Integer.valueOf(paramInt - this.mOe), Float.valueOf(f), Float.valueOf(this.kWT), Integer.valueOf(this.mHJ) });
    if (paramInt - this.mOe >= f / 2.0F)
    {
      i = wo(this.mOk.jY());
      int m = this.nEE.getAdapter().getItemCount();
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
      ac.i("MicroMsg.BizTimeLineViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(wp(paramInt)) });
      paramInt = wn(paramInt);
      AppMethodBeat.o(6147);
      return paramInt;
      if ((paramInt - this.mOe >= 0) && (paramInt - this.mOe < this.kWT))
      {
        ac.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(wn(i)) });
        paramInt = wn(i);
        AppMethodBeat.o(6147);
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
    
    public abstract void yM(int paramInt);
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g
 * JD-Core Version:    0.7.0.1
 */