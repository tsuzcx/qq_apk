package com.tencent.mm.plugin.appbrand.report.model;

import android.content.ComponentName;
import android.content.Intent;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.h.e;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.bb;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.openmaterial.model.a;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static String F(com.tencent.mm.plugin.appbrand.q paramq)
  {
    AppMethodBeat.i(227381);
    if (paramq.bsC().kHL.isEnable())
    {
      AppMethodBeat.o(227381);
      return "halfPage";
    }
    if (bb.r(paramq))
    {
      AppMethodBeat.o(227381);
      return "singlePage";
    }
    AppMethodBeat.o(227381);
    return "default";
  }
  
  private static String a(com.tencent.mm.plugin.appbrand.q paramq, String paramString)
  {
    AppMethodBeat.i(227382);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(227382);
      return paramString;
    }
    Object localObject1 = a.adn(paramString);
    if (localObject1 == null)
    {
      AppMethodBeat.o(227382);
      return paramString;
    }
    Object localObject2 = ((a)localObject1).nlI.trim();
    Log.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, originMaterialPath: ".concat(String.valueOf(localObject2)));
    if ((((String)localObject2).startsWith("http://")) || (((String)localObject2).startsWith("https://")))
    {
      AppMethodBeat.o(227382);
      return paramString;
    }
    String str1 = ((a)localObject1).mimeType;
    if ((!str1.startsWith("image")) && (!str1.startsWith("video"))) {}
    for (localObject1 = org.apache.commons.a.d.getName((String)localObject2);; localObject1 = "")
    {
      String str2 = org.apache.commons.a.d.getExtension((String)localObject2);
      o localo = new o((String)localObject2);
      int i = (int)localo.length();
      Log.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, fileName: %s, fileExt: %s，fileSize: %d", new Object[] { localObject1, str2, Integer.valueOf(i) });
      localObject2 = new i();
      paramq = paramq.OK().a(localo, str2, false, (i)localObject2);
      Log.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, result: ".concat(String.valueOf(paramq)));
      if (m.kSu != paramq)
      {
        AppMethodBeat.o(227382);
        return paramString;
      }
      paramq = (String)((i)localObject2).value;
      Log.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, newMaterialPath: ".concat(String.valueOf(paramq)));
      paramq = new a(str1, paramq, (String)localObject1, i).bua();
      AppMethodBeat.o(227382);
      return paramq;
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.q paramq, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48109);
    try
    {
      if ((j.a.sE(paramq.bsC().eix)) && (!TextUtils.isEmpty(paramq.bsC().ldS))) {
        paramJSONObject.put("debugLaunchInfo", new JSONObject(paramq.bsC().ldS));
      }
      AppMethodBeat.o(48109);
      return;
    }
    catch (JSONException paramq)
    {
      Log.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillDebugLaunchInfo ex = %s", new Object[] { paramq });
      AppMethodBeat.o(48109);
    }
  }
  
  public static void b(com.tencent.mm.plugin.appbrand.q paramq, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48110);
    try
    {
      c(paramq, paramJSONObject);
      paramJSONObject.put("referpagepath", d(paramq.bsC().cys));
      paramJSONObject.put("clickTimestamp", paramq.bsC().startTime);
      AppMethodBeat.o(48110);
      return;
    }
    catch (Exception paramq)
    {
      Log.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillWxConfigLaunchInfo ex = %s", new Object[] { paramq });
      AppMethodBeat.o(48110);
    }
  }
  
  public static void c(com.tencent.mm.plugin.appbrand.q paramq, JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(48111);
    paramJSONObject.put("scene", paramq.ON().cyA.scene);
    paramJSONObject.put("scene_note", paramq.ON().cyA.dCw);
    paramJSONObject.put("sessionId", paramq.bsC().cym);
    paramJSONObject.put("usedState", paramq.ON().cyA.nHt);
    paramJSONObject.put("prescene", paramq.ON().cyA.ecU);
    paramJSONObject.put("prescene_note", paramq.ON().cyA.ecV);
    Object localObject = paramq.bsC().kHG;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject.put("chatroomUsername", localObject);
    }
    localObject = paramq.bsC().kHQ;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject.put("shortLink", localObject);
    }
    if (!TextUtils.isEmpty(paramq.bsC().ldR))
    {
      String str = paramq.bsC().ldR;
      localObject = str;
      if (1173 == paramq.ON().cyA.scene) {
        localObject = a(paramq, str);
      }
    }
    try
    {
      paramJSONObject.put("nativeExtraData", new JSONObject((String)localObject));
      localObject = paramq.bsC().ldQ;
      if ((localObject == null) || (((PersistableBundle)localObject).size() <= 0)) {}
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        paramJSONObject.put("transitExtraData", e.a(paramq.bsC().ldQ));
        if (j.a.sE(paramq.bsC().eix))
        {
          paramJSONObject.put("appversion", i);
          paramJSONObject.put("mode", F(paramq));
          AppMethodBeat.o(48111);
          return;
          localJSONException1 = localJSONException1;
          Log.printErrStackTrace("MicroMsg.AppBrandPageVisitStatisticsHelper", localJSONException1, "", new Object[0]);
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppBrandPageVisitStatisticsHelper", localJSONException2, "", new Object[0]);
          continue;
          i = paramq.bsC().appVersion;
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
      if ((1 == paramAppBrandLaunchReferrer.leo) || (3 == paramAppBrandLaunchReferrer.leo)) {
        return paramAppBrandLaunchReferrer.appId;
      }
    } while (2 != paramAppBrandLaunchReferrer.leo);
    return paramAppBrandLaunchReferrer.url;
  }
  
  public static Pair<Integer, String> t(ag paramag)
  {
    int i = 7;
    AppMethodBeat.i(48112);
    Intent localIntent;
    switch (1.kRE[com.tencent.mm.plugin.appbrand.h.Uc(paramag.getAppId()).ordinal()])
    {
    default: 
      localIntent = u(paramag).bOA();
      if (localIntent != null) {
        if (localIntent.getComponent() == null)
        {
          paramag = "";
          Log.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
          if ((!paramag.contains("WebViewUI")) && (!paramag.contains("WebviewMpUI"))) {
            break label253;
          }
          i = 10;
          paramag = IntentUtil.getStringExtra(localIntent, AppBrandProcessProxyUI.lwe);
        }
      }
      break;
    }
    for (;;)
    {
      paramag = Pair.create(Integer.valueOf(i), paramag);
      AppMethodBeat.o(48112);
      return paramag;
      if (paramag.nrs.isLoading()) {}
      for (i = 4;; i = 3)
      {
        paramag = null;
        break;
      }
      if (paramag.nrs.isLoading()) {
        i = 5;
      }
      paramag = null;
      continue;
      i = 6;
      paramag = null;
      continue;
      i = 9;
      paramag = p.Um(paramag.getAppId()).kCT + ":" + com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(p.Um(paramag.getAppId()).kCU));
      continue;
      paramag = localIntent.getComponent().getClassName();
      break;
      label253:
      paramag = Util.nullAs(IntentUtil.getStringExtra(localIntent, AppBrandProcessProxyUI.lwf), paramag);
      i = 8;
      continue;
      paramag = null;
    }
  }
  
  private static f u(ag paramag)
  {
    AppMethodBeat.i(48113);
    paramag = paramag.getRuntime().bsD().getReporter();
    AppMethodBeat.o(48113);
    return paramag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.d
 * JD-Core Version:    0.7.0.1
 */