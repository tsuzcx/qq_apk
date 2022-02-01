package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.g.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveRecyclerView;", "Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView;", "Landroidx/core/view/NestedScrollingParent;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "nestedScrollTarget", "Landroid/view/View;", "nestedScrollTargetIsBeingDragged", "", "nestedScrollTargetWasUnableToScroll", "skipsTouchInterception", "dispatchNestedPreScroll", "dx", "dy", "consumed", "", "offsetInWindow", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "e", "onNestedScroll", "", "target", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "nestedScrollAxes", "onStopNestedScroll", "plugin-finder_release"})
public final class FinderLiveRecyclerView
  extends FinderRecyclerView
  implements o
{
  private final String TAG;
  private boolean yVA;
  private boolean yVB;
  private boolean yVC;
  private View yVz;
  
  public FinderLiveRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(286352);
    this.TAG = "Finder.FinderLiveRecyclerView";
    AppMethodBeat.o(286352);
  }
  
  public FinderLiveRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(286353);
    this.TAG = "Finder.FinderLiveRecyclerView";
    AppMethodBeat.o(286353);
  }
  
  public final boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(286348);
    if (this.yVz != null)
    {
      paramArrayOfInt1 = this.yVz;
      if (paramArrayOfInt1 == null) {
        p.iCn();
      }
      if (paramArrayOfInt1.getId() == b.f.finder_live_comment_list) {}
    }
    else
    {
      AppMethodBeat.o(286348);
      return true;
    }
    AppMethodBeat.o(286348);
    return false;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(286345);
    if (this.yVz != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.yVC = true;
      }
      boolean bool2 = super.dispatchTouchEvent(paramMotionEvent);
      boolean bool1 = bool2;
      if (i != 0)
      {
        this.yVC = false;
        if (bool2)
        {
          bool1 = bool2;
          if (!this.yVB) {}
        }
        else
        {
          bool1 = super.dispatchTouchEvent(paramMotionEvent);
        }
      }
      AppMethodBeat.o(286345);
      return bool1;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(286346);
    if ((!this.yVC) && (super.onInterceptTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(286346);
      return true;
    }
    AppMethodBeat.o(286346);
    return false;
  }
  
  public final void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(286347);
    p.k(paramView, "target");
    Log.i(this.TAG, "onNestedScroll");
    if ((paramView == this.yVz) && (!this.yVA) && (paramInt2 != 0))
    {
      this.yVA = true;
      this.yVB = false;
    }
    AppMethodBeat.o(286347);
  }
  
  public final void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(286349);
    p.k(paramView1, "child");
    p.k(paramView2, "target");
    Log.i(this.TAG, "onNestedScrollAccepted");
    if ((paramInt & 0x2) != 0)
    {
      this.yVz = paramView2;
      this.yVA = false;
      this.yVB = false;
    }
    super.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    AppMethodBeat.o(286349);
  }
  
  public final boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(286350);
    p.k(paramView1, "child");
    p.k(paramView2, "target");
    if ((paramInt & 0x2) != 0)
    {
      AppMethodBeat.o(286350);
      return true;
    }
    AppMethodBeat.o(286350);
    return false;
  }
  
  public final void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(286351);
    p.k(paramView, "child");
    Log.i(this.TAG, "onStopNestedScroll");
    this.yVz = null;
    this.yVA = false;
    this.yVB = false;
    AppMethodBeat.o(286351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveRecyclerView
 * JD-Core Version:    0.7.0.1
 */