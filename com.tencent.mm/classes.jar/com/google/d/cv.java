package com.google.d;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class cv
{
  private static final cv dUz = new cv();
  private final dd dUA = new bs();
  private final ConcurrentMap<Class<?>, dc<?>> dUB = new ConcurrentHashMap();
  
  private dc<?> a(Class<?> paramClass, dc<?> paramdc)
  {
    bj.c(paramClass, "messageType");
    bj.c(paramdc, "schema");
    return (dc)this.dUB.putIfAbsent(paramClass, paramdc);
  }
  
  public static cv aja()
  {
    return dUz;
  }
  
  public final <T> dc<T> O(Class<T> paramClass)
  {
    bj.c(paramClass, "messageType");
    dc localdc2 = (dc)this.dUB.get(paramClass);
    dc localdc1 = localdc2;
    if (localdc2 == null)
    {
      localdc2 = this.dUA.N(paramClass);
      localdc1 = a(paramClass, localdc2);
      if (localdc1 == null) {}
    }
    else
    {
      return localdc1;
    }
    return localdc2;
  }
  
  public final <T> dc<T> bK(T paramT)
  {
    return O(paramT.getClass());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.cv
 * JD-Core Version:    0.7.0.1
 */