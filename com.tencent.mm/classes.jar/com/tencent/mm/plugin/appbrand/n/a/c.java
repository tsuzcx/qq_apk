package com.tencent.mm.plugin.appbrand.n.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  public final r bEw;
  private final b.a iug;
  private final int iuh;
  
  public c(r paramr)
  {
    this.bEw = paramr;
    this.iuh = -1;
    this.iug = null;
  }
  
  public c(r paramr, int paramInt, b.a parama)
  {
    this.iug = parama;
    this.bEw = paramr;
    this.iuh = paramInt;
  }
  
  private static String D(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(102188);
    com.tencent.luggage.g.i.d(paramMap);
    paramMap = new com.tencent.mm.aa.i(paramMap).toString();
    AppMethodBeat.o(102188);
    return paramMap;
  }
  
  private String Eb(String paramString)
  {
    AppMethodBeat.i(102187);
    if (this.iug == null)
    {
      AppMethodBeat.o(102187);
      return paramString;
    }
    this.iug.Y(this.iuh, paramString);
    AppMethodBeat.o(102187);
    return null;
  }
  
  public final String C(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(102185);
    paramMap.put("ret", Integer.valueOf(0));
    paramMap = Eb(D(paramMap));
    AppMethodBeat.o(102185);
    return paramMap;
  }
  
  public final String aIB()
  {
    AppMethodBeat.i(102186);
    Object localObject = new HashMap();
    ((Map)localObject).put("ret", Integer.valueOf(2));
    localObject = Eb(D((Map)localObject));
    AppMethodBeat.o(102186);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.a.c
 * JD-Core Version:    0.7.0.1
 */