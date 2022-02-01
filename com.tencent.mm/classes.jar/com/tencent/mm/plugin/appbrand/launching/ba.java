package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.ab;
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
import com.tencent.mm.plugin.appbrand.launching.d.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.fnw;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.Callable;

final class ba
  extends au<Pair<WxaAttributes, Boolean>>
  implements ae
{
  String appId;
  private String cBH;
  private final int cBU;
  private final AppBrandLaunchReferrer cwV;
  private final com.tencent.luggage.sdk.launching.b cxe;
  private final int enterScene;
  private AppBrandLaunchFromNotifyReferrer nBB;
  private final String nBq;
  private final AppBrandStatObject nyh;
  private final String pSf;
  private boolean pXp;
  private boolean pXq;
  private WxaAttributes pXr;
  private final int pXs;
  boolean pXt = false;
  private boolean pXu = false;
  private ag.a pXv = ag.a.pWj;
  private int pXw = -1;
  private aa.f pXx = null;
  String username;
  
  ba(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString4, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer, String paramString5, aa.f paramf, com.tencent.luggage.sdk.launching.b paramb)
  {
    this.username = paramString1;
    this.appId = paramString2;
    this.cBU = paramInt1;
    this.pXs = paramInt2;
    this.enterScene = paramInt3;
    this.nBq = paramString3;
    this.nyh = paramAppBrandStatObject;
    this.cwV = paramAppBrandLaunchReferrer;
    this.cBH = paramString4;
    this.nBB = paramAppBrandLaunchFromNotifyReferrer;
    this.pSf = paramString5;
    this.cxe = paramb;
    this.pXx = paramf;
  }
  
  private WxaAttributes cai()
  {
    AppMethodBeat.i(47354);
    if (!Util.isNullOrNil(this.username))
    {
      localWxaAttributes = m.bFF().c(this.username, new String[0]);
      AppMethodBeat.o(47354);
      return localWxaAttributes;
    }
    WxaAttributes localWxaAttributes = m.bFF().d(this.appId, new String[0]);
    AppMethodBeat.o(47354);
    return localWxaAttributes;
  }
  
  private static boolean j(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(242737);
    if ((paramWxaAttributes.bLF() != null) && (paramWxaAttributes.bLF().Qv()))
    {
      AppMethodBeat.o(242737);
      return true;
    }
    AppMethodBeat.o(242737);
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
    if (paramWxaAttributes.bLH() == null)
    {
      Log.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "NULL versionInfo(%s) in contact(%s)", new Object[] { paramWxaAttributes.field_versionInfo, paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    if (paramWxaAttributes.bLF() == null)
    {
      Log.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "NULL appInfo(%s) in contact(%s)", new Object[] { paramWxaAttributes.field_appInfo, paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    if ((paramWxaAttributes.bLH().cwX == 0) && (Util.isNullOrNil(paramWxaAttributes.bLH().oby)))
    {
      Log.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid versionMD5 in contact(%s)", new Object[] { paramWxaAttributes.field_username });
      AppMethodBeat.o(47355);
      return true;
    }
    AppMethodBeat.o(47355);
    return false;
  }
  
  public final long bZX()
  {
    return this.pWY;
  }
  
  public final long bZY()
  {
    return this.pWZ;
  }
  
  public final long bZZ()
  {
    return this.pXa;
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
    
    public final void bLE()
    {
      AppMethodBeat.i(175003);
      if (ba.f(ba.this) != null) {
        ba.f(ba.this).bLE();
      }
      if (!j.a.za(ba.g(ba.this)))
      {
        AppMethodBeat.o(175003);
        return;
      }
      if (ab.bGR()) {
        ab.bGS();
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
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (!d.RAE))
      {
        i = 1;
        i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEB, i);
        localObject1 = ba.d(ba.this);
        localObject2 = ba.e(ba.this);
        if (i != 1) {
          break label417;
        }
        bool = true;
        Log.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "beforeSync: sync contact[username(%s) appId(%s)], process preload cgi, is open = [%b]", new Object[] { localObject1, localObject2, Boolean.valueOf(bool) });
        if (i == 1)
        {
          Log.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "beforeSync: sync contact[username(%s) appId(%s)], process preload cgi, is open = [%b]", new Object[] { ba.d(ba.this), ba.e(ba.this), Boolean.TRUE });
          localObject1 = com.tencent.luggage.sdk.f.c.cDf;
          com.tencent.luggage.sdk.f.c.a(new com.tencent.mm.plugin.appbrand.launching.d.c(), ba.a(ba.this));
          localObject1 = com.tencent.luggage.sdk.f.c.cDf;
          localObject2 = com.tencent.luggage.sdk.f.c.ej(ba.a(ba.this));
          str1 = ba.d(ba.this);
          i = ba.g(ba.this);
          j = ba.b(ba.this);
          str2 = ba.h(ba.this);
          localAppBrandStatObject = ba.i(ba.this);
          localAppBrandLaunchReferrer = ba.j(ba.this);
          str3 = ba.e(ba.this);
          if ((ba.b(ba.this) != 1162) || (ba.k(ba.this) == null)) {
            break label422;
          }
        }
      }
      label417:
      label422:
      for (Object localObject1 = ba.k(ba.this).nYy;; localObject1 = null)
      {
        ((com.tencent.luggage.sdk.f.b)localObject2).b(new g(str1, i, j, str2, localAppBrandStatObject, localAppBrandLaunchReferrer, str3, (String)localObject1, ba.l(ba.this)));
        ((com.tencent.luggage.sdk.f.b)localObject2).b(new f(ba.h(ba.this), ba.d(ba.this), ba.e(ba.this)));
        com.tencent.mm.plugin.appbrand.launching.d.b.rE(0);
        com.tencent.mm.plugin.appbrand.keylogger.c.a(ba.e(ba.this), KSProcessWeAppLaunch.stepGetContact_CGI);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ba
 * JD-Core Version:    0.7.0.1
 */