package android.support.transition;

import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ap
  extends ao
{
  private static Method ul;
  private static boolean um;
  
  public final am c(ViewGroup paramViewGroup)
  {
    return new al(paramViewGroup);
  }
  
  public final void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (!um) {}
    try
    {
      Method localMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[] { Boolean.TYPE });
      ul = localMethod;
      localMethod.setAccessible(true);
      label33:
      um = true;
      if (ul != null) {}
      try
      {
        ul.invoke(paramViewGroup, new Object[] { Boolean.valueOf(paramBoolean) });
        return;
      }
      catch (InvocationTargetException paramViewGroup) {}catch (IllegalAccessException paramViewGroup) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label33;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.ap
 * JD-Core Version:    0.7.0.1
 */