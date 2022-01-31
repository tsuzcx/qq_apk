package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiLaunchApplicationDirectly
  extends JsApiLaunchApplication
{
  private static final int CTRL_INDEX = 620;
  private static final String NAME = "launchApplicationDirectly";
  
  public final void a(r paramr, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(130478);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiLaunchApplicationDirectly", "data is null");
      paramr.h(paramInt, j("fail:data is null", null));
      AppMethodBeat.o(130478);
      return;
    }
    String str1 = paramJSONObject.optString("appId");
    String str2 = paramJSONObject.optString("schemeUrl");
    String str3 = paramJSONObject.optString("parameter");
    int i = bo.getInt(paramJSONObject.optString("alertType"), 0);
    int j = bo.getInt(paramJSONObject.optString("operateDirectly"), 0);
    String str4 = paramJSONObject.optString("extInfo");
    String str5 = paramJSONObject.optString("packageName");
    String str6 = paramJSONObject.optString("installSchemeUrl");
    String str7 = paramJSONObject.optString("fileMd5");
    String str8 = paramJSONObject.optString("taskName");
    ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", new Object[] { str1, str2, str4, str3 });
    if ((bo.isNullOrNil(str1)) && (bo.isNullOrNil(str2)))
    {
      ab.e("MicroMsg.JsApiLaunchApplicationDirectly", "appid and scheme is null or nil");
      paramr.h(paramInt, j("fail:appid and scheme is null or nil", null));
      AppMethodBeat.o(130478);
      return;
    }
    String str9 = paramr.getAppId();
    paramJSONObject = paramr.getCurrentPageView();
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.hzM;
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      if (!bo.isNullOrNil(paramJSONObject)) {}
      try
      {
        localBundle.putString("current_page_url", URLEncoder.encode(paramJSONObject, "UTF-8"));
        label243:
        localBundle.putString("current_page_appid", str9);
        b.a locala = new b.a();
        locala.fsX = new axf();
        locala.fsY = new axg();
        locala.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        locala.funcId = 1125;
        axf localaxf = (axf)locala.ado().fsV.fta;
        localaxf.cwc = str9;
        localaxf.xmy = str1;
        localaxf.scene = ((com.tencent.mm.plugin.appbrand.o)paramr.getRuntime()).wS().bDh.scene;
        localaxf.url = paramJSONObject;
        localaxf.xmz = str2;
        localaxf.kNx = i;
        localaxf.xmA = 1;
        localaxf.xmB = j;
        localaxf.xmC = str6;
        ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", new Object[] { str9, str1, Integer.valueOf(localaxf.scene), localaxf.url, localaxf.xmz, Integer.valueOf(localaxf.kNx), Integer.valueOf(localaxf.xmB) });
        com.tencent.mm.ipcinvoker.wx_extension.b.a(locala.ado(), new JsApiLaunchApplicationDirectly.1(this, paramr, paramInt, str5, str6, str1, str8, str7, str2, localBundle, str3, str4));
        AppMethodBeat.o(130478);
        return;
        ab.e("MicroMsg.JsApiLaunchApplicationDirectly", "getCurrentPageView is null");
        paramJSONObject = null;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label243;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly
 * JD-Core Version:    0.7.0.1
 */