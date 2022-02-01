package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class f
  implements g
{
  static Class<?> zp;
  private static boolean zq;
  private static Method zr;
  private static boolean zt;
  static Method zu;
  static boolean zv;
  private final View zw;
  
  private f(View paramView)
  {
    this.zw = paramView;
  }
  
  static g a(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    if (!zt) {}
    try
    {
      dt();
      Method localMethod = zp.getDeclaredMethod("addGhost", new Class[] { View.class, ViewGroup.class, Matrix.class });
      zr = localMethod;
      localMethod.setAccessible(true);
      label46:
      zt = true;
      if (zr != null) {
        try
        {
          paramView = new f((View)zr.invoke(null, new Object[] { paramView, paramViewGroup, paramMatrix }));
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
  
  static void dt()
  {
    if (!zq) {}
    try
    {
      zp = Class.forName("android.view.GhostView");
      label14:
      zq = true;
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
    this.zw.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.f
 * JD-Core Version:    0.7.0.1
 */