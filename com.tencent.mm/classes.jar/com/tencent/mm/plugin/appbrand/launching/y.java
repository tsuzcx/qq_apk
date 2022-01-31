package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.ah.a.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.plugin.appbrand.appcache.am.a;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.b;
import com.tencent.mm.plugin.appbrand.appcache.b.b.f;
import com.tencent.mm.plugin.appbrand.appcache.b.b.f.a;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.appcache.r.a;
import com.tencent.mm.plugin.appbrand.appcache.z;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.ane;
import com.tencent.mm.protocal.c.cmh;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Locale;
import java.util.concurrent.Callable;
import junit.framework.Assert;

abstract class y
  extends w<WxaPkgWrappingInfo>
  implements i
{
  final String appId;
  private final int fEN;
  final int fJy;
  final WxaAttributes.d fQY;
  String fWD;
  final int gJU;
  private WxaPkgWrappingInfo gLh;
  
  y(String paramString, int paramInt1, int paramInt2, int paramInt3, WxaAttributes.d paramd)
  {
    this.appId = paramString;
    this.fJy = paramInt1;
    this.fEN = paramInt2;
    this.gJU = paramInt3;
    this.fWD = null;
    this.fQY = paramd;
  }
  
  private WxaPkgWrappingInfo aft()
  {
    Object localObject1 = am.t(this.appId, this.fJy, this.fEN);
    if (((Pair)localObject1).second != null)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, using existing pkg with appId(%s) versionType(%d) pkgVersion(%d)", new Object[] { this.appId, Integer.valueOf(this.fJy), Integer.valueOf(this.fEN) });
      localObject1 = (WxaPkgWrappingInfo)((Pair)localObject1).second;
      return localObject1;
    }
    Object localObject2;
    if (d.a.kq(this.fJy))
    {
      Object localObject3 = ((z)com.tencent.mm.plugin.appbrand.app.e.G(z.class)).q(this.appId, 1, this.fEN);
      if (localObject3 != null)
      {
        localObject2 = new PLong();
        boolean bool = f.a((com.tencent.mm.plugin.appbrand.appcache.y)localObject3, f.a.fFp, (PLong)localObject2);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "decrypt ret %b, with appId(%s) version(%d)", new Object[] { Boolean.valueOf(bool), this.appId, Integer.valueOf(this.fEN) });
        if (bool)
        {
          localObject1 = am.t(this.appId, this.fJy, this.fEN);
          if (((Pair)localObject1).second != null)
          {
            localObject3 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(((PLong)localObject2).value, 180L);
            return (WxaPkgWrappingInfo)((Pair)localObject1).second;
          }
          localObject3 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(((PLong)localObject2).value, 181L);
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (am.a.fEd.equals(((Pair)localObject1).first))
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, manifest NULL, appId(%s) type(%d) version(%d)", new Object[] { this.appId, Integer.valueOf(this.fJy), Integer.valueOf(this.fEN) });
        com.tencent.mm.plugin.appbrand.app.e.abb().a(this.appId, this.fQY);
        if (com.tencent.mm.plugin.appbrand.app.e.abb().a(this.appId, this.fEN, this.fJy, new String[0]) != null) {
          break label571;
        }
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, insert manifest fail again!!! appId(%s) type(%d) version(%d)", new Object[] { this.appId, Integer.valueOf(this.fJy), Integer.valueOf(this.fEN) });
        localObject2 = localObject1;
      }
      for (;;)
      {
        for (;;)
        {
          if (!am.a.fEg.equals(((Pair)localObject2).first)) {
            break label1160;
          }
          if (this.fJy != 0) {
            break label1136;
          }
          this.gLh = e.aU(this.appId, 1);
          try
          {
            localObject1 = com.tencent.mm.plugin.appbrand.app.e.abb().a(this.appId, 0, new String[] { "version", "versionMd5", "versionState" });
            if (localObject1 != null) {
              break label583;
            }
            throw new i.a.a().m(com.tencent.mm.plugin.appbrand.v.c.getMMString(y.j.app_brand_preparing_pkg_manifest_null, new Object[] { com.tencent.mm.plugin.appbrand.appcache.a.kp(this.fJy) }), new Object[0]).n("get NULL record with md5", new Object[0]).alI();
          }
          catch (i.a locala)
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "release_pkg APP_BROKEN obtain appId %s, message %s", new Object[] { this.appId, locala.getMessage() });
            if (this.fEN <= 0)
            {
              localObject2 = e.aU(this.appId, 1);
              localObject1 = localObject2;
              if (localObject2 != null) {
                break;
              }
            }
            if (!bk.bl(locala.gKq)) {
              x.uV(locala.gKq);
            }
            return null;
          }
        }
        label571:
        localObject2 = Pair.create(am.a.fEg, null);
        continue;
        label583:
        long l1 = bk.UY();
        int j = ((an)localObject1).field_version;
        int i;
        if (this.gLh == null)
        {
          i = 0;
          localObject2 = com.tencent.mm.ah.x.a(new b(this.appId, ((an)localObject1).field_version, ((an)localObject1).field_versionMd5, 0, i));
          if ((localObject2 != null) && (((a.a)localObject2).errType == 0) && (((a.a)localObject2).errCode == 0)) {
            break label841;
          }
          if ((localObject2 == null) || (((a.a)localObject2).errCode != -1001)) {
            break label738;
          }
          localObject1 = x.getMMString(y.j.app_brand_preparing_cgi_get_download_url_disaster, new Object[0]);
          localObject4 = new i.a.a();
          if (localObject2 != null) {
            break label801;
          }
        }
        label792:
        label801:
        for (localObject2 = null;; localObject2 = String.format(Locale.US, "(%d, %d)", new Object[] { Integer.valueOf(((a.a)localObject2).errType), Integer.valueOf(((a.a)localObject2).errCode) }))
        {
          throw ((i.a.a)localObject4).n("fail get download url, resp %s", new Object[] { localObject2 }).m((String)localObject1, new Object[0]).alI();
          i = this.gLh.fEN;
          break;
          label738:
          int k = y.j.app_brand_prepare_get_cdn_url_err;
          if (localObject2 == null)
          {
            i = -1;
            label749:
            if (localObject2 != null) {
              break label792;
            }
          }
          for (j = -1;; j = ((a.a)localObject2).errCode)
          {
            localObject1 = x.getMMString(k, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            break;
            i = ((a.a)localObject2).errType;
            break label749;
          }
        }
        label841:
        long l2 = bk.UY();
        r.a(r.b.gKY, this.appId, j, this.fJy, this.gJU, l2 - l1);
        if (bk.bl(((ane)((a.a)localObject2).ecw).url)) {
          throw new i.a.a().n("CgiGetDownloadURL return EMPTY url, ret = %d", new Object[] { Integer.valueOf(((ane)((a.a)localObject2).ecw).ret) }).alI();
        }
        Object localObject4 = new cmh();
        String str = ((ane)((a.a)localObject2).ecw).url;
        this.fWD = str;
        ((cmh)localObject4).tZl = str;
        ((cmh)localObject4).sCy = ((an)localObject1).field_version;
        ((cmh)localObject4).tZj = ((an)localObject1).field_versionState;
        ((cmh)localObject4).tZk = ((an)localObject1).field_versionMd5;
        com.tencent.mm.plugin.appbrand.app.e.abb().a(this.appId, (cmh)localObject4, 0);
        if (this.fQY.fRt > 0)
        {
          l1 = bk.UY();
          localObject1 = com.tencent.mm.plugin.appbrand.appcache.r.cs(this.fQY.fRt);
          l2 = bk.UY();
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "trimOff %d, cost %d, result %s", new Object[] { Integer.valueOf(this.fQY.fRt), Long.valueOf(l2 - l1), ((r.a)localObject1).name() });
        }
        localObject2 = b(new y.a(this, i, j, (ane)((a.a)localObject2).ecw, (byte)0));
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        throw new i.a.a().n("Download Fail", new Object[0]).alI();
        label1136:
        localObject1 = b(new y.b(this, 0, (byte)0));
        if (localObject1 != null) {
          return localObject1;
        }
      }
      label1160:
      a((am.a)((Pair)localObject2).first);
      return null;
    }
  }
  
  private WxaPkgWrappingInfo b(Callable<WxaPkgWrappingInfo> paramCallable)
  {
    if (paramCallable == this)
    {
      Assert.assertTrue("Why the hell you pass 'this' to this method", false);
      return null;
    }
    alE();
    try
    {
      paramCallable = (WxaPkgWrappingInfo)paramCallable.call();
      alG();
      return paramCallable;
    }
    catch (Exception paramCallable)
    {
      for (;;)
      {
        paramCallable = null;
      }
    }
  }
  
  final void a(am.a parama)
  {
    if (am.a.fEd.equals(parama))
    {
      if (this.fJy == 1) {}
      for (parama = com.tencent.mm.plugin.appbrand.v.c.getMMString(y.j.app_brand_launching_dev_pkg_expired, new Object[0]);; parama = com.tencent.mm.plugin.appbrand.v.c.getMMString(y.j.app_brand_preparing_pkg_manifest_null, new Object[] { com.tencent.mm.plugin.appbrand.appcache.a.kp(this.fJy) }))
      {
        if (this.fJy == 1)
        {
          g.aZ(this.appId, this.fJy);
          com.tencent.mm.plugin.appbrand.report.c.H(this.appId, 10, this.fJy + 1);
        }
        x.uV(parama);
        return;
      }
    }
    if ((am.a.fEf.equals(parama)) || (am.a.fEe.equals(parama)))
    {
      if (this.fJy != 0) {}
      for (int i = y.j.app_brand_launching_dev_pkg_expired;; i = y.j.app_brand_launching_release_pkg_deleted)
      {
        x.lO(i);
        if (this.fJy == 1) {
          com.tencent.mm.plugin.appbrand.report.c.H(this.appId, 10, this.fJy + 1);
        }
        g.aZ(this.appId, this.fJy);
        return;
      }
    }
    x.uV(com.tencent.mm.plugin.appbrand.v.c.getMMString(y.j.app_brand_preparing_comm_err_code, new Object[] { Integer.valueOf(1), Integer.valueOf(parama.ack()) }));
  }
  
  public void alE() {}
  
  public void alG() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppPkg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.y
 * JD-Core Version:    0.7.0.1
 */