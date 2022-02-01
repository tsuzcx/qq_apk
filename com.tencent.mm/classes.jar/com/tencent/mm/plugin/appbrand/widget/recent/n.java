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
import androidx.recyclerview.widget.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class n
  extends RecyclerView.l
{
  int biT;
  private int cag;
  Context mContext;
  private int mLastState;
  RecyclerView.r mSmoothScroller;
  private float sJP;
  BaseAppBrandRecentView uQH;
  private int uQI;
  private int uQJ;
  RecyclerView.r uQK;
  int uQL;
  int uQM;
  private b uQN;
  private boolean uQO;
  LinearLayoutManager uQP;
  private boolean uQQ;
  private int uQR;
  a uQS;
  private boolean uQT;
  private boolean uQU;
  private boolean uQV;
  
  public n(int paramInt)
  {
    AppMethodBeat.i(324014);
    this.uQJ = 0;
    this.uQL = 0;
    this.sJP = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.uQN = null;
    this.cag = -1;
    this.uQO = false;
    this.uQQ = false;
    this.uQR = 0;
    this.uQS = null;
    this.mLastState = 0;
    this.uQT = false;
    this.uQU = false;
    this.uQV = false;
    this.uQR = paramInt;
    AppMethodBeat.o(324014);
  }
  
  private int EL(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return this.uQM * paramInt + this.uQR;
  }
  
  private int EM(int paramInt)
  {
    if (this.uQR != 0)
    {
      int j = paramInt / this.uQM;
      int i = j;
      if (paramInt % this.uQM == 0)
      {
        i = j;
        if (paramInt != 0) {
          i = j - 1;
        }
      }
      return i;
    }
    return paramInt / this.uQM;
  }
  
  private static int EN(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(324072);
    if (paramInt == 0)
    {
      AppMethodBeat.o(324072);
      return 0;
    }
    int j = d.getCompletelyCountPerPage();
    if (d.cSN()) {
      i = 1;
    }
    AppMethodBeat.o(324072);
    return i + j * paramInt;
  }
  
  private void a(int paramInt, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(324051);
    this.uQN = paramb;
    this.uQO = true;
    int i = EM(paramInt);
    this.cag = EN(i);
    this.uQL = EM(this.uQP.Jv());
    Log.i("ViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.uQL), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.cag) });
    if ((i == this.uQL) && (!paramBoolean))
    {
      cSR();
      AppMethodBeat.o(324051);
      return;
    }
    am(this.cag, true);
    AppMethodBeat.o(324051);
  }
  
  private void cSQ()
  {
    this.uQO = false;
    this.uQQ = false;
    this.uQN = null;
    this.cag = -1;
  }
  
  private void cSR()
  {
    AppMethodBeat.i(324031);
    if (this.uQO)
    {
      Log.i("ViewPagerHelper", "alvinluo onScrollAnimationEnd");
      cSQ();
    }
    AppMethodBeat.o(324031);
  }
  
  final int EK(int paramInt)
  {
    AppMethodBeat.i(324127);
    int i = this.uQL;
    float f = this.uQH.getWidth();
    int k = this.uQL;
    Log.d("ViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.uQI), Integer.valueOf(paramInt - this.uQI), Float.valueOf(f), Float.valueOf(this.sJP), Integer.valueOf(this.uQL) });
    if (paramInt - this.uQI >= f / 2.0F)
    {
      i = EM(this.uQP.Jw());
      int m = this.uQH.getAdapter().getItemCount();
      int j = m / this.uQM;
      paramInt = j;
      if (m % this.uQM != 0) {
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
      Log.i("ViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(EN(paramInt)) });
      paramInt = EL(paramInt);
      AppMethodBeat.o(324127);
      return paramInt;
      if ((paramInt - this.uQI >= 0) && (paramInt - this.uQI < this.sJP))
      {
        Log.i("ViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(EL(i)) });
        paramInt = EL(i);
        AppMethodBeat.o(324127);
        return paramInt;
      }
      if (paramInt - this.uQI > -f / 2.0F) {
        break;
      }
      i = EM(this.uQP.Ju());
      break;
      label328:
      paramInt = i;
      if (k - i > 1) {
        paramInt = k - 1;
      }
    }
  }
  
  final void am(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(324132);
    if ((this.uQH != null) && ((this.uQU) || (paramBoolean)))
    {
      this.uQK.cag = paramInt;
      this.uQV = true;
      this.uQH.getLayoutManager().startSmoothScroll(this.uQK);
    }
    AppMethodBeat.o(324132);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(324116);
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt);
    a.c("com/tencent/mm/plugin/appbrand/widget/recent/ViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    Log.i("ViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if ((paramInt == 0) && (this.mLastState != 2))
    {
      i = EK(this.biT);
      if ((this.uQH != null) && (this.uQU))
      {
        this.mSmoothScroller.cag = i;
        this.uQV = true;
        this.uQH.getLayoutManager().startSmoothScroll(this.mSmoothScroller);
      }
      this.uQT = true;
    }
    for (;;)
    {
      this.mLastState = paramInt;
      a.a(this, "com/tencent/mm/plugin/appbrand/widget/recent/ViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(324116);
      return;
      if ((!this.uQT) && (paramInt == 2))
      {
        this.uQT = true;
      }
      else if (paramInt == 0)
      {
        this.uQI = this.biT;
        this.uQT = false;
        i = this.uQL;
        int j = this.uQP.Ju();
        Log.i("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        if (j != -1)
        {
          this.uQL = (j / this.uQM);
          Log.i("ViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.uQL), Integer.valueOf(j) });
          if ((i != this.uQL) && (this.uQS != null)) {}
          label291:
          this.uQU = false;
          this.uQJ = 0;
          if (!this.uQQ) {
            break label531;
          }
          Log.d("ViewPagerHelper", "alvinluo scrollMore");
          if (!d.cSN()) {
            break label398;
          }
          this.uQQ = false;
          a(0, this.uQN, true);
          cSR();
        }
        for (;;)
        {
          if (!this.uQV) {
            break label536;
          }
          Log.i("ViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.uQV = false;
          this.uQH.scrollBy(-1, 0);
          break;
          Log.e("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.uQL) });
          break label291;
          label398:
          this.uQH.getAdapter().by(this.uQH.getDataCount(), 5);
          paramRecyclerView = this.uQN;
          this.uQQ = false;
          int k = this.uQH.getDataCount();
          j = k / this.uQM;
          i = j;
          if (k % this.uQM == 0) {
            i = j + 1;
          }
          int m = i + 1;
          j = this.uQM * m;
          i = j;
          if (j <= 0) {
            i = 0;
          }
          Log.i("ViewPagerHelper", "alvinluo smoothScrollToLastPage allCount: %d, lastPage: %d, targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
          a(i, paramRecyclerView, false);
          continue;
          label531:
          cSR();
        }
      }
      else
      {
        label536:
        if (paramInt == 1)
        {
          Log.i("ViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.uQU = true;
        }
      }
    }
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(324102);
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt1);
    localb.sc(paramInt2);
    a.c("com/tencent/mm/plugin/appbrand/widget/recent/ViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    this.uQJ += paramInt1;
    this.biT += paramInt1;
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/recent/ViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
    AppMethodBeat.o(324102);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.n
 * JD-Core Version:    0.7.0.1
 */