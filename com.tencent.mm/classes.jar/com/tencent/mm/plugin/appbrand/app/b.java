package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.br;
import com.tencent.mm.plugin.appbrand.appcache.bs;
import com.tencent.mm.plugin.appbrand.appcache.bx;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.e;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.h;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.appusage.n;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.backgroundfetch.g;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.config.v.a;
import com.tencent.mm.plugin.appbrand.launching.al;
import com.tencent.mm.plugin.appbrand.launching.ar;
import com.tencent.mm.plugin.appbrand.launching.s;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class b
{
  static final Map<a, String[]> nBP;
  private static final Map<Class, Object> nBQ;
  
  static
  {
    AppMethodBeat.i(44088);
    nBP = new HashMap();
    a(new a() {}, s.lqL);
    a(new a() {}, ar.lqL);
    a(new a() {}, aj.lqL);
    a(new a() {}, n.lqL);
    a(new a() {}, e.lqL);
    a(new a() {}, aq.lqL);
    a(new a() {}, k.lqL);
    a(new a() {}, h.lqL);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.predownload.e.d.lqL);
    a(new a() {}, ao.lqL);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.predownload.e.b.lqL);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appusage.a.b.lqL);
    a(new a() {}, u.lqL);
    a(new a() {}, com.tencent.mm.plugin.appbrand.backgroundfetch.d.lqL);
    a(new a() {}, g.lqL);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.lqL);
    a(new a() {}, ak.lqL);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appstorage.b.lqL);
    a(new a() {}, al.lqL);
    a(new a() {}, com.tencent.mm.plugin.appbrand.page.web_renderingcache.b.lqL);
    a(new a() {}, br.lqL);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.a.lqL);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.c.lqL);
    a(new a() {}, com.tencent.mm.plugin.appbrand.config.a.a.lqL);
    a(new a() {}, com.tencent.mm.plugin.appbrand.ui.c.a.b.lqL);
    a(v.a.oao, v.lqL);
    a(new a() {}, bx.lqL);
    nBQ = new HashMap();
    AppMethodBeat.o(44088);
  }
  
  static <T> T W(Class<T> paramClass)
  {
    AppMethodBeat.i(44087);
    boolean bool;
    if (paramClass != null) {
      bool = true;
    }
    for (;;)
    {
      Assert.assertTrue("Cant pass Null class here", bool);
      synchronized (nBQ)
      {
        paramClass = nBQ.get(paramClass);
        AppMethodBeat.o(44087);
        return paramClass;
        bool = false;
      }
    }
  }
  
  private static void a(a parama, String[] paramArrayOfString)
  {
    AppMethodBeat.i(44084);
    nBP.put(parama, paramArrayOfString);
    AppMethodBeat.o(44084);
  }
  
  static void a(ISQLiteDatabase paramISQLiteDatabase)
  {
    AppMethodBeat.i(44085);
    synchronized (nBQ)
    {
      nBQ.clear();
      Iterator localIterator = nBP.keySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject = ((a)localIterator.next()).b(paramISQLiteDatabase);
        nBQ.put(localObject.getClass(), localObject);
      }
    }
    AppMethodBeat.o(44085);
  }
  
  static void bFh()
  {
    AppMethodBeat.i(44086);
    synchronized (nBQ)
    {
      nBQ.clear();
      AppMethodBeat.o(44086);
      return;
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract T b(ISQLiteDatabase paramISQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.b
 * JD-Core Version:    0.7.0.1
 */