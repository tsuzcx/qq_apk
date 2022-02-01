package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.support.v4.view.m;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "Landroid/support/v4/view/NestedScrollingParent;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "nestedScrollTarget", "Landroid/view/View;", "nestedScrollTargetIsBeingDragged", "", "nestedScrollTargetWasUnableToScroll", "skipsTouchInterception", "dispatchNestedPreScroll", "dx", "dy", "consumed", "", "offsetInWindow", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "e", "onNestedScroll", "", "target", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "nestedScrollAxes", "onStopNestedScroll", "plugin-finder_release"})
public final class FinderLiveRecyclerView
  extends WxRecyclerView
  implements m
{
  private final String TAG;
  private View uzT;
  private boolean uzU;
  private boolean uzV;
  private boolean uzW;
  
  public FinderLiveRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(247565);
    this.TAG = "Finder.FinderLiveRecyclerView";
    AppMethodBeat.o(247565);
  }
  
  public FinderLiveRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(247566);
    this.TAG = "Finder.FinderLiveRecyclerView";
    AppMethodBeat.o(247566);
  }
  
  public final boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(247561);
    if (this.uzT != null)
    {
      paramArrayOfInt1 = this.uzT;
      if (paramArrayOfInt1 == null) {
        p.hyc();
      }
      if (paramArrayOfInt1.getId() == 2131300974) {}
    }
    else
    {
      AppMethodBeat.o(247561);
      return true;
    }
    AppMethodBeat.o(247561);
    return false;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(247558);
    if (this.uzT != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.uzW = true;
      }
      boolean bool2 = super.dispatchTouchEvent(paramMotionEvent);
      boolean bool1 = bool2;
      if (i != 0)
      {
        this.uzW = false;
        if (bool2)
        {
          bool1 = bool2;
          if (!this.uzV) {}
        }
        else
        {
          bool1 = super.dispatchTouchEvent(paramMotionEvent);
        }
      }
      AppMethodBeat.o(247558);
      return bool1;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(247559);
    if ((!this.uzW) && (super.onInterceptTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(247559);
      return true;
    }
    AppMethodBeat.o(247559);
    return false;
  }
  
  public final void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(247560);
    p.h(paramView, "target");
    Log.i(this.TAG, "onNestedScroll");
    if ((paramView == this.uzT) && (!this.uzU) && (paramInt2 != 0))
    {
      this.uzU = true;
      this.uzV = false;
    }
    AppMethodBeat.o(247560);
  }
  
  public final void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(247562);
    p.h(paramView1, "child");
    p.h(paramView2, "target");
    Log.i(this.TAG, "onNestedScrollAccepted");
    if ((paramInt & 0x2) != 0)
    {
      this.uzT = paramView2;
      this.uzU = false;
      this.uzV = false;
    }
    super.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    AppMethodBeat.o(247562);
  }
  
  public final boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(247563);
    p.h(paramView1, "child");
    p.h(paramView2, "target");
    if ((paramInt & 0x2) != 0)
    {
      AppMethodBeat.o(247563);
      return true;
    }
    AppMethodBeat.o(247563);
    return false;
  }
  
  public final void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(247564);
    p.h(paramView, "child");
    Log.i(this.TAG, "onStopNestedScroll");
    this.uzT = null;
    this.uzU = false;
    this.uzV = false;
    AppMethodBeat.o(247564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveRecyclerView
 * JD-Core Version:    0.7.0.1
 */