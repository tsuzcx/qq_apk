package android.support.transition;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ah
  extends ak
{
  private static Method AO;
  private static boolean AP;
  private static Method AQ;
  private static boolean AR;
  
  public final float O(View paramView)
  {
    if (!AR) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
      AQ = localMethod;
      localMethod.setAccessible(true);
      label27:
      AR = true;
      if (AQ != null) {
        try
        {
          float f = ((Float)AQ.invoke(paramView, new Object[0])).floatValue();
          return f;
        }
        catch (InvocationTargetException paramView)
        {
          throw new RuntimeException(paramView.getCause());
        }
        catch (IllegalAccessException localIllegalAccessException) {}
      }
      return super.O(paramView);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label27;
    }
  }
  
  public final void P(View paramView) {}
  
  public final void Q(View paramView) {}
  
  public final void d(View paramView, float paramFloat)
  {
    if (!AP) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("setTransitionAlpha", new Class[] { Float.TYPE });
      AO = localMethod;
      localMethod.setAccessible(true);
      label33:
      AP = true;
      if (AO != null) {}
      try
      {
        AO.invoke(paramView, new Object[] { Float.valueOf(paramFloat) });
        return;
      }
      catch (InvocationTargetException paramView)
      {
        throw new RuntimeException(paramView.getCause());
        paramView.setAlpha(paramFloat);
        return;
      }
      catch (IllegalAccessException paramView) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label33;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.ah
 * JD-Core Version:    0.7.0.1
 */