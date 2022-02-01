package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class l$d
{
  private static final Map<String, Integer> cyj;
  
  static
  {
    AppMethodBeat.i(207710);
    HashMap localHashMap = new HashMap(13);
    cyj = localHashMap;
    localHashMap.put("normal", Integer.valueOf(400));
    cyj.put("bold", Integer.valueOf(700));
    cyj.put("bolder", Integer.valueOf(1));
    cyj.put("lighter", Integer.valueOf(-1));
    cyj.put("100", Integer.valueOf(100));
    cyj.put("200", Integer.valueOf(200));
    cyj.put("300", Integer.valueOf(300));
    cyj.put("400", Integer.valueOf(400));
    cyj.put("500", Integer.valueOf(500));
    cyj.put("600", Integer.valueOf(600));
    cyj.put("700", Integer.valueOf(700));
    cyj.put("800", Integer.valueOf(800));
    cyj.put("900", Integer.valueOf(900));
    AppMethodBeat.o(207710);
  }
  
  static Integer bY(String paramString)
  {
    AppMethodBeat.i(207701);
    paramString = (Integer)cyj.get(paramString);
    AppMethodBeat.o(207701);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.a.a.l.d
 * JD-Core Version:    0.7.0.1
 */