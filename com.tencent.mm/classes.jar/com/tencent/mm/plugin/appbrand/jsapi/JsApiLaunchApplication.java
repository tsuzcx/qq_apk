package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.bqm;
import com.tencent.mm.protocal.protobuf.bqn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public class JsApiLaunchApplication
  extends a<q>
{
  private static final int CTRL_INDEX = 427;
  private static final String NAME = "launchApplication";
  
  public void a(q paramq, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45509);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiLaunchApplication", "data is null");
      paramq.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(45509);
      return;
    }
    String str1 = paramJSONObject.optString("appId");
    String str2 = paramJSONObject.optString("schemeUrl");
    String str3 = paramJSONObject.optString("parameter");
    int i = bt.getInt(paramJSONObject.optString("alertType"), 0);
    int j = bt.getInt(paramJSONObject.optString("operateDirectly"), 0);
    String str4 = paramJSONObject.optString("extInfo");
    String str5 = paramJSONObject.optString("packageName");
    String str6 = paramJSONObject.optString("signature");
    ad.i("MicroMsg.JsApiLaunchApplication", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s, pkg:%s, signature:%s", new Object[] { str1, str2, str4, str3, str5, str6 });
    if ((bt.isNullOrNil(str1)) && (bt.isNullOrNil(str2)) && (bt.isNullOrNil(str5)))
    {
      ad.e("MicroMsg.JsApiLaunchApplication", "appid and scheme is null or nil");
      paramq.h(paramInt, e("fail:appid and scheme is null or nil", null));
      AppMethodBeat.o(45509);
      return;
    }
    String str7 = paramq.getAppId();
    paramJSONObject = paramq.getCurrentPageView();
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.kuf;
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      if (!bt.isNullOrNil(paramJSONObject)) {}
      try
      {
        localBundle.putString("current_page_url", URLEncoder.encode(paramJSONObject, "UTF-8"));
        label246:
        localBundle.putString("current_page_appid", str7);
        b.a locala = new b.a();
        locala.hNM = new bqm();
        locala.hNN = new bqn();
        locala.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        locala.funcId = 1125;
        bqm localbqm = (bqm)locala.aDC().hNK.hNQ;
        localbqm.duW = str7;
        localbqm.GKT = str1;
        localbqm.scene = ((o)paramq.getRuntime()).Fb().cmC.scene;
        localbqm.url = paramJSONObject;
        localbqm.GKU = str2;
        localbqm.paC = i;
        localbqm.GKV = 1;
        localbqm.GKW = j;
        localbqm.packageName = str5;
        ad.i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", new Object[] { str7, str1, Integer.valueOf(localbqm.scene), localbqm.url, localbqm.GKU, Integer.valueOf(localbqm.paC), Integer.valueOf(localbqm.GKW) });
        IPCRunCgi.a(locala.aDC(), new JsApiLaunchApplication.1(this, paramq, paramInt, str2, localBundle, str5, str6, str3, str1, str4));
        AppMethodBeat.o(45509);
        return;
        ad.e("MicroMsg.JsApiLaunchApplication", "getCurrentPageView is null");
        paramJSONObject = null;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label246;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication
 * JD-Core Version:    0.7.0.1
 */