package com.tencent.mm.plugin.api;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.api.a.a;
import com.tencent.mm.plugin.mmsight.model.b.b;
import com.tencent.mm.plugin.mmsight.model.b.c;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  implements a.a
{
  public final com.tencent.mm.plugin.mmsight.api.a a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt1 == 1) {
      return new b(paramString1, paramString2, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    if (paramInt1 == 2) {
      return new c(paramString1, paramString2, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    return null;
  }
  
  public final com.tencent.mm.plugin.mmsight.api.a a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2)
  {
    if (paramInt1 == 1) {
      return new b(paramString1, paramString2, paramInt2, paramInt3, paramInt4, paramInt5, paramLong1, paramLong2);
    }
    if (paramInt1 == 2) {
      return new c(paramString1, paramString2, paramInt2, paramInt3, paramInt4, paramInt5, paramLong1, paramLong2);
    }
    return null;
  }
  
  public final com.tencent.mm.plugin.mmsight.api.a a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    int i = q.dyk.dyB;
    y.i("MicroMsg.MMSightPresendRemuxerImpl", "get, configRemuxerType: %s", new Object[] { Integer.valueOf(i) });
    if (i != -1)
    {
      if (i == 1) {
        return new b(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2);
      }
      if (i == 2) {
        return new c(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2);
      }
    }
    if (d.gF(19)) {
      return new b(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2);
    }
    return new c(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2);
  }
  
  public final com.tencent.mm.plugin.mmsight.api.a b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = q.dyk.dyB;
    y.i("MicroMsg.MMSightPresendRemuxerImpl", "get, configRemuxerType: %s", new Object[] { Integer.valueOf(i) });
    if (i != -1)
    {
      if (i == 1) {
        return new b(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      if (i == 2) {
        return new c(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    if (d.gF(19)) {
      return new b(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    return new c(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.api.a
 * JD-Core Version:    0.7.0.1
 */