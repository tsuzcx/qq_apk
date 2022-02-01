package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class y
{
  private static String[][] uqV;
  
  static
  {
    String[] arrayOfString1 = { "\"", "\\\"" };
    String[] arrayOfString2 = { "\n", "\\n" };
    String[] arrayOfString3 = { "\t", "\\t" };
    String[] arrayOfString4 = { "\f", "\\f" };
    String[] arrayOfString5 = { "\r", "\\r" };
    String[] arrayOfString6 = { " ", "\\u2029" };
    uqV = new String[][] { { "\\", "\\\\" }, { "'", "\\'" }, arrayOfString1, arrayOfString2, arrayOfString3, { "\b", "\\b" }, arrayOfString4, arrayOfString5, { " ", "\\u2028" }, arrayOfString6 };
  }
  
  public static String agF(String paramString)
  {
    AppMethodBeat.i(135365);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(135365);
      return paramString;
    }
    String[][] arrayOfString = uqV;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.y
 * JD-Core Version:    0.7.0.1
 */