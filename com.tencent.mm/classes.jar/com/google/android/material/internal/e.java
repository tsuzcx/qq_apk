package com.google.android.material.internal;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class e
{
  private static Method bCl;
  private static boolean bCm;
  
  public static boolean a(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState)
  {
    AppMethodBeat.i(237652);
    if (!bCm) {}
    try
    {
      Method localMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[] { DrawableContainer.DrawableContainerState.class });
      bCl = localMethod;
      localMethod.setAccessible(true);
      label37:
      bCm = true;
      if (bCl != null) {
        try
        {
          bCl.invoke(paramDrawableContainer, new Object[] { paramConstantState });
          AppMethodBeat.o(237652);
          return true;
        }
        catch (Exception paramDrawableContainer) {}
      }
      AppMethodBeat.o(237652);
      return false;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.material.internal.e
 * JD-Core Version:    0.7.0.1
 */