package com.tencent.mm.plugin.appbrand.ad.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.utils.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import java.util.HashMap;

public final class f
  extends p
{
  private static final int CTRL_INDEX = 750;
  public static final String NAME = "shouldShowSplashAd";
  public String source = "launch";
  
  public final void a(q paramq, Context paramContext)
  {
    AppMethodBeat.i(44050);
    HashMap localHashMap = new HashMap();
    localHashMap.put("appId", paramq.getAppId());
    localHashMap.put("appName", paramq.getRuntime().Eg().dfM);
    localHashMap.put("appIcon", paramq.getRuntime().Eg().iconUrl);
    if ((paramq.getRuntime() instanceof o)) {
      localHashMap.put("scene", Integer.valueOf(((o)paramq.getRuntime()).DZ().cfo.scene));
    }
    localHashMap.put("source", bt.by(this.source, "launch"));
    boolean bool2 = ai.Eq();
    localHashMap.put("isDarkMode", Boolean.valueOf(bool2));
    if ((paramq.getRuntime() instanceof o)) {}
    for (boolean bool1 = ((o)paramq.getRuntime()).CZ();; bool1 = false)
    {
      localHashMap.put("isGame", Boolean.valueOf(bool1));
      Object localObject = a.ME(paramq.getAppId());
      if ((localObject != null) && (!bt.isNullOrNil(((QualitySession)localObject).kGa)))
      {
        localObject = ((QualitySession)localObject).kGa;
        localHashMap.put("instanceId", localObject);
        if (paramContext == null) {
          break label397;
        }
        localObject = paramContext.getResources().getDisplayMetrics();
        paramContext = new int[2];
        paramContext[0] = ((DisplayMetrics)localObject).widthPixels;
        paramContext[1] = ((DisplayMetrics)localObject).heightPixels;
      }
      for (;;)
      {
        int j = paramContext[0];
        int i = paramContext[1];
        j = g.uk(j);
        i = g.uk(i);
        localHashMap.put("screenWidth", Integer.valueOf(j));
        localHashMap.put("screenHeight", Integer.valueOf(i));
        localHashMap.put("pixelRatio", Float.valueOf(g.bqj()));
        ad.i("MicroMsg.JsApiEventShouldShowSplashAd", "dispatch, screenSize[%s, %s], pixelRatio:%s, isDarkMode:%s, isGame:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(g.bqj()), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        n.Dp(paramq.getAppId()).iFK.iIr = bt.eGO();
        B(localHashMap).g(paramq).aXQ();
        AppMethodBeat.o(44050);
        return;
        localObject = "";
        break;
        label397:
        paramContext = ac.g(paramq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.f
 * JD-Core Version:    0.7.0.1
 */