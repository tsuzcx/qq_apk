package com.tencent.mm.ad;

import com.eclipsesource.a.b;
import com.eclipsesource.a.e;
import com.eclipsesource.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
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
      paramb.hf(((Integer)paramObject).intValue());
      AppMethodBeat.o(158632);
      return;
    }
    if ((paramObject instanceof String))
    {
      paramb.cq((String)paramObject);
      AppMethodBeat.o(158632);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramb.bt(((Boolean)paramObject).booleanValue());
      AppMethodBeat.o(158632);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramb.bI(((Long)paramObject).longValue());
      AppMethodBeat.o(158632);
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramb.aP(((Float)paramObject).floatValue());
      AppMethodBeat.o(158632);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramb.hf(((Integer)paramObject).intValue());
      AppMethodBeat.o(158632);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramb.s(((Double)paramObject).doubleValue());
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
      parame.t(paramString, ((Integer)paramObject).intValue());
      AppMethodBeat.o(158633);
      return;
    }
    if ((paramObject instanceof String))
    {
      parame.q(paramString, (String)paramObject);
      AppMethodBeat.o(158633);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      parame.d(paramString, ((Boolean)paramObject).booleanValue());
      AppMethodBeat.o(158633);
      return;
    }
    if ((paramObject instanceof Long))
    {
      parame.c(paramString, ((Long)paramObject).longValue());
      AppMethodBeat.o(158633);
      return;
    }
    if ((paramObject instanceof Float))
    {
      parame.b(paramString, ((Float)paramObject).floatValue());
      AppMethodBeat.o(158633);
      return;
    }
    if ((paramObject instanceof Double))
    {
      parame.b(paramString, ((Double)paramObject).doubleValue());
      AppMethodBeat.o(158633);
      return;
    }
    if ((paramObject instanceof h)) {
      parame.b(paramString, (h)paramObject);
    }
    AppMethodBeat.o(158633);
  }
  
  public static b t(Collection paramCollection)
  {
    AppMethodBeat.i(230948);
    b localb = new b();
    if (paramCollection == null)
    {
      AppMethodBeat.o(230948);
      return localb;
    }
    paramCollection = new ArrayList(paramCollection);
    int i = 0;
    while (i < paramCollection.size())
    {
      a(localb, paramCollection.get(i));
      i += 1;
    }
    AppMethodBeat.o(230948);
    return localb;
  }
  
  public static e v(Map paramMap)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ad.j
 * JD-Core Version:    0.7.0.1
 */