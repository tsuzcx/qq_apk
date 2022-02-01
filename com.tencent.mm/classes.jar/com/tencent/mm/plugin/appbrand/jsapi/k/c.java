package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.o.12;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.o.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends g
{
  public static final int CTRL_INDEX = 516;
  public static final String NAME = "joinVoIPChat";
  private static String TAG = "MicroMsg.OpenVoice.JsApiCloudVoiceJoinVoIPChat";
  private i kdP;
  private j kdQ;
  private l kdR;
  private k kdS;
  private c.a kdT;
  private long kdU;
  private int kdV;
  private String mAppId;
  
  public c()
  {
    AppMethodBeat.i(46680);
    this.kdP = new i();
    this.kdQ = new j();
    this.kdR = new l();
    this.kdS = new k();
    this.kdT = null;
    this.mAppId = "";
    this.kdU = -1L;
    this.kdV = 0;
    com.tencent.mm.plugin.appbrand.permission.c.Me("joinVoIPChat");
    AppMethodBeat.o(46680);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46681);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null or nil", null));
      AppMethodBeat.o(46681);
      return;
    }
    this.mAppId = paramc.getAppId();
    if (this.kdT == null) {
      this.kdT = new c.a()
      {
        public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
        {
          AppMethodBeat.i(46675);
          if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.b.b.iQL) && (c.a(c.this).equals(paramAnonymousString)))
          {
            ad.i(c.TAG, "hy: appbrand change to background");
            c.this.fP(false);
            com.tencent.mm.plugin.cloudvoip.cloudvoice.d.o.nQO.a(new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {}, o.a.nSt);
          }
          AppMethodBeat.o(46675);
        }
      };
    }
    try
    {
      if ((paramc.getRuntime() != null) && (paramc.getRuntime().iDK != null)) {
        paramc.getRuntime().iDK.a(this.kdT);
      }
      String str1 = paramJSONObject.getString("signature");
      String str2 = paramJSONObject.getString("nonceStr");
      String str3 = paramJSONObject.getString("groupId");
      int j = paramJSONObject.getInt("timeStamp");
      int k = paramJSONObject.optInt("roomType", 2);
      int m = paramJSONObject.optInt("maxWidth", 480);
      int n = paramJSONObject.optInt("maxHeight", 640);
      String str4 = paramJSONObject.optString("privateData", "");
      Object localObject = paramJSONObject.getJSONObject("muteConfig");
      final boolean bool1 = ((JSONObject)localObject).optBoolean("muteMicrophone");
      final boolean bool2 = ((JSONObject)localObject).optBoolean("muteEarphone");
      localObject = paramc.getAppId();
      ad.i(TAG, "hy: appId:" + (String)localObject + ", parmas:" + paramJSONObject.toString());
      this.kdV = 0;
      this.kdU = bt.GC();
      if ((paramc.getRuntime() != null) && (paramc.getRuntime().CZ())) {}
      for (int i = 0;; i = 1)
      {
        fP(false);
        paramJSONObject = com.tencent.mm.plugin.cloudvoip.cloudvoice.d.o.nQO;
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local2 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local3 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local4 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local5 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local6 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger join room. %s, %s, %s, %d, %s", new Object[] { localObject, str1, str3, Integer.valueOf(j), str2 });
        paramJSONObject.ae(new o.12(paramJSONObject, (String)localObject, "wx766655dab8fe851b", str1, str3, j, i, k, m, n, str2, str4, local2, local3, local4, local5, local6));
        ad.i(TAG, "hy: JsApiCloudVoiceJoinVoIPChat callbackId:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(46681);
        return;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ad.printErrStackTrace(TAG, paramJSONObject, "", new Object[0]);
      paramc.h(paramInt, e("fail: param error!", null));
      AppMethodBeat.o(46681);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.c
 * JD-Core Version:    0.7.0.1
 */