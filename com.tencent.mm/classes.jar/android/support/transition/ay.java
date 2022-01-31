package android.support.transition;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ay
  extends ax
{
  private static Method tA;
  private static boolean tB;
  private static Method tC;
  private static boolean tD;
  
  public final float H(View paramView)
  {
    if (!tD) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
      tC = localMethod;
      localMethod.setAccessible(true);
      label27:
      tD = true;
      if (tC != null) {
        try
        {
          float f = ((Float)tC.invoke(paramView, new Object[0])).floatValue();
          return f;
        }
        catch (InvocationTargetException paramView)
        {
          throw new RuntimeException(paramView.getCause());
        }
        catch (IllegalAccessException localIllegalAccessException) {}
      }
      return super.H(paramView);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label27;
    }
  }
  
  public final void I(View paramView) {}
  
  public final void J(View paramView) {}
  
  public final void c(View paramView, float paramFloat)
  {
    if (!tB) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("setTransitionAlpha", new Class[] { Float.TYPE });
      tA = localMethod;
      localMethod.setAccessible(true);
      label33:
      tB = true;
      if (tA != null) {}
      try
      {
        tA.invoke(paramView, new Object[] { Float.valueOf(paramFloat) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.ay
 * JD-Core Version:    0.7.0.1
 */