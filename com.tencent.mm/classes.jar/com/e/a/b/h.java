package com.e.a.b;

import com.e.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class h
{
  public static Map<String, Object> a(f paramf)
  {
    AppMethodBeat.i(153416);
    paramf = paramf.Az();
    HashMap localHashMap = new HashMap();
    localHashMap.put("sql", paramf.sql);
    localHashMap.put("arguments", paramf.bYL);
    AppMethodBeat.o(153416);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.e.a.b.h
 * JD-Core Version:    0.7.0.1
 */