package com.tencent.mm.plugin.appbrand.u.a;

import com.tencent.luggage.h.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.s;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  public final s cAJ;
  private final b.a nkb;
  private final int nkc;
  
  public c(s params)
  {
    this.cAJ = params;
    this.nkc = -1;
    this.nkb = null;
  }
  
  public c(s params, int paramInt, b.a parama)
  {
    this.nkb = parama;
    this.cAJ = params;
    this.nkc = paramInt;
  }
  
  private static String Z(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147385);
    e.m(paramMap);
    paramMap = new i(paramMap).toString();
    AppMethodBeat.o(147385);
    return paramMap;
  }
  
  private String adk(String paramString)
  {
    AppMethodBeat.i(147384);
    if (this.nkb == null)
    {
      AppMethodBeat.o(147384);
      return paramString;
    }
    this.nkb.ap(this.nkc, paramString);
    AppMethodBeat.o(147384);
    return null;
  }
  
  public final String Y(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147382);
    paramMap.put("ret", Integer.valueOf(0));
    paramMap = adk(Z(paramMap));
    AppMethodBeat.o(147382);
    return paramMap;
  }
  
  public final String bPU()
  {
    AppMethodBeat.i(147383);
    Object localObject = new HashMap();
    ((Map)localObject).put("ret", Integer.valueOf(2));
    localObject = adk(Z((Map)localObject));
    AppMethodBeat.o(147383);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.a.c
 * JD-Core Version:    0.7.0.1
 */