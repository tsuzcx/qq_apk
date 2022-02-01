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
  private static LinkedHashMap<String, c> eic;
  private static Map<Class<? extends d>, Object> eid;
  
  static
  {
    AppMethodBeat.i(140311);
    eic = new LinkedHashMap();
    a locala = new a();
    Log.i("Luggage.Luggage", "plugin:[%s] installed", new Object[] { locala.getName() });
    eic.put(locala.getName(), locala);
    eid = new HashMap();
    AppMethodBeat.o(140311);
  }
  
  public static <T extends b> T T(Class<T> paramClass)
  {
    AppMethodBeat.i(140305);
    if (paramClass == null)
    {
      AppMethodBeat.o(140305);
      return null;
    }
    ListIterator localListIterator = new ArrayList(eic.values()).listIterator(eic.size());
    while (localListIterator.hasPrevious())
    {
      c localc = (c)localListIterator.previous();
      if ((localc != null) && (localc.anW() != null) && (localc.anW().get(paramClass) != null))
      {
        paramClass = (b)localc.anW().get(paramClass);
        AppMethodBeat.o(140305);
        return paramClass;
      }
    }
    Log.w("Luggage.Luggage", "no customize found for [%s]", new Object[] { paramClass.getCanonicalName() });
    AppMethodBeat.o(140305);
    return null;
  }
  
  public static <T extends d> T U(Class<T> paramClass)
  {
    AppMethodBeat.i(140308);
    paramClass = V(paramClass);
    AppMethodBeat.o(140308);
    return paramClass;
  }
  
  public static <T extends d> T V(Class<T> paramClass)
  {
    AppMethodBeat.i(140309);
    if (paramClass == null)
    {
      paramClass = W(paramClass);
      AppMethodBeat.o(140309);
      return paramClass;
    }
    ListIterator localListIterator = new ArrayList(eic.values()).listIterator(eic.size());
    while (localListIterator.hasPrevious())
    {
      c localc = (c)localListIterator.previous();
      if ((localc != null) && (localc.anX() != null) && (localc.anX().get(paramClass) != null))
      {
        paramClass = (d)localc.anX().get(paramClass);
        AppMethodBeat.o(140309);
        return paramClass;
      }
    }
    Log.w("Luggage.Luggage", "no profiler found for [%s], genDummy[%b]", new Object[] { paramClass.getCanonicalName(), Boolean.TRUE });
    paramClass = W(paramClass);
    AppMethodBeat.o(140309);
    return paramClass;
  }
  
  private static <T extends d> T W(Class<T> paramClass)
  {
    AppMethodBeat.i(140310);
    if (eid.get(paramClass) != null)
    {
      paramClass = (d)eid.get(paramClass);
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
    eid.put(paramClass, localObject);
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
    ((c)eic.get("luggage-core")).anW().put(paramClass, paramT);
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
    ((c)eic.get("luggage-core")).anX().put(paramClass, paramT);
    AppMethodBeat.o(140307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.a.e
 * JD-Core Version:    0.7.0.1
 */