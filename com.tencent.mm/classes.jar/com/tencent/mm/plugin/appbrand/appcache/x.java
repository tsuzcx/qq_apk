package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public enum x
  implements b
{
  private String jGA = null;
  private int jGz = -1;
  
  static
  {
    AppMethodBeat.i(44302);
    jGy = new x("INSTANCE");
    jGB = new x[] { jGy };
    AppMethodBeat.o(44302);
  }
  
  private x() {}
  
  final void T(int paramInt, String paramString)
  {
    this.jGz = paramInt;
    this.jGA = paramString;
  }
  
  public final void fH(boolean paramBoolean)
  {
    AppMethodBeat.i(44301);
    Object localObject = WxaPkgIntegrityChecker.r(paramBoolean, true);
    if (((Pair)localObject).second != null)
    {
      AppMethodBeat.o(44301);
      return;
    }
    if (((Pair)localObject).first == WxaPkgIntegrityChecker.a.jIp)
    {
      localObject = j.aYX();
      if (paramBoolean)
      {
        i = 0;
        localObject = ((bg)localObject).a("@LibraryAppId", i, new String[] { "downloadURL", "version" });
        if ((localObject == null) || (bt.isNullOrNil(((bc)localObject).field_downloadURL))) {
          break label283;
        }
        if (!paramBoolean) {
          break label206;
        }
      }
      bi.a local1;
      label206:
      for (final int i = ((bc)localObject).field_version;; i = 0)
      {
        local1 = new bi.a() {};
        if (!paramBoolean) {
          break label259;
        }
        if ((this.jGz <= 0) || (bt.isNullOrNil(this.jGA))) {
          break label239;
        }
        paramBoolean = u.aZR();
        ad.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] lib can be patch, abtest open %b", new Object[] { Boolean.valueOf(paramBoolean) });
        if (!paramBoolean) {
          break label239;
        }
        if (WxaPkgIntegrityChecker.D("@LibraryAppId", 0, this.jGz).first != WxaPkgIntegrityChecker.a.jIl) {
          break label211;
        }
        ad.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] start incremental lib download");
        s.a("@LibraryAppId", this.jGz, ((bc)localObject).field_version, this.jGA, local1);
        AppMethodBeat.o(44301);
        return;
        i = 999;
        break;
      }
      label211:
      ad.e("MicroMsg.AppBrand.PkgDownloadService", "[incremental] OldLibPkg[%d] or PatchUrl[%s] Invalid", new Object[] { Integer.valueOf(this.jGz), this.jGA });
      label239:
      bi.a(((bc)localObject).field_downloadURL, ((bc)localObject).field_version, local1);
      AppMethodBeat.o(44301);
      return;
      label259:
      bi.a("@LibraryAppId", 999, ((bc)localObject).field_downloadURL, local1, new a.a()
      {
        public final String aZW()
        {
          AppMethodBeat.i(44298);
          String str = "_" + this.jGE.field_versionMd5;
          AppMethodBeat.o(44298);
          return str;
        }
      });
    }
    label283:
    AppMethodBeat.o(44301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.x
 * JD-Core Version:    0.7.0.1
 */