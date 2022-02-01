package com.a.a;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class c
{
  static final int axO;
  private static final Method axP;
  
  static
  {
    AppMethodBeat.i(201719);
    try
    {
      axO = ((Integer)Canvas.class.getField("MATRIX_SAVE_FLAG").get(null)).intValue();
      axP = Canvas.class.getMethod("save", new Class[] { Integer.TYPE });
      AppMethodBeat.o(201719);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(201719);
      throw localThrowable;
    }
  }
  
  static void c(Canvas paramCanvas, int paramInt)
  {
    AppMethodBeat.i(201716);
    try
    {
      axP.invoke(paramCanvas, new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(201716);
      return;
    }
    catch (Throwable paramCanvas)
    {
      AppMethodBeat.o(201716);
      throw paramCanvas;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.a.a.c
 * JD-Core Version:    0.7.0.1
 */