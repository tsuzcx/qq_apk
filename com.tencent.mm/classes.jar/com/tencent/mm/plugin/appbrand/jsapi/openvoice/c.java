package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.23;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends i
{
  public static final int CTRL_INDEX = 516;
  public static final String NAME = "joinVoIPChat";
  private static String TAG = "MicroMsg.OpenVoice.JsApiCloudVoiceJoinVoIPChat";
  protected String mAppId;
  protected l phP;
  protected m phQ;
  protected p phR;
  protected n phS;
  protected o phT;
  protected c.a phU;
  protected q phV;
  protected volatile boolean phW;
  protected long phX;
  protected int phY;
  protected boolean phZ;
  
  public c()
  {
    AppMethodBeat.i(46680);
    this.phP = new l();
    this.phQ = new m();
    this.phR = new p();
    this.phS = new n();
    this.phT = new o();
    this.phU = null;
    this.phV = new q();
    this.phW = false;
    this.mAppId = "";
    this.phX = -1L;
    this.phY = 0;
    this.phZ = false;
    com.tencent.mm.plugin.appbrand.permission.c.amg("joinVoIPChat");
    AppMethodBeat.o(46680);
  }
  
  protected static Map<String, Object> G(ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> paramArrayList)
  {
    AppMethodBeat.i(266799);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    if (!Util.isNullOrNil(paramArrayList))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localArrayList.add(((com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b)paramArrayList.next()).openId);
      }
    }
    localHashMap.put("openIdList", localArrayList);
    AppMethodBeat.o(266799);
    return localHashMap;
  }
  
  public void a(final com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46681);
    if (paramJSONObject == null)
    {
      paramc.j(paramInt, h("fail:data is null or nil", null));
      AppMethodBeat.o(46681);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.ai.c.b.c)paramc.getRuntime().av(com.tencent.mm.plugin.appbrand.jsapi.ai.c.b.c.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.ai.c.b.c)localObject).cp(paramc.getAppId(), paramc.getRuntime().ntz.cBI);
      if (!Util.isNullOrNil((String)localObject))
      {
        Log.e(TAG, "can not join voip chat now, message:%s", new Object[] { localObject });
        paramJSONObject = new HashMap();
        b(paramJSONObject, eC(-10086, -7));
        paramc.j(paramInt, m(String.format("fail: %d, %d, can not join voip chat now", new Object[] { Integer.valueOf(-10086), Integer.valueOf(-7) }), paramJSONObject));
        AppMethodBeat.o(46681);
        return;
      }
    }
    this.mAppId = paramc.getAppId();
    c(paramc);
    localObject = paramc.getAppId();
    Log.i(TAG, "hy: appId:" + (String)localObject + ", params:" + paramJSONObject.toString());
    try
    {
      String str1 = paramJSONObject.getString("signature");
      String str2 = paramJSONObject.getString("nonceStr");
      String str3 = paramJSONObject.getString("groupId");
      int j = paramJSONObject.getInt("timeStamp");
      int k = paramJSONObject.optInt("roomType", 2);
      int m = paramJSONObject.optInt("maxWidth", 480);
      int n = paramJSONObject.optInt("maxHeight", 640);
      String str4 = paramJSONObject.optString("privateData", "");
      paramJSONObject = paramJSONObject.getJSONObject("muteConfig");
      final boolean bool1 = paramJSONObject.optBoolean("muteMicrophone");
      final boolean bool2 = paramJSONObject.optBoolean("muteEarphone");
      this.phY = 0;
      this.phX = Util.currentTicks();
      if ((paramc.getRuntime() != null) && (paramc.getRuntime().Qv())) {}
      for (int i = 0;; i = 1)
      {
        ib(false);
        paramJSONObject = com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.tRM;
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local1 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local2 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local3 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local4 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local5 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local6 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger join room. %s, %s, %s, %d, %s", new Object[] { localObject, str1, str3, Integer.valueOf(j), str2 });
        paramJSONObject.am(new q.23(paramJSONObject, (String)localObject, "wx766655dab8fe851b", str1, str3, j, i, k, m, n, str2, str4, local1, local2, local3, local4, local5, local6));
        Log.i(TAG, "hy: JsApiCloudVoiceJoinVoIPChat callbackId:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(46681);
        return;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace(TAG, paramJSONObject, "handle join voice voip data exception", new Object[0]);
      paramc.j(paramInt, h("fail: param error!", null));
      this.phZ = false;
      AppMethodBeat.o(46681);
    }
  }
  
  protected final void c(final com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    AppMethodBeat.i(266797);
    if (this.phU == null) {
      this.phU = new c.a()
      {
        public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
        {
          AppMethodBeat.i(272789);
          Log.i(c.TAG, "hy: is1V1:%b, isIsVoIPTalking:%b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.tRM.tSo), Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.tRM.tSn) });
          if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.nKS) && (c.this.mAppId.equals(paramAnonymousString)))
          {
            Log.i(c.TAG, "hy: appbrand change to destroy");
            com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.tRM.a(new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {}, q.a.tTB);
            if ((paramc.getRuntime() != null) && (paramc.getRuntime().ntR != null)) {
              paramc.getRuntime().ntR.b(c.this.phU);
            }
            r.ait(paramAnonymousString);
            AppMethodBeat.o(272789);
            return;
          }
          if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.nKQ) && (c.this.mAppId.equals(paramAnonymousString)))
          {
            if (c.this.phZ) {
              r.ais(c.this.mAppId);
            }
            c.this.phZ = false;
          }
          AppMethodBeat.o(272789);
        }
      };
    }
    if ((paramc.getRuntime() != null) && (paramc.getRuntime().ntR != null)) {
      paramc.getRuntime().ntR.a(this.phU);
    }
    AppMethodBeat.o(266797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.c
 * JD-Core Version:    0.7.0.1
 */