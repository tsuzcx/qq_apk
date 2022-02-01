package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class f
  implements g
{
  static Class<?> Bh;
  private static boolean Bi;
  private static Method Bj;
  private static boolean Bk;
  static Method Bl;
  static boolean Bm;
  private final View Bn;
  
  private f(View paramView)
  {
    this.Bn = paramView;
  }
  
  static g a(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    if (!Bk) {}
    try
    {
      dI();
      Method localMethod = Bh.getDeclaredMethod("addGhost", new Class[] { View.class, ViewGroup.class, Matrix.class });
      Bj = localMethod;
      localMethod.setAccessible(true);
      label46:
      Bk = true;
      if (Bj != null) {
        try
        {
          paramView = new f((View)Bj.invoke(null, new Object[] { paramView, paramViewGroup, paramMatrix }));
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
  
  static void dI()
  {
    if (!Bi) {}
    try
    {
      Bh = Class.forName("android.view.GhostView");
      label14:
      Bi = true;
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
    this.Bn.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.f
 * JD-Core Version:    0.7.0.1
 */