package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public final class r
{
  private static String[][] mTV;
  
  static
  {
    String[] arrayOfString1 = { "\"", "\\\"" };
    String[] arrayOfString2 = { "\b", "\\b" };
    String[] arrayOfString3 = { "\r", "\\r" };
    String[] arrayOfString4 = { " ", "\\u2029" };
    mTV = new String[][] { { "\\", "\\\\" }, { "'", "\\'" }, arrayOfString1, { "\n", "\\n" }, { "\t", "\\t" }, arrayOfString2, { "\f", "\\f" }, arrayOfString3, { " ", "\\u2028" }, arrayOfString4 };
  }
  
  public static String VN(String paramString)
  {
    AppMethodBeat.i(135365);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(135365);
      return paramString;
    }
    String[][] arrayOfString = mTV;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.r
 * JD-Core Version:    0.7.0.1
 */