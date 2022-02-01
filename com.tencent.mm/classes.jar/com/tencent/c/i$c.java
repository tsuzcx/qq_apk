package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class i$c
{
  public Boolean ahhE;
  
  static c de(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(229180);
    c localc = new c();
    localc.ahhE = ((Boolean)paramMap.get("value"));
    AppMethodBeat.o(229180);
    return localc;
  }
  
  final Map<String, Object> jRw()
  {
    AppMethodBeat.i(229184);
    HashMap localHashMap = new HashMap();
    localHashMap.put("value", this.ahhE);
    AppMethodBeat.o(229184);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.c.i.c
 * JD-Core Version:    0.7.0.1
 */