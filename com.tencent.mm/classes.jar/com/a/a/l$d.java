package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class l$d
{
  private static final Map<String, Integer> aUi;
  
  static
  {
    AppMethodBeat.i(214931);
    HashMap localHashMap = new HashMap(13);
    aUi = localHashMap;
    localHashMap.put("normal", Integer.valueOf(400));
    aUi.put("bold", Integer.valueOf(700));
    aUi.put("bolder", Integer.valueOf(1));
    aUi.put("lighter", Integer.valueOf(-1));
    aUi.put("100", Integer.valueOf(100));
    aUi.put("200", Integer.valueOf(200));
    aUi.put("300", Integer.valueOf(300));
    aUi.put("400", Integer.valueOf(400));
    aUi.put("500", Integer.valueOf(500));
    aUi.put("600", Integer.valueOf(600));
    aUi.put("700", Integer.valueOf(700));
    aUi.put("800", Integer.valueOf(800));
    aUi.put("900", Integer.valueOf(900));
    AppMethodBeat.o(214931);
  }
  
  static Integer aK(String paramString)
  {
    AppMethodBeat.i(214930);
    paramString = (Integer)aUi.get(paramString);
    AppMethodBeat.o(214930);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.a.a.l.d
 * JD-Core Version:    0.7.0.1
 */