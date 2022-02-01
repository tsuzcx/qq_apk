package com.tencent.mm.sdk.b;

import java.util.TimeZone;

public final class c
{
  private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
  private static final long[] q = { 300L, 200L, 300L, 200L };
  private static final char[] r = { 60, 62, 34, 39, 38 };
  private static final String[] s = { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;" };
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.c
 * JD-Core Version:    0.7.0.1
 */