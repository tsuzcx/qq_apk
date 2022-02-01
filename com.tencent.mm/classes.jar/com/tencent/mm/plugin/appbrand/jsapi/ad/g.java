package com.tencent.mm.plugin.appbrand.jsapi.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends a
{
  public static final int CTRL_INDEX = 899;
  public static final String NAME = "setDefaultTrafficCard";
  
  protected final void a(h paramh, int paramInt, com.b.b.a.a.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(221292);
    if (paramJSONObject == null)
    {
      parama = new HashMap();
      parama.put("errCode", Integer.valueOf(b.mSZ.errorCode));
      paramh.h(paramInt, m("fail:" + b.mSZ.errorMsg, parama));
      ad.e("MicroMsg.JsApiSetDefaultTrafficCard", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%d]", new Object[] { b.mSZ.errorMsg, paramh.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(221292);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("issuerID", paramJSONObject.optString("issuerID"));
    localHashMap.put("appID", "APP-WECHAT");
    localHashMap.put("mode", "0");
    try
    {
      parama = parama.cq(localHashMap);
      ad.d("MicroMsg.JsApiSetDefaultTrafficCard", "setDefaultCardString: [%s]! params: [%s]", new Object[] { parama, new JSONObject(localHashMap).toString() });
      parama = new JSONObject(parama);
      localHashMap = new HashMap();
      if (parama == null)
      {
        localHashMap.put("errCode", Integer.valueOf(b.naY.errorCode));
        paramh.h(paramInt, m("fail:" + b.naY.errorMsg, localHashMap));
        AppMethodBeat.o(221292);
        return;
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiSetDefaultTrafficCard", "call huawei remote interface fail: [%s] ! ", new Object[] { parama.getMessage() });
        parama = null;
      }
      int i = parama.optInt("resultCode");
      if (i != b.mSY.errorCode)
      {
        paramJSONObject = b.wk(i);
        parama = paramJSONObject;
        if (paramJSONObject == b.nbC) {
          parama = b.nbA;
        }
        localHashMap.put("errCode", Integer.valueOf(parama.errorCode));
        paramh.h(paramInt, m("fail:" + parama.errorMsg, localHashMap));
        ad.e("MicroMsg.JsApiSetDefaultTrafficCard", "Return code from huawei remote interface! with RetCode rechargeCard[%d] ", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(221292);
        return;
      }
      localHashMap.put("errCode", Integer.valueOf(b.mSY.errorCode));
      paramh.h(paramInt, m(b.mSY.errorMsg, localHashMap));
      AppMethodBeat.o(221292);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.g
 * JD-Core Version:    0.7.0.1
 */