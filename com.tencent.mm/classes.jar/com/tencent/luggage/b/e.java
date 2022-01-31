package com.tencent.luggage.b;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

public final class e
{
  private static LinkedHashMap<String, c> bhh = new LinkedHashMap();
  private static Map<Class<? extends d>, Object> bhi = new HashMap();
  
  static
  {
    a locala = new a();
    com.tencent.luggage.j.c.i("Luggage.Luggage", "plugin:[%s] installed", new Object[] { locala.getName() });
    bhh.put(locala.getName(), locala);
  }
  
  public static <T extends b> void a(Class<T> paramClass, T paramT)
  {
    if ((paramClass == null) || (paramT == null)) {
      return;
    }
    ((c)bhh.get("luggage-core")).pL().put(paramClass, paramT);
  }
  
  public static <T extends d> void a(Class<T> paramClass, T paramT)
  {
    if ((paramClass == null) || (paramT == null)) {
      return;
    }
    ((c)bhh.get("luggage-core")).pM().put(paramClass, paramT);
  }
  
  public static <T extends b> T i(Class<T> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    ListIterator localListIterator = new ArrayList(bhh.values()).listIterator(bhh.size());
    while (localListIterator.hasPrevious())
    {
      c localc = (c)localListIterator.previous();
      if ((localc != null) && (localc.pL() != null) && (localc.pL().get(paramClass) != null)) {
        return (b)localc.pL().get(paramClass);
      }
    }
    com.tencent.luggage.j.c.w("Luggage.Luggage", "no customize found for [%s]", new Object[] { paramClass.getCanonicalName() });
    return null;
  }
  
  public static <T extends d> T j(Class<T> paramClass)
  {
    Object localObject = new ArrayList(bhh.values()).listIterator(bhh.size());
    while (((ListIterator)localObject).hasPrevious())
    {
      c localc = (c)((ListIterator)localObject).previous();
      if ((localc != null) && (localc.pM() != null) && (localc.pM().get(paramClass) != null)) {
        return (d)localc.pM().get(paramClass);
      }
    }
    com.tencent.luggage.j.c.w("Luggage.Luggage", "no profiler found for [%s], genDummy[%b]", new Object[] { paramClass.getCanonicalName(), Boolean.valueOf(true) });
    if (bhi.get(paramClass) != null) {
      return (d)bhi.get(paramClass);
    }
    localObject = new e.1();
    localObject = (d)Proxy.newProxyInstance(d.class.getClassLoader(), new Class[] { paramClass }, (InvocationHandler)localObject);
    bhi.put(paramClass, localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.b.e
 * JD-Core Version:    0.7.0.1
 */