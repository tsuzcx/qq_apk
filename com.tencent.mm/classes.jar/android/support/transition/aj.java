package android.support.transition;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class aj
  extends ai
{
  private static Method BW;
  private static boolean BX;
  
  public final void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!BX) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("setLeftTopRightBottom", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE });
      BW = localMethod;
      localMethod.setAccessible(true);
      label54:
      BX = true;
      if (BW != null) {}
      try
      {
        BW.invoke(paramView, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
        return;
      }
      catch (InvocationTargetException paramView)
      {
        throw new RuntimeException(paramView.getCause());
      }
      catch (IllegalAccessException paramView) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label54;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.transition.aj
 * JD-Core Version:    0.7.0.1
 */