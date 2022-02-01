package com.tencent.mm.plugin.finder.view.indictor;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.view.FinderViewPager.a;
import com.tencent.mm.view.MediaBannerIndicator;
import com.tencent.mm.view.d;
import com.tencent.mm.view.i.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator2;", "Lcom/tencent/mm/view/MediaBannerIndicator;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downX", "", "canScrollHorizontally", "", "direction", "parent", "Landroid/view/ViewGroup;", "x", "y", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMediaGestureIndicator2
  extends MediaBannerIndicator
  implements FinderViewPager.a
{
  private float fif;
  
  public FinderMediaGestureIndicator2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(345500);
    setIndicatorWidth((int)getResources().getDimension(e.c.Edge_A));
    setIndicatorMargin(d.e(getContext(), 3.0F));
    setUnSelectDrawable(getContext().getDrawable(e.d.finder_indicator_gray_radius));
    setSelectDrawable(getContext().getDrawable(e.d.finder_indicator_white_radius));
    AppMethodBeat.o(345500);
  }
  
  public FinderMediaGestureIndicator2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(345508);
    setIndicatorWidth((int)getResources().getDimension(e.c.Edge_A));
    setIndicatorMargin(d.e(getContext(), 3.0F));
    setUnSelectDrawable(getContext().getDrawable(e.d.finder_indicator_gray_radius));
    setSelectDrawable(getContext().getDrawable(e.d.finder_indicator_white_radius));
    AppMethodBeat.o(345508);
  }
  
  public final boolean a(int paramInt, ViewGroup paramViewGroup, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(345527);
    s.u(paramViewGroup, "parent");
    AppMethodBeat.o(345527);
    return true;
  }
  
  public final boolean canScrollHorizontally(int paramInt)
  {
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(345519);
    s.u(paramMotionEvent, "event");
    super.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() == 0) {
      this.fif = paramMotionEvent.getX();
    }
    for (;;)
    {
      AppMethodBeat.o(345519);
      return true;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        float f = paramMotionEvent.getX() - this.fif;
        if (Math.abs(f) >= 15.0F)
        {
          if (f < 0.0F)
          {
            paramMotionEvent = getOnSelectedPageListener();
            if (paramMotionEvent != null) {
              paramMotionEvent.Ng(Math.min(getCurrentIndex() + 1, getCount() - 1));
            }
          }
          else
          {
            paramMotionEvent = getOnSelectedPageListener();
            if (paramMotionEvent != null) {
              paramMotionEvent.Ng(Math.max(getCurrentIndex() - 1, 0));
            }
          }
        }
        else if (this.fif < getWidth() / 2.0F)
        {
          paramMotionEvent = getOnSelectedPageListener();
          if (paramMotionEvent != null) {
            paramMotionEvent.Ng(Math.max(getCurrentIndex() - 1, 0));
          }
        }
        else
        {
          paramMotionEvent = getOnSelectedPageListener();
          if (paramMotionEvent != null) {
            paramMotionEvent.Ng(Math.min(getCurrentIndex() + 1, getCount() - 1));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.indictor.FinderMediaGestureIndicator2
 * JD-Core Version:    0.7.0.1
 */