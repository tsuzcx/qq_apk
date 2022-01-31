package com.hilive.mediasdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogDelegate
{
  private static LogDelegate.ILog sImp;
  
  static
  {
    AppMethodBeat.i(142846);
    sImp = new DefaultLog(null);
    AppMethodBeat.o(142846);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(142841);
    sImp.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(142841);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(142844);
    sImp.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(142844);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(142842);
    sImp.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(142842);
  }
  
  public static void printStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(142845);
    sImp.printStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    AppMethodBeat.o(142845);
  }
  
  public static void setImp(LogDelegate.ILog paramILog)
  {
    if (paramILog != null) {
      sImp = paramILog;
    }
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(142840);
    sImp.v(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(142840);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(142843);
    sImp.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(142843);
  }
  
  static class DefaultLog
    implements LogDelegate.ILog
  {
    public void d(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(142835);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(142835);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(142835);
      }
    }
    
    public void e(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(142838);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(142838);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(142838);
      }
    }
    
    public void i(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(142836);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(142836);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(142836);
      }
    }
    
    public void printStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(142839);
      if (paramThrowable != null)
      {
        if (paramVarArgs != null) {}
        try
        {
          if (paramVarArgs.length > 0) {
            String.format(paramString2, paramVarArgs);
          }
          AppMethodBeat.o(142839);
          return;
        }
        catch (Exception paramString1) {}
      }
      AppMethodBeat.o(142839);
    }
    
    public void v(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(142834);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(142834);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(142834);
      }
    }
    
    public void w(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(142837);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(142837);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(142837);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.hilive.mediasdk.LogDelegate
 * JD-Core Version:    0.7.0.1
 */