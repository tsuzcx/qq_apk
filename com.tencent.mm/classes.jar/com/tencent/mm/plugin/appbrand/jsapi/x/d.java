package com.tencent.mm.plugin.appbrand.jsapi.x;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.e;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
{
  public static void a(ViewGroup paramViewGroup, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140690);
    int j = paramViewGroup.getChildCount();
    int i = paramMotionEvent.getActionIndex();
    if (paramViewGroup.isMotionEventSplittingEnabled())
    {
      i = 1 << paramMotionEvent.getPointerId(i);
      j -= 1;
    }
    for (;;)
    {
      if (j < 0) {
        break label142;
      }
      View localView = paramViewGroup.getChildAt(j);
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((AppBrandViewMotionCompat.cS(localView)) && (AppBrandViewMotionCompat.a(paramViewGroup, f1, f2, localView)) && (localView.isDuplicateParentStateEnabled()))
      {
        a(paramViewGroup, paramMotionEvent, localView, i);
        if (((localView instanceof e)) && (((e)localView).aYz()))
        {
          AppMethodBeat.o(140690);
          return;
          i = -1;
          break;
        }
      }
      j -= 1;
    }
    label142:
    AppMethodBeat.o(140690);
  }
  
  public static boolean a(ViewGroup paramViewGroup, MotionEvent paramMotionEvent, View paramView, int paramInt)
  {
    AppMethodBeat.i(140691);
    if (paramView == null)
    {
      ad.v("MicroMsg.ViewMotionHelper", "child is null.");
      AppMethodBeat.o(140691);
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i == 3)
    {
      paramMotionEvent.setAction(3);
      bool = paramView.dispatchTouchEvent(paramMotionEvent);
      paramMotionEvent.setAction(i);
      AppMethodBeat.o(140691);
      return bool;
    }
    i = AppBrandViewMotionCompat.L(paramMotionEvent);
    paramInt = i & paramInt;
    if (paramInt == 0)
    {
      ad.v("MicroMsg.ViewMotionHelper", "newPointerIdBits is 0.");
      AppMethodBeat.o(140691);
      return false;
    }
    boolean bool = AppBrandViewMotionCompat.cT(paramView);
    Object localObject;
    if (paramInt == i)
    {
      if (bool)
      {
        float f1 = paramViewGroup.getScrollX() - paramView.getLeft();
        float f2 = paramViewGroup.getScrollY() - paramView.getTop();
        paramMotionEvent.offsetLocation(f1, f2);
        bool = paramView.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.offsetLocation(-f1, -f2);
        AppMethodBeat.o(140691);
        return bool;
      }
      localObject = MotionEvent.obtain(paramMotionEvent);
    }
    for (;;)
    {
      ((MotionEvent)localObject).offsetLocation(paramViewGroup.getScrollX() - paramView.getLeft(), paramViewGroup.getScrollY() - paramView.getTop());
      if (!bool) {
        ((MotionEvent)localObject).transform(AppBrandViewMotionCompat.cU(paramView));
      }
      bool = paramView.dispatchTouchEvent((MotionEvent)localObject);
      ((MotionEvent)localObject).recycle();
      AppMethodBeat.o(140691);
      return bool;
      MotionEvent localMotionEvent = AppBrandViewMotionCompat.c(paramMotionEvent, paramInt);
      localObject = localMotionEvent;
      if (localMotionEvent == null) {
        localObject = MotionEvent.obtain(paramMotionEvent);
      }
    }
  }
  
  public static d.f cB(View paramView)
  {
    AppMethodBeat.i(140689);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramView = new d.f(0, arrayOfInt[0], arrayOfInt[1]);
    AppMethodBeat.o(140689);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.d
 * JD-Core Version:    0.7.0.1
 */