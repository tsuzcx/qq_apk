package com.tencent.matrix;

import com.tencent.c.a.a;
import com.tencent.c.a.a.a;
import com.tencent.mm.plugin.expt.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;

public final class f
  implements a
{
  private final ax ctt = ax.eGf();
  
  public final float cS(String paramString)
  {
    paramString = get(paramString, "");
    if (bt.isNullOrNil(paramString)) {
      return 0.9F;
    }
    return bt.getFloat(paramString, 0.9F);
  }
  
  public final int get(String paramString, int paramInt)
  {
    int i;
    if (paramString.equals(a.a.Iha.name()))
    {
      i = this.ctt.getInt(a.a.Iha.name(), -1);
      if (i != -1) {
        ad.i("MicroMsg.XDynamicConfig", "[get] local! key=%s value=%s", new Object[] { paramString, Integer.valueOf(i) });
      }
    }
    do
    {
      return i;
      paramString = get(paramString, "");
      i = paramInt;
    } while (bt.isNullOrNil(paramString));
    return bt.getInt(paramString, paramInt);
  }
  
  public final long get(String paramString, long paramLong)
  {
    paramString = get(paramString, "");
    if (bt.isNullOrNil(paramString)) {
      return paramLong;
    }
    return bt.getLong(paramString, paramLong);
  }
  
  public final String get(String paramString1, String paramString2)
  {
    return b.ceD().b(paramString1, paramString2, false, false);
  }
  
  public final boolean get(String paramString, boolean paramBoolean)
  {
    paramString = get(paramString, "");
    if (bt.isNullOrNil(paramString)) {
      return paramBoolean;
    }
    if (paramBoolean) {}
    for (int i = 1; bt.getInt(paramString, i) != 0; i = 0) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.f
 * JD-Core Version:    0.7.0.1
 */