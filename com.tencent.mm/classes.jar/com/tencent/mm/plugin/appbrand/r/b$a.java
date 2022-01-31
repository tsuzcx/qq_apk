package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$a
{
  public static String l(String[] paramArrayOfString)
  {
    AppMethodBeat.i(57065);
    String str1 = " PRIMARY KEY ( ";
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str2 = paramArrayOfString[i];
      str1 = str1 + ", " + str2;
      i += 1;
    }
    paramArrayOfString = str1.replaceFirst(",", "");
    paramArrayOfString = paramArrayOfString + " )";
    paramArrayOfString = "" + "," + paramArrayOfString;
    AppMethodBeat.o(57065);
    return paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.b.a
 * JD-Core Version:    0.7.0.1
 */