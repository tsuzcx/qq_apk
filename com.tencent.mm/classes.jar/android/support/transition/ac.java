package android.support.transition;

import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ac
{
  private static Method By;
  private static boolean Bz;
  
  static void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    
    if (By != null) {}
    try
    {
      By.invoke(paramViewGroup, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (InvocationTargetException paramViewGroup) {}catch (IllegalAccessException paramViewGroup) {}
  }
  
  private static void dA()
  {
    if (!Bz) {}
    try
    {
      Method localMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[] { Boolean.TYPE });
      By = localMethod;
      localMethod.setAccessible(true);
      label33:
      Bz = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label33;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.transition.ac
 * JD-Core Version:    0.7.0.1
 */