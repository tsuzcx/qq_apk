package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
{
  public static boolean A(String paramString1, String paramString2)
  {
    AppMethodBeat.i(140860);
    if ((paramString1 == null) || (paramString1.length() < 0) || (paramString2.length() < 0))
    {
      AppMethodBeat.o(140860);
      return false;
    }
    if (paramString2.length() > paramString1.length())
    {
      AppMethodBeat.o(140860);
      return false;
    }
    if (paramString2.equalsIgnoreCase(paramString1.substring(0, paramString2.length())))
    {
      AppMethodBeat.o(140860);
      return true;
    }
    AppMethodBeat.o(140860);
    return false;
  }
  
  public static String Nm(String paramString)
  {
    AppMethodBeat.i(140859);
    if (paramString == null)
    {
      AppMethodBeat.o(140859);
      return null;
    }
    paramString = paramString.replace(" ", "\\n").replace(" ", "\\n");
    AppMethodBeat.o(140859);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.w
 * JD-Core Version:    0.7.0.1
 */