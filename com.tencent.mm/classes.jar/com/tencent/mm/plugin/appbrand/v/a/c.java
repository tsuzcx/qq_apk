package com.tencent.mm.plugin.appbrand.v.a;

import com.tencent.luggage.l.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.y;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  public final y esk;
  private final b.a tqx;
  private final int tqy;
  
  public c(y paramy)
  {
    this.esk = paramy;
    this.tqy = -1;
    this.tqx = null;
  }
  
  public c(y paramy, int paramInt, b.a parama)
  {
    this.tqx = parama;
    this.esk = paramy;
    this.tqy = paramInt;
  }
  
  private static String Z(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147385);
    d.k(paramMap);
    paramMap = new i(paramMap).toString();
    AppMethodBeat.o(147385);
    return paramMap;
  }
  
  private String aem(String paramString)
  {
    AppMethodBeat.i(147384);
    if (this.tqx == null)
    {
      AppMethodBeat.o(147384);
      return paramString;
    }
    this.tqx.aC(this.tqy, paramString);
    AppMethodBeat.o(147384);
    return null;
  }
  
  public final String Cz(int paramInt)
  {
    AppMethodBeat.i(321252);
    Object localObject = new HashMap();
    ((Map)localObject).put("ret", Integer.valueOf(paramInt));
    localObject = aem(Z((Map)localObject));
    AppMethodBeat.o(321252);
    return localObject;
  }
  
  public final String Y(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147382);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("ret", Integer.valueOf(0));
    paramMap = aem(Z((Map)localObject));
    AppMethodBeat.o(147382);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.a.c
 * JD-Core Version:    0.7.0.1
 */