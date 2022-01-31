package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public final class ae
  implements d
{
  public final void a(Context paramContext, String paramString1, int paramInt, String paramString2, AppBrandStatObject paramAppBrandStatObject, String paramString3, String paramString4)
  {
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.fPF = 7;
    localAppBrandLaunchReferrer.appId = paramString3;
    localAppBrandLaunchReferrer.fPJ = paramString4;
    AppBrandLaunchProxyUI.a(paramContext, paramString1, null, paramString2, paramInt, 0, paramAppBrandStatObject, localAppBrandLaunchReferrer, null);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, AppBrandStatObject paramAppBrandStatObject)
  {
    AppBrandLaunchProxyUI.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramAppBrandStatObject, null, null);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, AppBrandStatObject paramAppBrandStatObject, String paramString4)
  {
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    switch (paramAppBrandStatObject.scene)
    {
    }
    for (;;)
    {
      localAppBrandLaunchReferrer.appId = paramString4;
      AppBrandLaunchProxyUI.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramAppBrandStatObject, localAppBrandLaunchReferrer, null);
      return;
      localAppBrandLaunchReferrer.fPF = 4;
      continue;
      localAppBrandLaunchReferrer.fPF = 2;
      continue;
      localAppBrandLaunchReferrer.fPF = 5;
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if (bk.bl(paramString3)) {
      return;
    }
    if ((bk.bl(paramString3)) || (bk.bl(paramString2)))
    {
      y.e("MicroMsg.WeAppLauncher", "targetAppId %s referrerAppId %s, Null Or Nil");
      return;
    }
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1055;
    localAppBrandStatObject.bFv = (q.encode(bk.pm(paramString1)) + ":" + paramString2);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.appId = paramString2;
    localAppBrandLaunchReferrer.fPF = 2;
    localAppBrandLaunchReferrer.url = paramString1;
    AppBrandLaunchProxyUI.a(paramContext, null, paramString3, paramString4, paramInt, -1, localAppBrandStatObject, localAppBrandLaunchReferrer, null);
    Assert.assertTrue(true);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, g.a parama)
  {
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1036;
    localAppBrandStatObject.bFv = (bk.pm(parama.appId) + ":" + bk.pm(q.encode(parama.url)));
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localAppBrandStatObject.caB = i;
      if (paramBoolean) {
        paramString2 = paramString1;
      }
      localAppBrandStatObject.caC = paramString2;
      paramString2 = null;
      if (!bk.bl(parama.dTe))
      {
        paramString2 = new LaunchParamsOptional();
        paramString2.dZN = paramString1;
        paramString2.dTX = parama.dTe;
      }
      paramString1 = new AppBrandLaunchReferrer();
      paramString1.fPF = 4;
      paramString1.appId = parama.appId;
      AppBrandLaunchProxyUI.a(paramContext, parama.dSY, parama.dSZ, parama.dSX, parama.dTf, parama.dTg, localAppBrandStatObject, paramString1, paramString2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ae
 * JD-Core Version:    0.7.0.1
 */