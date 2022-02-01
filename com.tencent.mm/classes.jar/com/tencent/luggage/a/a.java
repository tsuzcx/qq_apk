package com.tencent.luggage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements c
{
  private static Map<Class<? extends b>, b> bYW;
  private static Map<Class<? extends d>, d> bYX;
  
  static
  {
    AppMethodBeat.i(140304);
    bYW = new ConcurrentHashMap();
    bYX = new ConcurrentHashMap();
    AppMethodBeat.o(140304);
  }
  
  public final Map<Class<? extends b>, b> AD()
  {
    return bYW;
  }
  
  public final Map<Class<? extends d>, d> AE()
  {
    return bYX;
  }
  
  public final String getName()
  {
    return "luggage-core";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.a.a
 * JD-Core Version:    0.7.0.1
 */