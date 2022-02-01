package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zx;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.util.Collection;
import java.util.Iterator;

public final class bj
{
  private static volatile bj jLS = null;
  private final h<String, a> jIC;
  public final az jLT;
  
  public bj()
  {
    AppMethodBeat.i(90644);
    this.jIC = new h();
    this.jLT = new az();
    AppMethodBeat.o(90644);
  }
  
  static Collection<a> Ml(String paramString)
  {
    AppMethodBeat.i(212497);
    paramString = af(paramString, true);
    AppMethodBeat.o(212497);
    return paramString;
  }
  
  static void a(String paramString, WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    AppMethodBeat.i(90653);
    ae.i("MicroMsg.AppBrand.WxaPkgUpdater", "hy: urlkey: %s, onProgressUpdate %s", new Object[] { paramString, paramWxaPkgLoadProgress });
    Object localObject;
    if (!bu.isNullOrNil(paramString))
    {
      localObject = bbn();
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
            localObject = ((bj)localObject).jIC.cF(paramString);
            break;
          }
        }
      }
      AppMethodBeat.o(90653);
      return;
    }
    ae.d("MicroMsg.AppBrand.WxaPkgUpdater", "callback progress, null callback urlKey = %s", new Object[] { paramString });
    AppMethodBeat.o(90653);
  }
  
  static void a(String paramString, a parama)
  {
    AppMethodBeat.i(90648);
    bj localbj;
    if ((!bu.isNullOrNil(paramString)) && (parama != null))
    {
      localbj = bbn();
      if (localbj != null) {}
    }
    else
    {
      AppMethodBeat.o(90648);
      return;
    }
    localbj.jIC.j(paramString, parama);
    AppMethodBeat.o(90648);
  }
  
  static void a(String paramString1, String paramString2, b.a.a parama)
  {
    AppMethodBeat.i(90660);
    if (bbn() == null)
    {
      ae.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadFail, get instance null !!!");
      AppMethodBeat.o(90660);
      return;
    }
    a(paramString1, paramString2, parama, null);
    AppMethodBeat.o(90660);
  }
  
  static void a(String paramString1, String paramString2, b.a.a parama, bj.b paramb)
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
    ae.d("MicroMsg.AppBrand.WxaPkgUpdater", "callback, null callback appId = %s", new Object[] { paramString2 });
    AppMethodBeat.o(90659);
  }
  
  static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, ae.a parama)
  {
    AppMethodBeat.i(90661);
    boolean bool = j.a.oQ(paramInt2);
    if (bbn() == null)
    {
      ae.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, get instance null !!!");
      AppMethodBeat.o(90661);
      return;
    }
    if (bu.isNullOrNil(paramString3))
    {
      ae.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, filePath is null or nil");
      a(paramString1, paramString2, b.a.a.jMA, null);
      parama.aZW();
      AppMethodBeat.o(90661);
      return;
    }
    if (!new k(paramString3).exists())
    {
      ae.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, pkg file not exists");
      a(paramString1, paramString2, b.a.a.jMA, null);
      parama.aZW();
      AppMethodBeat.o(90661);
      return;
    }
    if (((e)com.tencent.mm.kernel.g.ab(e.class)).aYP() == null)
    {
      ae.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, WxaPkgStorage is null");
      cg(paramString1, paramString2);
      AppMethodBeat.o(90661);
      return;
    }
    if (!bool) {}
    bd localbd;
    for (int i = paramInt1;; i = 1)
    {
      localbd = ((e)com.tencent.mm.kernel.g.ab(e.class)).aYP().a(paramString2, i, paramInt2, new String[0]);
      if (localbd != null) {
        break;
      }
      ae.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, no manifest record!!! with given appId(%s) version(%d) debugType(%d)", new Object[] { paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      a(paramString1, paramString2, b.a.a.jMz, null);
      AppMethodBeat.o(90661);
      return;
    }
    parama.aZX();
    Object localObject;
    String[] arrayOfString;
    int j;
    if (!bu.isNullOrNil(paramString2))
    {
      localObject = new k(paramString3);
      arrayOfString = new String[2];
      arrayOfString[0] = localbd.field_versionMd5;
      arrayOfString[1] = localbd.field_NewMd5;
      localObject = WxaPkgIntegrityChecker.Me(w.B(((k)localObject).fTh()));
      j = 0;
      if (j < 2)
      {
        String str = arrayOfString[j];
        if ((!TextUtils.isEmpty(str)) && (str.equals(localObject)))
        {
          ae.i("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete$verifyPkg, appId[%s] verify ok with checksumMd5[%s]", new Object[] { paramString2, str });
          bool = true;
        }
      }
    }
    for (;;)
    {
      parama.fI(bool);
      if (bool) {
        break label438;
      }
      o.deleteFile(paramString3);
      a(paramString1, paramString2, b.a.a.jMC, null);
      AppMethodBeat.o(90661);
      return;
      j += 1;
      break;
      ae.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete$verifyPkg, appId[%s] checksumMd5List[%s] != file.md5[%s]", new Object[] { paramString2, org.apache.commons.b.g.a(arrayOfString, ","), localObject });
      bool = false;
      continue;
      bool = false;
    }
    label438:
    ae.i("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", new Object[] { Boolean.valueOf(((e)com.tencent.mm.kernel.g.ab(e.class)).aYP().e(paramString2, paramInt2, i, paramString3)), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString3 });
    a(paramString1, paramString2, b.a.a.jMy, new bj.b(paramString2, paramString3, paramInt1, paramInt2));
    paramString1 = new zx();
    paramString1.dQu.appId = paramString2;
    paramString1.dQu.filePath = paramString3;
    paramString1.dQu.version = paramInt1;
    paramString1.dQu.dQv = paramInt2;
    paramString1.dQu.md5 = localbd.field_versionMd5;
    com.tencent.mm.sdk.b.a.IvT.l(paramString1);
    AppMethodBeat.o(90661);
  }
  
  static void a(String paramString, Collection<a> paramCollection)
  {
    AppMethodBeat.i(212496);
    bj localbj;
    if ((!bu.isNullOrNil(paramString)) && (paramCollection != null) && (!paramCollection.isEmpty()))
    {
      localbj = bbn();
      if (localbj != null) {}
    }
    else
    {
      AppMethodBeat.o(212496);
      return;
    }
    localbj.jIC.b(paramString, paramCollection);
    AppMethodBeat.o(212496);
  }
  
  static boolean a(com.tencent.mm.plugin.appbrand.appcache.a.a parama, a parama1)
  {
    AppMethodBeat.i(90654);
    if (bbn() == null)
    {
      ae.e("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
      AppMethodBeat.o(90654);
      return false;
    }
    if (parama == null)
    {
      AppMethodBeat.o(90654);
      return false;
    }
    a(parama.Fhz, parama1);
    int i = bbn().jLT.c(parama);
    if ((i != 0) && (i != 2))
    {
      a(parama.Fhz, parama.appId, b.a.a.jMF, null);
      AppMethodBeat.o(90654);
      return false;
    }
    AppMethodBeat.o(90654);
    return true;
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, a parama)
  {
    AppMethodBeat.i(90655);
    if (bbn() == null)
    {
      ae.e("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
      AppMethodBeat.o(90655);
      return false;
    }
    Object localObject1;
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2))) {
      localObject1 = null;
    }
    Object localObject2;
    while (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label350;
      }
      ae.e("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadPkg, create Null request, appId %s, pkgType %d, pkgVersion %d, url %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
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
        localObject1 = new br(paramString2, paramString1, paramInt2, paramInt1);
        break;
      case 0: 
      case 6: 
      case 12: 
      case 13: 
        localObject1 = new ba(paramString1, paramInt1, paramInt2, paramString2);
        break;
      case 1: 
      case 2: 
      case 999: 
        localObject1 = new av(paramString1, paramString2, paramInt1);
      }
    }
    if ("@LibraryAppId".equals(paramString1)) {
      bool = false;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.appcache.a.a)localObject1).jMx = bool;
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
    ae.i("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadPkg, request.urlKey[%s], ret[%b]", new Object[] { localObject2.Fhz, Boolean.valueOf(bool) });
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
    if (bbn() == null)
    {
      ae.e("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadDebugPkg with keyGen, get null updater instance!!!");
      AppMethodBeat.o(90658);
      return false;
    }
    boolean bool = a(new av(paramString1, paramString2, paramInt, parama1), parama);
    AppMethodBeat.o(90658);
    return bool;
  }
  
  private static Collection<a> af(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(212498);
    bj localbj;
    if (!bu.isNullOrNil(paramString))
    {
      localbj = bbn();
      if (localbj != null) {}
    }
    else
    {
      AppMethodBeat.o(212498);
      return null;
    }
    if (paramBoolean) {
      ae.i("MicroMsg.AppBrand.WxaPkgUpdater", "removeCallbacks, key[%s]", new Object[] { paramString });
    }
    paramString = localbj.jIC.cG(paramString);
    AppMethodBeat.o(212498);
    return paramString;
  }
  
  public static boolean b(String paramString1, int paramInt1, int paramInt2, String paramString2, a parama)
  {
    AppMethodBeat.i(90656);
    boolean bool = a(paramString1, paramInt1, paramInt2, 0, paramString2, parama);
    AppMethodBeat.o(90656);
    return bool;
  }
  
  public static bj bbn()
  {
    AppMethodBeat.i(90645);
    if (((e)com.tencent.mm.kernel.g.ab(e.class)).aYP() == null)
    {
      jLS = null;
      AppMethodBeat.o(90645);
      return null;
    }
    if (jLS == null) {}
    try
    {
      if (jLS == null) {
        jLS = new bj();
      }
      bj localbj = jLS;
      AppMethodBeat.o(90645);
      return localbj;
    }
    finally
    {
      AppMethodBeat.o(90645);
    }
  }
  
  static void cg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90652);
    a(paramString1, paramString2, b.a.a.jMF, null);
    AppMethodBeat.o(90652);
  }
  
  public static void shutdown()
  {
    AppMethodBeat.i(90646);
    try
    {
      bj localbj = jLS;
      jLS = null;
      if (localbj != null) {
        localbj.jLT.jKM.shutdown();
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
    extends b.a<bj.b, WxaPkgLoadProgress>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bj
 * JD-Core Version:    0.7.0.1
 */