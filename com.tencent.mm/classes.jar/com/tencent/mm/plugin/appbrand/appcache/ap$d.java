package com.tencent.mm.plugin.appbrand.appcache;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.pluginsdk.g.a.c.c;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class ap$d
  implements c
{
  final ak gWj;
  
  ap$d(ap paramap)
  {
    AppMethodBeat.i(59500);
    this.gWj = new ak(new com.tencent.mm.sdk.platformtools.al("WxaPkgDownloadPerformerEventDispatchThread").oNc.getLooper());
    AppMethodBeat.o(59500);
  }
  
  private static void a(ap.c paramc, m paramm)
  {
    AppMethodBeat.i(59506);
    com.tencent.mm.vfs.e.deleteFile(paramm.filePath);
    if ((paramc.avR() instanceof l))
    {
      k.gUg.a((l)paramc.avR(), paramm);
      AppMethodBeat.o(59506);
      return;
    }
    if ((paramc.avR() instanceof al))
    {
      p.a((al)paramc.avR(), paramm, paramc.gWi);
      AppMethodBeat.o(59506);
      return;
    }
    if ((paramc.avR() instanceof bd))
    {
      be.a((bd)paramc.avR(), paramm, paramc.gWi);
      AppMethodBeat.o(59506);
      return;
    }
    String str = paramc.avR().appId;
    if ((paramm.vOv instanceof com.tencent.mm.pluginsdk.g.a.b.a)) {
      paramc = b.a.a.gXr;
    }
    for (;;)
    {
      ba.a(paramm.vMK, str, paramc);
      AppMethodBeat.o(59506);
      return;
      switch (paramm.httpStatusCode)
      {
      default: 
        paramc = b.a.a.gXm;
        break;
      case 403: 
      case 404: 
        paramc = b.a.a.gXq;
      }
    }
  }
  
  public static void b(com.tencent.mm.pluginsdk.g.a.c.e parame, m paramm)
  {
    AppMethodBeat.i(59502);
    a((ap.c)parame, paramm);
    AppMethodBeat.o(59502);
  }
  
  public static void c(com.tencent.mm.pluginsdk.g.a.c.e parame, m paramm)
  {
    AppMethodBeat.i(59503);
    Object localObject1 = ((ap.c)parame).avR();
    if ((localObject1 instanceof al))
    {
      paramm = (al)localObject1;
      parame = ((ap.c)parame).gWi;
      localObject1 = ((d)g.E(d.class)).we();
      if (localObject1 == null)
      {
        ba.a(paramm.vMK, paramm.appId, b.a.a.gXs, null);
        AppMethodBeat.o(59503);
        return;
      }
      Object localObject2 = paramm.appId;
      j = paramm.gVy;
      i = paramm.gVz;
      String str = paramm.avJ();
      at localat = ((ay)localObject1).a((String)localObject2, j, 0, new String[] { "pkgPath" });
      localObject2 = ((ay)localObject1).a((String)localObject2, i, 0, new String[] { "versionMd5" });
      if ((localat == null) || (localObject2 == null))
      {
        ba.a(paramm.vMK, paramm.appId, b.a.a.gXs, null);
        AppMethodBeat.o(59503);
        return;
      }
      parame.avk();
      long l1 = SystemClock.elapsedRealtime();
      j = p.B(localat.field_pkgPath, str, paramm.getFilePath());
      long l2 = SystemClock.elapsedRealtime();
      ab.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "applyPkgPatch, appId[%s], oldPath[%s], newPath[%s], patchPath[%s], cost %d, ret %d", new Object[] { paramm.appId, localat.field_pkgPath, str, paramm.getFilePath(), Long.valueOf(l2 - l1), Integer.valueOf(j) });
      parame.nl(j);
      if (j == 0)
      {
        ba.a(paramm.vMK, paramm.appId, str, i, 0, parame);
        AppMethodBeat.o(59503);
        return;
      }
      com.tencent.mm.vfs.e.deleteFile(str);
      parame = ((ay)localObject1).a(paramm.appId, paramm.gVz, 0, new String[] { "downloadURL" });
      if (parame == null)
      {
        ba.a(paramm.vMK, paramm.appId, b.a.a.gXs, null);
        AppMethodBeat.o(59503);
        return;
      }
      ba.yI(paramm.vMK);
      ba.b(paramm.appId, 0, paramm.gVz, parame.field_downloadURL, paramm.gVA);
      AppMethodBeat.o(59503);
      return;
    }
    if ((localObject1 instanceof bd))
    {
      paramm = (bd)localObject1;
      parame = ((ap.c)parame).gWi;
      localObject1 = ((d)g.E(d.class)).we();
      if (localObject1 == null)
      {
        ba.a(paramm.vMK, paramm.appId, b.a.a.gXs, null);
        AppMethodBeat.o(59503);
        return;
      }
      parame.avn();
      boolean bool = be.a(paramm);
      parame.dH(bool);
      ab.i("MicroMsg.AppBrand.ZstdLogic", "processZstd suc:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        ba.a(paramm.vMK, paramm.appId, paramm.awk(), paramm.gXf, paramm.cvs, parame);
        AppMethodBeat.o(59503);
        return;
      }
      com.tencent.mm.vfs.e.deleteFile(paramm.awk());
      parame = ((ay)localObject1).a(paramm.appId, paramm.gXf, paramm.cvs, new String[] { "downloadURL" });
      if (parame == null)
      {
        ba.a(paramm.vMK, paramm.appId, b.a.a.gXs, null);
        AppMethodBeat.o(59503);
        return;
      }
      ba.yI(paramm.vMK);
      ba.b(paramm.appId, paramm.cvs, paramm.gXf, parame.field_downloadURL, paramm.gVA);
      AppMethodBeat.o(59503);
      return;
    }
    if ((localObject1 instanceof l))
    {
      k.gUg.a((l)localObject1, paramm);
      AppMethodBeat.o(59503);
      return;
    }
    localObject1 = ((ap.c)parame).avR().appId;
    int i = ((ap.c)parame).avR().version;
    int j = ((ap.c)parame).avR().cvs;
    try
    {
      ba.a(paramm.vMK, (String)localObject1, paramm.filePath, i, j, ((ap.c)parame).gWi);
      AppMethodBeat.o(59503);
      return;
    }
    catch (Exception parame)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", parame, "dispatchComplete", new Object[0]);
      ba.bu(paramm.vMK, (String)localObject1);
      AppMethodBeat.o(59503);
    }
  }
  
  public static void d(com.tencent.mm.pluginsdk.g.a.c.e parame, m paramm)
  {
    AppMethodBeat.i(59504);
    a((ap.c)parame, paramm);
    AppMethodBeat.o(59504);
  }
  
  public final void D(String paramString, long paramLong) {}
  
  public final void E(String paramString, int paramInt1, int paramInt2) {}
  
  public final void a(com.tencent.mm.pluginsdk.g.a.c.e parame, m paramm)
  {
    AppMethodBeat.i(59501);
    this.gWj.post(new ap.d.1(this, paramm, parame));
    AppMethodBeat.o(59501);
  }
  
  public final void a(String paramString, com.tencent.mm.pluginsdk.g.a.c.k paramk)
  {
    AppMethodBeat.i(59505);
    ba.a(paramString, (WxaPkgLoadProgress)paramk);
    AppMethodBeat.o(59505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ap.d
 * JD-Core Version:    0.7.0.1
 */