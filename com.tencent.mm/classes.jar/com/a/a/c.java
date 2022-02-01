package com.a.a;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class c
{
  static final int aPC;
  private static final Method aPD;
  
  static
  {
    AppMethodBeat.i(212964);
    try
    {
      aPC = ((Integer)Canvas.class.getField("MATRIX_SAVE_FLAG").get(null)).intValue();
      aPD = Canvas.class.getMethod("save", new Class[] { Integer.TYPE });
      AppMethodBeat.o(212964);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(212964);
      throw localThrowable;
    }
  }
  
  static void c(Canvas paramCanvas, int paramInt)
  {
    AppMethodBeat.i(212963);
    try
    {
      aPD.invoke(paramCanvas, new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(212963);
      return;
    }
    catch (Throwable paramCanvas)
    {
      AppMethodBeat.o(212963);
      throw paramCanvas;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.a.a.c
 * JD-Core Version:    0.7.0.1
 */