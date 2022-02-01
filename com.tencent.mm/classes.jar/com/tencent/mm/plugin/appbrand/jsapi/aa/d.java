package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends a
{
  public static final int CTRL_INDEX = 897;
  public static final String NAME = "issueTrafficCard";
  
  protected final void a(k paramk, int paramInt, com.huawei.a.a.a.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(226996);
    if (paramJSONObject == null)
    {
      parama = new HashMap();
      parama.put("errCode", Integer.valueOf(b.muo.errorCode));
      paramk.i(paramInt, n("fail:" + b.muo.errorMsg, parama));
      Log.e("MicroMsg.JsApiIssueTrafficCard", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%d]", new Object[] { b.muo.errorMsg, paramk.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(226996);
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
      paramJSONObject = parama.e(localHashMap);
      parama = parama.f(localHashMap);
      Log.d("MicroMsg.JsApiIssueTrafficCard", "preIssueCardString: [%s] issueCardString: [%s]! params: [%s]", new Object[] { paramJSONObject, parama, new JSONObject(localHashMap).toString() });
      parama = new JSONObject(parama);
      localHashMap = new HashMap();
      if (parama == null)
      {
        localHashMap.put("errCode", Integer.valueOf(b.mus.errorCode));
        paramk.i(paramInt, n("fail:" + b.mus.errorMsg, localHashMap));
        AppMethodBeat.o(226996);
        return;
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiIssueTrafficCard", "call huawei remote interface fail: [%s] ! ", new Object[] { parama.getMessage() });
        parama = null;
      }
      int i = parama.optInt("resultCode");
      if (i != b.mun.errorCode)
      {
        paramJSONObject = b.xq(i);
        parama = paramJSONObject;
        if (paramJSONObject == b.muQ) {
          parama = b.muL;
        }
        localHashMap.put("errCode", Integer.valueOf(parama.errorCode));
        paramk.i(paramInt, n("fail:" + parama.errorMsg, localHashMap));
        Log.e("MicroMsg.JsApiIssueTrafficCard", "Return code from huawei remote interface! with RetCode issueCard[%d] ", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(226996);
        return;
      }
      localHashMap.put("errCode", Integer.valueOf(b.mun.errorCode));
      paramk.i(paramInt, n(b.mun.errorMsg, localHashMap));
      AppMethodBeat.o(226996);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.d
 * JD-Core Version:    0.7.0.1
 */