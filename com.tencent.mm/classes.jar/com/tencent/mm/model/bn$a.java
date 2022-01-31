package com.tencent.mm.model;

import com.tencent.mm.sdk.platformtools.bk;

final class bn$a
{
  public static boolean aa(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1)) {}
    do
    {
      return true;
      paramString1 = decode(encode(paramString1));
    } while ((bk.bl(paramString1)) || (!paramString1.equals(paramString2)));
    return false;
  }
  
  private static String decode(String paramString)
  {
    String str1 = "";
    String str2;
    if ((bk.bl(paramString)) || (paramString.length() % 2 != 0)) {
      str2 = "";
    }
    for (;;)
    {
      return str2;
      int i = 0;
      str2 = str1;
      try
      {
        if (i < paramString.length())
        {
          str1 = str1 + (char)Integer.parseInt(paramString.substring(i, i + 2), 16);
          i += 2;
        }
      }
      catch (Exception paramString) {}
    }
    return "";
  }
  
  private static String encode(String paramString)
  {
    int i = 0;
    char[] arrayOfChar = paramString.toCharArray();
    paramString = "";
    try
    {
      int j = arrayOfChar.length;
      String str;
      for (;;)
      {
        str = paramString;
        if (i >= j) {
          break;
        }
        int k = arrayOfChar[i];
        paramString = paramString + String.format("%02x", new Object[] { Integer.valueOf(k) });
        i += 1;
      }
      return str;
    }
    catch (Exception paramString)
    {
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bn.a
 * JD-Core Version:    0.7.0.1
 */