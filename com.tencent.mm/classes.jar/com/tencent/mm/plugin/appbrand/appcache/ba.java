package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ba
{
  private static volatile ba gXa = null;
  private final Map<String, Map<ba.a, Boolean>> gXb;
  public final ap gXc;
  
  public ba()
  {
    AppMethodBeat.i(59528);
    this.gXb = new android.support.v4.e.a();
    this.gXc = new ap();
    AppMethodBeat.o(59528);
  }
  
  static void a(String paramString, WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    AppMethodBeat.i(59536);
    ab.i("MicroMsg.AppBrandWxaPkgUpdater", "hy: urlkey: %s, onProgressUpdate %s", new Object[] { paramString, paramWxaPkgLoadProgress });
    Object localObject = yJ(paramString);
    if (localObject != null)
    {
      paramString = ((Map)localObject).keySet().iterator();
      while (paramString.hasNext())
      {
        localObject = (ba.a)paramString.next();
        if (localObject != null) {
          ((ba.a)localObject).ba(paramWxaPkgLoadProgress);
        }
      }
      AppMethodBeat.o(59536);
      return;
    }
    ab.d("MicroMsg.AppBrandWxaPkgUpdater", "callback progress, null callback urlKey = %s", new Object[] { paramString });
    AppMethodBeat.o(59536);
  }
  
  static void a(String paramString, ba.a parama)
  {
    AppMethodBeat.i(59532);
    Object localObject;
    if ((!bo.isNullOrNil(paramString)) && (parama != null))
    {
      localObject = awi();
      if (localObject != null) {}
    }
    else
    {
      AppMethodBeat.o(59532);
      return;
    }
    try
    {
      Map localMap = (Map)((ba)localObject).gXb.get(paramString);
      localObject = localMap;
      if (localMap == null)
      {
        localObject = new HashMap();
        awi().gXb.put(paramString, localObject);
      }
      ((Map)localObject).put(parama, Boolean.TRUE);
      return;
    }
    finally
    {
      AppMethodBeat.o(59532);
    }
  }
  
  static void a(String paramString1, String paramString2, b.a.a parama)
  {
    AppMethodBeat.i(59543);
    if (awi() == null)
    {
      ab.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadFail, get instance null !!!");
      AppMethodBeat.o(59543);
      return;
    }
    a(paramString1, paramString2, parama, null);
    AppMethodBeat.o(59543);
  }
  
  static void a(String paramString1, String paramString2, b.a.a parama, ba.b paramb)
  {
    AppMethodBeat.i(59542);
    paramString1 = yI(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.keySet().iterator();
      while (paramString1.hasNext())
      {
        ba.a locala = (ba.a)paramString1.next();
        if (locala != null) {
          locala.a(paramString2, parama, paramb);
        }
      }
      AppMethodBeat.o(59542);
      return;
    }
    ab.d("MicroMsg.AppBrandWxaPkgUpdater", "callback, null callback appId = %s", new Object[] { paramString2 });
    AppMethodBeat.o(59542);
  }
  
  static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, z.a parama)
  {
    AppMethodBeat.i(59544);
    boolean bool = j.a.kQ(paramInt2);
    if (awi() == null)
    {
      ab.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, get instance null !!!");
      AppMethodBeat.o(59544);
      return;
    }
    if (bo.isNullOrNil(paramString3))
    {
      ab.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, filePath is null or nil");
      a(paramString1, paramString2, b.a.a.gXn, null);
      parama.avl();
      AppMethodBeat.o(59544);
      return;
    }
    if (!new File(paramString3).exists())
    {
      ab.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg file not exists");
      a(paramString1, paramString2, b.a.a.gXn, null);
      parama.avl();
      AppMethodBeat.o(59544);
      return;
    }
    if (((d)com.tencent.mm.kernel.g.E(d.class)).we() == null)
    {
      ab.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, WxaPkgStorage is null");
      bu(paramString1, paramString2);
      AppMethodBeat.o(59544);
      return;
    }
    if (!bool) {}
    Object localObject;
    for (int i = paramInt1;; i = 1)
    {
      localObject = ((d)com.tencent.mm.kernel.g.E(d.class)).we().a(paramString2, i, paramInt2, new String[0]);
      if (localObject != null) {
        break;
      }
      ab.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, no manifest record!!! with given appId(%s) version(%d) debugType(%d)", new Object[] { paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      a(paramString1, paramString2, b.a.a.gXm, null);
      AppMethodBeat.o(59544);
      return;
    }
    parama.avm();
    if (!bo.isNullOrNil(paramString2)) {
      if (paramString2.endsWith("__CODELIB__")) {
        bool = true;
      }
    }
    for (;;)
    {
      parama.dG(bool);
      if (bool) {
        break;
      }
      e.deleteFile(paramString3);
      a(paramString1, paramString2, b.a.a.gXp, null);
      AppMethodBeat.o(59544);
      return;
      File localFile = new File(paramString3);
      localObject = ((at)localObject).field_versionMd5;
      if (!bool)
      {
        String str = com.tencent.mm.a.g.r(localFile);
        if (!bo.nullAsNil((String)localObject).equals(str))
        {
          ab.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, record.md5(%s) != file.md5(%s)", new Object[] { localObject, str });
          bool = false;
          continue;
        }
      }
      localObject = new ao(localFile);
      if (!((ao)localObject).gVO)
      {
        ((ao)localObject).close();
        ab.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg invalid");
        localFile.delete();
        bool = false;
      }
      else if (!((ao)localObject).avO())
      {
        ((ao)localObject).close();
        ab.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg readInfo failed");
        localFile.delete();
        bool = false;
      }
      else
      {
        ((ao)localObject).close();
        bool = true;
        continue;
        bool = false;
      }
    }
    ab.i("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", new Object[] { Boolean.valueOf(((d)com.tencent.mm.kernel.g.E(d.class)).we().d(paramString2, paramInt2, i, paramString3)), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString3 });
    a(paramString1, paramString2, b.a.a.gXl, new ba.b(paramString2, paramString3, paramInt1, paramInt2));
    AppMethodBeat.o(59544);
  }
  
  static boolean a(com.tencent.mm.plugin.appbrand.appcache.a.a parama, ba.a parama1)
  {
    AppMethodBeat.i(59537);
    if (awi() == null)
    {
      ab.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
      AppMethodBeat.o(59537);
      return false;
    }
    if (parama == null)
    {
      AppMethodBeat.o(59537);
      return false;
    }
    a(parama.vMK, parama1);
    int i = awi().gXc.b(parama);
    if ((i != 0) && (i != 2))
    {
      a(parama.vMK, parama.appId, b.a.a.gXs, null);
      AppMethodBeat.o(59537);
      return false;
    }
    AppMethodBeat.o(59537);
    return true;
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, ba.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(59538);
    if (awi() == null)
    {
      ab.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
      AppMethodBeat.o(59538);
      return false;
    }
    Object localObject1;
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2))) {
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      localObject1 = localObject2;
      if (localObject1 != null) {
        break label346;
      }
      ab.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, create Null request, appId %s, pkgType %d, pkgVersion %d, url %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
      AppMethodBeat.o(59538);
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
        localObject1 = new bc(paramString2, paramString1, paramInt2, paramInt1);
        break;
      case 0: 
      case 12: 
      case 13: 
      case 14: 
        localObject1 = new aq(paramString1, paramInt1, paramInt2, paramString2);
        break;
      case 1: 
      case 2: 
      case 999: 
        localObject1 = new ak(paramString1, paramString2, paramInt1);
      }
    }
    if ("@LibraryAppId".equals(paramString1)) {
      bool = false;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.appcache.a.a)localObject1).gXk = bool;
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
    AppMethodBeat.o(59538);
    return bool;
  }
  
  public static boolean a(String paramString, int paramInt, ba.a parama)
  {
    AppMethodBeat.i(59531);
    boolean bool = b("@LibraryAppId", 0, paramInt, paramString, parama);
    AppMethodBeat.o(59531);
    return bool;
  }
  
  public static boolean a(String paramString1, int paramInt, String paramString2, ba.a parama)
  {
    AppMethodBeat.i(59540);
    boolean bool = b(paramString1, paramInt, 1, paramString2, parama);
    AppMethodBeat.o(59540);
    return bool;
  }
  
  public static boolean a(String paramString1, int paramInt, String paramString2, ba.a parama, a.a parama1)
  {
    AppMethodBeat.i(59541);
    if (awi() == null)
    {
      ab.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadDebugPkg with keyGen, get null updater instance!!!");
      AppMethodBeat.o(59541);
      return false;
    }
    boolean bool = a(new ak(paramString1, paramString2, paramInt, parama1), parama);
    AppMethodBeat.o(59541);
    return bool;
  }
  
  public static ba awi()
  {
    AppMethodBeat.i(59529);
    if (((d)com.tencent.mm.kernel.g.E(d.class)).we() == null)
    {
      gXa = null;
      AppMethodBeat.o(59529);
      return null;
    }
    if (gXa == null) {}
    try
    {
      if (gXa == null) {
        gXa = new ba();
      }
      ba localba = gXa;
      AppMethodBeat.o(59529);
      return localba;
    }
    finally
    {
      AppMethodBeat.o(59529);
    }
  }
  
  public static boolean b(String paramString1, int paramInt1, int paramInt2, String paramString2, ba.a parama)
  {
    AppMethodBeat.i(59539);
    boolean bool = a(paramString1, paramInt1, paramInt2, 0, paramString2, parama);
    AppMethodBeat.o(59539);
    return bool;
  }
  
  static void bu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(59535);
    a(paramString1, paramString2, b.a.a.gXs, null);
    AppMethodBeat.o(59535);
  }
  
  public static void shutdown()
  {
    AppMethodBeat.i(59530);
    try
    {
      ba localba = gXa;
      gXa = null;
      if (localba != null) {
        localba.gXc.gVX.shutdown();
      }
      AppMethodBeat.o(59530);
      return;
    }
    finally
    {
      AppMethodBeat.o(59530);
    }
  }
  
  static Map<ba.a, Boolean> yI(String paramString)
  {
    AppMethodBeat.i(59533);
    ba localba;
    if (!bo.isNullOrNil(paramString))
    {
      localba = awi();
      if (localba != null) {}
    }
    else
    {
      AppMethodBeat.o(59533);
      return null;
    }
    try
    {
      paramString = (Map)localba.gXb.remove(paramString);
      return paramString;
    }
    finally
    {
      AppMethodBeat.o(59533);
    }
  }
  
  private static Map<ba.a, Boolean> yJ(String paramString)
  {
    AppMethodBeat.i(59534);
    Object localObject;
    if (!bo.isNullOrNil(paramString))
    {
      localObject = awi();
      if (localObject != null) {}
    }
    else
    {
      AppMethodBeat.o(59534);
      return null;
    }
    try
    {
      localObject = (Map)((ba)localObject).gXb.get(paramString);
      paramString = (String)localObject;
      if (localObject != null) {
        paramString = new HashMap((Map)localObject);
      }
      return paramString;
    }
    finally
    {
      AppMethodBeat.o(59534);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ba
 * JD-Core Version:    0.7.0.1
 */