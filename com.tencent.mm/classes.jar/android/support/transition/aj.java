package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class aj
  extends ai
{
  private static Method DR;
  private static boolean DS;
  private static Method DT;
  private static boolean DU;
  private static Method DV;
  private static boolean DW;
  
  public final void a(View paramView, Matrix paramMatrix)
  {
    if (!DS) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[] { Matrix.class });
      DR = localMethod;
      localMethod.setAccessible(true);
      label32:
      DS = true;
      if (DR != null) {}
      try
      {
        DR.invoke(paramView, new Object[] { paramMatrix });
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
    if (!DU) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[] { Matrix.class });
      DT = localMethod;
      localMethod.setAccessible(true);
      label32:
      DU = true;
      if (DT != null) {}
      try
      {
        DT.invoke(paramView, new Object[] { paramMatrix });
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
    if (!DW) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("setAnimationMatrix", new Class[] { Matrix.class });
      DV = localMethod;
      localMethod.setAccessible(true);
      label32:
      DW = true;
      if (DV != null) {}
      try
      {
        DV.invoke(paramView, new Object[] { paramMatrix });
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
 * Qualified Name:     android.support.transition.aj
 * JD-Core Version:    0.7.0.1
 */