package com.tencent.mm.plugin.appbrand.ad.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.ae.k;
import com.tencent.mm.plugin.appbrand.jsapi.ae.k.c;
import com.tencent.mm.plugin.appbrand.jsapi.ae.p;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.plugin.appbrand.utils.aq;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.HashMap;
import java.util.Random;

public final class f
  extends s
{
  private static final int CTRL_INDEX = 750;
  public static final String NAME = "shouldShowSplashAd";
  public String source = "launch";
  
  private static String UO(String paramString)
  {
    AppMethodBeat.i(321303);
    int i = com.tencent.mm.kernel.b.aZP();
    if (i != 0)
    {
      long l = i;
      paramString = (l & 0xFFFFFFFF) + "_" + paramString;
      AppMethodBeat.o(321303);
      return paramString;
    }
    AppMethodBeat.o(321303);
    return paramString;
  }
  
  public final void a(y paramy, Context paramContext, o paramo)
  {
    AppMethodBeat.i(321315);
    HashMap localHashMap = new HashMap();
    w localw = (w)paramy.getRuntime();
    localHashMap.put("appId", localw.mAppId);
    localHashMap.put("appName", localw.getInitConfig().hEy);
    localHashMap.put("appIcon", localw.getInitConfig().iconUrl);
    if ((localw instanceof w)) {
      localHashMap.put("scene", Integer.valueOf(localw.asA().epn.scene));
    }
    localHashMap.put("source", Util.nullAs(this.source, "launch"));
    boolean bool2 = aw.isDarkMode();
    localHashMap.put("isDarkMode", Boolean.valueOf(bool2));
    boolean bool1 = false;
    if ((localw instanceof w)) {
      bool1 = localw.aqJ();
    }
    localHashMap.put("isGame", Boolean.valueOf(bool1));
    int i = com.tencent.mm.plugin.appbrand.ad.b.ccV();
    localHashMap.put("timeThreshold", Integer.valueOf(i));
    String str = UO(String.format("%s_%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(new Random().nextInt(10000)) }));
    localHashMap.put("instanceId", str);
    localHashMap.put("weixinVersion", ChannelUtil.formatVersion(null, BuildInfo.CLIENT_VERSION_INT));
    localHashMap.put("osType", Integer.valueOf(2));
    localHashMap.put("osVersion", "Android " + Build.VERSION.RELEASE);
    localHashMap.put("model", q.aPo());
    if (paramContext == null) {
      MMApplicationContext.getContext();
    }
    k.c localc = k.cuM();
    localHashMap.put("networkType", localc.value);
    if (paramContext != null)
    {
      DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      paramContext = new int[2];
      paramContext[0] = localDisplayMetrics.widthPixels;
      paramContext[1] = localDisplayMetrics.heightPixels;
    }
    for (;;)
    {
      int k = paramContext[0];
      int j = paramContext[1];
      k = i.DA(k);
      j = i.DA(j);
      localHashMap.put("screenWidth", Integer.valueOf(k));
      localHashMap.put("screenHeight", Integer.valueOf(j));
      localHashMap.put("pixelRatio", Float.valueOf(i.mn()));
      localHashMap.put("rightButtonTop", Integer.valueOf(i.DA(com.tencent.mm.view.d.e(paramy.getContext(), 8.0F) + p.f(paramy))));
      Log.i("MicroMsg.JsApiEventShouldShowSplashAd[AppBrandSplashAd]", "dispatch, instanceId:%s, timeThreshold:%s, screenSize[%s, %s], pixelRatio:%s, isDarkMode:%s, isGame:%s, networkType:%s", new Object[] { str, Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Float.valueOf(i.mn()), Boolean.valueOf(bool2), Boolean.valueOf(bool1), localc });
      u.Uy(localw.mAppId).quV.qzd = Util.nowMilliSecond();
      K(localHashMap).h(paramy).b(paramo);
      AppMethodBeat.o(321315);
      return;
      paramContext = aq.d(paramy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.f
 * JD-Core Version:    0.7.0.1
 */