package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 898;
  public static final String NAME = "rechargeTrafficCard";
  
  protected final void a(h paramh, int paramInt, com.b.a.a.a.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222687);
    if (paramJSONObject == null)
    {
      parama = new HashMap();
      parama.put("errCode", Integer.valueOf(b.lnG.errorCode));
      paramh.h(paramInt, n("fail:" + b.lnG.errorMsg, parama));
      ae.e("MicroMsg.JsApiRechargeTrafficCard", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%d]", new Object[] { b.lnG.errorMsg, paramh.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(222687);
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
      parama = parama.e(localHashMap);
      ae.d("MicroMsg.JsApiRechargeTrafficCard", "rechargeCardString: [%s]! params: [%s]", new Object[] { parama, new JSONObject(localHashMap).toString() });
      parama = new JSONObject(parama);
      localHashMap = new HashMap();
      if (parama == null)
      {
        localHashMap.put("errCode", Integer.valueOf(b.lnK.errorCode));
        paramh.h(paramInt, n("fail:" + b.lnK.errorMsg, localHashMap));
        AppMethodBeat.o(222687);
        return;
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ae.e("MicroMsg.JsApiRechargeTrafficCard", "call huawei remote interface fail: [%s] ! ", new Object[] { parama.getMessage() });
        parama = null;
      }
      int i = parama.optInt("resultCode");
      if (i != b.lnF.errorCode)
      {
        paramJSONObject = b.ts(i);
        parama = paramJSONObject;
        if (paramJSONObject == b.lok) {
          parama = b.loh;
        }
        localHashMap.put("errCode", Integer.valueOf(parama.errorCode));
        paramh.h(paramInt, n("fail:" + parama.errorMsg, localHashMap));
        ae.e("MicroMsg.JsApiRechargeTrafficCard", "Return code from huawei remote interface! with RetCode rechargeCard[%d] ", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(222687);
        return;
      }
      localHashMap.put("errCode", Integer.valueOf(b.lnF.errorCode));
      paramh.h(paramInt, n(b.lnF.errorMsg, localHashMap));
      AppMethodBeat.o(222687);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.f
 * JD-Core Version:    0.7.0.1
 */