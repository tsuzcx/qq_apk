package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.aa.c;
import com.tencent.mm.plugin.appbrand.config.aa.f;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.launching.d.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.fcv;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.Callable;

final class bc
  extends aw<Pair<WxaAttributes, Boolean>>
  implements ak
{
  String appId;
  private final AppBrandLaunchReferrer cys;
  private final com.tencent.luggage.sdk.launching.b cyz;
  private final int enterScene;
  private final int iOo;
  private final AppBrandStatObject kEH;
  private String kEY;
  private AppBrandLaunchFromNotifyReferrer kHI;
  private final String kHw;
  private final String mRk;
  private boolean mWV;
  private boolean mWW;
  private WxaAttributes mWX;
  private final int mWY;
  boolean mWZ = false;
  private boolean mXa = false;
  private am.a mXb = am.a.mVG;
  private int mXc = -1;
  private aa.f mXd = null;
  String username;
  
  bc(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString4, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer, String paramString5, aa.f paramf, com.tencent.luggage.sdk.launching.b paramb)
  {
    this.username = paramString1;
    this.appId = paramString2;
    this.iOo = paramInt1;
    this.mWY = paramInt2;
    this.enterScene = paramInt3;
    this.kHw = paramString3;
    this.kEH = paramAppBrandStatObject;
    this.cys = paramAppBrandLaunchReferrer;
    this.kEY = paramString4;
    this.kHI = paramAppBrandLaunchFromNotifyReferrer;
    this.mRk = paramString5;
    this.cyz = paramb;
    this.mXd = paramf;
  }
  
  private WxaAttributes bNP()
  {
    AppMethodBeat.i(47354);
    if (!Util.isNullOrNil(this.username))
    {
      localWxaAttributes = n.buC().d(this.username, new String[0]);
      AppMethodBeat.o(47354);
      return localWxaAttributes;
    }
    WxaAttributes localWxaAttributes = n.buC().e(this.appId, new String[0]);
    AppMethodBeat.o(47354);
    return localWxaAttributes;
  }
  
  private static boolean j(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(227114);
    if ((paramWxaAttributes.bAn() != null) && (paramWxaAttributes.bAn().NA()))
    {
      AppMethodBeat.o(227114);
      return true;
    }
    AppMethodBeat.o(227114);
    return false;
  }
  
  private static boolean k(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(47355);
    if (Util.isNullOrNil(paramWxaAttributes.field_appId))
    {
      Log.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid appID in contact(%s)", new Object[] { paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    if (paramWxaAttributes.bAp() == null)
    {
      Log.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "NULL versionInfo(%s) in contact(%s)", new Object[] { paramWxaAttributes.field_versionInfo, paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    if (paramWxaAttributes.bAn() == null)
    {
      Log.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "NULL appInfo(%s) in contact(%s)", new Object[] { paramWxaAttributes.field_appInfo, paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    if ((paramWxaAttributes.bAp().cyu == 0) && (Util.isNullOrNil(paramWxaAttributes.bAp().lgS)))
    {
      Log.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid versionMD5 in contact(%s)", new Object[] { paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    AppMethodBeat.o(47355);
    return false;
  }
  
  public final long bNF()
  {
    return this.mWG;
  }
  
  public final long bNG()
  {
    return this.mWH;
  }
  
  public final long bNH()
  {
    return this.mWI;
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
    implements aa.f
  {
    private a() {}
    
    public final void bAm()
    {
      AppMethodBeat.i(175003);
      if (bc.f(bc.this) != null) {
        bc.f(bc.this).bAm();
      }
      if (!j.a.vP(bc.g(bc.this)))
      {
        AppMethodBeat.o(175003);
        return;
      }
      if (aa.bvK()) {
        aa.bvL();
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
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (!d.KyP))
      {
        i = 1;
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXI, i);
        localObject1 = bc.d(bc.this);
        localObject2 = bc.e(bc.this);
        if (i != 1) {
          break label417;
        }
        bool = true;
        Log.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "beforeSync: sync contact[username(%s) appId(%s)], process preload cgi, is open = [%b]", new Object[] { localObject1, localObject2, Boolean.valueOf(bool) });
        if (i == 1)
        {
          Log.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "beforeSync: sync contact[username(%s) appId(%s)], process preload cgi, is open = [%b]", new Object[] { bc.d(bc.this), bc.e(bc.this), Boolean.TRUE });
          localObject1 = com.tencent.luggage.sdk.e.c.cCC;
          com.tencent.luggage.sdk.e.c.a(new com.tencent.mm.plugin.appbrand.launching.d.c(), bc.a(bc.this));
          localObject1 = com.tencent.luggage.sdk.e.c.cCC;
          localObject2 = com.tencent.luggage.sdk.e.c.dJ(bc.a(bc.this));
          str1 = bc.d(bc.this);
          i = bc.g(bc.this);
          j = bc.b(bc.this);
          str2 = bc.h(bc.this);
          localAppBrandStatObject = bc.i(bc.this);
          localAppBrandLaunchReferrer = bc.j(bc.this);
          str3 = bc.e(bc.this);
          if ((bc.b(bc.this) != 1162) || (bc.k(bc.this) == null)) {
            break label422;
          }
        }
      }
      label417:
      label422:
      for (Object localObject1 = bc.k(bc.this).lek;; localObject1 = null)
      {
        ((com.tencent.luggage.sdk.e.b)localObject2).b(new com.tencent.mm.plugin.appbrand.launching.d.g(str1, i, j, str2, localAppBrandStatObject, localAppBrandLaunchReferrer, str3, (String)localObject1, bc.l(bc.this)));
        ((com.tencent.luggage.sdk.e.b)localObject2).b(new f(bc.h(bc.this), bc.d(bc.this), bc.e(bc.this)));
        com.tencent.mm.plugin.appbrand.launching.d.b.pl(0);
        com.tencent.mm.plugin.appbrand.keylogger.c.a(bc.e(bc.this), KSProcessWeAppLaunch.stepGetContact_CGI);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bc
 * JD-Core Version:    0.7.0.1
 */