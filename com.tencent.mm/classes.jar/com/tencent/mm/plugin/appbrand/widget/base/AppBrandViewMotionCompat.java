package com.tencent.mm.plugin.appbrand.widget.base;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.support.annotation.Keep;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandViewMotionCompat
{
  @TargetApi(11)
  public static boolean a(ViewGroup paramViewGroup, float paramFloat1, float paramFloat2, View paramView)
  {
    AppMethodBeat.i(91198);
    float[] arrayOfFloat = new float[2];
    float[] tmp12_10 = arrayOfFloat;
    tmp12_10[0] = 0.0F;
    float[] tmp16_12 = tmp12_10;
    tmp16_12[1] = 0.0F;
    tmp16_12;
    arrayOfFloat[0] = (paramViewGroup.getScrollX() - paramView.getLeft() + paramFloat1);
    arrayOfFloat[1] = (paramViewGroup.getScrollY() - paramView.getTop() + paramFloat2);
    paramViewGroup = paramView.getMatrix();
    if (!paramViewGroup.isIdentity())
    {
      paramViewGroup.invert(paramViewGroup);
      paramViewGroup.mapPoints(arrayOfFloat);
    }
    if ((arrayOfFloat[0] >= 0.0F) && (arrayOfFloat[1] >= 0.0F) && (arrayOfFloat[0] < paramView.getRight() - paramView.getLeft()) && (arrayOfFloat[1] < paramView.getBottom() - paramView.getTop()))
    {
      AppMethodBeat.o(91198);
      return true;
    }
    AppMethodBeat.o(91198);
    return false;
  }
  
  public static boolean cF(View paramView)
  {
    AppMethodBeat.i(91196);
    if ((paramView != null) && ((paramView instanceof c)) && (((c)paramView).aOP()))
    {
      AppMethodBeat.o(91196);
      return true;
    }
    AppMethodBeat.o(91196);
    return false;
  }
  
  public static boolean cG(View paramView)
  {
    AppMethodBeat.i(91197);
    if ((paramView.getVisibility() == 0) || (paramView.getAnimation() != null))
    {
      AppMethodBeat.o(91197);
      return true;
    }
    AppMethodBeat.o(91197);
    return false;
  }
  
  @TargetApi(11)
  @Keep
  public static boolean dispatchTransformedTouchEvent(ViewGroup paramViewGroup, MotionEvent paramMotionEvent, boolean paramBoolean, View paramView, int paramInt)
  {
    AppMethodBeat.i(91199);
    if ((paramViewGroup == null) || (paramMotionEvent == null))
    {
      AppMethodBeat.o(91199);
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((paramBoolean) || (i == 3))
    {
      paramMotionEvent.setAction(3);
      if (paramView == null)
      {
        AppMethodBeat.o(91199);
        return false;
      }
      paramBoolean = paramView.dispatchTouchEvent(paramMotionEvent);
      paramMotionEvent.setAction(i);
      AppMethodBeat.o(91199);
      return paramBoolean;
    }
    i = 0;
    int k = paramMotionEvent.getPointerCount();
    int j = 0;
    while (j < k)
    {
      i |= 1 << paramMotionEvent.getPointerId(j);
      j += 1;
    }
    int i1 = i & paramInt;
    if (i1 == 0)
    {
      AppMethodBeat.o(91199);
      return false;
    }
    int[] arrayOfInt;
    int n;
    int i2;
    label283:
    int m;
    MotionEvent localMotionEvent;
    if (i1 == i)
    {
      if ((paramView == null) || (paramView.getMatrix().isIdentity()))
      {
        if (paramView == null)
        {
          AppMethodBeat.o(91199);
          return false;
        }
        float f1 = paramViewGroup.getScrollX() - paramView.getLeft();
        float f2 = paramViewGroup.getScrollY() - paramView.getTop();
        paramMotionEvent.offsetLocation(f1, f2);
        paramBoolean = paramView.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.offsetLocation(-f1, -f2);
        AppMethodBeat.o(91199);
        return paramBoolean;
      }
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (paramView == null)
      {
        AppMethodBeat.o(91199);
        return false;
      }
    }
    else
    {
      MotionEvent.PointerProperties[] arrayOfPointerProperties;
      MotionEvent.PointerCoords[] arrayOfPointerCoords;
      try
      {
        int i3 = paramMotionEvent.getPointerCount();
        arrayOfPointerProperties = new MotionEvent.PointerProperties[i3];
        arrayOfPointerCoords = new MotionEvent.PointerCoords[i3];
        arrayOfInt = new int[i3];
        n = paramMotionEvent.getAction();
        i2 = n & 0xFF;
        j = -1;
        i = 0;
        paramInt = 0;
        if (paramInt < i3)
        {
          paramMotionEvent.getPointerProperties(paramInt, arrayOfPointerProperties[i]);
          m = j;
          k = i;
          if ((1 << arrayOfPointerProperties[i].id & i1) == 0) {
            break label664;
          }
          if (paramInt != (0xFF00 & n) >> 8) {
            break label647;
          }
          j = i;
          break label647;
        }
        if (i == 0)
        {
          paramViewGroup = new IllegalArgumentException("idBits did not match any ids in the event");
          AppMethodBeat.o(91199);
          throw paramViewGroup;
        }
      }
      catch (IllegalArgumentException paramViewGroup)
      {
        d.w("MicroMsg.AppBrandViewMotionCompat", "dispatchTransformedTouchEvent e=%s", new Object[] { paramViewGroup.getMessage() });
        AppMethodBeat.o(91199);
        return false;
      }
      if (i2 != 5)
      {
        paramInt = n;
        if (i2 != 6) {}
      }
      else
      {
        if (j >= 0) {
          break label705;
        }
        paramInt = 2;
      }
      localMotionEvent = null;
      n = paramMotionEvent.getHistorySize();
      j = 0;
      break label681;
      label433:
      while (m < i)
      {
        paramMotionEvent.getHistoricalPointerCoords(arrayOfInt[m], k, arrayOfPointerCoords[m]);
        m += 1;
      }
      long l = paramMotionEvent.getHistoricalEventTime(k);
      if (j == 0)
      {
        localMotionEvent = MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), paramInt, i, arrayOfPointerProperties, arrayOfPointerCoords, paramMotionEvent.getMetaState(), paramMotionEvent.getButtonState(), paramMotionEvent.getXPrecision(), paramMotionEvent.getYPrecision(), paramMotionEvent.getDeviceId(), paramMotionEvent.getEdgeFlags(), paramMotionEvent.getSource(), paramMotionEvent.getFlags());
        localMotionEvent.offsetLocation(localMotionEvent.getX() - localMotionEvent.getRawX(), localMotionEvent.getY() - localMotionEvent.getRawY());
        break label749;
      }
      localMotionEvent.addBatch(l, arrayOfPointerCoords, 0);
      break label749;
    }
    label647:
    label664:
    label681:
    label705:
    label749:
    label756:
    for (;;)
    {
      paramMotionEvent = localMotionEvent;
      break;
      paramMotionEvent.offsetLocation(paramViewGroup.getScrollX() - paramView.getLeft(), paramViewGroup.getScrollY() - paramView.getTop());
      if (!paramView.getMatrix().isIdentity())
      {
        paramViewGroup = paramView.getMatrix();
        paramViewGroup.invert(paramViewGroup);
        paramMotionEvent.transform(paramViewGroup);
      }
      paramBoolean = paramView.dispatchTouchEvent(paramMotionEvent);
      paramMotionEvent.recycle();
      AppMethodBeat.o(91199);
      return paramBoolean;
      arrayOfInt[i] = paramInt;
      k = i + 1;
      m = j;
      paramInt += 1;
      j = m;
      i = k;
      break label283;
      for (;;)
      {
        if (j > n) {
          break label756;
        }
        if (j == n) {}
        for (k = -2147483648;; k = j)
        {
          m = 0;
          break label433;
          if (i == 1)
          {
            if (i2 == 5) {}
            for (paramInt = 0;; paramInt = 1) {
              break;
            }
          }
          paramInt = i2 | j << 8;
          break;
        }
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat
 * JD-Core Version:    0.7.0.1
 */