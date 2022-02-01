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

public final class h
  extends a
{
  public static final int CTRL_INDEX = 899;
  public static final String NAME = "setDefaultTrafficCard";
  
  protected final void a(k paramk, int paramInt, IInterface paramIInterface, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(325910);
    if (paramJSONObject == null)
    {
      paramIInterface = new HashMap();
      paramIInterface.put("errCode", Integer.valueOf(b.sxO.errorCode));
      paramk.callback(paramInt, m("fail:" + b.sxO.errorMsg, paramIInterface));
      t(6, b.sxO.errorCode, "deviceData is null");
      Log.e("MicroMsg.JsApiSetDefaultTrafficCard", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%s]", new Object[] { b.sxO.errorMsg, paramk.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(325910);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("issuerID", paramJSONObject.optString("issuerID"));
    localHashMap.put("appID", "APP-WECHAT");
    localHashMap.put("mode", "0");
    boolean bool = paramIInterface instanceof com.huawei.b.a.a.a;
    if (bool) {}
    for (;;)
    {
      try
      {
        paramIInterface = ((com.huawei.b.a.a.a)paramIInterface).startSetDefault(localHashMap);
        Log.i("MicroMsg.JsApiSetDefaultTrafficCard", "setDefaultCardString: [%s]! params: [%s]", new Object[] { paramIInterface, new JSONObject(localHashMap).toString() });
        if (TextUtils.isEmpty(paramIInterface)) {
          continue;
        }
        paramIInterface = new JSONObject(paramIInterface);
      }
      catch (Exception paramIInterface)
      {
        Log.e("MicroMsg.JsApiSetDefaultTrafficCard", "call remote interface fail: [%s] ! ", new Object[] { paramIInterface.getMessage() });
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
        paramJSONObject = b.syv;
        localHashMap.put("errCode", Integer.valueOf(paramJSONObject.errorCode));
        paramk.callback(paramInt, m("fail:" + paramJSONObject.errorMsg, localHashMap));
        t(6, paramJSONObject.errorCode, paramJSONObject.errorMsg);
        Log.e("MicroMsg.JsApiSetDefaultTrafficCard", "Return code from remote interface! with RetCode rechargeCard[%s] ", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(325910);
        return;
        paramIInterface = b.Bc(i);
        continue;
        localHashMap.put("errCode", Integer.valueOf(b.sxN.errorCode));
        paramk.callback(paramInt, m(b.sxN.errorMsg, localHashMap));
        t(6, b.sxN.errorCode, "");
        AppMethodBeat.o(325910);
        return;
      }
      localHashMap = new HashMap();
      if (paramIInterface == null)
      {
        localHashMap.put("errCode", Integer.valueOf(b.sxS.errorCode));
        paramk.callback(paramInt, m("fail:" + b.sxS.errorMsg, localHashMap));
        t(6, b.sxS.errorCode, "call remote interface exception");
        Log.e("MicroMsg.JsApiSetDefaultTrafficCard", "call remote interface exception.");
        AppMethodBeat.o(325910);
        return;
        if (!(paramIInterface instanceof ITencentSmartcardOpenService)) {
          break label581;
        }
        paramIInterface = ((ITencentSmartcardOpenService)paramIInterface).startSetDefault(localHashMap);
      }
      label581:
      paramIInterface = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.h
 * JD-Core Version:    0.7.0.1
 */