package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class h
  extends RecyclerView.l
{
  private int atO;
  Context mContext;
  private float mFs;
  private int mLastState;
  int mOffsetX;
  RecyclerView.r mSmoothScroller;
  int oDP;
  int oDQ;
  RecyclerView.r oDR;
  int oDS;
  private boolean oDU;
  LinearLayoutManager oDV;
  private boolean oDW;
  private boolean oDY;
  private boolean oDZ;
  private boolean oEa;
  private int owQ;
  int owW;
  BizTimeLineHotListView pzW;
  private b pzX;
  a pzY;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(6143);
    this.oDQ = 0;
    this.owW = 0;
    this.mFs = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.pzX = null;
    this.atO = -1;
    this.oDU = false;
    this.oDW = false;
    this.owQ = 0;
    this.pzY = null;
    this.mLastState = 0;
    this.oDY = false;
    this.oDZ = false;
    this.oEa = false;
    this.owQ = paramInt;
    AppMethodBeat.o(6143);
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
  
  public static int Dl(int paramInt)
  {
    AppMethodBeat.i(6150);
    int i = a.getCompletelyCountPerPage();
    AppMethodBeat.o(6150);
    return (paramInt + 1) * i + 1;
  }
  
  private void ccY()
  {
    this.oDU = false;
    this.oDW = false;
    this.pzX = null;
    this.atO = -1;
  }
  
  final int AE(int paramInt)
  {
    AppMethodBeat.i(6147);
    int i = this.owW;
    float f = this.pzW.getWidth();
    int k = this.owW;
    Log.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.oDP), Integer.valueOf(paramInt - this.oDP), Float.valueOf(f), Float.valueOf(this.mFs), Integer.valueOf(this.owW) });
    if (paramInt - this.oDP >= f / 2.0F)
    {
      i = AG(this.oDV.ku());
      int m = this.pzW.getAdapter().getItemCount();
      int j = m / this.oDS;
      paramInt = j;
      if (m % this.oDS != 0) {
        paramInt = j + 1;
      }
      i = Math.max(Math.min(i, paramInt - 1), -1);
      if (i - k <= 1) {
        break label331;
      }
      paramInt = k + 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.BizTimeLineViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(AH(paramInt)) });
      paramInt = AF(paramInt);
      AppMethodBeat.o(6147);
      return paramInt;
      if ((paramInt - this.oDP >= 0) && (paramInt - this.oDP < this.mFs))
      {
        Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(AF(i)) });
        paramInt = AF(i);
        AppMethodBeat.o(6147);
        return paramInt;
      }
      if (paramInt - this.oDP > -f / 2.0F) {
        break;
      }
      i = AG(this.oDV.ks());
      break;
      label331:
      paramInt = i;
      if (k - i > 1) {
        paramInt = k - 1;
      }
    }
  }
  
  final void W(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(6148);
    if ((this.pzW != null) && ((this.oDZ) || (paramBoolean)))
    {
      this.oDR.atO = paramInt;
      this.oEa = true;
      this.pzW.getLayoutManager().startSmoothScroll(this.oDR);
    }
    AppMethodBeat.o(6148);
  }
  
  final void ccZ()
  {
    AppMethodBeat.i(6146);
    if (this.oDU)
    {
      Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollAnimationEnd");
      ccY();
    }
    AppMethodBeat.o(6146);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(6145);
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if ((paramInt == 0) && (this.mLastState != 2))
    {
      i = AE(this.mOffsetX);
      if ((this.pzW != null) && (this.oDZ))
      {
        this.mSmoothScroller.atO = i;
        this.oEa = true;
        this.pzW.getLayoutManager().startSmoothScroll(this.mSmoothScroller);
      }
      this.oDY = true;
    }
    for (;;)
    {
      this.mLastState = paramInt;
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(6145);
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
        Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        boolean bool;
        if (j != -1)
        {
          this.owW = (j / this.oDS);
          Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.owW), Integer.valueOf(j) });
          if ((i != this.owW) && (this.pzY != null))
          {
            paramRecyclerView = this.pzY;
            i = this.owW;
            if (!this.oDZ)
            {
              bool = true;
              label310:
              paramRecyclerView.V(i, bool);
            }
          }
          else
          {
            label319:
            this.oDZ = false;
            this.oDQ = 0;
            if (!this.oDW) {
              break label643;
            }
            Log.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollMore");
            this.pzW.getAdapter().aq(this.pzW.getDataCount(), 5);
            paramRecyclerView = this.pzX;
            this.oDW = false;
            int k = this.pzW.getDataCount();
            j = k / this.oDS;
            i = j;
            if (k % this.oDS == 0) {
              i = j + 1;
            }
            int m = i + 1;
            j = this.oDS * m;
            i = j;
            if (j <= 0) {
              i = 0;
            }
            Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo smoothScrollToLastPage allCount: %d, lastPage: %d, targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
            this.pzX = paramRecyclerView;
            this.oDU = true;
            j = AG(i);
            this.atO = AH(j);
            this.owW = AG(this.oDV.kt());
            Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.owW), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.atO) });
            if (j != this.owW) {
              break label631;
            }
            ccZ();
          }
        }
        for (;;)
        {
          if (!this.oEa) {
            break label648;
          }
          Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.oEa = false;
          this.pzW.scrollBy(-1, 0);
          break;
          bool = false;
          break label310;
          Log.e("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.owW) });
          break label319;
          label631:
          W(this.atO, true);
          continue;
          label643:
          ccZ();
        }
      }
      else
      {
        label648:
        if (paramInt == 1)
        {
          Log.i("MicroMsg.BizTimeLineViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.oDZ = true;
        }
      }
    }
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6144);
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt1);
    localb.pH(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    this.oDQ += paramInt1;
    if ((this.pzY != null) && ((paramInt1 != 0) || (paramInt2 != 0))) {
      this.pzY.Dk(this.oDQ);
    }
    this.mOffsetX += paramInt1;
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(6144);
  }
  
  public static abstract interface a
  {
    public abstract void Dk(int paramInt);
    
    public abstract void V(int paramInt, boolean paramBoolean);
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.h
 * JD-Core Version:    0.7.0.1
 */