package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public enum n
  implements a
{
  private int fCE = -1;
  private String fCF = null;
  
  private n() {}
  
  public final void cF(boolean paramBoolean)
  {
    Object localObject = am.o(paramBoolean, true);
    if (((Pair)localObject).second != null) {}
    do
    {
      do
      {
        return;
      } while (((Pair)localObject).first != am.a.fEg);
      localObject = e.abb();
      if (!paramBoolean) {
        break;
      }
      i = 0;
      localObject = ((ar)localObject).a("@LibraryAppId", i, new String[] { "downloadURL", "version" });
    } while ((localObject == null) || (bk.bl(((an)localObject).field_downloadURL)));
    if (paramBoolean) {}
    n.1 local1;
    for (int i = ((an)localObject).field_version;; i = 0)
    {
      local1 = new n.1(this, i);
      if (!paramBoolean) {
        break label239;
      }
      if ((this.fCE <= 0) || (bk.bl(this.fCF))) {
        break label224;
      }
      paramBoolean = l.abG();
      y.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] lib can be patch, abtest open %b", new Object[] { Boolean.valueOf(paramBoolean) });
      if (!paramBoolean) {
        break label224;
      }
      if (am.t("@LibraryAppId", 0, this.fCE).first != am.a.fEc) {
        break label196;
      }
      y.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] start incremental lib download");
      j.a("@LibraryAppId", this.fCE, ((an)localObject).field_version, this.fCF, local1);
      return;
      i = 999;
      break;
    }
    label196:
    y.e("MicroMsg.AppBrand.PkgDownloadService", "[incremental] OldLibPkg[%d] or PatchUrl[%s] Invalid", new Object[] { Integer.valueOf(this.fCE), this.fCF });
    label224:
    at.a(((an)localObject).field_downloadURL, ((an)localObject).field_version, local1);
    return;
    label239:
    at.a(((an)localObject).field_downloadURL, local1);
  }
  
  final void y(int paramInt, String paramString)
  {
    this.fCE = paramInt;
    this.fCF = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.n
 * JD-Core Version:    0.7.0.1
 */