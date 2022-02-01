package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class i
  extends RecyclerView.l
{
  int CL;
  private int alG;
  Context mContext;
  private int mLastState;
  RecyclerView.r mSmoothScroller;
  private float pEE;
  int rFA;
  private boolean rFC;
  LinearLayoutManager rFD;
  private boolean rFE;
  private int rFF;
  private boolean rFH;
  private boolean rFI;
  private boolean rFJ;
  int rFw;
  int rFx;
  RecyclerView.r rFy;
  int rFz;
  BizTimeLineHotListView sKf;
  private b sKg;
  a sKh;
  
  public i(int paramInt)
  {
    AppMethodBeat.i(6143);
    this.rFx = 0;
    this.rFz = 0;
    this.pEE = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.sKg = null;
    this.alG = -1;
    this.rFC = false;
    this.rFE = false;
    this.rFF = 0;
    this.sKh = null;
    this.mLastState = 0;
    this.rFH = false;
    this.rFI = false;
    this.rFJ = false;
    this.rFF = paramInt;
    AppMethodBeat.o(6143);
  }
  
  private int El(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return this.rFA * paramInt + this.rFF;
  }
  
  private int Em(int paramInt)
  {
    if (this.rFF != 0)
    {
      int j = paramInt / this.rFA;
      int i = j;
      if (paramInt % this.rFA == 0)
      {
        i = j;
        if (paramInt != 0) {
          i = j - 1;
        }
      }
      return i;
    }
    return paramInt / this.rFA;
  }
  
  public static int En(int paramInt)
  {
    AppMethodBeat.i(6149);
    if (paramInt == 0)
    {
      AppMethodBeat.o(6149);
      return 0;
    }
    int i = b.getCompletelyCountPerPage();
    AppMethodBeat.o(6149);
    return i * paramInt + 1;
  }
  
  public static int GT(int paramInt)
  {
    AppMethodBeat.i(6150);
    int i = b.getCompletelyCountPerPage();
    AppMethodBeat.o(6150);
    return (paramInt + 1) * i + 1;
  }
  
  private void cqj()
  {
    this.rFC = false;
    this.rFE = false;
    this.sKg = null;
    this.alG = -1;
  }
  
  private void cqk()
  {
    AppMethodBeat.i(6146);
    if (this.rFC)
    {
      Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollAnimationEnd");
      cqj();
    }
    AppMethodBeat.o(6146);
  }
  
  final int Ek(int paramInt)
  {
    AppMethodBeat.i(6147);
    int i = this.rFz;
    float f = this.sKf.getWidth();
    int k = this.rFz;
    Log.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.rFw), Integer.valueOf(paramInt - this.rFw), Float.valueOf(f), Float.valueOf(this.pEE), Integer.valueOf(this.rFz) });
    if (paramInt - this.rFw >= f / 2.0F)
    {
      i = Em(this.rFD.kL());
      int m = this.sKf.getAdapter().getItemCount();
      int j = m / this.rFA;
      paramInt = j;
      if (m % this.rFA != 0) {
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
      Log.i("MicroMsg.BizTimeLineViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(En(paramInt)) });
      paramInt = El(paramInt);
      AppMethodBeat.o(6147);
      return paramInt;
      if ((paramInt - this.rFw >= 0) && (paramInt - this.rFw < this.pEE))
      {
        Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(El(i)) });
        paramInt = El(i);
        AppMethodBeat.o(6147);
        return paramInt;
      }
      if (paramInt - this.rFw > -f / 2.0F) {
        break;
      }
      i = Em(this.rFD.kJ());
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
    if ((this.sKf != null) && ((this.rFI) || (paramBoolean)))
    {
      this.rFy.alG = paramInt;
      this.rFJ = true;
      this.sKf.getLayoutManager().startSmoothScroll(this.rFy);
    }
    AppMethodBeat.o(6148);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(266885);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramRecyclerView);
    localb.sg(paramInt);
    a.c("com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if ((paramInt == 0) && (this.mLastState != 2))
    {
      i = Ek(this.CL);
      if ((this.sKf != null) && (this.rFI))
      {
        this.mSmoothScroller.alG = i;
        this.rFJ = true;
        this.sKf.getLayoutManager().startSmoothScroll(this.mSmoothScroller);
      }
      this.rFH = true;
    }
    for (;;)
    {
      this.mLastState = paramInt;
      a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(266885);
      return;
      if ((!this.rFH) && (paramInt == 2))
      {
        this.rFH = true;
      }
      else if (paramInt == 0)
      {
        this.rFw = this.CL;
        this.rFH = false;
        i = this.rFz;
        int j = this.rFD.kJ();
        Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        boolean bool;
        if (j != -1)
        {
          this.rFz = (j / this.rFA);
          Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.rFz), Integer.valueOf(j) });
          if ((i != this.rFz) && (this.sKh != null))
          {
            paramRecyclerView = this.sKh;
            i = this.rFz;
            if (!this.rFI)
            {
              bool = true;
              label310:
              paramRecyclerView.Z(i, bool);
            }
          }
          else
          {
            label319:
            this.rFI = false;
            this.rFx = 0;
            if (!this.rFE) {
              break label643;
            }
            Log.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollMore");
            this.sKf.getAdapter().aE(this.sKf.getDataCount(), 5);
            paramRecyclerView = this.sKg;
            this.rFE = false;
            int k = this.sKf.getDataCount();
            j = k / this.rFA;
            i = j;
            if (k % this.rFA == 0) {
              i = j + 1;
            }
            int m = i + 1;
            j = this.rFA * m;
            i = j;
            if (j <= 0) {
              i = 0;
            }
            Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo smoothScrollToLastPage allCount: %d, lastPage: %d, targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
            this.sKg = paramRecyclerView;
            this.rFC = true;
            j = Em(i);
            this.alG = En(j);
            this.rFz = Em(this.rFD.kK());
            Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.rFz), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.alG) });
            if (j != this.rFz) {
              break label631;
            }
            cqk();
          }
        }
        for (;;)
        {
          if (!this.rFJ) {
            break label648;
          }
          Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.rFJ = false;
          this.sKf.scrollBy(-1, 0);
          break;
          bool = false;
          break label310;
          Log.e("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.rFz) });
          break label319;
          label631:
          W(this.alG, true);
          continue;
          label643:
          cqk();
        }
      }
      else
      {
        label648:
        if (paramInt == 1)
        {
          Log.i("MicroMsg.BizTimeLineViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.rFI = true;
        }
      }
    }
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(266884);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramRecyclerView);
    localb.sg(paramInt1);
    localb.sg(paramInt2);
    a.c("com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    this.rFx += paramInt1;
    if ((this.sKh != null) && ((paramInt1 != 0) || (paramInt2 != 0))) {
      this.sKh.GR(this.rFx);
    }
    this.CL += paramInt1;
    a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
    AppMethodBeat.o(266884);
  }
  
  public static abstract interface a
  {
    public abstract void GR(int paramInt);
    
    public abstract void Z(int paramInt, boolean paramBoolean);
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.i
 * JD-Core Version:    0.7.0.1
 */