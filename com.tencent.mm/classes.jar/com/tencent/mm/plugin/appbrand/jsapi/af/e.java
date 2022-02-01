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

public final class e
  extends a
{
  public static final int CTRL_INDEX = 897;
  public static final String NAME = "issueTrafficCard";
  
  protected final void a(k paramk, int paramInt, IInterface paramIInterface, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(325906);
    if (paramJSONObject == null)
    {
      paramIInterface = new HashMap();
      paramIInterface.put("errCode", Integer.valueOf(b.sxO.errorCode));
      paramk.callback(paramInt, m("fail:" + b.sxO.errorMsg, paramIInterface));
      t(3, b.sxO.errorCode, "deviceData is null");
      Log.e("MicroMsg.JsApiIssueTrafficCard", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%s]", new Object[] { b.sxO.errorMsg, paramk.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(325906);
      return;
    }
    HashMap localHashMap = new HashMap();
    String str1 = paramJSONObject.optString("issuerID");
    String str2 = paramJSONObject.optString("orderNo");
    String str3 = paramJSONObject.optString("cityCode");
    paramJSONObject = paramJSONObject.optString("orderStatus");
    localHashMap.put("issuerID", str1);
    localHashMap.put("orderNo", str2);
    localHashMap.put("appID", "APP-WECHAT");
    localHashMap.put("operation", "1");
    localHashMap.put("cityCode", str3);
    localHashMap.put("orderStatus", paramJSONObject);
    boolean bool = paramIInterface instanceof com.huawei.b.a.a.a;
    if (bool) {}
    for (;;)
    {
      try
      {
        ((com.huawei.b.a.a.a)paramIInterface).preIssueCard(localHashMap);
        paramIInterface = ((com.huawei.b.a.a.a)paramIInterface).issueCard(localHashMap);
        if (TextUtils.isEmpty(paramIInterface)) {
          continue;
        }
        paramIInterface = new JSONObject(paramIInterface);
      }
      catch (Exception paramIInterface)
      {
        Log.e("MicroMsg.JsApiIssueTrafficCard", "call remote interface fail: [%s] ! ", new Object[] { paramIInterface.getMessage() });
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
        paramJSONObject = b.sys;
        localHashMap.put("errCode", Integer.valueOf(paramJSONObject.errorCode));
        paramk.callback(paramInt, m("fail:" + paramJSONObject.errorMsg, localHashMap));
        t(3, paramJSONObject.errorCode, paramJSONObject.errorMsg);
        Log.e("MicroMsg.JsApiIssueTrafficCard", "Return code from remote interface! with RetCode issueCard[%s] ", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(325906);
        return;
        paramIInterface = b.Bc(i);
        continue;
        localHashMap.put("errCode", Integer.valueOf(b.sxN.errorCode));
        paramk.callback(paramInt, m(b.sxN.errorMsg, localHashMap));
        t(3, b.sxN.errorCode, "");
        AppMethodBeat.o(325906);
        return;
      }
      localHashMap = new HashMap();
      if (paramIInterface == null)
      {
        localHashMap.put("errCode", Integer.valueOf(b.sxS.errorCode));
        paramk.callback(paramInt, m("fail:" + b.sxS.errorMsg, localHashMap));
        t(3, b.sxS.errorCode, "call remote interface exception");
        Log.e("MicroMsg.JsApiIssueTrafficCard", "call remote interface exception.");
        AppMethodBeat.o(325906);
        return;
        if (!(paramIInterface instanceof ITencentSmartcardOpenService)) {
          break label632;
        }
        ((ITencentSmartcardOpenService)paramIInterface).preIssueCard(localHashMap);
        paramIInterface = ((ITencentSmartcardOpenService)paramIInterface).issueCard(localHashMap);
      }
      label632:
      paramIInterface = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.e
 * JD-Core Version:    0.7.0.1
 */