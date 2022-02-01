package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.21;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  protected l laM;
  protected m laN;
  protected o laO;
  protected n laP;
  protected c.a laQ;
  protected p laR;
  protected volatile boolean laS;
  protected long laT;
  protected int laU;
  protected String mAppId;
  
  public c()
  {
    AppMethodBeat.i(46680);
    this.laM = new l();
    this.laN = new m();
    this.laO = new o();
    this.laP = new n();
    this.laQ = null;
    this.laR = new p();
    this.laS = false;
    this.mAppId = "";
    this.laT = -1L;
    this.laU = 0;
    com.tencent.mm.plugin.appbrand.permission.c.TP("joinVoIPChat");
    AppMethodBeat.o(46680);
  }
  
  protected static Map<String, Object> A(ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> paramArrayList)
  {
    AppMethodBeat.i(188466);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    if (!bt.hj(paramArrayList))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localArrayList.add(((com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b)paramArrayList.next()).openId);
      }
    }
    localHashMap.put("openIdList", localArrayList);
    AppMethodBeat.o(188466);
    return localHashMap;
  }
  
  protected static void b(Map<String, Object> paramMap, int paramInt)
  {
    AppMethodBeat.i(188468);
    paramMap.put("errCode", Integer.valueOf(paramInt));
    AppMethodBeat.o(188468);
  }
  
  protected static Map<String, Object> d(HashMap<String, LinkedList> paramHashMap)
  {
    AppMethodBeat.i(188467);
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
    AppMethodBeat.o(188467);
    return localHashMap;
  }
  
  protected static int dS(int paramInt1, int paramInt2)
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
      paramc.h(paramInt, e("fail:data is null or nil", null));
      AppMethodBeat.o(46681);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.ac.c.b.c)paramc.getRuntime().as(com.tencent.mm.plugin.appbrand.jsapi.ac.c.b.c.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.ac.c.b.c)localObject).bpL();
      if (!bt.isNullOrNil((String)localObject))
      {
        ad.e(TAG, "can not join voip chat now, message:%s", new Object[] { localObject });
        paramc.h(paramInt, "fail: can not join voip chat now");
        Toast.makeText(paramc.getContext(), (CharSequence)localObject, 0).show();
        AppMethodBeat.o(46681);
        return;
      }
    }
    this.mAppId = paramc.getAppId();
    b(paramc);
    localObject = paramc.getAppId();
    ad.i(TAG, "hy: appId:" + (String)localObject + ", params:" + paramJSONObject.toString());
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
      this.laU = 0;
      this.laT = bt.HI();
      if ((paramc.getRuntime() != null) && (paramc.getRuntime().Eb())) {}
      for (int i = 0;; i = 1)
      {
        gq(false);
        paramJSONObject = com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.oXv;
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local1 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local2 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local3 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local4 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local5 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger join room. %s, %s, %s, %d, %s", new Object[] { localObject, str1, str3, Integer.valueOf(j), str2 });
        paramJSONObject.af(new p.21(paramJSONObject, (String)localObject, "wx766655dab8fe851b", str1, str3, j, i, k, m, n, str2, str4, local1, local2, local3, local4, local5));
        ad.i(TAG, "hy: JsApiCloudVoiceJoinVoIPChat callbackId:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(46681);
        return;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ad.printErrStackTrace(TAG, paramJSONObject, "handle join voice voip data exception", new Object[0]);
      paramc.h(paramInt, e("fail: param error!", null));
      AppMethodBeat.o(46681);
    }
  }
  
  protected final void b(final com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    AppMethodBeat.i(188465);
    if (this.laQ == null) {
      this.laQ = new c.a()
      {
        public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
        {
          AppMethodBeat.i(188464);
          ad.i(c.TAG, "hy: is1V1:%b, isIsVoIPTalking:%b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.oXv.oXW), Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.oXv.oXV) });
          if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.jKR) && (c.this.mAppId.equals(paramAnonymousString)))
          {
            ad.i(c.TAG, "hy: appbrand change to destroy");
            com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.oXv.a(new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {}, p.a.oZh);
            if ((paramc.getRuntime() != null) && (paramc.getRuntime().jwS != null)) {
              paramc.getRuntime().jwS.b(c.this.laQ);
            }
            q.Qr(paramAnonymousString);
          }
          AppMethodBeat.o(188464);
        }
      };
    }
    if ((paramc.getRuntime() != null) && (paramc.getRuntime().jwS != null)) {
      paramc.getRuntime().jwS.a(this.laQ);
    }
    AppMethodBeat.o(188465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.c
 * JD-Core Version:    0.7.0.1
 */