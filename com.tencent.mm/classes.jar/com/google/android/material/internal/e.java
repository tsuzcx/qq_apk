package com.google.android.material.internal;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class e
{
  private static Method dvn;
  private static boolean dvo;
  
  public static boolean a(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState)
  {
    AppMethodBeat.i(209262);
    if (!dvo) {}
    try
    {
      Method localMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[] { DrawableContainer.DrawableContainerState.class });
      dvn = localMethod;
      localMethod.setAccessible(true);
      label37:
      dvo = true;
      if (dvn != null) {
        try
        {
          dvn.invoke(paramDrawableContainer, new Object[] { paramConstantState });
          AppMethodBeat.o(209262);
          return true;
        }
        catch (Exception paramDrawableContainer) {}
      }
      AppMethodBeat.o(209262);
      return false;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.internal.e
 * JD-Core Version:    0.7.0.1
 */