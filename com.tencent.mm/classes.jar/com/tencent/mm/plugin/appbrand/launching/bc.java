package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.luggage.sdk.launching.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.ag.c;
import com.tencent.mm.plugin.appbrand.config.ag.f;
import com.tencent.mm.plugin.appbrand.launching.d.f;
import com.tencent.mm.plugin.appbrand.launching.d.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.gkv;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.Callable;
import junit.framework.Assert;

final class bc
  extends aw<Pair<WxaAttributes, Boolean>>
  implements af
{
  private final String TAG;
  String appId;
  private final int enterScene;
  private final AppBrandLaunchReferrer eoV;
  private final e epm;
  private String eup;
  private final int euz;
  private final String qAF;
  private AppBrandLaunchFromNotifyReferrer qAQ;
  private final AppBrandStatObject qxv;
  private final String sXh;
  private boolean tcf;
  private boolean tcg;
  WxaAttributes tch;
  private final int tci;
  boolean tcj;
  private boolean tck;
  ah.a tcl;
  private int tcm;
  private ag.f tcn;
  String username;
  
  bc(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString4, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer, String paramString5, ag.f paramf, e parame)
  {
    AppMethodBeat.i(320746);
    this.tcj = false;
    this.tck = false;
    this.tcl = ah.a.taY;
    this.tcm = -1;
    this.tcn = null;
    this.username = paramString1;
    this.appId = paramString2;
    this.euz = paramInt1;
    this.tci = paramInt2;
    this.enterScene = paramInt3;
    this.qAF = paramString3;
    this.qxv = paramAppBrandStatObject;
    this.eoV = paramAppBrandLaunchReferrer;
    this.eup = paramString4;
    this.qAQ = paramAppBrandLaunchFromNotifyReferrer;
    this.sXh = paramString5;
    this.epm = parame;
    if ((BuildInfo.DEBUG) && (Util.isNullOrNil(paramString1)) && (Util.isNullOrNil(paramString2))) {
      Assert.fail("username and appId should not be null or nil!");
    }
    if (!Util.isNullOrNil(paramString1)) {}
    for (this.TAG = ("MicroMsg.AppBrand.PrepareStepGetWxaAttrs[" + paramString1 + "]");; this.TAG = ("MicroMsg.AppBrand.PrepareStepGetWxaAttrs[" + paramString2 + "]"))
    {
      this.tcn = paramf;
      AppMethodBeat.o(320746);
      return;
    }
  }
  
  private WxaAttributes cAw()
  {
    AppMethodBeat.i(47354);
    if (!Util.isNullOrNil(this.username))
    {
      localWxaAttributes = n.cfc().d(this.username, new String[0]);
      AppMethodBeat.o(47354);
      return localWxaAttributes;
    }
    WxaAttributes localWxaAttributes = n.cfc().e(this.appId, new String[0]);
    AppMethodBeat.o(47354);
    return localWxaAttributes;
  }
  
  public final long cAj()
  {
    return this.tbM;
  }
  
  public final long cAk()
  {
    return this.tbN;
  }
  
  public final long cAl()
  {
    return this.tbO;
  }
  
  public final boolean czJ()
  {
    AppMethodBeat.i(320799);
    if ((super.czJ()) && (e.etJ != this.epm))
    {
      AppMethodBeat.o(320799);
      return true;
    }
    AppMethodBeat.o(320799);
    return false;
  }
  
  final String getTag()
  {
    return this.TAG;
  }
  
  public final String name()
  {
    return "PrepareStepGetWxaAttrs";
  }
  
  final class a
    implements ag.f
  {
    private a() {}
    
    public final void clc()
    {
      AppMethodBeat.i(175003);
      if (bc.f(bc.this) != null) {
        bc.f(bc.this).clc();
      }
      if (!k.a.zn(bc.g(bc.this)))
      {
        AppMethodBeat.o(175003);
        return;
      }
      ac.cgo();
      int i;
      Object localObject2;
      String str1;
      boolean bool;
      label127:
      int j;
      String str2;
      AppBrandStatObject localAppBrandStatObject;
      AppBrandLaunchReferrer localAppBrandLaunchReferrer;
      String str3;
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (!d.Yxi))
      {
        i = 1;
        i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTQ, i);
        localObject1 = bc.h(bc.this);
        localObject2 = bc.d(bc.this);
        str1 = bc.e(bc.this);
        if (i != 1) {
          break label403;
        }
        bool = true;
        Log.i((String)localObject1, "beforeSync: sync contact[username(%s) appId(%s)], process preload cgi, is open = [%b]", new Object[] { localObject2, str1, Boolean.valueOf(bool) });
        if (i == 1)
        {
          localObject1 = com.tencent.luggage.sdk.f.c.evF;
          com.tencent.luggage.sdk.f.c.a(new com.tencent.mm.plugin.appbrand.launching.d.c(), bc.a(bc.this));
          localObject1 = com.tencent.luggage.sdk.f.c.evF;
          localObject2 = com.tencent.luggage.sdk.f.c.fC(bc.a(bc.this));
          str1 = bc.d(bc.this);
          i = bc.g(bc.this);
          j = bc.b(bc.this);
          str2 = bc.i(bc.this);
          localAppBrandStatObject = bc.j(bc.this);
          localAppBrandLaunchReferrer = bc.k(bc.this);
          str3 = bc.e(bc.this);
          if ((bc.b(bc.this) != 1162) || (bc.l(bc.this) == null)) {
            break label408;
          }
        }
      }
      label403:
      label408:
      for (Object localObject1 = bc.l(bc.this).qYA;; localObject1 = null)
      {
        ((com.tencent.luggage.sdk.f.b)localObject2).c(new g(str1, i, j, str2, localAppBrandStatObject, localAppBrandLaunchReferrer, str3, (String)localObject1, bc.m(bc.this), bc.c(bc.this), bc.a(bc.this)));
        ((com.tencent.luggage.sdk.f.b)localObject2).c(new f(bc.i(bc.this), bc.d(bc.this), bc.e(bc.this)));
        com.tencent.mm.plugin.appbrand.launching.d.b.rG(0);
        com.tencent.mm.plugin.appbrand.keylogger.c.a(bc.e(bc.this), KSProcessWeAppLaunch.stepGetContact_CGI);
        AppMethodBeat.o(175003);
        return;
        i = 0;
        break;
        bool = false;
        break label127;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bc
 * JD-Core Version:    0.7.0.1
 */