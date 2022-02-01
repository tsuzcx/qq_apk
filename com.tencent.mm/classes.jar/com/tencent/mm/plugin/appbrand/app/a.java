package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appcache.b.e.h;
import com.tencent.mm.plugin.appbrand.appcache.bk;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.appusage.n;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.backgroundfetch.g;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.config.s.a;
import com.tencent.mm.plugin.appbrand.launching.az;
import com.tencent.mm.plugin.appbrand.launching.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class a
{
  static final Map<a, String[]> jGe;
  private static final Map<Class, Object> jGf;
  
  static
  {
    AppMethodBeat.i(44088);
    jGe = new HashMap();
    a(new a() {}, t.hGX);
    a(new a.12(), ai.hGX);
    a(new a() {}, n.hGX);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.b.e.e.hGX);
    a(new a() {}, ap.hGX);
    a(new a() {}, k.hGX);
    a(new a.22(), h.hGX);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.b.e.d.hGX);
    a(new a() {}, an.hGX);
    a(new a.2(), com.tencent.mm.plugin.appbrand.appcache.b.e.b.hGX);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appusage.a.b.hGX);
    a(new a() {}, u.hGX);
    a(new a() {}, com.tencent.mm.plugin.appbrand.backgroundfetch.d.hGX);
    a(new a() {}, g.hGX);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.b.d.a.hGX);
    a(new a.8(), aj.hGX);
    a(new a.9(), com.tencent.mm.plugin.appbrand.appstorage.b.hGX);
    a(new a() {}, az.hGX);
    a(new a() {}, com.tencent.mm.plugin.appbrand.page.web_renderingcache.b.hGX);
    a(new a() {}, bk.hGX);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.a.hGX);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.c.hGX);
    a(new a() {}, com.tencent.mm.plugin.appbrand.config.a.a.hGX);
    a(new a() {}, com.tencent.mm.plugin.appbrand.ui.c.a.b.hGX);
    a(s.a.kcj, s.hGX);
    jGf = new HashMap();
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
      synchronized (jGf)
      {
        paramClass = jGf.get(paramClass);
        AppMethodBeat.o(44087);
        return paramClass;
        bool = false;
      }
    }
  }
  
  private static void a(a parama, String[] paramArrayOfString)
  {
    AppMethodBeat.i(44084);
    jGe.put(parama, paramArrayOfString);
    AppMethodBeat.o(44084);
  }
  
  static void a(com.tencent.mm.sdk.e.e parame)
  {
    AppMethodBeat.i(44085);
    synchronized (jGf)
    {
      jGf.clear();
      Iterator localIterator = jGe.keySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject = ((a)localIterator.next()).b(parame);
        jGf.put(localObject.getClass(), localObject);
      }
    }
    AppMethodBeat.o(44085);
  }
  
  static void aYR()
  {
    AppMethodBeat.i(44086);
    synchronized (jGf)
    {
      jGf.clear();
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