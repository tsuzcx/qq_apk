package android.support.design.widget;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import java.lang.reflect.Method;

public final class g
{
  private static Method pd;
  private static boolean pe;
  
  static boolean a(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState)
  {
    if (!pe) {}
    try
    {
      Method localMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[] { DrawableContainer.DrawableContainerState.class });
      pd = localMethod;
      localMethod.setAccessible(true);
      label32:
      pe = true;
      if (pd != null) {
        try
        {
          pd.invoke(paramDrawableContainer, new Object[] { paramConstantState });
          return true;
        }
        catch (Exception paramDrawableContainer) {}
      }
      return false;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label32;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.g
 * JD-Core Version:    0.7.0.1
 */