package com.tencent.mm.kernel;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
{
  private static long gdX;
  private static long gdY;
  private static volatile a gdZ = null;
  
  public static void a(a parama)
  {
    gdZ = parama;
  }
  
  public static void afG() {}
  
  public static long afH()
  {
    return gdY;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158324);
    if (gdZ != null) {
      gdZ.d(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(158324);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158321);
    if (gdZ != null) {
      gdZ.e(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(158321);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158323);
    if (gdZ != null) {
      gdZ.i(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(158323);
  }
  
  public static void p(String paramString, long paramLong)
  {
    AppMethodBeat.i(158319);
    ad.i("Blink-LOG", "since the %s : %s", new Object[] { paramString, Long.valueOf(System.nanoTime() - paramLong) });
    AppMethodBeat.o(158319);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158325);
    if (gdZ != null) {
      gdZ.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(158325);
  }
  
  public static long qV(String paramString)
  {
    AppMethodBeat.i(190811);
    long l = SystemClock.elapsedRealtime() - gdY;
    ad.i("Blink-LOG", "since startup %s : %s", new Object[] { paramString, Long.valueOf(l) });
    String.format("since startup %s : %s", new Object[] { paramString, Long.valueOf(l) });
    AppMethodBeat.o(190811);
    return l;
  }
  
  public static void u(long paramLong1, long paramLong2)
  {
    gdX = paramLong1;
    gdY = paramLong2;
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158322);
    if (gdZ != null) {
      gdZ.w(paramString1, paramString2, paramVarArgs);
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