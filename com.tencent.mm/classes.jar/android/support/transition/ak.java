package android.support.transition;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ak
  extends aj
{
  private static Method DX;
  private static boolean DY;
  
  public final void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!DY) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("setLeftTopRightBottom", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE });
      DX = localMethod;
      localMethod.setAccessible(true);
      label54:
      DY = true;
      if (DX != null) {}
      try
      {
        DX.invoke(paramView, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.ak
 * JD-Core Version:    0.7.0.1
 */