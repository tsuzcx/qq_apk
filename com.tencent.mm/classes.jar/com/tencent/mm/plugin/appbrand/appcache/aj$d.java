package com.tencent.mm.plugin.appbrand.appcache;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.pluginsdk.g.a.c.k;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class aj$d
  implements com.tencent.mm.pluginsdk.g.a.c.c
{
  final ah fDT = new ah(new ai("WxaPkgDownloadPerformerEventDispatchThread").mnU.getLooper());
  
  aj$d(aj paramaj) {}
  
  private static void a(aj.c paramc, m paramm)
  {
    com.tencent.mm.vfs.e.deleteFile(paramm.filePath);
    if ((paramc.aca() instanceof f))
    {
      localObject = e.fBV;
      f localf = (f)paramc.aca();
      paramc = paramc.fDS;
      ((e)localObject).a(localf, paramm);
      return;
    }
    if ((paramc.aca() instanceof af))
    {
      localObject = (af)paramc.aca();
      paramc = paramc.fDS;
      y.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, request(%s %d->%d)", new Object[] { ((af)localObject).appId, Integer.valueOf(((af)localObject).fDk), Integer.valueOf(((af)localObject).fDl) });
      paramc.a(paramm);
      paramc = ((com.tencent.mm.plugin.appbrand.a.c)g.r(com.tencent.mm.plugin.appbrand.a.c.class)).aaG();
      if (paramc == null)
      {
        y.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil storage");
        at.a(((l)localObject).rVT, ((af)localObject).appId, b.a.a.fFa, null);
        return;
      }
      at.rl(((l)localObject).rVT);
      paramc = paramc.a(((af)localObject).appId, ((af)localObject).fDl, 0, new String[] { "downloadURL" });
      if (paramc == null)
      {
        y.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", new Object[] { ((af)localObject).appId, Integer.valueOf(((af)localObject).fDl) });
        return;
      }
      at.b(((af)localObject).appId, 0, ((af)localObject).fDl, paramc.field_downloadURL, ((af)localObject).fDm);
      return;
    }
    Object localObject = paramc.aca().appId;
    if ((paramm.rXE instanceof com.tencent.mm.pluginsdk.g.a.b.a)) {
      paramc = b.a.a.fEZ;
    }
    for (;;)
    {
      at.a(paramm.rVT, (String)localObject, paramc);
      return;
      switch (paramm.httpStatusCode)
      {
      default: 
        paramc = b.a.a.fEU;
        break;
      case 403: 
      case 404: 
        paramc = b.a.a.fEY;
      }
    }
  }
  
  public static void b(com.tencent.mm.pluginsdk.g.a.c.e parame, m paramm)
  {
    a((aj.c)parame, paramm);
  }
  
  public static void c(com.tencent.mm.pluginsdk.g.a.c.e parame, m paramm)
  {
    Object localObject2 = ((aj.c)parame).aca();
    if ((localObject2 instanceof af))
    {
      paramm = (af)localObject2;
      parame = ((aj.c)parame).fDS;
      localObject1 = ((com.tencent.mm.plugin.appbrand.a.c)g.r(com.tencent.mm.plugin.appbrand.a.c.class)).aaG();
      if (localObject1 == null)
      {
        at.a(paramm.rVT, paramm.appId, b.a.a.fFa, null);
        return;
      }
      Object localObject3 = paramm.appId;
      j = paramm.fDk;
      i = paramm.fDl;
      localObject2 = paramm.abS();
      an localan = ((ar)localObject1).a((String)localObject3, j, 0, new String[] { "pkgPath" });
      localObject3 = ((ar)localObject1).a((String)localObject3, i, 0, new String[] { "versionMd5" });
      if ((localan == null) || (localObject3 == null))
      {
        at.a(paramm.rVT, paramm.appId, b.a.a.fFa, null);
        return;
      }
      parame.abt();
      long l1 = SystemClock.elapsedRealtime();
      j = j.x(localan.field_pkgPath, (String)localObject2, paramm.bjl());
      long l2 = SystemClock.elapsedRealtime();
      y.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "applyPkgPatch, appId[%s], oldPath[%s], newPath[%s], patchPath[%s], cost %d, ret %d", new Object[] { paramm.appId, localan.field_pkgPath, localObject2, paramm.bjl(), Long.valueOf(l2 - l1), Integer.valueOf(j) });
      parame.kr(j);
      if (j == 0)
      {
        at.a(paramm.rVT, paramm.appId, (String)localObject2, i, 0, parame);
        return;
      }
      com.tencent.mm.vfs.e.deleteFile((String)localObject2);
      parame = ((ar)localObject1).a(paramm.appId, paramm.fDl, 0, new String[] { "downloadURL" });
      if (parame == null)
      {
        at.a(paramm.rVT, paramm.appId, b.a.a.fFa, null);
        return;
      }
      at.rl(paramm.rVT);
      at.b(paramm.appId, 0, paramm.fDl, parame.field_downloadURL, paramm.fDm);
      return;
    }
    if ((localObject2 instanceof f))
    {
      localObject1 = e.fBV;
      localObject2 = (f)localObject2;
      parame = ((aj.c)parame).fDS;
      ((e)localObject1).a((f)localObject2, paramm);
      return;
    }
    Object localObject1 = ((aj.c)parame).aca().appId;
    int i = ((aj.c)parame).aca().version;
    int j = ((aj.c)parame).aca().bOa;
    try
    {
      at.a(paramm.rVT, (String)localObject1, paramm.filePath, i, j, ((aj.c)parame).fDS);
      return;
    }
    catch (Exception parame)
    {
      y.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", parame, "dispatchComplete", new Object[0]);
      at.aY(paramm.rVT, (String)localObject1);
    }
  }
  
  public static void d(com.tencent.mm.pluginsdk.g.a.c.e parame, m paramm)
  {
    a((aj.c)parame, paramm);
  }
  
  public final void a(final com.tencent.mm.pluginsdk.g.a.c.e parame, final m paramm)
  {
    this.fDT.post(new Runnable()
    {
      public final void run()
      {
        switch (paramm.status)
        {
        default: 
          return;
        case 4: 
          aj.d.d(parame, paramm);
          return;
        case 2: 
          aj.d.c(parame, paramm);
          return;
        }
        aj.d.b(parame, paramm);
      }
    });
  }
  
  public final void a(String paramString, k paramk)
  {
    at.a(paramString, (WxaPkgLoadProgress)paramk);
  }
  
  public final void s(String paramString, int paramInt1, int paramInt2) {}
  
  public final void u(String paramString, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj.d
 * JD-Core Version:    0.7.0.1
 */