package com.google.b;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class ck
{
  private static final ck caq = new ck();
  private final cq car = new bm();
  private final ConcurrentMap<Class<?>, cp<?>> cas = new ConcurrentHashMap();
  
  private <T> cp<T> F(Class<T> paramClass)
  {
    be.c(paramClass, "messageType");
    cp localcp2 = (cp)this.cas.get(paramClass);
    cp localcp1 = localcp2;
    if (localcp2 == null)
    {
      localcp2 = this.car.E(paramClass);
      be.c(paramClass, "messageType");
      be.c(localcp2, "schema");
      localcp1 = (cp)this.cas.putIfAbsent(paramClass, localcp2);
      if (localcp1 == null) {}
    }
    else
    {
      return localcp1;
    }
    return localcp2;
  }
  
  public static ck IM()
  {
    return caq;
  }
  
  public final <T> cp<T> ar(T paramT)
  {
    return F(paramT.getClass());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.ck
 * JD-Core Version:    0.7.0.1
 */