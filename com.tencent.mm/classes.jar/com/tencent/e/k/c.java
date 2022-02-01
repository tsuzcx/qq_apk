package com.tencent.e.k;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static boolean c(Class<?> paramClass, String paramString, Object paramObject)
  {
    AppMethodBeat.i(183496);
    boolean bool = new a(paramClass, paramString).eu(paramObject);
    AppMethodBeat.o(183496);
    return bool;
  }
  
  public static <T> T f(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(183495);
    paramClass = new a(paramClass, paramString).get();
    AppMethodBeat.o(183495);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.k.c
 * JD-Core Version:    0.7.0.1
 */