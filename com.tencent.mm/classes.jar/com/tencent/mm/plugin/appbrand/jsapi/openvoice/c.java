package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q.23;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q.a;
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
  protected l sni;
  protected m snj;
  protected p snk;
  protected n snl;
  protected o snm;
  protected c.a snn;
  protected q sno;
  protected volatile boolean snp;
  protected long snq;
  protected int snr;
  protected boolean snt;
  
  public c()
  {
    AppMethodBeat.i(46680);
    this.sni = new l();
    this.snj = new m();
    this.snk = new p();
    this.snl = new n();
    this.snm = new o();
    this.snn = null;
    this.sno = new q();
    this.snp = false;
    this.mAppId = "";
    this.snq = -1L;
    this.snr = 0;
    this.snt = false;
    com.tencent.mm.plugin.appbrand.permission.c.afo("joinVoIPChat");
    AppMethodBeat.o(46680);
  }
  
  protected static Map<String, Object> K(ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> paramArrayList)
  {
    AppMethodBeat.i(326340);
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
    AppMethodBeat.o(326340);
    return localHashMap;
  }
  
  public void a(final com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46681);
    if (paramJSONObject == null)
    {
      paramc.callback(paramInt, ZP("fail:data is null or nil"));
      AppMethodBeat.o(46681);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.al.c.b.c)paramc.getRuntime().aO(com.tencent.mm.plugin.appbrand.jsapi.al.c.b.c.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.al.c.b.c)localObject).cP(paramc.getAppId(), paramc.getRuntime().qsh.eul);
      if (!Util.isNullOrNil((String)localObject))
      {
        Log.e(TAG, "can not join voip chat now, message:%s", new Object[] { localObject });
        paramJSONObject = new HashMap();
        c(paramJSONObject, fw(-10086, -7));
        paramc.callback(paramInt, m(String.format("fail: %d, %d, can not join voip chat now", new Object[] { Integer.valueOf(-10086), Integer.valueOf(-7) }), paramJSONObject));
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
      this.snr = 0;
      this.snq = Util.currentTicks();
      if ((paramc.getRuntime() != null) && (paramc.getRuntime().aqJ())) {}
      for (int i = 0;; i = 1)
      {
        ja(false);
        paramJSONObject = com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q.wVc;
        com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b local1 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b local2 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b local3 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b local4 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b local5 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b local6 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b() {};
        Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger join room. %s, %s, %s, %d, %s", new Object[] { localObject, str1, str3, Integer.valueOf(j), str2 });
        paramJSONObject.au(new q.23(paramJSONObject, (String)localObject, "wx766655dab8fe851b", str1, str3, j, i, k, m, n, str2, str4, local1, local2, local3, local4, local5, local6));
        Log.i(TAG, "hy: JsApiCloudVoiceJoinVoIPChat callbackId:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(46681);
        return;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace(TAG, paramJSONObject, "handle join voice voip data exception", new Object[0]);
      paramc.callback(paramInt, ZP("fail: param error!"));
      this.snt = false;
      AppMethodBeat.o(46681);
    }
  }
  
  protected final void c(final com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    AppMethodBeat.i(326362);
    if (this.snn == null) {
      this.snn = new c.a()
      {
        public final void onRunningStateChanged(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
        {
          AppMethodBeat.i(326307);
          Log.i(c.TAG, "hy: is1V1:%b, isIsVoIPTalking:%b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q.wVc.wVF), Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q.wVc.wVE) });
          if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.b.b.qKz) && (c.this.mAppId.equals(paramAnonymousString)))
          {
            Log.i(c.TAG, "hy: appbrand change to destroy");
            com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q.wVc.a(new com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b() {}, q.a.wWS);
            if ((paramc.getRuntime() != null) && (paramc.getRuntime().qsB != null)) {
              paramc.getRuntime().qsB.b(c.this.snn);
            }
            r.abr(paramAnonymousString);
            AppMethodBeat.o(326307);
            return;
          }
          if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.b.b.qKx) && (c.this.mAppId.equals(paramAnonymousString)))
          {
            if (c.this.snt) {
              r.abq(c.this.mAppId);
            }
            c.this.snt = false;
          }
          AppMethodBeat.o(326307);
        }
      };
    }
    if ((paramc.getRuntime() != null) && (paramc.getRuntime().qsB != null)) {
      paramc.getRuntime().qsB.a(this.snn);
    }
    AppMethodBeat.o(326362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.c
 * JD-Core Version:    0.7.0.1
 */