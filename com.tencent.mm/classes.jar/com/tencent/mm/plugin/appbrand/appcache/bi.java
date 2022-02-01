package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zr;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.z.h;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.Collection;
import java.util.Iterator;

public final class bi
{
  private static volatile bi jIR = null;
  private final h<String, a> jFD;
  public final ay jIS;
  
  public bi()
  {
    AppMethodBeat.i(90644);
    this.jFD = new h();
    this.jIS = new ay();
    AppMethodBeat.o(90644);
  }
  
  static Collection<a> LI(String paramString)
  {
    AppMethodBeat.i(207436);
    paramString = af(paramString, true);
    AppMethodBeat.o(207436);
    return paramString;
  }
  
  static void a(String paramString, WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    AppMethodBeat.i(90653);
    ad.i("MicroMsg.AppBrand.WxaPkgUpdater", "hy: urlkey: %s, onProgressUpdate %s", new Object[] { paramString, paramWxaPkgLoadProgress });
    Object localObject;
    if (!bt.isNullOrNil(paramString))
    {
      localObject = baO();
      if (localObject != null) {}
    }
    else
    {
      localObject = null;
    }
    while (localObject != null)
    {
      paramString = ((Collection)localObject).iterator();
      for (;;)
      {
        if (paramString.hasNext())
        {
          localObject = (a)paramString.next();
          if (localObject != null)
          {
            ((a)localObject).ci(paramWxaPkgLoadProgress);
            continue;
            localObject = ((bi)localObject).jFD.cE(paramString);
            break;
          }
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
    bi localbi;
    if ((!bt.isNullOrNil(paramString)) && (parama != null))
    {
      localbi = baO();
      if (localbi != null) {}
    }
    else
    {
      AppMethodBeat.o(90648);
      return;
    }
    localbi.jFD.j(paramString, parama);
    AppMethodBeat.o(90648);
  }
  
  static void a(String paramString1, String paramString2, b.a.a parama)
  {
    AppMethodBeat.i(90660);
    if (baO() == null)
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
    paramString1 = af(paramString1, false);
    if (paramString1 != null)
    {
      paramString1 = paramString1.iterator();
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
  
  static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, ad.a parama)
  {
    AppMethodBeat.i(90661);
    boolean bool = j.a.oN(paramInt2);
    if (baO() == null)
    {
      ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, get instance null !!!");
      AppMethodBeat.o(90661);
      return;
    }
    if (bt.isNullOrNil(paramString3))
    {
      ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, filePath is null or nil");
      a(paramString1, paramString2, b.a.a.jJy, null);
      parama.aZz();
      AppMethodBeat.o(90661);
      return;
    }
    if (!new com.tencent.mm.vfs.e(paramString3).exists())
    {
      ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, pkg file not exists");
      a(paramString1, paramString2, b.a.a.jJy, null);
      parama.aZz();
      AppMethodBeat.o(90661);
      return;
    }
    if (((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYu() == null)
    {
      ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, WxaPkgStorage is null");
      cf(paramString1, paramString2);
      AppMethodBeat.o(90661);
      return;
    }
    if (!bool) {}
    bc localbc;
    for (int i = paramInt1;; i = 1)
    {
      localbc = ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYu().a(paramString2, i, paramInt2, new String[0]);
      if (localbc != null) {
        break;
      }
      ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, no manifest record!!! with given appId(%s) version(%d) debugType(%d)", new Object[] { paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      a(paramString1, paramString2, b.a.a.jJx, null);
      AppMethodBeat.o(90661);
      return;
    }
    parama.aZA();
    Object localObject;
    String[] arrayOfString;
    int j;
    if (!bt.isNullOrNil(paramString2))
    {
      localObject = new com.tencent.mm.vfs.e(paramString3);
      arrayOfString = new String[2];
      arrayOfString[0] = localbc.field_versionMd5;
      arrayOfString[1] = localbc.field_NewMd5;
      localObject = WxaPkgIntegrityChecker.LB(q.B(((com.tencent.mm.vfs.e)localObject).fOK()));
      j = 0;
      if (j < 2)
      {
        String str = arrayOfString[j];
        if ((!TextUtils.isEmpty(str)) && (str.equals(localObject)))
        {
          ad.i("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete$verifyPkg, appId[%s] verify ok with checksumMd5[%s]", new Object[] { paramString2, str });
          bool = true;
        }
      }
    }
    for (;;)
    {
      parama.fJ(bool);
      if (bool) {
        break label438;
      }
      i.deleteFile(paramString3);
      a(paramString1, paramString2, b.a.a.jJA, null);
      AppMethodBeat.o(90661);
      return;
      j += 1;
      break;
      ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete$verifyPkg, appId[%s] checksumMd5List[%s] != file.md5[%s]", new Object[] { paramString2, org.apache.commons.b.g.a(arrayOfString, ","), localObject });
      bool = false;
      continue;
      bool = false;
    }
    label438:
    ad.i("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYu().e(paramString2, paramInt2, i, paramString3)), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString3 });
    a(paramString1, paramString2, b.a.a.jJw, new b(paramString2, paramString3, paramInt1, paramInt2));
    paramString1 = new zr();
    paramString1.dPe.appId = paramString2;
    paramString1.dPe.filePath = paramString3;
    paramString1.dPe.version = paramInt1;
    paramString1.dPe.dPf = paramInt2;
    paramString1.dPe.md5 = localbc.field_versionMd5;
    com.tencent.mm.sdk.b.a.IbL.l(paramString1);
    AppMethodBeat.o(90661);
  }
  
  static void a(String paramString, Collection<a> paramCollection)
  {
    AppMethodBeat.i(207435);
    bi localbi;
    if ((!bt.isNullOrNil(paramString)) && (paramCollection != null) && (!paramCollection.isEmpty()))
    {
      localbi = baO();
      if (localbi != null) {}
    }
    else
    {
      AppMethodBeat.o(207435);
      return;
    }
    localbi.jFD.b(paramString, paramCollection);
    AppMethodBeat.o(207435);
  }
  
  static boolean a(com.tencent.mm.plugin.appbrand.appcache.a.a parama, a parama1)
  {
    AppMethodBeat.i(90654);
    if (baO() == null)
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
    a(parama.EPe, parama1);
    int i = baO().jIS.c(parama);
    if ((i != 0) && (i != 2))
    {
      a(parama.EPe, parama.appId, b.a.a.jJD, null);
      AppMethodBeat.o(90654);
      return false;
    }
    AppMethodBeat.o(90654);
    return true;
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, a parama)
  {
    AppMethodBeat.i(90655);
    if (baO() == null)
    {
      ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
      AppMethodBeat.o(90655);
      return false;
    }
    Object localObject1;
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2))) {
      localObject1 = null;
    }
    Object localObject2;
    while (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label350;
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
        localObject1 = new bp(paramString2, paramString1, paramInt2, paramInt1);
        break;
      case 0: 
      case 6: 
      case 12: 
      case 13: 
        localObject1 = new az(paramString1, paramInt1, paramInt2, paramString2);
        break;
      case 1: 
      case 2: 
      case 999: 
        localObject1 = new au(paramString1, paramString2, paramInt1);
      }
    }
    if ("@LibraryAppId".equals(paramString1)) {
      bool = false;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.appcache.a.a)localObject1).jJv = bool;
      localObject2 = localObject1;
      if (paramInt3 <= 2097152) {
        break;
      }
      ((com.tencent.mm.plugin.appbrand.appcache.a.a)localObject1).setReadTimeout(((com.tencent.mm.plugin.appbrand.appcache.a.a)localObject1).getReadTimeout() * 2);
      ((com.tencent.mm.plugin.appbrand.appcache.a.a)localObject1).setConnectTimeout(((com.tencent.mm.plugin.appbrand.appcache.a.a)localObject1).getConnectTimeout() * 2);
      localObject2 = localObject1;
      break;
      if (paramInt1 != 0) {
        bool = false;
      } else {
        bool = true;
      }
    }
    label350:
    boolean bool = a(localObject2, parama);
    ad.i("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadPkg, request.urlKey[%s], ret[%b]", new Object[] { localObject2.EPe, Boolean.valueOf(bool) });
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
    if (baO() == null)
    {
      ad.e("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadDebugPkg with keyGen, get null updater instance!!!");
      AppMethodBeat.o(90658);
      return false;
    }
    boolean bool = a(new au(paramString1, paramString2, paramInt, parama1), parama);
    AppMethodBeat.o(90658);
    return bool;
  }
  
  private static Collection<a> af(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(207437);
    bi localbi;
    if (!bt.isNullOrNil(paramString))
    {
      localbi = baO();
      if (localbi != null) {}
    }
    else
    {
      AppMethodBeat.o(207437);
      return null;
    }
    if (paramBoolean) {
      ad.i("MicroMsg.AppBrand.WxaPkgUpdater", "removeCallbacks, key[%s]", new Object[] { paramString });
    }
    paramString = localbi.jFD.cF(paramString);
    AppMethodBeat.o(207437);
    return paramString;
  }
  
  public static boolean b(String paramString1, int paramInt1, int paramInt2, String paramString2, a parama)
  {
    AppMethodBeat.i(90656);
    boolean bool = a(paramString1, paramInt1, paramInt2, 0, paramString2, parama);
    AppMethodBeat.o(90656);
    return bool;
  }
  
  public static bi baO()
  {
    AppMethodBeat.i(90645);
    if (((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYu() == null)
    {
      jIR = null;
      AppMethodBeat.o(90645);
      return null;
    }
    if (jIR == null) {}
    try
    {
      if (jIR == null) {
        jIR = new bi();
      }
      bi localbi = jIR;
      AppMethodBeat.o(90645);
      return localbi;
    }
    finally
    {
      AppMethodBeat.o(90645);
    }
  }
  
  static void cf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90652);
    a(paramString1, paramString2, b.a.a.jJD, null);
    AppMethodBeat.o(90652);
  }
  
  public static void shutdown()
  {
    AppMethodBeat.i(90646);
    try
    {
      bi localbi = jIR;
      jIR = null;
      if (localbi != null) {
        localbi.jIS.jHL.shutdown();
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
    extends b.a<bi.b, WxaPkgLoadProgress>
  {}
  
  public static final class b
  {
    public final String appId;
    public final int dPf;
    public final String filePath;
    public final int version;
    
    public b(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      this.appId = paramString1;
      this.filePath = paramString2;
      this.version = paramInt1;
      this.dPf = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bi
 * JD-Core Version:    0.7.0.1
 */