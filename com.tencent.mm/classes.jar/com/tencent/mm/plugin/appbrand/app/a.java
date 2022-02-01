package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.b.e.h;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.bk;
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
  static final Map<a, String[]> jDg;
  private static final Map<Class, Object> jDh;
  
  static
  {
    AppMethodBeat.i(44088);
    jDg = new HashMap();
    a(new a() {}, t.hEf);
    a(new a() {}, ah.hEf);
    a(new a() {}, n.hEf);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.b.e.e.hEf);
    a(new a() {}, ao.hEf);
    a(new a() {}, k.hEf);
    a(new a.22(), h.hEf);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.b.e.d.hEf);
    a(new a() {}, am.hEf);
    a(new a.2(), com.tencent.mm.plugin.appbrand.appcache.b.e.b.hEf);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appusage.a.b.hEf);
    a(new a() {}, u.hEf);
    a(new a() {}, com.tencent.mm.plugin.appbrand.backgroundfetch.d.hEf);
    a(new a() {}, g.hEf);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.b.d.a.hEf);
    a(new a() {}, ai.hEf);
    a(new a.9(), com.tencent.mm.plugin.appbrand.appstorage.b.hEf);
    a(new a() {}, az.hEf);
    a(new a() {}, com.tencent.mm.plugin.appbrand.page.web_renderingcache.b.hEf);
    a(new a() {}, bj.hEf);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.a.hEf);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.c.hEf);
    a(new a() {}, com.tencent.mm.plugin.appbrand.config.a.a.hEf);
    a(new a() {}, com.tencent.mm.plugin.appbrand.ui.c.a.b.hEf);
    a(s.a.jYS, s.hEf);
    jDh = new HashMap();
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
      synchronized (jDh)
      {
        paramClass = jDh.get(paramClass);
        AppMethodBeat.o(44087);
        return paramClass;
        bool = false;
      }
    }
  }
  
  private static void a(a parama, String[] paramArrayOfString)
  {
    AppMethodBeat.i(44084);
    jDg.put(parama, paramArrayOfString);
    AppMethodBeat.o(44084);
  }
  
  static void a(com.tencent.mm.sdk.e.e parame)
  {
    AppMethodBeat.i(44085);
    synchronized (jDh)
    {
      jDh.clear();
      Iterator localIterator = jDg.keySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject = ((a)localIterator.next()).b(parame);
        jDh.put(localObject.getClass(), localObject);
      }
    }
    AppMethodBeat.o(44085);
  }
  
  static void aYw()
  {
    AppMethodBeat.i(44086);
    synchronized (jDh)
    {
      jDh.clear();
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