package android.support.transition;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ax
  extends aw
{
  private static Method uB;
  private static boolean uC;
  private static Method uD;
  private static boolean uE;
  
  public final float L(View paramView)
  {
    if (!uE) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
      uD = localMethod;
      localMethod.setAccessible(true);
      label27:
      uE = true;
      if (uD != null) {
        try
        {
          float f = ((Float)uD.invoke(paramView, new Object[0])).floatValue();
          return f;
        }
        catch (InvocationTargetException paramView)
        {
          throw new RuntimeException(paramView.getCause());
        }
        catch (IllegalAccessException localIllegalAccessException) {}
      }
      return super.L(paramView);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label27;
    }
  }
  
  public final void M(View paramView) {}
  
  public final void N(View paramView) {}
  
  public final void d(View paramView, float paramFloat)
  {
    if (!uC) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("setTransitionAlpha", new Class[] { Float.TYPE });
      uB = localMethod;
      localMethod.setAccessible(true);
      label33:
      uC = true;
      if (uB != null) {}
      try
      {
        uB.invoke(paramView, new Object[] { Float.valueOf(paramFloat) });
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
 * Qualified Name:     android.support.transition.ax
 * JD-Core Version:    0.7.0.1
 */