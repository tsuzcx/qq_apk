package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public class JsApiLaunchApplication
  extends a<r>
{
  private static final int CTRL_INDEX = 427;
  private static final String NAME = "launchApplication";
  
  public void a(final r paramr, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(130450);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiLaunchApplication", "data is null");
      paramr.h(paramInt, j("fail:data is null", null));
      AppMethodBeat.o(130450);
      return;
    }
    final String str1 = paramJSONObject.optString("appId");
    final String str2 = paramJSONObject.optString("schemeUrl");
    final String str3 = paramJSONObject.optString("parameter");
    int i = bo.getInt(paramJSONObject.optString("alertType"), 0);
    int j = bo.getInt(paramJSONObject.optString("operateDirectly"), 0);
    final String str4 = paramJSONObject.optString("extInfo");
    final String str5 = paramJSONObject.optString("packageName");
    final String str6 = paramJSONObject.optString("signature");
    ab.i("MicroMsg.JsApiLaunchApplication", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s, pkg:%s, signature:%s", new Object[] { str1, str2, str4, str3, str5, str6 });
    if ((bo.isNullOrNil(str1)) && (bo.isNullOrNil(str2)) && (bo.isNullOrNil(str5)))
    {
      ab.e("MicroMsg.JsApiLaunchApplication", "appid and scheme is null or nil");
      paramr.h(paramInt, j("fail:appid and scheme is null or nil", null));
      AppMethodBeat.o(130450);
      return;
    }
    String str7 = paramr.getAppId();
    paramJSONObject = paramr.getCurrentPageView();
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.hzM;
    }
    for (;;)
    {
      final Bundle localBundle = new Bundle();
      if (!bo.isNullOrNil(paramJSONObject)) {}
      try
      {
        localBundle.putString("current_page_url", URLEncoder.encode(paramJSONObject, "UTF-8"));
        label246:
        localBundle.putString("current_page_appid", str7);
        com.tencent.mm.ai.b.a locala = new com.tencent.mm.ai.b.a();
        locala.fsX = new axf();
        locala.fsY = new axg();
        locala.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        locala.funcId = 1125;
        axf localaxf = (axf)locala.ado().fsV.fta;
        localaxf.cwc = str7;
        localaxf.xmy = str1;
        localaxf.scene = ((o)paramr.getRuntime()).wS().bDh.scene;
        localaxf.url = paramJSONObject;
        localaxf.xmz = str2;
        localaxf.kNx = i;
        localaxf.xmA = 1;
        localaxf.xmB = j;
        localaxf.packageName = str5;
        ab.i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", new Object[] { str7, str1, Integer.valueOf(localaxf.scene), localaxf.url, localaxf.xmz, Integer.valueOf(localaxf.kNx), Integer.valueOf(localaxf.xmB) });
        com.tencent.mm.ipcinvoker.wx_extension.b.a(locala.ado(), new com.tencent.mm.ipcinvoker.wx_extension.b.a()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ai.b paramAnonymousb)
          {
            AppMethodBeat.i(130439);
            ab.i("MicroMsg.JsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            com.tencent.mm.ch.a.post(new JsApiLaunchApplication.1.1(this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousb));
            AppMethodBeat.o(130439);
          }
        });
        AppMethodBeat.o(130450);
        return;
        ab.e("MicroMsg.JsApiLaunchApplication", "getCurrentPageView is null");
        paramJSONObject = null;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label246;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication
 * JD-Core Version:    0.7.0.1
 */