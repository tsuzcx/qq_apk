package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.t;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class bh
{
  private static Method apS;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[] { Rect.class, Rect.class });
      apS = localMethod;
      if (!localMethod.isAccessible()) {
        apS.setAccessible(true);
      }
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  public static void a(View paramView, Rect paramRect1, Rect paramRect2)
  {
    if (apS != null) {}
    try
    {
      apS.invoke(paramView, new Object[] { paramRect1, paramRect2 });
      return;
    }
    catch (Exception paramView) {}
  }
  
  public static boolean bY(View paramView)
  {
    return t.T(paramView) == 1;
  }
  
  public static void bZ(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    try
    {
      Method localMethod = paramView.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
      if (!localMethod.isAccessible()) {
        localMethod.setAccessible(true);
      }
      localMethod.invoke(paramView, new Object[0]);
      return;
    }
    catch (IllegalAccessException paramView) {}catch (InvocationTargetException paramView) {}catch (NoSuchMethodException paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.bh
 * JD-Core Version:    0.7.0.1
 */