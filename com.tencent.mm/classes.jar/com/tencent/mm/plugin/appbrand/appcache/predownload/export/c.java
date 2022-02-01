package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bq;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.i;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.service.x;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgStorageExportService;", "()V", "occupiedPkgSet", "Ljava/util/concurrent/ConcurrentSkipListSet;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl$OccupiedPkgKey;", "getOccupiedPkgList", "", "getPkgRecord", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "appId", "", "versionType", "", "version", "getServerNotifiedReleaseVersion", "insertPkg", "", "filePath", "setPkgIsOccupied", "", "Companion", "OccupiedPkgKey", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements x
{
  public static final a qJW;
  private final ConcurrentSkipListSet<c.b> qJX;
  
  static
  {
    AppMethodBeat.i(320539);
    qJW = new a((byte)0);
    AppMethodBeat.o(320539);
  }
  
  public c()
  {
    AppMethodBeat.i(320526);
    this.qJX = new ConcurrentSkipListSet();
    AppMethodBeat.o(320526);
  }
  
  public static final c chy()
  {
    AppMethodBeat.i(320532);
    c localc = a.chy();
    AppMethodBeat.o(320532);
    return localc;
  }
  
  public final bh L(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(320561);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(320561);
      return null;
    }
    if (paramInt2 == 0)
    {
      localObject = n.cfm().c(paramString, paramInt1, new String[0]);
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
      if ((paramInt1 != 0) || (!y.ZC(((bh)localObject).field_pkgPath))) {
        break label184;
      }
      if (!bq.a(new u(((bh)localObject).field_pkgPath), new String[] { ((bh)localObject).field_versionMd5, ((bh)localObject).field_NewMd5 }, paramString, "getPkgRecord")) {
        break label184;
      }
      AppMethodBeat.o(320561);
      return localObject;
      localObject = n.cfm().b(paramString, paramInt2, paramInt1, new String[0]);
      break;
    }
    label184:
    AppMethodBeat.o(320561);
    return null;
  }
  
  public final bh VK(String paramString)
  {
    AppMethodBeat.i(320558);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(320558);
      return null;
    }
    localObject = n.cfm().c(paramString, 0, new String[0]);
    if (localObject != null)
    {
      CharSequence localCharSequence = (CharSequence)((bh)localObject).field_pkgPath;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (i = 1; (i == 0) && (y.ZC(((bh)localObject).field_pkgPath)); i = 0)
      {
        if (!bq.a(new u(((bh)localObject).field_pkgPath), new String[] { ((bh)localObject).field_versionMd5, ((bh)localObject).field_NewMd5 }, paramString, "getPkgRecord")) {
          break;
        }
        AppMethodBeat.o(320558);
        return localObject;
      }
    }
    AppMethodBeat.o(320558);
    return null;
  }
  
  public final int VL(String paramString)
  {
    AppMethodBeat.i(320589);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(320589);
      return 0;
    }
    localObject = ad.XL(paramString);
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0)
      {
        localObject = w.raK;
        localObject = (String)w.ckT().get(paramString);
      }
      localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label133;
      }
      i = 1;
      label111:
      if (i == 0) {
        break label138;
      }
      i = 0;
    }
    for (;;)
    {
      if (i < 0) {
        break label168;
      }
      AppMethodBeat.o(320589);
      return i;
      i = 0;
      break;
      label133:
      i = 0;
      break label111;
      label138:
      localObject = ((j)n.ag(j.class)).VM((String)localObject);
      if (localObject == null) {
        i = 0;
      } else {
        i = ((i)localObject).field_appVersion;
      }
    }
    label168:
    localObject = n.cfc();
    if (localObject == null)
    {
      AppMethodBeat.o(320589);
      return 0;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.config.af)localObject).e(paramString, new String[] { "versionInfo" });
    if (paramString == null)
    {
      AppMethodBeat.o(320589);
      return 0;
    }
    paramString = paramString.clf();
    if (paramString == null)
    {
      AppMethodBeat.o(320589);
      return 0;
    }
    i = paramString.appVersion;
    AppMethodBeat.o(320589);
    return i;
  }
  
  public final void bM(String paramString, int paramInt)
  {
    AppMethodBeat.i(320567);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(320567);
      return;
    }
    this.qJX.add(new c.b(paramString, paramInt));
    AppMethodBeat.o(320567);
  }
  
  public final List<c.b> chx()
  {
    AppMethodBeat.i(320577);
    List localList = (List)new LinkedList((Collection)this.qJX);
    AppMethodBeat.o(320577);
    return localList;
  }
  
  public final boolean v(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(320549);
    if (y.ZC(paramString2))
    {
      localObject = (CharSequence)paramString1;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label48;
      }
    }
    label48:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(320549);
      return false;
    }
    Object localObject = be.bC(new com.tencent.mm.plugin.appbrand.appcache.af(paramString1).toString(), paramInt);
    if (!FilesCopy.copy(paramString2, (String)localObject, false))
    {
      Log.e("MicroMsg.WxaPkgStorageExportServiceImpl", "copy pkg failed: appId[%s] version[%d] from %s to %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, localObject });
      AppMethodBeat.o(320549);
      return false;
    }
    try
    {
      s.checkNotNull(localObject);
      String str = WxaPkgWrappingInfo.n(new u((String)localObject));
      paramString2 = new bh();
      paramString2.field_appId = paramString1;
      paramString2.field_version = paramInt;
      paramString2.field_debugType = 0;
      paramString2.field_pkgPath = ((String)localObject);
      paramString2.field_versionMd5 = str;
      paramString2.field_NewMd5 = str;
      boolean bool = n.cfm().d(paramString2);
      AppMethodBeat.o(320549);
      return bool;
    }
    catch (IOException localIOException)
    {
      Log.e("MicroMsg.WxaPkgStorageExportServiceImpl", "insertPkg(appId:" + paramString1 + ", version:" + paramInt + ", filePath:" + paramString2 + "), get exception:" + localIOException);
      AppMethodBeat.o(320549);
    }
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl$Companion;", "", "()V", "TAG", "", "VERSION_UNDEFINED", "", "INSTANCE", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static c chy()
    {
      AppMethodBeat.i(320531);
      Object localObject = h.ax(x.class);
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceImpl");
        AppMethodBeat.o(320531);
        throw ((Throwable)localObject);
      }
      localObject = (c)localObject;
      AppMethodBeat.o(320531);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.c
 * JD-Core Version:    0.7.0.1
 */