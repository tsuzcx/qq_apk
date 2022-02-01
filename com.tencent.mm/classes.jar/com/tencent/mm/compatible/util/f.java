package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public static String app()
  {
    AppMethodBeat.i(155882);
    String str = new java.lang.Throwable().getStackTrace()[1].toString();
    AppMethodBeat.o(155882);
    return str;
  }
  
  public static String apq()
  {
    AppMethodBeat.i(155883);
    Object localObject = new java.lang.Throwable().getStackTrace()[1];
    int i = ((StackTraceElement)localObject).getMethodName().lastIndexOf('.');
    localObject = ((StackTraceElement)localObject).getMethodName().substring(i + 1) + "(" + ((StackTraceElement)localObject).getFileName() + ":" + ((StackTraceElement)localObject).getLineNumber() + ")";
    AppMethodBeat.o(155883);
    return localObject;
  }
  
  public static int getLine()
  {
    AppMethodBeat.i(155881);
    int i = new java.lang.Throwable().getStackTrace()[1].getLineNumber();
    AppMethodBeat.o(155881);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.util.f
 * JD-Core Version:    0.7.0.1
 */