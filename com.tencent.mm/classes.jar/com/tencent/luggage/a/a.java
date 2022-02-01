package com.tencent.luggage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements c
{
  private static Map<Class<? extends b>, b> bVT;
  private static Map<Class<? extends d>, d> bVU;
  
  static
  {
    AppMethodBeat.i(140304);
    bVT = new ConcurrentHashMap();
    bVU = new ConcurrentHashMap();
    AppMethodBeat.o(140304);
  }
  
  public final Map<Class<? extends b>, b> Ah()
  {
    return bVT;
  }
  
  public final Map<Class<? extends d>, d> Ai()
  {
    return bVU;
  }
  
  public final String getName()
  {
    return "luggage-core";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.a.a
 * JD-Core Version:    0.7.0.1
 */