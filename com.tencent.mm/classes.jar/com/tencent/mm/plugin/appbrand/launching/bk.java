package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import junit.framework.Assert;

public final class bk
  implements com.tencent.mm.plugin.appbrand.service.n
{
  private com.tencent.mm.ui.base.p fua;
  private boolean kqy = false;
  
  private void a(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(47385);
    aLi();
    paramContext.getString(2131755906);
    this.fua = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131755936), true, paramOnCancelListener);
    AppMethodBeat.o(47385);
  }
  
  private void aLi()
  {
    AppMethodBeat.i(47386);
    if (this.fua != null)
    {
      this.fua.dismiss();
      this.fua = null;
    }
    AppMethodBeat.o(47386);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.appbrand.a.f paramf)
  {
    AppMethodBeat.i(47378);
    Object localObject = v.lkk;
    int i;
    try
    {
      localObject = (CharSequence)paramf.username;
      if (localObject == null) {
        break label634;
      }
      if (((CharSequence)localObject).length() != 0) {
        break label121;
      }
    }
    catch (Exception paramContext)
    {
      label68:
      if (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) {
        break label611;
      }
    }
    if (i != 0)
    {
      localObject = (CharSequence)paramf.appId;
      if (localObject != null)
      {
        if (((CharSequence)localObject).length() == 0) {
          break label639;
        }
        for (;;)
        {
          if (i == 0) {
            break label131;
          }
          paramContext = (Throwable)new IllegalArgumentException("Both username & appId is EMPTY");
          AppMethodBeat.o(47378);
          throw paramContext;
          paramContext = (Throwable)new RuntimeException((Throwable)paramContext);
          AppMethodBeat.o(47378);
          throw paramContext;
          label121:
          i = 0;
          break;
          i = 0;
        }
      }
    }
    else
    {
      label131:
      localObject = (CharSequence)paramf.username;
      if (localObject == null) {
        break label644;
      }
      if (((CharSequence)localObject).length() != 0) {
        break label649;
      }
      break label644;
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject = paramf.username;
        d.g.b.k.g(localObject, "username");
        if (!d.n.n.nc((String)localObject, "@app"))
        {
          paramContext = (Throwable)new IllegalArgumentException("Invalid weapp username " + paramf.username);
          AppMethodBeat.o(47378);
          throw paramContext;
        }
      }
      if ((!j.a.rq(paramf.hxM)) && (!j.a.on(paramf.hxM)))
      {
        paramContext = (Throwable)new IllegalArgumentException("Invalid weapp versionType " + paramf.hxM);
        AppMethodBeat.o(47378);
        throw paramContext;
      }
      if (paramf.scene <= 1000)
      {
        paramContext = (Throwable)new IllegalArgumentException("Invalid weapp enter scene " + paramf.scene);
        AppMethodBeat.o(47378);
        throw paramContext;
      }
      com.tencent.mm.plugin.appbrand.launching.e.f localf = com.tencent.mm.plugin.appbrand.launching.e.f.lqh;
      LaunchParcel localLaunchParcel = new LaunchParcel();
      localLaunchParcel.username = paramf.username;
      localLaunchParcel.appId = paramf.appId;
      localLaunchParcel.version = paramf.version;
      localLaunchParcel.hxM = paramf.hxM;
      localLaunchParcel.jjf = paramf.jjf;
      localObject = paramf.jjg;
      if (localObject != null)
      {
        localObject = ((d)localObject).aUZ();
        localLaunchParcel.jDC = ((String)localObject);
        localLaunchParcel.jDB = paramf.jjh;
        localObject = new AppBrandStatObject();
        ((AppBrandStatObject)localObject).scene = paramf.scene;
        ((AppBrandStatObject)localObject).cYP = paramf.cYP;
        ((AppBrandStatObject)localObject).dxE = paramf.jji;
        ((AppBrandStatObject)localObject).dxF = paramf.jjj;
        localLaunchParcel.lpG = ((AppBrandStatObject)localObject);
        localLaunchParcel.cce = paramf.jjo;
        if (paramf.jjk == null) {
          break label605;
        }
      }
      label605:
      for (localObject = (a)new v.a(paramf);; localObject = null)
      {
        localLaunchParcel.lpJ = ((a)localObject);
        localLaunchParcel.jjl = paramf.jjl;
        localLaunchParcel.jjp = paramf.jjp;
        localLaunchParcel.launchMode = paramf.launchMode;
        localLaunchParcel.jjq = paramf.jjq;
        localObject = new PersistableBundle();
        ((PersistableBundle)localObject).putString("KEY_OPENSDK_AD_TRACE_KEY", paramf.jjn);
        localLaunchParcel.lpL = ((PersistableBundle)localObject);
        localLaunchParcel.jjr = paramf.jjr;
        localf.a(paramContext, localLaunchParcel);
        AppMethodBeat.o(47378);
        return;
        localObject = null;
        break;
      }
      label611:
      ac.printErrStackTrace("MicroMsg.AppBrand.ExportWxaInstrumentation", (Throwable)paramContext, "", new Object[0]);
      AppMethodBeat.o(47378);
      return;
      label634:
      i = 1;
      break;
      label639:
      i = 1;
      break label68;
      label644:
      i = 1;
      continue;
      label649:
      i = 0;
    }
  }
  
  public final void a(Context paramContext, String paramString1, int paramInt, String paramString2, AppBrandStatObject paramAppBrandStatObject, String paramString3, String paramString4)
  {
    AppMethodBeat.i(47382);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.jDQ = 7;
    localAppBrandLaunchReferrer.appId = paramString3;
    localAppBrandLaunchReferrer.jDT = paramString4;
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
      localAppBrandLaunchReferrer.jDQ = 4;
      continue;
      localAppBrandLaunchReferrer.jDQ = 2;
      continue;
      localAppBrandLaunchReferrer.jDQ = 5;
    }
  }
  
  public final void a(Context paramContext, final String paramString1, final String paramString2, String paramString3, final int paramInt, final n.a parama)
  {
    AppMethodBeat.i(47384);
    ac.i("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk isMain[%b]", new Object[] { Boolean.valueOf(ap.isMainThread()) });
    parama = new n.a()
    {
      private boolean loB = false;
      
      public final void bnS()
      {
        AppMethodBeat.i(47371);
        if (this.loB)
        {
          AppMethodBeat.o(47371);
          return;
        }
        this.loB = true;
        if (parama != null) {
          parama.bnS();
        }
        AppMethodBeat.o(47371);
      }
      
      public final void bnT()
      {
        AppMethodBeat.i(47372);
        if (this.loB)
        {
          AppMethodBeat.o(47372);
          return;
        }
        this.loB = true;
        if (parama != null) {
          parama.bnT();
        }
        AppMethodBeat.o(47372);
      }
    };
    this.kqy = false;
    a(paramContext, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(47373);
        ac.w("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, user canceled");
        bk.a(bk.this);
        parama.bnT();
        OpenBusinessViewUtil.z(paramString1, paramString2, -2);
        AppMethodBeat.o(47373);
      }
    });
    OpenBusinessViewUtil.a(1, paramString2, paramString3, paramString1, null, new OpenBusinessViewUtil.a()
    {
      public final void af(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(47375);
        ac.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail, CGI errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        bk.b(bk.this);
        parama.bnT();
        OpenBusinessViewUtil.z(paramString1, paramString2, -3);
        AppMethodBeat.o(47375);
      }
      
      public final void cY(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(47374);
        bk.b(bk.this);
        if (bk.c(bk.this))
        {
          AppMethodBeat.o(47374);
          return;
        }
        if (bs.isNullOrNil(paramAnonymousString1))
        {
          ac.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, invalid businessType");
          parama.bnT();
          OpenBusinessViewUtil.z(paramString1, paramString2, -3);
          AppMethodBeat.o(47374);
          return;
        }
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1069;
        localAppBrandStatObject.cYP = paramString1;
        AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer.appId = paramString1;
        localAppBrandLaunchReferrer.jDQ = 4;
        localAppBrandLaunchReferrer.businessType = paramString2;
        localAppBrandLaunchReferrer.sourceType = 5;
        if (AppBrandLaunchProxyUI.a(ai.getContext(), null, paramAnonymousString1, paramAnonymousString2, paramInt, -1, localAppBrandStatObject, localAppBrandLaunchReferrer, null))
        {
          ac.i("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch success");
          parama.bnS();
          AppMethodBeat.o(47374);
          return;
        }
        ac.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail");
        parama.bnT();
        OpenBusinessViewUtil.z(paramString1, paramString2, -3);
        AppMethodBeat.o(47374);
      }
    });
    AppMethodBeat.o(47384);
  }
  
  public final void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, String paramString4, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(47383);
    this.kqy = false;
    a(paramContext, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(47368);
        ac.w("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, user canceled");
        bk.a(bk.this);
        OpenBusinessViewUtil.A(paramString3, null, -3);
        AppMethodBeat.o(47368);
      }
    });
    OpenBusinessViewUtil.a(2, paramString3, paramString4, paramString2, paramString1, new OpenBusinessViewUtil.a()
    {
      public final void af(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(47370);
        ac.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch fail, CGI errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        bk.b(bk.this);
        OpenBusinessViewUtil.A(paramString3, null, -2);
        AppMethodBeat.o(47370);
      }
      
      public final void cY(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(47369);
        bk.b(bk.this);
        if (bk.c(bk.this))
        {
          AppMethodBeat.o(47369);
          return;
        }
        if (bs.isNullOrNil(paramAnonymousString1))
        {
          ac.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, invalid businessType");
          OpenBusinessViewUtil.A(paramString3, null, -4);
          AppMethodBeat.o(47369);
          return;
        }
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1055;
        localAppBrandStatObject.cYP = (com.tencent.mm.compatible.util.p.encode(bs.nullAsNil(paramString1)) + ":" + paramString2 + ":" + paramInt2);
        AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer.appId = paramString2;
        localAppBrandLaunchReferrer.jDQ = 2;
        localAppBrandLaunchReferrer.url = paramString1;
        localAppBrandLaunchReferrer.businessType = paramString3;
        localAppBrandLaunchReferrer.sourceType = 5;
        if (AppBrandLaunchProxyUI.a(paramContext, null, paramAnonymousString1, paramAnonymousString2, paramInt1, -1, localAppBrandStatObject, localAppBrandLaunchReferrer, null))
        {
          ac.i("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch success");
          AppMethodBeat.o(47369);
          return;
        }
        ac.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch fail");
        OpenBusinessViewUtil.A(paramString3, null, -1);
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
        break label285;
      }
      ac.d("MicroMsg.WeAppLauncher", "launchByOpenSdkAppMessage kf guide msg");
      localAppBrandStatObject.scene = 1157;
      localAppBrandStatObject.cYP = paramString1;
      label58:
      localAppBrandStatObject.cYP = (bs.nullAsNil(paramb.appId) + ":" + bs.nullAsNil(com.tencent.mm.compatible.util.p.encode(paramb.url)));
      if (!paramBoolean) {
        break label342;
      }
      i = 2;
      label112:
      localAppBrandStatObject.dxE = i;
      paramBundle = paramString2;
      if (paramBoolean) {
        paramBundle = String.format("%s:%s", new Object[] { paramString1, paramString2 });
      }
      localAppBrandStatObject.dxF = paramBundle;
      paramString2 = new LaunchParamsOptional();
      if (bs.isNullOrNil(paramb.hkk)) {
        break label348;
      }
      paramString2.ccc = paramString1;
      paramString2.ccd = paramb.hkk;
    }
    label285:
    label342:
    label348:
    for (localAppBrandStatObject.cYP += ":1";; localAppBrandStatObject.cYP += ":0")
    {
      paramString1 = new AppBrandLaunchReferrer();
      paramString1.jDQ = 4;
      paramString1.appId = paramb.appId;
      AppBrandLaunchProxyUI.a(paramContext, paramb.hke, paramb.hkf, paramb.hkd, paramb.hkq, paramb.hkr, localAppBrandStatObject, paramString1, paramString2);
      AppMethodBeat.o(175004);
      return;
      i = 0;
      break;
      localAppBrandStatObject.scene = 1036;
      localAppBrandStatObject.cYP = (bs.nullAsNil(paramb.appId) + ":" + bs.nullAsNil(com.tencent.mm.compatible.util.p.encode(paramb.url)));
      break label58;
      i = 1;
      break label112;
    }
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(47376);
    if (bs.isNullOrNil(paramString3))
    {
      AppMethodBeat.o(47376);
      return;
    }
    if ((bs.isNullOrNil(paramString3)) || (bs.isNullOrNil(paramString2)))
    {
      ac.e("MicroMsg.WeAppLauncher", "targetAppId %s referrerAppId %s, Null Or Nil");
      AppMethodBeat.o(47376);
      return;
    }
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1055;
    localAppBrandStatObject.cYP = (com.tencent.mm.compatible.util.p.encode(bs.nullAsNil(paramString1)) + ":" + paramString2 + ":" + paramInt2);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.appId = paramString2;
    localAppBrandLaunchReferrer.jDQ = 2;
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
    label115:
    String str;
    if (paramBundle.getBoolean("stat_weishi_from_opensdk", false))
    {
      i = 1;
      if (i == 0) {
        break label488;
      }
      localAppBrandStatObject.scene = 1036;
      localAppBrandStatObject.cYP = (bs.nullAsNil(paramb.appId) + ":" + bs.nullAsNil(com.tencent.mm.compatible.util.p.encode(paramb.url)));
      if (!paramBoolean) {
        break label450;
      }
      j = 2;
      localAppBrandStatObject.dxE = j;
      str = paramString2;
      if (paramBoolean) {
        str = String.format("%s:%s", new Object[] { paramString1, paramString2 });
      }
      localAppBrandStatObject.dxF = str;
      ac.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, from opensdk appmsg, scene:%s", new Object[] { Integer.valueOf(localAppBrandStatObject.scene) });
      if (bs.isNullOrNil(paramb.hkk)) {
        break label456;
      }
      localAppBrandStatObject.cYP += ":1";
      label221:
      localAppBrandLaunchReferrer.appId = paramb.appId;
      localAppBrandLaunchReferrer.jDQ = 4;
      if (!bs.isNullOrNil(paramb.hkk))
      {
        localLaunchParamsOptional.ccc = paramString1;
        localLaunchParamsOptional.ccd = paramb.hkk;
      }
      if ("wxfe02ecfe70800f46".equalsIgnoreCase(paramb.hkf))
      {
        paramString1 = new AppBrandWeishiParams();
        if (i == 0) {
          break label663;
        }
      }
    }
    label663:
    for (int i = 1;; i = 0)
    {
      paramString1.hgh = i;
      paramString1.thumbUrl = paramBundle.getString("stat_weishi_thumb_url", null);
      paramString1.jEo = paramBundle.getString("stat_weishi_thumb_path", null);
      paramString1.jEp = paramBundle.getString("stat_weishi_msg_img_path", null);
      paramString1.appId = paramBundle.getString("stat_weishi_app_id", null);
      paramString1.appName = paramBundle.getString("stat_weishi_app_name", null);
      paramString1.jEq = paramBundle.getString("stat_weishi_source_username", null);
      localLaunchParamsOptional.ccf = paramString1;
      ac.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, weishi params:%s", new Object[] { paramString1 });
      AppBrandLaunchProxyUI.a(paramContext, paramb.hke, paramb.hkf, paramb.hkd, paramb.hkq, paramb.hkr, localAppBrandStatObject, localAppBrandLaunchReferrer, localLaunchParamsOptional);
      AppMethodBeat.o(47381);
      return;
      i = 0;
      break;
      label450:
      j = 1;
      break label115;
      label456:
      localAppBrandStatObject.cYP += ":0";
      break label221;
      label488:
      str = paramb.hkj;
      if (paramBoolean) {
        localAppBrandStatObject.scene = 1008;
      }
      for (localAppBrandStatObject.cYP = (paramString1 + ":" + paramString2 + ":" + str);; localAppBrandStatObject.cYP = (paramString2 + ":" + str))
      {
        localAppBrandStatObject.dxE = com.tencent.mm.plugin.appbrand.report.k.l(localAppBrandStatObject.scene, paramBundle);
        localAppBrandStatObject.dxF = com.tencent.mm.plugin.appbrand.report.k.m(localAppBrandStatObject.scene, paramBundle);
        ac.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, from chatting appmsg, scene:%s", new Object[] { Integer.valueOf(localAppBrandStatObject.scene) });
        localAppBrandLaunchReferrer.appId = paramb.appId;
        localAppBrandLaunchReferrer.jDQ = 6;
        break;
        localAppBrandStatObject.scene = 1007;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bk
 * JD-Core Version:    0.7.0.1
 */