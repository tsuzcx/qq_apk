package com.tencent.mm.plugin.appbrand.q.a;

import com.tencent.luggage.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.r;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  public final r coz;
  private final b.a mcq;
  private final int mcr;
  
  public c(r paramr)
  {
    this.coz = paramr;
    this.mcr = -1;
    this.mcq = null;
  }
  
  public c(r paramr, int paramInt, b.a parama)
  {
    this.mcq = parama;
    this.coz = paramr;
    this.mcr = paramInt;
  }
  
  private String TE(String paramString)
  {
    AppMethodBeat.i(147384);
    if (this.mcq == null)
    {
      AppMethodBeat.o(147384);
      return paramString;
    }
    this.mcq.an(this.mcr, paramString);
    AppMethodBeat.o(147384);
    return null;
  }
  
  private static String W(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147385);
    d.k(paramMap);
    paramMap = new i(paramMap).toString();
    AppMethodBeat.o(147385);
    return paramMap;
  }
  
  public final String V(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147382);
    paramMap.put("ret", Integer.valueOf(0));
    paramMap = TE(W(paramMap));
    AppMethodBeat.o(147382);
    return paramMap;
  }
  
  public final String bun()
  {
    AppMethodBeat.i(147383);
    Object localObject = new HashMap();
    ((Map)localObject).put("ret", Integer.valueOf(2));
    localObject = TE(W((Map)localObject));
    AppMethodBeat.o(147383);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.a.c
 * JD-Core Version:    0.7.0.1
 */