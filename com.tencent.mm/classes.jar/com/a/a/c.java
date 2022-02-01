package com.a.a;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class c
{
  static final int ctD;
  private static final Method ctE;
  
  static
  {
    AppMethodBeat.i(207760);
    try
    {
      ctD = ((Integer)Canvas.class.getField("MATRIX_SAVE_FLAG").get(null)).intValue();
      ctE = Canvas.class.getMethod("save", new Class[] { Integer.TYPE });
      return;
    }
    finally
    {
      AppMethodBeat.o(207760);
    }
  }
  
  static void d(Canvas paramCanvas, int paramInt)
  {
    AppMethodBeat.i(207754);
    try
    {
      ctE.invoke(paramCanvas, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    finally
    {
      AppMethodBeat.o(207754);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.a.a.c
 * JD-Core Version:    0.7.0.1
 */