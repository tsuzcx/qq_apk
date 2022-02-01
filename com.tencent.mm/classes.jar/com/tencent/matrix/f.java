package com.tencent.matrix;

import com.tencent.c.a.a;
import com.tencent.c.a.a.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
  implements a
{
  private final MultiProcessMMKV cQe = MultiProcessMMKV.getMultiDefault();
  
  public final float ei(String paramString)
  {
    paramString = get(paramString, "");
    if (Util.isNullOrNil(paramString)) {
      return 0.9F;
    }
    return Util.getFloat(paramString, 0.9F);
  }
  
  public final int get(String paramString, int paramInt)
  {
    int i;
    if (paramString.equals(a.a.RzN.name()))
    {
      i = this.cQe.getInt(a.a.RzN.name(), -1);
      if (i != -1) {
        Log.i("MicroMsg.XDynamicConfig", "[get] local! key=%s value=%s", new Object[] { paramString, Integer.valueOf(i) });
      }
    }
    do
    {
      return i;
      paramString = get(paramString, "");
      i = paramInt;
    } while (Util.isNullOrNil(paramString));
    return Util.getInt(paramString, paramInt);
  }
  
  public final long get(String paramString, long paramLong)
  {
    paramString = get(paramString, "");
    if (Util.isNullOrNil(paramString)) {
      return paramLong;
    }
    return Util.getLong(paramString, paramLong);
  }
  
  public final String get(String paramString1, String paramString2)
  {
    return d.cRY().b(paramString1, paramString2, false, false);
  }
  
  public final boolean get(String paramString, boolean paramBoolean)
  {
    paramString = get(paramString, "");
    if (Util.isNullOrNil(paramString)) {
      return paramBoolean;
    }
    if (paramBoolean) {}
    for (int i = 1; Util.getInt(paramString, i) != 0; i = 0) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.f
 * JD-Core Version:    0.7.0.1
 */