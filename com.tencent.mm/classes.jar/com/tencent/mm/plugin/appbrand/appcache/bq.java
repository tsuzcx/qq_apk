package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.acm;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.pluginsdk.k.a.c.k;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.Collection;
import java.util.Iterator;
import junit.framework.Assert;

public final class bq
{
  private static volatile bq nHV = null;
  private final com.tencent.mm.plugin.appbrand.ac.h<String, a> nEo;
  public final bc nHW;
  
  public bq()
  {
    AppMethodBeat.i(90644);
    this.nEo = new com.tencent.mm.plugin.appbrand.ac.h();
    this.nHW = new bc();
    AppMethodBeat.o(90644);
  }
  
  static void a(String paramString, WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    AppMethodBeat.i(90653);
    Log.i("MicroMsg.WxaPkgUpdater", "hy: urlkey: %s, onProgressUpdate %s", new Object[] { paramString, paramWxaPkgLoadProgress });
    Object localObject;
    if (!Util.isNullOrNil(paramString))
    {
      localObject = bHH();
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
            localObject = ((bq)localObject).nEo.cN(paramString);
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
      localbq = bHH();
      if (localbq != null) {}
    }
    else
    {
      AppMethodBeat.o(90648);
      return;
    }
    localbq.nEo.k(paramString, parama);
    AppMethodBeat.o(90648);
  }
  
  static void a(String paramString1, String paramString2, b.a.a parama)
  {
    AppMethodBeat.i(90660);
    if (bHH() == null)
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
    paramString1 = ai(paramString1, false);
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
  
  static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, af.a parama)
  {
    AppMethodBeat.i(90661);
    a(paramString1, paramString2, paramString3, paramInt1, paramInt2, null, parama);
    AppMethodBeat.o(90661);
  }
  
  static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, af.a parama)
  {
    AppMethodBeat.i(206550);
    if (bHH() == null)
    {
      Log.e("MicroMsg.WxaPkgUpdater", "onDownloadComplete, get instance null !!!");
      AppMethodBeat.o(206550);
      return;
    }
    if (Util.isNullOrNil(paramString3))
    {
      Log.e("MicroMsg.WxaPkgUpdater", "onDownloadComplete, filePath is null or nil");
      a(paramString1, paramString2, b.a.a.nIH, null);
      parama.bGt();
      AppMethodBeat.o(206550);
      return;
    }
    if (!new q(paramString3).ifE())
    {
      Log.e("MicroMsg.WxaPkgUpdater", "onDownloadComplete, pkg file not exists");
      a(paramString1, paramString2, b.a.a.nIH, null);
      parama.bGt();
      AppMethodBeat.o(206550);
      return;
    }
    s locals = ((e)com.tencent.mm.kernel.h.ae(e.class)).n(paramString2, paramInt2, paramString4);
    if (locals == null)
    {
      Log.e("MicroMsg.WxaPkgUpdater", "onDownloadComplete, WxaPkgStorage is null");
      cz(paramString1, paramString2);
      AppMethodBeat.o(206550);
      return;
    }
    int i;
    if (!j.a.vB(paramInt2))
    {
      i = paramInt1;
      if (TextUtils.isEmpty(paramString4)) {
        break label242;
      }
    }
    label242:
    for (g localg = (g)locals.a(paramString2, paramInt2, paramString4, new String[0]);; localg = (g)locals.a(paramString2, i, paramInt2, new String[0]))
    {
      if (localg != null) {
        break label266;
      }
      Log.e("MicroMsg.WxaPkgUpdater", "onDownloadComplete, no manifest record!!! with given appId(%s) version(%d) debugType(%d)", new Object[] { paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      a(paramString1, paramString2, b.a.a.nIG, null);
      AppMethodBeat.o(206550);
      return;
      i = 1;
      break;
    }
    label266:
    parama.bGu();
    if (!Util.isNullOrNil(paramString2)) {}
    for (boolean bool = a(new q(paramString3), new String[] { localg.field_versionMd5, localg.field_NewMd5 }, paramString2, "onDownloadComplete");; bool = false)
    {
      parama.hp(bool);
      if (bool) {
        break;
      }
      u.deleteFile(paramString3);
      a(paramString1, paramString2, b.a.a.nIJ, null);
      AppMethodBeat.o(206550);
      return;
    }
    localg.field_pkgPath = paramString3;
    Log.i("MicroMsg.WxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, versionDesc = %s, filePath = %s", new Object[] { Boolean.valueOf(bn.b(locals, localg)), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i), paramString4, paramString3 });
    a(paramString1, paramString2, b.a.a.nIF, new b(paramString2, paramString3, paramInt1, paramInt2));
    paramString1 = new acm();
    paramString1.gcM.appId = paramString2;
    paramString1.gcM.filePath = paramString3;
    paramString1.gcM.version = paramInt1;
    paramString1.gcM.cBI = paramInt2;
    paramString1.gcM.md5 = localg.field_versionMd5;
    EventCenter.instance.publish(paramString1);
    AppMethodBeat.o(206550);
  }
  
  static void a(String paramString, Collection<a> paramCollection)
  {
    AppMethodBeat.i(206528);
    bq localbq;
    if ((!Util.isNullOrNil(paramString)) && (paramCollection != null) && (!paramCollection.isEmpty()))
    {
      localbq = bHH();
      if (localbq != null) {}
    }
    else
    {
      AppMethodBeat.o(206528);
      return;
    }
    localbq.nEo.b(paramString, paramCollection);
    AppMethodBeat.o(206528);
  }
  
  static boolean a(a parama, a parama1)
  {
    AppMethodBeat.i(90654);
    if (bHH() == null)
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
    a(parama.QYU, parama1);
    int i = bHH().nHW.c(parama);
    if ((i != 0) && (i != 2))
    {
      a(parama.QYU, parama.appId, b.a.a.nIM, null);
      AppMethodBeat.o(90654);
      return false;
    }
    AppMethodBeat.o(90654);
    return true;
  }
  
  public static boolean a(q paramq, String[] paramArrayOfString, String paramString1, String paramString2)
  {
    AppMethodBeat.i(206551);
    paramq = WxaPkgIntegrityChecker.acX(paramq.bOF());
    int i = 0;
    while (i < 2)
    {
      String str = paramArrayOfString[i];
      if ((!TextUtils.isEmpty(str)) && (str.equals(paramq)))
      {
        Log.i("MicroMsg.WxaPkgUpdater", "[%s]verifyPkg, appId[%s] verify ok with checksumMd5[%s]", new Object[] { paramString2, paramString1, str });
        AppMethodBeat.o(206551);
        return true;
      }
      i += 1;
    }
    Log.e("MicroMsg.WxaPkgUpdater", "[%s]verifyPkg, appId[%s] checksumMd5List[%s] != file.md5[%s]", new Object[] { paramString2, paramString1, org.apache.commons.b.g.a(paramArrayOfString, ","), paramq });
    AppMethodBeat.o(206551);
    return false;
  }
  
  public static boolean a(String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(90647);
    boolean bool = c("@LibraryAppId", 0, paramInt, paramString, parama);
    AppMethodBeat.o(90647);
    return bool;
  }
  
  public static boolean a(String paramString1, int paramInt, String paramString2, String paramString3, a parama, a.a parama1)
  {
    AppMethodBeat.i(206543);
    if (bHH() == null)
    {
      Log.e("MicroMsg.WxaPkgUpdater", "startDownloadDebugPkg with keyGen, get null updater instance!!!");
      AppMethodBeat.o(206543);
      return false;
    }
    boolean bool = a(new ay(paramString1, paramInt, paramString2, paramString3, parama1), parama);
    AppMethodBeat.o(206543);
    return bool;
  }
  
  static Collection<a> ade(String paramString)
  {
    AppMethodBeat.i(206531);
    paramString = ai(paramString, true);
    AppMethodBeat.o(206531);
    return paramString;
  }
  
  private static Collection<a> ai(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(206532);
    bq localbq;
    if (!Util.isNullOrNil(paramString))
    {
      localbq = bHH();
      if (localbq != null) {}
    }
    else
    {
      AppMethodBeat.o(206532);
      return null;
    }
    if (paramBoolean) {
      Log.i("MicroMsg.WxaPkgUpdater", "removeCallbacks, key[%s]", new Object[] { paramString });
    }
    paramString = localbq.nEo.cO(paramString);
    AppMethodBeat.o(206532);
    return paramString;
  }
  
  private static boolean b(String paramString1, int paramInt1, int paramInt2, String paramString2, a parama)
  {
    AppMethodBeat.i(206541);
    if (bHH() == null)
    {
      Log.e("MicroMsg.WxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
      AppMethodBeat.o(206541);
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
        AppMethodBeat.o(206541);
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
        localObject = new bz(paramString2, paramString1, paramInt2, paramInt1);
        break;
        localObject = new bd(paramString1, paramInt1, paramInt2, paramString2);
        break;
        Assert.fail("Unrecognized type:".concat(String.valueOf(paramInt1)));
      }
    }
    if ("@LibraryAppId".equals(paramString1)) {
      bool = false;
    }
    for (;;)
    {
      ((a)localObject).nIE = bool;
      break;
      if (paramInt1 != 0) {
        bool = false;
      } else {
        bool = true;
      }
    }
    label309:
    boolean bool = a((a)localObject, parama);
    Log.i("MicroMsg.WxaPkgUpdater", "startDownloadPkg, request.urlKey[%s], ret[%b]", new Object[] { ((k)localObject).QYU, Boolean.valueOf(bool) });
    AppMethodBeat.o(206541);
    return bool;
  }
  
  public static bq bHH()
  {
    AppMethodBeat.i(90645);
    if ((!com.tencent.mm.kernel.h.aHE().kbT) || (com.tencent.mm.kernel.h.ae(e.class) == null))
    {
      nHV = null;
      AppMethodBeat.o(90645);
      return null;
    }
    if (nHV == null) {}
    try
    {
      if (nHV == null) {
        nHV = new bq();
      }
      bq localbq = nHV;
      AppMethodBeat.o(90645);
      return localbq;
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
  
  static void cz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90652);
    a(paramString1, paramString2, b.a.a.nIM, null);
    AppMethodBeat.o(90652);
  }
  
  public static void shutdown()
  {
    AppMethodBeat.i(90646);
    try
    {
      bq localbq = nHV;
      nHV = null;
      if (localbq != null) {
        localbq.nHW.nGG.shutdown();
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
    public final int cBI;
    public final String filePath;
    public final int version;
    
    public b(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      this.appId = paramString1;
      this.filePath = paramString2;
      this.version = paramInt1;
      this.cBI = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bq
 * JD-Core Version:    0.7.0.1
 */