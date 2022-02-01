package com.tencent.mm.plugin.appbrand.jsapi.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends a
{
  public static final int CTRL_INDEX = 896;
  public static final String NAME = "queryTrafficCardInfo";
  
  protected final void a(h paramh, int paramInt, com.b.b.a.a.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(221290);
    if (paramJSONObject == null)
    {
      parama = new HashMap();
      parama.put("errCode", Integer.valueOf(b.mSZ.errorCode));
      paramh.h(paramInt, m("fail:" + b.mSZ.errorMsg, parama));
      ad.e("MicroMsg.JsApiQueryTrafficCardInfo", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%d]", new Object[] { b.mSZ.errorMsg, paramh.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(221290);
      return;
    }
    Object localObject = paramJSONObject.optString("issuerID");
    int i = paramJSONObject.optInt("dataType");
    try
    {
      parama = parama.hz((String)localObject, i);
      ad.d("MicroMsg.JsApiQueryTrafficCardInfo", "queryTrafficCardInfoString: [%s]! ", new Object[] { parama });
      parama = new JSONObject(parama);
      localObject = new HashMap();
      if (parama == null)
      {
        ((Map)localObject).put("errCode", Integer.valueOf(b.naY.errorCode));
        paramh.h(paramInt, m("fail:" + b.naY.errorMsg, (Map)localObject));
        AppMethodBeat.o(221290);
        return;
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiQueryTrafficCardInfo", "call huawei remote interface fail: [%s] ! ", new Object[] { parama.getMessage() });
        parama = null;
      }
      i = parama.optInt("resultCode");
      if (i != b.mSY.errorCode)
      {
        paramJSONObject = b.wk(i);
        parama = paramJSONObject;
        if (paramJSONObject == b.nbC) {
          parama = b.nbp;
        }
        ((Map)localObject).put("errCode", Integer.valueOf(parama.errorCode));
        paramh.h(paramInt, m("fail:" + parama.errorMsg, (Map)localObject));
        ad.e("MicroMsg.JsApiQueryTrafficCardInfo", "Return code from huawei remote interface! with RetCode rechargeCard[%d] ", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(221290);
        return;
      }
      ((Map)localObject).put("errCode", Integer.valueOf(b.mSY.errorCode));
      ((Map)localObject).put("data", parama.optJSONObject("data"));
      paramh.h(paramInt, m(b.mSY.errorMsg, (Map)localObject));
      AppMethodBeat.o(221290);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.e
 * JD-Core Version:    0.7.0.1
 */