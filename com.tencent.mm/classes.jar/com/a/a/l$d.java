package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class l$d
{
  private static final Map<String, Integer> aUa;
  
  static
  {
    AppMethodBeat.i(206658);
    HashMap localHashMap = new HashMap(13);
    aUa = localHashMap;
    localHashMap.put("normal", Integer.valueOf(400));
    aUa.put("bold", Integer.valueOf(700));
    aUa.put("bolder", Integer.valueOf(1));
    aUa.put("lighter", Integer.valueOf(-1));
    aUa.put("100", Integer.valueOf(100));
    aUa.put("200", Integer.valueOf(200));
    aUa.put("300", Integer.valueOf(300));
    aUa.put("400", Integer.valueOf(400));
    aUa.put("500", Integer.valueOf(500));
    aUa.put("600", Integer.valueOf(600));
    aUa.put("700", Integer.valueOf(700));
    aUa.put("800", Integer.valueOf(800));
    aUa.put("900", Integer.valueOf(900));
    AppMethodBeat.o(206658);
  }
  
  static Integer aK(String paramString)
  {
    AppMethodBeat.i(206657);
    paramString = (Integer)aUa.get(paramString);
    AppMethodBeat.o(206657);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.a.a.l.d
 * JD-Core Version:    0.7.0.1
 */