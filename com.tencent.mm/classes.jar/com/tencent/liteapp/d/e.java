package com.tencent.liteapp.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class e
{
  @TargetApi(17)
  private static boolean aA(Context paramContext)
  {
    AppMethodBeat.i(197809);
    if (aB(paramContext) > 0)
    {
      AppMethodBeat.o(197809);
      return true;
    }
    AppMethodBeat.o(197809);
    return false;
  }
  
  private static int aB(Context paramContext)
  {
    AppMethodBeat.i(197810);
    Object localObject2 = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Object localObject1 = new Point();
    ((Display)localObject2).getSize((Point)localObject1);
    localObject2 = az(paramContext);
    int i = Math.max(((Point)localObject1).y, ((Point)localObject1).x);
    if (aC(paramContext)) {
      i = ((Point)localObject1).y;
    }
    int j = Math.max(((Point)localObject2).y, ((Point)localObject2).x);
    localObject1 = new Rect();
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
      i = Math.max(((Rect)localObject1).bottom, ((Rect)localObject1).right);
      if (aC(paramContext)) {
        i = ((Rect)localObject1).bottom;
      }
    }
    AppMethodBeat.o(197810);
    return j - i;
  }
  
  private static boolean aC(Context paramContext)
  {
    AppMethodBeat.i(197811);
    if (paramContext.getResources().getConfiguration().orientation == 1)
    {
      AppMethodBeat.o(197811);
      return true;
    }
    AppMethodBeat.o(197811);
    return false;
  }
  
  public static int aD(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(197812);
    if (aA(paramContext))
    {
      int j = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
      if (j > 0) {
        i = Resources.getSystem().getDimensionPixelSize(j);
      }
      int k = aB(paramContext);
      j = i;
      if (k != 0)
      {
        j = i;
        if (k < i) {
          j = k;
        }
      }
      AppMethodBeat.o(197812);
      return j;
    }
    AppMethodBeat.o(197812);
    return 0;
  }
  
  public static int ay(Context paramContext)
  {
    AppMethodBeat.i(197806);
    int i = y(paramContext, d.ax(paramContext));
    AppMethodBeat.o(197806);
    return i;
  }
  
  private static Point az(Context paramContext)
  {
    AppMethodBeat.i(197808);
    Point localPoint = new Point();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      paramContext.getRealSize(localPoint);
    }
    for (;;)
    {
      AppMethodBeat.o(197808);
      return localPoint;
      if (Build.VERSION.SDK_INT >= 14) {}
      try
      {
        Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
        localPoint.x = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
        localPoint.y = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
      }
      catch (NoSuchMethodException paramContext)
      {
        continue;
        paramContext.getSize(localPoint);
      }
      catch (InvocationTargetException paramContext) {}catch (IllegalAccessException paramContext) {}
    }
  }
  
  private static int y(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(197807);
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = f.cL(localClass.getField("status_bar_height").get(localObject).toString());
      i = paramContext.getResources().getDimensionPixelSize(i);
      paramInt = i;
    }
    catch (Exception paramContext)
    {
      label46:
      break label46;
    }
    b.i("WeUIToolHelper", "[getStatusBarHeightFromSysR] :%s ", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(197807);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteapp.d.e
 * JD-Core Version:    0.7.0.1
 */