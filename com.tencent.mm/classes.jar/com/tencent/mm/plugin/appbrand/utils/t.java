package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class t
{
  private static String[][] riJ;
  
  static
  {
    String[] arrayOfString1 = { "\\", "\\\\" };
    String[] arrayOfString2 = { "'", "\\'" };
    String[] arrayOfString3 = { "\n", "\\n" };
    String[] arrayOfString4 = { "\t", "\\t" };
    String[] arrayOfString5 = { "\b", "\\b" };
    String[] arrayOfString6 = { "\f", "\\f" };
    String[] arrayOfString7 = { "\r", "\\r" };
    String[] arrayOfString8 = { " ", "\\u2028" };
    String[] arrayOfString9 = { " ", "\\u2029" };
    riJ = new String[][] { arrayOfString1, arrayOfString2, { "\"", "\\\"" }, arrayOfString3, arrayOfString4, arrayOfString5, arrayOfString6, arrayOfString7, arrayOfString8, arrayOfString9 };
  }
  
  public static String anl(String paramString)
  {
    AppMethodBeat.i(135365);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(135365);
      return paramString;
    }
    String[][] arrayOfString = riJ;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.t
 * JD-Core Version:    0.7.0.1
 */