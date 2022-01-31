package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.appcache.b.e.h;
import com.tencent.mm.plugin.appbrand.appcache.f;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.appusage.n;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.backgroundfetch.g;
import com.tencent.mm.plugin.appbrand.launching.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

final class a
{
  static final Map<a.a, String[]> gSq;
  private static final Map<Class, Object> gSr;
  
  static
  {
    AppMethodBeat.i(129191);
    gSq = new HashMap();
    a(new a.1(), m.fkl);
    a(new a.9(), ad.fkl);
    a(new a.10(), n.fkl);
    a(new a.11(), com.tencent.mm.plugin.appbrand.appcache.b.e.e.fkl);
    a(new a.12(), ah.fkl);
    a(new a.13(), k.fkl);
    a(new a.14(), h.fkl);
    a(new a.15(), com.tencent.mm.plugin.appbrand.appcache.b.e.d.fkl);
    a(new a.16(), af.fkl);
    a(new a.2(), com.tencent.mm.plugin.appbrand.appcache.b.e.b.fkl);
    a(new a.3(), com.tencent.mm.plugin.appbrand.appusage.a.b.fkl);
    a(new a.4(), s.fkl);
    a(new a.5(), com.tencent.mm.plugin.appbrand.backgroundfetch.d.fkl);
    a(new a.6(), g.fkl);
    a(new a.7(), com.tencent.mm.plugin.appbrand.appcache.b.d.a.fkl);
    a(new a.8(), f.fkl);
    gSr = new HashMap();
    AppMethodBeat.o(129191);
  }
  
  private static void a(a.a parama, String[] paramArrayOfString)
  {
    AppMethodBeat.i(129187);
    gSq.put(parama, paramArrayOfString);
    AppMethodBeat.o(129187);
  }
  
  static void a(com.tencent.mm.sdk.e.e parame)
  {
    AppMethodBeat.i(129188);
    synchronized (gSr)
    {
      gSr.clear();
      Iterator localIterator = gSq.keySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject = ((a.a)localIterator.next()).b(parame);
        gSr.put(localObject.getClass(), localObject);
      }
    }
    AppMethodBeat.o(129188);
  }
  
  static void aus()
  {
    AppMethodBeat.i(129189);
    synchronized (gSr)
    {
      gSr.clear();
      AppMethodBeat.o(129189);
      return;
    }
  }
  
  static <T> T w(Class<T> paramClass)
  {
    AppMethodBeat.i(129190);
    boolean bool;
    if (paramClass != null) {
      bool = true;
    }
    for (;;)
    {
      Assert.assertTrue("Cant pass Null class here", bool);
      synchronized (gSr)
      {
        paramClass = gSr.get(paramClass);
        AppMethodBeat.o(129190);
        return paramClass;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.a
 * JD-Core Version:    0.7.0.1
 */