package com.tencent.mm.plugin.appbrand.v;

public final class o
{
  public static boolean n(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() < 0) || (paramString2.length() < 0)) {}
    while ((paramString2.length() > paramString1.length()) || (!paramString2.equalsIgnoreCase(paramString1.substring(0, paramString2.length())))) {
      return false;
    }
    return true;
  }
  
  public static String wH(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.replace(' ', '\n').replace(' ', '\n');
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.o
 * JD-Core Version:    0.7.0.1
 */