package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.br;
import com.tencent.mm.plugin.appbrand.appcache.bs;
import com.tencent.mm.plugin.appbrand.appcache.bw;
import com.tencent.mm.plugin.appbrand.appcache.c;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.l;
import com.tencent.mm.plugin.appbrand.appusage.m;
import com.tencent.mm.plugin.appbrand.backgroundfetch.g;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.aa.a;
import com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.n;
import com.tencent.mm.plugin.appbrand.launching.am;
import com.tencent.mm.plugin.appbrand.launching.at;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class b
{
  static final Map<a, String[]> qBg;
  private static final Map<Class, Object> qBh;
  
  static
  {
    AppMethodBeat.i(44088);
    qBg = new HashMap();
    a(new a() {}, com.tencent.mm.plugin.appbrand.launching.t.nVW);
    a(new a() {}, at.nVW);
    a(new a() {}, ak.nVW);
    a(new a() {}, m.nVW);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.predownload.storage.e.nVW);
    a(new a() {}, ar.nVW);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appusage.j.nVW);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.predownload.storage.j.nVW);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.predownload.storage.d.nVW);
    a(new a() {}, ap.nVW);
    a(new b.3(), com.tencent.mm.plugin.appbrand.appcache.predownload.storage.b.nVW);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appusage.a.b.nVW);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appusage.t.nVW);
    a(new b.6(), com.tencent.mm.plugin.appbrand.backgroundfetch.d.nVW);
    a(new b.7(), g.nVW);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.nVW);
    a(new a() {}, al.nVW);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appstorage.e.nVW);
    a(new a() {}, am.nVW);
    a(new b.13(), com.tencent.mm.plugin.appbrand.page.web_renderingcache.b.nVW);
    a(new a() {}, br.nVW);
    a(new b.15(), com.tencent.mm.plugin.appbrand.appcache.a.nVW);
    a(new a() {}, c.nVW);
    a(new a() {}, com.tencent.mm.plugin.appbrand.config.a.a.nVW);
    a(new a() {}, com.tencent.mm.plugin.appbrand.ui.b.a.b.nVW);
    a(aa.a.rba, aa.nVW);
    a(new a() {}, bw.nVW);
    a(new b.20(), l.nVW);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appstorage.b.b.nVW);
    a(new b.22(), n.nVW);
    qBh = new HashMap();
    AppMethodBeat.o(44088);
  }
  
  private static void a(a parama, String[] paramArrayOfString)
  {
    AppMethodBeat.i(44084);
    qBg.put(parama, paramArrayOfString);
    AppMethodBeat.o(44084);
  }
  
  static void a(ISQLiteDatabase paramISQLiteDatabase)
  {
    AppMethodBeat.i(44085);
    synchronized (qBh)
    {
      qBh.clear();
      Iterator localIterator = qBg.keySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject = ((a)localIterator.next()).b(paramISQLiteDatabase);
        qBh.put(localObject.getClass(), localObject);
      }
    }
    AppMethodBeat.o(44085);
  }
  
  static <T> T ag(Class<T> paramClass)
  {
    AppMethodBeat.i(44087);
    boolean bool;
    if (paramClass != null) {
      bool = true;
    }
    for (;;)
    {
      Assert.assertTrue("Cant pass Null class here", bool);
      synchronized (qBh)
      {
        paramClass = qBh.get(paramClass);
        AppMethodBeat.o(44087);
        return paramClass;
        bool = false;
      }
    }
  }
  
  static void ceu()
  {
    AppMethodBeat.i(44086);
    synchronized (qBh)
    {
      qBh.clear();
      AppMethodBeat.o(44086);
      return;
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract T b(ISQLiteDatabase paramISQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.b
 * JD-Core Version:    0.7.0.1
 */