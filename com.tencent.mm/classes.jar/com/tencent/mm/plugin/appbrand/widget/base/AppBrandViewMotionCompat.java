package com.tencent.mm.plugin.appbrand.widget.base;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.os.Looper;
import android.support.annotation.Keep;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class AppBrandViewMotionCompat
{
  private static MotionEvent.PointerCoords[] lRE;
  private static MotionEvent.PointerProperties[] lRF;
  private static int[] lRG;
  
  @TargetApi(5)
  public static int L(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(174629);
    int k = paramMotionEvent.getPointerCount();
    int j = 0;
    int m;
    for (int i = 0; j < k; i = 1 << m | i)
    {
      m = paramMotionEvent.getPointerId(j);
      j += 1;
    }
    AppMethodBeat.o(174629);
    return i;
  }
  
  @TargetApi(11)
  public static boolean a(ViewGroup paramViewGroup, float paramFloat1, float paramFloat2, View paramView)
  {
    AppMethodBeat.i(140872);
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
      AppMethodBeat.o(140872);
      return true;
    }
    AppMethodBeat.o(140872);
    return false;
  }
  
  @TargetApi(14)
  public static MotionEvent c(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(174632);
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      paramMotionEvent = new RuntimeException("Should be called on main-thread");
      AppMethodBeat.o(174632);
      throw paramMotionEvent;
    }
    int i3 = paramMotionEvent.getPointerCount();
    uy(i3);
    MotionEvent.PointerProperties[] arrayOfPointerProperties = lRF;
    MotionEvent.PointerCoords[] arrayOfPointerCoords = lRE;
    int[] arrayOfInt = lRG;
    int i1 = paramMotionEvent.getAction();
    int i2 = i1 & 0xFF;
    int j = -1;
    int i = 0;
    int k = 0;
    int m;
    while (k < i3)
    {
      paramMotionEvent.getPointerProperties(k, arrayOfPointerProperties[i]);
      n = j;
      m = i;
      if ((1 << arrayOfPointerProperties[i].id & paramInt) != 0)
      {
        if (k == (0xFF00 & i1) >> 8) {
          j = i;
        }
        arrayOfInt[i] = k;
        m = i + 1;
        n = j;
      }
      k += 1;
      j = n;
      i = m;
    }
    if (i == 0)
    {
      paramMotionEvent = new IllegalArgumentException("idBits did not match any ids in the event");
      AppMethodBeat.o(174632);
      throw paramMotionEvent;
    }
    if (i2 != 5)
    {
      paramInt = i1;
      if (i2 != 6) {}
    }
    else
    {
      if (j >= 0) {
        break label263;
      }
      paramInt = 2;
    }
    MotionEvent localMotionEvent = null;
    int n = paramMotionEvent.getHistorySize();
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
        label263:
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
    AppMethodBeat.o(174632);
    return localMotionEvent;
  }
  
  public static boolean cR(View paramView)
  {
    AppMethodBeat.i(140870);
    if ((paramView != null) && ((paramView instanceof c)) && (((c)paramView).brm()))
    {
      AppMethodBeat.o(140870);
      return true;
    }
    AppMethodBeat.o(140870);
    return false;
  }
  
  public static boolean cS(View paramView)
  {
    AppMethodBeat.i(140871);
    if ((paramView.getVisibility() == 0) || (paramView.getAnimation() != null))
    {
      AppMethodBeat.o(140871);
      return true;
    }
    AppMethodBeat.o(140871);
    return false;
  }
  
  @TargetApi(11)
  public static boolean cT(View paramView)
  {
    AppMethodBeat.i(174627);
    boolean bool = paramView.getMatrix().isIdentity();
    AppMethodBeat.o(174627);
    return bool;
  }
  
  public static Matrix cU(View paramView)
  {
    AppMethodBeat.i(174628);
    if (paramView == null)
    {
      AppMethodBeat.o(174628);
      return null;
    }
    Matrix localMatrix2 = (Matrix)paramView.getTag(2131296901);
    Matrix localMatrix1 = localMatrix2;
    if (localMatrix2 == null)
    {
      localMatrix1 = new Matrix();
      paramView.setTag(2131296901, localMatrix1);
    }
    paramView.getMatrix().invert(localMatrix1);
    AppMethodBeat.o(174628);
    return localMatrix1;
  }
  
  @TargetApi(11)
  @Keep
  public static boolean dispatchTransformedTouchEvent(ViewGroup paramViewGroup, MotionEvent paramMotionEvent, boolean paramBoolean, View paramView, int paramInt)
  {
    AppMethodBeat.i(140873);
    if ((paramViewGroup == null) || (paramMotionEvent == null))
    {
      AppMethodBeat.o(140873);
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((paramBoolean) || (i == 3))
    {
      paramMotionEvent.setAction(3);
      if (paramView == null)
      {
        AppMethodBeat.o(140873);
        return false;
      }
      paramBoolean = paramView.dispatchTouchEvent(paramMotionEvent);
      paramMotionEvent.setAction(i);
      AppMethodBeat.o(140873);
      return paramBoolean;
    }
    i = L(paramMotionEvent);
    paramInt = i & paramInt;
    if (paramInt == 0)
    {
      AppMethodBeat.o(140873);
      return false;
    }
    if (paramInt == i)
    {
      if ((paramView == null) || (paramView.getMatrix().isIdentity()))
      {
        if (paramView == null)
        {
          AppMethodBeat.o(140873);
          return false;
        }
        float f1 = paramViewGroup.getScrollX() - paramView.getLeft();
        float f2 = paramViewGroup.getScrollY() - paramView.getTop();
        paramMotionEvent.offsetLocation(f1, f2);
        paramBoolean = paramView.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.offsetLocation(-f1, -f2);
        AppMethodBeat.o(140873);
        return paramBoolean;
      }
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    }
    while (paramView == null)
    {
      AppMethodBeat.o(140873);
      return false;
      try
      {
        paramMotionEvent = c(paramMotionEvent, paramInt);
      }
      catch (IllegalArgumentException paramViewGroup)
      {
        ad.w("MicroMsg.AppBrandViewMotionCompat", "dispatchTransformedTouchEvent e=%s", new Object[] { paramViewGroup.getMessage() });
        AppMethodBeat.o(140873);
        return false;
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
    AppMethodBeat.o(140873);
    return paramBoolean;
  }
  
  private static void uy(int paramInt)
  {
    AppMethodBeat.i(174630);
    if ((lRE == null) || (lRE.length < paramInt))
    {
      int i;
      if (lRE != null) {
        i = lRE.length;
      }
      while (i < paramInt)
      {
        i *= 2;
        continue;
        i = 8;
      }
      MotionEvent.PointerCoords[] arrayOfPointerCoords = new MotionEvent.PointerCoords[i];
      paramInt = 0;
      while (paramInt < i)
      {
        arrayOfPointerCoords[paramInt] = new MotionEvent.PointerCoords();
        paramInt += 1;
      }
      lRE = arrayOfPointerCoords;
      lRF = uz(i);
      lRG = new int[i];
    }
    AppMethodBeat.o(174630);
  }
  
  private static MotionEvent.PointerProperties[] uz(int paramInt)
  {
    AppMethodBeat.i(174631);
    MotionEvent.PointerProperties[] arrayOfPointerProperties = new MotionEvent.PointerProperties[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfPointerProperties[i] = new MotionEvent.PointerProperties();
      i += 1;
    }
    AppMethodBeat.o(174631);
    return arrayOfPointerProperties;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat
 * JD-Core Version:    0.7.0.1
 */