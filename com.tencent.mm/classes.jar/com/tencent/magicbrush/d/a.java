package com.tencent.magicbrush.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static float bLI = -1.0F;
  
  public static Point ay(Context paramContext)
  {
    AppMethodBeat.i(116008);
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    Point localPoint = new Point();
    if (localWindowManager != null)
    {
      localWindowManager.getDefaultDisplay().getRealSize(localPoint);
      if ((localPoint.x == 0) || (localPoint.y == 0)) {}
    }
    for (;;)
    {
      localPoint.x = x(paramContext, localPoint.x);
      localPoint.y = x(paramContext, localPoint.y);
      AppMethodBeat.o(116008);
      return localPoint;
      localPoint.x = paramContext.getResources().getDisplayMetrics().widthPixels;
      localPoint.y = paramContext.getResources().getDisplayMetrics().heightPixels;
    }
  }
  
  public static float getDensity(Context paramContext)
  {
    AppMethodBeat.i(116006);
    if (bLI < 0.0F) {
      bLI = paramContext.getResources().getDisplayMetrics().density;
    }
    float f = bLI;
    AppMethodBeat.o(116006);
    return f;
  }
  
  private static int x(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(116007);
    paramInt = (int)Math.ceil(paramInt / getDensity(paramContext));
    AppMethodBeat.o(116007);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.d.a
 * JD-Core Version:    0.7.0.1
 */