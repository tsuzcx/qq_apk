package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  public static String I(String paramString, long paramLong)
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
  
  public static boolean OS(String paramString)
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
  
  public static String OT(String paramString)
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
  
  public static long OU(String paramString)
  {
    AppMethodBeat.i(156000);
    int i = paramString.lastIndexOf(";?enc=");
    if (i > 0)
    {
      long l = Util.safeParseLong(paramString.substring(i + 6));
      AppMethodBeat.o(156000);
      return l;
    }
    AppMethodBeat.o(156000);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsfs.e
 * JD-Core Version:    0.7.0.1
 */