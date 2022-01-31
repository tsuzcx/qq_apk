package com.tencent.mm.model;

import com.tencent.mm.a.g;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class o
{
  public static String l(String paramString, long paramLong)
  {
    String str = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(paramLong));
    if ((paramString != null) && (paramString.length() > 1)) {}
    for (paramString = str + g.o(paramString.getBytes()).substring(0, 7);; paramString = str + "fffffff")
    {
      paramString = paramString + String.format("%04x", new Object[] { Long.valueOf(paramLong % 65535L) });
      return paramString + (paramLong % 7L + 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.o
 * JD-Core Version:    0.7.0.1
 */