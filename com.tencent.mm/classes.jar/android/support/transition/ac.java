package android.support.transition;

import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ac
{
  private static Method AA;
  private static boolean AB;
  
  static void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    
    if (AA != null) {}
    try
    {
      AA.invoke(paramViewGroup, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (InvocationTargetException paramViewGroup) {}catch (IllegalAccessException paramViewGroup) {}
  }
  
  private static void dt()
  {
    if (!AB) {}
    try
    {
      Method localMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[] { Boolean.TYPE });
      AA = localMethod;
      localMethod.setAccessible(true);
      label33:
      AB = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label33;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.ac
 * JD-Core Version:    0.7.0.1
 */