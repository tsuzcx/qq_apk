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

final class b
{
  static final Map<a, String[]> iJo;
  private static final Map<Class, Object> iJp;
  
  static
  {
    AppMethodBeat.i(44088);
    iJo = new HashMap();
    a(new a() {}, t.gLs);
    a(new a() {}, ag.gLs);
    a(new a() {}, n.gLs);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.b.e.e.gLs);
    a(new a() {}, an.gLs);
    a(new a() {}, k.gLs);
    a(new a() {}, h.gLs);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.b.e.d.gLs);
    a(new a() {}, al.gLs);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.b.e.b.gLs);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appusage.a.b.gLs);
    a(new a() {}, u.gLs);
    a(new a() {}, com.tencent.mm.plugin.appbrand.backgroundfetch.d.gLs);
    a(new a() {}, g.gLs);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.b.d.a.gLs);
    a(new a() {}, ah.gLs);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appstorage.b.gLs);
    a(new a() {}, aw.gLs);
    a(new a() {}, com.tencent.mm.plugin.appbrand.page.web_renderingcache.b.gLs);
    a(new a() {}, bi.gLs);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.a.gLs);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.c.gLs);
    a(new a() {}, com.tencent.mm.plugin.appbrand.config.a.a.gLs);
    a(new a() {}, com.tencent.mm.plugin.appbrand.ui.c.a.b.gLs);
    iJp = new HashMap();
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
      synchronized (iJp)
      {
        paramClass = iJp.get(paramClass);
        AppMethodBeat.o(44087);
        return paramClass;
        bool = false;
      }
    }
  }
  
  private static void a(a parama, String[] paramArrayOfString)
  {
    AppMethodBeat.i(44084);
    iJo.put(parama, paramArrayOfString);
    AppMethodBeat.o(44084);
  }
  
  static void a(com.tencent.mm.sdk.e.e parame)
  {
    AppMethodBeat.i(44085);
    synchronized (iJp)
    {
      iJp.clear();
      Iterator localIterator = iJo.keySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject = ((a)localIterator.next()).b(parame);
        iJp.put(localObject.getClass(), localObject);
      }
    }
    AppMethodBeat.o(44085);
  }
  
  static void aOm()
  {
    AppMethodBeat.i(44086);
    synchronized (iJp)
    {
      iJp.clear();
      AppMethodBeat.o(44086);
      return;
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract T b(com.tencent.mm.sdk.e.e parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.b
 * JD-Core Version:    0.7.0.1
 */