package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ai
  extends ah
{
  private static Method DI;
  private static boolean DJ;
  private static Method DK;
  private static boolean DL;
  private static Method DM;
  private static boolean DN;
  
  public final void a(View paramView, Matrix paramMatrix)
  {
    if (!DJ) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[] { Matrix.class });
      DI = localMethod;
      localMethod.setAccessible(true);
      label32:
      DJ = true;
      if (DI != null) {}
      try
      {
        DI.invoke(paramView, new Object[] { paramMatrix });
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
    if (!DL) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[] { Matrix.class });
      DK = localMethod;
      localMethod.setAccessible(true);
      label32:
      DL = true;
      if (DK != null) {}
      try
      {
        DK.invoke(paramView, new Object[] { paramMatrix });
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
    if (!DN) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("setAnimationMatrix", new Class[] { Matrix.class });
      DM = localMethod;
      localMethod.setAccessible(true);
      label32:
      DN = true;
      if (DM != null) {}
      try
      {
        DM.invoke(paramView, new Object[] { paramMatrix });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.ai
 * JD-Core Version:    0.7.0.1
 */