package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class j$c
{
  public Boolean ahhE;
  
  static c dh(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(229249);
    c localc = new c();
    localc.ahhE = ((Boolean)paramMap.get("value"));
    AppMethodBeat.o(229249);
    return localc;
  }
  
  final Map<String, Object> jRw()
  {
    AppMethodBeat.i(229252);
    HashMap localHashMap = new HashMap();
    localHashMap.put("value", this.ahhE);
    AppMethodBeat.o(229252);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.c.j.c
 * JD-Core Version:    0.7.0.1
 */