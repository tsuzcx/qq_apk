package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.protocal.protobuf.cmv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public class JsApiLaunchApplication
  extends c<v>
{
  private static final int CTRL_INDEX = 427;
  private static final String NAME = "launchApplication";
  
  public void a(v paramv, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45509);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiLaunchApplication", "data is null");
      paramv.j(paramInt, h("fail:data is null", null));
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
      paramv.j(paramInt, h("fail:appid and scheme is null or nil", null));
      AppMethodBeat.o(45509);
      return;
    }
    String str7 = paramv.getAppId();
    paramJSONObject = paramv.getCurrentPageView();
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.oxe;
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      if (!Util.isNullOrNil(paramJSONObject)) {}
      try
      {
        localBundle.putString("current_page_url", URLEncoder.encode(paramJSONObject, "UTF-8"));
        label262:
        localBundle.putString("current_page_appid", str7);
        localBundle.putString("current_page_biz_info", (String)localObject2);
        localBundle.putString("current_page_source_info", (String)localObject1);
        localObject1 = new d.a();
        ((d.a)localObject1).lBU = new cmu();
        ((d.a)localObject1).lBV = new cmv();
        ((d.a)localObject1).uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        ((d.a)localObject1).funcId = 1125;
        localObject2 = (cmu)d.b.b(((d.a)localObject1).bgN().lBR);
        ((cmu)localObject2).appid = str7;
        ((cmu)localObject2).Tur = str1;
        ((cmu)localObject2).scene = ((t)paramv.getRuntime()).Sk().cxf.scene;
        ((cmu)localObject2).url = paramJSONObject;
        ((cmu)localObject2).Tus = str2;
        ((cmu)localObject2).tVq = i;
        ((cmu)localObject2).SEl = 1;
        ((cmu)localObject2).Tut = j;
        ((cmu)localObject2).packageName = str5;
        Log.i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", new Object[] { str7, str1, Integer.valueOf(((cmu)localObject2).scene), ((cmu)localObject2).url, ((cmu)localObject2).Tus, Integer.valueOf(((cmu)localObject2).tVq), Integer.valueOf(((cmu)localObject2).Tut) });
        IPCRunCgi.a(((d.a)localObject1).bgN(), new JsApiLaunchApplication.1(this, paramv, paramInt, str2, localBundle, str5, str6, str3, str1, str4));
        AppMethodBeat.o(45509);
        return;
        Log.e("MicroMsg.JsApiLaunchApplication", "getCurrentPageView is null");
        paramJSONObject = null;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label262;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication
 * JD-Core Version:    0.7.0.1
 */