package android.support.transition;

import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ac
{
  private static Method Dq;
  private static boolean Dr;
  
  static void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    
    if (Dq != null) {}
    try
    {
      Dq.invoke(paramViewGroup, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (InvocationTargetException paramViewGroup) {}catch (IllegalAccessException paramViewGroup) {}
  }
  
  private static void dP()
  {
    if (!Dr) {}
    try
    {
      Method localMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[] { Boolean.TYPE });
      Dq = localMethod;
      localMethod.setAccessible(true);
      label33:
      Dr = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label33;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.transition.ac
 * JD-Core Version:    0.7.0.1
 */