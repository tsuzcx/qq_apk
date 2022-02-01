package com.hilive.mediasdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogDelegate
{
  private static ILog sImp;
  
  static
  {
    AppMethodBeat.i(73604);
    sImp = new DefaultLog(null);
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
  
  static class DefaultLog
    implements LogDelegate.ILog
  {
    public void d(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(73593);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(73593);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(73593);
      }
    }
    
    public void e(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(73596);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(73596);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(73596);
      }
    }
    
    public void i(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(73594);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(73594);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(73594);
      }
    }
    
    public void printStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(73597);
      if (paramThrowable != null)
      {
        if (paramVarArgs != null) {}
        try
        {
          if (paramVarArgs.length > 0) {
            String.format(paramString2, paramVarArgs);
          }
          AppMethodBeat.o(73597);
          return;
        }
        catch (Exception paramString1) {}
      }
      AppMethodBeat.o(73597);
    }
    
    public void v(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(73592);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(73592);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(73592);
      }
    }
    
    public void w(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(73595);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(73595);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(73595);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.hilive.mediasdk.LogDelegate
 * JD-Core Version:    0.7.0.1
 */