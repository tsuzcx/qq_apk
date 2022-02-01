package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.b;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public enum y
  implements b
{
  private int kLw = -1;
  private String kLx = null;
  
  static
  {
    AppMethodBeat.i(44302);
    kLv = new y("INSTANCE");
    kLy = new y[] { kLv };
    AppMethodBeat.o(44302);
  }
  
  private y() {}
  
  final void W(int paramInt, String paramString)
  {
    this.kLw = paramInt;
    this.kLx = paramString;
  }
  
  public final void gB(boolean paramBoolean)
  {
    AppMethodBeat.i(44301);
    Object localObject = WxaPkgIntegrityChecker.r(paramBoolean, true);
    if (((Pair)localObject).second != null)
    {
      Log.i("MicroMsg.AppBrand.PkgDownloadService", "checkLibUnbrokenOrDownload, releaseLib:%b, skipLocalDevPack:true, already cached, version:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(((WxaPkgWrappingInfo)((Pair)localObject).second).pkgVersion()) });
      AppMethodBeat.o(44301);
      return;
    }
    if (((Pair)localObject).first == WxaPkgIntegrityChecker.a.kNp)
    {
      localObject = n.buL();
      if (paramBoolean)
      {
        i = 0;
        localObject = ((bh)localObject).a("@LibraryAppId", i, new String[] { "downloadURL", "version" });
        if ((localObject == null) || (Util.isNullOrNil(((bd)localObject).field_downloadURL))) {
          break label317;
        }
        if (!paramBoolean) {
          break label240;
        }
      }
      bj.a local1;
      label240:
      for (final int i = ((bd)localObject).field_version;; i = 0)
      {
        local1 = new bj.a() {};
        if (!paramBoolean) {
          break label293;
        }
        if ((this.kLw <= 0) || (Util.isNullOrNil(this.kLx))) {
          break label273;
        }
        paramBoolean = v.bvF();
        Log.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] lib can be patch, abtest open %b", new Object[] { Boolean.valueOf(paramBoolean) });
        if (!paramBoolean) {
          break label273;
        }
        if (WxaPkgIntegrityChecker.D("@LibraryAppId", 0, this.kLw).first != WxaPkgIntegrityChecker.a.kNl) {
          break label245;
        }
        Log.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] start incremental lib download");
        s.a("@LibraryAppId", this.kLw, ((bd)localObject).field_version, this.kLx, local1);
        AppMethodBeat.o(44301);
        return;
        i = 999;
        break;
      }
      label245:
      Log.e("MicroMsg.AppBrand.PkgDownloadService", "[incremental] OldLibPkg[%d] or PatchUrl[%s] Invalid", new Object[] { Integer.valueOf(this.kLw), this.kLx });
      label273:
      bj.a(((bd)localObject).field_downloadURL, ((bd)localObject).field_version, local1);
      AppMethodBeat.o(44301);
      return;
      label293:
      bj.a("@LibraryAppId", 999, ((bd)localObject).field_downloadURL, local1, new a.a()
      {
        public final String bvJ()
        {
          AppMethodBeat.i(44298);
          String str = "_" + this.kLB.field_versionMd5;
          AppMethodBeat.o(44298);
          return str;
        }
      });
    }
    label317:
    AppMethodBeat.o(44301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.y
 * JD-Core Version:    0.7.0.1
 */