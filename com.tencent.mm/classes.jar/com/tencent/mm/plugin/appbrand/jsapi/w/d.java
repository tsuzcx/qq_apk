package com.tencent.mm.plugin.appbrand.jsapi.w;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public class d
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  private static final int CTRL_INDEX = 45;
  private static final String NAME = "reportAction";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(107801);
    String str5 = paramJSONObject.optString("key");
    String str7 = paramJSONObject.optString("value");
    Log.i("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey =  %s, actionValue =  %s", new Object[] { str5, str7 });
    if ((Util.isNullOrNil(str5)) || (Util.isNullOrNil(str7)))
    {
      Log.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue is null");
      paramf.i(paramInt, h("fail", null));
      AppMethodBeat.o(107801);
      return;
    }
    if ((str5.length() <= 0) || (str5.length() > 32) || (str7.length() <= 0) || (str7.length() > 1024))
    {
      Log.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue size is bad");
      paramf.i(paramInt, h("fail", null));
      AppMethodBeat.o(107801);
      return;
    }
    String str6 = paramf.getAppId();
    if (TextUtils.isEmpty(str6))
    {
      Log.e("MicroMsg.JsApiReportAction", "doReportActionInfo, appId is empty");
      paramf.i(paramInt, h("fail", null));
      AppMethodBeat.o(107801);
      return;
    }
    Log.i("MicroMsg.JsApiReportAction", "doReportActionInfo, appId %s", new Object[] { str6 });
    int i = 0;
    int j = 0;
    if (NetStatusUtil.isConnected(paramf.getContext()))
    {
      if (!NetStatusUtil.isWifi(paramf.getContext())) {
        break label535;
      }
      i = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.JsApiReportAction", "doReportActionInfo, get networkType %d", new Object[] { Integer.valueOf(i) });
      long l = Util.nowSecond();
      Log.d("MicroMsg.JsApiReportAction", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", new Object[] { Long.valueOf(l), Integer.valueOf(13579), str6, Integer.valueOf(i), "", "", "", str5, str7 });
      Object localObject1 = "";
      localObject3 = "";
      String str3 = "";
      str4 = "";
      String str1 = str3;
      paramJSONObject = (JSONObject)localObject3;
      try
      {
        localObject2 = URLEncoder.encode(Util.nullAsNil(""), "UTF-8");
        str1 = str3;
        paramJSONObject = (JSONObject)localObject3;
        localObject1 = localObject2;
        localObject3 = URLEncoder.encode("", "UTF-8");
        str1 = str3;
        paramJSONObject = (JSONObject)localObject3;
        localObject1 = localObject2;
        str3 = URLEncoder.encode(str5, "UTF-8");
        str1 = str3;
        paramJSONObject = (JSONObject)localObject3;
        localObject1 = localObject2;
        str5 = URLEncoder.encode(str7, "UTF-8");
        paramJSONObject = str5;
        localObject1 = localObject2;
        str1 = str3;
        localObject2 = paramJSONObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Object localObject2;
          Log.printErrStackTrace("MicroMsg.JsApiReportAction", localUnsupportedEncodingException, "", new Object[0]);
          String str2 = str4;
          localObject3 = paramJSONObject;
        }
      }
      h.CyF.a(13579, new Object[] { str6, Integer.valueOf(i), localObject1, localObject3, "", str1, localObject2, Long.valueOf(l), Long.valueOf(l) });
      paramf.i(paramInt, h("ok", null));
      AppMethodBeat.o(107801);
      return;
      label535:
      if (NetStatusUtil.is5G(paramf.getContext()))
      {
        i = 5;
      }
      else if (NetStatusUtil.is4G(paramf.getContext()))
      {
        i = 4;
      }
      else if (NetStatusUtil.is3G(paramf.getContext()))
      {
        i = 3;
      }
      else
      {
        i = j;
        if (NetStatusUtil.is2G(paramf.getContext())) {
          i = 2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.d
 * JD-Core Version:    0.7.0.1
 */