package com.tencent.mm.plugin.appbrand.report.model;

import android.content.ComponentName;
import android.content.Intent;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.g;
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
      if ((j.a.oN(paramo.aXc().dPf)) && (!TextUtils.isEmpty(paramo.aXc().jXz))) {
        paramJSONObject.put("debugLaunchInfo", new JSONObject(paramo.aXc().jXz));
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
      paramJSONObject.put("referpagepath", d(paramo.aXc().cmv));
      paramJSONObject.put("clickTimestamp", paramo.aXc().startTime);
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
    paramJSONObject.put("scene", paramo.Fb().cmC.scene);
    paramJSONObject.put("scene_note", paramo.Fb().cmC.dkh);
    paramJSONObject.put("sessionId", paramo.aXc().Ec());
    paramJSONObject.put("usedState", paramo.Fb().cmC.mrx);
    paramJSONObject.put("prescene", paramo.Fb().cmC.dJQ);
    paramJSONObject.put("prescene_note", paramo.Fb().cmC.dJR);
    Object localObject = paramo.aXc().jCX;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject.put("chatroomUsername", localObject);
    }
    if (!TextUtils.isEmpty(paramo.aXc().jXy)) {}
    try
    {
      paramJSONObject.put("nativeExtraData", new JSONObject(paramo.aXc().jXy));
      localObject = paramo.aXc().jXx;
      if ((localObject == null) || (((PersistableBundle)localObject).size() <= 0)) {}
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        paramJSONObject.put("transitExtraData", com.tencent.luggage.h.d.a(paramo.aXc().jXx));
        if (j.a.oN(paramo.aXc().dPf))
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
          i = paramo.aXc().aDD;
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
      if ((1 == paramAppBrandLaunchReferrer.jXR) || (3 == paramAppBrandLaunchReferrer.jXR)) {
        return paramAppBrandLaunchReferrer.appId;
      }
    } while (2 != paramAppBrandLaunchReferrer.jXR);
    return paramAppBrandLaunchReferrer.url;
  }
  
  public static Pair<Integer, String> s(ae paramae)
  {
    int i = 7;
    AppMethodBeat.i(48112);
    Intent localIntent;
    switch (1.jLK[com.tencent.mm.plugin.appbrand.g.Kv(paramae.getAppId()).ordinal()])
    {
    default: 
      localIntent = t(paramae).bsl();
      if (localIntent != null) {
        if (localIntent.getComponent() == null)
        {
          paramae = "";
          ad.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
          if ((!paramae.contains("WebViewUI")) && (!paramae.contains("WebviewMpUI"))) {
            break label249;
          }
          i = 10;
          paramae = y.getStringExtra(localIntent, AppBrandProcessProxyUI.kpe);
        }
      }
      break;
    }
    for (;;)
    {
      paramae = Pair.create(Integer.valueOf(i), paramae);
      AppMethodBeat.o(48112);
      return paramae;
      if (paramae.mcx.isLoading()) {}
      for (i = 4;; i = 3)
      {
        paramae = null;
        break;
      }
      if (paramae.mcx.isLoading()) {
        i = 5;
      }
      paramae = null;
      continue;
      i = 6;
      paramae = null;
      continue;
      i = 9;
      paramae = n.KE(paramae.getAppId()).jyX + ":" + q.encode(bt.nullAsNil(n.KE(paramae.getAppId()).jyY));
      continue;
      paramae = localIntent.getComponent().getClassName();
      break;
      label249:
      paramae = bt.bI(y.getStringExtra(localIntent, AppBrandProcessProxyUI.kpf), paramae);
      i = 8;
      continue;
      paramae = null;
    }
  }
  
  private static f t(ae paramae)
  {
    AppMethodBeat.i(48113);
    paramae = paramae.getRuntime().aXd().getReporter();
    AppMethodBeat.o(48113);
    return paramae;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.d
 * JD-Core Version:    0.7.0.1
 */