package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.l;
import com.tencent.mm.plugin.appbrand.service.n.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import junit.framework.Assert;

public final class bk
  implements com.tencent.mm.plugin.appbrand.service.n
{
  private com.tencent.mm.ui.base.p fqw;
  private boolean jPM = false;
  
  private void a(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(47385);
    aEr();
    paramContext.getString(2131755906);
    this.fqw = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131755936), true, paramOnCancelListener);
    AppMethodBeat.o(47385);
  }
  
  private void aEr()
  {
    AppMethodBeat.i(47386);
    if (this.fqw != null)
    {
      this.fqw.dismiss();
      this.fqw = null;
    }
    AppMethodBeat.o(47386);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.appbrand.a.f paramf)
  {
    AppMethodBeat.i(47378);
    Object localObject = v.kIO;
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
        k.g(localObject, "username");
        if (!d.n.n.mB((String)localObject, "@app"))
        {
          paramContext = (Throwable)new IllegalArgumentException("Invalid weapp username " + paramf.username);
          AppMethodBeat.o(47378);
          throw paramContext;
        }
      }
      if ((!j.a.qD(paramf.gXn)) && (!j.a.nz(paramf.gXn)))
      {
        paramContext = (Throwable)new IllegalArgumentException("Invalid weapp versionType " + paramf.gXn);
        AppMethodBeat.o(47378);
        throw paramContext;
      }
      if (paramf.scene <= 1000)
      {
        paramContext = (Throwable)new IllegalArgumentException("Invalid weapp enter scene " + paramf.scene);
        AppMethodBeat.o(47378);
        throw paramContext;
      }
      com.tencent.mm.plugin.appbrand.launching.e.f localf = com.tencent.mm.plugin.appbrand.launching.e.f.kOI;
      LaunchParcel localLaunchParcel = new LaunchParcel();
      localLaunchParcel.username = paramf.username;
      localLaunchParcel.appId = paramf.appId;
      localLaunchParcel.version = paramf.version;
      localLaunchParcel.gXn = paramf.gXn;
      localLaunchParcel.iJb = paramf.iJb;
      localObject = paramf.iJc;
      if (localObject != null)
      {
        localObject = ((d)localObject).aOj();
        localLaunchParcel.jdp = ((String)localObject);
        localLaunchParcel.jdo = paramf.iJd;
        localObject = new AppBrandStatObject();
        ((AppBrandStatObject)localObject).scene = paramf.scene;
        ((AppBrandStatObject)localObject).dbt = paramf.dbt;
        ((AppBrandStatObject)localObject).dzS = paramf.iJe;
        ((AppBrandStatObject)localObject).dzT = paramf.iJf;
        localLaunchParcel.kOh = ((AppBrandStatObject)localObject);
        localLaunchParcel.cfi = paramf.iJk;
        if (paramf.iJg == null) {
          break label605;
        }
      }
      label605:
      for (localObject = (a)new v.a(paramf);; localObject = null)
      {
        localLaunchParcel.kOk = ((a)localObject);
        localLaunchParcel.iJh = paramf.iJh;
        localLaunchParcel.iJl = paramf.iJl;
        localLaunchParcel.launchMode = paramf.launchMode;
        localLaunchParcel.iJm = paramf.iJm;
        localObject = new PersistableBundle();
        ((PersistableBundle)localObject).putString("KEY_OPENSDK_AD_TRACE_KEY", paramf.iJj);
        localLaunchParcel.kOm = ((PersistableBundle)localObject);
        localLaunchParcel.iJn = paramf.iJn;
        localf.a(paramContext, localLaunchParcel);
        AppMethodBeat.o(47378);
        return;
        localObject = null;
        break;
      }
      label611:
      ad.printErrStackTrace("MicroMsg.AppBrand.ExportWxaInstrumentation", (Throwable)paramContext, "", new Object[0]);
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
    localAppBrandLaunchReferrer.jdC = 7;
    localAppBrandLaunchReferrer.appId = paramString3;
    localAppBrandLaunchReferrer.jdF = paramString4;
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
      localAppBrandLaunchReferrer.jdC = 4;
      continue;
      localAppBrandLaunchReferrer.jdC = 2;
      continue;
      localAppBrandLaunchReferrer.jdC = 5;
    }
  }
  
  public final void a(Context paramContext, final String paramString1, final String paramString2, String paramString3, final int paramInt, final n.a parama)
  {
    AppMethodBeat.i(47384);
    ad.i("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk isMain[%b]", new Object[] { Boolean.valueOf(aq.isMainThread()) });
    parama = new n.a()
    {
      private boolean kNc = false;
      
      public final void bgY()
      {
        AppMethodBeat.i(47371);
        if (this.kNc)
        {
          AppMethodBeat.o(47371);
          return;
        }
        this.kNc = true;
        if (parama != null) {
          parama.bgY();
        }
        AppMethodBeat.o(47371);
      }
      
      public final void bgZ()
      {
        AppMethodBeat.i(47372);
        if (this.kNc)
        {
          AppMethodBeat.o(47372);
          return;
        }
        this.kNc = true;
        if (parama != null) {
          parama.bgZ();
        }
        AppMethodBeat.o(47372);
      }
    };
    this.jPM = false;
    a(paramContext, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(47373);
        ad.w("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, user canceled");
        bk.a(bk.this);
        parama.bgZ();
        OpenBusinessViewUtil.y(paramString1, paramString2, -2);
        AppMethodBeat.o(47373);
      }
    });
    OpenBusinessViewUtil.a(1, paramString2, paramString3, paramString1, null, new OpenBusinessViewUtil.a()
    {
      public final void ae(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(47375);
        ad.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail, CGI errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        bk.b(bk.this);
        parama.bgZ();
        OpenBusinessViewUtil.y(paramString1, paramString2, -3);
        AppMethodBeat.o(47375);
      }
      
      public final void cN(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(47374);
        bk.b(bk.this);
        if (bk.c(bk.this))
        {
          AppMethodBeat.o(47374);
          return;
        }
        if (bt.isNullOrNil(paramAnonymousString1))
        {
          ad.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, invalid businessType");
          parama.bgZ();
          OpenBusinessViewUtil.y(paramString1, paramString2, -3);
          AppMethodBeat.o(47374);
          return;
        }
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1069;
        localAppBrandStatObject.dbt = paramString1;
        AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer.appId = paramString1;
        localAppBrandLaunchReferrer.jdC = 4;
        localAppBrandLaunchReferrer.businessType = paramString2;
        localAppBrandLaunchReferrer.sourceType = 5;
        if (AppBrandLaunchProxyUI.a(aj.getContext(), null, paramAnonymousString1, paramAnonymousString2, paramInt, -1, localAppBrandStatObject, localAppBrandLaunchReferrer, null))
        {
          ad.i("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch success");
          parama.bgY();
          AppMethodBeat.o(47374);
          return;
        }
        ad.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail");
        parama.bgZ();
        OpenBusinessViewUtil.y(paramString1, paramString2, -3);
        AppMethodBeat.o(47374);
      }
    });
    AppMethodBeat.o(47384);
  }
  
  public final void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, String paramString4, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(47383);
    this.jPM = false;
    a(paramContext, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(47368);
        ad.w("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, user canceled");
        bk.a(bk.this);
        OpenBusinessViewUtil.z(paramString3, null, -3);
        AppMethodBeat.o(47368);
      }
    });
    OpenBusinessViewUtil.a(2, paramString3, paramString4, paramString2, paramString1, new OpenBusinessViewUtil.a()
    {
      public final void ae(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(47370);
        ad.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch fail, CGI errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        bk.b(bk.this);
        OpenBusinessViewUtil.z(paramString3, null, -2);
        AppMethodBeat.o(47370);
      }
      
      public final void cN(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(47369);
        bk.b(bk.this);
        if (bk.c(bk.this))
        {
          AppMethodBeat.o(47369);
          return;
        }
        if (bt.isNullOrNil(paramAnonymousString1))
        {
          ad.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, invalid businessType");
          OpenBusinessViewUtil.z(paramString3, null, -4);
          AppMethodBeat.o(47369);
          return;
        }
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1055;
        localAppBrandStatObject.dbt = (com.tencent.mm.compatible.util.p.encode(bt.nullAsNil(paramString1)) + ":" + paramString2 + ":" + paramInt2);
        AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer.appId = paramString2;
        localAppBrandLaunchReferrer.jdC = 2;
        localAppBrandLaunchReferrer.url = paramString1;
        localAppBrandLaunchReferrer.businessType = paramString3;
        localAppBrandLaunchReferrer.sourceType = 5;
        if (AppBrandLaunchProxyUI.a(paramContext, null, paramAnonymousString1, paramAnonymousString2, paramInt1, -1, localAppBrandStatObject, localAppBrandLaunchReferrer, null))
        {
          ad.i("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch success");
          AppMethodBeat.o(47369);
          return;
        }
        ad.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch fail");
        OpenBusinessViewUtil.z(paramString3, null, -1);
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
      ad.d("MicroMsg.WeAppLauncher", "launchByOpenSdkAppMessage kf guide msg");
      localAppBrandStatObject.scene = 1157;
      localAppBrandStatObject.dbt = paramString1;
      label58:
      localAppBrandStatObject.dbt = (bt.nullAsNil(paramb.appId) + ":" + bt.nullAsNil(com.tencent.mm.compatible.util.p.encode(paramb.url)));
      if (!paramBoolean) {
        break label342;
      }
      i = 2;
      label112:
      localAppBrandStatObject.dzS = i;
      paramBundle = paramString2;
      if (paramBoolean) {
        paramBundle = String.format("%s:%s", new Object[] { paramString1, paramString2 });
      }
      localAppBrandStatObject.dzT = paramBundle;
      paramString2 = new LaunchParamsOptional();
      if (bt.isNullOrNil(paramb.gJK)) {
        break label348;
      }
      paramString2.cff = paramString1;
      paramString2.cfh = paramb.gJK;
    }
    label285:
    label342:
    label348:
    for (localAppBrandStatObject.dbt += ":1";; localAppBrandStatObject.dbt += ":0")
    {
      paramString1 = new AppBrandLaunchReferrer();
      paramString1.jdC = 4;
      paramString1.appId = paramb.appId;
      AppBrandLaunchProxyUI.a(paramContext, paramb.gJE, paramb.gJF, paramb.gJD, paramb.gJQ, paramb.gJR, localAppBrandStatObject, paramString1, paramString2);
      AppMethodBeat.o(175004);
      return;
      i = 0;
      break;
      localAppBrandStatObject.scene = 1036;
      localAppBrandStatObject.dbt = (bt.nullAsNil(paramb.appId) + ":" + bt.nullAsNil(com.tencent.mm.compatible.util.p.encode(paramb.url)));
      break label58;
      i = 1;
      break label112;
    }
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(47376);
    if (bt.isNullOrNil(paramString3))
    {
      AppMethodBeat.o(47376);
      return;
    }
    if ((bt.isNullOrNil(paramString3)) || (bt.isNullOrNil(paramString2)))
    {
      ad.e("MicroMsg.WeAppLauncher", "targetAppId %s referrerAppId %s, Null Or Nil");
      AppMethodBeat.o(47376);
      return;
    }
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1055;
    localAppBrandStatObject.dbt = (com.tencent.mm.compatible.util.p.encode(bt.nullAsNil(paramString1)) + ":" + paramString2 + ":" + paramInt2);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.appId = paramString2;
    localAppBrandLaunchReferrer.jdC = 2;
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
      localAppBrandStatObject.dbt = (bt.nullAsNil(paramb.appId) + ":" + bt.nullAsNil(com.tencent.mm.compatible.util.p.encode(paramb.url)));
      if (!paramBoolean) {
        break label450;
      }
      j = 2;
      localAppBrandStatObject.dzS = j;
      str = paramString2;
      if (paramBoolean) {
        str = String.format("%s:%s", new Object[] { paramString1, paramString2 });
      }
      localAppBrandStatObject.dzT = str;
      ad.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, from opensdk appmsg, scene:%s", new Object[] { Integer.valueOf(localAppBrandStatObject.scene) });
      if (bt.isNullOrNil(paramb.gJK)) {
        break label456;
      }
      localAppBrandStatObject.dbt += ":1";
      label221:
      localAppBrandLaunchReferrer.appId = paramb.appId;
      localAppBrandLaunchReferrer.jdC = 4;
      if (!bt.isNullOrNil(paramb.gJK))
      {
        localLaunchParamsOptional.cff = paramString1;
        localLaunchParamsOptional.cfh = paramb.gJK;
      }
      if ("wxfe02ecfe70800f46".equalsIgnoreCase(paramb.gJF))
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
      paramString1.gFG = i;
      paramString1.thumbUrl = paramBundle.getString("stat_weishi_thumb_url", null);
      paramString1.jea = paramBundle.getString("stat_weishi_thumb_path", null);
      paramString1.jeb = paramBundle.getString("stat_weishi_msg_img_path", null);
      paramString1.appId = paramBundle.getString("stat_weishi_app_id", null);
      paramString1.appName = paramBundle.getString("stat_weishi_app_name", null);
      paramString1.jec = paramBundle.getString("stat_weishi_source_username", null);
      localLaunchParamsOptional.cfj = paramString1;
      ad.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, weishi params:%s", new Object[] { paramString1 });
      AppBrandLaunchProxyUI.a(paramContext, paramb.gJE, paramb.gJF, paramb.gJD, paramb.gJQ, paramb.gJR, localAppBrandStatObject, localAppBrandLaunchReferrer, localLaunchParamsOptional);
      AppMethodBeat.o(47381);
      return;
      i = 0;
      break;
      label450:
      j = 1;
      break label115;
      label456:
      localAppBrandStatObject.dbt += ":0";
      break label221;
      label488:
      str = paramb.gJJ;
      if (paramBoolean) {
        localAppBrandStatObject.scene = 1008;
      }
      for (localAppBrandStatObject.dbt = (paramString1 + ":" + paramString2 + ":" + str);; localAppBrandStatObject.dbt = (paramString2 + ":" + str))
      {
        localAppBrandStatObject.dzS = l.k(localAppBrandStatObject.scene, paramBundle);
        localAppBrandStatObject.dzT = l.l(localAppBrandStatObject.scene, paramBundle);
        ad.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, from chatting appmsg, scene:%s", new Object[] { Integer.valueOf(localAppBrandStatObject.scene) });
        localAppBrandLaunchReferrer.appId = paramb.appId;
        localAppBrandLaunchReferrer.jdC = 6;
        break;
        localAppBrandStatObject.scene = 1007;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bk
 * JD-Core Version:    0.7.0.1
 */