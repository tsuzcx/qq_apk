package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.config.w.c;
import com.tencent.mm.plugin.appbrand.launching.d.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;

final class bh
  extends bb<Pair<WxaAttributes, Boolean>>
{
  private String appId;
  private final AppBrandLaunchReferrer cfi;
  private final int enterScene;
  private final int gXn;
  private final AppBrandStatObject iJL;
  private final String iJb;
  private AppBrandLaunchFromNotifyReferrer iJn;
  private String kGa;
  private boolean kME;
  private boolean kMF;
  private final int kMG;
  private boolean kMH = false;
  private boolean kMI = false;
  private as.a kMJ = as.a.kLr;
  private int kMK = -1;
  boolean kML = false;
  private w.c kMM = null;
  private String username;
  
  bh(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString4, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer, w.c paramc)
  {
    this.username = paramString1;
    this.appId = paramString2;
    this.gXn = paramInt1;
    this.kMG = paramInt2;
    this.enterScene = paramInt3;
    this.iJb = paramString3;
    this.iJL = paramAppBrandStatObject;
    this.cfi = paramAppBrandLaunchReferrer;
    this.kGa = paramString4;
    this.iJn = paramAppBrandLaunchFromNotifyReferrer;
    this.kMM = paramc;
  }
  
  private WxaAttributes bgW()
  {
    AppMethodBeat.i(47354);
    if (!bt.isNullOrNil(this.username))
    {
      localWxaAttributes = j.aOC().d(this.username, new String[0]);
      AppMethodBeat.o(47354);
      return localWxaAttributes;
    }
    WxaAttributes localWxaAttributes = j.aOC().e(this.appId, new String[0]);
    AppMethodBeat.o(47354);
    return localWxaAttributes;
  }
  
  private static boolean g(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(47355);
    if (bt.isNullOrNil(paramWxaAttributes.field_appId))
    {
      ad.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid appID in contact(%s)", new Object[] { paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    if (paramWxaAttributes.aTP() == null)
    {
      ad.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "NULL versionInfo(%s) in contact(%s)", new Object[] { paramWxaAttributes.field_versionInfo, paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    if (paramWxaAttributes.aTN() == null)
    {
      ad.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "NULL appInfo(%s) in contact(%s)", new Object[] { paramWxaAttributes.field_appInfo, paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    if ((paramWxaAttributes.aTP().cfk == 0) && (bt.isNullOrNil(paramWxaAttributes.aTP().jfy)))
    {
      ad.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid versionMD5 in contact(%s)", new Object[] { paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    AppMethodBeat.o(47355);
    return false;
  }
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepGetWxaAttrs";
  }
  
  final class a
    implements w.c
  {
    private a() {}
    
    public final void aTM()
    {
      AppMethodBeat.i(175003);
      if (bh.a(bh.this) != null) {
        bh.a(bh.this).aTM();
      }
      if (!j.a.qD(bh.b(bh.this)))
      {
        AppMethodBeat.o(175003);
        return;
      }
      int i;
      Object localObject2;
      boolean bool;
      label109:
      String str1;
      int j;
      String str2;
      AppBrandStatObject localAppBrandStatObject;
      AppBrandLaunchReferrer localAppBrandLaunchReferrer;
      String str3;
      if ((h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE) || (!d.CpL))
      {
        i = 1;
        i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ppg, i);
        localObject1 = bh.c(bh.this);
        localObject2 = bh.d(bh.this);
        if (i != 1) {
          break label401;
        }
        bool = true;
        ad.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "beforeSync: sync contact[username(%s) appId(%s)], process preload cgi, is open = [%b]", new Object[] { localObject1, localObject2, Boolean.valueOf(bool) });
        if (i == 1)
        {
          ad.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "beforeSync: sync contact[username(%s) appId(%s)], process preload cgi, is open = [%b]", new Object[] { bh.c(bh.this), bh.d(bh.this), Boolean.TRUE });
          localObject1 = com.tencent.luggage.sdk.e.c.ciu;
          com.tencent.luggage.sdk.e.c.a(new com.tencent.mm.plugin.appbrand.launching.d.c(), bh.e(bh.this));
          localObject1 = com.tencent.luggage.sdk.e.c.ciu;
          localObject2 = com.tencent.luggage.sdk.e.c.cx(bh.e(bh.this));
          str1 = bh.c(bh.this);
          i = bh.b(bh.this);
          j = bh.f(bh.this);
          str2 = bh.g(bh.this);
          localAppBrandStatObject = bh.h(bh.this);
          localAppBrandLaunchReferrer = bh.i(bh.this);
          str3 = bh.d(bh.this);
          if ((bh.f(bh.this) != 1162) || (bh.j(bh.this) == null)) {
            break label406;
          }
        }
      }
      label401:
      label406:
      for (Object localObject1 = bh.j(bh.this).jdA;; localObject1 = null)
      {
        ((com.tencent.luggage.sdk.e.b)localObject2).b(new com.tencent.mm.plugin.appbrand.launching.d.g(str1, i, j, str2, localAppBrandStatObject, localAppBrandLaunchReferrer, str3, (String)localObject1));
        ((com.tencent.luggage.sdk.e.b)localObject2).b(new f(bh.g(bh.this), bh.c(bh.this), bh.d(bh.this)));
        com.tencent.mm.plugin.appbrand.launching.d.b.lI(0);
        com.tencent.mm.plugin.appbrand.keylogger.c.a(bh.d(bh.this), KSProcessWeAppLaunch.stepGetContact_CGI);
        AppMethodBeat.o(175003);
        return;
        i = 0;
        break;
        bool = false;
        break label109;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bh
 * JD-Core Version:    0.7.0.1
 */