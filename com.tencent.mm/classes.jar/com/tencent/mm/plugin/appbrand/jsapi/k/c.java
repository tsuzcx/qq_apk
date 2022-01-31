package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.1;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends g
{
  public static final int CTRL_INDEX = 516;
  public static final String NAME = "joinVoIPChat";
  private static String TAG = "MicroMsg.OpenVoice.JsApiCloudVoiceJoinVoIPChat";
  private int hVA;
  private h hVv;
  private i hVw;
  private j hVx;
  private c.a hVy;
  private long hVz;
  private String mAppId;
  
  public c()
  {
    AppMethodBeat.i(131391);
    this.hVv = new h();
    this.hVw = new i();
    this.hVx = new j();
    this.hVy = null;
    this.mAppId = "";
    this.hVz = -1L;
    this.hVA = 0;
    AppMethodBeat.o(131391);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(143425);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, j("fail:data is null or nil", null));
      AppMethodBeat.o(143425);
      return;
    }
    this.mAppId = paramc.getAppId();
    if (this.hVy == null) {
      this.hVy = new c.1(this);
    }
    paramc.getRuntime().gPL.a(this.hVy);
    try
    {
      String str1 = paramJSONObject.getString("signature");
      String str2 = paramJSONObject.getString("nonceStr");
      String str3 = paramJSONObject.getString("groupId");
      int j = paramJSONObject.getInt("timeStamp");
      int k = paramJSONObject.optInt("roomType", 2);
      int m = paramJSONObject.optInt("maxWidth", 480);
      int n = paramJSONObject.optInt("maxHeight", 640);
      paramJSONObject = paramJSONObject.getJSONObject("muteConfig");
      final boolean bool1 = paramJSONObject.optBoolean("muteMicrophone");
      final boolean bool2 = paramJSONObject.optBoolean("muteEarphone");
      paramJSONObject = paramc.getAppId();
      ab.i(TAG, "hy: appId:" + paramJSONObject + ",signature:" + str1 + ",nonceStr:" + str2 + ",groupId:" + str3 + ",muteMicroPhone:" + bool1 + ",muteEarPhone:" + bool2 + ",roomType:" + k + ",width:" + m + ",height:" + n);
      this.hVA = 0;
      this.hVz = bo.yB();
      ec(false);
      com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o localo = com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.kKN;
      if (paramc.getRuntime().vY()) {}
      for (int i = 0;; i = 1)
      {
        com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b local2 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b() {};
        c.3 local3 = new c.3(this, paramc);
        c.4 local4 = new c.4(this, paramc);
        c.5 local5 = new c.5(this, paramc);
        ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger join room. %s, %s, %s, %d, %s", new Object[] { paramJSONObject, str1, str3, Integer.valueOf(j), str2 });
        localo.O(new o.1(localo, paramJSONObject, "wx766655dab8fe851b", str1, str3, j, i, k, m, n, str2, local2, local3, local4, local5));
        ab.i(TAG, "hy: JsApiCloudVoiceJoinVoIPChat callbackId:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(143425);
        return;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ab.printErrStackTrace(TAG, paramJSONObject, "", new Object[0]);
      paramc.h(paramInt, j("fail: param error!", null));
      AppMethodBeat.o(143425);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.c
 * JD-Core Version:    0.7.0.1
 */