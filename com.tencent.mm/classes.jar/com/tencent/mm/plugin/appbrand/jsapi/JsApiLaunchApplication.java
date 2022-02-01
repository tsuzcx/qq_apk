package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public class JsApiLaunchApplication
  extends a<r>
{
  private static final int CTRL_INDEX = 427;
  private static final String NAME = "launchApplication";
  
  public void a(r paramr, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45509);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiLaunchApplication", "data is null");
      paramr.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(45509);
      return;
    }
    String str1 = paramJSONObject.optString("appId");
    String str2 = paramJSONObject.optString("schemeUrl");
    String str3 = paramJSONObject.optString("parameter");
    int i = bu.getInt(paramJSONObject.optString("alertType"), 0);
    int j = bu.getInt(paramJSONObject.optString("operateDirectly"), 0);
    String str4 = paramJSONObject.optString("extInfo");
    String str5 = paramJSONObject.optString("packageName");
    String str6 = paramJSONObject.optString("signature");
    ae.i("MicroMsg.JsApiLaunchApplication", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s, pkg:%s, signature:%s", new Object[] { str1, str2, str4, str3, str5, str6 });
    if ((bu.isNullOrNil(str1)) && (bu.isNullOrNil(str2)) && (bu.isNullOrNil(str5)))
    {
      ae.e("MicroMsg.JsApiLaunchApplication", "appid and scheme is null or nil");
      paramr.h(paramInt, e("fail:appid and scheme is null or nil", null));
      AppMethodBeat.o(45509);
      return;
    }
    String str7 = paramr.getAppId();
    paramJSONObject = paramr.getCurrentPageView();
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.kxv;
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      if (!bu.isNullOrNil(paramJSONObject)) {}
      try
      {
        localBundle.putString("current_page_url", URLEncoder.encode(paramJSONObject, "UTF-8"));
        label246:
        localBundle.putString("current_page_appid", str7);
        b.a locala = new b.a();
        locala.hQF = new brg();
        locala.hQG = new brh();
        locala.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        locala.funcId = 1125;
        brg localbrg = (brg)locala.aDS().hQD.hQJ;
        localbrg.dwb = str7;
        localbrg.Heu = str1;
        localbrg.scene = ((p)paramr.getRuntime()).Fg().cmE.scene;
        localbrg.url = paramJSONObject;
        localbrg.Hev = str2;
        localbrg.phg = i;
        localbrg.Hew = 1;
        localbrg.Hex = j;
        localbrg.packageName = str5;
        ae.i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", new Object[] { str7, str1, Integer.valueOf(localbrg.scene), localbrg.url, localbrg.Hev, Integer.valueOf(localbrg.phg), Integer.valueOf(localbrg.Hex) });
        IPCRunCgi.a(locala.aDS(), new JsApiLaunchApplication.1(this, paramr, paramInt, str2, localBundle, str5, str6, str3, str1, str4));
        AppMethodBeat.o(45509);
        return;
        ae.e("MicroMsg.JsApiLaunchApplication", "getCurrentPageView is null");
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