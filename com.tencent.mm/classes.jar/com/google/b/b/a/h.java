package com.google.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class h
{
  public String dBl = null;
  public Boolean dBm = null;
  public Integer dBn = null;
  public Thread.UncaughtExceptionHandler dBo = null;
  public ThreadFactory dBp = null;
  
  public static String format(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(208725);
    paramString = String.format(Locale.ROOT, paramString, paramVarArgs);
    AppMethodBeat.o(208725);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.b.a.h
 * JD-Core Version:    0.7.0.1
 */