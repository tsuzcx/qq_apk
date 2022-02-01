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

public final class f
  extends a
{
  public static final int CTRL_INDEX = 896;
  public static final String NAME = "queryTrafficCardInfo";
  
  protected final void a(k paramk, int paramInt, IInterface paramIInterface, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(325907);
    if (paramJSONObject == null)
    {
      paramIInterface = new HashMap();
      paramIInterface.put("errCode", Integer.valueOf(b.sxO.errorCode));
      paramk.callback(paramInt, m("fail:" + b.sxO.errorMsg, paramIInterface));
      t(4, b.sxO.errorCode, "deviceData is null");
      Log.e("MicroMsg.JsApiQueryTrafficCardInfo", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%s]", new Object[] { b.sxO.errorMsg, paramk.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(325907);
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
        paramJSONObject = b.syl;
        ((Map)localObject).put("errCode", Integer.valueOf(paramJSONObject.errorCode));
        paramk.callback(paramInt, m("fail:" + paramJSONObject.errorMsg, (Map)localObject));
        t(4, paramJSONObject.errorCode, paramJSONObject.errorMsg);
        Log.e("MicroMsg.JsApiQueryTrafficCardInfo", "Return code from huawei remote interface! with RetCode rechargeCard[%s] ", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(325907);
        return;
        paramIInterface = b.Bc(i);
        continue;
        ((Map)localObject).put("errCode", Integer.valueOf(b.sxN.errorCode));
        ((Map)localObject).put("data", paramIInterface.optJSONObject("data"));
        paramk.callback(paramInt, m(b.sxN.errorMsg, (Map)localObject));
        t(4, b.sxN.errorCode, "");
        AppMethodBeat.o(325907);
        return;
      }
      localObject = new HashMap();
      if (paramIInterface == null)
      {
        ((Map)localObject).put("errCode", Integer.valueOf(b.sxS.errorCode));
        paramk.callback(paramInt, m("fail:" + b.sxS.errorMsg, (Map)localObject));
        t(4, b.sxS.errorCode, "call remote interface exception");
        Log.e("MicroMsg.JsApiQueryTrafficCardInfo", "call remote interface exception.");
        AppMethodBeat.o(325907);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.f
 * JD-Core Version:    0.7.0.1
 */