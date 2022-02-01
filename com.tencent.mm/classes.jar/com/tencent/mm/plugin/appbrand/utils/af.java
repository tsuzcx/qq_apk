package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class af
{
  public static String agE(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.af
 * JD-Core Version:    0.7.0.1
 */