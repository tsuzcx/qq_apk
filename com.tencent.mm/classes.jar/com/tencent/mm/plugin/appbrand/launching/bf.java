package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.api.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.m;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.r.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class bf
  implements r
{
  private com.tencent.mm.ui.base.q gut;
  private boolean lUi = false;
  
  private void a(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(47385);
    biW();
    paramContext.getString(2131755998);
    this.gut = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131756029), true, paramOnCancelListener);
    AppMethodBeat.o(47385);
  }
  
  private void biW()
  {
    AppMethodBeat.i(47386);
    if (this.gut != null)
    {
      this.gut.dismiss();
      this.gut = null;
    }
    AppMethodBeat.o(47386);
  }
  
  public final void a(Context paramContext, g paramg)
  {
    AppMethodBeat.i(47378);
    Object localObject = u.mTD;
    try
    {
      u.a(paramg);
      localObject = com.tencent.mm.plugin.appbrand.launching.e.f.mZp;
      if (paramg == null) {
        kotlin.g.b.p.hyc();
      }
      ((com.tencent.mm.plugin.appbrand.launching.e.f)localObject).a(paramContext, u.b(paramg));
      AppMethodBeat.o(47378);
      return;
    }
    catch (Exception paramContext)
    {
      if (BuildInfo.IS_FLAVOR_RED)
      {
        paramContext = (Throwable)new RuntimeException((Throwable)paramContext);
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
    localAppBrandLaunchReferrer.leo = 7;
    localAppBrandLaunchReferrer.appId = paramString3;
    localAppBrandLaunchReferrer.ler = paramString4;
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
      localAppBrandLaunchReferrer.leo = 4;
      continue;
      localAppBrandLaunchReferrer.leo = 2;
      continue;
      localAppBrandLaunchReferrer.leo = 5;
    }
  }
  
  public final void a(Context paramContext, final String paramString1, final String paramString2, String paramString3, final int paramInt, final r.a parama)
  {
    AppMethodBeat.i(47384);
    Log.i("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk isMain[%b]", new Object[] { Boolean.valueOf(MMHandlerThread.isMainThread()) });
    parama = new r.a()
    {
      private boolean mXt = false;
      
      public final void bNR()
      {
        AppMethodBeat.i(47371);
        if (this.mXt)
        {
          AppMethodBeat.o(47371);
          return;
        }
        this.mXt = true;
        if (parama != null) {
          parama.bNR();
        }
        AppMethodBeat.o(47371);
      }
      
      public final void bNS()
      {
        AppMethodBeat.i(47372);
        if (this.mXt)
        {
          AppMethodBeat.o(47372);
          return;
        }
        this.mXt = true;
        if (parama != null) {
          parama.bNS();
        }
        AppMethodBeat.o(47372);
      }
    };
    this.lUi = false;
    a(paramContext, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(47373);
        Log.w("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, user canceled");
        bf.a(bf.this);
        parama.bNS();
        OpenBusinessViewUtil.A(paramString1, paramString2, -2);
        AppMethodBeat.o(47373);
      }
    });
    OpenBusinessViewUtil.a(1, paramString2, paramString3, paramString1, null, new OpenBusinessViewUtil.a()
    {
      public final void ak(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(47375);
        Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail, CGI errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        bf.b(bf.this);
        parama.bNS();
        OpenBusinessViewUtil.A(paramString1, paramString2, -3);
        AppMethodBeat.o(47375);
      }
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(47374);
        bf.b(bf.this);
        if (bf.c(bf.this))
        {
          AppMethodBeat.o(47374);
          return;
        }
        if (Util.isNullOrNil(paramAnonymousString1))
        {
          Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, invalid businessType");
          parama.bNS();
          OpenBusinessViewUtil.A(paramString1, paramString2, -3);
          AppMethodBeat.o(47374);
          return;
        }
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1069;
        localAppBrandStatObject.dCw = paramString1;
        AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer.appId = paramString1;
        localAppBrandLaunchReferrer.leo = 4;
        localAppBrandLaunchReferrer.businessType = paramString2;
        localAppBrandLaunchReferrer.sourceType = 5;
        if (AppBrandLaunchProxyUI.a(MMApplicationContext.getContext(), null, paramAnonymousString1, paramAnonymousString2, paramInt, -1, localAppBrandStatObject, localAppBrandLaunchReferrer, null))
        {
          Log.i("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch success");
          parama.bNR();
          AppMethodBeat.o(47374);
          return;
        }
        Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail");
        parama.bNS();
        OpenBusinessViewUtil.A(paramString1, paramString2, -3);
        AppMethodBeat.o(47374);
      }
    });
    AppMethodBeat.o(47384);
  }
  
  public final void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, String paramString4, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(47383);
    this.lUi = false;
    a(paramContext, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(47368);
        Log.w("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, user canceled");
        bf.a(bf.this);
        OpenBusinessViewUtil.B(paramString3, null, -3);
        AppMethodBeat.o(47368);
      }
    });
    OpenBusinessViewUtil.a(2, paramString3, paramString4, paramString2, paramString1, new OpenBusinessViewUtil.a()
    {
      public final void ak(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(47370);
        Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch fail, CGI errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        bf.b(bf.this);
        OpenBusinessViewUtil.B(paramString3, null, -2);
        AppMethodBeat.o(47370);
      }
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(47369);
        bf.b(bf.this);
        if (bf.c(bf.this))
        {
          AppMethodBeat.o(47369);
          return;
        }
        if (Util.isNullOrNil(paramAnonymousString1))
        {
          Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, invalid businessType");
          OpenBusinessViewUtil.B(paramString3, null, -4);
          AppMethodBeat.o(47369);
          return;
        }
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1055;
        localAppBrandStatObject.dCw = (com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(paramString1)) + ":" + paramString2 + ":" + paramInt2);
        AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer.appId = paramString2;
        localAppBrandLaunchReferrer.leo = 2;
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
        OpenBusinessViewUtil.B(paramString3, null, -1);
        AppMethodBeat.o(47369);
      }
    });
    AppMethodBeat.o(47383);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(175004);
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    int i;
    if (paramBundle.getBoolean("stat_kf_guide", false))
    {
      i = 1;
      if (i == 0) {
        break label273;
      }
      Log.d("MicroMsg.WeAppLauncher", "launchByOpenSdkAppMessage kf guide msg");
      localAppBrandStatObject.scene = 1157;
      localAppBrandStatObject.dCw = paramString1;
      label54:
      if (!paramBoolean) {
        break label330;
      }
      i = 2;
      label62:
      localAppBrandStatObject.ecU = i;
      paramBundle = paramString2;
      if (paramBoolean) {
        paramBundle = String.format("%s:%s", new Object[] { paramString1, paramString2 });
      }
      localAppBrandStatObject.ecV = paramBundle;
      paramString2 = new LaunchParamsOptional();
      if (Util.isNullOrNil(paramb.izo)) {
        break label336;
      }
      paramString2.cyq = paramString1;
      paramString2.cyr = paramb.izo;
    }
    label273:
    label330:
    label336:
    for (localAppBrandStatObject.dCw += ":1";; localAppBrandStatObject.dCw += ":0")
    {
      localAppBrandStatObject.dCw = (localAppBrandStatObject.dCw + ":" + Util.nullAsNil(paramb.izn));
      paramString1 = new AppBrandLaunchReferrer();
      paramString1.leo = 4;
      paramString1.appId = paramb.appId;
      AppBrandLaunchProxyUI.a(paramContext, paramb.izi, paramb.izj, paramb.izh, paramb.izz, paramb.izA, localAppBrandStatObject, paramString1, paramString2);
      AppMethodBeat.o(175004);
      return;
      i = 0;
      break;
      localAppBrandStatObject.scene = 1036;
      localAppBrandStatObject.dCw = (Util.nullAsNil(paramb.appId) + ":" + Util.nullAsNil(com.tencent.mm.compatible.util.q.encode(paramb.url)));
      break label54;
      i = 1;
      break label62;
    }
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(227119);
    if (parami != null) {
      WeAppOpenUICallbackIPCProxy.c.b(parami);
    }
    AppMethodBeat.o(227119);
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
    localAppBrandStatObject.dCw = (com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(paramString1)) + ":" + paramString2 + ":" + paramInt2);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.appId = paramString2;
    localAppBrandLaunchReferrer.leo = 2;
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
        break label502;
      }
      localAppBrandStatObject.scene = 1036;
      localAppBrandStatObject.dCw = (Util.nullAsNil(paramb.appId) + ":" + Util.nullAsNil(com.tencent.mm.compatible.util.q.encode(paramb.url)) + ":" + Util.nullAsNil(paramb.izn));
      if (!paramBoolean) {
        break label464;
      }
      j = 2;
      localAppBrandStatObject.ecU = j;
      str = paramString2;
      if (paramBoolean) {
        str = String.format("%s:%s", new Object[] { paramString1, paramString2 });
      }
      localAppBrandStatObject.ecV = str;
      Log.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, from opensdk appmsg, scene:%s", new Object[] { Integer.valueOf(localAppBrandStatObject.scene) });
      if (Util.isNullOrNil(paramb.izo)) {
        break label470;
      }
      localAppBrandStatObject.dCw += ":1";
      label236:
      localAppBrandLaunchReferrer.appId = paramb.appId;
      localAppBrandLaunchReferrer.leo = 4;
      if (!Util.isNullOrNil(paramb.izo))
      {
        localLaunchParamsOptional.cyq = paramString1;
        localLaunchParamsOptional.cyr = paramb.izo;
      }
      if ("wxfe02ecfe70800f46".equalsIgnoreCase(paramb.izj))
      {
        paramString1 = new AppBrandWeishiParams();
        if (i == 0) {
          break label676;
        }
      }
    }
    label676:
    for (int i = 1;; i = 0)
    {
      paramString1.ivk = i;
      paramString1.thumbUrl = paramBundle.getString("stat_weishi_thumb_url", null);
      paramString1.leN = paramBundle.getString("stat_weishi_thumb_path", null);
      paramString1.leO = paramBundle.getString("stat_weishi_msg_img_path", null);
      paramString1.appId = paramBundle.getString("stat_weishi_app_id", null);
      paramString1.appName = paramBundle.getString("stat_weishi_app_name", null);
      paramString1.sourceUserName = paramBundle.getString("stat_weishi_source_username", null);
      localLaunchParamsOptional.cyt = paramString1;
      Log.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, weishi params:%s", new Object[] { paramString1 });
      AppBrandLaunchProxyUI.a(paramContext, paramb.izi, paramb.izj, paramb.izh, paramb.izz, paramb.izA, localAppBrandStatObject, localAppBrandLaunchReferrer, localLaunchParamsOptional);
      AppMethodBeat.o(47381);
      return;
      i = 0;
      break;
      label464:
      j = 1;
      break label132;
      label470:
      localAppBrandStatObject.dCw += ":0";
      break label236;
      label502:
      str = paramb.izn;
      if (paramBoolean) {
        localAppBrandStatObject.scene = 1008;
      }
      for (localAppBrandStatObject.dCw = (paramString1 + ":" + paramString2 + ":" + str);; localAppBrandStatObject.dCw = (paramString2 + ":" + str))
      {
        localAppBrandStatObject.ecU = m.k(localAppBrandStatObject.scene, paramBundle);
        localAppBrandStatObject.ecV = m.l(localAppBrandStatObject.scene, paramBundle);
        Log.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, from chatting appmsg, scene:%s", new Object[] { Integer.valueOf(localAppBrandStatObject.scene) });
        localAppBrandLaunchReferrer.appId = paramb.appId;
        localAppBrandLaunchReferrer.leo = 6;
        break;
        localAppBrandStatObject.scene = 1007;
      }
    }
  }
  
  public final void b(g paramg, com.tencent.mm.plugin.appbrand.api.f paramf)
  {
    AppMethodBeat.i(227121);
    if (paramg == null)
    {
      AppMethodBeat.o(227121);
      return;
    }
    j localj = j.kAc;
    j.a(paramg, paramf);
    AppMethodBeat.o(227121);
  }
  
  public final boolean bW(String paramString, int paramInt)
  {
    AppMethodBeat.i(227122);
    boolean bool = com.tencent.mm.plugin.appbrand.task.h.bWb().cn(paramString, paramInt);
    AppMethodBeat.o(227122);
    return bool;
  }
  
  public final void ej(String paramString1, String paramString2)
  {
    AppMethodBeat.i(227120);
    if (TextUtils.isEmpty(paramString2)) {}
    for (String str = y.Xw(paramString1);; str = paramString2)
    {
      Log.i("MicroMsg.WeAppLauncher", "closeWxaApp() identity:[%s | %s]->[%s | %s], versionType:%d, allowBackgroundRunning:%b", new Object[] { paramString1, paramString2, paramString1, str, Integer.valueOf(-1), Boolean.FALSE });
      if (TextUtils.isEmpty(str))
      {
        AppMethodBeat.o(227120);
        return;
      }
      com.tencent.mm.plugin.appbrand.task.h.bWb().cl(str, -1);
      AppMethodBeat.o(227120);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bf
 * JD-Core Version:    0.7.0.1
 */