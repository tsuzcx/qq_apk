package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.b;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public enum z
  implements b
{
  private int nFp = -1;
  private String nFq = null;
  
  static
  {
    AppMethodBeat.i(44302);
    nFo = new z("INSTANCE");
    nFr = new z[] { nFo };
    AppMethodBeat.o(44302);
  }
  
  private z() {}
  
  final void Y(int paramInt, String paramString)
  {
    this.nFp = paramInt;
    this.nFq = paramString;
  }
  
  public final void hm(boolean paramBoolean)
  {
    AppMethodBeat.i(44301);
    Object localObject = WxaPkgIntegrityChecker.hu(paramBoolean);
    if (((Pair)localObject).second != null)
    {
      Log.i("MicroMsg.AppBrand.PkgDownloadService", "checkLibUnbrokenOrDownload, releaseLib:%b, skipLocalDevPack:true, already cached, version:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(((WxaPkgWrappingInfo)((Pair)localObject).second).pkgVersion()) });
      AppMethodBeat.o(44301);
      return;
    }
    if (((Pair)localObject).first == WxaPkgIntegrityChecker.a.nHp)
    {
      localObject = m.bFP();
      if (paramBoolean)
      {
        i = 0;
        localObject = ((bm)localObject).c("@LibraryAppId", i, new String[] { "downloadURL", "version" });
        if ((localObject == null) || (Util.isNullOrNil(((bh)localObject).field_downloadURL))) {
          break label317;
        }
        if (!paramBoolean) {
          break label239;
        }
      }
      z.1 local1;
      label239:
      for (int i = ((bh)localObject).field_version;; i = 0)
      {
        local1 = new z.1(this, i);
        if (!paramBoolean) {
          break label292;
        }
        if ((this.nFp <= 0) || (Util.isNullOrNil(this.nFq))) {
          break label272;
        }
        paramBoolean = w.bGM();
        Log.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] lib can be patch, abtest open %b", new Object[] { Boolean.valueOf(paramBoolean) });
        if (!paramBoolean) {
          break label272;
        }
        if (WxaPkgIntegrityChecker.D("@LibraryAppId", 0, this.nFp).first != WxaPkgIntegrityChecker.a.nHl) {
          break label244;
        }
        Log.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] start incremental lib download");
        t.a("@LibraryAppId", this.nFp, ((bh)localObject).field_version, this.nFq, local1);
        AppMethodBeat.o(44301);
        return;
        i = 999;
        break;
      }
      label244:
      Log.e("MicroMsg.AppBrand.PkgDownloadService", "[incremental] OldLibPkg[%d] or PatchUrl[%s] Invalid", new Object[] { Integer.valueOf(this.nFp), this.nFq });
      label272:
      bq.a(((bh)localObject).field_downloadURL, ((bh)localObject).field_version, local1);
      AppMethodBeat.o(44301);
      return;
      label292:
      bq.a("@LibraryAppId", 999, null, ((bh)localObject).field_downloadURL, local1, new a.a()
      {
        public final String bGQ()
        {
          AppMethodBeat.i(44298);
          String str = "_" + this.nFu.field_versionMd5;
          AppMethodBeat.o(44298);
          return str;
        }
      });
    }
    label317:
    AppMethodBeat.o(44301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.z
 * JD-Core Version:    0.7.0.1
 */