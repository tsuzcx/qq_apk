package com.tencent.mm.kernel;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class j
{
  private static long gEU;
  private static long gEV;
  private static volatile a gEW = null;
  
  public static void a(a parama)
  {
    gEW = parama;
  }
  
  public static void ajW() {}
  
  public static long ajX()
  {
    return gEV;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158324);
    if (gEW != null) {
      gEW.d(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(158324);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158321);
    if (gEW != null) {
      gEW.e(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(158321);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158323);
    if (gEW != null) {
      gEW.i(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(158323);
  }
  
  public static void p(String paramString, long paramLong)
  {
    AppMethodBeat.i(158319);
    ae.i("Blink-LOG", "since the %s : %s", new Object[] { paramString, Long.valueOf(System.nanoTime() - paramLong) });
    AppMethodBeat.o(158319);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158325);
    if (gEW != null) {
      gEW.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(158325);
  }
  
  public static void q(long paramLong1, long paramLong2)
  {
    gEU = paramLong1;
    gEV = paramLong2;
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158322);
    if (gEW != null) {
      gEW.w(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(158322);
  }
  
  public static long xJ(String paramString)
  {
    AppMethodBeat.i(197966);
    long l = SystemClock.elapsedRealtime() - gEV;
    ae.i("Blink-LOG", "since startup %s : %s", new Object[] { paramString, Long.valueOf(l) });
    String.format("since startup %s : %s", new Object[] { paramString, Long.valueOf(l) });
    AppMethodBeat.o(197966);
    return l;
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.j
 * JD-Core Version:    0.7.0.1
 */