package com.tencent.mm.plugin.appbrand.jsapi.af;

import android.os.IInterface;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends a
{
  public static final int CTRL_INDEX = 898;
  public static final String NAME = "rechargeTrafficCard";
  
  protected final void a(k paramk, int paramInt, IInterface paramIInterface, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(325909);
    if (paramJSONObject == null)
    {
      paramIInterface = new HashMap();
      paramIInterface.put("errCode", Integer.valueOf(b.sxO.errorCode));
      paramk.callback(paramInt, m("fail:" + b.sxO.errorMsg, paramIInterface));
      t(5, b.sxO.errorCode, "deviceData is null");
      Log.e("MicroMsg.JsApiRechargeTrafficCard", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%s]", new Object[] { b.sxO.errorMsg, paramk.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(325909);
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
    boolean bool = paramIInterface instanceof com.huawei.b.a.a.a;
    if (bool) {}
    for (;;)
    {
      try
      {
        paramIInterface = ((com.huawei.b.a.a.a)paramIInterface).recharge(localHashMap);
        Log.i("MicroMsg.JsApiRechargeTrafficCard", "rechargeCardString: [%s]! params: [%s]", new Object[] { paramIInterface, new JSONObject(localHashMap).toString() });
        if (TextUtils.isEmpty(paramIInterface)) {
          continue;
        }
        paramIInterface = new JSONObject(paramIInterface);
      }
      catch (Exception paramIInterface)
      {
        Log.e("MicroMsg.JsApiRechargeTrafficCard", "call remote interface fail: [%s] ! ", new Object[] { paramIInterface.getMessage() });
        paramIInterface = null;
        continue;
        int i = paramIInterface.optInt("resultCode");
        if (i == b.sxN.errorCode) {
          continue;
        }
        if (!bool) {
          continue;
        }
        paramIInterface = b.Bb(i);
        paramJSONObject = paramIInterface;
        if (paramIInterface != b.syA) {
          continue;
        }
        paramJSONObject = b.syu;
        localHashMap.put("errCode", Integer.valueOf(paramJSONObject.errorCode));
        paramk.callback(paramInt, m("fail:" + paramJSONObject.errorMsg, localHashMap));
        t(5, paramJSONObject.errorCode, paramJSONObject.errorMsg);
        Log.e("MicroMsg.JsApiRechargeTrafficCard", "Return code from remote interface! with RetCode rechargeCard[%s] ", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(325909);
        return;
        paramIInterface = b.Bc(i);
        continue;
        localHashMap.put("errCode", Integer.valueOf(b.sxN.errorCode));
        paramk.callback(paramInt, m(b.sxN.errorMsg, localHashMap));
        t(5, b.sxN.errorCode, "");
        AppMethodBeat.o(325909);
        return;
      }
      localHashMap = new HashMap();
      if (paramIInterface == null)
      {
        localHashMap.put("errCode", Integer.valueOf(b.sxS.errorCode));
        paramk.callback(paramInt, m("fail:" + b.sxS.errorMsg, localHashMap));
        t(5, b.sxS.errorCode, "call remote interface exception");
        Log.e("MicroMsg.JsApiRechargeTrafficCard", "call remote interface exception.");
        AppMethodBeat.o(325909);
        return;
        if (!(paramIInterface instanceof ITencentSmartcardOpenService)) {
          break label638;
        }
        paramIInterface = ((ITencentSmartcardOpenService)paramIInterface).recharge(localHashMap);
      }
      label638:
      paramIInterface = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.g
 * JD-Core Version:    0.7.0.1
 */