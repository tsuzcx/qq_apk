package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class f
  implements g
{
  static Class<?> Bn;
  private static boolean Bo;
  private static Method Bp;
  private static boolean Bq;
  static Method Br;
  static boolean Bs;
  private final View Bt;
  
  private f(View paramView)
  {
    this.Bt = paramView;
  }
  
  static g a(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    if (!Bq) {}
    try
    {
      dL();
      Method localMethod = Bn.getDeclaredMethod("addGhost", new Class[] { View.class, ViewGroup.class, Matrix.class });
      Bp = localMethod;
      localMethod.setAccessible(true);
      label46:
      Bq = true;
      if (Bp != null) {
        try
        {
          paramView = new f((View)Bp.invoke(null, new Object[] { paramView, paramViewGroup, paramMatrix }));
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
  
  static void dL()
  {
    if (!Bo) {}
    try
    {
      Bn = Class.forName("android.view.GhostView");
      label14:
      Bo = true;
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
    this.Bt.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.f
 * JD-Core Version:    0.7.0.1
 */