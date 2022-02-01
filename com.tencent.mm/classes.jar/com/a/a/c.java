package com.a.a;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class c
{
  static final int aPv;
  private static final Method aPw;
  
  static
  {
    AppMethodBeat.i(206460);
    try
    {
      aPv = ((Integer)Canvas.class.getField("MATRIX_SAVE_FLAG").get(null)).intValue();
      aPw = Canvas.class.getMethod("save", new Class[] { Integer.TYPE });
      AppMethodBeat.o(206460);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(206460);
      throw localThrowable;
    }
  }
  
  static void c(Canvas paramCanvas, int paramInt)
  {
    AppMethodBeat.i(206459);
    try
    {
      aPw.invoke(paramCanvas, new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(206459);
      return;
    }
    catch (Throwable paramCanvas)
    {
      AppMethodBeat.o(206459);
      throw paramCanvas;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.a.a.c
 * JD-Core Version:    0.7.0.1
 */