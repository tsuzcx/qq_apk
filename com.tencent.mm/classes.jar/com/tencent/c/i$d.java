package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class i$d
{
  public Long ahhF;
  
  static d df(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(229145);
    d locald = new d();
    paramMap = paramMap.get("value");
    if (paramMap == null)
    {
      paramMap = null;
      locald.ahhF = paramMap;
      AppMethodBeat.o(229145);
      return locald;
    }
    if ((paramMap instanceof Integer)) {}
    for (long l = ((Integer)paramMap).intValue();; l = ((Long)paramMap).longValue())
    {
      paramMap = Long.valueOf(l);
      break;
    }
  }
  
  final Map<String, Object> jRw()
  {
    AppMethodBeat.i(229148);
    HashMap localHashMap = new HashMap();
    localHashMap.put("value", this.ahhF);
    AppMethodBeat.o(229148);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.c.i.d
 * JD-Core Version:    0.7.0.1
 */