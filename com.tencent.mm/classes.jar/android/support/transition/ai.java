package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ai
  extends ah
{
  private static Method AS;
  private static boolean AT;
  private static Method AU;
  private static boolean AV;
  private static Method AW;
  private static boolean AX;
  
  public final void a(View paramView, Matrix paramMatrix)
  {
    if (!AT) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[] { Matrix.class });
      AS = localMethod;
      localMethod.setAccessible(true);
      label32:
      AT = true;
      if (AS != null) {}
      try
      {
        AS.invoke(paramView, new Object[] { paramMatrix });
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
      break label32;
    }
  }
  
  public final void b(View paramView, Matrix paramMatrix)
  {
    if (!AV) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[] { Matrix.class });
      AU = localMethod;
      localMethod.setAccessible(true);
      label32:
      AV = true;
      if (AU != null) {}
      try
      {
        AU.invoke(paramView, new Object[] { paramMatrix });
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
      break label32;
    }
  }
  
  public final void c(View paramView, Matrix paramMatrix)
  {
    if (!AX) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("setAnimationMatrix", new Class[] { Matrix.class });
      AW = localMethod;
      localMethod.setAccessible(true);
      label32:
      AX = true;
      if (AW != null) {}
      try
      {
        AW.invoke(paramView, new Object[] { paramMatrix });
        return;
      }
      catch (IllegalAccessException paramView)
      {
        throw new RuntimeException(paramView.getCause());
      }
      catch (InvocationTargetException paramView) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label32;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.ai
 * JD-Core Version:    0.7.0.1
 */