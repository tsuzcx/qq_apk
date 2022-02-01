package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.luggage.sdk.config.AppBrandInitWindowConfig;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.n;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.service.t.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.xweb.a;
import junit.framework.Assert;
import kotlin.ah;

public final class bh
  implements t
{
  private w psR;
  private boolean rWH = false;
  
  static
  {
    AppMethodBeat.i(320986);
    if (!bh.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(320986);
      return;
    }
  }
  
  private void a(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(47385);
    bQa();
    paramContext.getString(ba.i.app_tip);
    this.psR = k.a(paramContext, paramContext.getString(ba.i.app_waiting), true, paramOnCancelListener);
    AppMethodBeat.o(47385);
  }
  
  private void bQa()
  {
    AppMethodBeat.i(47386);
    if (this.psR != null)
    {
      this.psR.dismiss();
      this.psR = null;
    }
    AppMethodBeat.o(47386);
  }
  
  public final void M(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(321006);
    if (TextUtils.isEmpty(paramString2)) {}
    for (String str = ad.XJ(paramString1);; str = paramString2)
    {
      Log.i("MicroMsg.WeAppLauncher", "closeWxaApp() identity:[%s | %s]->[%s | %s], versionType:%d, allowBackgroundRunning:%b", new Object[] { paramString1, paramString2, paramString1, str, Integer.valueOf(paramInt), Boolean.FALSE });
      if (TextUtils.isEmpty(str))
      {
        AppMethodBeat.o(321006);
        return;
      }
      if ((!$assertionsDisabled) && (str == null))
      {
        paramString1 = new AssertionError();
        AppMethodBeat.o(321006);
        throw paramString1;
      }
      com.tencent.mm.plugin.appbrand.task.i.cJV().F(str, paramInt);
      AppMethodBeat.o(321006);
      return;
    }
  }
  
  public final void a(Context paramContext, g paramg)
  {
    AppMethodBeat.i(47378);
    Object localObject = v.sZx;
    try
    {
      v.b(paramg);
      com.tencent.mm.plugin.appbrand.launching.precondition.f localf = com.tencent.mm.plugin.appbrand.launching.precondition.f.teH;
      kotlin.g.b.s.checkNotNull(paramg);
      LaunchParcel localLaunchParcel = v.c(paramg);
      if (z.raW == paramg.epq)
      {
        paramg = AndroidContextUtil.castActivityOrNull(paramContext);
        if (paramg != null)
        {
          Window localWindow = paramg.getWindow();
          if (localWindow != null)
          {
            localObject = localLaunchParcel.epj;
            paramg = (g)localObject;
            if (localObject == null) {
              paramg = new AppBrandInitWindowConfig(null, null, false, null, null, 127);
            }
            localLaunchParcel.epj = paramg;
            paramg = localLaunchParcel.epj;
            kotlin.g.b.s.checkNotNull(paramg);
            paramg.epo = true;
            paramg = localLaunchParcel.epj;
            kotlin.g.b.s.checkNotNull(paramg);
            paramg.epp = localWindow.getNavigationBarColor();
          }
        }
      }
      paramg = ah.aiuX;
      localf.a(paramContext, localLaunchParcel);
      AppMethodBeat.o(47378);
      return;
    }
    catch (Exception paramContext)
    {
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED))
      {
        paramContext = new RuntimeException((Throwable)paramContext);
        AppMethodBeat.o(47378);
        throw paramContext;
      }
      Log.printErrStackTrace("MicroMsg.AppBrand.ExportWxaInstrumentation", (Throwable)paramContext, "", new Object[0]);
      AppMethodBeat.o(47378);
    }
  }
  
  public final void a(Context paramContext, String paramString1, int paramInt, String paramString2, AppBrandStatObject paramAppBrandStatObject, String paramString3, String paramString4)
  {
    AppMethodBeat.i(47382);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.qYE = 7;
    localAppBrandLaunchReferrer.appId = paramString3;
    localAppBrandLaunchReferrer.qYH = paramString4;
    AppBrandLaunchProxyUI.a(paramContext, paramString1, null, paramString2, paramInt, 0, paramAppBrandStatObject, localAppBrandLaunchReferrer, null);
    AppMethodBeat.o(47382);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47377);
    AppBrandLaunchProxyUI.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramAppBrandStatObject, null, null);
    AppMethodBeat.o(47377);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, AppBrandStatObject paramAppBrandStatObject, String paramString4)
  {
    AppMethodBeat.i(47379);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    switch (paramAppBrandStatObject.scene)
    {
    }
    for (;;)
    {
      localAppBrandLaunchReferrer.appId = paramString4;
      AppBrandLaunchProxyUI.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramAppBrandStatObject, localAppBrandLaunchReferrer, null);
      AppMethodBeat.o(47379);
      return;
      localAppBrandLaunchReferrer.qYE = 4;
      continue;
      localAppBrandLaunchReferrer.qYE = 2;
      continue;
      localAppBrandLaunchReferrer.qYE = 5;
    }
  }
  
  public final void a(Context paramContext, final String paramString1, final String paramString2, String paramString3, final int paramInt, final t.a parama)
  {
    AppMethodBeat.i(47384);
    Log.i("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk isMain[%b]", new Object[] { Boolean.valueOf(MMHandlerThread.isMainThread()) });
    parama = new t.a()
    {
      private boolean tcE = false;
      
      public final void cAA()
      {
        AppMethodBeat.i(47372);
        if (this.tcE)
        {
          AppMethodBeat.o(47372);
          return;
        }
        this.tcE = true;
        if (parama != null) {
          parama.cAA();
        }
        AppMethodBeat.o(47372);
      }
      
      public final void cAz()
      {
        AppMethodBeat.i(47371);
        if (this.tcE)
        {
          AppMethodBeat.o(47371);
          return;
        }
        this.tcE = true;
        if (parama != null) {
          parama.cAz();
        }
        AppMethodBeat.o(47371);
      }
    };
    this.rWH = false;
    a(paramContext, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(47373);
        Log.w("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, user canceled");
        bh.a(bh.this);
        parama.cAA();
        OpenBusinessViewUtil.I(paramString1, paramString2, -2);
        AppMethodBeat.o(47373);
      }
    });
    OpenBusinessViewUtil.a(1, paramString2, paramString3, paramString1, null, new OpenBusinessViewUtil.a()
    {
      public final void aw(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(47375);
        Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail, CGI errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        bh.b(bh.this);
        parama.cAA();
        OpenBusinessViewUtil.I(paramString1, paramString2, -3);
        AppMethodBeat.o(47375);
      }
      
      public final void br(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(47374);
        bh.b(bh.this);
        if (bh.c(bh.this))
        {
          AppMethodBeat.o(47374);
          return;
        }
        if (Util.isNullOrNil(paramAnonymousString1))
        {
          Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, invalid businessType");
          parama.cAA();
          OpenBusinessViewUtil.I(paramString1, paramString2, -3);
          AppMethodBeat.o(47374);
          return;
        }
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1069;
        localAppBrandStatObject.hzx = paramString1;
        AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer.appId = paramString1;
        localAppBrandLaunchReferrer.qYE = 4;
        localAppBrandLaunchReferrer.businessType = paramString2;
        localAppBrandLaunchReferrer.sourceType = 5;
        if (AppBrandLaunchProxyUI.a(MMApplicationContext.getContext(), null, paramAnonymousString1, paramAnonymousString2, paramInt, -1, localAppBrandStatObject, localAppBrandLaunchReferrer, null))
        {
          Log.i("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch success");
          parama.cAz();
          AppMethodBeat.o(47374);
          return;
        }
        Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail");
        parama.cAA();
        OpenBusinessViewUtil.I(paramString1, paramString2, -3);
        AppMethodBeat.o(47374);
      }
    });
    AppMethodBeat.o(47384);
  }
  
  public final void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, String paramString4, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(47383);
    this.rWH = false;
    a(paramContext, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(47368);
        Log.w("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, user canceled");
        bh.a(bh.this);
        OpenBusinessViewUtil.J(paramString3, null, -3);
        AppMethodBeat.o(47368);
      }
    });
    OpenBusinessViewUtil.a(2, paramString3, paramString4, paramString2, paramString1, new OpenBusinessViewUtil.a()
    {
      public final void aw(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(47370);
        Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch fail, CGI errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        bh.b(bh.this);
        OpenBusinessViewUtil.J(paramString3, null, -2);
        AppMethodBeat.o(47370);
      }
      
      public final void br(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(47369);
        bh.b(bh.this);
        if (bh.c(bh.this))
        {
          AppMethodBeat.o(47369);
          return;
        }
        if (Util.isNullOrNil(paramAnonymousString1))
        {
          Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, invalid businessType");
          OpenBusinessViewUtil.J(paramString3, null, -4);
          AppMethodBeat.o(47369);
          return;
        }
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1055;
        localAppBrandStatObject.hzx = (r.cg(Util.nullAsNil(paramString1)) + ":" + paramString2 + ":" + paramInt2);
        AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer.appId = paramString2;
        localAppBrandLaunchReferrer.qYE = 2;
        localAppBrandLaunchReferrer.url = paramString1;
        localAppBrandLaunchReferrer.businessType = paramString3;
        localAppBrandLaunchReferrer.sourceType = 5;
        if (AppBrandLaunchProxyUI.a(paramContext, null, paramAnonymousString1, paramAnonymousString2, paramInt1, -1, localAppBrandStatObject, localAppBrandLaunchReferrer, null))
        {
          Log.i("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch success");
          AppMethodBeat.o(47369);
          return;
        }
        Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch fail");
        OpenBusinessViewUtil.J(paramString3, null, -1);
        AppMethodBeat.o(47369);
      }
    });
    AppMethodBeat.o(47383);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(175004);
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    label57:
    label65:
    Object localObject;
    if (paramBundle.getBoolean("stat_kf_guide", false))
    {
      i = 1;
      if (i == 0) {
        break label493;
      }
      Log.d("MicroMsg.WeAppLauncher", "launchByOpenSdkAppMessage kf guide msg");
      localAppBrandStatObject.scene = 1157;
      localAppBrandStatObject.hzx = paramString1;
      if (!paramBoolean) {
        break label550;
      }
      i = 2;
      localAppBrandStatObject.icZ = i;
      localObject = paramString2;
      if (paramBoolean) {
        localObject = String.format("%s:%s", new Object[] { paramString1, paramString2 });
      }
      localAppBrandStatObject.ida = ((String)localObject);
      localObject = new LaunchParamsOptional();
      localAppBrandStatObject.chatType = paramBundle.getInt("chat_type", -1);
      if (Util.isNullOrNil(paramb.nTJ)) {
        break label556;
      }
      ((LaunchParamsOptional)localObject).eoT = paramString1;
      ((LaunchParamsOptional)localObject).eoU = paramb.nTJ;
      localAppBrandStatObject.hzx += ":1";
      label186:
      ((LaunchParamsOptional)localObject).opX = paramb.nTP;
      localAppBrandStatObject.hzx = (localAppBrandStatObject.hzx + ":" + Util.nullAsNil(paramb.nTI));
      localAppBrandStatObject.hzx = (localAppBrandStatObject.hzx + ":" + paramBundle.getInt("chat_type", -1));
      localAppBrandStatObject.hzx = (localAppBrandStatObject.hzx + ":" + paramString1);
      if (localAppBrandStatObject.scene == 1036)
      {
        i = paramBundle.getInt("stat_scene", 0);
        if ((i == 2) || (i == 1)) {
          if (!b.a(paramb, ((com.tencent.mm.plugin.appbrand.service.s)h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(paramb.nTD))) {
            break label588;
          }
        }
      }
    }
    label550:
    label556:
    label588:
    for (int i = 1;; i = 0)
    {
      localAppBrandStatObject.hzx = (localAppBrandStatObject.hzx + ":" + i);
      paramBundle = new AppBrandLaunchReferrer();
      paramBundle.qYE = 4;
      paramBundle.appId = paramb.appId;
      paramString2 = "";
      if (paramBoolean) {
        paramString2 = paramString1;
      }
      AppBrandLaunchProxyUI.a(paramContext, paramb.nTD, paramb.nTE, paramb.nTC, paramb.nTW, paramb.nTX, paramString2, localAppBrandStatObject, paramBundle, (LaunchParamsOptional)localObject);
      AppMethodBeat.o(175004);
      return;
      i = 0;
      break;
      label493:
      localAppBrandStatObject.scene = 1036;
      localAppBrandStatObject.hzx = (Util.nullAsNil(paramb.appId) + ":" + Util.nullAsNil(r.cg(paramb.url)));
      break label57;
      i = 1;
      break label65;
      localAppBrandStatObject.hzx += ":0";
      break label186;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.api.i parami)
  {
    AppMethodBeat.i(321003);
    if (parami != null) {
      WeAppOpenUICallbackIPCProxy.c.b(parami);
    }
    AppMethodBeat.o(321003);
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(47376);
    if (Util.isNullOrNil(paramString3))
    {
      AppMethodBeat.o(47376);
      return;
    }
    if ((Util.isNullOrNil(paramString3)) || (Util.isNullOrNil(paramString2)))
    {
      Log.e("MicroMsg.WeAppLauncher", "targetAppId %s referrerAppId %s, Null Or Nil");
      AppMethodBeat.o(47376);
      return;
    }
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1055;
    localAppBrandStatObject.hzx = (r.cg(Util.nullAsNil(paramString1)) + ":" + paramString2 + ":" + paramInt2);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.appId = paramString2;
    localAppBrandLaunchReferrer.qYE = 2;
    localAppBrandLaunchReferrer.url = paramString1;
    AppBrandLaunchProxyUI.a(paramContext, null, paramString3, paramString4, paramInt1, -1, localAppBrandStatObject, localAppBrandLaunchReferrer, null);
    Assert.assertTrue(true);
    AppMethodBeat.o(47376);
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(47381);
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    LaunchParamsOptional localLaunchParamsOptional = new LaunchParamsOptional();
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    int j;
    label132:
    String str;
    if (paramBundle.getBoolean("stat_weishi_from_opensdk", false))
    {
      i = 1;
      if (i == 0) {
        break label503;
      }
      localAppBrandStatObject.scene = 1036;
      localAppBrandStatObject.hzx = (Util.nullAsNil(paramb.appId) + ":" + Util.nullAsNil(r.cg(paramb.url)) + ":" + Util.nullAsNil(paramb.nTI));
      if (!paramBoolean) {
        break label465;
      }
      j = 2;
      localAppBrandStatObject.icZ = j;
      str = paramString2;
      if (paramBoolean) {
        str = String.format("%s:%s", new Object[] { paramString1, paramString2 });
      }
      localAppBrandStatObject.ida = str;
      Log.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, from opensdk appmsg, scene:%s", new Object[] { Integer.valueOf(localAppBrandStatObject.scene) });
      if (Util.isNullOrNil(paramb.nTJ)) {
        break label471;
      }
      localAppBrandStatObject.hzx += ":1";
      label237:
      localAppBrandLaunchReferrer.appId = paramb.appId;
      localAppBrandLaunchReferrer.qYE = 4;
      if (!Util.isNullOrNil(paramb.nTJ))
      {
        localLaunchParamsOptional.eoT = paramString1;
        localLaunchParamsOptional.eoU = paramb.nTJ;
      }
      if ("wxfe02ecfe70800f46".equalsIgnoreCase(paramb.nTE))
      {
        paramString1 = new AppBrandWeishiParams();
        if (i == 0) {
          break label677;
        }
      }
    }
    label677:
    for (int i = 1;; i = 0)
    {
      paramString1.nPf = i;
      paramString1.thumbUrl = paramBundle.getString("stat_weishi_thumb_url", null);
      paramString1.qZi = paramBundle.getString("stat_weishi_thumb_path", null);
      paramString1.qZj = paramBundle.getString("stat_weishi_msg_img_path", null);
      paramString1.appId = paramBundle.getString("stat_weishi_app_id", null);
      paramString1.appName = paramBundle.getString("stat_weishi_app_name", null);
      paramString1.sourceUserName = paramBundle.getString("stat_weishi_source_username", null);
      localLaunchParamsOptional.eoW = paramString1;
      Log.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, weishi params:%s", new Object[] { paramString1 });
      AppBrandLaunchProxyUI.a(paramContext, paramb.nTD, paramb.nTE, paramb.nTC, paramb.nTW, paramb.nTX, localAppBrandStatObject, localAppBrandLaunchReferrer, localLaunchParamsOptional);
      AppMethodBeat.o(47381);
      return;
      i = 0;
      break;
      label465:
      j = 1;
      break label132;
      label471:
      localAppBrandStatObject.hzx += ":0";
      break label237;
      label503:
      str = paramb.nTI;
      if (paramBoolean) {
        localAppBrandStatObject.scene = 1008;
      }
      for (localAppBrandStatObject.hzx = (paramString1 + ":" + paramString2 + ":" + str);; localAppBrandStatObject.hzx = (paramString2 + ":" + str))
      {
        localAppBrandStatObject.icZ = n.o(localAppBrandStatObject.scene, paramBundle);
        localAppBrandStatObject.ida = n.p(localAppBrandStatObject.scene, paramBundle);
        Log.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, from chatting appmsg, scene:%s", new Object[] { Integer.valueOf(localAppBrandStatObject.scene) });
        localAppBrandLaunchReferrer.appId = paramb.appId;
        localAppBrandLaunchReferrer.qYE = 6;
        break;
        localAppBrandStatObject.scene = 1007;
      }
    }
  }
  
  public final void b(g paramg, com.tencent.mm.plugin.appbrand.api.f paramf)
  {
    AppMethodBeat.i(321009);
    if (paramg == null)
    {
      AppMethodBeat.o(321009);
      return;
    }
    m localm = m.qrR;
    m.a(paramg, paramf);
    AppMethodBeat.o(321009);
  }
  
  public final boolean cAy()
  {
    AppMethodBeat.i(321004);
    boolean bool = a.keX().Q("dis_set_back_ground_color", "tools", false);
    AppMethodBeat.o(321004);
    return bool;
  }
  
  public final boolean cT(String paramString, int paramInt)
  {
    AppMethodBeat.i(321013);
    boolean bool = com.tencent.mm.plugin.appbrand.task.i.cJV().C(paramString, paramInt);
    AppMethodBeat.o(321013);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bh
 * JD-Core Version:    0.7.0.1
 */