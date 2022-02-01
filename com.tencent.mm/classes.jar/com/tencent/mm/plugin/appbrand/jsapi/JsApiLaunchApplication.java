package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.protocal.protobuf.ddi;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public class JsApiLaunchApplication
  extends c<y>
{
  private static final int CTRL_INDEX = 427;
  private static final String NAME = "launchApplication";
  
  public void a(y paramy, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45509);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiLaunchApplication", "data is null");
      paramy.callback(paramInt, ZP("fail:data is null"));
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
    Object localObject1 = paramJSONObject.optString("sourceInfo");
    Object localObject2 = paramJSONObject.optString("bizInfo");
    Log.i("MicroMsg.JsApiLaunchApplication", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s, pkg:%s, signature:%s", new Object[] { str1, str2, str4, str3, str5, str6 });
    if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)) && (Util.isNullOrNil(str5)))
    {
      Log.e("MicroMsg.JsApiLaunchApplication", "appid and scheme is null or nil");
      paramy.callback(paramInt, ZP("fail:appid and scheme is null or nil"));
      AppMethodBeat.o(45509);
      return;
    }
    String str7 = paramy.getAppId();
    paramJSONObject = paramy.getCurrentPageView();
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.cgR();
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      if (!Util.isNullOrNil(paramJSONObject)) {}
      try
      {
        localBundle.putString("current_page_url", URLEncoder.encode(paramJSONObject, "UTF-8"));
        label260:
        localBundle.putString("current_page_appid", str7);
        localBundle.putString("current_page_biz_info", (String)localObject2);
        localBundle.putString("current_page_source_info", (String)localObject1);
        localObject1 = new c.a();
        ((c.a)localObject1).otE = new ddi();
        ((c.a)localObject1).otF = new ddj();
        ((c.a)localObject1).uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        ((c.a)localObject1).funcId = 1125;
        localObject2 = (ddi)c.b.b(((c.a)localObject1).bEF().otB);
        ((ddi)localObject2).appid = str7;
        ((ddi)localObject2).aaIV = str1;
        ((ddi)localObject2).scene = ((w)paramy.getRuntime()).asA().epn.scene;
        ((ddi)localObject2).url = paramJSONObject;
        ((ddi)localObject2).aaIW = str2;
        ((ddi)localObject2).wYK = i;
        ((ddi)localObject2).ZFJ = 1;
        ((ddi)localObject2).aaIX = j;
        ((ddi)localObject2).packageName = str5;
        Log.i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", new Object[] { str7, str1, Integer.valueOf(((ddi)localObject2).scene), ((ddi)localObject2).url, ((ddi)localObject2).aaIW, Integer.valueOf(((ddi)localObject2).wYK), Integer.valueOf(((ddi)localObject2).aaIX) });
        IPCRunCgi.a(((c.a)localObject1).bEF(), new JsApiLaunchApplication.1(this, paramy, paramInt, str2, localBundle, str5, str6, str3, str1, str4));
        AppMethodBeat.o(45509);
        return;
        Log.e("MicroMsg.JsApiLaunchApplication", "getCurrentPageView is null");
        paramJSONObject = null;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label260;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication
 * JD-Core Version:    0.7.0.1
 */