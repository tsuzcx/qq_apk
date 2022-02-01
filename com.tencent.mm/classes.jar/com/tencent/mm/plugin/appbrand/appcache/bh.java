package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.pluginsdk.h.a.c.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class bh
{
  private static volatile bh iOM = null;
  private final Map<String, Map<a, Boolean>> iON;
  public final ax iOO;
  
  public bh()
  {
    AppMethodBeat.i(90644);
    this.iON = new android.support.v4.e.a();
    this.iOO = new ax();
    AppMethodBeat.o(90644);
  }
  
  static Map<a, Boolean> En(String paramString)
  {
    AppMethodBeat.i(90649);
    paramString = ae(paramString, true);
    AppMethodBeat.o(90649);
    return paramString;
  }
  
  private static Map<a, Boolean> Eo(String paramString)
  {
    AppMethodBeat.i(90651);
    Object localObject;
    if (!bt.isNullOrNil(paramString))
    {
      localObject = aQy();
      if (localObject != null) {}
    }
    else
    {
      AppMethodBeat.o(90651);
      return null;
    }
    try
    {
      localObject = (Map)((bh)localObject).iON.get(paramString);
      paramString = (String)localObject;
      if (localObject != null) {
        paramString = new HashMap((Map)localObject);
      }
      return paramString;
    }
    finally
    {
      AppMethodBeat.o(90651);
    }
  }
  
  static void a(String paramString, WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    AppMethodBeat.i(90653);
    ad.i("MicroMsg.AppBrand.WxaPkgUpdater", "hy: urlkey: %s, onProgressUpdate %s", new Object[] { paramString, paramWxaPkgLoadProgress });
    Object localObject = Eo(paramString);
    if (localObject != null)
    {
      paramString = ((Map)localObject).keySet().iterator();
      while (paramString.hasNext())
      {
        localObject = (a)paramString.next();
        if (localObject != null) {
          ((a)localObject).ci(paramWxaPkgLoadProgress);
        }
      }
      AppMethodBeat.o(90653);
      return;
    }
    ad.d("MicroMsg.AppBrand.WxaPkgUpdater", "callback progress, null callback urlKey = %s", new Object[] { paramString });
    AppMethodBeat.o(90653);
  }
  
  static void a(String paramString, a parama)
  {
    AppMethodBeat.i(90648);
    Object localObject;
    if ((!bt.isNullOrNil(paramString)) && (parama != null))
    {
      localObject = aQy();
      if (localObject != null) {}
    }
    else
    {
      AppMethodBeat.o(90648);
      return;
    }
    try
    {
      Map localMap = (Map)((bh)localObject).iON.get(paramString);
      localObject = localMap;
      if (localMap == null)
      {
        localObject = new HashMap();
        aQy().iON.put(paramString, localObject);
      }
      ((Map)localObject).put(parama, Boolean.TRUE);
      return;
    }
    finally
    {
      AppMethodBeat.o(90648);
    }
  }
  
  static void a(String paramString1, String paramString2, b.a.a parama)
  {
    AppMethodBeat.i(90660);
    if (aQy() == null)
    {
      ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadFail, get instance null !!!");
      AppMethodBeat.o(90660);
      return;
    }
    a(paramString1, paramString2, parama, null);
    AppMethodBeat.o(90660);
  }
  
  static void a(String paramString1, String paramString2, b.a.a parama, b paramb)
  {
    AppMethodBeat.i(90659);
    paramString1 = ae(paramString1, false);
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
      AppMethodBeat.o(90659);
      return;
    }
    ad.d("MicroMsg.AppBrand.WxaPkgUpdater", "callback, null callback appId = %s", new Object[] { paramString2 });
    AppMethodBeat.o(90659);
  }
  
  static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, ac.a parama)
  {
    AppMethodBeat.i(90661);
    boolean bool = j.a.nz(paramInt2);
    if (aQy() == null)
    {
      ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, get instance null !!!");
      AppMethodBeat.o(90661);
      return;
    }
    if (bt.isNullOrNil(paramString3))
    {
      ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, filePath is null or nil");
      a(paramString1, paramString2, b.a.a.iPu, null);
      parama.aPm();
      AppMethodBeat.o(90661);
      return;
    }
    if (!new com.tencent.mm.vfs.e(paramString3).exists())
    {
      ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, pkg file not exists");
      a(paramString1, paramString2, b.a.a.iPu, null);
      parama.aPm();
      AppMethodBeat.o(90661);
      return;
    }
    if (((com.tencent.mm.plugin.appbrand.a.e)g.ab(com.tencent.mm.plugin.appbrand.a.e.class)).aOk() == null)
    {
      ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, WxaPkgStorage is null");
      bU(paramString1, paramString2);
      AppMethodBeat.o(90661);
      return;
    }
    if (!bool) {}
    Object localObject2;
    for (int i = paramInt1;; i = 1)
    {
      localObject2 = ((com.tencent.mm.plugin.appbrand.a.e)g.ab(com.tencent.mm.plugin.appbrand.a.e.class)).aOk().a(paramString2, i, paramInt2, new String[0]);
      if (localObject2 != null) {
        break;
      }
      ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, no manifest record!!! with given appId(%s) version(%d) debugType(%d)", new Object[] { paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      a(paramString1, paramString2, b.a.a.iPt, null);
      AppMethodBeat.o(90661);
      return;
    }
    parama.aPn();
    if (!bt.isNullOrNil(paramString2))
    {
      Object localObject1 = new com.tencent.mm.vfs.e(paramString3);
      localObject2 = ((bb)localObject2).field_versionMd5;
      localObject1 = WxaPkgIntegrityChecker.Eg(q.B(((com.tencent.mm.vfs.e)localObject1).fhU()));
      if (!bt.nullAsNil((String)localObject2).equals(localObject1))
      {
        ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, appId(%s) record.md5(%s) != file.md5(%s)", new Object[] { paramString2, localObject2, localObject1 });
        bool = false;
      }
    }
    for (;;)
    {
      parama.fj(bool);
      if (bool) {
        break;
      }
      i.deleteFile(paramString3);
      a(paramString1, paramString2, b.a.a.iPx, null);
      AppMethodBeat.o(90661);
      return;
      bool = true;
      continue;
      bool = false;
    }
    ad.i("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.appbrand.a.e)g.ab(com.tencent.mm.plugin.appbrand.a.e.class)).aOk().d(paramString2, paramInt2, i, paramString3)), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString3 });
    a(paramString1, paramString2, b.a.a.iPs, new b(paramString2, paramString3, paramInt1, paramInt2));
    AppMethodBeat.o(90661);
  }
  
  static boolean a(com.tencent.mm.plugin.appbrand.appcache.a.a parama, a parama1)
  {
    AppMethodBeat.i(90654);
    if (aQy() == null)
    {
      ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
      AppMethodBeat.o(90654);
      return false;
    }
    if (parama == null)
    {
      AppMethodBeat.o(90654);
      return false;
    }
    a(parama.BRL, parama1);
    int i = aQy().iOO.b(parama);
    if ((i != 0) && (i != 2))
    {
      a(parama.BRL, parama.appId, b.a.a.iPA, null);
      AppMethodBeat.o(90654);
      return false;
    }
    AppMethodBeat.o(90654);
    return true;
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(90655);
    if (aQy() == null)
    {
      ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
      AppMethodBeat.o(90655);
      return false;
    }
    Object localObject1;
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2))) {
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      localObject1 = localObject2;
      if (localObject1 != null) {
        break label346;
      }
      ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadPkg, create Null request, appId %s, pkgType %d, pkgVersion %d, url %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
      AppMethodBeat.o(90655);
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
        localObject1 = new bn(paramString2, paramString1, paramInt2, paramInt1);
        break;
      case 0: 
      case 6: 
      case 12: 
      case 13: 
        localObject1 = new ay(paramString1, paramInt1, paramInt2, paramString2);
        break;
      case 1: 
      case 2: 
      case 999: 
        localObject1 = new at(paramString1, paramString2, paramInt1);
      }
    }
    if ("@LibraryAppId".equals(paramString1)) {
      bool = false;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.appcache.a.a)localObject1).iPr = bool;
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
    label346:
    boolean bool = a((com.tencent.mm.plugin.appbrand.appcache.a.a)localObject1, parama);
    AppMethodBeat.o(90655);
    return bool;
  }
  
  public static boolean a(String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(90647);
    boolean bool = b("@LibraryAppId", 0, paramInt, paramString, parama);
    AppMethodBeat.o(90647);
    return bool;
  }
  
  public static boolean a(String paramString1, int paramInt, String paramString2, a parama)
  {
    AppMethodBeat.i(90657);
    boolean bool = b(paramString1, paramInt, 1, paramString2, parama);
    AppMethodBeat.o(90657);
    return bool;
  }
  
  public static boolean a(String paramString1, int paramInt, String paramString2, a parama, a.a parama1)
  {
    AppMethodBeat.i(90658);
    if (aQy() == null)
    {
      ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadDebugPkg with keyGen, get null updater instance!!!");
      AppMethodBeat.o(90658);
      return false;
    }
    boolean bool = a(new at(paramString1, paramString2, paramInt, parama1), parama);
    AppMethodBeat.o(90658);
    return bool;
  }
  
  public static bh aQy()
  {
    AppMethodBeat.i(90645);
    if (((com.tencent.mm.plugin.appbrand.a.e)g.ab(com.tencent.mm.plugin.appbrand.a.e.class)).aOk() == null)
    {
      iOM = null;
      AppMethodBeat.o(90645);
      return null;
    }
    if (iOM == null) {}
    try
    {
      if (iOM == null) {
        iOM = new bh();
      }
      bh localbh = iOM;
      AppMethodBeat.o(90645);
      return localbh;
    }
    finally
    {
      AppMethodBeat.o(90645);
    }
  }
  
  private static Map<a, Boolean> ae(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(90650);
    bh localbh;
    if (!bt.isNullOrNil(paramString))
    {
      localbh = aQy();
      if (localbh != null) {}
    }
    else
    {
      AppMethodBeat.o(90650);
      return null;
    }
    if (paramBoolean) {
      ad.i("MicroMsg.AppBrand.WxaPkgUpdater", "removeCallbacks, key[%s]", new Object[] { paramString });
    }
    try
    {
      paramString = (Map)localbh.iON.remove(paramString);
      return paramString;
    }
    finally
    {
      AppMethodBeat.o(90650);
    }
  }
  
  public static boolean b(String paramString1, int paramInt1, int paramInt2, String paramString2, a parama)
  {
    AppMethodBeat.i(90656);
    boolean bool = a(paramString1, paramInt1, paramInt2, 0, paramString2, parama);
    AppMethodBeat.o(90656);
    return bool;
  }
  
  static void bU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90652);
    a(paramString1, paramString2, b.a.a.iPA, null);
    AppMethodBeat.o(90652);
  }
  
  public static void shutdown()
  {
    AppMethodBeat.i(90646);
    try
    {
      bh localbh = iOM;
      iOM = null;
      if (localbh != null) {
        localbh.iOO.iNG.shutdown();
      }
      AppMethodBeat.o(90646);
      return;
    }
    finally
    {
      AppMethodBeat.o(90646);
    }
  }
  
  public static abstract interface a
    extends b.a<bh.b, WxaPkgLoadProgress>
  {}
  
  public static final class b
  {
    public final String appId;
    public final String filePath;
    public final int iOP;
    public final int version;
    
    public b(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      this.appId = paramString1;
      this.filePath = paramString2;
      this.version = paramInt1;
      this.iOP = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bh
 * JD-Core Version:    0.7.0.1
 */