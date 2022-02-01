package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.l;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.o.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.base.h;
import d.n.n;
import junit.framework.Assert;

public final class bn
  implements o
{
  private com.tencent.mm.ui.base.p fNb;
  private boolean kLU = false;
  
  private void a(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(47385);
    aOs();
    paramContext.getString(2131755906);
    this.fNb = h.b(paramContext, paramContext.getString(2131755936), true, paramOnCancelListener);
    AppMethodBeat.o(47385);
  }
  
  private void aOs()
  {
    AppMethodBeat.i(47386);
    if (this.fNb != null)
    {
      this.fNb.dismiss();
      this.fNb = null;
    }
    AppMethodBeat.o(47386);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.appbrand.api.f paramf)
  {
    AppMethodBeat.i(47378);
    Object localObject = v.lHs;
    int i;
    try
    {
      localObject = (CharSequence)paramf.username;
      if (localObject == null) {
        break label637;
      }
      if (((CharSequence)localObject).length() != 0) {
        break label121;
      }
    }
    catch (Exception paramContext)
    {
      label68:
      if (!i.IS_FLAVOR_RED) {
        break label614;
      }
    }
    if (i != 0)
    {
      localObject = (CharSequence)paramf.appId;
      if (localObject != null)
      {
        if (((CharSequence)localObject).length() == 0) {
          break label642;
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
        break label647;
      }
      if (((CharSequence)localObject).length() != 0) {
        break label652;
      }
      break label647;
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject = paramf.username;
        d.g.b.p.g(localObject, "username");
        if (!n.nA((String)localObject, "@app"))
        {
          paramContext = (Throwable)new IllegalArgumentException("Invalid weapp username " + paramf.username);
          AppMethodBeat.o(47378);
          throw paramContext;
        }
      }
      if ((!j.a.rQ(paramf.hQh)) && (!j.a.oN(paramf.hQh)))
      {
        paramContext = (Throwable)new IllegalArgumentException("Invalid weapp versionType " + paramf.hQh);
        AppMethodBeat.o(47378);
        throw paramContext;
      }
      if (paramf.scene <= 1000)
      {
        paramContext = (Throwable)new IllegalArgumentException("Invalid weapp enter scene " + paramf.scene);
        AppMethodBeat.o(47378);
        throw paramContext;
      }
      com.tencent.mm.plugin.appbrand.launching.e.f localf = com.tencent.mm.plugin.appbrand.launching.e.f.lNC;
      LaunchParcel localLaunchParcel = new LaunchParcel();
      localLaunchParcel.username = paramf.username;
      localLaunchParcel.appId = paramf.appId;
      localLaunchParcel.version = paramf.version;
      localLaunchParcel.hQh = paramf.hQh;
      localLaunchParcel.jCN = paramf.jCN;
      localObject = paramf.jCO;
      if (localObject != null)
      {
        localObject = ((d)localObject).aYt();
        localLaunchParcel.jXy = ((String)localObject);
        localLaunchParcel.jXx = paramf.jCP;
        localObject = new AppBrandStatObject();
        ((AppBrandStatObject)localObject).scene = paramf.scene;
        ((AppBrandStatObject)localObject).dkh = paramf.dkh;
        ((AppBrandStatObject)localObject).dJQ = paramf.jCQ;
        ((AppBrandStatObject)localObject).dJR = paramf.jCR;
        localLaunchParcel.lMZ = ((AppBrandStatObject)localObject);
        localLaunchParcel.cmv = paramf.jCW;
        if (paramf.jCS == null) {
          break label608;
        }
      }
      label608:
      for (localObject = (a)new v.a(paramf);; localObject = null)
      {
        localLaunchParcel.lNc = ((a)localObject);
        localLaunchParcel.jCT = paramf.jCT;
        localLaunchParcel.jCX = paramf.jCX;
        localLaunchParcel.launchMode = paramf.launchMode;
        localObject = new PersistableBundle();
        ((PersistableBundle)localObject).putString("KEY_OPENSDK_AD_TRACE_KEY", paramf.jCV);
        localLaunchParcel.lNe = ((PersistableBundle)localObject);
        localLaunchParcel.jCZ = paramf.jCZ;
        localLaunchParcel.lNf = ((Parcelable)paramf.jDa);
        localf.a(paramContext, localLaunchParcel);
        AppMethodBeat.o(47378);
        return;
        localObject = null;
        break;
      }
      label614:
      ad.printErrStackTrace("MicroMsg.AppBrand.ExportWxaInstrumentation", (Throwable)paramContext, "", new Object[0]);
      AppMethodBeat.o(47378);
      return;
      label637:
      i = 1;
      break;
      label642:
      i = 1;
      break label68;
      label647:
      i = 1;
      continue;
      label652:
      i = 0;
    }
  }
  
  public final void a(Context paramContext, String paramString1, int paramInt, String paramString2, AppBrandStatObject paramAppBrandStatObject, String paramString3, String paramString4)
  {
    AppMethodBeat.i(47382);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.jXR = 7;
    localAppBrandLaunchReferrer.appId = paramString3;
    localAppBrandLaunchReferrer.jXU = paramString4;
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
      localAppBrandLaunchReferrer.jXR = 4;
      continue;
      localAppBrandLaunchReferrer.jXR = 2;
      continue;
      localAppBrandLaunchReferrer.jXR = 5;
    }
  }
  
  public final void a(Context paramContext, final String paramString1, final String paramString2, String paramString3, final int paramInt, final o.a parama)
  {
    AppMethodBeat.i(47384);
    ad.i("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk isMain[%b]", new Object[] { Boolean.valueOf(aq.isMainThread()) });
    parama = new o.a()
    {
      private boolean lLT = false;
      
      public final void brK()
      {
        AppMethodBeat.i(47371);
        if (this.lLT)
        {
          AppMethodBeat.o(47371);
          return;
        }
        this.lLT = true;
        if (parama != null) {
          parama.brK();
        }
        AppMethodBeat.o(47371);
      }
      
      public final void brL()
      {
        AppMethodBeat.i(47372);
        if (this.lLT)
        {
          AppMethodBeat.o(47372);
          return;
        }
        this.lLT = true;
        if (parama != null) {
          parama.brL();
        }
        AppMethodBeat.o(47372);
      }
    };
    this.kLU = false;
    a(paramContext, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(47373);
        ad.w("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, user canceled");
        bn.a(bn.this);
        parama.brL();
        OpenBusinessViewUtil.A(paramString1, paramString2, -2);
        AppMethodBeat.o(47373);
      }
    });
    OpenBusinessViewUtil.a(1, paramString2, paramString3, paramString1, null, new OpenBusinessViewUtil.a()
    {
      public final void ah(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(47375);
        ad.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail, CGI errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        bn.b(bn.this);
        parama.brL();
        OpenBusinessViewUtil.A(paramString1, paramString2, -3);
        AppMethodBeat.o(47375);
      }
      
      public final void da(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(47374);
        bn.b(bn.this);
        if (bn.c(bn.this))
        {
          AppMethodBeat.o(47374);
          return;
        }
        if (bt.isNullOrNil(paramAnonymousString1))
        {
          ad.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, invalid businessType");
          parama.brL();
          OpenBusinessViewUtil.A(paramString1, paramString2, -3);
          AppMethodBeat.o(47374);
          return;
        }
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1069;
        localAppBrandStatObject.dkh = paramString1;
        AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer.appId = paramString1;
        localAppBrandLaunchReferrer.jXR = 4;
        localAppBrandLaunchReferrer.businessType = paramString2;
        localAppBrandLaunchReferrer.sourceType = 5;
        if (AppBrandLaunchProxyUI.a(aj.getContext(), null, paramAnonymousString1, paramAnonymousString2, paramInt, -1, localAppBrandStatObject, localAppBrandLaunchReferrer, null))
        {
          ad.i("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch success");
          parama.brK();
          AppMethodBeat.o(47374);
          return;
        }
        ad.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail");
        parama.brL();
        OpenBusinessViewUtil.A(paramString1, paramString2, -3);
        AppMethodBeat.o(47374);
      }
    });
    AppMethodBeat.o(47384);
  }
  
  public final void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, String paramString4, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(47383);
    this.kLU = false;
    a(paramContext, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(47368);
        ad.w("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, user canceled");
        bn.a(bn.this);
        OpenBusinessViewUtil.B(paramString3, null, -3);
        AppMethodBeat.o(47368);
      }
    });
    OpenBusinessViewUtil.a(2, paramString3, paramString4, paramString2, paramString1, new OpenBusinessViewUtil.a()
    {
      public final void ah(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(47370);
        ad.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch fail, CGI errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        bn.b(bn.this);
        OpenBusinessViewUtil.B(paramString3, null, -2);
        AppMethodBeat.o(47370);
      }
      
      public final void da(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(47369);
        bn.b(bn.this);
        if (bn.c(bn.this))
        {
          AppMethodBeat.o(47369);
          return;
        }
        if (bt.isNullOrNil(paramAnonymousString1))
        {
          ad.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, invalid businessType");
          OpenBusinessViewUtil.B(paramString3, null, -4);
          AppMethodBeat.o(47369);
          return;
        }
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1055;
        localAppBrandStatObject.dkh = (q.encode(bt.nullAsNil(paramString1)) + ":" + paramString2 + ":" + paramInt2);
        AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer.appId = paramString2;
        localAppBrandLaunchReferrer.jXR = 2;
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
        break label285;
      }
      ad.d("MicroMsg.WeAppLauncher", "launchByOpenSdkAppMessage kf guide msg");
      localAppBrandStatObject.scene = 1157;
      localAppBrandStatObject.dkh = paramString1;
      label58:
      localAppBrandStatObject.dkh = (bt.nullAsNil(paramb.appId) + ":" + bt.nullAsNil(q.encode(paramb.url)));
      if (!paramBoolean) {
        break label342;
      }
      i = 2;
      label112:
      localAppBrandStatObject.dJQ = i;
      paramBundle = paramString2;
      if (paramBoolean) {
        paramBundle = String.format("%s:%s", new Object[] { paramString1, paramString2 });
      }
      localAppBrandStatObject.dJR = paramBundle;
      paramString2 = new LaunchParamsOptional();
      if (bt.isNullOrNil(paramb.hCt)) {
        break label348;
      }
      paramString2.cmt = paramString1;
      paramString2.cmu = paramb.hCt;
    }
    label285:
    label342:
    label348:
    for (localAppBrandStatObject.dkh += ":1";; localAppBrandStatObject.dkh += ":0")
    {
      paramString1 = new AppBrandLaunchReferrer();
      paramString1.jXR = 4;
      paramString1.appId = paramb.appId;
      AppBrandLaunchProxyUI.a(paramContext, paramb.hCn, paramb.hCo, paramb.hCm, paramb.hCz, paramb.hCA, localAppBrandStatObject, paramString1, paramString2);
      AppMethodBeat.o(175004);
      return;
      i = 0;
      break;
      localAppBrandStatObject.scene = 1036;
      localAppBrandStatObject.dkh = (bt.nullAsNil(paramb.appId) + ":" + bt.nullAsNil(q.encode(paramb.url)));
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
    localAppBrandStatObject.dkh = (q.encode(bt.nullAsNil(paramString1)) + ":" + paramString2 + ":" + paramInt2);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.appId = paramString2;
    localAppBrandLaunchReferrer.jXR = 2;
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
      localAppBrandStatObject.dkh = (bt.nullAsNil(paramb.appId) + ":" + bt.nullAsNil(q.encode(paramb.url)));
      if (!paramBoolean) {
        break label450;
      }
      j = 2;
      localAppBrandStatObject.dJQ = j;
      str = paramString2;
      if (paramBoolean) {
        str = String.format("%s:%s", new Object[] { paramString1, paramString2 });
      }
      localAppBrandStatObject.dJR = str;
      ad.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, from opensdk appmsg, scene:%s", new Object[] { Integer.valueOf(localAppBrandStatObject.scene) });
      if (bt.isNullOrNil(paramb.hCt)) {
        break label456;
      }
      localAppBrandStatObject.dkh += ":1";
      label221:
      localAppBrandLaunchReferrer.appId = paramb.appId;
      localAppBrandLaunchReferrer.jXR = 4;
      if (!bt.isNullOrNil(paramb.hCt))
      {
        localLaunchParamsOptional.cmt = paramString1;
        localLaunchParamsOptional.cmu = paramb.hCt;
      }
      if ("wxfe02ecfe70800f46".equalsIgnoreCase(paramb.hCo))
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
      paramString1.hyq = i;
      paramString1.thumbUrl = paramBundle.getString("stat_weishi_thumb_url", null);
      paramString1.jYq = paramBundle.getString("stat_weishi_thumb_path", null);
      paramString1.jYr = paramBundle.getString("stat_weishi_msg_img_path", null);
      paramString1.appId = paramBundle.getString("stat_weishi_app_id", null);
      paramString1.appName = paramBundle.getString("stat_weishi_app_name", null);
      paramString1.jYs = paramBundle.getString("stat_weishi_source_username", null);
      localLaunchParamsOptional.cmw = paramString1;
      ad.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, weishi params:%s", new Object[] { paramString1 });
      AppBrandLaunchProxyUI.a(paramContext, paramb.hCn, paramb.hCo, paramb.hCm, paramb.hCz, paramb.hCA, localAppBrandStatObject, localAppBrandLaunchReferrer, localLaunchParamsOptional);
      AppMethodBeat.o(47381);
      return;
      i = 0;
      break;
      label450:
      j = 1;
      break label115;
      label456:
      localAppBrandStatObject.dkh += ":0";
      break label221;
      label488:
      str = paramb.hCs;
      if (paramBoolean) {
        localAppBrandStatObject.scene = 1008;
      }
      for (localAppBrandStatObject.dkh = (paramString1 + ":" + paramString2 + ":" + str);; localAppBrandStatObject.dkh = (paramString2 + ":" + str))
      {
        localAppBrandStatObject.dJQ = l.l(localAppBrandStatObject.scene, paramBundle);
        localAppBrandStatObject.dJR = l.m(localAppBrandStatObject.scene, paramBundle);
        ad.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, from chatting appmsg, scene:%s", new Object[] { Integer.valueOf(localAppBrandStatObject.scene) });
        localAppBrandLaunchReferrer.appId = paramb.appId;
        localAppBrandLaunchReferrer.jXR = 6;
        break;
        localAppBrandStatObject.scene = 1007;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bn
 * JD-Core Version:    0.7.0.1
 */