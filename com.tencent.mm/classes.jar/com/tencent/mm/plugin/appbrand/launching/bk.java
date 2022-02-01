package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.z;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.config.x.d;
import com.tencent.mm.plugin.appbrand.launching.d.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import java.util.concurrent.Callable;

final class bk
  extends be<Pair<WxaAttributes, Boolean>>
  implements as
{
  String appId;
  private final AppBrandLaunchReferrer cmv;
  private final int enterScene;
  private final int hQh;
  private final String jCN;
  private AppBrandLaunchFromNotifyReferrer jCZ;
  private final AppBrandStatObject jDH;
  private String lEv;
  boolean lLA = false;
  private boolean lLB = false;
  private au.a lLC = au.a.lJY;
  private int lLD = -1;
  private x.d lLE = null;
  private boolean lLw;
  private boolean lLx;
  private WxaAttributes lLy;
  private final int lLz;
  String username;
  
  bk(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString4, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer, x.d paramd)
  {
    this.username = paramString1;
    this.appId = paramString2;
    this.hQh = paramInt1;
    this.lLz = paramInt2;
    this.enterScene = paramInt3;
    this.jCN = paramString3;
    this.jDH = paramAppBrandStatObject;
    this.cmv = paramAppBrandLaunchReferrer;
    this.lEv = paramString4;
    this.jCZ = paramAppBrandLaunchFromNotifyReferrer;
    this.lLE = paramd;
  }
  
  private WxaAttributes brI()
  {
    AppMethodBeat.i(47354);
    if (!bt.isNullOrNil(this.username))
    {
      localWxaAttributes = j.aYP().d(this.username, new String[0]);
      AppMethodBeat.o(47354);
      return localWxaAttributes;
    }
    WxaAttributes localWxaAttributes = j.aYP().e(this.appId, new String[0]);
    AppMethodBeat.o(47354);
    return localWxaAttributes;
  }
  
  private static boolean j(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(47355);
    if (bt.isNullOrNil(paramWxaAttributes.field_appId))
    {
      ad.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid appID in contact(%s)", new Object[] { paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    if (paramWxaAttributes.ben() == null)
    {
      ad.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "NULL versionInfo(%s) in contact(%s)", new Object[] { paramWxaAttributes.field_versionInfo, paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    if (paramWxaAttributes.bel() == null)
    {
      ad.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "NULL appInfo(%s) in contact(%s)", new Object[] { paramWxaAttributes.field_appInfo, paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    if ((paramWxaAttributes.ben().cmx == 0) && (bt.isNullOrNil(paramWxaAttributes.ben().jZW)))
    {
      ad.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid versionMD5 in contact(%s)", new Object[] { paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    AppMethodBeat.o(47355);
    return false;
  }
  
  public final long bru()
  {
    return this.lKV;
  }
  
  public final long brv()
  {
    return this.lKW;
  }
  
  public final long brw()
  {
    return this.lKX;
  }
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepGetWxaAttrs";
  }
  
  public final String name()
  {
    return "PrepareStepGetWxaAttrs";
  }
  
  final class a
    implements x.d
  {
    private a() {}
    
    public final void bek()
    {
      AppMethodBeat.i(175003);
      if (bk.c(bk.this) != null) {
        bk.c(bk.this).bek();
      }
      if (!j.a.rQ(bk.d(bk.this)))
      {
        AppMethodBeat.o(175003);
        return;
      }
      if (z.aZX()) {
        z.aZY();
      }
      int i;
      Object localObject2;
      boolean bool;
      label118:
      String str1;
      int j;
      String str2;
      AppBrandStatObject localAppBrandStatObject;
      AppBrandLaunchReferrer localAppBrandLaunchReferrer;
      String str3;
      if ((i.IS_FLAVOR_RED) || (i.IS_FLAVOR_PURPLE) || (!d.Fnk))
      {
        i = 1;
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxv, i);
        localObject1 = bk.a(bk.this);
        localObject2 = bk.b(bk.this);
        if (i != 1) {
          break label410;
        }
        bool = true;
        ad.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "beforeSync: sync contact[username(%s) appId(%s)], process preload cgi, is open = [%b]", new Object[] { localObject1, localObject2, Boolean.valueOf(bool) });
        if (i == 1)
        {
          ad.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "beforeSync: sync contact[username(%s) appId(%s)], process preload cgi, is open = [%b]", new Object[] { bk.a(bk.this), bk.b(bk.this), Boolean.TRUE });
          localObject1 = com.tencent.luggage.sdk.e.c.cpG;
          com.tencent.luggage.sdk.e.c.a(new com.tencent.mm.plugin.appbrand.launching.d.c(), bk.e(bk.this));
          localObject1 = com.tencent.luggage.sdk.e.c.cpG;
          localObject2 = com.tencent.luggage.sdk.e.c.jdMethod_do(bk.e(bk.this));
          str1 = bk.a(bk.this);
          i = bk.d(bk.this);
          j = bk.f(bk.this);
          str2 = bk.g(bk.this);
          localAppBrandStatObject = bk.h(bk.this);
          localAppBrandLaunchReferrer = bk.i(bk.this);
          str3 = bk.b(bk.this);
          if ((bk.f(bk.this) != 1162) || (bk.j(bk.this) == null)) {
            break label415;
          }
        }
      }
      label410:
      label415:
      for (Object localObject1 = bk.j(bk.this).jXO;; localObject1 = null)
      {
        ((com.tencent.luggage.sdk.e.b)localObject2).b(new com.tencent.mm.plugin.appbrand.launching.d.g(str1, i, j, str2, localAppBrandStatObject, localAppBrandLaunchReferrer, str3, (String)localObject1));
        ((com.tencent.luggage.sdk.e.b)localObject2).b(new f(bk.g(bk.this), bk.a(bk.this), bk.b(bk.this)));
        com.tencent.mm.plugin.appbrand.launching.d.b.ma(0);
        com.tencent.mm.plugin.appbrand.keylogger.c.a(bk.b(bk.this), KSProcessWeAppLaunch.stepGetContact_CGI);
        AppMethodBeat.o(175003);
        return;
        i = 0;
        break;
        bool = false;
        break label118;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bk
 * JD-Core Version:    0.7.0.1
 */