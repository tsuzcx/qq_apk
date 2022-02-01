package com.tencent.matrix;

import com.tencent.c.a.a;
import com.tencent.c.a.a.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;

public final class f
  implements a
{
  private final ay cCf = ay.fpc();
  
  public final float dN(String paramString)
  {
    paramString = get(paramString, "");
    if (bu.isNullOrNil(paramString)) {
      return 0.9F;
    }
    return bu.getFloat(paramString, 0.9F);
  }
  
  public final int get(String paramString, int paramInt)
  {
    int i;
    if (paramString.equals(a.a.LZv.name()))
    {
      i = this.cCf.getInt(a.a.LZv.name(), -1);
      if (i != -1) {
        ae.i("MicroMsg.XDynamicConfig", "[get] local! key=%s value=%s", new Object[] { paramString, Integer.valueOf(i) });
      }
    }
    do
    {
      return i;
      paramString = get(paramString, "");
      i = paramInt;
    } while (bu.isNullOrNil(paramString));
    return bu.getInt(paramString, paramInt);
  }
  
  public final long get(String paramString, long paramLong)
  {
    paramString = get(paramString, "");
    if (bu.isNullOrNil(paramString)) {
      return paramLong;
    }
    return bu.getLong(paramString, paramLong);
  }
  
  public final String get(String paramString1, String paramString2)
  {
    return d.ctr().b(paramString1, paramString2, false, false);
  }
  
  public final boolean get(String paramString, boolean paramBoolean)
  {
    paramString = get(paramString, "");
    if (bu.isNullOrNil(paramString)) {
      return paramBoolean;
    }
    if (paramBoolean) {}
    for (int i = 1; bu.getInt(paramString, i) != 0; i = 0) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.f
 * JD-Core Version:    0.7.0.1
 */