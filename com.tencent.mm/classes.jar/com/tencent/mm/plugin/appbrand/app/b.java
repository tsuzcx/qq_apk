package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appcache.bk;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.e;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.h;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.appusage.n;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.backgroundfetch.g;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.config.v.a;
import com.tencent.mm.plugin.appbrand.launching.ar;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class b
{
  static final Map<a, String[]> kHX;
  private static final Map<Class, Object> kHY;
  
  static
  {
    AppMethodBeat.i(44088);
    kHX = new HashMap();
    a(new a() {}, t.iBh);
    a(new a() {}, ai.iBh);
    a(new a() {}, n.iBh);
    a(new a() {}, e.iBh);
    a(new a() {}, ap.iBh);
    a(new a() {}, k.iBh);
    a(new a() {}, h.iBh);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.predownload.e.d.iBh);
    a(new a() {}, an.iBh);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.predownload.e.b.iBh);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appusage.a.b.iBh);
    a(new a() {}, u.iBh);
    a(new a() {}, com.tencent.mm.plugin.appbrand.backgroundfetch.d.iBh);
    a(new a() {}, g.iBh);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.iBh);
    a(new a() {}, aj.iBh);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appstorage.b.iBh);
    a(new a() {}, ar.iBh);
    a(new a() {}, com.tencent.mm.plugin.appbrand.page.web_renderingcache.b.iBh);
    a(new a() {}, bk.iBh);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.a.iBh);
    a(new a() {}, com.tencent.mm.plugin.appbrand.appcache.c.iBh);
    a(new a() {}, com.tencent.mm.plugin.appbrand.config.a.a.iBh);
    a(new a() {}, com.tencent.mm.plugin.appbrand.ui.c.a.b.iBh);
    a(v.a.lfO, v.iBh);
    kHY = new HashMap();
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
      synchronized (kHY)
      {
        paramClass = kHY.get(paramClass);
        AppMethodBeat.o(44087);
        return paramClass;
        bool = false;
      }
    }
  }
  
  private static void a(a parama, String[] paramArrayOfString)
  {
    AppMethodBeat.i(44084);
    kHX.put(parama, paramArrayOfString);
    AppMethodBeat.o(44084);
  }
  
  static void a(ISQLiteDatabase paramISQLiteDatabase)
  {
    AppMethodBeat.i(44085);
    synchronized (kHY)
    {
      kHY.clear();
      Iterator localIterator = kHX.keySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject = ((a)localIterator.next()).b(paramISQLiteDatabase);
        kHY.put(localObject.getClass(), localObject);
      }
    }
    AppMethodBeat.o(44085);
  }
  
  static void buh()
  {
    AppMethodBeat.i(44086);
    synchronized (kHY)
    {
      kHY.clear();
      AppMethodBeat.o(44086);
      return;
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract T b(ISQLiteDatabase paramISQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.b
 * JD-Core Version:    0.7.0.1
 */