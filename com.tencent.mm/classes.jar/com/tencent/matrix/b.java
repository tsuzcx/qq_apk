package com.tencent.matrix;

import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
{
  public static boolean gg(String paramString)
  {
    return Util.getInt(d.dNI().a(paramString, "0", false, true), 0) != 0;
  }
  
  public static long m(String paramString, long paramLong)
  {
    return Util.getLong(d.dNI().a(paramString, String.valueOf(paramLong), false, true), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.b
 * JD-Core Version:    0.7.0.1
 */