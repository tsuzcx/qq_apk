package com.tencent.mm.plugin.finder.view.indictor;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderViewPager.a;
import com.tencent.mm.view.MediaBannerIndicator;
import com.tencent.mm.view.d;
import com.tencent.mm.view.h.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator2;", "Lcom/tencent/mm/view/MediaBannerIndicator;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downX", "", "canScrollHorizontally", "", "direction", "parent", "Landroid/view/ViewGroup;", "x", "y", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
public final class FinderMediaGestureIndicator2
  extends MediaBannerIndicator
  implements FinderViewPager.a
{
  private float deo;
  
  public FinderMediaGestureIndicator2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(255244);
    setIndicatorWidth((int)getResources().getDimension(2131165314));
    setIndicatorMargin(d.e(getContext(), 3.0F));
    setUnSelectDrawable(getContext().getDrawable(2131232551));
    setSelectDrawable(getContext().getDrawable(2131232552));
    AppMethodBeat.o(255244);
  }
  
  public FinderMediaGestureIndicator2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(255245);
    setIndicatorWidth((int)getResources().getDimension(2131165314));
    setIndicatorMargin(d.e(getContext(), 3.0F));
    setUnSelectDrawable(getContext().getDrawable(2131232551));
    setSelectDrawable(getContext().getDrawable(2131232552));
    AppMethodBeat.o(255245);
  }
  
  public final boolean a(int paramInt, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(255243);
    p.h(paramViewGroup, "parent");
    AppMethodBeat.o(255243);
    return true;
  }
  
  public final boolean canScrollHorizontally(int paramInt)
  {
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(255242);
    p.h(paramMotionEvent, "event");
    super.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() == 0) {
      this.deo = paramMotionEvent.getX();
    }
    for (;;)
    {
      AppMethodBeat.o(255242);
      return true;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        float f = paramMotionEvent.getX() - this.deo;
        if (Math.abs(f) >= 15.0F)
        {
          if (f < 0.0F)
          {
            paramMotionEvent = getOnSelectedPageListener();
            if (paramMotionEvent != null) {
              paramMotionEvent.Ir(Math.min(getCurrentIndex() + 1, getCount() - 1));
            }
          }
          else
          {
            paramMotionEvent = getOnSelectedPageListener();
            if (paramMotionEvent != null) {
              paramMotionEvent.Ir(Math.max(getCurrentIndex() - 1, 0));
            }
          }
        }
        else if (this.deo < getWidth() / 2.0F)
        {
          paramMotionEvent = getOnSelectedPageListener();
          if (paramMotionEvent != null) {
            paramMotionEvent.Ir(Math.max(getCurrentIndex() - 1, 0));
          }
        }
        else
        {
          paramMotionEvent = getOnSelectedPageListener();
          if (paramMotionEvent != null) {
            paramMotionEvent.Ir(Math.min(getCurrentIndex() + 1, getCount() - 1));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.indictor.FinderMediaGestureIndicator2
 * JD-Core Version:    0.7.0.1
 */