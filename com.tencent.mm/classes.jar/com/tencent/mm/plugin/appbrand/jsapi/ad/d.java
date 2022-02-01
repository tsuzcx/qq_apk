package com.tencent.mm.plugin.appbrand.jsapi.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends a
{
  public static final int CTRL_INDEX = 897;
  public static final String NAME = "issueTrafficCard";
  
  protected final void a(h paramh, int paramInt, com.b.b.a.a.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(221289);
    if (paramJSONObject == null)
    {
      parama = new HashMap();
      parama.put("errCode", Integer.valueOf(b.mSZ.errorCode));
      paramh.h(paramInt, m("fail:" + b.mSZ.errorMsg, parama));
      ad.e("MicroMsg.JsApiIssueTrafficCard", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%d]", new Object[] { b.mSZ.errorMsg, paramh.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(221289);
      return;
    }
    HashMap localHashMap = new HashMap();
    String str1 = paramJSONObject.optString("issuerID");
    String str2 = paramJSONObject.optString("orderNo");
    String str3 = paramJSONObject.optString("cityCode");
    paramJSONObject = paramJSONObject.optString("orderStatus");
    localHashMap.put("issuerID", str1);
    localHashMap.put("orderNo", str2);
    localHashMap.put("appID", "APP-WECHAT");
    localHashMap.put("operation", "1");
    localHashMap.put("cityCode", str3);
    localHashMap.put("orderStatus", paramJSONObject);
    try
    {
      paramJSONObject = parama.cl(localHashMap);
      parama = parama.cm(localHashMap);
      ad.d("MicroMsg.JsApiIssueTrafficCard", "preIssueCardString: [%s] issueCardString: [%s]! params: [%s]", new Object[] { paramJSONObject, parama, new JSONObject(localHashMap).toString() });
      parama = new JSONObject(parama);
      localHashMap = new HashMap();
      if (parama == null)
      {
        localHashMap.put("errCode", Integer.valueOf(b.naY.errorCode));
        paramh.h(paramInt, m("fail:" + b.naY.errorMsg, localHashMap));
        AppMethodBeat.o(221289);
        return;
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiIssueTrafficCard", "call huawei remote interface fail: [%s] ! ", new Object[] { parama.getMessage() });
        parama = null;
      }
      int i = parama.optInt("resultCode");
      if (i != b.mSY.errorCode)
      {
        paramJSONObject = b.wk(i);
        parama = paramJSONObject;
        if (paramJSONObject == b.nbC) {
          parama = b.nbx;
        }
        localHashMap.put("errCode", Integer.valueOf(parama.errorCode));
        paramh.h(paramInt, m("fail:" + parama.errorMsg, localHashMap));
        ad.e("MicroMsg.JsApiIssueTrafficCard", "Return code from huawei remote interface! with RetCode issueCard[%d] ", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(221289);
        return;
      }
      localHashMap.put("errCode", Integer.valueOf(b.mSY.errorCode));
      paramh.h(paramInt, m(b.mSY.errorMsg, localHashMap));
      AppMethodBeat.o(221289);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.d
 * JD-Core Version:    0.7.0.1
 */