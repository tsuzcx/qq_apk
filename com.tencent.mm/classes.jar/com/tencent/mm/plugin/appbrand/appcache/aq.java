package com.tencent.mm.plugin.appbrand.appcache;

import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.u.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class aq
{
  private static final Map<com.tencent.mm.plugin.appbrand.i, aq> fEv = new HashMap();
  private static final aq fEw = new aq.1();
  private final o fEx;
  private final LinkedList<i> fEy = new LinkedList();
  private final String mAppId;
  
  private aq(com.tencent.mm.plugin.appbrand.i parami)
  {
    if (parami == null)
    {
      this.fEx = null;
      this.mAppId = null;
      return;
    }
    this.mAppId = parami.mAppId;
    this.fEx = new o(parami.ZB().fPS);
    this.fEx.abK();
    com.tencent.mm.plugin.appbrand.g.a(this.mAppId, new aq.2(this, parami));
  }
  
  public static String a(com.tencent.mm.plugin.appbrand.i parami, String paramString)
  {
    return bk.pm((String)m(parami).f(paramString, String.class));
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.i arg0, i parami1)
  {
    aq localaq = m(???);
    synchronized (localaq.fEy)
    {
      parami1.init();
      localaq.fEy.addFirst(parami1);
      return;
    }
  }
  
  public static boolean b(com.tencent.mm.plugin.appbrand.i parami, String paramString)
  {
    parami = d(parami, paramString);
    if (parami != null)
    {
      bk.b(parami);
      return true;
    }
    return false;
  }
  
  public static WebResourceResponse c(com.tencent.mm.plugin.appbrand.i parami, String paramString)
  {
    return (WebResourceResponse)m(parami).f(paramString, WebResourceResponse.class);
  }
  
  public static InputStream d(com.tencent.mm.plugin.appbrand.i parami, String paramString)
  {
    return (InputStream)m(parami).f(paramString, InputStream.class);
  }
  
  public static String e(com.tencent.mm.plugin.appbrand.i parami, String paramString)
  {
    if (rg(paramString)) {
      return null;
    }
    parami = parami.Zl();
    if ((parami instanceof m))
    {
      parami = ((IWxaFileSystemWithModularizing)((m)parami).H(IWxaFileSystemWithModularizing.class)).findAppropriateModuleInfo(paramString);
      if (parami != null) {
        return q.a(parami, paramString);
      }
    }
    return null;
  }
  
  public static void k(com.tencent.mm.plugin.appbrand.i parami)
  {
    parami = m(parami);
    if ((parami != null) && (parami.fEx != null)) {
      parami.fEx.abK();
    }
  }
  
  public static o l(com.tencent.mm.plugin.appbrand.i parami)
  {
    return m(parami).fEx;
  }
  
  private static aq m(com.tencent.mm.plugin.appbrand.i parami)
  {
    if (parami == null) {
      return fEw;
    }
    synchronized (fEv)
    {
      aq localaq2 = (aq)fEv.get(parami);
      aq localaq1 = localaq2;
      if (localaq2 == null)
      {
        localaq1 = new aq(parami);
        fEv.put(parami, localaq1);
      }
      return localaq1;
    }
  }
  
  private static boolean rg(String paramString)
  {
    if (bk.bl(paramString)) {}
    while ((com.tencent.luggage.j.g.n(paramString, "about:blank")) || (d.wD(paramString)) || (URLUtil.isFileUrl(paramString))) {
      return true;
    }
    return false;
  }
  
  private InputStream rh(String paramString)
  {
    synchronized (this.fEy)
    {
      Iterator localIterator = this.fEy.iterator();
      while (localIterator.hasNext())
      {
        InputStream localInputStream = ((i)localIterator.next()).openRead(paramString);
        if (localInputStream != null) {
          return localInputStream;
        }
      }
      ??? = this.fEx.findAppropriateModuleInfo(paramString);
      if (??? == null) {
        return null;
      }
    }
    return ((ai)???).rb(paramString);
  }
  
  protected <T> T f(String paramString, Class<T> paramClass)
  {
    if (rg(paramString)) {
      return null;
    }
    paramString = com.tencent.mm.plugin.appbrand.appstorage.i.rA(paramString);
    if (paramString.startsWith("/__APP__")) {
      paramString = com.tencent.mm.plugin.appbrand.appstorage.i.rA(paramString.substring(8));
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      Object localObject = rh(paramString);
      if (localObject != null) {}
      for (localObject = ((aq.b)aq.b.a.fEA.get(paramClass)).c(paramString, (InputStream)localObject);; localObject = null)
      {
        String str = this.mAppId;
        if (localObject == null) {}
        for (boolean bool = true;; bool = false)
        {
          y.i("MicroMsg.WxaPkgRuntimeReader", "openRead, appId = %s, reqURL = %s, null(%B), type = %s, cost = %dms", new Object[] { str, paramString, Boolean.valueOf(bool), paramClass.getName(), Long.valueOf(System.currentTimeMillis() - l) });
          return localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aq
 * JD-Core Version:    0.7.0.1
 */