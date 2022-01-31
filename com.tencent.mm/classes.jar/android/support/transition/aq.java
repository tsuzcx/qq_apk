package android.support.transition;

import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class aq
  extends ap
{
  private static Method ti;
  private static boolean tj;
  
  public final void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (!tj) {}
    try
    {
      Method localMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[] { Boolean.TYPE });
      ti = localMethod;
      localMethod.setAccessible(true);
      label33:
      tj = true;
      if (ti != null) {}
      try
      {
        ti.invoke(paramViewGroup, new Object[] { Boolean.valueOf(paramBoolean) });
        return;
      }
      catch (InvocationTargetException paramViewGroup) {}catch (IllegalAccessException paramViewGroup) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label33;
    }
  }
  
  public final an d(ViewGroup paramViewGroup)
  {
    return new am(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.aq
 * JD-Core Version:    0.7.0.1
 */