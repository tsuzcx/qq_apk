package com.tencent.mm.plugin.appbrand.q.a;

import com.tencent.luggage.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.q;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  public final q ceh;
  private final b.a lyl;
  private final int lym;
  
  public c(q paramq)
  {
    this.ceh = paramq;
    this.lym = -1;
    this.lyl = null;
  }
  
  public c(q paramq, int paramInt, b.a parama)
  {
    this.lyl = parama;
    this.ceh = paramq;
    this.lym = paramInt;
  }
  
  private static String P(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147385);
    d.d(paramMap);
    paramMap = new i(paramMap).toString();
    AppMethodBeat.o(147385);
    return paramMap;
  }
  
  private String Ps(String paramString)
  {
    AppMethodBeat.i(147384);
    if (this.lyl == null)
    {
      AppMethodBeat.o(147384);
      return paramString;
    }
    this.lyl.al(this.lym, paramString);
    AppMethodBeat.o(147384);
    return null;
  }
  
  public final String O(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147382);
    paramMap.put("ret", Integer.valueOf(0));
    paramMap = Ps(P(paramMap));
    AppMethodBeat.o(147382);
    return paramMap;
  }
  
  public final String bpB()
  {
    AppMethodBeat.i(147383);
    Object localObject = new HashMap();
    ((Map)localObject).put("ret", Integer.valueOf(2));
    localObject = Ps(P((Map)localObject));
    AppMethodBeat.o(147383);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.a.c
 * JD-Core Version:    0.7.0.1
 */