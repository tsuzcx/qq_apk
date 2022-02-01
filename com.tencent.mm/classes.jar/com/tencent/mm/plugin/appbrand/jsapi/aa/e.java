package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends a
{
  public static final int CTRL_INDEX = 896;
  public static final String NAME = "queryTrafficCardInfo";
  
  protected final void a(k paramk, int paramInt, com.huawei.a.a.a.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(226997);
    if (paramJSONObject == null)
    {
      parama = new HashMap();
      parama.put("errCode", Integer.valueOf(b.muo.errorCode));
      paramk.i(paramInt, n("fail:" + b.muo.errorMsg, parama));
      Log.e("MicroMsg.JsApiQueryTrafficCardInfo", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%d]", new Object[] { b.muo.errorMsg, paramk.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(226997);
      return;
    }
    Object localObject = paramJSONObject.optString("issuerID");
    int i = paramJSONObject.optInt("dataType");
    try
    {
      parama = parama.n((String)localObject, i);
      Log.d("MicroMsg.JsApiQueryTrafficCardInfo", "queryTrafficCardInfoString: [%s]! ", new Object[] { parama });
      parama = new JSONObject(parama);
      localObject = new HashMap();
      if (parama == null)
      {
        ((Map)localObject).put("errCode", Integer.valueOf(b.mus.errorCode));
        paramk.i(paramInt, n("fail:" + b.mus.errorMsg, (Map)localObject));
        AppMethodBeat.o(226997);
        return;
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiQueryTrafficCardInfo", "call huawei remote interface fail: [%s] ! ", new Object[] { parama.getMessage() });
        parama = null;
      }
      i = parama.optInt("resultCode");
      if (i != b.mun.errorCode)
      {
        paramJSONObject = b.xq(i);
        parama = paramJSONObject;
        if (paramJSONObject == b.muQ) {
          parama = b.muH;
        }
        ((Map)localObject).put("errCode", Integer.valueOf(parama.errorCode));
        paramk.i(paramInt, n("fail:" + parama.errorMsg, (Map)localObject));
        Log.e("MicroMsg.JsApiQueryTrafficCardInfo", "Return code from huawei remote interface! with RetCode rechargeCard[%d] ", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(226997);
        return;
      }
      ((Map)localObject).put("errCode", Integer.valueOf(b.mun.errorCode));
      ((Map)localObject).put("data", parama.optJSONObject("data"));
      paramk.i(paramInt, n(b.mun.errorMsg, (Map)localObject));
      AppMethodBeat.o(226997);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.e
 * JD-Core Version:    0.7.0.1
 */