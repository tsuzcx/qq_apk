package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class cb$a
{
  public static boolean be(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42980);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(42980);
      return true;
    }
    paramString1 = ch(cg(paramString1));
    if ((Util.isNullOrNil(paramString1)) || (!paramString1.equals(paramString2)))
    {
      AppMethodBeat.o(42980);
      return true;
    }
    AppMethodBeat.o(42980);
    return false;
  }
  
  private static String cg(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(42981);
    char[] arrayOfChar = paramString.toCharArray();
    paramString = "";
    try
    {
      int j = arrayOfChar.length;
      while (i < j)
      {
        int k = arrayOfChar[i];
        paramString = paramString + String.format("%02x", new Object[] { Integer.valueOf(k) });
        i += 1;
      }
      AppMethodBeat.o(42981);
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(42981);
      return "";
    }
    return paramString;
  }
  
  private static String ch(String paramString)
  {
    AppMethodBeat.i(42982);
    String str = "";
    if ((Util.isNullOrNil(paramString)) || (paramString.length() % 2 != 0))
    {
      AppMethodBeat.o(42982);
      return "";
    }
    int i = 0;
    try
    {
      while (i < paramString.length())
      {
        str = str + (char)Integer.parseInt(paramString.substring(i, i + 2), 16);
        i += 2;
      }
      AppMethodBeat.o(42982);
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(42982);
      return "";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.cb.a
 * JD-Core Version:    0.7.0.1
 */