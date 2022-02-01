package com.tencent.mm.plugin.appbrand.q.a;

import com.tencent.luggage.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.plugin.appbrand.q;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  public final q cox;
  private final b.a lXJ;
  private final int lXK;
  
  public c(q paramq)
  {
    this.cox = paramq;
    this.lXK = -1;
    this.lXJ = null;
  }
  
  public c(q paramq, int paramInt, b.a parama)
  {
    this.lXJ = parama;
    this.cox = paramq;
    this.lXK = paramInt;
  }
  
  private static String P(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147385);
    d.d(paramMap);
    paramMap = new i(paramMap).toString();
    AppMethodBeat.o(147385);
    return paramMap;
  }
  
  private String SV(String paramString)
  {
    AppMethodBeat.i(147384);
    if (this.lXJ == null)
    {
      AppMethodBeat.o(147384);
      return paramString;
    }
    this.lXJ.an(this.lXK, paramString);
    AppMethodBeat.o(147384);
    return null;
  }
  
  public final String O(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147382);
    paramMap.put("ret", Integer.valueOf(0));
    paramMap = SV(P(paramMap));
    AppMethodBeat.o(147382);
    return paramMap;
  }
  
  public final String btC()
  {
    AppMethodBeat.i(147383);
    Object localObject = new HashMap();
    ((Map)localObject).put("ret", Integer.valueOf(2));
    localObject = SV(P((Map)localObject));
    AppMethodBeat.o(147383);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.a.c
 * JD-Core Version:    0.7.0.1
 */