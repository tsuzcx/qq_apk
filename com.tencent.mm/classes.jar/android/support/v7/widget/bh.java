package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.t;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class bh
{
  private static Method axu;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[] { Rect.class, Rect.class });
      axu = localMethod;
      if (!localMethod.isAccessible()) {
        axu.setAccessible(true);
      }
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  public static void a(View paramView, Rect paramRect1, Rect paramRect2)
  {
    if (axu != null) {}
    try
    {
      axu.invoke(paramView, new Object[] { paramRect1, paramRect2 });
      return;
    }
    catch (Exception paramView) {}
  }
  
  public static void cg(View paramView)
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
  
  public static boolean d(View paramView)
  {
    return t.Y(paramView) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.bh
 * JD-Core Version:    0.7.0.1
 */