package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class f
  implements g
{
  static Class<?> yq;
  private static boolean yr;
  private static Method ys;
  private static boolean yt;
  static Method yu;
  static boolean yv;
  private final View yw;
  
  private f(View paramView)
  {
    this.yw = paramView;
  }
  
  static g a(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    if (!yt) {}
    try
    {
      dm();
      Method localMethod = yq.getDeclaredMethod("addGhost", new Class[] { View.class, ViewGroup.class, Matrix.class });
      ys = localMethod;
      localMethod.setAccessible(true);
      label46:
      yt = true;
      if (ys != null) {
        try
        {
          paramView = new f((View)ys.invoke(null, new Object[] { paramView, paramViewGroup, paramMatrix }));
          return paramView;
        }
        catch (InvocationTargetException paramView)
        {
          throw new RuntimeException(paramView.getCause());
        }
        catch (IllegalAccessException paramView) {}
      }
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label46;
    }
  }
  
  static void dm()
  {
    if (!yr) {}
    try
    {
      yq = Class.forName("android.view.GhostView");
      label14:
      yr = true;
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label14;
    }
  }
  
  public final void a(ViewGroup paramViewGroup, View paramView) {}
  
  public final void setVisibility(int paramInt)
  {
    this.yw.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.f
 * JD-Core Version:    0.7.0.1
 */