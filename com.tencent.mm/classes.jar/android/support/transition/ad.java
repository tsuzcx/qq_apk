package android.support.transition;

import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ad
{
  private static boolean DA;
  private static Method Dz;
  
  static void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    
    if (Dz != null) {}
    try
    {
      Dz.invoke(paramViewGroup, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (InvocationTargetException paramViewGroup) {}catch (IllegalAccessException paramViewGroup) {}
  }
  
  private static void dT()
  {
    if (!DA) {}
    try
    {
      Method localMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[] { Boolean.TYPE });
      Dz = localMethod;
      localMethod.setAccessible(true);
      label33:
      DA = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label33;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.ad
 * JD-Core Version:    0.7.0.1
 */