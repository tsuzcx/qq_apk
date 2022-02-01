package com.hilive.mediasdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogDelegate
{
  private static ILog sImp;
  
  static
  {
    AppMethodBeat.i(73604);
    sImp = new LogDelegate.DefaultLog(null);
    AppMethodBeat.o(73604);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73599);
    sImp.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(73599);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73602);
    sImp.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(73602);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73600);
    sImp.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(73600);
  }
  
  public static void printStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73603);
    sImp.printStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    AppMethodBeat.o(73603);
  }
  
  public static void setImp(ILog paramILog)
  {
    if (paramILog != null) {
      sImp = paramILog;
    }
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73598);
    sImp.v(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(73598);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73601);
    sImp.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(73601);
  }
  
  public static abstract interface ILog
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void printStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
    
    public abstract void v(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.hilive.mediasdk.LogDelegate
 * JD-Core Version:    0.7.0.1
 */