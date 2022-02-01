package com.tencent.mm.plugin.finder.view.indictor;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.view.FinderViewPager.a;
import com.tencent.mm.view.MediaBannerIndicator;
import com.tencent.mm.view.d;
import com.tencent.mm.view.h.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator2;", "Lcom/tencent/mm/view/MediaBannerIndicator;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downX", "", "canScrollHorizontally", "", "direction", "parent", "Landroid/view/ViewGroup;", "x", "y", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
public final class FinderMediaGestureIndicator2
  extends MediaBannerIndicator
  implements FinderViewPager.a
{
  private float dit;
  
  public FinderMediaGestureIndicator2(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(220570);
    setIndicatorWidth((int)getResources().getDimension(b.d.Edge_A));
    setIndicatorMargin(d.e(getContext(), 3.0F));
    setUnSelectDrawable(getContext().getDrawable(b.e.finder_indicator_gray_radius));
    setSelectDrawable(getContext().getDrawable(b.e.finder_indicator_white_radius));
    AppMethodBeat.o(220570);
  }
  
  public FinderMediaGestureIndicator2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(220573);
    setIndicatorWidth((int)getResources().getDimension(b.d.Edge_A));
    setIndicatorMargin(d.e(getContext(), 3.0F));
    setUnSelectDrawable(getContext().getDrawable(b.e.finder_indicator_gray_radius));
    setSelectDrawable(getContext().getDrawable(b.e.finder_indicator_white_radius));
    AppMethodBeat.o(220573);
  }
  
  public FinderMediaGestureIndicator2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220576);
    setIndicatorWidth((int)getResources().getDimension(b.d.Edge_A));
    setIndicatorMargin(d.e(getContext(), 3.0F));
    setUnSelectDrawable(getContext().getDrawable(b.e.finder_indicator_gray_radius));
    setSelectDrawable(getContext().getDrawable(b.e.finder_indicator_white_radius));
    AppMethodBeat.o(220576);
  }
  
  public final boolean a(int paramInt, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(220568);
    p.k(paramViewGroup, "parent");
    AppMethodBeat.o(220568);
    return true;
  }
  
  public final boolean canScrollHorizontally(int paramInt)
  {
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(220566);
    p.k(paramMotionEvent, "event");
    super.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() == 0) {
      this.dit = paramMotionEvent.getX();
    }
    for (;;)
    {
      AppMethodBeat.o(220566);
      return true;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        float f = paramMotionEvent.getX() - this.dit;
        if (Math.abs(f) >= 15.0F)
        {
          if (f < 0.0F)
          {
            paramMotionEvent = getOnSelectedPageListener();
            if (paramMotionEvent != null) {
              paramMotionEvent.Mc(Math.min(getCurrentIndex() + 1, getCount() - 1));
            }
          }
          else
          {
            paramMotionEvent = getOnSelectedPageListener();
            if (paramMotionEvent != null) {
              paramMotionEvent.Mc(Math.max(getCurrentIndex() - 1, 0));
            }
          }
        }
        else if (this.dit < getWidth() / 2.0F)
        {
          paramMotionEvent = getOnSelectedPageListener();
          if (paramMotionEvent != null) {
            paramMotionEvent.Mc(Math.max(getCurrentIndex() - 1, 0));
          }
        }
        else
        {
          paramMotionEvent = getOnSelectedPageListener();
          if (paramMotionEvent != null) {
            paramMotionEvent.Mc(Math.min(getCurrentIndex() + 1, getCount() - 1));
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