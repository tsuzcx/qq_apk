package com.tencent.mm.plugin.game.chatroom.view;

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

public final class c
  extends RecyclerView.l
{
  private b Iqr;
  private a Iqs;
  int biT;
  private int cag;
  private Context mContext;
  private int mLastState;
  private RecyclerView mRecyclerView;
  private RecyclerView.r mSmoothScroller;
  private float sJP;
  private int uQI;
  private int uQJ;
  private RecyclerView.r uQK;
  private int uQL;
  private int uQM;
  private boolean uQO;
  private LinearLayoutManager uQP;
  private boolean uQQ;
  private int uQR;
  private boolean uQT;
  private boolean uQU;
  private boolean uQV;
  
  public c()
  {
    AppMethodBeat.i(276330);
    this.uQJ = 0;
    this.uQL = 0;
    this.sJP = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.Iqr = null;
    this.cag = -1;
    this.uQO = false;
    this.uQQ = false;
    this.Iqs = null;
    this.mLastState = 0;
    this.uQT = false;
    this.uQU = false;
    this.uQV = false;
    this.uQR = 1;
    AppMethodBeat.o(276330);
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
  
  private int EN(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return this.uQM * paramInt + 1;
  }
  
  private void cSQ()
  {
    this.uQO = false;
    this.uQQ = false;
    this.Iqr = null;
    this.cag = -1;
  }
  
  private void cSR()
  {
    AppMethodBeat.i(276344);
    if (this.uQO)
    {
      Log.i("GameChatRoom.CommonLineViewPagerHelper", "alvinluo onScrollAnimationEnd");
      cSQ();
    }
    AppMethodBeat.o(276344);
  }
  
  final int EK(int paramInt)
  {
    AppMethodBeat.i(276416);
    int i = this.uQL;
    float f = this.mRecyclerView.getWidth();
    int k = this.uQL;
    Log.d("GameChatRoom.CommonLineViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.uQI), Integer.valueOf(paramInt - this.uQI), Float.valueOf(f), Float.valueOf(this.sJP), Integer.valueOf(this.uQL) });
    if (paramInt - this.uQI >= f / 2.0F)
    {
      i = EM(this.uQP.Jw());
      int m = this.mRecyclerView.getAdapter().getItemCount();
      int j = m / this.uQM;
      paramInt = j;
      if (m % this.uQM != 0) {
        paramInt = j + 1;
      }
      i = Math.max(Math.min(i, paramInt - 1), -1);
      if (i - k <= 1) {
        break label329;
      }
      paramInt = k + 1;
    }
    for (;;)
    {
      Log.i("GameChatRoom.CommonLineViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(EN(paramInt)) });
      paramInt = EL(paramInt);
      AppMethodBeat.o(276416);
      return paramInt;
      if ((paramInt - this.uQI >= 0) && (paramInt - this.uQI < this.sJP))
      {
        Log.i("GameChatRoom.CommonLineViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(EL(i)) });
        paramInt = EL(i);
        AppMethodBeat.o(276416);
        return paramInt;
      }
      if (paramInt - this.uQI > -f / 2.0F) {
        break;
      }
      i = EM(this.uQP.Ju());
      break;
      label329:
      paramInt = i;
      if (k - i > 1) {
        paramInt = k - 1;
      }
    }
  }
  
  public final void a(Context paramContext, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(276386);
    this.mContext = paramContext;
    this.mRecyclerView = paramRecyclerView;
    this.uQM = 5;
    this.mRecyclerView.b(this);
    this.mRecyclerView.a(this);
    this.uQP = ((LinearLayoutManager)this.mRecyclerView.getLayoutManager());
    this.mSmoothScroller = new o(this.mRecyclerView.getContext())
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
        AppMethodBeat.i(276427);
        PointF localPointF = ((LinearLayoutManager)c.a(c.this).getLayoutManager()).fM(paramAnonymousInt);
        AppMethodBeat.o(276427);
        return localPointF;
      }
      
      public final int fP(int paramAnonymousInt)
      {
        AppMethodBeat.i(276423);
        paramAnonymousInt = super.fP(paramAnonymousInt);
        AppMethodBeat.o(276423);
        return paramAnonymousInt;
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(276433);
        super.onStart();
        AppMethodBeat.o(276433);
      }
      
      public final void onStop()
      {
        AppMethodBeat.i(276439);
        super.onStop();
        AppMethodBeat.o(276439);
      }
    };
    this.uQK = new o(this.mRecyclerView.getContext())
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
        AppMethodBeat.i(276445);
        PointF localPointF = ((LinearLayoutManager)c.a(c.this).getLayoutManager()).fM(paramAnonymousInt);
        AppMethodBeat.o(276445);
        return localPointF;
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(276452);
        super.onStart();
        c.fDu();
        AppMethodBeat.o(276452);
      }
      
      public final void onStop()
      {
        AppMethodBeat.i(276460);
        super.onStop();
        Log.i("GameChatRoom.CommonLineViewPagerHelper", "alvinluo SmoothScrollerForFling onStop %d", new Object[] { Integer.valueOf(c.a(c.this).getScrollState()) });
        if (c.a(c.this).getScrollState() == 0) {
          c.b(c.this);
        }
        AppMethodBeat.o(276460);
      }
    };
    AppMethodBeat.o(276386);
  }
  
  final void am(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(276421);
    if ((this.mRecyclerView != null) && ((this.uQU) || (paramBoolean)))
    {
      this.uQK.cag = paramInt;
      this.uQV = true;
      this.mRecyclerView.getLayoutManager().startSmoothScroll(this.uQK);
    }
    AppMethodBeat.o(276421);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(276403);
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt);
    a.c("com/tencent/mm/plugin/game/chatroom/view/CommonLineViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    Log.i("GameChatRoom.CommonLineViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if ((paramInt == 0) && (this.mLastState != 2))
    {
      i = EK(this.biT);
      if ((this.mRecyclerView != null) && (this.uQU))
      {
        this.mSmoothScroller.cag = i;
        this.uQV = true;
        this.mRecyclerView.getLayoutManager().startSmoothScroll(this.mSmoothScroller);
      }
      this.uQT = true;
    }
    for (;;)
    {
      this.mLastState = paramInt;
      a.a(this, "com/tencent/mm/plugin/game/chatroom/view/CommonLineViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(276403);
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
        Log.i("GameChatRoom.CommonLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        if (j != -1)
        {
          this.uQL = (j / this.uQM);
          Log.i("GameChatRoom.CommonLineViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.uQL), Integer.valueOf(j) });
          if ((i != this.uQL) && (this.Iqs != null)) {}
          label291:
          this.uQU = false;
          this.uQJ = 0;
          if (!this.uQQ) {
            break label616;
          }
          Log.d("GameChatRoom.CommonLineViewPagerHelper", "alvinluo scrollMore");
          this.mRecyclerView.getAdapter().by(this.mRecyclerView.getAdapter().getItemCount(), 5);
          paramRecyclerView = this.Iqr;
          this.uQQ = false;
          int k = this.mRecyclerView.getAdapter().getItemCount();
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
          Log.i("GameChatRoom.CommonLineViewPagerHelper", "alvinluo smoothScrollToLastPage allCount: %d, lastPage: %d, targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
          this.Iqr = paramRecyclerView;
          this.uQO = true;
          j = EM(i);
          this.cag = EN(j);
          this.uQL = EM(this.uQP.Jv());
          Log.i("GameChatRoom.CommonLineViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.uQL), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.cag) });
          if (j != this.uQL) {
            break label604;
          }
          cSR();
        }
        for (;;)
        {
          if (!this.uQV) {
            break label621;
          }
          Log.i("GameChatRoom.CommonLineViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.uQV = false;
          this.mRecyclerView.scrollBy(-1, 0);
          break;
          Log.e("GameChatRoom.CommonLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.uQL) });
          break label291;
          label604:
          am(this.cag, true);
          continue;
          label616:
          cSR();
        }
      }
      else
      {
        label621:
        if (paramInt == 1)
        {
          Log.i("GameChatRoom.CommonLineViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.uQU = true;
        }
      }
    }
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(276393);
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt1);
    localb.sc(paramInt2);
    a.c("com/tencent/mm/plugin/game/chatroom/view/CommonLineViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    this.uQJ += paramInt1;
    this.biT += paramInt1;
    a.a(this, "com/tencent/mm/plugin/game/chatroom/view/CommonLineViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
    AppMethodBeat.o(276393);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.c
 * JD-Core Version:    0.7.0.1
 */