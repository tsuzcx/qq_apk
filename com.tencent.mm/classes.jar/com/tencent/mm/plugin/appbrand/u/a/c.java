package com.tencent.mm.plugin.appbrand.u.a;

import com.tencent.luggage.k.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.v;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  public final v czP;
  private final int qlA;
  private final b.a qlz;
  
  public c(v paramv)
  {
    this.czP = paramv;
    this.qlA = -1;
    this.qlz = null;
  }
  
  public c(v paramv, int paramInt, b.a parama)
  {
    this.qlz = parama;
    this.czP = paramv;
    this.qlA = paramInt;
  }
  
  private static String S(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147385);
    e.e(paramMap);
    paramMap = new i(paramMap).toString();
    AppMethodBeat.o(147385);
    return paramMap;
  }
  
  private String alf(String paramString)
  {
    AppMethodBeat.i(147384);
    if (this.qlz == null)
    {
      AppMethodBeat.o(147384);
      return paramString;
    }
    this.qlz.ar(this.qlA, paramString);
    AppMethodBeat.o(147384);
    return null;
  }
  
  public final String Ck(int paramInt)
  {
    AppMethodBeat.i(237300);
    Object localObject = new HashMap();
    ((Map)localObject).put("ret", Integer.valueOf(paramInt));
    localObject = alf(S((Map)localObject));
    AppMethodBeat.o(237300);
    return localObject;
  }
  
  public final String R(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147382);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("ret", Integer.valueOf(0));
    paramMap = alf(S((Map)localObject));
    AppMethodBeat.o(147382);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.a.c
 * JD-Core Version:    0.7.0.1
 */