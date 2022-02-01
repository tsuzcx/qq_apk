package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 898;
  public static final String NAME = "rechargeTrafficCard";
  
  protected final void a(k paramk, int paramInt, com.huawei.a.a.a.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(226998);
    if (paramJSONObject == null)
    {
      parama = new HashMap();
      parama.put("errCode", Integer.valueOf(b.muo.errorCode));
      paramk.i(paramInt, n("fail:" + b.muo.errorMsg, parama));
      Log.e("MicroMsg.JsApiRechargeTrafficCard", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%d]", new Object[] { b.muo.errorMsg, paramk.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(226998);
      return;
    }
    HashMap localHashMap = new HashMap();
    String str1 = paramJSONObject.optString("issuerID");
    String str2 = paramJSONObject.optString("orderNo");
    String str3 = paramJSONObject.optString("cityCode");
    paramJSONObject = paramJSONObject.optString("retry");
    localHashMap.put("issuerID", str1);
    localHashMap.put("orderNo", str2);
    localHashMap.put("appID", "APP-WECHAT");
    localHashMap.put("operation", "1");
    localHashMap.put("cityCode", str3);
    localHashMap.put("retry", paramJSONObject);
    try
    {
      parama = parama.g(localHashMap);
      Log.d("MicroMsg.JsApiRechargeTrafficCard", "rechargeCardString: [%s]! params: [%s]", new Object[] { parama, new JSONObject(localHashMap).toString() });
      parama = new JSONObject(parama);
      localHashMap = new HashMap();
      if (parama == null)
      {
        localHashMap.put("errCode", Integer.valueOf(b.mus.errorCode));
        paramk.i(paramInt, n("fail:" + b.mus.errorMsg, localHashMap));
        AppMethodBeat.o(226998);
        return;
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiRechargeTrafficCard", "call huawei remote interface fail: [%s] ! ", new Object[] { parama.getMessage() });
        parama = null;
      }
      int i = parama.optInt("resultCode");
      if (i != b.mun.errorCode)
      {
        paramJSONObject = b.xq(i);
        parama = paramJSONObject;
        if (paramJSONObject == b.muQ) {
          parama = b.muN;
        }
        localHashMap.put("errCode", Integer.valueOf(parama.errorCode));
        paramk.i(paramInt, n("fail:" + parama.errorMsg, localHashMap));
        Log.e("MicroMsg.JsApiRechargeTrafficCard", "Return code from huawei remote interface! with RetCode rechargeCard[%d] ", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(226998);
        return;
      }
      localHashMap.put("errCode", Integer.valueOf(b.mun.errorCode));
      paramk.i(paramInt, n(b.mun.errorMsg, localHashMap));
      AppMethodBeat.o(226998);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.f
 * JD-Core Version:    0.7.0.1
 */