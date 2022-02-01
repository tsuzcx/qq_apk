package android.support.transition;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ai
  extends al
{
  private static Method DN;
  private static boolean DO;
  private static Method DP;
  private static boolean DQ;
  
  public final float P(View paramView)
  {
    if (!DQ) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
      DP = localMethod;
      localMethod.setAccessible(true);
      label27:
      DQ = true;
      if (DP != null) {
        try
        {
          float f = ((Float)DP.invoke(paramView, new Object[0])).floatValue();
          return f;
        }
        catch (InvocationTargetException paramView)
        {
          throw new RuntimeException(paramView.getCause());
        }
        catch (IllegalAccessException localIllegalAccessException) {}
      }
      return super.P(paramView);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label27;
    }
  }
  
  public final void Q(View paramView) {}
  
  public final void R(View paramView) {}
  
  public final void d(View paramView, float paramFloat)
  {
    if (!DO) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("setTransitionAlpha", new Class[] { Float.TYPE });
      DN = localMethod;
      localMethod.setAccessible(true);
      label33:
      DO = true;
      if (DN != null) {}
      try
      {
        DN.invoke(paramView, new Object[] { Float.valueOf(paramFloat) });
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
 * Qualified Name:     android.support.transition.ai
 * JD-Core Version:    0.7.0.1
 */