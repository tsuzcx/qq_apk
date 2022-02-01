package com.tencent.mm.plugin.appbrand.jsapi.ac;

import android.os.IInterface;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.j;
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
  
  protected final void a(j paramj, int paramInt, IInterface paramIInterface, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(270437);
    if (paramJSONObject == null)
    {
      paramIInterface = new HashMap();
      paramIInterface.put("errCode", Integer.valueOf(b.psC.errorCode));
      paramj.j(paramInt, m("fail:" + b.psC.errorMsg, paramIInterface));
      q(6, b.psC.errorCode, "deviceData is null");
      Log.e("MicroMsg.JsApiSetDefaultTrafficCard", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%s]", new Object[] { b.psC.errorMsg, paramj.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(270437);
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
        if (i == b.psB.errorCode) {
          continue;
        }
        if (!bool) {
          continue;
        }
        paramIInterface = b.AM(i);
        paramJSONObject = paramIInterface;
        if (paramIInterface != b.ptn) {
          continue;
        }
        paramJSONObject = b.pti;
        localHashMap.put("errCode", Integer.valueOf(paramJSONObject.errorCode));
        paramj.j(paramInt, m("fail:" + paramJSONObject.errorMsg, localHashMap));
        q(6, paramJSONObject.errorCode, paramJSONObject.errorMsg);
        Log.e("MicroMsg.JsApiSetDefaultTrafficCard", "Return code from remote interface! with RetCode rechargeCard[%s] ", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(270437);
        return;
        paramIInterface = b.AN(i);
        continue;
        localHashMap.put("errCode", Integer.valueOf(b.psB.errorCode));
        paramj.j(paramInt, m(b.psB.errorMsg, localHashMap));
        q(6, b.psB.errorCode, "");
        AppMethodBeat.o(270437);
        return;
      }
      localHashMap = new HashMap();
      if (paramIInterface == null)
      {
        localHashMap.put("errCode", Integer.valueOf(b.psG.errorCode));
        paramj.j(paramInt, m("fail:" + b.psG.errorMsg, localHashMap));
        q(6, b.psG.errorCode, "call remote interface exception");
        Log.e("MicroMsg.JsApiSetDefaultTrafficCard", "call remote interface exception.");
        AppMethodBeat.o(270437);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.h
 * JD-Core Version:    0.7.0.1
 */