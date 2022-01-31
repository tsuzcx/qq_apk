package com.tencent.mm.compatible.util;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public static String Mk()
  {
    AppMethodBeat.i(93077);
    String str = new java.lang.Throwable().getStackTrace()[1].toString();
    AppMethodBeat.o(93077);
    return str;
  }
  
  public static String Ml()
  {
    AppMethodBeat.i(93078);
    Object localObject = new java.lang.Throwable().getStackTrace()[1];
    int i = ((StackTraceElement)localObject).getMethodName().lastIndexOf('.');
    localObject = ((StackTraceElement)localObject).getMethodName().substring(i + 1) + "(" + ((StackTraceElement)localObject).getFileName() + ":" + ((StackTraceElement)localObject).getLineNumber() + ")";
    AppMethodBeat.o(93078);
    return localObject;
  }
  
  public static int getLine()
  {
    AppMethodBeat.i(93076);
    int i = new java.lang.Throwable().getStackTrace()[1].getLineNumber();
    AppMethodBeat.o(93076);
    return i;
  }
  
  public static final class a
  {
    public long etf;
    
    public a()
    {
      AppMethodBeat.i(93073);
      this.etf = SystemClock.elapsedRealtime();
      AppMethodBeat.o(93073);
    }
    
    public final long Mm()
    {
      AppMethodBeat.i(93075);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.etf;
      AppMethodBeat.o(93075);
      return l1 - l2;
    }
    
    public final void reset()
    {
      AppMethodBeat.i(156798);
      this.etf = SystemClock.elapsedRealtime();
      AppMethodBeat.o(156798);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.g
 * JD-Core Version:    0.7.0.1
 */