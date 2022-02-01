package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class j$e
{
  public Long ahhF;
  
  static e di(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(229246);
    e locale = new e();
    paramMap = paramMap.get("value");
    if (paramMap == null)
    {
      paramMap = null;
      locale.ahhF = paramMap;
      AppMethodBeat.o(229246);
      return locale;
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
    AppMethodBeat.i(229250);
    HashMap localHashMap = new HashMap();
    localHashMap.put("value", this.ahhF);
    AppMethodBeat.o(229250);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.c.j.e
 * JD-Core Version:    0.7.0.1
 */