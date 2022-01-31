package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public enum t
  implements b
{
  private int gUU = -1;
  private String gUV = null;
  
  static
  {
    AppMethodBeat.i(129396);
    gUT = new t("INSTANCE");
    gUW = new t[] { gUT };
    AppMethodBeat.o(129396);
  }
  
  private t() {}
  
  final void H(int paramInt, String paramString)
  {
    this.gUU = paramInt;
    this.gUV = paramString;
  }
  
  public final void dF(boolean paramBoolean)
  {
    AppMethodBeat.i(129395);
    Object localObject = as.p(paramBoolean, true);
    if (((Pair)localObject).second != null)
    {
      AppMethodBeat.o(129395);
      return;
    }
    if (((Pair)localObject).first == as.a.gWw)
    {
      localObject = g.auM();
      if (paramBoolean)
      {
        i = 0;
        localObject = ((ay)localObject).a("@LibraryAppId", i, new String[] { "downloadURL", "version" });
        if ((localObject == null) || (bo.isNullOrNil(((at)localObject).field_downloadURL))) {
          break label283;
        }
        if (!paramBoolean) {
          break label206;
        }
      }
      t.1 local1;
      label206:
      for (int i = ((at)localObject).field_version;; i = 0)
      {
        local1 = new t.1(this, i);
        if (!paramBoolean) {
          break label259;
        }
        if ((this.gUU <= 0) || (bo.isNullOrNil(this.gUV))) {
          break label239;
        }
        paramBoolean = r.avw();
        ab.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] lib can be patch, abtest open %b", new Object[] { Boolean.valueOf(paramBoolean) });
        if (!paramBoolean) {
          break label239;
        }
        if (as.F("@LibraryAppId", 0, this.gUU).first != as.a.gWs) {
          break label211;
        }
        ab.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] start incremental lib download");
        p.a("@LibraryAppId", this.gUU, ((at)localObject).field_version, this.gUV, local1);
        AppMethodBeat.o(129395);
        return;
        i = 999;
        break;
      }
      label211:
      ab.e("MicroMsg.AppBrand.PkgDownloadService", "[incremental] OldLibPkg[%d] or PatchUrl[%s] Invalid", new Object[] { Integer.valueOf(this.gUU), this.gUV });
      label239:
      ba.a(((at)localObject).field_downloadURL, ((at)localObject).field_version, local1);
      AppMethodBeat.o(129395);
      return;
      label259:
      ba.a("@LibraryAppId", 999, ((at)localObject).field_downloadURL, local1, new t.2(this, (at)localObject));
    }
    label283:
    AppMethodBeat.o(129395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.t
 * JD-Core Version:    0.7.0.1
 */