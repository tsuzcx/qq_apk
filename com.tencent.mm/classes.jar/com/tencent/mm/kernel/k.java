package com.tencent.mm.kernel;

import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.y;

public final class k
{
  private static long dLq;
  private static long dLr;
  private static volatile a dLs = null;
  
  public static void a(a parama)
  {
    dLs = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (dLs != null) {
      dLs.d(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (dLs != null) {
      dLs.e(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void el(String paramString)
  {
    long l = SystemClock.elapsedRealtime() - dLr;
    y.i("Blink-LOG", "since startup %s : %s", new Object[] { paramString, Long.valueOf(l) });
    String.format("since startup %s : %s", new Object[] { paramString, Long.valueOf(l) });
  }
  
  public static void h(String paramString, long paramLong)
  {
    y.i("Blink-LOG", "since the %s : %s", new Object[] { paramString, Long.valueOf(System.nanoTime() - paramLong) });
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (dLs != null) {
      dLs.i(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void l(long paramLong1, long paramLong2)
  {
    dLq = paramLong1;
    dLr = paramLong2;
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (dLs != null) {
      dLs.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (dLs != null) {
      dLs.w(paramString1, paramString2, paramVarArgs);
    }
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
 * Qualified Name:     com.tencent.mm.kernel.k
 * JD-Core Version:    0.7.0.1
 */