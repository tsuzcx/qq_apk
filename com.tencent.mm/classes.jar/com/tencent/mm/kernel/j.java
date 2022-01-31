package com.tencent.mm.kernel;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class j
{
  private static long eIO;
  private static long eIP;
  private static volatile a eIQ = null;
  
  public static void RQ() {}
  
  public static void a(a parama)
  {
    eIQ = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(123271);
    if (eIQ != null) {
      eIQ.d(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(123271);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(123268);
    if (eIQ != null) {
      eIQ.e(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(123268);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(123270);
    if (eIQ != null) {
      eIQ.i(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(123270);
  }
  
  public static void ks(String paramString)
  {
    AppMethodBeat.i(123267);
    long l = SystemClock.elapsedRealtime() - eIP;
    ab.i("Blink-LOG", "since startup %s : %s", new Object[] { paramString, Long.valueOf(l) });
    String.format("since startup %s : %s", new Object[] { paramString, Long.valueOf(l) });
    AppMethodBeat.o(123267);
  }
  
  public static void p(String paramString, long paramLong)
  {
    AppMethodBeat.i(123266);
    ab.i("Blink-LOG", "since the %s : %s", new Object[] { paramString, Long.valueOf(System.nanoTime() - paramLong) });
    AppMethodBeat.o(123266);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(123272);
    if (eIQ != null) {
      eIQ.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(123272);
  }
  
  public static void s(long paramLong1, long paramLong2)
  {
    eIO = paramLong1;
    eIP = paramLong2;
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(123269);
    if (eIQ != null) {
      eIQ.w(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(123269);
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