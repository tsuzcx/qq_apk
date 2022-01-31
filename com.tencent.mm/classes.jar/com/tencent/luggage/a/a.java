package com.tencent.luggage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements c
{
  private static Map<Class<? extends b>, b> bxF;
  private static Map<Class<? extends d>, d> bxG;
  
  static
  {
    AppMethodBeat.i(90706);
    bxF = new ConcurrentHashMap();
    bxG = new ConcurrentHashMap();
    AppMethodBeat.o(90706);
  }
  
  public final String getName()
  {
    return "luggage-core";
  }
  
  public final Map<Class<? extends b>, b> tP()
  {
    return bxF;
  }
  
  public final Map<Class<? extends d>, d> tQ()
  {
    return bxG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.a.a
 * JD-Core Version:    0.7.0.1
 */