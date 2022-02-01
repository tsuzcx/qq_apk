package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class n
  extends RecyclerView.l
{
  int CL;
  private int alG;
  Context mContext;
  private int mLastState;
  RecyclerView.r mSmoothScroller;
  private float pEE;
  int rFA;
  private b rFB;
  private boolean rFC;
  LinearLayoutManager rFD;
  private boolean rFE;
  private int rFF;
  a rFG;
  private boolean rFH;
  private boolean rFI;
  private boolean rFJ;
  BaseAppBrandRecentView rFv;
  private int rFw;
  private int rFx;
  RecyclerView.r rFy;
  int rFz;
  
  public n(int paramInt)
  {
    AppMethodBeat.i(275299);
    this.rFx = 0;
    this.rFz = 0;
    this.pEE = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.rFB = null;
    this.alG = -1;
    this.rFC = false;
    this.rFE = false;
    this.rFF = 0;
    this.rFG = null;
    this.mLastState = 0;
    this.rFH = false;
    this.rFI = false;
    this.rFJ = false;
    this.rFF = paramInt;
    AppMethodBeat.o(275299);
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
  
  private static int En(int paramInt)
  {
    AppMethodBeat.i(275309);
    if (paramInt == 0)
    {
      AppMethodBeat.o(275309);
      return 0;
    }
    int i = d.getCompletelyCountPerPage();
    d.cqh();
    AppMethodBeat.o(275309);
    return i * paramInt + 1;
  }
  
  private void cqj()
  {
    this.rFC = false;
    this.rFE = false;
    this.rFB = null;
    this.alG = -1;
  }
  
  private void cqk()
  {
    AppMethodBeat.i(275305);
    if (this.rFC)
    {
      Log.i("ViewPagerHelper", "alvinluo onScrollAnimationEnd");
      cqj();
    }
    AppMethodBeat.o(275305);
  }
  
  final int Ek(int paramInt)
  {
    AppMethodBeat.i(275306);
    int i = this.rFz;
    float f = this.rFv.getWidth();
    int k = this.rFz;
    Log.d("ViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.rFw), Integer.valueOf(paramInt - this.rFw), Float.valueOf(f), Float.valueOf(this.pEE), Integer.valueOf(this.rFz) });
    if (paramInt - this.rFw >= f / 2.0F)
    {
      i = Em(this.rFD.kL());
      int m = this.rFv.getAdapter().getItemCount();
      int j = m / this.rFA;
      paramInt = j;
      if (m % this.rFA != 0) {
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
      Log.i("ViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(En(paramInt)) });
      paramInt = El(paramInt);
      AppMethodBeat.o(275306);
      return paramInt;
      if ((paramInt - this.rFw >= 0) && (paramInt - this.rFw < this.pEE))
      {
        Log.i("ViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(El(i)) });
        paramInt = El(i);
        AppMethodBeat.o(275306);
        return paramInt;
      }
      if (paramInt - this.rFw > -f / 2.0F) {
        break;
      }
      i = Em(this.rFD.kJ());
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
    AppMethodBeat.i(275307);
    if ((this.rFv != null) && ((this.rFI) || (paramBoolean)))
    {
      this.rFy.alG = paramInt;
      this.rFJ = true;
      this.rFv.getLayoutManager().startSmoothScroll(this.rFy);
    }
    AppMethodBeat.o(275307);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(275304);
    b localb = new b();
    localb.bn(paramRecyclerView);
    localb.sg(paramInt);
    a.c("com/tencent/mm/plugin/appbrand/widget/recent/ViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    Log.i("ViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if ((paramInt == 0) && (this.mLastState != 2))
    {
      i = Ek(this.CL);
      if ((this.rFv != null) && (this.rFI))
      {
        this.mSmoothScroller.alG = i;
        this.rFJ = true;
        this.rFv.getLayoutManager().startSmoothScroll(this.mSmoothScroller);
      }
      this.rFH = true;
    }
    for (;;)
    {
      this.mLastState = paramInt;
      a.a(this, "com/tencent/mm/plugin/appbrand/widget/recent/ViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(275304);
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
        Log.i("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        if (j != -1)
        {
          this.rFz = (j / this.rFA);
          Log.i("ViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.rFz), Integer.valueOf(j) });
          if ((i != this.rFz) && (this.rFG != null)) {}
          label291:
          this.rFI = false;
          this.rFx = 0;
          if (!this.rFE) {
            break label483;
          }
          Log.d("ViewPagerHelper", "alvinluo scrollMore");
          d.cqh();
          this.rFE = false;
          this.rFB = this.rFB;
          this.rFC = true;
          i = Em(0);
          this.alG = En(i);
          this.rFz = Em(this.rFD.kK());
          Log.i("ViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.rFz), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(this.alG) });
          W(this.alG, true);
          cqk();
        }
        for (;;)
        {
          if (!this.rFJ) {
            break label488;
          }
          Log.i("ViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.rFJ = false;
          this.rFv.scrollBy(-1, 0);
          break;
          Log.e("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.rFz) });
          break label291;
          label483:
          cqk();
        }
      }
      else
      {
        label488:
        if (paramInt == 1)
        {
          Log.i("ViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.rFI = true;
        }
      }
    }
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(275302);
    b localb = new b();
    localb.bn(paramRecyclerView);
    localb.sg(paramInt1);
    localb.sg(paramInt2);
    a.c("com/tencent/mm/plugin/appbrand/widget/recent/ViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    this.rFx += paramInt1;
    this.CL += paramInt1;
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/recent/ViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
    AppMethodBeat.o(275302);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.n
 * JD-Core Version:    0.7.0.1
 */