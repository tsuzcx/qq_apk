package com.tencent.luggage.b;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements c
{
  private static Map<Class<? extends b>, b> bhf = new ConcurrentHashMap();
  private static Map<Class<? extends d>, d> bhg = new ConcurrentHashMap();
  
  public final String getName()
  {
    return "luggage-core";
  }
  
  public final Map<Class<? extends b>, b> pL()
  {
    return bhf;
  }
  
  public final Map<Class<? extends d>, d> pM()
  {
    return bhg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.b.a
 * JD-Core Version:    0.7.0.1
 */