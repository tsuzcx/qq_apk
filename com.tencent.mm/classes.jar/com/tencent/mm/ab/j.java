package com.tencent.mm.ab;

import com.eclipsesource.a.b;
import com.eclipsesource.a.e;
import com.eclipsesource.a.h;
import java.util.Iterator;
import java.util.List;

public final class j
{
  private static b a(a parama)
  {
    localb = new b();
    if (parama == null) {}
    for (;;)
    {
      return localb;
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
      catch (g parama) {}
    }
  }
  
  private static e a(c paramc)
  {
    locale = new e();
    if (paramc == null) {
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
    catch (g paramc) {}
  }
  
  protected static void a(b paramb, Object paramObject)
  {
    if ((paramObject instanceof c)) {
      paramb.a(a((c)paramObject));
    }
    do
    {
      return;
      if ((paramObject instanceof a))
      {
        paramb.a(a((a)paramObject));
        return;
      }
      if ((paramObject instanceof Integer))
      {
        paramb.cz(((Integer)paramObject).intValue());
        return;
      }
      if ((paramObject instanceof String))
      {
        paramObject = (String)paramObject;
        paramb.arx.add(com.eclipsesource.a.a.V(paramObject));
        return;
      }
      if ((paramObject instanceof Boolean))
      {
        paramb.ar(((Boolean)paramObject).booleanValue());
        return;
      }
      if ((paramObject instanceof Long))
      {
        paramb.o(((Long)paramObject).longValue());
        return;
      }
      if ((paramObject instanceof Float))
      {
        float f = ((Float)paramObject).floatValue();
        paramb.arx.add(com.eclipsesource.a.a.T(f));
        return;
      }
      if ((paramObject instanceof Integer))
      {
        paramb.cz(((Integer)paramObject).intValue());
        return;
      }
      if ((paramObject instanceof Double))
      {
        paramb.m(((Double)paramObject).doubleValue());
        return;
      }
    } while (!(paramObject instanceof h));
    paramb.a((h)paramObject);
  }
  
  protected static void a(e parame, String paramString, Object paramObject)
  {
    if ((paramObject instanceof c)) {
      parame.b(paramString, a((c)paramObject));
    }
    do
    {
      return;
      if ((paramObject instanceof a))
      {
        parame.b(paramString, a((a)paramObject));
        return;
      }
      if ((paramObject instanceof Integer))
      {
        parame.g(paramString, ((Integer)paramObject).intValue());
        return;
      }
      if ((paramObject instanceof String))
      {
        parame.b(paramString, com.eclipsesource.a.a.V((String)paramObject));
        return;
      }
      if ((paramObject instanceof Boolean))
      {
        parame.b(paramString, com.eclipsesource.a.a.aq(((Boolean)paramObject).booleanValue()));
        return;
      }
      if ((paramObject instanceof Long))
      {
        parame.b(paramString, com.eclipsesource.a.a.n(((Long)paramObject).longValue()));
        return;
      }
      if ((paramObject instanceof Float))
      {
        parame.b(paramString, com.eclipsesource.a.a.T(((Float)paramObject).floatValue()));
        return;
      }
      if ((paramObject instanceof Integer))
      {
        parame.g(paramString, ((Integer)paramObject).intValue());
        return;
      }
      if ((paramObject instanceof Double))
      {
        parame.b(paramString, com.eclipsesource.a.a.l(((Double)paramObject).doubleValue()));
        return;
      }
    } while (!(paramObject instanceof h));
    parame.b(paramString, (h)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ab.j
 * JD-Core Version:    0.7.0.1
 */