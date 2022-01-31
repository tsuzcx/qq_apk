package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class ao$2
  implements OpenBusinessViewUtil.a
{
  ao$2(ao paramao, String paramString1, String paramString2, String paramString3, int paramInt1, Context paramContext, int paramInt2) {}
  
  public final void S(int paramInt, String paramString)
  {
    AppMethodBeat.i(132002);
    ab.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch fail, CGI errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    ao.b(this.imZ);
    OpenBusinessViewUtil.t(this.imY, null, -2);
    AppMethodBeat.o(132002);
  }
  
  public final void cf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132001);
    ao.b(this.imZ);
    if (ao.c(this.imZ))
    {
      AppMethodBeat.o(132001);
      return;
    }
    if (bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, invalid businessType");
      OpenBusinessViewUtil.t(this.imY, null, -4);
      AppMethodBeat.o(132001);
      return;
    }
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1055;
    localAppBrandStatObject.cmF = (q.encode(bo.nullAsNil(this.ina)) + ":" + this.inb + ":" + this.inc);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.appId = this.inb;
    localAppBrandLaunchReferrer.hiK = 2;
    localAppBrandLaunchReferrer.url = this.ina;
    localAppBrandLaunchReferrer.businessType = this.imY;
    localAppBrandLaunchReferrer.cpG = 5;
    if (AppBrandLaunchProxyUI.a(this.val$context, null, paramString1, paramString2, this.hld, -1, localAppBrandStatObject, localAppBrandLaunchReferrer, null))
    {
      ab.i("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch success");
      AppMethodBeat.o(132001);
      return;
    }
    ab.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch fail");
    OpenBusinessViewUtil.t(this.imY, null, -1);
    AppMethodBeat.o(132001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ao.2
 * JD-Core Version:    0.7.0.1
 */