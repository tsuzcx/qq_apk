package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ai
  extends ah
{
  private static Method BQ;
  private static boolean BR;
  private static Method BS;
  private static boolean BT;
  private static Method BU;
  private static boolean BV;
  
  public final void a(View paramView, Matrix paramMatrix)
  {
    if (!BR) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[] { Matrix.class });
      BQ = localMethod;
      localMethod.setAccessible(true);
      label32:
      BR = true;
      if (BQ != null) {}
      try
      {
        BQ.invoke(paramView, new Object[] { paramMatrix });
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
    if (!BT) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[] { Matrix.class });
      BS = localMethod;
      localMethod.setAccessible(true);
      label32:
      BT = true;
      if (BS != null) {}
      try
      {
        BS.invoke(paramView, new Object[] { paramMatrix });
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
    if (!BV) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("setAnimationMatrix", new Class[] { Matrix.class });
      BU = localMethod;
      localMethod.setAccessible(true);
      label32:
      BV = true;
      if (BU != null) {}
      try
      {
        BU.invoke(paramView, new Object[] { paramMatrix });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.transition.ai
 * JD-Core Version:    0.7.0.1
 */