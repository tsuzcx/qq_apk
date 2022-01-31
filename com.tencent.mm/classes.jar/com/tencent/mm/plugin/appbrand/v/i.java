package com.tencent.mm.plugin.appbrand.v;

import com.tencent.mm.sdk.platformtools.bk;

public final class i
{
  private static String[][] hls = { { "\\", "\\\\" }, { "'", "\\'" }, { "\"", "\\\"" }, { "\n", "\\n" }, { "\t", "\\t" }, { "\b", "\\b" }, { "\f", "\\f" }, { "\r", "\\r" } };
  
  public static String wI(String paramString)
  {
    String str;
    if (bk.bl(paramString))
    {
      str = paramString;
      return str;
    }
    String[][] arrayOfString = hls;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      str = paramString;
      if (i >= j) {
        break;
      }
      str = arrayOfString[i];
      paramString = paramString.replace(str[0], str[1]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.i
 * JD-Core Version:    0.7.0.1
 */