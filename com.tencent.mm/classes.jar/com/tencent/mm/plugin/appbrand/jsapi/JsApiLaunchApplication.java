package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.ceb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public class JsApiLaunchApplication
  extends d<s>
{
  private static final int CTRL_INDEX = 427;
  private static final String NAME = "launchApplication";
  
  public void a(s params, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45509);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiLaunchApplication", "data is null");
      params.i(paramInt, h("fail:data is null", null));
      AppMethodBeat.o(45509);
      return;
    }
    String str1 = paramJSONObject.optString("appId");
    String str2 = paramJSONObject.optString("schemeUrl");
    String str3 = paramJSONObject.optString("parameter");
    int i = Util.getInt(paramJSONObject.optString("alertType"), 0);
    int j = Util.getInt(paramJSONObject.optString("operateDirectly"), 0);
    String str4 = paramJSONObject.optString("extInfo");
    String str5 = paramJSONObject.optString("packageName");
    String str6 = paramJSONObject.optString("signature");
    Log.i("MicroMsg.JsApiLaunchApplication", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s, pkg:%s, signature:%s", new Object[] { str1, str2, str4, str3, str5, str6 });
    if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)) && (Util.isNullOrNil(str5)))
    {
      Log.e("MicroMsg.JsApiLaunchApplication", "appid and scheme is null or nil");
      params.i(paramInt, h("fail:appid and scheme is null or nil", null));
      AppMethodBeat.o(45509);
      return;
    }
    String str7 = params.getAppId();
    paramJSONObject = params.getCurrentPageView();
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.lBI;
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      if (!Util.isNullOrNil(paramJSONObject)) {}
      try
      {
        localBundle.putString("current_page_url", URLEncoder.encode(paramJSONObject, "UTF-8"));
        label246:
        localBundle.putString("current_page_appid", str7);
        d.a locala = new d.a();
        locala.iLN = new cea();
        locala.iLO = new ceb();
        locala.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        locala.funcId = 1125;
        cea localcea = (cea)locala.aXF().iLK.iLR;
        localcea.dNI = str7;
        localcea.MjD = str1;
        localcea.scene = ((q)params.getRuntime()).ON().cyA.scene;
        localcea.url = paramJSONObject;
        localcea.MjE = str2;
        localcea.qwp = i;
        localcea.LEg = 1;
        localcea.MjF = j;
        localcea.packageName = str5;
        Log.i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", new Object[] { str7, str1, Integer.valueOf(localcea.scene), localcea.url, localcea.MjE, Integer.valueOf(localcea.qwp), Integer.valueOf(localcea.MjF) });
        IPCRunCgi.a(locala.aXF(), new JsApiLaunchApplication.1(this, params, paramInt, str2, localBundle, str5, str6, str3, str1, str4));
        AppMethodBeat.o(45509);
        return;
        Log.e("MicroMsg.JsApiLaunchApplication", "getCurrentPageView is null");
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