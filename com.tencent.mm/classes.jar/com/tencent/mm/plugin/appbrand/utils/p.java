package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public final class p
{
  private static String[][] moo = { { "\\", "\\\\" }, { "'", "\\'" }, { "\"", "\\\"" }, { "\n", "\\n" }, { "\t", "\\t" }, { "\b", "\\b" }, { "\f", "\\f" }, { "\r", "\\r" } };
  
  public static String Rw(String paramString)
  {
    AppMethodBeat.i(135365);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(135365);
      return paramString;
    }
    String[][] arrayOfString = moo;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString1 = arrayOfString[i];
      paramString = paramString.replace(arrayOfString1[0], arrayOfString1[1]);
      i += 1;
    }
    AppMethodBeat.o(135365);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.p
 * JD-Core Version:    0.7.0.1
 */