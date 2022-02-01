package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.b;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public enum ab
  implements b
{
  private int qFl = -1;
  private String qFm = null;
  
  static
  {
    AppMethodBeat.i(44302);
    qFk = new ab("INSTANCE");
    qFn = new ab[] { qFk };
    AppMethodBeat.o(44302);
  }
  
  private ab() {}
  
  final void ag(int paramInt, String paramString)
  {
    this.qFl = paramInt;
    this.qFm = paramString;
  }
  
  public final void id(boolean paramBoolean)
  {
    AppMethodBeat.i(44301);
    Object localObject = WxaPkgIntegrityChecker.il(paramBoolean);
    if (((Pair)localObject).second != null)
    {
      Log.i("MicroMsg.AppBrand.PkgDownloadService", "checkLibUnbrokenOrDownload, releaseLib:%b, skipLocalDevPack:true, already cached, version:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(((WxaPkgWrappingInfo)((Pair)localObject).second).pkgVersion()) });
      AppMethodBeat.o(44301);
      return;
    }
    if (((Pair)localObject).first == WxaPkgIntegrityChecker.a.qHc)
    {
      localObject = n.cfm();
      if (paramBoolean)
      {
        i = 0;
        localObject = ((bm)localObject).c("@LibraryAppId", i, new String[] { "downloadURL", "version" });
        if ((localObject == null) || (Util.isNullOrNil(((bh)localObject).field_downloadURL))) {
          break label318;
        }
        if (!paramBoolean) {
          break label240;
        }
      }
      bq.a local1;
      label240:
      for (final int i = ((bh)localObject).field_version;; i = 0)
      {
        local1 = new bq.a() {};
        if (!paramBoolean) {
          break label293;
        }
        if ((this.qFl <= 0) || (Util.isNullOrNil(this.qFm))) {
          break label273;
        }
        paramBoolean = y.cgl();
        Log.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] lib can be patch, abtest open %b", new Object[] { Boolean.valueOf(paramBoolean) });
        if (!paramBoolean) {
          break label273;
        }
        if (WxaPkgIntegrityChecker.H("@LibraryAppId", 0, this.qFl).first != WxaPkgIntegrityChecker.a.qGY) {
          break label245;
        }
        Log.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] start incremental lib download");
        v.a("@LibraryAppId", this.qFl, ((bh)localObject).field_version, this.qFm, null, local1);
        AppMethodBeat.o(44301);
        return;
        i = 999;
        break;
      }
      label245:
      Log.e("MicroMsg.AppBrand.PkgDownloadService", "[incremental] OldLibPkg[%d] or PatchUrl[%s] Invalid", new Object[] { Integer.valueOf(this.qFl), this.qFm });
      label273:
      bq.a(((bh)localObject).field_downloadURL, ((bh)localObject).field_version, local1);
      AppMethodBeat.o(44301);
      return;
      label293:
      bq.a("@LibraryAppId", 999, null, ((bh)localObject).field_downloadURL, local1, new a.a()
      {
        public final String append()
        {
          AppMethodBeat.i(44298);
          String str = "_" + this.qFq.field_versionMd5;
          AppMethodBeat.o(44298);
          return str;
        }
      });
    }
    label318:
    AppMethodBeat.o(44301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ab
 * JD-Core Version:    0.7.0.1
 */