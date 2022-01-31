package com.tencent.mm.aa;

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
    AppMethodBeat.i(117691);
    localb = new b();
    if (parama == null)
    {
      AppMethodBeat.o(117691);
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
      AppMethodBeat.o(117691);
    }
  }
  
  public static e a(c paramc)
  {
    AppMethodBeat.i(117690);
    locale = new e();
    if (paramc == null)
    {
      AppMethodBeat.o(117690);
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
      AppMethodBeat.o(117690);
    }
  }
  
  protected static void a(b paramb, Object paramObject)
  {
    AppMethodBeat.i(117692);
    if ((paramObject instanceof c))
    {
      paramb.a(a((c)paramObject));
      AppMethodBeat.o(117692);
      return;
    }
    if ((paramObject instanceof a))
    {
      paramb.a(a((a)paramObject));
      AppMethodBeat.o(117692);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramb.cS(((Integer)paramObject).intValue());
      AppMethodBeat.o(117692);
      return;
    }
    if ((paramObject instanceof String))
    {
      paramb.ac((String)paramObject);
      AppMethodBeat.o(117692);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramb.aA(((Boolean)paramObject).booleanValue());
      AppMethodBeat.o(117692);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramb.m(((Long)paramObject).longValue());
      AppMethodBeat.o(117692);
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramb.T(((Float)paramObject).floatValue());
      AppMethodBeat.o(117692);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramb.cS(((Integer)paramObject).intValue());
      AppMethodBeat.o(117692);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramb.m(((Double)paramObject).doubleValue());
      AppMethodBeat.o(117692);
      return;
    }
    if ((paramObject instanceof h)) {
      paramb.a((h)paramObject);
    }
    AppMethodBeat.o(117692);
  }
  
  protected static void a(e parame, String paramString, Object paramObject)
  {
    AppMethodBeat.i(117693);
    if ((paramObject instanceof c))
    {
      parame.b(paramString, a((c)paramObject));
      AppMethodBeat.o(117693);
      return;
    }
    if ((paramObject instanceof a))
    {
      parame.b(paramString, a((a)paramObject));
      AppMethodBeat.o(117693);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      parame.f(paramString, ((Integer)paramObject).intValue());
      AppMethodBeat.o(117693);
      return;
    }
    if ((paramObject instanceof String))
    {
      parame.h(paramString, (String)paramObject);
      AppMethodBeat.o(117693);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      parame.e(paramString, ((Boolean)paramObject).booleanValue());
      AppMethodBeat.o(117693);
      return;
    }
    if ((paramObject instanceof Long))
    {
      parame.b(paramString, ((Long)paramObject).longValue());
      AppMethodBeat.o(117693);
      return;
    }
    if ((paramObject instanceof Float))
    {
      parame.d(paramString, ((Float)paramObject).floatValue());
      AppMethodBeat.o(117693);
      return;
    }
    if ((paramObject instanceof Double))
    {
      parame.b(paramString, ((Double)paramObject).doubleValue());
      AppMethodBeat.o(117693);
      return;
    }
    if ((paramObject instanceof h)) {
      parame.b(paramString, (h)paramObject);
    }
    AppMethodBeat.o(117693);
  }
  
  public static e l(Map paramMap)
  {
    AppMethodBeat.i(117689);
    e locale = new e();
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(117689);
      return locale;
    }
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramMap.get(localObject1);
      a(locale, (String)localObject1, localObject2);
    }
    AppMethodBeat.o(117689);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.aa.j
 * JD-Core Version:    0.7.0.1
 */