package com.google.a;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class bm
{
  private static final bm bYM = new bm();
  private final bs bYN = new am();
  private final ConcurrentMap<Class<?>, br<?>> bYO = new ConcurrentHashMap();
  
  private <T> br<T> H(Class<T> paramClass)
  {
    ae.checkNotNull(paramClass, "messageType");
    br localbr2 = (br)this.bYO.get(paramClass);
    br localbr1 = localbr2;
    if (localbr2 == null)
    {
      localbr2 = this.bYN.G(paramClass);
      ae.checkNotNull(paramClass, "messageType");
      ae.checkNotNull(localbr2, "schema");
      localbr1 = (br)this.bYO.putIfAbsent(paramClass, localbr2);
      if (localbr1 == null) {}
    }
    else
    {
      return localbr1;
    }
    return localbr2;
  }
  
  public static bm Hl()
  {
    return bYM;
  }
  
  public final <T> br<T> av(T paramT)
  {
    return H(paramT.getClass());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.bm
 * JD-Core Version:    0.7.0.1
 */