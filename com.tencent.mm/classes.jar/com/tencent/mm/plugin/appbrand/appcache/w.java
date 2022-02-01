package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public enum w
  implements b
{
  private int iMw = -1;
  private String iMx = null;
  
  static
  {
    AppMethodBeat.i(44302);
    iMv = new w("INSTANCE");
    iMy = new w[] { iMv };
    AppMethodBeat.o(44302);
  }
  
  private w() {}
  
  final void Q(int paramInt, String paramString)
  {
    this.iMw = paramInt;
    this.iMx = paramString;
  }
  
  public final void fh(boolean paramBoolean)
  {
    AppMethodBeat.i(44301);
    Object localObject = WxaPkgIntegrityChecker.q(paramBoolean, true);
    if (((Pair)localObject).second != null)
    {
      AppMethodBeat.o(44301);
      return;
    }
    if (((Pair)localObject).first == WxaPkgIntegrityChecker.a.iOk)
    {
      localObject = j.aOK();
      if (paramBoolean)
      {
        i = 0;
        localObject = ((bf)localObject).a("@LibraryAppId", i, new String[] { "downloadURL", "version" });
        if ((localObject == null) || (bt.isNullOrNil(((bb)localObject).field_downloadURL))) {
          break label283;
        }
        if (!paramBoolean) {
          break label206;
        }
      }
      bh.a local1;
      label206:
      for (final int i = ((bb)localObject).field_version;; i = 0)
      {
        local1 = new bh.a() {};
        if (!paramBoolean) {
          break label259;
        }
        if ((this.iMw <= 0) || (bt.isNullOrNil(this.iMx))) {
          break label239;
        }
        paramBoolean = u.aPE();
        ad.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] lib can be patch, abtest open %b", new Object[] { Boolean.valueOf(paramBoolean) });
        if (!paramBoolean) {
          break label239;
        }
        if (WxaPkgIntegrityChecker.C("@LibraryAppId", 0, this.iMw).first != WxaPkgIntegrityChecker.a.iOg) {
          break label211;
        }
        ad.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] start incremental lib download");
        s.a("@LibraryAppId", this.iMw, ((bb)localObject).field_version, this.iMx, local1);
        AppMethodBeat.o(44301);
        return;
        i = 999;
        break;
      }
      label211:
      ad.e("MicroMsg.AppBrand.PkgDownloadService", "[incremental] OldLibPkg[%d] or PatchUrl[%s] Invalid", new Object[] { Integer.valueOf(this.iMw), this.iMx });
      label239:
      bh.a(((bb)localObject).field_downloadURL, ((bb)localObject).field_version, local1);
      AppMethodBeat.o(44301);
      return;
      label259:
      bh.a("@LibraryAppId", 999, ((bb)localObject).field_downloadURL, local1, new a.a()
      {
        public final String aPJ()
        {
          AppMethodBeat.i(44298);
          String str = "_" + this.iMB.field_versionMd5;
          AppMethodBeat.o(44298);
          return str;
        }
      });
    }
    label283:
    AppMethodBeat.o(44301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.w
 * JD-Core Version:    0.7.0.1
 */