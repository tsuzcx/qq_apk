package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.service.v;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgStorageExportService;", "()V", "occupiedPkgSet", "Ljava/util/concurrent/ConcurrentSkipListSet;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl$OccupiedPkgKey;", "getOccupiedPkgList", "", "getPkgRecord", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "appId", "", "versionType", "", "version", "insertPkg", "", "filePath", "setPkgIsOccupied", "", "Companion", "OccupiedPkgKey", "plugin-appbrand-integration_release"})
public final class c
  implements v
{
  public static final a kQs;
  private final ConcurrentSkipListSet<b> kQr;
  
  static
  {
    AppMethodBeat.i(228114);
    kQs = new a((byte)0);
    AppMethodBeat.o(228114);
  }
  
  public c()
  {
    AppMethodBeat.i(228113);
    this.kQr = new ConcurrentSkipListSet();
    AppMethodBeat.o(228113);
  }
  
  public static final c bwU()
  {
    AppMethodBeat.i(228115);
    c localc = a.bwU();
    AppMethodBeat.o(228115);
    return localc;
  }
  
  public final bd H(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228111);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(228111);
      return null;
    }
    if (paramInt2 == 0)
    {
      localObject = n.buL().a(paramString, paramInt1, new String[0]);
      if (localObject == null) {
        break label184;
      }
      CharSequence localCharSequence = (CharSequence)((bd)localObject).field_pkgPath;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label179;
      }
    }
    label179:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt1 != 0) || (!s.YS(((bd)localObject).field_pkgPath))) {
        break label184;
      }
      if (!bj.a(new o(((bd)localObject).field_pkgPath), new String[] { ((bd)localObject).field_versionMd5, ((bd)localObject).field_NewMd5 }, paramString, "getPkgRecord")) {
        break label184;
      }
      AppMethodBeat.o(228111);
      return localObject;
      localObject = n.buL().a(paramString, paramInt2, paramInt1, new String[0]);
      break;
    }
    label184:
    AppMethodBeat.o(228111);
    return null;
  }
  
  public final bd VF(String paramString)
  {
    AppMethodBeat.i(228110);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(228110);
      return null;
    }
    localObject = n.buL().a(paramString, 0, new String[0]);
    if (localObject != null)
    {
      CharSequence localCharSequence = (CharSequence)((bd)localObject).field_pkgPath;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (i = 1; (i == 0) && (s.YS(((bd)localObject).field_pkgPath)); i = 0)
      {
        if (!bj.a(new o(((bd)localObject).field_pkgPath), new String[] { ((bd)localObject).field_versionMd5, ((bd)localObject).field_NewMd5 }, paramString, "getPkgRecord")) {
          break;
        }
        AppMethodBeat.o(228110);
        return localObject;
      }
    }
    AppMethodBeat.o(228110);
    return null;
  }
  
  public final void bc(String paramString, int paramInt)
  {
    AppMethodBeat.i(228112);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(228112);
      return;
    }
    this.kQr.add(new b(paramString, paramInt));
    AppMethodBeat.o(228112);
  }
  
  public final List<b> bxg()
  {
    AppMethodBeat.i(258046);
    List localList = (List)new LinkedList((Collection)this.kQr);
    AppMethodBeat.o(258046);
    return localList;
  }
  
  public final boolean s(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(228109);
    if (s.YS(paramString2))
    {
      localObject = (CharSequence)paramString1;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label48;
      }
    }
    label48:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(228109);
      return false;
    }
    Object localObject = ba.aT(new ad(paramString1).toString(), paramInt);
    if (!FilesCopy.copy(paramString2, (String)localObject, false))
    {
      Log.e("MicroMsg.WxaPkgStorageExportServiceImpl", "copy pkg failed: appId[%s] version[%d] from %s to %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, localObject });
      AppMethodBeat.o(228109);
      return false;
    }
    paramString2 = new bd();
    paramString2.field_appId = paramString1;
    paramString2.field_version = paramInt;
    paramString2.field_debugType = 0;
    paramString2.field_pkgPath = ((String)localObject);
    if (localObject == null) {
      p.hyc();
    }
    paramString2.field_versionMd5 = WxaPkgWrappingInfo.n(new o((String)localObject));
    boolean bool = n.buL().b(paramString2);
    AppMethodBeat.o(228109);
    return bool;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl$Companion;", "", "()V", "TAG", "", "VERSION_UNDEFINED", "", "INSTANCE", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static c bwU()
    {
      AppMethodBeat.i(228103);
      Object localObject = g.af(v.class);
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceImpl");
        AppMethodBeat.o(228103);
        throw ((Throwable)localObject);
      }
      localObject = (c)localObject;
      AppMethodBeat.o(228103);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl$OccupiedPkgKey;", "", "appId", "", "versionType", "", "version", "(Ljava/lang/String;II)V", "getAppId", "()Ljava/lang/String;", "getVersion", "()I", "getVersionType", "compareTo", "other", "component1", "component2", "component3", "copy", "equals", "", "", "hashCode", "toString", "plugin-appbrand-integration_release"})
  public static final class b
    implements Comparable<b>
  {
    public final String appId;
    public final int iOo;
    public final int version;
    
    public b(String paramString, int paramInt)
    {
      AppMethodBeat.i(228107);
      this.appId = paramString;
      this.iOo = 0;
      this.version = paramInt;
      AppMethodBeat.o(228107);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(228104);
      if ((b)this == paramObject)
      {
        AppMethodBeat.o(228104);
        return true;
      }
      Class localClass2 = getClass();
      if (paramObject != null) {}
      for (Class localClass1 = paramObject.getClass(); (p.j(localClass2, localClass1) ^ true); localClass1 = null)
      {
        AppMethodBeat.o(228104);
        return false;
      }
      if (paramObject == null)
      {
        paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceImpl.OccupiedPkgKey");
        AppMethodBeat.o(228104);
        throw paramObject;
      }
      if ((p.j(this.appId, ((b)paramObject).appId) ^ true))
      {
        AppMethodBeat.o(228104);
        return false;
      }
      if (this.iOo != ((b)paramObject).iOo)
      {
        AppMethodBeat.o(228104);
        return false;
      }
      if (this.version != ((b)paramObject).version)
      {
        AppMethodBeat.o(228104);
        return false;
      }
      AppMethodBeat.o(228104);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(228105);
      int i = this.appId.hashCode();
      int j = this.iOo;
      int k = this.version;
      AppMethodBeat.o(228105);
      return (i * 31 + j) * 31 + k;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(228108);
      String str = "OccupiedPkgKey(appId=" + this.appId + ", versionType=" + this.iOo + ", version=" + this.version + ")";
      AppMethodBeat.o(228108);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.c
 * JD-Core Version:    0.7.0.1
 */