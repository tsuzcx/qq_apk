package com.tencent.mm.plugin.appbrand.r.a;

import com.tencent.luggage.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.plugin.appbrand.q;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  public final q chm;
  private final b.a kWB;
  private final int kWC;
  
  public c(q paramq)
  {
    this.chm = paramq;
    this.kWC = -1;
    this.kWB = null;
  }
  
  public c(q paramq, int paramInt, b.a parama)
  {
    this.kWB = parama;
    this.chm = paramq;
    this.kWC = paramInt;
  }
  
  private String Lk(String paramString)
  {
    AppMethodBeat.i(147384);
    if (this.kWB == null)
    {
      AppMethodBeat.o(147384);
      return paramString;
    }
    this.kWB.ak(this.kWC, paramString);
    AppMethodBeat.o(147384);
    return null;
  }
  
  private static String P(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147385);
    d.e(paramMap);
    paramMap = new i(paramMap).toString();
    AppMethodBeat.o(147385);
    return paramMap;
  }
  
  public final String O(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147382);
    paramMap.put("ret", Integer.valueOf(0));
    paramMap = Lk(P(paramMap));
    AppMethodBeat.o(147382);
    return paramMap;
  }
  
  public final String biI()
  {
    AppMethodBeat.i(147383);
    Object localObject = new HashMap();
    ((Map)localObject).put("ret", Integer.valueOf(2));
    localObject = Lk(P((Map)localObject));
    AppMethodBeat.o(147383);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.c
 * JD-Core Version:    0.7.0.1
 */