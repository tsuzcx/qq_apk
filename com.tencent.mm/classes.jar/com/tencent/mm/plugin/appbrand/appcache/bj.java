package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.abe;
import com.tencent.mm.plugin.appbrand.ac.h;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Collection;
import java.util.Iterator;

public final class bj
{
  private static volatile bj kNT = null;
  private final h<String, a> kKy;
  public final az kNU;
  
  public bj()
  {
    AppMethodBeat.i(90644);
    this.kKy = new h();
    this.kNU = new az();
    AppMethodBeat.o(90644);
  }
  
  static Collection<a> Vu(String paramString)
  {
    AppMethodBeat.i(230566);
    paramString = ah(paramString, true);
    AppMethodBeat.o(230566);
    return paramString;
  }
  
  static void a(String paramString, WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    AppMethodBeat.i(90653);
    Log.i("MicroMsg.AppBrand.WxaPkgUpdater", "hy: urlkey: %s, onProgressUpdate %s", new Object[] { paramString, paramWxaPkgLoadProgress });
    Object localObject;
    if (!Util.isNullOrNil(paramString))
    {
      localObject = bwA();
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
            ((a)localObject).cr(paramWxaPkgLoadProgress);
            continue;
            localObject = ((bj)localObject).kKy.cM(paramString);
            break;
          }
        }
      }
      AppMethodBeat.o(90653);
      return;
    }
    Log.d("MicroMsg.AppBrand.WxaPkgUpdater", "callback progress, null callback urlKey = %s", new Object[] { paramString });
    AppMethodBeat.o(90653);
  }
  
  static void a(String paramString, a parama)
  {
    AppMethodBeat.i(90648);
    bj localbj;
    if ((!Util.isNullOrNil(paramString)) && (parama != null))
    {
      localbj = bwA();
      if (localbj != null) {}
    }
    else
    {
      AppMethodBeat.o(90648);
      return;
    }
    localbj.kKy.r(paramString, parama);
    AppMethodBeat.o(90648);
  }
  
  static void a(String paramString1, String paramString2, b.a.a parama)
  {
    AppMethodBeat.i(90660);
    if (bwA() == null)
    {
      Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadFail, get instance null !!!");
      AppMethodBeat.o(90660);
      return;
    }
    a(paramString1, paramString2, parama, null);
    AppMethodBeat.o(90660);
  }
  
  static void a(String paramString1, String paramString2, b.a.a parama, b paramb)
  {
    AppMethodBeat.i(90659);
    paramString1 = ah(paramString1, false);
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
    Log.d("MicroMsg.AppBrand.WxaPkgUpdater", "callback, null callback appId = %s", new Object[] { paramString2 });
    AppMethodBeat.o(90659);
  }
  
  static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, ae.a parama)
  {
    AppMethodBeat.i(90661);
    boolean bool = j.a.sE(paramInt2);
    if (bwA() == null)
    {
      Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, get instance null !!!");
      AppMethodBeat.o(90661);
      return;
    }
    if (Util.isNullOrNil(paramString3))
    {
      Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, filePath is null or nil");
      a(paramString1, paramString2, b.a.a.kOE, null);
      parama.bvn();
      AppMethodBeat.o(90661);
      return;
    }
    if (!new o(paramString3).exists())
    {
      Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, pkg file not exists");
      a(paramString1, paramString2, b.a.a.kOE, null);
      parama.bvn();
      AppMethodBeat.o(90661);
      return;
    }
    if (((e)com.tencent.mm.kernel.g.af(e.class)).bub() == null)
    {
      Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, WxaPkgStorage is null");
      cu(paramString1, paramString2);
      AppMethodBeat.o(90661);
      return;
    }
    if (!bool) {}
    bd localbd;
    for (int i = paramInt1;; i = 1)
    {
      localbd = ((e)com.tencent.mm.kernel.g.af(e.class)).bub().a(paramString2, i, paramInt2, new String[0]);
      if (localbd != null) {
        break;
      }
      Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, no manifest record!!! with given appId(%s) version(%d) debugType(%d)", new Object[] { paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      a(paramString1, paramString2, b.a.a.kOD, null);
      AppMethodBeat.o(90661);
      return;
    }
    parama.bvo();
    if (!Util.isNullOrNil(paramString2)) {}
    for (bool = a(new o(paramString3), new String[] { localbd.field_versionMd5, localbd.field_NewMd5 }, paramString2, "onDownloadComplete");; bool = false)
    {
      parama.gE(bool);
      if (bool) {
        break;
      }
      s.deleteFile(paramString3);
      a(paramString1, paramString2, b.a.a.kOG, null);
      AppMethodBeat.o(90661);
      return;
    }
    Log.i("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", new Object[] { Boolean.valueOf(((e)com.tencent.mm.kernel.g.af(e.class)).bub().e(paramString2, paramInt2, i, paramString3)), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString3 });
    a(paramString1, paramString2, b.a.a.kOC, new b(paramString2, paramString3, paramInt1, paramInt2));
    paramString1 = new abe();
    paramString1.eiw.appId = paramString2;
    paramString1.eiw.filePath = paramString3;
    paramString1.eiw.version = paramInt1;
    paramString1.eiw.eix = paramInt2;
    paramString1.eiw.md5 = localbd.field_versionMd5;
    EventCenter.instance.publish(paramString1);
    AppMethodBeat.o(90661);
  }
  
  static void a(String paramString, Collection<a> paramCollection)
  {
    AppMethodBeat.i(230565);
    bj localbj;
    if ((!Util.isNullOrNil(paramString)) && (paramCollection != null) && (!paramCollection.isEmpty()))
    {
      localbj = bwA();
      if (localbj != null) {}
    }
    else
    {
      AppMethodBeat.o(230565);
      return;
    }
    localbj.kKy.b(paramString, paramCollection);
    AppMethodBeat.o(230565);
  }
  
  static boolean a(a parama, a parama1)
  {
    AppMethodBeat.i(90654);
    if (bwA() == null)
    {
      Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
      AppMethodBeat.o(90654);
      return false;
    }
    if (parama == null)
    {
      AppMethodBeat.o(90654);
      return false;
    }
    a(parama.JYs, parama1);
    int i = bwA().kNU.c(parama);
    if ((i != 0) && (i != 2))
    {
      a(parama.JYs, parama.appId, b.a.a.kOJ, null);
      AppMethodBeat.o(90654);
      return false;
    }
    AppMethodBeat.o(90654);
    return true;
  }
  
  public static boolean a(o paramo, String[] paramArrayOfString, String paramString1, String paramString2)
  {
    AppMethodBeat.i(230569);
    paramo = WxaPkgIntegrityChecker.Vn(aa.z(paramo.her()));
    int i = 0;
    while (i < 2)
    {
      String str = paramArrayOfString[i];
      if ((!TextUtils.isEmpty(str)) && (str.equals(paramo)))
      {
        Log.i("MicroMsg.AppBrand.WxaPkgUpdater", "[%s]verifyPkg, appId[%s] verify ok with checksumMd5[%s]", new Object[] { paramString2, paramString1, str });
        AppMethodBeat.o(230569);
        return true;
      }
      i += 1;
    }
    Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "[%s]verifyPkg, appId[%s] checksumMd5List[%s] != file.md5[%s]", new Object[] { paramString2, paramString1, org.apache.commons.b.g.a(paramArrayOfString, ","), paramo });
    AppMethodBeat.o(230569);
    return false;
  }
  
  public static boolean a(String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(90647);
    boolean bool = c("@LibraryAppId", 0, paramInt, paramString, parama);
    AppMethodBeat.o(90647);
    return bool;
  }
  
  public static boolean a(String paramString1, int paramInt, String paramString2, a parama)
  {
    AppMethodBeat.i(90657);
    boolean bool = c(paramString1, paramInt, 1, paramString2, parama);
    AppMethodBeat.o(90657);
    return bool;
  }
  
  public static boolean a(String paramString1, int paramInt, String paramString2, a parama, a.a parama1)
  {
    AppMethodBeat.i(90658);
    if (bwA() == null)
    {
      Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadDebugPkg with keyGen, get null updater instance!!!");
      AppMethodBeat.o(90658);
      return false;
    }
    boolean bool = a(new av(paramString1, paramString2, paramInt, parama1), parama);
    AppMethodBeat.o(90658);
    return bool;
  }
  
  private static Collection<a> ah(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(230567);
    bj localbj;
    if (!Util.isNullOrNil(paramString))
    {
      localbj = bwA();
      if (localbj != null) {}
    }
    else
    {
      AppMethodBeat.o(230567);
      return null;
    }
    if (paramBoolean) {
      Log.i("MicroMsg.AppBrand.WxaPkgUpdater", "removeCallbacks, key[%s]", new Object[] { paramString });
    }
    paramString = localbj.kKy.cN(paramString);
    AppMethodBeat.o(230567);
    return paramString;
  }
  
  private static boolean b(String paramString1, int paramInt1, int paramInt2, String paramString2, a parama)
  {
    AppMethodBeat.i(230568);
    if (bwA() == null)
    {
      Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
      AppMethodBeat.o(230568);
      return false;
    }
    Object localObject;
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2))) {
      localObject = null;
    }
    while (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label308;
      }
      Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadPkg, create Null request, appId %s, pkgType %d, pkgVersion %d, url %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
      AppMethodBeat.o(230568);
      return false;
      switch (paramInt1)
      {
      default: 
        localObject = null;
        break;
      case 10000: 
      case 10001: 
      case 10002: 
      case 10100: 
      case 10101: 
      case 10102: 
        localObject = new br(paramString2, paramString1, paramInt2, paramInt1);
        break;
      case 0: 
      case 6: 
      case 12: 
      case 13: 
        localObject = new ba(paramString1, paramInt1, paramInt2, paramString2);
        break;
      case 1: 
      case 2: 
      case 999: 
        localObject = new av(paramString1, paramString2, paramInt1);
      }
    }
    if ("@LibraryAppId".equals(paramString1)) {
      bool = false;
    }
    for (;;)
    {
      ((a)localObject).kOB = bool;
      break;
      if (paramInt1 != 0) {
        bool = false;
      } else {
        bool = true;
      }
    }
    label308:
    boolean bool = a((a)localObject, parama);
    Log.i("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadPkg, request.urlKey[%s], ret[%b]", new Object[] { ((l)localObject).JYs, Boolean.valueOf(bool) });
    AppMethodBeat.o(230568);
    return bool;
  }
  
  public static bj bwA()
  {
    AppMethodBeat.i(90645);
    if (((e)com.tencent.mm.kernel.g.af(e.class)).bub() == null)
    {
      kNT = null;
      AppMethodBeat.o(90645);
      return null;
    }
    if (kNT == null) {}
    try
    {
      if (kNT == null) {
        kNT = new bj();
      }
      bj localbj = kNT;
      AppMethodBeat.o(90645);
      return localbj;
    }
    finally
    {
      AppMethodBeat.o(90645);
    }
  }
  
  public static boolean c(String paramString1, int paramInt1, int paramInt2, String paramString2, a parama)
  {
    AppMethodBeat.i(90656);
    boolean bool = b(paramString1, paramInt1, paramInt2, paramString2, parama);
    AppMethodBeat.o(90656);
    return bool;
  }
  
  static void cu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90652);
    a(paramString1, paramString2, b.a.a.kOJ, null);
    AppMethodBeat.o(90652);
  }
  
  public static void shutdown()
  {
    AppMethodBeat.i(90646);
    try
    {
      bj localbj = kNT;
      kNT = null;
      if (localbj != null) {
        localbj.kNU.kML.shutdown();
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
  
  public static final class b
  {
    public final String appId;
    public final int eix;
    public final String filePath;
    public final int version;
    
    public b(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      this.appId = paramString1;
      this.filePath = paramString2;
      this.version = paramInt1;
      this.eix = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bj
 * JD-Core Version:    0.7.0.1
 */