package com.tencent.mm.kernel;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
{
  private static long hrI;
  private static long hrJ;
  private static volatile a hrK = null;
  
  public static long FT(String paramString)
  {
    AppMethodBeat.i(230544);
    long l = SystemClock.elapsedRealtime() - hrJ;
    Log.i("Blink-LOG", "since startup %s : %s", new Object[] { paramString, Long.valueOf(l) });
    String.format("since startup %s : %s", new Object[] { paramString, Long.valueOf(l) });
    AppMethodBeat.o(230544);
    return l;
  }
  
  public static void a(a parama)
  {
    hrK = parama;
  }
  
  public static void aAm() {}
  
  public static long aAn()
  {
    return hrJ;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158324);
    if (hrK != null) {
      hrK.d(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(158324);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158321);
    if (hrK != null) {
      hrK.e(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(158321);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158323);
    if (hrK != null) {
      hrK.i(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(158323);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158325);
    if (hrK != null) {
      hrK.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(158325);
  }
  
  public static void q(String paramString, long paramLong)
  {
    AppMethodBeat.i(158319);
    Log.i("Blink-LOG", "since the %s : %s", new Object[] { paramString, Long.valueOf(System.nanoTime() - paramLong) });
    AppMethodBeat.o(158319);
  }
  
  public static void r(long paramLong1, long paramLong2)
  {
    hrI = paramLong1;
    hrJ = paramLong2;
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158322);
    if (hrK != null) {
      hrK.w(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(158322);
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