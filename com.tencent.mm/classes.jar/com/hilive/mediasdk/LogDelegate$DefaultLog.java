package com.hilive.mediasdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class LogDelegate$DefaultLog
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.hilive.mediasdk.LogDelegate.DefaultLog
 * JD-Core Version:    0.7.0.1
 */