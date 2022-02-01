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

public final class e
  extends a
{
  public static final int CTRL_INDEX = 897;
  public static final String NAME = "issueTrafficCard";
  
  protected final void a(j paramj, int paramInt, IInterface paramIInterface, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(243125);
    if (paramJSONObject == null)
    {
      paramIInterface = new HashMap();
      paramIInterface.put("errCode", Integer.valueOf(b.psC.errorCode));
      paramj.j(paramInt, m("fail:" + b.psC.errorMsg, paramIInterface));
      q(3, b.psC.errorCode, "deviceData is null");
      Log.e("MicroMsg.JsApiIssueTrafficCard", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%s]", new Object[] { b.psC.errorMsg, paramj.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(243125);
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
        paramJSONObject = b.ptf;
        localHashMap.put("errCode", Integer.valueOf(paramJSONObject.errorCode));
        paramj.j(paramInt, m("fail:" + paramJSONObject.errorMsg, localHashMap));
        q(3, paramJSONObject.errorCode, paramJSONObject.errorMsg);
        Log.e("MicroMsg.JsApiIssueTrafficCard", "Return code from remote interface! with RetCode issueCard[%s] ", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(243125);
        return;
        paramIInterface = b.AN(i);
        continue;
        localHashMap.put("errCode", Integer.valueOf(b.psB.errorCode));
        paramj.j(paramInt, m(b.psB.errorMsg, localHashMap));
        q(3, b.psB.errorCode, "");
        AppMethodBeat.o(243125);
        return;
      }
      localHashMap = new HashMap();
      if (paramIInterface == null)
      {
        localHashMap.put("errCode", Integer.valueOf(b.psG.errorCode));
        paramj.j(paramInt, m("fail:" + b.psG.errorMsg, localHashMap));
        q(3, b.psG.errorCode, "call remote interface exception");
        Log.e("MicroMsg.JsApiIssueTrafficCard", "call remote interface exception.");
        AppMethodBeat.o(243125);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.e
 * JD-Core Version:    0.7.0.1
 */