package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.b.d.b;
import com.tencent.mm.plugin.appbrand.appcache.x;
import com.tencent.mm.plugin.appbrand.appcache.z;
import com.tencent.mm.plugin.appbrand.appusage.a.c;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.appusage.n;
import com.tencent.mm.plugin.appbrand.appusage.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

final class a
{
  static final Map<a.a, String[]> fAH = new HashMap();
  private static final Map<Class, Object> fAI = new HashMap();
  
  static
  {
    a(new a.1(), com.tencent.mm.plugin.appbrand.launching.h.dUb);
    a(new a.6(), x.dUb);
    a(new a.7(), n.dUb);
    a(new a.8(), com.tencent.mm.plugin.appbrand.appcache.b.d.e.dUb);
    a(new a.9(), ab.dUb);
    a(new a.10(), k.dUb);
    a(new a.11(), com.tencent.mm.plugin.appbrand.appcache.b.d.h.dUb);
    a(new a.12(), com.tencent.mm.plugin.appbrand.appcache.b.d.d.dUb);
    a(new a.13(), z.dUb);
    a(new a.2(), b.dUb);
    a(new a.3(), c.dUb);
    a(new a.4(), s.dUb);
    a(new a.5(), com.tencent.mm.plugin.appbrand.backgroundfetch.d.dUb);
  }
  
  static <T> T G(Class<T> paramClass)
  {
    if (paramClass != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("Cant pass Null class here", bool);
      synchronized (fAI)
      {
        paramClass = fAI.get(paramClass);
        return paramClass;
      }
    }
  }
  
  private static void a(a.a parama, String[] paramArrayOfString)
  {
    fAH.put(parama, paramArrayOfString);
  }
  
  static void a(com.tencent.mm.sdk.e.e parame)
  {
    synchronized (fAI)
    {
      fAI.clear();
      Iterator localIterator = fAH.keySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject = ((a.a)localIterator.next()).b(parame);
        fAI.put(localObject.getClass(), localObject);
      }
    }
  }
  
  static void aaI()
  {
    synchronized (fAI)
    {
      fAI.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.a
 * JD-Core Version:    0.7.0.1
 */