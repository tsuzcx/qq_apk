package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public class d
  extends a
{
  private static final int CTRL_INDEX = 45;
  private static final String NAME = "reportAction";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(107801);
    String str5 = paramJSONObject.optString("key");
    String str7 = paramJSONObject.optString("value");
    ac.i("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey =  %s, actionValue =  %s", new Object[] { str5, str7 });
    if ((bs.isNullOrNil(str5)) || (bs.isNullOrNil(str7)))
    {
      ac.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue is null");
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(107801);
      return;
    }
    if ((str5.length() <= 0) || (str5.length() > 32) || (str7.length() <= 0) || (str7.length() > 1024))
    {
      ac.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue size is bad");
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(107801);
      return;
    }
    String str6 = paramc.getAppId();
    if (TextUtils.isEmpty(str6))
    {
      ac.e("MicroMsg.JsApiReportAction", "doReportActionInfo, appId is empty");
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(107801);
      return;
    }
    ac.i("MicroMsg.JsApiReportAction", "doReportActionInfo, appId %s", new Object[] { str6 });
    int i = 0;
    int j = 0;
    if (ax.isConnected(paramc.getContext()))
    {
      if (!ax.isWifi(paramc.getContext())) {
        break label535;
      }
      i = 1;
    }
    for (;;)
    {
      ac.i("MicroMsg.JsApiReportAction", "doReportActionInfo, get networkType %d", new Object[] { Integer.valueOf(i) });
      long l = bs.aNx();
      ac.d("MicroMsg.JsApiReportAction", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", new Object[] { Long.valueOf(l), Integer.valueOf(13579), str6, Integer.valueOf(i), "", "", "", str5, str7 });
      Object localObject1 = "";
      localObject3 = "";
      String str3 = "";
      str4 = "";
      String str1 = str3;
      paramJSONObject = (JSONObject)localObject3;
      try
      {
        localObject2 = URLEncoder.encode(bs.nullAsNil(""), "UTF-8");
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
          ac.printErrStackTrace("MicroMsg.JsApiReportAction", localUnsupportedEncodingException, "", new Object[0]);
          String str2 = str4;
          localObject3 = paramJSONObject;
        }
      }
      h.wUl.f(13579, new Object[] { str6, Integer.valueOf(i), localObject1, localObject3, "", str1, localObject2, Long.valueOf(l), Long.valueOf(l) });
      paramc.h(paramInt, e("ok", null));
      AppMethodBeat.o(107801);
      return;
      label535:
      if (ax.is4G(paramc.getContext()))
      {
        i = 4;
      }
      else if (ax.is3G(paramc.getContext()))
      {
        i = 3;
      }
      else
      {
        i = j;
        if (ax.is2G(paramc.getContext())) {
          i = 2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.d
 * JD-Core Version:    0.7.0.1
 */