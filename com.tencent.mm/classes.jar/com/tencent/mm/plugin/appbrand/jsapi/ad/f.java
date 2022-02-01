package com.tencent.mm.plugin.appbrand.jsapi.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 898;
  public static final String NAME = "rechargeTrafficCard";
  
  protected final void a(h paramh, int paramInt, com.b.b.a.a.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(221291);
    if (paramJSONObject == null)
    {
      parama = new HashMap();
      parama.put("errCode", Integer.valueOf(b.mSZ.errorCode));
      paramh.h(paramInt, m("fail:" + b.mSZ.errorMsg, parama));
      ad.e("MicroMsg.JsApiRechargeTrafficCard", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%d]", new Object[] { b.mSZ.errorMsg, paramh.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(221291);
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
      parama = parama.cn(localHashMap);
      ad.d("MicroMsg.JsApiRechargeTrafficCard", "rechargeCardString: [%s]! params: [%s]", new Object[] { parama, new JSONObject(localHashMap).toString() });
      parama = new JSONObject(parama);
      localHashMap = new HashMap();
      if (parama == null)
      {
        localHashMap.put("errCode", Integer.valueOf(b.naY.errorCode));
        paramh.h(paramInt, m("fail:" + b.naY.errorMsg, localHashMap));
        AppMethodBeat.o(221291);
        return;
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiRechargeTrafficCard", "call huawei remote interface fail: [%s] ! ", new Object[] { parama.getMessage() });
        parama = null;
      }
      int i = parama.optInt("resultCode");
      if (i != b.mSY.errorCode)
      {
        paramJSONObject = b.wk(i);
        parama = paramJSONObject;
        if (paramJSONObject == b.nbC) {
          parama = b.nbz;
        }
        localHashMap.put("errCode", Integer.valueOf(parama.errorCode));
        paramh.h(paramInt, m("fail:" + parama.errorMsg, localHashMap));
        ad.e("MicroMsg.JsApiRechargeTrafficCard", "Return code from huawei remote interface! with RetCode rechargeCard[%d] ", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(221291);
        return;
      }
      localHashMap.put("errCode", Integer.valueOf(b.mSY.errorCode));
      paramh.h(paramInt, m(b.mSY.errorMsg, localHashMap));
      AppMethodBeat.o(221291);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.f
 * JD-Core Version:    0.7.0.1
 */