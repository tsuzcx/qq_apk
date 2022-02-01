package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends a
{
  public static final int CTRL_INDEX = 899;
  public static final String NAME = "setDefaultTrafficCard";
  
  protected final void a(h paramh, int paramInt, com.b.a.a.a.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222688);
    if (paramJSONObject == null)
    {
      parama = new HashMap();
      parama.put("errCode", Integer.valueOf(b.lnG.errorCode));
      paramh.h(paramInt, n("fail:" + b.lnG.errorMsg, parama));
      ae.e("MicroMsg.JsApiSetDefaultTrafficCard", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%d]", new Object[] { b.lnG.errorMsg, paramh.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(222688);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("issuerID", paramJSONObject.optString("issuerID"));
    localHashMap.put("appID", "APP-WECHAT");
    localHashMap.put("mode", "0");
    try
    {
      parama = parama.h(localHashMap);
      ae.d("MicroMsg.JsApiSetDefaultTrafficCard", "setDefaultCardString: [%s]! params: [%s]", new Object[] { parama, new JSONObject(localHashMap).toString() });
      parama = new JSONObject(parama);
      localHashMap = new HashMap();
      if (parama == null)
      {
        localHashMap.put("errCode", Integer.valueOf(b.lnK.errorCode));
        paramh.h(paramInt, n("fail:" + b.lnK.errorMsg, localHashMap));
        AppMethodBeat.o(222688);
        return;
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ae.e("MicroMsg.JsApiSetDefaultTrafficCard", "call huawei remote interface fail: [%s] ! ", new Object[] { parama.getMessage() });
        parama = null;
      }
      int i = parama.optInt("resultCode");
      if (i != b.lnF.errorCode)
      {
        paramJSONObject = b.ts(i);
        parama = paramJSONObject;
        if (paramJSONObject == b.lok) {
          parama = b.loi;
        }
        localHashMap.put("errCode", Integer.valueOf(parama.errorCode));
        paramh.h(paramInt, n("fail:" + parama.errorMsg, localHashMap));
        ae.e("MicroMsg.JsApiSetDefaultTrafficCard", "Return code from huawei remote interface! with RetCode rechargeCard[%d] ", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(222688);
        return;
      }
      localHashMap.put("errCode", Integer.valueOf(b.lnF.errorCode));
      paramh.h(paramInt, n(b.lnF.errorMsg, localHashMap));
      AppMethodBeat.o(222688);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.g
 * JD-Core Version:    0.7.0.1
 */