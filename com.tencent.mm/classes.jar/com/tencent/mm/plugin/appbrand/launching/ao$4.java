package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class ao$4
  implements OpenBusinessViewUtil.a
{
  ao$4(ao paramao, String paramString1, String paramString2, Context paramContext, int paramInt) {}
  
  public final void S(int paramInt, String paramString)
  {
    AppMethodBeat.i(132005);
    ab.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail, CGI errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    ao.b(this.imZ);
    OpenBusinessViewUtil.s(this.inb, this.imY, -3);
    AppMethodBeat.o(132005);
  }
  
  public final void cf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132004);
    ao.b(this.imZ);
    if (ao.c(this.imZ))
    {
      AppMethodBeat.o(132004);
      return;
    }
    if (bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, invalid businessType");
      OpenBusinessViewUtil.s(this.inb, this.imY, -3);
      AppMethodBeat.o(132004);
      return;
    }
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1069;
    localAppBrandStatObject.cmF = this.inb;
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.appId = this.inb;
    localAppBrandLaunchReferrer.hiK = 4;
    localAppBrandLaunchReferrer.businessType = this.imY;
    localAppBrandLaunchReferrer.cpG = 5;
    if (AppBrandLaunchProxyUI.a(this.val$context, null, paramString1, paramString2, this.hld, -1, localAppBrandStatObject, localAppBrandLaunchReferrer, null))
    {
      ab.i("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch success");
      AppMethodBeat.o(132004);
      return;
    }
    ab.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail");
    OpenBusinessViewUtil.s(this.inb, this.imY, -3);
    AppMethodBeat.o(132004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ao.4
 * JD-Core Version:    0.7.0.1
 */