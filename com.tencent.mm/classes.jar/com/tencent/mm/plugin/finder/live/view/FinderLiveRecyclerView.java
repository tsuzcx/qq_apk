package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.g.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveRecyclerView;", "Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView;", "Landroidx/core/view/NestedScrollingParent;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "nestedScrollTarget", "Landroid/view/View;", "nestedScrollTargetIsBeingDragged", "", "nestedScrollTargetWasUnableToScroll", "skipsTouchInterception", "dispatchNestedPreScroll", "dx", "dy", "consumed", "", "offsetInWindow", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "e", "onNestedScroll", "", "target", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "nestedScrollAxes", "onStopNestedScroll", "scrollBy", "x", "y", "scrollTo", "scrollToPosition", "position", "smoothScrollBy", "interpolator", "Landroid/view/animation/Interpolator;", "smoothScrollToPosition", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveRecyclerView
  extends FinderRecyclerView
  implements o
{
  private View DPm;
  private boolean DPn;
  private boolean DPo;
  private boolean DPp;
  private final String TAG;
  
  public FinderLiveRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(358057);
    this.TAG = "Finder.FinderLiveRecyclerView";
    AppMethodBeat.o(358057);
  }
  
  public FinderLiveRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(358065);
    this.TAG = "Finder.FinderLiveRecyclerView";
    AppMethodBeat.o(358065);
  }
  
  public final void a(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(358154);
    Log.i(this.TAG, "smoothScrollBy");
    super.a(paramInt1, paramInt2, paramInterpolator);
    AppMethodBeat.o(358154);
  }
  
  public final void br(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(358148);
    Log.i(this.TAG, "smoothScrollBy");
    super.br(paramInt1, paramInt2);
    AppMethodBeat.o(358148);
  }
  
  public final boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(358094);
    if (this.DPm != null)
    {
      paramArrayOfInt1 = this.DPm;
      s.checkNotNull(paramArrayOfInt1);
      if (paramArrayOfInt1.getId() == p.e.BJS) {}
    }
    else
    {
      AppMethodBeat.o(358094);
      return true;
    }
    AppMethodBeat.o(358094);
    return false;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(358076);
    if (this.DPm != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.DPp = true;
      }
      boolean bool2 = super.dispatchTouchEvent(paramMotionEvent);
      boolean bool1 = bool2;
      if (i != 0)
      {
        this.DPp = false;
        if (bool2)
        {
          bool1 = bool2;
          if (!this.DPo) {}
        }
        else
        {
          bool1 = super.dispatchTouchEvent(paramMotionEvent);
        }
      }
      AppMethodBeat.o(358076);
      return bool1;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(358083);
    if ((!this.DPp) && (super.onInterceptTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(358083);
      return true;
    }
    AppMethodBeat.o(358083);
    return false;
  }
  
  public final void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(358089);
    s.u(paramView, "target");
    Log.i(this.TAG, "onNestedScroll");
    if ((paramView == this.DPm) && (!this.DPn) && (paramInt2 != 0))
    {
      this.DPn = true;
      this.DPo = false;
    }
    AppMethodBeat.o(358089);
  }
  
  public final void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(358101);
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    Log.i(this.TAG, "onNestedScrollAccepted");
    if ((paramInt & 0x2) != 0)
    {
      this.DPm = paramView2;
      this.DPn = false;
      this.DPo = false;
    }
    super.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    AppMethodBeat.o(358101);
  }
  
  public final boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(358110);
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    if ((paramInt & 0x2) != 0)
    {
      AppMethodBeat.o(358110);
      return true;
    }
    AppMethodBeat.o(358110);
    return false;
  }
  
  public final void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(358116);
    s.u(paramView, "child");
    Log.i(this.TAG, "onStopNestedScroll");
    this.DPm = null;
    this.DPn = false;
    this.DPo = false;
    AppMethodBeat.o(358116);
  }
  
  public final void scrollBy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(358126);
    Log.i(this.TAG, "scrollBy");
    super.scrollBy(paramInt1, paramInt2);
    AppMethodBeat.o(358126);
  }
  
  public final void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(358134);
    Log.i(this.TAG, "scrollTo");
    super.scrollTo(paramInt1, paramInt2);
    AppMethodBeat.o(358134);
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(358121);
    Log.i(this.TAG, s.X("scrollToPosition ", Integer.valueOf(paramInt)));
    super.scrollToPosition(paramInt);
    AppMethodBeat.o(358121);
  }
  
  public final void smoothScrollToPosition(int paramInt)
  {
    AppMethodBeat.i(358142);
    Log.i(this.TAG, "smoothScrollToPosition");
    super.smoothScrollToPosition(paramInt);
    AppMethodBeat.o(358142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveRecyclerView
 * JD-Core Version:    0.7.0.1
 */