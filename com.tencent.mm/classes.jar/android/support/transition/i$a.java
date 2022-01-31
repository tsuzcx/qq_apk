package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class i$a
  implements j.a
{
  public final void A(View paramView)
  {
    if (!i.rW) {}
    try
    {
      i.ck();
      Method localMethod = i.rR.getDeclaredMethod("removeGhost", new Class[] { View.class });
      i.rV = localMethod;
      localMethod.setAccessible(true);
      label36:
      i.rW = true;
      if (i.rV != null) {}
      try
      {
        i.rV.invoke(null, new Object[] { paramView });
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
      break label36;
    }
  }
  
  public final j a(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    if (!i.rU) {}
    try
    {
      i.ck();
      Method localMethod = i.rR.getDeclaredMethod("addGhost", new Class[] { View.class, ViewGroup.class, Matrix.class });
      i.rT = localMethod;
      localMethod.setAccessible(true);
      label49:
      i.rU = true;
      if (i.rT != null) {
        try
        {
          paramView = new i((View)i.rT.invoke(null, new Object[] { paramView, paramViewGroup, paramMatrix }), (byte)0);
          return paramView;
        }
        catch (InvocationTargetException paramView)
        {
          throw new RuntimeException(paramView.getCause());
        }
        catch (IllegalAccessException paramView) {}
      }
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label49;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.transition.i.a
 * JD-Core Version:    0.7.0.1
 */