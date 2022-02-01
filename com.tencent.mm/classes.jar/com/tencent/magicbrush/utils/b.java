package com.tencent.magicbrush.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static float cPs = -1.0F;
  
  public static Point aV(Context paramContext)
  {
    AppMethodBeat.i(140069);
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    Point localPoint = new Point();
    if (localWindowManager != null)
    {
      localWindowManager.getDefaultDisplay().getRealSize(localPoint);
      if ((localPoint.x == 0) || (localPoint.y == 0)) {}
    }
    for (;;)
    {
      localPoint.x = z(paramContext, localPoint.x);
      localPoint.y = z(paramContext, localPoint.y);
      AppMethodBeat.o(140069);
      return localPoint;
      localPoint.x = paramContext.getResources().getDisplayMetrics().widthPixels;
      localPoint.y = paramContext.getResources().getDisplayMetrics().heightPixels;
    }
  }
  
  public static float getDensity(Context paramContext)
  {
    AppMethodBeat.i(140067);
    if (cPs < 0.0F) {
      cPs = paramContext.getResources().getDisplayMetrics().density;
    }
    float f = cPs;
    AppMethodBeat.o(140067);
    return f;
  }
  
  private static int z(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(140068);
    paramInt = (int)Math.ceil(paramInt / getDensity(paramContext));
    AppMethodBeat.o(140068);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.utils.b
 * JD-Core Version:    0.7.0.1
 */