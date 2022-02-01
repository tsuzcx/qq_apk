package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class s
{
  public static String w(String paramString, long paramLong)
  {
    AppMethodBeat.i(42772);
    String str = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(paramLong));
    if ((paramString != null) && (paramString.length() > 1)) {}
    for (paramString = str + g.getMessageDigest(paramString.getBytes()).substring(0, 7);; paramString = str + "fffffff")
    {
      paramString = paramString + String.format("%04x", new Object[] { Long.valueOf(paramLong % 65535L) });
      paramString = paramString + (paramLong % 7L + 100L);
      AppMethodBeat.o(42772);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.s
 * JD-Core Version:    0.7.0.1
 */