package com.tencent.mm.plugin.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.api.a;
import com.tencent.mm.plugin.mmsight.api.a.b;
import com.tencent.mm.plugin.mmsight.model.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements a.b
{
  public final a a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(89184);
    if (paramInt1 == 1)
    {
      paramString1 = new b(paramString1, paramString2, paramInt2, paramInt3, paramInt4, paramInt5);
      AppMethodBeat.o(89184);
      return paramString1;
    }
    if (paramInt1 == 2)
    {
      paramString1 = new com.tencent.mm.plugin.mmsight.model.b.c(paramString1, paramString2, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
      AppMethodBeat.o(89184);
      return paramString1;
    }
    AppMethodBeat.o(89184);
    return null;
  }
  
  public final a a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(89185);
    if (paramInt1 == 1)
    {
      paramString1 = new b(paramString1, paramString2, paramInt2, paramInt3, paramInt4, paramInt5, paramLong1, paramLong2);
      AppMethodBeat.o(89185);
      return paramString1;
    }
    if (paramInt1 == 2)
    {
      paramString1 = new com.tencent.mm.plugin.mmsight.model.b.c(paramString1, paramString2, paramInt2, paramInt3, paramInt4, paramInt5, paramLong1, paramLong2, paramInt6, paramInt7);
      AppMethodBeat.o(89185);
      return paramString1;
    }
    AppMethodBeat.o(89185);
    return null;
  }
  
  public final a a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(89182);
    int i = af.lYf.lWH;
    Log.i("MicroMsg.MMSightPresendRemuxerImpl", "get, configRemuxerType: %s", new Object[] { Integer.valueOf(i) });
    if (i != -1)
    {
      if (i == 1)
      {
        paramString1 = new b(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4);
        AppMethodBeat.o(89182);
        return paramString1;
      }
      if (i == 2)
      {
        paramString1 = new com.tencent.mm.plugin.mmsight.model.b.c(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
        AppMethodBeat.o(89182);
        return paramString1;
      }
    }
    if (d.rb(19))
    {
      paramString1 = new b(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(89182);
      return paramString1;
    }
    paramString1 = new com.tencent.mm.plugin.mmsight.model.b.c(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.o(89182);
    return paramString1;
  }
  
  public final a a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(89183);
    int i = af.lYf.lWH;
    Log.i("MicroMsg.MMSightPresendRemuxerImpl", "get, configRemuxerType: %s", new Object[] { Integer.valueOf(i) });
    if (i != -1)
    {
      if (i == 1)
      {
        paramString1 = new b(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2);
        AppMethodBeat.o(89183);
        return paramString1;
      }
      if (i == 2)
      {
        paramString1 = new com.tencent.mm.plugin.mmsight.model.b.c(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2, paramInt5, paramInt6);
        AppMethodBeat.o(89183);
        return paramString1;
      }
    }
    if (d.rb(19))
    {
      paramString1 = new b(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2);
      AppMethodBeat.o(89183);
      return paramString1;
    }
    paramString1 = new com.tencent.mm.plugin.mmsight.model.b.c(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2, paramInt5, paramInt6);
    AppMethodBeat.o(89183);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.api.c
 * JD-Core Version:    0.7.0.1
 */