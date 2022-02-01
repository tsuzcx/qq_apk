package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah.e;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;

public class DuplicateStateCoverViewContainer
  extends CoverViewContainer
{
  public DuplicateStateCoverViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DuplicateStateCoverViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean crX()
  {
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140671);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    boolean bool = dv(this).contains(f1, f2);
    if ((paramMotionEvent.getActionMasked() == 0) && (!ap(paramMotionEvent.getX(), paramMotionEvent.getY())) && (!bool))
    {
      AppMethodBeat.o(140671);
      return false;
    }
    bool = super.dispatchTouchEvent(paramMotionEvent);
    if ((!bool) && (paramMotionEvent.getActionMasked() != 0))
    {
      int j = getChildCount();
      int i = paramMotionEvent.getActionIndex();
      if (isMotionEventSplittingEnabled()) {}
      for (i = 1 << paramMotionEvent.getPointerId(i);; i = -1)
      {
        j -= 1;
        while (j >= 0)
        {
          View localView = getChildAt(j);
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if (((!(localView instanceof CoverViewContainer)) || (((CoverViewContainer)localView).crX())) && (AppBrandViewMotionCompat.dS(localView)) && (AppBrandViewMotionCompat.a(this, f1, f2, localView)) && (localView.isDuplicateParentStateEnabled()))
          {
            e.a(this, paramMotionEvent, localView, i);
            if (((localView instanceof f)) && (((f)localView).cqz())) {
              break;
            }
          }
          j -= 1;
        }
      }
    }
    AppMethodBeat.o(140671);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.DuplicateStateCoverViewContainer
 * JD-Core Version:    0.7.0.1
 */