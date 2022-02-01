package com.tencent.luggage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
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
  private static LinkedHashMap<String, c> cgk;
  private static Map<Class<? extends d>, Object> cgl;
  
  static
  {
    AppMethodBeat.i(140311);
    cgk = new LinkedHashMap();
    a locala = new a();
    ad.i("Luggage.Luggage", "plugin:[%s] installed", new Object[] { locala.getName() });
    cgk.put(locala.getName(), locala);
    cgl = new HashMap();
    AppMethodBeat.o(140311);
  }
  
  public static <T extends b> T K(Class<T> paramClass)
  {
    AppMethodBeat.i(140305);
    if (paramClass == null)
    {
      AppMethodBeat.o(140305);
      return null;
    }
    ListIterator localListIterator = new ArrayList(cgk.values()).listIterator(cgk.size());
    while (localListIterator.hasPrevious())
    {
      c localc = (c)localListIterator.previous();
      if ((localc != null) && (localc.BE() != null) && (localc.BE().get(paramClass) != null))
      {
        paramClass = (b)localc.BE().get(paramClass);
        AppMethodBeat.o(140305);
        return paramClass;
      }
    }
    ad.w("Luggage.Luggage", "no customize found for [%s]", new Object[] { paramClass.getCanonicalName() });
    AppMethodBeat.o(140305);
    return null;
  }
  
  public static <T extends d> T L(Class<T> paramClass)
  {
    AppMethodBeat.i(140308);
    paramClass = M(paramClass);
    AppMethodBeat.o(140308);
    return paramClass;
  }
  
  public static <T extends d> T M(Class<T> paramClass)
  {
    AppMethodBeat.i(140309);
    if (paramClass == null)
    {
      paramClass = N(paramClass);
      AppMethodBeat.o(140309);
      return paramClass;
    }
    ListIterator localListIterator = new ArrayList(cgk.values()).listIterator(cgk.size());
    while (localListIterator.hasPrevious())
    {
      c localc = (c)localListIterator.previous();
      if ((localc != null) && (localc.BF() != null) && (localc.BF().get(paramClass) != null))
      {
        paramClass = (d)localc.BF().get(paramClass);
        AppMethodBeat.o(140309);
        return paramClass;
      }
    }
    ad.w("Luggage.Luggage", "no profiler found for [%s], genDummy[%b]", new Object[] { paramClass.getCanonicalName(), Boolean.TRUE });
    paramClass = N(paramClass);
    AppMethodBeat.o(140309);
    return paramClass;
  }
  
  private static <T extends d> T N(Class<T> paramClass)
  {
    AppMethodBeat.i(140310);
    if (cgl.get(paramClass) != null)
    {
      paramClass = (d)cgl.get(paramClass);
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
    cgl.put(paramClass, localObject);
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
    ((c)cgk.get("luggage-core")).BE().put(paramClass, paramT);
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
    ((c)cgk.get("luggage-core")).BF().put(paramClass, paramT);
    AppMethodBeat.o(140307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.a.e
 * JD-Core Version:    0.7.0.1
 */