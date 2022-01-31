package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.ah.a.a;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.at.a;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.protocal.c.ald;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Locale;

final class q
  extends o
{
  final String appId;
  final int bOa;
  final String fCQ;
  
  q(String paramString1, String paramString2, int paramInt)
  {
    super(new s(paramString1, paramString2));
    this.appId = paramString1;
    this.fCQ = paramString2;
    this.bOa = paramInt;
  }
  
  public final String alK()
  {
    return String.format(Locale.US, "appId %s, module %s, pkgType %d", new Object[] { this.appId, this.fCQ, Integer.valueOf(this.bOa) });
  }
  
  public final void prepare()
  {
    int k = -1;
    Object localObject1 = am.t(this.gKF.toString(), this.bOa, 1);
    if (((Pair)localObject1).second != null)
    {
      ((WxaPkgWrappingInfo)((Pair)localObject1).second).name = this.fCQ;
      d((WxaPkgWrappingInfo)((Pair)localObject1).second);
    }
    Object localObject2;
    label252:
    do
    {
      return;
      if (bk.bl(this.fCQ)) {}
      for (localObject1 = e.abb().aj(this.appId, this.bOa);; localObject1 = null)
      {
        localObject2 = new q.1(this, this.bOa);
        y.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s before download, url(%s)", new Object[] { alK(), localObject1 });
        if (!bk.bl((String)localObject1)) {
          break label542;
        }
        d(null);
        return;
        localObject1 = e.abb().a(this.gKF.toString(), this.bOa, new String[] { "versionMd5" });
        if (localObject1 != null) {
          break;
        }
        y.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, NULL record", new Object[] { alK() });
      }
      localObject1 = com.tencent.mm.ah.x.a(new com.tencent.mm.plugin.appbrand.appcache.c(this.appId, this.fCQ, ((an)localObject1).field_versionMd5, this.bOa));
      if ((localObject1 == null) || (((a.a)localObject1).errType != 0) || (((a.a)localObject1).errCode != 0))
      {
        localObject2 = alK();
        int i;
        int m;
        if (localObject1 == null)
        {
          i = -1;
          if (localObject1 != null) {
            break label349;
          }
          j = -1;
          y.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, cgi failed, %d %d", new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(j) });
          m = y.j.app_brand_prepare_get_cdn_url_err;
          if (localObject1 != null) {
            break label358;
          }
          i = -1;
          if (localObject1 != null) {
            break label367;
          }
        }
        for (int j = k;; j = ((a.a)localObject1).errCode)
        {
          x.uV(x.getMMString(m, new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
          localObject1 = null;
          break;
          i = ((a.a)localObject1).errType;
          break label252;
          j = ((a.a)localObject1).errCode;
          break label259;
          i = ((a.a)localObject1).errType;
          break label301;
        }
      }
      y.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "resp.errcode %d, resp.errmsg %s, resp.url %s", new Object[] { Integer.valueOf(((ald)((a.a)localObject1).ecw).error_code), ((ald)((a.a)localObject1).ecw).error_msg, ((ald)((a.a)localObject1).ecw).dlQ });
      if (bk.bl(((ald)((a.a)localObject1).ecw).dlQ))
      {
        if (((ald)((a.a)localObject1).ecw).error_code != -1001) {
          break label502;
        }
        AppBrand404PageUI.show(y.j.app_brand_qrcode_result_uin_invalid);
        com.tencent.mm.plugin.appbrand.report.c.H(this.appId, 4, this.bOa + 1);
      }
      for (;;)
      {
        localObject1 = ((ald)((a.a)localObject1).ecw).dlQ;
        break;
        x.uV(com.tencent.mm.plugin.appbrand.v.c.getMMString(y.j.app_brand_preparing_comm_err_code, new Object[] { Integer.valueOf(5), Integer.valueOf(((ald)((a.a)localObject1).ecw).error_code) }));
      }
    } while (at.b(this.gKF.toString(), this.bOa, 1, (String)localObject1, (at.a)localObject2));
    label259:
    label301:
    label349:
    label358:
    label367:
    label502:
    y.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s start downloadPkg failed", new Object[] { alK() });
    label542:
    d(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.q
 * JD-Core Version:    0.7.0.1
 */