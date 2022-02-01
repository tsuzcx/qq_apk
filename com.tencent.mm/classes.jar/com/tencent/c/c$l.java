package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class c$l
{
  public byte[] buffer;
  
  static l cY(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(229169);
    l locall = new l();
    locall.buffer = ((byte[])paramMap.get("buffer"));
    AppMethodBeat.o(229169);
    return locall;
  }
  
  final Map<String, Object> jRw()
  {
    AppMethodBeat.i(229172);
    HashMap localHashMap = new HashMap();
    localHashMap.put("buffer", this.buffer);
    AppMethodBeat.o(229172);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.c.c.l
 * JD-Core Version:    0.7.0.1
 */