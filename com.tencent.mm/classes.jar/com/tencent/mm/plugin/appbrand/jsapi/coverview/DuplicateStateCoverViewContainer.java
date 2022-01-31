package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.e;
import com.tencent.mm.plugin.appbrand.jsapi.s.d;
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
  
  public final boolean aCT()
  {
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141796);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    boolean bool = cp(this).contains(f1, f2);
    if ((paramMotionEvent.getActionMasked() == 0) && (!K(paramMotionEvent.getX(), paramMotionEvent.getY())) && (!bool))
    {
      AppMethodBeat.o(141796);
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
          if (((!(localView instanceof CoverViewContainer)) || (((CoverViewContainer)localView).aCT())) && (AppBrandViewMotionCompat.cG(localView)) && (AppBrandViewMotionCompat.a(this, f1, f2, localView)) && (localView.isDuplicateParentStateEnabled()))
          {
            d.a(this, paramMotionEvent, localView, i);
            if (((localView instanceof e)) && (((e)localView).aCe())) {
              break;
            }
          }
          j -= 1;
        }
      }
    }
    AppMethodBeat.o(141796);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.DuplicateStateCoverViewContainer
 * JD-Core Version:    0.7.0.1
 */