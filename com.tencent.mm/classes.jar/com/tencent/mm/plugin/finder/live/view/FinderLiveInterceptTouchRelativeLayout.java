package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveInterceptTouchRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interceptTouch", "", "getInterceptTouch", "()Z", "setInterceptTouch", "(Z)V", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveInterceptTouchRelativeLayout
  extends RelativeLayout
{
  private boolean DNQ;
  
  public FinderLiveInterceptTouchRelativeLayout(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(357942);
    AppMethodBeat.o(357942);
  }
  
  public FinderLiveInterceptTouchRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(357935);
    AppMethodBeat.o(357935);
  }
  
  public FinderLiveInterceptTouchRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(357931);
    AppMethodBeat.o(357931);
  }
  
  public final boolean getInterceptTouch()
  {
    return this.DNQ;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(357956);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    if (this.DNQ)
    {
      requestDisallowInterceptTouchEvent(true);
      AppMethodBeat.o(357956);
      return bool;
    }
    requestDisallowInterceptTouchEvent(false);
    AppMethodBeat.o(357956);
    return bool;
  }
  
  public final void setInterceptTouch(boolean paramBoolean)
  {
    this.DNQ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveInterceptTouchRelativeLayout
 * JD-Core Version:    0.7.0.1
 */