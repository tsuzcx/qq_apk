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
import androidx.recyclerview.widget.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class i
  extends RecyclerView.l
{
  int biT;
  private int cag;
  private Context mContext;
  private int mLastState;
  private RecyclerView.r mSmoothScroller;
  private float sJP;
  int uQI;
  int uQJ;
  private RecyclerView.r uQK;
  int uQL;
  int uQM;
  private boolean uQO;
  private LinearLayoutManager uQP;
  private boolean uQQ;
  private int uQR;
  private boolean uQT;
  private boolean uQU;
  private boolean uQV;
  BizTimeLineHotListView vQf;
  private b vQg;
  a vQh;
  
  public i(int paramInt)
  {
    AppMethodBeat.i(6143);
    this.uQJ = 0;
    this.uQL = 0;
    this.sJP = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.vQg = null;
    this.cag = -1;
    this.uQO = false;
    this.uQQ = false;
    this.uQR = 0;
    this.vQh = null;
    this.mLastState = 0;
    this.uQT = false;
    this.uQU = false;
    this.uQV = false;
    this.uQR = paramInt;
    AppMethodBeat.o(6143);
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
  
  public static int EN(int paramInt)
  {
    AppMethodBeat.i(6149);
    if (paramInt == 0)
    {
      AppMethodBeat.o(6149);
      return 0;
    }
    int i = c.getCompletelyCountPerPage();
    AppMethodBeat.o(6149);
    return i * paramInt + 1;
  }
  
  public static int Hs(int paramInt)
  {
    AppMethodBeat.i(6150);
    int i = c.getCompletelyCountPerPage();
    AppMethodBeat.o(6150);
    return (paramInt + 1) * i + 1;
  }
  
  private void cSQ()
  {
    this.uQO = false;
    this.uQQ = false;
    this.vQg = null;
    this.cag = -1;
  }
  
  private void cSR()
  {
    AppMethodBeat.i(6146);
    if (this.uQO)
    {
      Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollAnimationEnd");
      cSQ();
    }
    AppMethodBeat.o(6146);
  }
  
  final int EK(int paramInt)
  {
    AppMethodBeat.i(6147);
    int i = this.uQL;
    float f = this.vQf.getWidth();
    int k = this.uQL;
    Log.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.uQI), Integer.valueOf(paramInt - this.uQI), Float.valueOf(f), Float.valueOf(this.sJP), Integer.valueOf(this.uQL) });
    if (paramInt - this.uQI >= f / 2.0F)
    {
      i = EM(this.uQP.Jw());
      int m = this.vQf.getAdapter().getItemCount();
      int j = m / this.uQM;
      paramInt = j;
      if (m % this.uQM != 0) {
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
      Log.i("MicroMsg.BizTimeLineViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(EN(paramInt)) });
      paramInt = EL(paramInt);
      AppMethodBeat.o(6147);
      return paramInt;
      if ((paramInt - this.uQI >= 0) && (paramInt - this.uQI < this.sJP))
      {
        Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(EL(i)) });
        paramInt = EL(i);
        AppMethodBeat.o(6147);
        return paramInt;
      }
      if (paramInt - this.uQI > -f / 2.0F) {
        break;
      }
      i = EM(this.uQP.Ju());
      break;
      label331:
      paramInt = i;
      if (k - i > 1) {
        paramInt = k - 1;
      }
    }
  }
  
  public final void a(Context paramContext, BizTimeLineHotListView paramBizTimeLineHotListView, int paramInt)
  {
    AppMethodBeat.i(302321);
    this.mContext = paramContext;
    this.vQf = paramBizTimeLineHotListView;
    this.uQM = paramInt;
    this.vQf.b(this);
    this.vQf.a(this);
    this.uQP = ((LinearLayoutManager)this.vQf.getLayoutManager());
    this.mSmoothScroller = new o(this.vQf.getContext())
    {
      public final int JB()
      {
        return -1;
      }
      
      public final float c(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 80.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final PointF fM(int paramAnonymousInt)
      {
        AppMethodBeat.i(6139);
        PointF localPointF = ((LinearLayoutManager)i.a(i.this).getLayoutManager()).fM(paramAnonymousInt);
        AppMethodBeat.o(6139);
        return localPointF;
      }
      
      public final int fP(int paramAnonymousInt)
      {
        AppMethodBeat.i(6138);
        paramAnonymousInt = super.fP(paramAnonymousInt);
        AppMethodBeat.o(6138);
        return paramAnonymousInt;
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(302404);
        super.onStart();
        AppMethodBeat.o(302404);
      }
      
      public final void onStop()
      {
        AppMethodBeat.i(6140);
        super.onStop();
        AppMethodBeat.o(6140);
      }
    };
    this.uQK = new o(this.vQf.getContext())
    {
      public final int JB()
      {
        return -1;
      }
      
      public final float c(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 40.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final PointF fM(int paramAnonymousInt)
      {
        AppMethodBeat.i(6141);
        PointF localPointF = ((LinearLayoutManager)i.a(i.this).getLayoutManager()).fM(paramAnonymousInt);
        AppMethodBeat.o(6141);
        return localPointF;
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(302379);
        super.onStart();
        i.deE();
        AppMethodBeat.o(302379);
      }
      
      public final void onStop()
      {
        AppMethodBeat.i(6142);
        super.onStop();
        Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo SmoothScrollerForFling onStop %d", new Object[] { Integer.valueOf(i.a(i.this).getScrollState()) });
        if (i.a(i.this).getScrollState() == 0) {
          i.b(i.this);
        }
        AppMethodBeat.o(6142);
      }
    };
    AppMethodBeat.o(302321);
  }
  
  final void am(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(6148);
    if ((this.vQf != null) && ((this.uQU) || (paramBoolean)))
    {
      this.uQK.cag = paramInt;
      this.uQV = true;
      this.vQf.getLayoutManager().startSmoothScroll(this.uQK);
    }
    AppMethodBeat.o(6148);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(302347);
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt);
    a.c("com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if ((paramInt == 0) && (this.mLastState != 2))
    {
      i = EK(this.biT);
      if ((this.vQf != null) && (this.uQU))
      {
        this.mSmoothScroller.cag = i;
        this.uQV = true;
        this.vQf.getLayoutManager().startSmoothScroll(this.mSmoothScroller);
      }
      this.uQT = true;
    }
    for (;;)
    {
      this.mLastState = paramInt;
      a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(302347);
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
        Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        boolean bool;
        if (j != -1)
        {
          this.uQL = (j / this.uQM);
          Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.uQL), Integer.valueOf(j) });
          if ((i != this.uQL) && (this.vQh != null))
          {
            paramRecyclerView = this.vQh;
            i = this.uQL;
            if (!this.uQU)
            {
              bool = true;
              label311:
              paramRecyclerView.aq(i, bool);
            }
          }
          else
          {
            label320:
            this.uQU = false;
            this.uQJ = 0;
            if (!this.uQQ) {
              break label644;
            }
            Log.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollMore");
            this.vQf.getAdapter().by(this.vQf.getDataCount(), 5);
            paramRecyclerView = this.vQg;
            this.uQQ = false;
            int k = this.vQf.getDataCount();
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
            Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo smoothScrollToLastPage allCount: %d, lastPage: %d, targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
            this.vQg = paramRecyclerView;
            this.uQO = true;
            j = EM(i);
            this.cag = EN(j);
            this.uQL = EM(this.uQP.Jv());
            Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.uQL), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.cag) });
            if (j != this.uQL) {
              break label632;
            }
            cSR();
          }
        }
        for (;;)
        {
          if (!this.uQV) {
            break label649;
          }
          Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.uQV = false;
          this.vQf.scrollBy(-1, 0);
          break;
          bool = false;
          break label311;
          Log.e("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.uQL) });
          break label320;
          label632:
          am(this.cag, true);
          continue;
          label644:
          cSR();
        }
      }
      else
      {
        label649:
        if (paramInt == 1)
        {
          Log.i("MicroMsg.BizTimeLineViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.uQU = true;
        }
      }
    }
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(302332);
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt1);
    localb.sc(paramInt2);
    a.c("com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    this.uQJ += paramInt1;
    if ((this.vQh != null) && ((paramInt1 != 0) || (paramInt2 != 0))) {
      this.vQh.Hr(this.uQJ);
    }
    this.biT += paramInt1;
    a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
    AppMethodBeat.o(302332);
  }
  
  public static abstract interface a
  {
    public abstract void Hr(int paramInt);
    
    public abstract void aq(int paramInt, boolean paramBoolean);
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.i
 * JD-Core Version:    0.7.0.1
 */