package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.config.x.e;
import com.tencent.mm.plugin.appbrand.launching.d.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.concurrent.Callable;

final class bk
  extends be<Pair<WxaAttributes, Boolean>>
  implements as
{
  String appId;
  private final AppBrandLaunchReferrer cmx;
  private final int enterScene;
  private final int hSZ;
  private final String jFL;
  private AppBrandLaunchFromNotifyReferrer jFX;
  private final AppBrandStatObject jGF;
  private String lIU;
  private boolean lPW;
  private boolean lPX;
  private WxaAttributes lPY;
  private final int lPZ;
  boolean lQa = false;
  private boolean lQb = false;
  private au.a lQc = au.a.lOy;
  private int lQd = -1;
  private x.e lQe = null;
  String username;
  
  bk(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString4, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer, x.e parame)
  {
    this.username = paramString1;
    this.appId = paramString2;
    this.hSZ = paramInt1;
    this.lPZ = paramInt2;
    this.enterScene = paramInt3;
    this.jFL = paramString3;
    this.jGF = paramAppBrandStatObject;
    this.cmx = paramAppBrandLaunchReferrer;
    this.lIU = paramString4;
    this.jFX = paramAppBrandLaunchFromNotifyReferrer;
    this.lQe = parame;
  }
  
  private WxaAttributes bst()
  {
    AppMethodBeat.i(47354);
    if (!bu.isNullOrNil(this.username))
    {
      localWxaAttributes = com.tencent.mm.plugin.appbrand.app.j.aZl().d(this.username, new String[0]);
      AppMethodBeat.o(47354);
      return localWxaAttributes;
    }
    WxaAttributes localWxaAttributes = com.tencent.mm.plugin.appbrand.app.j.aZl().e(this.appId, new String[0]);
    AppMethodBeat.o(47354);
    return localWxaAttributes;
  }
  
  private static boolean j(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(222798);
    if ((paramWxaAttributes.beT() != null) && (paramWxaAttributes.beT().Ee()))
    {
      AppMethodBeat.o(222798);
      return true;
    }
    AppMethodBeat.o(222798);
    return false;
  }
  
  private static boolean k(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(47355);
    if (bu.isNullOrNil(paramWxaAttributes.field_appId))
    {
      ae.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid appID in contact(%s)", new Object[] { paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    if (paramWxaAttributes.beV() == null)
    {
      ae.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "NULL versionInfo(%s) in contact(%s)", new Object[] { paramWxaAttributes.field_versionInfo, paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    if (paramWxaAttributes.beT() == null)
    {
      ae.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "NULL appInfo(%s) in contact(%s)", new Object[] { paramWxaAttributes.field_appInfo, paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    if ((paramWxaAttributes.beV().cmz == 0) && (bu.isNullOrNil(paramWxaAttributes.beV().kdn)))
    {
      ae.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid versionMD5 in contact(%s)", new Object[] { paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    AppMethodBeat.o(47355);
    return false;
  }
  
  public final long bsf()
  {
    return this.lPv;
  }
  
  public final long bsg()
  {
    return this.lPw;
  }
  
  public final long bsh()
  {
    return this.lPx;
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
    implements x.e
  {
    private a() {}
    
    public final void beS()
    {
      AppMethodBeat.i(175003);
      if (bk.c(bk.this) != null) {
        bk.c(bk.this).beS();
      }
      if (!j.a.rT(bk.d(bk.this)))
      {
        AppMethodBeat.o(175003);
        return;
      }
      if (aa.baw()) {
        aa.bax();
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
      if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) || (!d.FFI))
      {
        i = 1;
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEB, i);
        localObject1 = bk.a(bk.this);
        localObject2 = bk.b(bk.this);
        if (i != 1) {
          break label410;
        }
        bool = true;
        ae.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "beforeSync: sync contact[username(%s) appId(%s)], process preload cgi, is open = [%b]", new Object[] { localObject1, localObject2, Boolean.valueOf(bool) });
        if (i == 1)
        {
          ae.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "beforeSync: sync contact[username(%s) appId(%s)], process preload cgi, is open = [%b]", new Object[] { bk.a(bk.this), bk.b(bk.this), Boolean.TRUE });
          localObject1 = com.tencent.luggage.sdk.e.c.cqj;
          com.tencent.luggage.sdk.e.c.a(new com.tencent.mm.plugin.appbrand.launching.d.c(), bk.e(bk.this));
          localObject1 = com.tencent.luggage.sdk.e.c.cqj;
          localObject2 = com.tencent.luggage.sdk.e.c.dq(bk.e(bk.this));
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
      for (Object localObject1 = bk.j(bk.this).kbd;; localObject1 = null)
      {
        ((com.tencent.luggage.sdk.e.b)localObject2).b(new com.tencent.mm.plugin.appbrand.launching.d.g(str1, i, j, str2, localAppBrandStatObject, localAppBrandLaunchReferrer, str3, (String)localObject1));
        ((com.tencent.luggage.sdk.e.b)localObject2).b(new f(bk.g(bk.this), bk.a(bk.this), bk.b(bk.this)));
        com.tencent.mm.plugin.appbrand.launching.d.b.md(0);
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