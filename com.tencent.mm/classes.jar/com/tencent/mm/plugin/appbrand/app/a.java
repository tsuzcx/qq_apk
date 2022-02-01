package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.b.e.h;
import com.tencent.mm.plugin.appbrand.appcache.bi;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.appusage.n;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.backgroundfetch.g;
import com.tencent.mm.plugin.appbrand.launching.aw;
import com.tencent.mm.plugin.appbrand.launching.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

final class a
{
  static final Map<a, String[]> jjs;
  private static final Map<Class, Object> jjt;
  
  static
  {
    AppMethodBeat.i(44088);
    jjs = new HashMap();
    a(new a() {}, t.hlS);
    a(new a.12(), ag.hlS);
    a(new a() {}, n.hlS);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.b.e.e.hlS);
    a(new a() {}, an.hlS);
    a(new a() {}, k.hlS);
    a(new a.22(), h.hlS);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.b.e.d.hlS);
    a(new a() {}, al.hlS);
    a(new a.2(), com.tencent.mm.plugin.appbrand.appcache.b.e.b.hlS);
    a(new a.3(), com.tencent.mm.plugin.appbrand.appusage.a.b.hlS);
    a(new a() {}, u.hlS);
    a(new a() {}, com.tencent.mm.plugin.appbrand.backgroundfetch.d.hlS);
    a(new a() {}, g.hlS);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.b.d.a.hlS);
    a(new a.8(), ah.hlS);
    a(new a.9(), com.tencent.mm.plugin.appbrand.appstorage.b.hlS);
    a(new a() {}, aw.hlS);
    a(new a() {}, com.tencent.mm.plugin.appbrand.page.web_renderingcache.b.hlS);
    a(new a() {}, bi.hlS);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.a.hlS);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.c.hlS);
    a(new a() {}, com.tencent.mm.plugin.appbrand.config.a.a.hlS);
    a(new a() {}, com.tencent.mm.plugin.appbrand.ui.c.a.b.hlS);
    jjt = new HashMap();
    AppMethodBeat.o(44088);
  }
  
  static <T> T T(Class<T> paramClass)
  {
    AppMethodBeat.i(44087);
    boolean bool;
    if (paramClass != null) {
      bool = true;
    }
    for (;;)
    {
      Assert.assertTrue("Cant pass Null class here", bool);
      synchronized (jjt)
      {
        paramClass = jjt.get(paramClass);
        AppMethodBeat.o(44087);
        return paramClass;
        bool = false;
      }
    }
  }
  
  private static void a(a parama, String[] paramArrayOfString)
  {
    AppMethodBeat.i(44084);
    jjs.put(parama, paramArrayOfString);
    AppMethodBeat.o(44084);
  }
  
  static void a(com.tencent.mm.sdk.e.e parame)
  {
    AppMethodBeat.i(44085);
    synchronized (jjt)
    {
      jjt.clear();
      Iterator localIterator = jjs.keySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject = ((a)localIterator.next()).b(parame);
        jjt.put(localObject.getClass(), localObject);
      }
    }
    AppMethodBeat.o(44085);
  }
  
  static void aVc()
  {
    AppMethodBeat.i(44086);
    synchronized (jjt)
    {
      jjt.clear();
      AppMethodBeat.o(44086);
      return;
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract T b(com.tencent.mm.sdk.e.e parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.a
 * JD-Core Version:    0.7.0.1
 */