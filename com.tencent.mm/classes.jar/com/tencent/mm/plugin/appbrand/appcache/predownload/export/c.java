package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bq;
import com.tencent.mm.plugin.appbrand.service.v;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgStorageExportService;", "()V", "occupiedPkgSet", "Ljava/util/concurrent/ConcurrentSkipListSet;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl$OccupiedPkgKey;", "getOccupiedPkgList", "", "getPkgRecord", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "appId", "", "versionType", "", "version", "getServerNotifiedReleaseVersion", "insertPkg", "", "filePath", "setPkgIsOccupied", "", "Companion", "OccupiedPkgKey", "plugin-appbrand-integration_release"})
public final class c
  implements v
{
  public static final a nKy;
  private final ConcurrentSkipListSet<c.b> nKx;
  
  static
  {
    AppMethodBeat.i(262364);
    nKy = new a((byte)0);
    AppMethodBeat.o(262364);
  }
  
  public c()
  {
    AppMethodBeat.i(262362);
    this.nKx = new ConcurrentSkipListSet();
    AppMethodBeat.o(262362);
  }
  
  public static final c bIc()
  {
    AppMethodBeat.i(262368);
    c localc = a.bIc();
    AppMethodBeat.o(262368);
    return localc;
  }
  
  public final bh H(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262352);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(262352);
      return null;
    }
    if (paramInt2 == 0)
    {
      localObject = m.bFP().c(paramString, paramInt1, new String[0]);
      if (localObject == null) {
        break label184;
      }
      CharSequence localCharSequence = (CharSequence)((bh)localObject).field_pkgPath;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label179;
      }
    }
    label179:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt1 != 0) || (!u.agG(((bh)localObject).field_pkgPath))) {
        break label184;
      }
      if (!bq.a(new q(((bh)localObject).field_pkgPath), new String[] { ((bh)localObject).field_versionMd5, ((bh)localObject).field_NewMd5 }, paramString, "getPkgRecord")) {
        break label184;
      }
      AppMethodBeat.o(262352);
      return localObject;
      localObject = m.bFP().b(paramString, paramInt2, paramInt1, new String[0]);
      break;
    }
    label184:
    AppMethodBeat.o(262352);
    return null;
  }
  
  public final bh ado(String paramString)
  {
    AppMethodBeat.i(262348);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(262348);
      return null;
    }
    localObject = m.bFP().c(paramString, 0, new String[0]);
    if (localObject != null)
    {
      CharSequence localCharSequence = (CharSequence)((bh)localObject).field_pkgPath;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (i = 1; (i == 0) && (u.agG(((bh)localObject).field_pkgPath)); i = 0)
      {
        if (!bq.a(new q(((bh)localObject).field_pkgPath), new String[] { ((bh)localObject).field_versionMd5, ((bh)localObject).field_NewMd5 }, paramString, "getPkgRecord")) {
          break;
        }
        AppMethodBeat.o(262348);
        return localObject;
      }
    }
    AppMethodBeat.o(262348);
    return null;
  }
  
  public final int adp(String paramString)
  {
    AppMethodBeat.i(262360);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(262360);
      return 0;
    }
    localObject = c.c.nKz;
    localObject = c.d.nKA;
    i = c.c.adq(paramString);
    if (i >= 0)
    {
      AppMethodBeat.o(262360);
      return i;
    }
    i = c.d.adq(paramString);
    AppMethodBeat.o(262360);
    return i;
  }
  
  public final List<c.b> bIb()
  {
    AppMethodBeat.i(262357);
    List localList = (List)new LinkedList((Collection)this.nKx);
    AppMethodBeat.o(262357);
    return localList;
  }
  
  public final void bv(String paramString, int paramInt)
  {
    AppMethodBeat.i(262355);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(262355);
      return;
    }
    this.nKx.add(new c.b(paramString, paramInt));
    AppMethodBeat.o(262355);
  }
  
  public final boolean t(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(262344);
    if (u.agG(paramString2))
    {
      localObject = (CharSequence)paramString1;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label48;
      }
    }
    label48:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(262344);
      return false;
    }
    Object localObject = bd.bl(new ae(paramString1).toString(), paramInt);
    if (!FilesCopy.copy(paramString2, (String)localObject, false))
    {
      Log.e("MicroMsg.WxaPkgStorageExportServiceImpl", "copy pkg failed: appId[%s] version[%d] from %s to %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, localObject });
      AppMethodBeat.o(262344);
      return false;
    }
    if (localObject == null) {}
    try
    {
      p.iCn();
      String str = WxaPkgWrappingInfo.n(new q((String)localObject));
      paramString2 = new bh();
      paramString2.field_appId = paramString1;
      paramString2.field_version = paramInt;
      paramString2.field_debugType = 0;
      paramString2.field_pkgPath = ((String)localObject);
      paramString2.field_versionMd5 = str;
      paramString2.field_NewMd5 = str;
      boolean bool = m.bFP().d(paramString2);
      AppMethodBeat.o(262344);
      return bool;
    }
    catch (IOException localIOException)
    {
      Log.e("MicroMsg.WxaPkgStorageExportServiceImpl", "insertPkg(appId:" + paramString1 + ", version:" + paramInt + ", filePath:" + paramString2 + "), get exception:" + localIOException);
      AppMethodBeat.o(262344);
    }
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl$Companion;", "", "()V", "TAG", "", "VERSION_UNDEFINED", "", "INSTANCE", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static c bIc()
    {
      AppMethodBeat.i(282992);
      Object localObject = h.ae(v.class);
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceImpl");
        AppMethodBeat.o(282992);
        throw ((Throwable)localObject);
      }
      localObject = (c)localObject;
      AppMethodBeat.o(282992);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.c
 * JD-Core Version:    0.7.0.1
 */