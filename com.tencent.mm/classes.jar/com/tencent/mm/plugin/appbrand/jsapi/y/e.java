package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends a
{
  public static final int CTRL_INDEX = 896;
  public static final String NAME = "queryTrafficCardInfo";
  
  protected final void a(h paramh, int paramInt, com.b.a.a.a.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222686);
    if (paramJSONObject == null)
    {
      parama = new HashMap();
      parama.put("errCode", Integer.valueOf(b.lnG.errorCode));
      paramh.h(paramInt, n("fail:" + b.lnG.errorMsg, parama));
      ae.e("MicroMsg.JsApiQueryTrafficCardInfo", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%d]", new Object[] { b.lnG.errorMsg, paramh.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(222686);
      return;
    }
    Object localObject = paramJSONObject.optString("issuerID");
    int i = paramJSONObject.optInt("dataType");
    try
    {
      parama = parama.n((String)localObject, i);
      ae.d("MicroMsg.JsApiQueryTrafficCardInfo", "queryTrafficCardInfoString: [%s]! ", new Object[] { parama });
      parama = new JSONObject(parama);
      localObject = new HashMap();
      if (parama == null)
      {
        ((Map)localObject).put("errCode", Integer.valueOf(b.lnK.errorCode));
        paramh.h(paramInt, n("fail:" + b.lnK.errorMsg, (Map)localObject));
        AppMethodBeat.o(222686);
        return;
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ae.e("MicroMsg.JsApiQueryTrafficCardInfo", "call huawei remote interface fail: [%s] ! ", new Object[] { parama.getMessage() });
        parama = null;
      }
      i = parama.optInt("resultCode");
      if (i != b.lnF.errorCode)
      {
        paramJSONObject = b.ts(i);
        parama = paramJSONObject;
        if (paramJSONObject == b.lok) {
          parama = b.lnZ;
        }
        ((Map)localObject).put("errCode", Integer.valueOf(parama.errorCode));
        paramh.h(paramInt, n("fail:" + parama.errorMsg, (Map)localObject));
        ae.e("MicroMsg.JsApiQueryTrafficCardInfo", "Return code from huawei remote interface! with RetCode rechargeCard[%d] ", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(222686);
        return;
      }
      ((Map)localObject).put("errCode", Integer.valueOf(b.lnF.errorCode));
      ((Map)localObject).put("data", parama.optJSONObject("data"));
      paramh.h(paramInt, n(b.lnF.errorMsg, (Map)localObject));
      AppMethodBeat.o(222686);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.e
 * JD-Core Version:    0.7.0.1
 */