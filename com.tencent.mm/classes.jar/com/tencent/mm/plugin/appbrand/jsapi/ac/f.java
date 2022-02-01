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

public final class f
  extends a
{
  public static final int CTRL_INDEX = 896;
  public static final String NAME = "queryTrafficCardInfo";
  
  protected final void a(j paramj, int paramInt, IInterface paramIInterface, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(282539);
    if (paramJSONObject == null)
    {
      paramIInterface = new HashMap();
      paramIInterface.put("errCode", Integer.valueOf(b.psC.errorCode));
      paramj.j(paramInt, m("fail:" + b.psC.errorMsg, paramIInterface));
      q(4, b.psC.errorCode, "deviceData is null");
      Log.e("MicroMsg.JsApiQueryTrafficCardInfo", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%s]", new Object[] { b.psC.errorMsg, paramj.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(282539);
      return;
    }
    Object localObject = paramJSONObject.optString("issuerID");
    int i = paramJSONObject.optInt("dataType");
    boolean bool = paramIInterface instanceof com.huawei.b.a.a.a;
    if (bool) {}
    for (;;)
    {
      try
      {
        paramIInterface = ((com.huawei.b.a.a.a)paramIInterface).queryTrafficCardInfo((String)localObject, i);
        if (TextUtils.isEmpty(paramIInterface)) {
          continue;
        }
        paramIInterface = new JSONObject(paramIInterface);
      }
      catch (Exception paramIInterface)
      {
        Log.e("MicroMsg.JsApiQueryTrafficCardInfo", "call huawei remote interface fail: [%s] ! ", new Object[] { paramIInterface.getMessage() });
        paramIInterface = null;
        continue;
        i = paramIInterface.optInt("resultCode");
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
        paramJSONObject = b.psZ;
        ((Map)localObject).put("errCode", Integer.valueOf(paramJSONObject.errorCode));
        paramj.j(paramInt, m("fail:" + paramJSONObject.errorMsg, (Map)localObject));
        q(4, paramJSONObject.errorCode, paramJSONObject.errorMsg);
        Log.e("MicroMsg.JsApiQueryTrafficCardInfo", "Return code from huawei remote interface! with RetCode rechargeCard[%s] ", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(282539);
        return;
        paramIInterface = b.AN(i);
        continue;
        ((Map)localObject).put("errCode", Integer.valueOf(b.psB.errorCode));
        ((Map)localObject).put("data", paramIInterface.optJSONObject("data"));
        paramj.j(paramInt, m(b.psB.errorMsg, (Map)localObject));
        q(4, b.psB.errorCode, "");
        AppMethodBeat.o(282539);
        return;
      }
      localObject = new HashMap();
      if (paramIInterface == null)
      {
        ((Map)localObject).put("errCode", Integer.valueOf(b.psG.errorCode));
        paramj.j(paramInt, m("fail:" + b.psG.errorMsg, (Map)localObject));
        q(4, b.psG.errorCode, "call remote interface exception");
        Log.e("MicroMsg.JsApiQueryTrafficCardInfo", "call remote interface exception.");
        AppMethodBeat.o(282539);
        return;
        if (!(paramIInterface instanceof ITencentSmartcardOpenService)) {
          break label541;
        }
        paramIInterface = ((ITencentSmartcardOpenService)paramIInterface).queryTrafficCardInfo((String)localObject, i);
      }
      label541:
      paramIInterface = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.f
 * JD-Core Version:    0.7.0.1
 */