package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.jsapi.base.e;
import com.tencent.mm.plugin.appbrand.u.m;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  public static void a(ViewGroup paramViewGroup, MotionEvent paramMotionEvent)
  {
    int j = paramViewGroup.getChildCount();
    int i = paramMotionEvent.getActionIndex();
    View localView;
    float f1;
    float f2;
    if (paramViewGroup.isMotionEventSplittingEnabled())
    {
      i = 1 << paramMotionEvent.getPointerId(i);
      j -= 1;
      if (j >= 0)
      {
        localView = paramViewGroup.getChildAt(j);
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        if ((!AppBrandViewMotionCompat.cd(localView)) || (!AppBrandViewMotionCompat.a(paramViewGroup, f1, f2, localView)) || (!localView.isDuplicateParentStateEnabled())) {
          break label425;
        }
        if (localView != null) {
          break label125;
        }
        y.v("MicroMsg.ViewMotionHelper", "child is null.");
      }
    }
    label97:
    label125:
    int m;
    boolean bool;
    MotionEvent localMotionEvent;
    for (;;)
    {
      if (((localView instanceof e)) && (((e)localView).ail()))
      {
        return;
        i = -1;
        break;
        int k = paramMotionEvent.getAction();
        if (k == 3)
        {
          paramMotionEvent.setAction(3);
          localView.dispatchTouchEvent(paramMotionEvent);
          paramMotionEvent.setAction(k);
        }
        else
        {
          k = ((Integer)m.a(MotionEvent.class, "getPointerIdBits", paramMotionEvent, new Class[0], new Object[0], Integer.valueOf(0))).intValue();
          m = k & i;
          if (m == 0)
          {
            y.v("MicroMsg.ViewMotionHelper", "newPointerIdBits is 0.");
          }
          else
          {
            bool = ((Boolean)m.a(View.class, "hasIdentityMatrix", localView, new Class[0], new Object[0], Boolean.valueOf(false))).booleanValue();
            if (m == k)
            {
              if (bool)
              {
                f1 = paramViewGroup.getScrollX() - localView.getLeft();
                f2 = paramViewGroup.getScrollY() - localView.getTop();
                paramMotionEvent.offsetLocation(f1, f2);
                localView.dispatchTouchEvent(paramMotionEvent);
                paramMotionEvent.offsetLocation(-f1, -f2);
                continue;
              }
              localMotionEvent = MotionEvent.obtain(paramMotionEvent);
            }
          }
        }
      }
    }
    for (;;)
    {
      localMotionEvent.offsetLocation(paramViewGroup.getScrollX() - localView.getLeft(), paramViewGroup.getScrollY() - localView.getTop());
      if (!bool) {
        localMotionEvent.transform((Matrix)m.a(View.class, "getInverseMatrix", localView, new Class[0], new Object[0], null));
      }
      localView.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      break label97;
      localMotionEvent = (MotionEvent)m.a(null, "split", paramMotionEvent, new Class[] { Integer.class }, new Object[] { Integer.valueOf(m) }, null);
      if (localMotionEvent == null)
      {
        localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        continue;
        label425:
        j -= 1;
        break;
      }
    }
  }
  
  public static c.f bU(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return new c.f(0, arrayOfInt[0], arrayOfInt[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.c
 * JD-Core Version:    0.7.0.1
 */