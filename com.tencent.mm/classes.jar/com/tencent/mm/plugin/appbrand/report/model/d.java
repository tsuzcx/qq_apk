package com.tencent.mm.plugin.appbrand.report.model;

import android.content.ComponentName;
import android.content.Intent;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.z;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  public static void a(p paramp, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48109);
    try
    {
      if ((j.a.oQ(paramp.aXx().dQv)) && (!TextUtils.isEmpty(paramp.aXx().kaO))) {
        paramJSONObject.put("debugLaunchInfo", new JSONObject(paramp.aXx().kaO));
      }
      AppMethodBeat.o(48109);
      return;
    }
    catch (JSONException paramp)
    {
      ae.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillDebugLaunchInfo ex = %s", new Object[] { paramp });
      AppMethodBeat.o(48109);
    }
  }
  
  public static void b(p paramp, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48110);
    try
    {
      c(paramp, paramJSONObject);
      paramJSONObject.put("referpagepath", d(paramp.aXx().cmx));
      paramJSONObject.put("clickTimestamp", paramp.aXx().startTime);
      AppMethodBeat.o(48110);
      return;
    }
    catch (Exception paramp)
    {
      ae.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillWxConfigLaunchInfo ex = %s", new Object[] { paramp });
      AppMethodBeat.o(48110);
    }
  }
  
  public static void c(p paramp, JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(48111);
    paramJSONObject.put("scene", paramp.Fg().cmE.scene);
    paramJSONObject.put("scene_note", paramp.Fg().cmE.dlj);
    paramJSONObject.put("sessionId", paramp.aXx().Ef());
    paramJSONObject.put("usedState", paramp.Fg().cmE.mwv);
    paramJSONObject.put("prescene", paramp.Fg().cmE.dLf);
    paramJSONObject.put("prescene_note", paramp.Fg().cmE.dLg);
    Object localObject = paramp.aXx().jFV;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject.put("chatroomUsername", localObject);
    }
    if (!TextUtils.isEmpty(paramp.aXx().kaN)) {}
    try
    {
      paramJSONObject.put("nativeExtraData", new JSONObject(paramp.aXx().kaN));
      localObject = paramp.aXx().kaM;
      if ((localObject == null) || (((PersistableBundle)localObject).size() <= 0)) {}
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        paramJSONObject.put("transitExtraData", com.tencent.luggage.h.d.a(paramp.aXx().kaM));
        if (j.a.oQ(paramp.aXx().dQv))
        {
          paramJSONObject.put("appversion", i);
          AppMethodBeat.o(48111);
          return;
          localJSONException1 = localJSONException1;
          ae.printErrStackTrace("MicroMsg.AppBrandPageVisitStatisticsHelper", localJSONException1, "", new Object[0]);
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.AppBrandPageVisitStatisticsHelper", localJSONException2, "", new Object[0]);
          continue;
          i = paramp.aXx().aDD;
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
      if ((1 == paramAppBrandLaunchReferrer.kbg) || (3 == paramAppBrandLaunchReferrer.kbg)) {
        return paramAppBrandLaunchReferrer.appId;
      }
    } while (2 != paramAppBrandLaunchReferrer.kbg);
    return paramAppBrandLaunchReferrer.url;
  }
  
  public static Pair<Integer, String> t(ad paramad)
  {
    int i = 7;
    AppMethodBeat.i(48112);
    Intent localIntent;
    switch (d.1.jOW[com.tencent.mm.plugin.appbrand.h.KU(paramad.getAppId()).ordinal()])
    {
    default: 
      localIntent = u(paramad).bsW();
      if (localIntent != null) {
        if (localIntent.getComponent() == null)
        {
          paramad = "";
          ae.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
          if ((!paramad.contains("WebViewUI")) && (!paramad.contains("WebviewMpUI"))) {
            break label249;
          }
          i = 10;
          paramad = z.getStringExtra(localIntent, AppBrandProcessProxyUI.ksu);
        }
      }
      break;
    }
    for (;;)
    {
      paramad = Pair.create(Integer.valueOf(i), paramad);
      AppMethodBeat.o(48112);
      return paramad;
      if (paramad.mgP.isLoading()) {}
      for (i = 4;; i = 3)
      {
        paramad = null;
        break;
      }
      if (paramad.mgP.isLoading()) {
        i = 5;
      }
      paramad = null;
      continue;
      i = 6;
      paramad = null;
      continue;
      i = 9;
      paramad = o.Ld(paramad.getAppId()).jBX + ":" + q.encode(bu.nullAsNil(o.Ld(paramad.getAppId()).jBY));
      continue;
      paramad = localIntent.getComponent().getClassName();
      break;
      label249:
      paramad = bu.bI(z.getStringExtra(localIntent, AppBrandProcessProxyUI.ksv), paramad);
      i = 8;
      continue;
      paramad = null;
    }
  }
  
  private static f u(ad paramad)
  {
    AppMethodBeat.i(48113);
    paramad = paramad.getRuntime().aXy().getReporter();
    AppMethodBeat.o(48113);
    return paramad;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.d
 * JD-Core Version:    0.7.0.1
 */