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

public final class c
  extends a
{
  public static final int CTRL_INDEX = 895;
  public static final String NAME = "checkTrafficCardConditions";
  
  protected final void a(k paramk, int paramInt, IInterface paramIInterface, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(325911);
    if (paramJSONObject == null)
    {
      paramIInterface = new HashMap();
      paramIInterface.put("errCode", Integer.valueOf(b.sxO.errorCode));
      paramk.callback(paramInt, m("fail:" + b.sxO.errorMsg, paramIInterface));
      t(2, b.sxO.errorCode, "deviceData is null");
      Log.e("MicroMsg.JsApiCheckTrafficCardConditions", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%s]", new Object[] { b.sxO.errorMsg, paramk.getAppId(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(325911);
      return;
    }
    localObject3 = new HashMap();
    localObject1 = paramJSONObject.optString("issuerID");
    localObject4 = paramJSONObject.optString("serviceID");
    bool1 = "issueCardService".equals(localObject4);
    ((HashMap)localObject3).put("issuerID", localObject1);
    Object localObject8 = null;
    Object localObject9 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    bool2 = paramIInterface instanceof com.huawei.b.a.a.a;
    localObject5 = "";
    paramJSONObject = "";
    if (bool2)
    {
      localObject1 = localObject6;
      localObject2 = localObject8;
    }
    for (;;)
    {
      try
      {
        localObject5 = ((com.huawei.b.a.a.a)paramIInterface).queryCplc();
        if (bool1)
        {
          localObject1 = localObject6;
          localObject2 = localObject8;
          paramJSONObject = ((com.huawei.b.a.a.a)paramIInterface).checkIssueConditions((Map)localObject3);
        }
        localObject1 = localObject6;
        localObject2 = localObject8;
        ((HashMap)localObject3).put("serviceID", localObject4);
        localObject1 = localObject6;
        localObject2 = localObject8;
        localObject3 = ((com.huawei.b.a.a.a)paramIInterface).checkServiceStatus((Map)localObject3);
        localObject4 = paramJSONObject;
      }
      catch (Exception paramIInterface)
      {
        Log.e("MicroMsg.JsApiCheckTrafficCardConditions", "call remote interface fail: [%s] ! ", new Object[] { paramIInterface.getMessage() });
        localObject4 = localObject2;
        localObject5 = localObject1;
        paramIInterface = null;
        paramJSONObject = (JSONObject)localObject5;
        continue;
        int k = ((JSONObject)localObject4).optInt("resultCode");
        int m = paramIInterface.optInt("resultCode");
        int i = 0;
        if (!bool1) {
          continue;
        }
        i = paramJSONObject.optInt("resultCode");
        int j = 0;
        if (j >= 3) {
          continue;
        }
        int n = new int[] { k, i, m }[j];
        if (n == b.sxN.errorCode) {
          continue;
        }
        if (!bool2) {
          continue;
        }
        paramIInterface = b.Bb(n);
        paramJSONObject = paramIInterface;
        if (paramIInterface != b.syA) {
          continue;
        }
        paramJSONObject = b.syk;
        paramIInterface = new HashMap();
        paramIInterface.put("errCode", Integer.valueOf(paramJSONObject.errorCode));
        if (k != 0) {
          continue;
        }
        paramIInterface.put("data", ((JSONObject)localObject4).optJSONObject("data"));
        paramk.callback(paramInt, m("fail:" + paramJSONObject.errorMsg, paramIInterface));
        t(2, paramJSONObject.errorCode, paramJSONObject.errorMsg);
        Log.e("MicroMsg.JsApiCheckTrafficCardConditions", "Return code from huawei remote interface! with RetCode cplc[%s] issueConditions[%s] serviceStatus [%s] ", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m) });
        AppMethodBeat.o(325911);
        return;
        paramIInterface = b.Bc(n);
        continue;
        j += 1;
        continue;
        paramIInterface = new HashMap();
        paramIInterface.put("errCode", Integer.valueOf(b.sxN.errorCode));
        localObject1 = ((JSONObject)localObject4).optJSONObject("data");
        if ((!bool1) || (!paramJSONObject.has("data"))) {
          continue;
        }
        try
        {
          ((JSONObject)localObject1).put("customData", paramJSONObject.optJSONObject("data"));
          paramIInterface.put("data", localObject1);
          paramk.callback(paramInt, m(b.sxN.errorMsg, paramIInterface));
          t(2, b.sxN.errorCode, "");
          AppMethodBeat.o(325911);
          return;
        }
        catch (Exception paramJSONObject)
        {
          Log.e("MicroMsg.JsApiCheckTrafficCardConditions", "checkIssueConditions do not contains data: [%s] ! ", new Object[] { paramJSONObject.getMessage() });
          continue;
        }
        localObject3 = "";
        localObject4 = paramJSONObject;
        continue;
      }
      paramIInterface = localObject9;
      localObject1 = localObject6;
      localObject2 = localObject8;
      if (!TextUtils.isEmpty((CharSequence)localObject5))
      {
        localObject1 = localObject6;
        localObject2 = localObject8;
        paramIInterface = new JSONObject((String)localObject5);
      }
      paramJSONObject = localObject7;
      localObject1 = localObject6;
      localObject2 = paramIInterface;
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        localObject1 = localObject6;
        localObject2 = paramIInterface;
        paramJSONObject = new JSONObject((String)localObject4);
      }
      localObject1 = paramJSONObject;
      localObject2 = paramIInterface;
      localObject5 = paramJSONObject;
      localObject4 = paramIInterface;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        continue;
      }
      localObject1 = paramJSONObject;
      localObject2 = paramIInterface;
      localObject3 = new JSONObject((String)localObject3);
      localObject4 = paramIInterface;
      paramIInterface = (IInterface)localObject3;
      if ((localObject4 != null) && ((!bool1) || (paramJSONObject != null)) && (paramIInterface != null)) {
        continue;
      }
      paramIInterface = new HashMap();
      paramIInterface.put("errCode", Integer.valueOf(b.sxS.errorCode));
      paramk.callback(paramInt, m("fail:" + b.sxS.errorMsg, paramIInterface));
      t(2, b.sxS.errorCode, "call remote interface exception");
      Log.e("MicroMsg.JsApiCheckTrafficCardConditions", "call remote interface exception.");
      AppMethodBeat.o(325911);
      return;
      localObject1 = localObject6;
      localObject2 = localObject8;
      if (!(paramIInterface instanceof ITencentSmartcardOpenService)) {
        continue;
      }
      localObject1 = localObject6;
      localObject2 = localObject8;
      localObject5 = ((ITencentSmartcardOpenService)paramIInterface).queryCplc();
      if (bool1)
      {
        localObject1 = localObject6;
        localObject2 = localObject8;
        paramJSONObject = ((ITencentSmartcardOpenService)paramIInterface).checkIssueConditions((Map)localObject3);
        localObject1 = localObject6;
        localObject2 = localObject8;
        Log.i("MicroMsg.JsApiCheckTrafficCardConditions", "issueConditions: [%s]! ", new Object[] { paramJSONObject });
      }
      localObject1 = localObject6;
      localObject2 = localObject8;
      ((HashMap)localObject3).put("serviceID", localObject4);
      localObject1 = localObject6;
      localObject2 = localObject8;
      localObject3 = ((ITencentSmartcardOpenService)paramIInterface).checkServiceStatus((Map)localObject3);
      localObject4 = paramJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.c
 * JD-Core Version:    0.7.0.1
 */