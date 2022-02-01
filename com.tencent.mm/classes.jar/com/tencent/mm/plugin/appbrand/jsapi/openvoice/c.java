package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.22;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends i
{
  public static final int CTRL_INDEX = 516;
  public static final String NAME = "joinVoIPChat";
  private static String TAG = "MicroMsg.OpenVoice.JsApiCloudVoiceJoinVoIPChat";
  protected String mAppId;
  protected l mjN;
  protected m mjO;
  protected o mjP;
  protected n mjQ;
  protected c.a mjR;
  protected p mjS;
  protected volatile boolean mjT;
  protected long mjU;
  protected int mjV;
  protected boolean mjW;
  
  public c()
  {
    AppMethodBeat.i(46680);
    this.mjN = new l();
    this.mjO = new m();
    this.mjP = new o();
    this.mjQ = new n();
    this.mjR = null;
    this.mjS = new p();
    this.mjT = false;
    this.mAppId = "";
    this.mjU = -1L;
    this.mjV = 0;
    this.mjW = false;
    com.tencent.mm.plugin.appbrand.permission.c.aem("joinVoIPChat");
    AppMethodBeat.o(46680);
  }
  
  protected static Map<String, Object> F(ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> paramArrayList)
  {
    AppMethodBeat.i(226925);
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
    AppMethodBeat.o(226925);
    return localHashMap;
  }
  
  protected static void b(Map<String, Object> paramMap, int paramInt)
  {
    AppMethodBeat.i(226927);
    paramMap.put("errCode", Integer.valueOf(paramInt));
    AppMethodBeat.o(226927);
  }
  
  protected static Map<String, Object> e(HashMap<String, LinkedList> paramHashMap)
  {
    AppMethodBeat.i(226926);
    HashMap localHashMap = new HashMap();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (LinkedList)((Map.Entry)localObject).getValue();
      if ((str != null) && (localObject != null)) {
        localHashMap.put(str, new ArrayList((Collection)localObject));
      }
    }
    AppMethodBeat.o(226926);
    return localHashMap;
  }
  
  protected static int ee(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return 0;
    }
    if ((paramInt1 != -10086) && (paramInt1 != -10087)) {
      return -1000;
    }
    switch (paramInt2)
    {
    case 0: 
    default: 
      return -1000;
    case -9: 
      return -3;
    case -1: 
      return -1;
    }
    return -2;
  }
  
  public void a(final com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46681);
    if (paramJSONObject == null)
    {
      paramc.i(paramInt, h("fail:data is null or nil", null));
      AppMethodBeat.o(46681);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.c)paramc.getRuntime().aw(com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.c.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.c)localObject).bMg();
      if (!Util.isNullOrNil((String)localObject))
      {
        Log.e(TAG, "can not join voip chat now, message:%s", new Object[] { localObject });
        paramJSONObject = new HashMap();
        b(paramJSONObject, ee(-10086, -7));
        paramc.i(paramInt, n(String.format("fail: %d, %d, can not join voip chat now", new Object[] { Integer.valueOf(-10086), Integer.valueOf(-7) }), paramJSONObject));
        AppMethodBeat.o(46681);
        return;
      }
    }
    this.mAppId = paramc.getAppId();
    b(paramc);
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
      this.mjV = 0;
      this.mjU = Util.currentTicks();
      if ((paramc.getRuntime() != null) && (paramc.getRuntime().NA())) {}
      for (int i = 0;; i = 1)
      {
        hl(false);
        paramJSONObject = com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.qta;
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local1 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local2 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local3 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local4 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local5 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.m.czc();
        Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger join room. %s, %s, %s, %d, %s", new Object[] { localObject, str1, str3, Integer.valueOf(j), str2 });
        paramJSONObject.aj(new q.22(paramJSONObject, (String)localObject, "wx766655dab8fe851b", str1, str3, j, i, k, m, n, str2, str4, local1, local2, local3, local4, local5));
        Log.i(TAG, "hy: JsApiCloudVoiceJoinVoIPChat callbackId:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(46681);
        return;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace(TAG, paramJSONObject, "handle join voice voip data exception", new Object[0]);
      paramc.i(paramInt, h("fail: param error!", null));
      this.mjW = false;
      AppMethodBeat.o(46681);
    }
  }
  
  protected final void b(final com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    AppMethodBeat.i(226924);
    if (this.mjR == null) {
      this.mjR = new c.a()
      {
        public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
        {
          AppMethodBeat.i(226923);
          Log.i(c.TAG, "hy: is1V1:%b, isIsVoIPTalking:%b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.qta.qtC), Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.qta.qtB) });
          if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.kQK) && (c.this.mAppId.equals(paramAnonymousString)))
          {
            Log.i(c.TAG, "hy: appbrand change to destroy");
            com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.qta.a(new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {}, q.a.quP);
            if ((paramc.getRuntime() != null) && (paramc.getRuntime().kAH != null)) {
              paramc.getRuntime().kAH.b(c.this.mjR);
            }
            q.aaC(paramAnonymousString);
            AppMethodBeat.o(226923);
            return;
          }
          if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.kQI) && (c.this.mAppId.equals(paramAnonymousString)))
          {
            if (c.this.mjW) {
              q.aaB(c.this.mAppId);
            }
            c.this.mjW = false;
          }
          AppMethodBeat.o(226923);
        }
      };
    }
    if ((paramc.getRuntime() != null) && (paramc.getRuntime().kAH != null)) {
      paramc.getRuntime().kAH.a(this.mjR);
    }
    AppMethodBeat.o(226924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.c
 * JD-Core Version:    0.7.0.1
 */