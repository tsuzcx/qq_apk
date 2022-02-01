package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class j$g
{
  public String value;
  
  static g dj(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(229260);
    g localg = new g();
    localg.value = ((String)paramMap.get("value"));
    AppMethodBeat.o(229260);
    return localg;
  }
  
  final Map<String, Object> jRw()
  {
    AppMethodBeat.i(229264);
    HashMap localHashMap = new HashMap();
    localHashMap.put("value", this.value);
    AppMethodBeat.o(229264);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.c.j.g
 * JD-Core Version:    0.7.0.1
 */