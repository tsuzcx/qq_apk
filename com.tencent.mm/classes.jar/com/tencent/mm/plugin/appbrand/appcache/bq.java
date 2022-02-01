package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ael;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.af.j;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.pluginsdk.res.downloader.model.k;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.y;
import java.util.Collection;
import java.util.Iterator;
import junit.framework.Assert;
import org.apache.commons.c.i;

public final class bq
{
  private static volatile bq qHK = null;
  private final j<String, a> qEj;
  public final bd qHL;
  
  public bq()
  {
    AppMethodBeat.i(90644);
    this.qEj = new j();
    this.qHL = new bd();
    AppMethodBeat.o(90644);
  }
  
  static Collection<a> VA(String paramString)
  {
    AppMethodBeat.i(320201);
    paramString = ap(paramString, true);
    AppMethodBeat.o(320201);
    return paramString;
  }
  
  static void a(String paramString, WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    AppMethodBeat.i(90653);
    Log.i("MicroMsg.WxaPkgUpdater", "hy: urlkey: %s, onProgressUpdate %s", new Object[] { paramString, paramWxaPkgLoadProgress });
    Object localObject;
    if (!Util.isNullOrNil(paramString))
    {
      localObject = chd();
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
            ((a)localObject).dM(paramWxaPkgLoadProgress);
            continue;
            localObject = ((bq)localObject).qEj.ej(paramString);
            break;
          }
        }
      }
      AppMethodBeat.o(90653);
      return;
    }
    Log.d("MicroMsg.WxaPkgUpdater", "callback progress, null callback urlKey = %s", new Object[] { paramString });
    AppMethodBeat.o(90653);
  }
  
  static void a(String paramString, a parama)
  {
    AppMethodBeat.i(90648);
    bq localbq;
    if ((!Util.isNullOrNil(paramString)) && (parama != null))
    {
      localbq = chd();
      if (localbq != null) {}
    }
    else
    {
      AppMethodBeat.o(90648);
      return;
    }
    localbq.qEj.v(paramString, parama);
    AppMethodBeat.o(90648);
  }
  
  static void a(String paramString1, String paramString2, b.a.a parama)
  {
    AppMethodBeat.i(90660);
    if (chd() == null)
    {
      Log.e("MicroMsg.WxaPkgUpdater", "onDownloadFail, get instance null !!!");
      AppMethodBeat.o(90660);
      return;
    }
    a(paramString1, paramString2, parama, null);
    AppMethodBeat.o(90660);
  }
  
  static void a(String paramString1, String paramString2, b.a.a parama, b paramb)
  {
    AppMethodBeat.i(90659);
    paramString1 = ap(paramString1, false);
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
    Log.d("MicroMsg.WxaPkgUpdater", "callback, null callback appId = %s", new Object[] { paramString2 });
    AppMethodBeat.o(90659);
  }
  
  static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, ag.a parama)
  {
    AppMethodBeat.i(90661);
    a(paramString1, paramString2, paramString3, paramInt1, paramInt2, null, parama);
    AppMethodBeat.o(90661);
  }
  
  static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, ag.a parama)
  {
    AppMethodBeat.i(320248);
    if (chd() == null)
    {
      Log.e("MicroMsg.WxaPkgUpdater", "onDownloadComplete, get instance null !!!");
      AppMethodBeat.o(320248);
      return;
    }
    if (Util.isNullOrNil(paramString3))
    {
      Log.e("MicroMsg.WxaPkgUpdater", "onDownloadComplete, filePath is null or nil");
      a(paramString1, paramString2, b.a.a.qIy, null);
      parama.cfT();
      AppMethodBeat.o(320248);
      return;
    }
    if (!new com.tencent.mm.vfs.u(paramString3).jKS())
    {
      Log.e("MicroMsg.WxaPkgUpdater", "onDownloadComplete, pkg file not exists");
      a(paramString1, paramString2, b.a.a.qIy, null);
      parama.cfT();
      AppMethodBeat.o(320248);
      return;
    }
    u localu = ((e)h.ax(e.class)).p(paramString2, paramInt2, paramString4);
    if (localu == null)
    {
      Log.e("MicroMsg.WxaPkgUpdater", "onDownloadComplete, WxaPkgStorage is null");
      cQ(paramString1, paramString2);
      AppMethodBeat.o(320248);
      return;
    }
    int i;
    if (!k.a.vK(paramInt2))
    {
      i = paramInt1;
      if (TextUtils.isEmpty(paramString4)) {
        break label242;
      }
    }
    label242:
    for (g localg = (g)localu.a(paramString2, paramInt2, paramString4, new String[0]);; localg = (g)localu.a(paramString2, i, paramInt2, new String[0]))
    {
      if (localg != null) {
        break label266;
      }
      Log.e("MicroMsg.WxaPkgUpdater", "onDownloadComplete, no manifest record!!! with given appId(%s) version(%d) debugType(%d)", new Object[] { paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      a(paramString1, paramString2, b.a.a.qIx, null);
      AppMethodBeat.o(320248);
      return;
      i = 1;
      break;
    }
    label266:
    parama.cfU();
    if (!Util.isNullOrNil(paramString2)) {}
    for (boolean bool = a(new com.tencent.mm.vfs.u(paramString3), new String[] { localg.field_versionMd5, localg.field_NewMd5 }, paramString2, "onDownloadComplete");; bool = false)
    {
      parama.ig(bool);
      if (bool) {
        break;
      }
      y.deleteFile(paramString3);
      a(paramString1, paramString2, b.a.a.qIz, null);
      AppMethodBeat.o(320248);
      return;
    }
    localg.field_pkgPath = paramString3;
    Log.i("MicroMsg.WxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, versionDesc = %s, filePath = %s", new Object[] { Boolean.valueOf(bn.b(localu, localg)), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString4, paramString3 });
    a(paramString1, paramString2, b.a.a.qIw, new b(paramString2, paramString3, paramInt1, paramInt2));
    paramString1 = new ael();
    paramString1.ijc.appId = paramString2;
    paramString1.ijc.filePath = paramString3;
    paramString1.ijc.version = paramInt1;
    paramString1.ijc.eul = paramInt2;
    paramString1.ijc.md5 = localg.field_versionMd5;
    paramString1.publish();
    AppMethodBeat.o(320248);
  }
  
  static void a(String paramString, Collection<a> paramCollection)
  {
    AppMethodBeat.i(320192);
    bq localbq;
    if ((!Util.isNullOrNil(paramString)) && (paramCollection != null) && (!paramCollection.isEmpty()))
    {
      localbq = chd();
      if (localbq != null) {}
    }
    else
    {
      AppMethodBeat.o(320192);
      return;
    }
    localbq.qEj.b(paramString, paramCollection);
    AppMethodBeat.o(320192);
  }
  
  static boolean a(a parama, a parama1)
  {
    AppMethodBeat.i(90654);
    if (chd() == null)
    {
      Log.e("MicroMsg.WxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
      AppMethodBeat.o(90654);
      return false;
    }
    if (parama == null)
    {
      AppMethodBeat.o(90654);
      return false;
    }
    a(parama.XUX, parama1);
    int i = chd().qHL.c(parama);
    if ((i != 0) && (i != 2))
    {
      a(parama.XUX, parama.appId, b.a.a.qIC, null);
      AppMethodBeat.o(90654);
      return false;
    }
    AppMethodBeat.o(90654);
    return true;
  }
  
  public static boolean a(com.tencent.mm.vfs.u paramu, String[] paramArrayOfString, String paramString1, String paramString2)
  {
    AppMethodBeat.i(320252);
    paramu = WxaPkgIntegrityChecker.Vu(ah.v(paramu.jKT()));
    int i = 0;
    while (i < 2)
    {
      String str = paramArrayOfString[i];
      if ((!TextUtils.isEmpty(str)) && (str.equals(paramu)))
      {
        Log.i("MicroMsg.WxaPkgUpdater", "[%s]verifyPkg, appId[%s] verify ok with checksumMd5[%s]", new Object[] { paramString2, paramString1, str });
        AppMethodBeat.o(320252);
        return true;
      }
      i += 1;
    }
    Log.e("MicroMsg.WxaPkgUpdater", "[%s]verifyPkg, appId[%s] checksumMd5List[%s] != file.md5[%s]", new Object[] { paramString2, paramString1, i.b(paramArrayOfString, ","), paramu });
    AppMethodBeat.o(320252);
    return false;
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, a parama)
  {
    AppMethodBeat.i(90656);
    boolean bool = b(paramString1, paramInt1, paramInt2, paramString2, null, parama);
    AppMethodBeat.o(90656);
    return bool;
  }
  
  public static boolean a(String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(90647);
    boolean bool = a("@LibraryAppId", 0, paramInt, paramString, parama);
    AppMethodBeat.o(90647);
    return bool;
  }
  
  public static boolean a(String paramString1, int paramInt, String paramString2, String paramString3, a parama, a.a parama1)
  {
    AppMethodBeat.i(320232);
    if (chd() == null)
    {
      Log.e("MicroMsg.WxaPkgUpdater", "startDownloadDebugPkg with keyGen, get null updater instance!!!");
      AppMethodBeat.o(320232);
      return false;
    }
    if ((parama1 == null) && (!TextUtils.isEmpty(paramString2))) {
      parama1 = new bq.1(paramString2);
    }
    for (;;)
    {
      boolean bool = a(new az(paramString1, paramInt, paramString2, paramString3, parama1), parama);
      AppMethodBeat.o(320232);
      return bool;
    }
  }
  
  private static Collection<a> ap(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(320206);
    bq localbq;
    if (!Util.isNullOrNil(paramString))
    {
      localbq = chd();
      if (localbq != null) {}
    }
    else
    {
      AppMethodBeat.o(320206);
      return null;
    }
    if (paramBoolean) {
      Log.i("MicroMsg.WxaPkgUpdater", "removeCallbacks, key[%s]", new Object[] { paramString });
    }
    paramString = localbq.qEj.ek(paramString);
    AppMethodBeat.o(320206);
    return paramString;
  }
  
  public static boolean b(String paramString1, int paramInt1, int paramInt2, String paramString2, aeo paramaeo, a parama)
  {
    AppMethodBeat.i(320225);
    if (chd() == null)
    {
      Log.e("MicroMsg.WxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
      AppMethodBeat.o(320225);
      return false;
    }
    Object localObject;
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      localObject = null;
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null) {
          break label309;
        }
        Log.e("MicroMsg.WxaPkgUpdater", "startDownloadPkg, create Null request, appId %s, pkgType %d, pkgVersion %d, url %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
        AppMethodBeat.o(320225);
        return false;
      }
    }
    else
    {
      switch (paramInt1)
      {
      }
      for (;;)
      {
        localObject = null;
        break;
        localObject = new by(paramString2, paramString1, paramInt2, paramInt1);
        break;
        localObject = new be(paramString1, paramInt1, paramInt2, paramString2);
        break;
        Assert.fail("Unrecognized type:".concat(String.valueOf(paramInt1)));
      }
    }
    if ("@LibraryAppId".equals(paramString1)) {
      bool = false;
    }
    for (;;)
    {
      ((a)localObject).qIu = bool;
      break;
      if (paramInt1 != 0) {
        bool = false;
      } else {
        bool = true;
      }
    }
    label309:
    ((a)localObject).qIv = paramaeo;
    boolean bool = a((a)localObject, parama);
    Log.i("MicroMsg.WxaPkgUpdater", "startDownloadPkg, request.urlKey[%s], ret[%b]", new Object[] { ((k)localObject).XUX, Boolean.valueOf(bool) });
    AppMethodBeat.o(320225);
    return bool;
  }
  
  static void cQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90652);
    a(paramString1, paramString2, b.a.a.qIC, null);
    AppMethodBeat.o(90652);
  }
  
  public static bq chd()
  {
    AppMethodBeat.i(90645);
    if ((!h.baC().mBZ) || (h.ax(e.class) == null))
    {
      qHK = null;
      AppMethodBeat.o(90645);
      return null;
    }
    if (qHK == null) {}
    try
    {
      if (qHK == null) {
        qHK = new bq();
      }
      bq localbq = qHK;
      AppMethodBeat.o(90645);
      return localbq;
    }
    finally
    {
      AppMethodBeat.o(90645);
    }
  }
  
  public static void shutdown()
  {
    AppMethodBeat.i(90646);
    try
    {
      bq localbq = qHK;
      qHK = null;
      if (localbq != null) {
        localbq.qHL.qGy.shutdown();
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
    extends b.a<bq.b, WxaPkgLoadProgress>
  {}
  
  public static final class b
  {
    public final String appId;
    public final int eul;
    public final String filePath;
    public final int version;
    
    public b(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      this.appId = paramString1;
      this.filePath = paramString2;
      this.version = paramInt1;
      this.eul = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bq
 * JD-Core Version:    0.7.0.1
 */