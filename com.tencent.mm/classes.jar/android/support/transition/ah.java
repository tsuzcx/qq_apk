package android.support.transition;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ah
  extends ak
{
  private static Method DE;
  private static boolean DF;
  private static Method DG;
  private static boolean DH;
  
  public final float O(View paramView)
  {
    if (!DH) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
      DG = localMethod;
      localMethod.setAccessible(true);
      label27:
      DH = true;
      if (DG != null) {
        try
        {
          float f = ((Float)DG.invoke(paramView, new Object[0])).floatValue();
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
    if (!DF) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("setTransitionAlpha", new Class[] { Float.TYPE });
      DE = localMethod;
      localMethod.setAccessible(true);
      label33:
      DF = true;
      if (DE != null) {}
      try
      {
        DE.invoke(paramView, new Object[] { Float.valueOf(paramFloat) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.transition.ah
 * JD-Core Version:    0.7.0.1
 */