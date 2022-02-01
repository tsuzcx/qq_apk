package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q.26;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  extends c
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "join1v1VoIPChat";
  private static String TAG = "MicroMsg.OpenVoice.JsApiJoin1v1VoIPChat";
  
  public h()
  {
    AppMethodBeat.i(326334);
    com.tencent.mm.plugin.appbrand.permission.c.afo("join1v1VoIPChat");
    AppMethodBeat.o(326334);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(326339);
    if (paramJSONObject == null)
    {
      paramc.callback(paramInt, ZP("fail:data is null or nil"));
      AppMethodBeat.o(326339);
      return;
    }
    Object localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.al.c.b.c)paramc.getRuntime().aO(com.tencent.mm.plugin.appbrand.jsapi.al.c.b.c.class);
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.al.c.b.c)localObject1).cP(paramc.getAppId(), paramc.getRuntime().qsh.eul);
      if (!Util.isNullOrNil((String)localObject1))
      {
        Log.e(TAG, "can not join voip chat now, message:%s", new Object[] { localObject1 });
        paramJSONObject = new HashMap();
        c(paramJSONObject, fw(-10086, -7));
        paramc.callback(paramInt, m(String.format("fail: %d, %d, can not join voip chat now", new Object[] { Integer.valueOf(-10086), Integer.valueOf(-7) }), paramJSONObject));
        AppMethodBeat.o(326339);
        return;
      }
    }
    this.mAppId = paramc.getAppId();
    c(paramc);
    localObject1 = paramc.getAppId();
    Log.i(TAG, "hy: appId:" + (String)localObject1 + ", data:" + paramJSONObject.toString());
    try
    {
      long l = paramJSONObject.getLong("roomId");
      Log.i(TAG, "hy:roomId:".concat(String.valueOf(l)));
      int j = paramJSONObject.optInt("roomType", 2);
      int k = paramJSONObject.optInt("lifespan", 86400);
      String str1 = paramJSONObject.optString("sessionKey", "");
      String str2 = paramJSONObject.optString("privateData", "");
      Object localObject2 = paramJSONObject.getJSONObject("muteConfig");
      final boolean bool1 = ((JSONObject)localObject2).optBoolean("muteMicrophone");
      final boolean bool2 = ((JSONObject)localObject2).optBoolean("muteEarphone");
      final boolean bool3 = paramJSONObject.optBoolean("handsFree", false);
      this.snr = 0;
      this.snq = Util.currentTicks();
      if ((paramc.getRuntime() != null) && (paramc.getRuntime().aqJ())) {}
      for (int i = 0;; i = 1)
      {
        ja(false);
        paramJSONObject = q.wVc;
        localObject2 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b local2 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b local3 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b local4 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b local5 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b local6 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b() {};
        Log.i("MicroMsg.OpenVoice.OpenVoiceService", "jd: trigger join room. %s, %s, %d, %d, %d", new Object[] { localObject1, "wx766655dab8fe851b", Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j) });
        paramJSONObject.au(new q.26(paramJSONObject, (String)localObject1, "wx766655dab8fe851b", i, j, str2, l, str1, k, (com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b)localObject2, local2, local3, local4, local5, local6));
        Log.i(TAG, "hy: JsApiJoin1v1VoIPChat callbackId:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(326339);
        return;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace(TAG, paramJSONObject, "handle join voip 1v1 data exception", new Object[0]);
      paramc.callback(paramInt, ZP("fail: param error!"));
      this.snt = false;
      AppMethodBeat.o(326339);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.h
 * JD-Core Version:    0.7.0.1
 */