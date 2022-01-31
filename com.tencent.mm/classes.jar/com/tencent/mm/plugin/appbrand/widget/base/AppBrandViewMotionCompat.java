package com.tencent.mm.plugin.appbrand.widget.base;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.support.annotation.Keep;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import android.view.ViewGroup;

public final class AppBrandViewMotionCompat
{
  @TargetApi(11)
  public static boolean a(ViewGroup paramViewGroup, float paramFloat1, float paramFloat2, View paramView)
  {
    float[] arrayOfFloat = new float[2];
    float[] tmp7_5 = arrayOfFloat;
    tmp7_5[0] = 0.0F;
    float[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 0.0F;
    tmp11_7;
    arrayOfFloat[0] = (paramViewGroup.getScrollX() - paramView.getLeft() + paramFloat1);
    arrayOfFloat[1] = (paramViewGroup.getScrollY() - paramView.getTop() + paramFloat2);
    paramViewGroup = paramView.getMatrix();
    if (!paramViewGroup.isIdentity())
    {
      paramViewGroup.invert(paramViewGroup);
      paramViewGroup.mapPoints(arrayOfFloat);
    }
    return (arrayOfFloat[0] >= 0.0F) && (arrayOfFloat[1] >= 0.0F) && (arrayOfFloat[0] < paramView.getRight() - paramView.getLeft()) && (arrayOfFloat[1] < paramView.getBottom() - paramView.getTop());
  }
  
  public static boolean cc(View paramView)
  {
    return (paramView != null) && ((paramView instanceof c)) && (((c)paramView).arc());
  }
  
  public static boolean cd(View paramView)
  {
    return (paramView.getVisibility() == 0) || (paramView.getAnimation() != null);
  }
  
  @TargetApi(11)
  @Keep
  public static boolean dispatchTransformedTouchEvent(ViewGroup paramViewGroup, MotionEvent paramMotionEvent, boolean paramBoolean, View paramView, int paramInt)
  {
    if ((paramViewGroup == null) || (paramMotionEvent == null)) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((paramBoolean) || (i == 3))
    {
      paramMotionEvent.setAction(3);
      if (paramView == null) {
        return false;
      }
      paramBoolean = paramView.dispatchTouchEvent(paramMotionEvent);
      paramMotionEvent.setAction(i);
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
    if (i1 == 0) {
      return false;
    }
    if (i1 == i) {
      if ((paramView == null) || (paramView.getMatrix().isIdentity()))
      {
        if (paramView == null) {
          return false;
        }
        float f1 = paramViewGroup.getScrollX() - paramView.getLeft();
        float f2 = paramViewGroup.getScrollY() - paramView.getTop();
        paramMotionEvent.offsetLocation(f1, f2);
        paramBoolean = paramView.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.offsetLocation(-f1, -f2);
        return paramBoolean;
      }
    }
    MotionEvent localMotionEvent;
    for (paramMotionEvent = MotionEvent.obtain(paramMotionEvent); paramView == null; paramMotionEvent = localMotionEvent)
    {
      return false;
      int i3 = paramMotionEvent.getPointerCount();
      MotionEvent.PointerProperties[] arrayOfPointerProperties = new MotionEvent.PointerProperties[i3];
      MotionEvent.PointerCoords[] arrayOfPointerCoords = new MotionEvent.PointerCoords[i3];
      int[] arrayOfInt = new int[i3];
      int n = paramMotionEvent.getAction();
      int i2 = n & 0xFF;
      j = -1;
      i = 0;
      paramInt = 0;
      int m;
      while (paramInt < i3)
      {
        paramMotionEvent.getPointerProperties(paramInt, arrayOfPointerProperties[i]);
        m = j;
        k = i;
        if ((1 << arrayOfPointerProperties[i].id & i1) != 0)
        {
          if (paramInt == (0xFF00 & n) >> 8) {
            j = i;
          }
          arrayOfInt[i] = paramInt;
          k = i + 1;
          m = j;
        }
        paramInt += 1;
        j = m;
        i = k;
      }
      if (i == 0) {
        throw new IllegalArgumentException("idBits did not match any ids in the event");
      }
      if (i2 != 5)
      {
        paramInt = n;
        if (i2 != 6) {}
      }
      else
      {
        if (j >= 0) {
          break label441;
        }
        paramInt = 2;
      }
      localMotionEvent = null;
      n = paramMotionEvent.getHistorySize();
      j = 0;
      if (j <= n)
      {
        if (j == n) {}
        for (k = -2147483648;; k = j)
        {
          m = 0;
          while (m < i)
          {
            paramMotionEvent.getHistoricalPointerCoords(arrayOfInt[m], k, arrayOfPointerCoords[m]);
            m += 1;
          }
          label441:
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
        long l = paramMotionEvent.getHistoricalEventTime(k);
        if (j == 0)
        {
          localMotionEvent = MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), paramInt, i, arrayOfPointerProperties, arrayOfPointerCoords, paramMotionEvent.getMetaState(), paramMotionEvent.getButtonState(), paramMotionEvent.getXPrecision(), paramMotionEvent.getYPrecision(), paramMotionEvent.getDeviceId(), paramMotionEvent.getEdgeFlags(), paramMotionEvent.getSource(), paramMotionEvent.getFlags());
          localMotionEvent.offsetLocation(localMotionEvent.getX() - localMotionEvent.getRawX(), localMotionEvent.getY() - localMotionEvent.getRawY());
        }
        for (;;)
        {
          j += 1;
          break;
          localMotionEvent.addBatch(l, arrayOfPointerCoords, 0);
        }
      }
    }
    paramMotionEvent.offsetLocation(paramViewGroup.getScrollX() - paramView.getLeft(), paramViewGroup.getScrollY() - paramView.getTop());
    if (!paramView.getMatrix().isIdentity())
    {
      paramViewGroup = paramView.getMatrix();
      paramViewGroup.invert(paramViewGroup);
      paramMotionEvent.transform(paramViewGroup);
    }
    paramBoolean = paramView.dispatchTouchEvent(paramMotionEvent);
    paramMotionEvent.recycle();
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat
 * JD-Core Version:    0.7.0.1
 */