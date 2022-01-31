package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.e;
import com.tencent.mm.plugin.appbrand.s.l;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
{
  public static void a(ViewGroup paramViewGroup, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(91079);
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
      if ((AppBrandViewMotionCompat.cG(localView)) && (AppBrandViewMotionCompat.a(paramViewGroup, f1, f2, localView)) && (localView.isDuplicateParentStateEnabled()))
      {
        a(paramViewGroup, paramMotionEvent, localView, i);
        if (((localView instanceof e)) && (((e)localView).aCe()))
        {
          AppMethodBeat.o(91079);
          return;
          i = -1;
          break;
        }
      }
      j -= 1;
    }
    label142:
    AppMethodBeat.o(91079);
  }
  
  public static boolean a(ViewGroup paramViewGroup, MotionEvent paramMotionEvent, View paramView, int paramInt)
  {
    AppMethodBeat.i(91080);
    if (paramView == null)
    {
      ab.v("MicroMsg.ViewMotionHelper", "child is null.");
      AppMethodBeat.o(91080);
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i == 3)
    {
      paramMotionEvent.setAction(3);
      bool = paramView.dispatchTouchEvent(paramMotionEvent);
      paramMotionEvent.setAction(i);
      AppMethodBeat.o(91080);
      return bool;
    }
    i = ((Integer)l.a(MotionEvent.class, "getPointerIdBits", paramMotionEvent, new Class[0], new Object[0], Integer.valueOf(0))).intValue();
    paramInt = i & paramInt;
    if (paramInt == 0)
    {
      ab.v("MicroMsg.ViewMotionHelper", "newPointerIdBits is 0.");
      AppMethodBeat.o(91080);
      return false;
    }
    Object localObject = Boolean.FALSE;
    boolean bool = ((Boolean)l.a(View.class, "hasIdentityMatrix", paramView, new Class[0], new Object[0], localObject)).booleanValue();
    if (paramInt == i)
    {
      if (bool)
      {
        float f1 = paramViewGroup.getScrollX() - paramView.getLeft();
        float f2 = paramViewGroup.getScrollY() - paramView.getTop();
        paramMotionEvent.offsetLocation(f1, f2);
        bool = paramView.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.offsetLocation(-f1, -f2);
        AppMethodBeat.o(91080);
        return bool;
      }
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    }
    for (;;)
    {
      paramMotionEvent.offsetLocation(paramViewGroup.getScrollX() - paramView.getLeft(), paramViewGroup.getScrollY() - paramView.getTop());
      if (!bool) {
        paramMotionEvent.transform((Matrix)l.a(View.class, "getInverseMatrix", paramView, new Class[0], new Object[0], null));
      }
      bool = paramView.dispatchTouchEvent(paramMotionEvent);
      paramMotionEvent.recycle();
      AppMethodBeat.o(91080);
      return bool;
      localObject = (MotionEvent)l.a("split", paramMotionEvent, new Class[] { Integer.class }, new Object[] { Integer.valueOf(paramInt) });
      if (localObject == null) {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      } else {
        paramMotionEvent = (MotionEvent)localObject;
      }
    }
  }
  
  public static d.f cr(View paramView)
  {
    AppMethodBeat.i(91078);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramView = new d.f(0, arrayOfInt[0], arrayOfInt[1]);
    AppMethodBeat.o(91078);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.d
 * JD-Core Version:    0.7.0.1
 */