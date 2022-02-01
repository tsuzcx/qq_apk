package com.tencent.luggage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements c
{
  private static Map<Class<? extends b>, b> cqi;
  private static Map<Class<? extends d>, d> cqj;
  
  static
  {
    AppMethodBeat.i(140304);
    cqi = new ConcurrentHashMap();
    cqj = new ConcurrentHashMap();
    AppMethodBeat.o(140304);
  }
  
  public final Map<Class<? extends b>, b> NK()
  {
    return cqi;
  }
  
  public final Map<Class<? extends d>, d> NL()
  {
    return cqj;
  }
  
  public final String getName()
  {
    return "luggage-core";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.a.a
 * JD-Core Version:    0.7.0.1
 */