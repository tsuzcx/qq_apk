package com.tencent.luggage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

public final class e
{
  private static LinkedHashMap<String, c> bxH;
  private static Map<Class<? extends d>, Object> bxI;
  
  static
  {
    AppMethodBeat.i(90711);
    bxH = new LinkedHashMap();
    a locala = new a();
    com.tencent.luggage.g.d.i("Luggage.Luggage", "plugin:[%s] installed", new Object[] { locala.getName() });
    bxH.put(locala.getName(), locala);
    bxI = new HashMap();
    AppMethodBeat.o(90711);
  }
  
  public static <T extends b> void a(Class<T> paramClass, T paramT)
  {
    AppMethodBeat.i(90708);
    if ((paramClass == null) || (paramT == null))
    {
      AppMethodBeat.o(90708);
      return;
    }
    ((c)bxH.get("luggage-core")).tP().put(paramClass, paramT);
    AppMethodBeat.o(90708);
  }
  
  public static <T extends d> void a(Class<T> paramClass, T paramT)
  {
    AppMethodBeat.i(90709);
    if ((paramClass == null) || (paramT == null))
    {
      AppMethodBeat.o(90709);
      return;
    }
    ((c)bxH.get("luggage-core")).tQ().put(paramClass, paramT);
    AppMethodBeat.o(90709);
  }
  
  public static <T extends b> T q(Class<T> paramClass)
  {
    AppMethodBeat.i(90707);
    if (paramClass == null)
    {
      AppMethodBeat.o(90707);
      return null;
    }
    ListIterator localListIterator = new ArrayList(bxH.values()).listIterator(bxH.size());
    while (localListIterator.hasPrevious())
    {
      c localc = (c)localListIterator.previous();
      if ((localc != null) && (localc.tP() != null) && (localc.tP().get(paramClass) != null))
      {
        paramClass = (b)localc.tP().get(paramClass);
        AppMethodBeat.o(90707);
        return paramClass;
      }
    }
    com.tencent.luggage.g.d.w("Luggage.Luggage", "no customize found for [%s]", new Object[] { paramClass.getCanonicalName() });
    AppMethodBeat.o(90707);
    return null;
  }
  
  public static <T extends d> T r(Class<T> paramClass)
  {
    AppMethodBeat.i(90710);
    paramClass = s(paramClass);
    AppMethodBeat.o(90710);
    return paramClass;
  }
  
  public static <T extends d> T s(Class<T> paramClass)
  {
    AppMethodBeat.i(155573);
    if (paramClass == null)
    {
      paramClass = t(paramClass);
      AppMethodBeat.o(155573);
      return paramClass;
    }
    ListIterator localListIterator = new ArrayList(bxH.values()).listIterator(bxH.size());
    while (localListIterator.hasPrevious())
    {
      c localc = (c)localListIterator.previous();
      if ((localc != null) && (localc.tQ() != null) && (localc.tQ().get(paramClass) != null))
      {
        paramClass = (d)localc.tQ().get(paramClass);
        AppMethodBeat.o(155573);
        return paramClass;
      }
    }
    com.tencent.luggage.g.d.w("Luggage.Luggage", "no profiler found for [%s], genDummy[%b]", new Object[] { paramClass.getCanonicalName(), Boolean.TRUE });
    paramClass = t(paramClass);
    AppMethodBeat.o(155573);
    return paramClass;
  }
  
  private static <T extends d> T t(Class<T> paramClass)
  {
    AppMethodBeat.i(155574);
    if (bxI.get(paramClass) != null)
    {
      paramClass = (d)bxI.get(paramClass);
      AppMethodBeat.o(155574);
      return paramClass;
    }
    Object localObject = new e.1();
    localObject = (d)Proxy.newProxyInstance(d.class.getClassLoader(), new Class[] { paramClass }, (InvocationHandler)localObject);
    bxI.put(paramClass, localObject);
    AppMethodBeat.o(155574);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.a.e
 * JD-Core Version:    0.7.0.1
 */