package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class at
{
  private static volatile at fEI = null;
  private final Map<String, Map<a, Boolean>> fEJ = new android.support.v4.f.a();
  public final aj fEK = new aj();
  
  static void a(String paramString, WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    y.i("MicroMsg.AppBrandWxaPkgUpdater", "hy: urlkey: %s, onProgressUpdate %s", new Object[] { paramString, paramWxaPkgLoadProgress });
    Object localObject = rm(paramString);
    if (localObject != null)
    {
      paramString = ((Map)localObject).keySet().iterator();
      while (paramString.hasNext())
      {
        localObject = (a)paramString.next();
        if (localObject != null) {
          ((a)localObject).aH(paramWxaPkgLoadProgress);
        }
      }
    }
    y.d("MicroMsg.AppBrandWxaPkgUpdater", "callback progress, null callback urlKey = %s", new Object[] { paramString });
  }
  
  static void a(String paramString1, String paramString2, b.a.a parama)
  {
    if (acr() == null)
    {
      y.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadFail, get instance null !!!");
      return;
    }
    a(paramString1, paramString2, parama, null);
  }
  
  static void a(String paramString1, String paramString2, b.a.a parama, at.b paramb)
  {
    paramString1 = rl(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.keySet().iterator();
      while (paramString1.hasNext())
      {
        a locala = (a)paramString1.next();
        if (locala != null) {
          locala.a(paramString2, parama, paramb);
        }
      }
    }
    y.d("MicroMsg.AppBrandWxaPkgUpdater", "callback, null callback appId = %s", new Object[] { paramString2 });
  }
  
  static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, t.a parama)
  {
    boolean bool = d.a.id(paramInt2);
    if (acr() == null)
    {
      y.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, get instance null !!!");
      return;
    }
    if (bk.bl(paramString3))
    {
      y.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, filePath is null or nil");
      a(paramString1, paramString2, b.a.a.fEV, null);
      parama.abu();
      return;
    }
    if (!new File(paramString3).exists())
    {
      y.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg file not exists");
      a(paramString1, paramString2, b.a.a.fEV, null);
      parama.abu();
      return;
    }
    if (((c)com.tencent.mm.kernel.g.r(c.class)).aaG() == null)
    {
      y.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, WxaPkgStorage is null");
      aY(paramString1, paramString2);
      return;
    }
    if (!bool) {}
    for (int i = paramInt1;; i = 1)
    {
      localObject = ((c)com.tencent.mm.kernel.g.r(c.class)).aaG().a(paramString2, i, paramInt2, new String[0]);
      if (localObject != null) {
        break;
      }
      y.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, no manifest record!!! with given appId(%s) version(%d) debugType(%d)", new Object[] { paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      a(paramString1, paramString2, b.a.a.fEU, null);
      return;
    }
    parama.abv();
    File localFile = new File(paramString3);
    Object localObject = ((an)localObject).field_versionMd5;
    if (!bool)
    {
      String str = com.tencent.mm.a.g.m(localFile);
      if (!bk.pm((String)localObject).equals(str))
      {
        y.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, record.md5(%s) != file.md5(%s)", new Object[] { localObject, str });
        bool = false;
      }
    }
    for (;;)
    {
      parama.cG(bool);
      if (bool) {
        break;
      }
      e.deleteFile(paramString3);
      a(paramString1, paramString2, b.a.a.fEX, null);
      return;
      localObject = new ai(localFile);
      if (!((ai)localObject).fDy)
      {
        ((ai)localObject).close();
        y.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg invalid");
        localFile.delete();
        bool = false;
      }
      else if (!((ai)localObject).abX())
      {
        ((ai)localObject).close();
        y.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg readInfo failed");
        localFile.delete();
        bool = false;
      }
      else
      {
        ((ai)localObject).close();
        bool = true;
      }
    }
    y.i("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", new Object[] { Boolean.valueOf(((c)com.tencent.mm.kernel.g.r(c.class)).aaG().d(paramString2, paramInt2, i, paramString3)), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString3 });
    a(paramString1, paramString2, b.a.a.fET, new at.b(paramString2, paramString3, paramInt1, paramInt2));
  }
  
  static boolean a(com.tencent.mm.plugin.appbrand.appcache.a.a parama, a parama1)
  {
    if (acr() == null) {
      y.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
    }
    while (parama == null) {
      return false;
    }
    b(parama.rVT, parama1);
    int i = acr().fEK.b(parama);
    if ((i != 0) && (i != 2))
    {
      a(parama.rVT, parama.appId, b.a.a.fFa, null);
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, a parama)
  {
    Object localObject2 = null;
    if (acr() == null)
    {
      y.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
      return false;
    }
    Object localObject1;
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      localObject1 = localObject2;
      if (localObject1 != null) {
        break label306;
      }
      y.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, create Null request, appId %s, pkgType %d, pkgVersion %d, url %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
      return false;
      switch (paramInt1)
      {
      default: 
        localObject1 = null;
        break;
      case 10000: 
      case 10001: 
      case 10002: 
      case 10100: 
      case 10101: 
      case 10102: 
        localObject1 = new au(paramString2, paramString1, paramInt2, paramInt1);
        break;
      case 0: 
        localObject1 = new ak(paramString1, paramInt1, paramInt2, paramString2);
        break;
      case 1: 
      case 2: 
      case 999: 
        localObject1 = new ae(paramString1, paramString2, paramInt1);
      }
    }
    boolean bool;
    if ("@LibraryAppId".equals(paramString1)) {
      bool = false;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.appcache.a.a)localObject1).fES = bool;
      if (paramInt3 > 2097152)
      {
        ((com.tencent.mm.plugin.appbrand.appcache.a.a)localObject1).setReadTimeout(((com.tencent.mm.plugin.appbrand.appcache.a.a)localObject1).getReadTimeout() * 2);
        ((com.tencent.mm.plugin.appbrand.appcache.a.a)localObject1).setConnectTimeout(((com.tencent.mm.plugin.appbrand.appcache.a.a)localObject1).getConnectTimeout() * 2);
      }
      break;
      if (paramInt1 != 0) {
        bool = false;
      } else {
        bool = true;
      }
    }
    label306:
    return a((com.tencent.mm.plugin.appbrand.appcache.a.a)localObject1, parama);
  }
  
  public static boolean a(String paramString, int paramInt, a parama)
  {
    return b("@LibraryAppId", 0, paramInt, paramString, parama);
  }
  
  public static boolean a(String paramString1, int paramInt, String paramString2, a parama)
  {
    return b(paramString1, paramInt, 1, paramString2, parama);
  }
  
  public static boolean a(String paramString, a parama)
  {
    return a("@LibraryAppId", 999, paramString, parama);
  }
  
  static void aY(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, b.a.a.fFa, null);
  }
  
  public static at acr()
  {
    if (((c)com.tencent.mm.kernel.g.r(c.class)).aaG() == null)
    {
      fEI = null;
      return null;
    }
    if (fEI == null) {}
    try
    {
      if (fEI == null) {
        fEI = new at();
      }
      return fEI;
    }
    finally {}
  }
  
  static void b(String paramString, a parama)
  {
    Object localObject;
    if ((!bk.bl(paramString)) && (parama != null))
    {
      localObject = acr();
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    try
    {
      Map localMap = (Map)((at)localObject).fEJ.get(paramString);
      localObject = localMap;
      if (localMap == null)
      {
        localObject = new HashMap();
        acr().fEJ.put(paramString, localObject);
      }
      ((Map)localObject).put(parama, Boolean.valueOf(true));
      return;
    }
    finally {}
  }
  
  public static boolean b(String paramString1, int paramInt1, int paramInt2, String paramString2, a parama)
  {
    return a(paramString1, paramInt1, paramInt2, 0, paramString2, parama);
  }
  
  static Map<a, Boolean> rl(String paramString)
  {
    at localat;
    if (!bk.bl(paramString))
    {
      localat = acr();
      if (localat != null) {}
    }
    else
    {
      return null;
    }
    try
    {
      paramString = (Map)localat.fEJ.remove(paramString);
      return paramString;
    }
    finally {}
  }
  
  private static Map<a, Boolean> rm(String paramString)
  {
    at localat;
    if (!bk.bl(paramString))
    {
      localat = acr();
      if (localat != null) {}
    }
    else
    {
      return null;
    }
    try
    {
      paramString = (Map)localat.fEJ.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public static void shutdown()
  {
    try
    {
      at localat = fEI;
      fEI = null;
      if (localat != null) {
        localat.fEK.fDH.shutdown();
      }
      return;
    }
    finally {}
  }
  
  public static abstract interface a
    extends b.a<at.b, WxaPkgLoadProgress>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.at
 * JD-Core Version:    0.7.0.1
 */