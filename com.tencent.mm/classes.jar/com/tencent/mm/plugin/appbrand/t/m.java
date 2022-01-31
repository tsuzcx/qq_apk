package com.tencent.mm.plugin.appbrand.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class m
{
  private static String[][] iXN = { { "\\", "\\\\" }, { "'", "\\'" }, { "\"", "\\\"" }, { "\n", "\\n" }, { "\t", "\\t" }, { "\b", "\\b" }, { "\f", "\\f" }, { "\r", "\\r" } };
  
  public static String Fr(String paramString)
  {
    AppMethodBeat.i(87424);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(87424);
      return paramString;
    }
    String[][] arrayOfString = iXN;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString1 = arrayOfString[i];
      paramString = paramString.replace(arrayOfString1[0], arrayOfString1[1]);
      i += 1;
    }
    AppMethodBeat.o(87424);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.m
 * JD-Core Version:    0.7.0.1
 */