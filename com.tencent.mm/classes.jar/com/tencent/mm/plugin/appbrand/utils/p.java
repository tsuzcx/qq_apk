package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class p
{
  private static String[][] mOQ;
  
  static
  {
    String[] arrayOfString1 = { "\\", "\\\\" };
    String[] arrayOfString2 = { "'", "\\'" };
    String[] arrayOfString3 = { "\"", "\\\"" };
    String[] arrayOfString4 = { "\n", "\\n" };
    String[] arrayOfString5 = { "\b", "\\b" };
    String[] arrayOfString6 = { "\r", "\\r" };
    String[] arrayOfString7 = { " ", "\\u2028" };
    String[] arrayOfString8 = { " ", "\\u2029" };
    mOQ = new String[][] { arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4, { "\t", "\\t" }, arrayOfString5, { "\f", "\\f" }, arrayOfString6, arrayOfString7, arrayOfString8 };
  }
  
  public static String Vc(String paramString)
  {
    AppMethodBeat.i(135365);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(135365);
      return paramString;
    }
    String[][] arrayOfString = mOQ;
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