package com.tencent.mm.plugin.appbrand.report.model;

import android.content.ComponentName;
import android.content.Intent;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  public static void a(o paramo, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48109);
    try
    {
      if ((j.a.nz(paramo.aNc().iOP)) && (!TextUtils.isEmpty(paramo.aNc().jdq))) {
        paramJSONObject.put("debugLaunchInfo", new JSONObject(paramo.aNc().jdq));
      }
      AppMethodBeat.o(48109);
      return;
    }
    catch (JSONException paramo)
    {
      ad.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillDebugLaunchInfo ex = %s", new Object[] { paramo });
      AppMethodBeat.o(48109);
    }
  }
  
  public static void b(o paramo, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48110);
    try
    {
      c(paramo, paramJSONObject);
      paramJSONObject.put("referpagepath", d(paramo.aNc().cfi));
      paramJSONObject.put("clickTimestamp", paramo.aNc().startTime);
      AppMethodBeat.o(48110);
      return;
    }
    catch (Exception paramo)
    {
      ad.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillWxConfigLaunchInfo ex = %s", new Object[] { paramo });
      AppMethodBeat.o(48110);
    }
  }
  
  public static void c(o paramo, JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(48111);
    paramJSONObject.put("scene", paramo.DZ().cfo.scene);
    paramJSONObject.put("scene_note", paramo.DZ().cfo.dbt);
    paramJSONObject.put("sessionId", paramo.aNc().Da());
    paramJSONObject.put("usedState", paramo.DZ().cfo.lpL);
    paramJSONObject.put("prescene", paramo.DZ().cfo.dzS);
    paramJSONObject.put("prescene_note", paramo.DZ().cfo.dzT);
    Object localObject = paramo.aNc().iJl;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject.put("chatroomUsername", localObject);
    }
    if (!TextUtils.isEmpty(paramo.aNc().jdp)) {}
    try
    {
      paramJSONObject.put("nativeExtraData", new JSONObject(paramo.aNc().jdp));
      localObject = paramo.aNc().jdo;
      if ((localObject == null) || (((PersistableBundle)localObject).size() <= 0)) {}
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        paramJSONObject.put("transitExtraData", com.tencent.luggage.h.d.a(paramo.aNc().jdo));
        if (j.a.nz(paramo.aNc().iOP))
        {
          paramJSONObject.put("appversion", i);
          AppMethodBeat.o(48111);
          return;
          localJSONException1 = localJSONException1;
          ad.printErrStackTrace("MicroMsg.AppBrandPageVisitStatisticsHelper", localJSONException1, "", new Object[0]);
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AppBrandPageVisitStatisticsHelper", localJSONException2, "", new Object[0]);
          continue;
          i = paramo.aNc().aAS;
        }
      }
    }
  }
  
  public static String d(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    String str;
    if (paramAppBrandLaunchReferrer == null) {
      str = null;
    }
    do
    {
      return str;
      str = "";
      if ((1 == paramAppBrandLaunchReferrer.jdC) || (3 == paramAppBrandLaunchReferrer.jdC)) {
        return paramAppBrandLaunchReferrer.appId;
      }
    } while (2 != paramAppBrandLaunchReferrer.jdC);
    return paramAppBrandLaunchReferrer.url;
  }
  
  public static Pair<Integer, String> r(ae paramae)
  {
    int i = 7;
    AppMethodBeat.i(48112);
    Intent localIntent;
    switch (d.1.iRF[com.tencent.mm.plugin.appbrand.g.Dd(paramae.getAppId()).ordinal()])
    {
    default: 
      localIntent = s(paramae).bhz();
      if (localIntent != null) {
        if (localIntent.getComponent() == null)
        {
          paramae = "";
          ad.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
          if ((!paramae.contains("WebViewUI")) && (!paramae.contains("WebviewMpUI"))) {
            break label249;
          }
          i = 10;
          paramae = y.getStringExtra(localIntent, AppBrandProcessProxyUI.juv);
        }
      }
      break;
    }
    for (;;)
    {
      paramae = Pair.create(Integer.valueOf(i), paramae);
      AppMethodBeat.o(48112);
      return paramae;
      if (paramae.lbw.isLoading()) {}
      for (i = 4;; i = 3)
      {
        paramae = null;
        break;
      }
      if (paramae.lbw.isLoading()) {
        i = 5;
      }
      paramae = null;
      continue;
      i = 6;
      paramae = null;
      continue;
      i = 9;
      paramae = n.Do(paramae.getAppId()).iFP + ":" + p.encode(bt.nullAsNil(n.Do(paramae.getAppId()).iFQ));
      continue;
      paramae = localIntent.getComponent().getClassName();
      break;
      label249:
      paramae = bt.by(y.getStringExtra(localIntent, AppBrandProcessProxyUI.juw), paramae);
      i = 8;
      continue;
      paramae = null;
    }
  }
  
  private static f s(ae paramae)
  {
    AppMethodBeat.i(48113);
    paramae = paramae.getRuntime().aNd().getReporter();
    AppMethodBeat.o(48113);
    return paramae;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.d
 * JD-Core Version:    0.7.0.1
 */