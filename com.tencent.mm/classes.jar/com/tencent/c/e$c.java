package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class e$c
{
  public Long ahhF;
  public String key;
  public String name;
  
  static c da(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(229171);
    c localc = new c();
    localc.name = ((String)paramMap.get("name"));
    localc.key = ((String)paramMap.get("key"));
    paramMap = paramMap.get("value");
    if (paramMap == null)
    {
      paramMap = null;
      localc.ahhF = paramMap;
      AppMethodBeat.o(229171);
      return localc;
    }
    if ((paramMap instanceof Integer)) {}
    for (long l = ((Integer)paramMap).intValue();; l = ((Long)paramMap).longValue())
    {
      paramMap = Long.valueOf(l);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.c.e.c
 * JD-Core Version:    0.7.0.1
 */