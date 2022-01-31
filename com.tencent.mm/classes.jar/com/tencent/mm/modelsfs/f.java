package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class f
{
  public static boolean ue(String paramString)
  {
    AppMethodBeat.i(93200);
    if (paramString.lastIndexOf(";?enc=") > 0)
    {
      AppMethodBeat.o(93200);
      return true;
    }
    AppMethodBeat.o(93200);
    return false;
  }
  
  public static String uf(String paramString)
  {
    AppMethodBeat.i(93202);
    int i = paramString.lastIndexOf(";?enc=");
    if (i > 0)
    {
      paramString = paramString.substring(0, i);
      AppMethodBeat.o(93202);
      return paramString;
    }
    AppMethodBeat.o(93202);
    return paramString;
  }
  
  public static long ug(String paramString)
  {
    AppMethodBeat.i(93203);
    int i = paramString.lastIndexOf(";?enc=");
    if (i > 0)
    {
      long l = bo.apW(paramString.substring(i + 6));
      AppMethodBeat.o(93203);
      return l;
    }
    AppMethodBeat.o(93203);
    return 0L;
  }
  
  public static String uh(String paramString)
  {
    AppMethodBeat.i(93204);
    int i = paramString.lastIndexOf(";?enc=");
    if (i > 0)
    {
      paramString = paramString.substring(i + 6).trim();
      AppMethodBeat.o(93204);
      return paramString;
    }
    AppMethodBeat.o(93204);
    return "";
  }
  
  public static String z(String paramString, long paramLong)
  {
    AppMethodBeat.i(93201);
    if (paramLong == 0L)
    {
      paramString = String.format(paramString + ";?enc=%d", new Object[] { Long.valueOf(314159265L) });
      AppMethodBeat.o(93201);
      return paramString;
    }
    paramString = String.format(paramString + ";?enc=%d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(93201);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsfs.f
 * JD-Core Version:    0.7.0.1
 */