package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public final class e
{
  public static boolean GJ(String paramString)
  {
    AppMethodBeat.i(155997);
    if (paramString.lastIndexOf(";?enc=") > 0)
    {
      AppMethodBeat.o(155997);
      return true;
    }
    AppMethodBeat.o(155997);
    return false;
  }
  
  public static String GK(String paramString)
  {
    AppMethodBeat.i(155999);
    int i = paramString.lastIndexOf(";?enc=");
    if (i > 0)
    {
      paramString = paramString.substring(0, i);
      AppMethodBeat.o(155999);
      return paramString;
    }
    AppMethodBeat.o(155999);
    return paramString;
  }
  
  public static long GL(String paramString)
  {
    AppMethodBeat.i(156000);
    int i = paramString.lastIndexOf(";?enc=");
    if (i > 0)
    {
      long l = bu.aSC(paramString.substring(i + 6));
      AppMethodBeat.o(156000);
      return l;
    }
    AppMethodBeat.o(156000);
    return 0L;
  }
  
  public static String H(String paramString, long paramLong)
  {
    AppMethodBeat.i(155998);
    if (paramLong == 0L)
    {
      paramString = String.format(paramString + ";?enc=%d", new Object[] { Long.valueOf(314159265L) });
      AppMethodBeat.o(155998);
      return paramString;
    }
    paramString = String.format(paramString + ";?enc=%d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(155998);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsfs.e
 * JD-Core Version:    0.7.0.1
 */