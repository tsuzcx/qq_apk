package com.tencent.luggage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

public final class e
{
  private static LinkedHashMap<String, c> csf;
  private static Map<Class<? extends d>, Object> csg;
  
  static
  {
    AppMethodBeat.i(140311);
    csf = new LinkedHashMap();
    a locala = new a();
    Log.i("Luggage.Luggage", "plugin:[%s] installed", new Object[] { locala.getName() });
    csf.put(locala.getName(), locala);
    csg = new HashMap();
    AppMethodBeat.o(140311);
  }
  
  public static <T extends b> T M(Class<T> paramClass)
  {
    AppMethodBeat.i(140305);
    if (paramClass == null)
    {
      AppMethodBeat.o(140305);
      return null;
    }
    ListIterator localListIterator = new ArrayList(csf.values()).listIterator(csf.size());
    while (localListIterator.hasPrevious())
    {
      c localc = (c)localListIterator.previous();
      if ((localc != null) && (localc.KU() != null) && (localc.KU().get(paramClass) != null))
      {
        paramClass = (b)localc.KU().get(paramClass);
        AppMethodBeat.o(140305);
        return paramClass;
      }
    }
    Log.w("Luggage.Luggage", "no customize found for [%s]", new Object[] { paramClass.getCanonicalName() });
    AppMethodBeat.o(140305);
    return null;
  }
  
  public static <T extends d> T N(Class<T> paramClass)
  {
    AppMethodBeat.i(140308);
    paramClass = O(paramClass);
    AppMethodBeat.o(140308);
    return paramClass;
  }
  
  public static <T extends d> T O(Class<T> paramClass)
  {
    AppMethodBeat.i(140309);
    if (paramClass == null)
    {
      paramClass = P(paramClass);
      AppMethodBeat.o(140309);
      return paramClass;
    }
    ListIterator localListIterator = new ArrayList(csf.values()).listIterator(csf.size());
    while (localListIterator.hasPrevious())
    {
      c localc = (c)localListIterator.previous();
      if ((localc != null) && (localc.KV() != null) && (localc.KV().get(paramClass) != null))
      {
        paramClass = (d)localc.KV().get(paramClass);
        AppMethodBeat.o(140309);
        return paramClass;
      }
    }
    Log.w("Luggage.Luggage", "no profiler found for [%s], genDummy[%b]", new Object[] { paramClass.getCanonicalName(), Boolean.TRUE });
    paramClass = P(paramClass);
    AppMethodBeat.o(140309);
    return paramClass;
  }
  
  private static <T extends d> T P(Class<T> paramClass)
  {
    AppMethodBeat.i(140310);
    if (csg.get(paramClass) != null)
    {
      paramClass = (d)csg.get(paramClass);
      AppMethodBeat.o(140310);
      return paramClass;
    }
    Object localObject = new InvocationHandler()
    {
      public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
      {
        return null;
      }
    };
    localObject = (d)Proxy.newProxyInstance(d.class.getClassLoader(), new Class[] { paramClass }, (InvocationHandler)localObject);
    csg.put(paramClass, localObject);
    AppMethodBeat.o(140310);
    return localObject;
  }
  
  public static <T extends b> void a(Class<T> paramClass, T paramT)
  {
    AppMethodBeat.i(140306);
    if ((paramClass == null) || (paramT == null))
    {
      AppMethodBeat.o(140306);
      return;
    }
    ((c)csf.get("luggage-core")).KU().put(paramClass, paramT);
    AppMethodBeat.o(140306);
  }
  
  public static <T extends d> void a(Class<T> paramClass, T paramT)
  {
    AppMethodBeat.i(140307);
    if ((paramClass == null) || (paramT == null))
    {
      AppMethodBeat.o(140307);
      return;
    }
    ((c)csf.get("luggage-core")).KV().put(paramClass, paramT);
    AppMethodBeat.o(140307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.a.e
 * JD-Core Version:    0.7.0.1
 */