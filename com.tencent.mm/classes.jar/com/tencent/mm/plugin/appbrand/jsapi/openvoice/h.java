package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.24;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.a;
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
    AppMethodBeat.i(279874);
    com.tencent.mm.plugin.appbrand.permission.c.amg("join1v1VoIPChat");
    AppMethodBeat.o(279874);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(279879);
    if (paramJSONObject == null)
    {
      paramc.j(paramInt, h("fail:data is null or nil", null));
      AppMethodBeat.o(279879);
      return;
    }
    Object localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.ai.c.b.c)paramc.getRuntime().av(com.tencent.mm.plugin.appbrand.jsapi.ai.c.b.c.class);
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.ai.c.b.c)localObject1).cp(paramc.getAppId(), paramc.getRuntime().ntz.cBI);
      if (!Util.isNullOrNil((String)localObject1))
      {
        Log.e(TAG, "can not join voip chat now, message:%s", new Object[] { localObject1 });
        paramJSONObject = new HashMap();
        b(paramJSONObject, eC(-10086, -7));
        paramc.j(paramInt, m(String.format("fail: %d, %d, can not join voip chat now", new Object[] { Integer.valueOf(-10086), Integer.valueOf(-7) }), paramJSONObject));
        AppMethodBeat.o(279879);
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
      this.phY = 0;
      this.phX = Util.currentTicks();
      if ((paramc.getRuntime() != null) && (paramc.getRuntime().Qv())) {}
      for (int i = 0;; i = 1)
      {
        ib(false);
        paramJSONObject = q.tRM;
        localObject2 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local2 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local3 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local4 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local5 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local6 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        Log.i("MicroMsg.OpenVoice.OpenVoiceService", "jd: trigger join room. %s, %s, %d, %d, %d", new Object[] { localObject1, "wx766655dab8fe851b", Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j) });
        paramJSONObject.am(new q.24(paramJSONObject, (String)localObject1, "wx766655dab8fe851b", i, j, str2, l, str1, k, (com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b)localObject2, local2, local3, local4, local5, local6));
        Log.i(TAG, "hy: JsApiJoin1v1VoIPChat callbackId:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(279879);
        return;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace(TAG, paramJSONObject, "handle join voip 1v1 data exception", new Object[0]);
      paramc.j(paramInt, h("fail: param error!", null));
      this.phZ = false;
      AppMethodBeat.o(279879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.h
 * JD-Core Version:    0.7.0.1
 */