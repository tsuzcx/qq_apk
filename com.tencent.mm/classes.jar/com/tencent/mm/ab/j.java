package com.tencent.mm.ab;

import com.eclipsesource.a.b;
import com.eclipsesource.a.e;
import com.eclipsesource.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class j
{
  public static b a(a parama)
  {
    AppMethodBeat.i(158631);
    localb = new b();
    if (parama == null)
    {
      AppMethodBeat.o(158631);
      return localb;
    }
    int i = 0;
    try
    {
      while (i < parama.length())
      {
        a(localb, parama.get(i));
        i += 1;
      }
      return localb;
    }
    catch (g parama)
    {
      AppMethodBeat.o(158631);
    }
  }
  
  public static e a(c paramc)
  {
    AppMethodBeat.i(158630);
    locale = new e();
    if (paramc == null)
    {
      AppMethodBeat.o(158630);
      return locale;
    }
    try
    {
      Iterator localIterator = paramc.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a(locale, str, paramc.get(str));
      }
      return locale;
    }
    catch (g paramc)
    {
      AppMethodBeat.o(158630);
    }
  }
  
  protected static void a(b paramb, Object paramObject)
  {
    AppMethodBeat.i(158632);
    if ((paramObject instanceof c))
    {
      paramb.a(a((c)paramObject));
      AppMethodBeat.o(158632);
      return;
    }
    if ((paramObject instanceof a))
    {
      paramb.a(a((a)paramObject));
      AppMethodBeat.o(158632);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramb.dC(((Integer)paramObject).intValue());
      AppMethodBeat.o(158632);
      return;
    }
    if ((paramObject instanceof String))
    {
      paramb.aa((String)paramObject);
      AppMethodBeat.o(158632);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramb.aM(((Boolean)paramObject).booleanValue());
      AppMethodBeat.o(158632);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramb.t(((Long)paramObject).longValue());
      AppMethodBeat.o(158632);
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramb.aa(((Float)paramObject).floatValue());
      AppMethodBeat.o(158632);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramb.dC(((Integer)paramObject).intValue());
      AppMethodBeat.o(158632);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramb.e(((Double)paramObject).doubleValue());
      AppMethodBeat.o(158632);
      return;
    }
    if ((paramObject instanceof h)) {
      paramb.a((h)paramObject);
    }
    AppMethodBeat.o(158632);
  }
  
  protected static void a(e parame, String paramString, Object paramObject)
  {
    AppMethodBeat.i(158633);
    if ((paramObject instanceof c))
    {
      parame.b(paramString, a((c)paramObject));
      AppMethodBeat.o(158633);
      return;
    }
    if ((paramObject instanceof a))
    {
      parame.b(paramString, a((a)paramObject));
      AppMethodBeat.o(158633);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      parame.f(paramString, ((Integer)paramObject).intValue());
      AppMethodBeat.o(158633);
      return;
    }
    if ((paramObject instanceof String))
    {
      parame.h(paramString, (String)paramObject);
      AppMethodBeat.o(158633);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      parame.e(paramString, ((Boolean)paramObject).booleanValue());
      AppMethodBeat.o(158633);
      return;
    }
    if ((paramObject instanceof Long))
    {
      parame.b(paramString, ((Long)paramObject).longValue());
      AppMethodBeat.o(158633);
      return;
    }
    if ((paramObject instanceof Float))
    {
      parame.d(paramString, ((Float)paramObject).floatValue());
      AppMethodBeat.o(158633);
      return;
    }
    if ((paramObject instanceof Double))
    {
      parame.a(paramString, ((Double)paramObject).doubleValue());
      AppMethodBeat.o(158633);
      return;
    }
    if ((paramObject instanceof h)) {
      parame.b(paramString, (h)paramObject);
    }
    AppMethodBeat.o(158633);
  }
  
  public static e n(Map paramMap)
  {
    AppMethodBeat.i(158629);
    e locale = new e();
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(158629);
      return locale;
    }
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramMap.get(localObject1);
      a(locale, (String)localObject1, localObject2);
    }
    AppMethodBeat.o(158629);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ab.j
 * JD-Core Version:    0.7.0.1
 */