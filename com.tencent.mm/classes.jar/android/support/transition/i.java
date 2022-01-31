package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class i
  implements j
{
  static Class<?> qU;
  private static boolean qV;
  static Method qW;
  static boolean qX;
  static Method qY;
  static boolean qZ;
  private final View ra;
  
  private i(View paramView)
  {
    this.ra = paramView;
  }
  
  static void bw()
  {
    if (!qV) {}
    try
    {
      qU = Class.forName("android.view.GhostView");
      label14:
      qV = true;
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
    this.ra.setVisibility(paramInt);
  }
  
  static final class a
    implements j.a
  {
    public final j a(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
    {
      if (!i.qX) {}
      try
      {
        i.bw();
        Method localMethod = i.qU.getDeclaredMethod("addGhost", new Class[] { View.class, ViewGroup.class, Matrix.class });
        i.qW = localMethod;
        localMethod.setAccessible(true);
        label49:
        i.qX = true;
        if (i.qW != null) {
          try
          {
            paramView = new i((View)i.qW.invoke(null, new Object[] { paramView, paramViewGroup, paramMatrix }), (byte)0);
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
        break label49;
      }
    }
    
    public final void x(View paramView)
    {
      if (!i.qZ) {}
      try
      {
        i.bw();
        Method localMethod = i.qU.getDeclaredMethod("removeGhost", new Class[] { View.class });
        i.qY = localMethod;
        localMethod.setAccessible(true);
        label36:
        i.qZ = true;
        if (i.qY != null) {}
        try
        {
          i.qY.invoke(null, new Object[] { paramView });
          return;
        }
        catch (InvocationTargetException paramView)
        {
          throw new RuntimeException(paramView.getCause());
        }
        catch (IllegalAccessException paramView) {}
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        break label36;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.transition.i
 * JD-Core Version:    0.7.0.1
 */