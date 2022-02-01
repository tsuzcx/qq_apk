package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public enum w
  implements b
{
  private int jmD = -1;
  private String jmE = null;
  
  static
  {
    AppMethodBeat.i(44302);
    jmC = new w("INSTANCE");
    jmF = new w[] { jmC };
    AppMethodBeat.o(44302);
  }
  
  private w() {}
  
  final void R(int paramInt, String paramString)
  {
    this.jmD = paramInt;
    this.jmE = paramString;
  }
  
  public final void fD(boolean paramBoolean)
  {
    AppMethodBeat.i(44301);
    Object localObject = WxaPkgIntegrityChecker.r(paramBoolean, true);
    if (((Pair)localObject).second != null)
    {
      AppMethodBeat.o(44301);
      return;
    }
    if (((Pair)localObject).first == WxaPkgIntegrityChecker.a.jot)
    {
      localObject = j.aVC();
      if (paramBoolean)
      {
        i = 0;
        localObject = ((bf)localObject).a("@LibraryAppId", i, new String[] { "downloadURL", "version" });
        if ((localObject == null) || (bs.isNullOrNil(((bb)localObject).field_downloadURL))) {
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
        if ((this.jmD <= 0) || (bs.isNullOrNil(this.jmE))) {
          break label239;
        }
        paramBoolean = u.aWw();
        ac.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] lib can be patch, abtest open %b", new Object[] { Boolean.valueOf(paramBoolean) });
        if (!paramBoolean) {
          break label239;
        }
        if (WxaPkgIntegrityChecker.B("@LibraryAppId", 0, this.jmD).first != WxaPkgIntegrityChecker.a.jop) {
          break label211;
        }
        ac.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] start incremental lib download");
        s.a("@LibraryAppId", this.jmD, ((bb)localObject).field_version, this.jmE, local1);
        AppMethodBeat.o(44301);
        return;
        i = 999;
        break;
      }
      label211:
      ac.e("MicroMsg.AppBrand.PkgDownloadService", "[incremental] OldLibPkg[%d] or PatchUrl[%s] Invalid", new Object[] { Integer.valueOf(this.jmD), this.jmE });
      label239:
      bh.a(((bb)localObject).field_downloadURL, ((bb)localObject).field_version, local1);
      AppMethodBeat.o(44301);
      return;
      label259:
      bh.a("@LibraryAppId", 999, ((bb)localObject).field_downloadURL, local1, new a.a()
      {
        public final String aWB()
        {
          AppMethodBeat.i(44298);
          String str = "_" + this.jmI.field_versionMd5;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.w
 * JD-Core Version:    0.7.0.1
 */