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
import androidx.recyclerview.widget.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
  extends RecyclerView.l
{
  int CL;
  private b Cyp;
  private a Cyq;
  private int alG;
  private Context mContext;
  private int mLastState;
  private RecyclerView mRecyclerView;
  private RecyclerView.r mSmoothScroller;
  private float pEE;
  private int rFA;
  private boolean rFC;
  private LinearLayoutManager rFD;
  private boolean rFE;
  private int rFF;
  private boolean rFH;
  private boolean rFI;
  private boolean rFJ;
  private int rFw;
  private int rFx;
  private RecyclerView.r rFy;
  private int rFz;
  
  public c()
  {
    AppMethodBeat.i(211255);
    this.rFx = 0;
    this.rFz = 0;
    this.pEE = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.Cyp = null;
    this.alG = -1;
    this.rFC = false;
    this.rFE = false;
    this.Cyq = null;
    this.mLastState = 0;
    this.rFH = false;
    this.rFI = false;
    this.rFJ = false;
    this.rFF = 1;
    AppMethodBeat.o(211255);
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
  
  private int En(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return this.rFA * paramInt + 1;
  }
  
  private void cqj()
  {
    this.rFC = false;
    this.rFE = false;
    this.Cyp = null;
    this.alG = -1;
  }
  
  private void cqk()
  {
    AppMethodBeat.i(211263);
    if (this.rFC)
    {
      Log.i("GameChatRoom.CommonLineViewPagerHelper", "alvinluo onScrollAnimationEnd");
      cqj();
    }
    AppMethodBeat.o(211263);
  }
  
  final int Ek(int paramInt)
  {
    AppMethodBeat.i(211264);
    int i = this.rFz;
    float f = this.mRecyclerView.getWidth();
    int k = this.rFz;
    Log.d("GameChatRoom.CommonLineViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.rFw), Integer.valueOf(paramInt - this.rFw), Float.valueOf(f), Float.valueOf(this.pEE), Integer.valueOf(this.rFz) });
    if (paramInt - this.rFw >= f / 2.0F)
    {
      i = Em(this.rFD.kL());
      int m = this.mRecyclerView.getAdapter().getItemCount();
      int j = m / this.rFA;
      paramInt = j;
      if (m % this.rFA != 0) {
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
      Log.i("GameChatRoom.CommonLineViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(En(paramInt)) });
      paramInt = El(paramInt);
      AppMethodBeat.o(211264);
      return paramInt;
      if ((paramInt - this.rFw >= 0) && (paramInt - this.rFw < this.pEE))
      {
        Log.i("GameChatRoom.CommonLineViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(El(i)) });
        paramInt = El(i);
        AppMethodBeat.o(211264);
        return paramInt;
      }
      if (paramInt - this.rFw > -f / 2.0F) {
        break;
      }
      i = Em(this.rFD.kJ());
      break;
      label329:
      paramInt = i;
      if (k - i > 1) {
        paramInt = k - 1;
      }
    }
  }
  
  final void W(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(211267);
    if ((this.mRecyclerView != null) && ((this.rFI) || (paramBoolean)))
    {
      this.rFy.alG = paramInt;
      this.rFJ = true;
      this.mRecyclerView.getLayoutManager().startSmoothScroll(this.rFy);
    }
    AppMethodBeat.o(211267);
  }
  
  public final void a(Context paramContext, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(211256);
    this.mContext = paramContext;
    this.mRecyclerView = paramRecyclerView;
    this.rFA = 5;
    this.mRecyclerView.b(this);
    this.mRecyclerView.a(this);
    this.rFD = ((LinearLayoutManager)this.mRecyclerView.getLayoutManager());
    this.mSmoothScroller = new p(this.mRecyclerView.getContext())
    {
      public final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 80.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final PointF cB(int paramAnonymousInt)
      {
        AppMethodBeat.i(210962);
        PointF localPointF = ((LinearLayoutManager)c.a(c.this).getLayoutManager()).cB(paramAnonymousInt);
        AppMethodBeat.o(210962);
        return localPointF;
      }
      
      public final int cF(int paramAnonymousInt)
      {
        AppMethodBeat.i(210961);
        paramAnonymousInt = super.cF(paramAnonymousInt);
        AppMethodBeat.o(210961);
        return paramAnonymousInt;
      }
      
      public final int kQ()
      {
        return -1;
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(210963);
        super.onStart();
        AppMethodBeat.o(210963);
      }
      
      public final void onStop()
      {
        AppMethodBeat.i(210964);
        super.onStop();
        AppMethodBeat.o(210964);
      }
    };
    this.rFy = new p(this.mRecyclerView.getContext())
    {
      public final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 40.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final PointF cB(int paramAnonymousInt)
      {
        AppMethodBeat.i(210919);
        PointF localPointF = ((LinearLayoutManager)c.a(c.this).getLayoutManager()).cB(paramAnonymousInt);
        AppMethodBeat.o(210919);
        return localPointF;
      }
      
      public final int kQ()
      {
        return -1;
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(210920);
        super.onStart();
        c.evW();
        AppMethodBeat.o(210920);
      }
      
      public final void onStop()
      {
        AppMethodBeat.i(210921);
        super.onStop();
        Log.i("GameChatRoom.CommonLineViewPagerHelper", "alvinluo SmoothScrollerForFling onStop %d", new Object[] { Integer.valueOf(c.a(c.this).getScrollState()) });
        if (c.a(c.this).getScrollState() == 0) {
          c.b(c.this);
        }
        AppMethodBeat.o(210921);
      }
    };
    AppMethodBeat.o(211256);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(211262);
    b localb = new b();
    localb.bn(paramRecyclerView);
    localb.sg(paramInt);
    a.c("com/tencent/mm/plugin/game/chatroom/view/CommonLineViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    Log.i("GameChatRoom.CommonLineViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if ((paramInt == 0) && (this.mLastState != 2))
    {
      i = Ek(this.CL);
      if ((this.mRecyclerView != null) && (this.rFI))
      {
        this.mSmoothScroller.alG = i;
        this.rFJ = true;
        this.mRecyclerView.getLayoutManager().startSmoothScroll(this.mSmoothScroller);
      }
      this.rFH = true;
    }
    for (;;)
    {
      this.mLastState = paramInt;
      a.a(this, "com/tencent/mm/plugin/game/chatroom/view/CommonLineViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(211262);
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
        Log.i("GameChatRoom.CommonLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", new Object[] { Integer.valueOf(j) });
        if (j != -1)
        {
          this.rFz = (j / this.rFA);
          Log.i("GameChatRoom.CommonLineViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", new Object[] { Integer.valueOf(this.rFz), Integer.valueOf(j) });
          if ((i != this.rFz) && (this.Cyq != null)) {}
          label291:
          this.rFI = false;
          this.rFx = 0;
          if (!this.rFE) {
            break label616;
          }
          Log.d("GameChatRoom.CommonLineViewPagerHelper", "alvinluo scrollMore");
          this.mRecyclerView.getAdapter().aE(this.mRecyclerView.getAdapter().getItemCount(), 5);
          paramRecyclerView = this.Cyp;
          this.rFE = false;
          int k = this.mRecyclerView.getAdapter().getItemCount();
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
          Log.i("GameChatRoom.CommonLineViewPagerHelper", "alvinluo smoothScrollToLastPage allCount: %d, lastPage: %d, targetPos: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
          this.Cyp = paramRecyclerView;
          this.rFC = true;
          j = Em(i);
          this.alG = En(j);
          this.rFz = Em(this.rFD.kK());
          Log.i("GameChatRoom.CommonLineViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", new Object[] { Integer.valueOf(this.rFz), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.alG) });
          if (j != this.rFz) {
            break label604;
          }
          cqk();
        }
        for (;;)
        {
          if (!this.rFJ) {
            break label621;
          }
          Log.i("GameChatRoom.CommonLineViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
          this.rFJ = false;
          this.mRecyclerView.scrollBy(-1, 0);
          break;
          Log.e("GameChatRoom.CommonLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", new Object[] { Integer.valueOf(this.rFz) });
          break label291;
          label604:
          W(this.alG, true);
          continue;
          label616:
          cqk();
        }
      }
      else
      {
        label621:
        if (paramInt == 1)
        {
          Log.i("GameChatRoom.CommonLineViewPagerHelper", "SCROLL_STATE_DRAGGING");
          this.rFI = true;
        }
      }
    }
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211259);
    b localb = new b();
    localb.bn(paramRecyclerView);
    localb.sg(paramInt1);
    localb.sg(paramInt2);
    a.c("com/tencent/mm/plugin/game/chatroom/view/CommonLineViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    this.rFx += paramInt1;
    this.CL += paramInt1;
    a.a(this, "com/tencent/mm/plugin/game/chatroom/view/CommonLineViewPagerHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
    AppMethodBeat.o(211259);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.c
 * JD-Core Version:    0.7.0.1
 */