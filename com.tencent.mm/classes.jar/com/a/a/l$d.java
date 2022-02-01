package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class l$d
{
  private static final Map<String, Integer> aCx;
  
  static
  {
    AppMethodBeat.i(202873);
    HashMap localHashMap = new HashMap(13);
    aCx = localHashMap;
    localHashMap.put("normal", Integer.valueOf(400));
    aCx.put("bold", Integer.valueOf(700));
    aCx.put("bolder", Integer.valueOf(1));
    aCx.put("lighter", Integer.valueOf(-1));
    aCx.put("100", Integer.valueOf(100));
    aCx.put("200", Integer.valueOf(200));
    aCx.put("300", Integer.valueOf(300));
    aCx.put("400", Integer.valueOf(400));
    aCx.put("500", Integer.valueOf(500));
    aCx.put("600", Integer.valueOf(600));
    aCx.put("700", Integer.valueOf(700));
    aCx.put("800", Integer.valueOf(800));
    aCx.put("900", Integer.valueOf(900));
    AppMethodBeat.o(202873);
  }
  
  static Integer aL(String paramString)
  {
    AppMethodBeat.i(202869);
    paramString = (Integer)aCx.get(paramString);
    AppMethodBeat.o(202869);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.a.a.l.d
 * JD-Core Version:    0.7.0.1
 */