package com.tencent.mm.audio.mix.h;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  private static a huW;
  private static a huX;
  private static int level;
  
  static
  {
    AppMethodBeat.i(136967);
    level = 6;
    a local1 = new a()
    {
      private Handler handler;
    };
    huW = local1;
    huX = local1;
    AppMethodBeat.o(136967);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136963);
    Log.d(paramString1, paramString2, null);
    AppMethodBeat.o(136963);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136961);
    Log.e(paramString1, paramString2, null);
    AppMethodBeat.o(136961);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(136964);
    Log.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(136964);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136962);
    Log.i(paramString1, paramString2, null);
    AppMethodBeat.o(136962);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(136965);
    Log.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(136965);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(136966);
    Log.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    AppMethodBeat.o(136966);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.audio.mix.h.b
 * JD-Core Version:    0.7.0.1
 */