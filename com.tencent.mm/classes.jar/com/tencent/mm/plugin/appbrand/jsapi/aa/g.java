package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends a
{
  public static final int CTRL_INDEX = 899;
  public static final String NAME = "setDefaultTrafficCard";
  
  protected final void a(k paramk, int paramInt, com.huawei.a.a.a.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(226999);
    if (paramJSONObject == null)
    {
      parama = new HashMap();
      parama.put("errCode", Integer.valueOf(b.muo.errorCode));
      paramk.i(paramInt, n("fail:" + b.muo.errorMsg, parama));
      Log.e("MicroMsg.JsApiSetDefaultTrafficCard", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%d]", new Object[] { b.muo.errorMsg, paramk.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(226999);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("issuerID", paramJSONObject.optString("issuerID"));
    localHashMap.put("appID", "APP-WECHAT");
    localHashMap.put("mode", "0");
    try
    {
      parama = parama.j(localHashMap);
      Log.d("MicroMsg.JsApiSetDefaultTrafficCard", "setDefaultCardString: [%s]! params: [%s]", new Object[] { parama, new JSONObject(localHashMap).toString() });
      parama = new JSONObject(parama);
      localHashMap = new HashMap();
      if (parama == null)
      {
        localHashMap.put("errCode", Integer.valueOf(b.mus.errorCode));
        paramk.i(paramInt, n("fail:" + b.mus.errorMsg, localHashMap));
        AppMethodBeat.o(226999);
        return;
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiSetDefaultTrafficCard", "call huawei remote interface fail: [%s] ! ", new Object[] { parama.getMessage() });
        parama = null;
      }
      int i = parama.optInt("resultCode");
      if (i != b.mun.errorCode)
      {
        paramJSONObject = b.xq(i);
        parama = paramJSONObject;
        if (paramJSONObject == b.muQ) {
          parama = b.muO;
        }
        localHashMap.put("errCode", Integer.valueOf(parama.errorCode));
        paramk.i(paramInt, n("fail:" + parama.errorMsg, localHashMap));
        Log.e("MicroMsg.JsApiSetDefaultTrafficCard", "Return code from huawei remote interface! with RetCode rechargeCard[%d] ", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(226999);
        return;
      }
      localHashMap.put("errCode", Integer.valueOf(b.mun.errorCode));
      paramk.i(paramInt, n(b.mun.errorMsg, localHashMap));
      AppMethodBeat.o(226999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.g
 * JD-Core Version:    0.7.0.1
 */