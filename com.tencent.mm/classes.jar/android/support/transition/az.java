package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class az
  extends ay
{
  private static Method tE;
  private static boolean tF;
  private static Method tG;
  private static boolean tH;
  private static Method tI;
  private static boolean tJ;
  
  public final void a(View paramView, Matrix paramMatrix)
  {
    if (!tF) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[] { Matrix.class });
      tE = localMethod;
      localMethod.setAccessible(true);
      label32:
      tF = true;
      if (tE != null) {}
      try
      {
        tE.invoke(paramView, new Object[] { paramMatrix });
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
    if (!tH) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[] { Matrix.class });
      tG = localMethod;
      localMethod.setAccessible(true);
      label32:
      tH = true;
      if (tG != null) {}
      try
      {
        tG.invoke(paramView, new Object[] { paramMatrix });
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
    if (!tJ) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("setAnimationMatrix", new Class[] { Matrix.class });
      tI = localMethod;
      localMethod.setAccessible(true);
      label32:
      tJ = true;
      if (tI != null) {}
      try
      {
        tI.invoke(paramView, new Object[] { paramMatrix });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.az
 * JD-Core Version:    0.7.0.1
 */