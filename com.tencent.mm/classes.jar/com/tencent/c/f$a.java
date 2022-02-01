package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class f$a
{
  public Long ahhF;
  
  static a dc(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(229077);
    a locala = new a();
    paramMap = paramMap.get("value");
    if (paramMap == null)
    {
      paramMap = null;
      locala.ahhF = paramMap;
      AppMethodBeat.o(229077);
      return locala;
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
    AppMethodBeat.i(229083);
    HashMap localHashMap = new HashMap();
    localHashMap.put("value", this.ahhF);
    AppMethodBeat.o(229083);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.c.f.a
 * JD-Core Version:    0.7.0.1
 */