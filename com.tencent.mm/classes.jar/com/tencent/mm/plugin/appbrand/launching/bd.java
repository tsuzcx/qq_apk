package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.n;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.r.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import junit.framework.Assert;
import kotlin.g.b.p;

public final class bd
  implements r
{
  private s iYE;
  private boolean oRc = false;
  
  static
  {
    AppMethodBeat.i(284289);
    if (!bd.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(284289);
      return;
    }
  }
  
  private void a(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(47385);
    bsu();
    paramContext.getString(au.i.app_tip);
    this.iYE = h.a(paramContext, paramContext.getString(au.i.app_waiting), true, paramOnCancelListener);
    AppMethodBeat.o(47385);
  }
  
  private void bsu()
  {
    AppMethodBeat.i(47386);
    if (this.iYE != null)
    {
      this.iYE.dismiss();
      this.iYE = null;
    }
    AppMethodBeat.o(47386);
  }
  
  public final void a(Context paramContext, g paramg)
  {
    AppMethodBeat.i(47378);
    Object localObject = t.pUE;
    try
    {
      t.a(paramg);
      localObject = com.tencent.mm.plugin.appbrand.launching.e.f.pZN;
      if (paramg == null) {
        p.iCn();
      }
      ((com.tencent.mm.plugin.appbrand.launching.e.f)localObject).a(paramContext, t.b(paramg));
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
    localAppBrandLaunchReferrer.nYB = 7;
    localAppBrandLaunchReferrer.appId = paramString3;
    localAppBrandLaunchReferrer.nYE = paramString4;
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
      localAppBrandLaunchReferrer.nYB = 4;
      continue;
      localAppBrandLaunchReferrer.nYB = 2;
      continue;
      localAppBrandLaunchReferrer.nYB = 5;
    }
  }
  
  public final void a(Context paramContext, final String paramString1, final String paramString2, String paramString3, final int paramInt, final r.a parama)
  {
    AppMethodBeat.i(47384);
    Log.i("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk isMain[%b]", new Object[] { Boolean.valueOf(MMHandlerThread.isMainThread()) });
    parama = new r.a()
    {
      private boolean pXN = false;
      
      public final void cak()
      {
        AppMethodBeat.i(47371);
        if (this.pXN)
        {
          AppMethodBeat.o(47371);
          return;
        }
        this.pXN = true;
        if (parama != null) {
          parama.cak();
        }
        AppMethodBeat.o(47371);
      }
      
      public final void cal()
      {
        AppMethodBeat.i(47372);
        if (this.pXN)
        {
          AppMethodBeat.o(47372);
          return;
        }
        this.pXN = true;
        if (parama != null) {
          parama.cal();
        }
        AppMethodBeat.o(47372);
      }
    };
    this.oRc = false;
    a(paramContext, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(47373);
        Log.w("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, user canceled");
        bd.a(bd.this);
        parama.cal();
        OpenBusinessViewUtil.D(paramString1, paramString2, -2);
        AppMethodBeat.o(47373);
      }
    });
    OpenBusinessViewUtil.a(1, paramString2, paramString3, paramString1, null, new OpenBusinessViewUtil.a()
    {
      public final void R(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(47374);
        bd.b(bd.this);
        if (bd.c(bd.this))
        {
          AppMethodBeat.o(47374);
          return;
        }
        if (Util.isNullOrNil(paramAnonymousString1))
        {
          Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, invalid businessType");
          parama.cal();
          OpenBusinessViewUtil.D(paramString1, paramString2, -3);
          AppMethodBeat.o(47374);
          return;
        }
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1069;
        localAppBrandStatObject.fvd = paramString1;
        AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer.appId = paramString1;
        localAppBrandLaunchReferrer.nYB = 4;
        localAppBrandLaunchReferrer.businessType = paramString2;
        localAppBrandLaunchReferrer.sourceType = 5;
        if (AppBrandLaunchProxyUI.a(MMApplicationContext.getContext(), null, paramAnonymousString1, paramAnonymousString2, paramInt, -1, localAppBrandStatObject, localAppBrandLaunchReferrer, null))
        {
          Log.i("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch success");
          parama.cak();
          AppMethodBeat.o(47374);
          return;
        }
        Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail");
        parama.cal();
        OpenBusinessViewUtil.D(paramString1, paramString2, -3);
        AppMethodBeat.o(47374);
      }
      
      public final void am(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(47375);
        Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail, CGI errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        bd.b(bd.this);
        parama.cal();
        OpenBusinessViewUtil.D(paramString1, paramString2, -3);
        AppMethodBeat.o(47375);
      }
    });
    AppMethodBeat.o(47384);
  }
  
  public final void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, String paramString4, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(47383);
    this.oRc = false;
    a(paramContext, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(47368);
        Log.w("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, user canceled");
        bd.a(bd.this);
        OpenBusinessViewUtil.E(paramString3, null, -3);
        AppMethodBeat.o(47368);
      }
    });
    OpenBusinessViewUtil.a(2, paramString3, paramString4, paramString2, paramString1, new OpenBusinessViewUtil.a()
    {
      public final void R(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(47369);
        bd.b(bd.this);
        if (bd.c(bd.this))
        {
          AppMethodBeat.o(47369);
          return;
        }
        if (Util.isNullOrNil(paramAnonymousString1))
        {
          Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, invalid businessType");
          OpenBusinessViewUtil.E(paramString3, null, -4);
          AppMethodBeat.o(47369);
          return;
        }
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1055;
        localAppBrandStatObject.fvd = (q.aT(Util.nullAsNil(paramString1)) + ":" + paramString2 + ":" + paramInt2);
        AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer.appId = paramString2;
        localAppBrandLaunchReferrer.nYB = 2;
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
        OpenBusinessViewUtil.E(paramString3, null, -1);
        AppMethodBeat.o(47369);
      }
      
      public final void am(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(47370);
        Log.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch fail, CGI errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        bd.b(bd.this);
        OpenBusinessViewUtil.E(paramString3, null, -2);
        AppMethodBeat.o(47370);
      }
    });
    AppMethodBeat.o(47383);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(175004);
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    int i;
    label54:
    label62:
    Object localObject;
    if (paramBundle.getBoolean("stat_kf_guide", false))
    {
      i = 1;
      if (i == 0) {
        break label388;
      }
      Log.d("MicroMsg.WeAppLauncher", "launchByOpenSdkAppMessage kf guide msg");
      localAppBrandStatObject.scene = 1157;
      localAppBrandStatObject.fvd = paramString1;
      if (!paramBoolean) {
        break label445;
      }
      i = 2;
      localAppBrandStatObject.fXa = i;
      localObject = paramString2;
      if (paramBoolean) {
        localObject = String.format("%s:%s", new Object[] { paramString1, paramString2 });
      }
      localAppBrandStatObject.fXb = ((String)localObject);
      localObject = new LaunchParamsOptional();
      localAppBrandStatObject.chatType = paramBundle.getInt("chat_type", -1);
      if (Util.isNullOrNil(paramb.loG)) {
        break label451;
      }
      ((LaunchParamsOptional)localObject).cwT = paramString1;
      ((LaunchParamsOptional)localObject).cwU = paramb.loG;
    }
    label388:
    label445:
    label451:
    for (localAppBrandStatObject.fvd += ":1";; localAppBrandStatObject.fvd += ":0")
    {
      ((LaunchParamsOptional)localObject).lyw = paramb.loM;
      localAppBrandStatObject.fvd = (localAppBrandStatObject.fvd + ":" + Util.nullAsNil(paramb.loF));
      localAppBrandStatObject.fvd = (localAppBrandStatObject.fvd + ":" + paramBundle.getInt("chat_type", -1));
      localAppBrandStatObject.fvd = (localAppBrandStatObject.fvd + ":" + paramString1);
      paramBundle = new AppBrandLaunchReferrer();
      paramBundle.nYB = 4;
      paramBundle.appId = paramb.appId;
      paramString2 = "";
      if (paramBoolean) {
        paramString2 = paramString1;
      }
      AppBrandLaunchProxyUI.a(paramContext, paramb.loA, paramb.loB, paramb.loz, paramb.loT, paramb.loU, paramString2, localAppBrandStatObject, paramBundle, (LaunchParamsOptional)localObject);
      AppMethodBeat.o(175004);
      return;
      i = 0;
      break;
      localAppBrandStatObject.scene = 1036;
      localAppBrandStatObject.fvd = (Util.nullAsNil(paramb.appId) + ":" + Util.nullAsNil(q.aT(paramb.url)));
      break label54;
      i = 1;
      break label62;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.api.i parami)
  {
    AppMethodBeat.i(284284);
    if (parami != null) {
      WeAppOpenUICallbackIPCProxy.c.b(parami);
    }
    AppMethodBeat.o(284284);
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
    localAppBrandStatObject.fvd = (q.aT(Util.nullAsNil(paramString1)) + ":" + paramString2 + ":" + paramInt2);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.appId = paramString2;
    localAppBrandLaunchReferrer.nYB = 2;
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
      localAppBrandStatObject.fvd = (Util.nullAsNil(paramb.appId) + ":" + Util.nullAsNil(q.aT(paramb.url)) + ":" + Util.nullAsNil(paramb.loF));
      if (!paramBoolean) {
        break label464;
      }
      j = 2;
      localAppBrandStatObject.fXa = j;
      str = paramString2;
      if (paramBoolean) {
        str = String.format("%s:%s", new Object[] { paramString1, paramString2 });
      }
      localAppBrandStatObject.fXb = str;
      Log.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, from opensdk appmsg, scene:%s", new Object[] { Integer.valueOf(localAppBrandStatObject.scene) });
      if (Util.isNullOrNil(paramb.loG)) {
        break label470;
      }
      localAppBrandStatObject.fvd += ":1";
      label236:
      localAppBrandLaunchReferrer.appId = paramb.appId;
      localAppBrandLaunchReferrer.nYB = 4;
      if (!Util.isNullOrNil(paramb.loG))
      {
        localLaunchParamsOptional.cwT = paramString1;
        localLaunchParamsOptional.cwU = paramb.loG;
      }
      if ("wxfe02ecfe70800f46".equalsIgnoreCase(paramb.loB))
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
      paramString1.lkt = i;
      paramString1.thumbUrl = paramBundle.getString("stat_weishi_thumb_url", null);
      paramString1.nZa = paramBundle.getString("stat_weishi_thumb_path", null);
      paramString1.nZb = paramBundle.getString("stat_weishi_msg_img_path", null);
      paramString1.appId = paramBundle.getString("stat_weishi_app_id", null);
      paramString1.appName = paramBundle.getString("stat_weishi_app_name", null);
      paramString1.sourceUserName = paramBundle.getString("stat_weishi_source_username", null);
      localLaunchParamsOptional.cwW = paramString1;
      Log.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, weishi params:%s", new Object[] { paramString1 });
      AppBrandLaunchProxyUI.a(paramContext, paramb.loA, paramb.loB, paramb.loz, paramb.loT, paramb.loU, localAppBrandStatObject, localAppBrandLaunchReferrer, localLaunchParamsOptional);
      AppMethodBeat.o(47381);
      return;
      i = 0;
      break;
      label464:
      j = 1;
      break label132;
      label470:
      localAppBrandStatObject.fvd += ":0";
      break label236;
      label502:
      str = paramb.loF;
      if (paramBoolean) {
        localAppBrandStatObject.scene = 1008;
      }
      for (localAppBrandStatObject.fvd = (paramString1 + ":" + paramString2 + ":" + str);; localAppBrandStatObject.fvd = (paramString2 + ":" + str))
      {
        localAppBrandStatObject.fXa = n.m(localAppBrandStatObject.scene, paramBundle);
        localAppBrandStatObject.fXb = n.n(localAppBrandStatObject.scene, paramBundle);
        Log.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, from chatting appmsg, scene:%s", new Object[] { Integer.valueOf(localAppBrandStatObject.scene) });
        localAppBrandLaunchReferrer.appId = paramb.appId;
        localAppBrandLaunchReferrer.nYB = 6;
        break;
        localAppBrandStatObject.scene = 1007;
      }
    }
  }
  
  public final void b(g paramg, com.tencent.mm.plugin.appbrand.api.f paramf)
  {
    AppMethodBeat.i(284286);
    if (paramg == null)
    {
      AppMethodBeat.o(284286);
      return;
    }
    m localm = m.ntn;
    m.a(paramg, paramf);
    AppMethodBeat.o(284286);
  }
  
  public final boolean cu(String paramString, int paramInt)
  {
    AppMethodBeat.i(284287);
    boolean bool = com.tencent.mm.plugin.appbrand.task.i.cjb().w(paramString, paramInt);
    AppMethodBeat.o(284287);
    return bool;
  }
  
  public final void ex(String paramString1, String paramString2)
  {
    AppMethodBeat.i(284285);
    if (TextUtils.isEmpty(paramString2)) {}
    for (String str = y.afi(paramString1);; str = paramString2)
    {
      Log.i("MicroMsg.WeAppLauncher", "closeWxaApp() identity:[%s | %s]->[%s | %s], versionType:%d, allowBackgroundRunning:%b", new Object[] { paramString1, paramString2, paramString1, str, Integer.valueOf(-1), Boolean.FALSE });
      if (TextUtils.isEmpty(str))
      {
        AppMethodBeat.o(284285);
        return;
      }
      if ((!$assertionsDisabled) && (str == null))
      {
        paramString1 = new AssertionError();
        AppMethodBeat.o(284285);
        throw paramString1;
      }
      com.tencent.mm.plugin.appbrand.task.i.cjb().u(str, -1);
      AppMethodBeat.o(284285);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bd
 * JD-Core Version:    0.7.0.1
 */