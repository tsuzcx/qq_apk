package com.tencent.mm.plugin.appbrand.z;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface b
{
  public abstract String[] getKeys();
  
  public static final class a
  {
    public static String r(String[] paramArrayOfString)
    {
      AppMethodBeat.i(146130);
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
      AppMethodBeat.o(146130);
      return paramArrayOfString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z.b
 * JD-Core Version:    0.7.0.1
 */