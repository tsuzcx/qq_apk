package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class p
{
  public static String t(String paramString, long paramLong)
  {
    AppMethodBeat.i(59722);
    String str = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(paramLong));
    if ((paramString != null) && (paramString.length() > 1)) {}
    for (paramString = str + g.w(paramString.getBytes()).substring(0, 7);; paramString = str + "fffffff")
    {
      paramString = paramString + String.format("%04x", new Object[] { Long.valueOf(paramLong % 65535L) });
      paramString = paramString + (paramLong % 7L + 100L);
      AppMethodBeat.o(59722);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.p
 * JD-Core Version:    0.7.0.1
 */