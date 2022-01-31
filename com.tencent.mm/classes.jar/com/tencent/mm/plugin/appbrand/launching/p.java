package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.a.g;
import com.tencent.mm.ck.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.b;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.appcache.l;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.protocal.c.and;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.FileNotFoundException;
import java.util.Locale;

public final class p
  extends o
{
  public final String appId;
  public final int bOa = 0;
  public final String fCQ;
  public final int gKH;
  public final boolean gKI;
  private an gKJ;
  
  public p(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, true);
  }
  
  public p(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    super(new s(paramString1, paramString2));
    this.appId = paramString1;
    this.fCQ = paramString2;
    this.gKH = paramInt;
    this.gKI = paramBoolean;
  }
  
  private WxaPkgWrappingInfo uT(String paramString)
  {
    paramString = WxaPkgWrappingInfo.rn(paramString);
    paramString.fEN = this.gKH;
    return paramString;
  }
  
  public final String alK()
  {
    return String.format(Locale.US, "pkg %s, targetVersion %d, pkgType %d", new Object[] { this.gKF.toString(), Integer.valueOf(this.gKH), Integer.valueOf(0) });
  }
  
  public final void prepare()
  {
    ar localar = com.tencent.mm.plugin.appbrand.app.e.abb();
    if (localar == null)
    {
      y.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL storage with %s", new Object[] { alK() });
      d(null);
      return;
    }
    this.gKJ = localar.a(this.gKF.toString(), this.gKH, 0, new String[0]);
    if (this.gKJ == null)
    {
      y.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL record with %s", new Object[] { alK() });
      d(null);
      return;
    }
    if (bk.bl(this.gKJ.field_versionMd5))
    {
      y.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get EMPTY md5 with %s", new Object[] { alK() });
      d(null);
      return;
    }
    try
    {
      if (this.gKJ.field_versionMd5.equals(g.b(com.tencent.mm.vfs.e.openRead(this.gKJ.field_pkgPath), 4096)))
      {
        y.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s prepare ok", new Object[] { alK() });
        d(uT(this.gKJ.field_pkgPath));
        return;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      com.tencent.mm.vfs.e.deleteFile(this.gKJ.field_pkgPath);
      Object localObject1 = e.a(this.gKF, this.gKH, this.gKJ.field_versionMd5);
      Object localObject2;
      if (localObject1 != null)
      {
        y.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "find reusable record, target (%s), reusable (%s %d)", new Object[] { alK(), ((an)localObject1).field_appId, Integer.valueOf(((an)localObject1).field_version) });
        localObject2 = ak.ah(this.gKF.toString(), this.gKH);
        com.tencent.mm.vfs.e.r(((an)localObject1).field_pkgPath, (String)localObject2);
        com.tencent.mm.plugin.appbrand.app.e.abb().d(this.gKF.toString(), 0, this.gKH, (String)localObject2);
        d(uT((String)localObject2));
        return;
      }
      y.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s getDownloadURL", new Object[] { alK() });
      localObject1 = new and();
      ((and)localObject1).bOL = this.appId;
      ((and)localObject1).sEs = this.gKH;
      ((and)localObject1).tiW = 0;
      if (!bk.bl(this.fCQ))
      {
        ((and)localObject1).thh = this.fCQ;
        ((and)localObject1).tiW = 4;
      }
      ((and)localObject1).tiV = this.gKJ.field_versionMd5;
      if ((l.abF()) && (d.a.kq(0)))
      {
        localObject2 = e.aU(this.gKF.toString(), 1);
        if (localObject2 != null) {
          ((and)localObject1).tiX = ((WxaPkgWrappingInfo)localObject2).fEN;
        }
      }
      new b((and)localObject1).Km().h(new p.1(this, (and)localObject1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.p
 * JD-Core Version:    0.7.0.1
 */