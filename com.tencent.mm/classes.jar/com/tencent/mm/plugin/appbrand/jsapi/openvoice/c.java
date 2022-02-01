package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.21;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  protected p leA;
  protected volatile boolean leB;
  protected long leC;
  protected int leD;
  protected boolean leE;
  protected l lev;
  protected m lew;
  protected o lex;
  protected n ley;
  protected c.a lez;
  protected String mAppId;
  
  public c()
  {
    AppMethodBeat.i(46680);
    this.lev = new l();
    this.lew = new m();
    this.lex = new o();
    this.ley = new n();
    this.lez = null;
    this.leA = new p();
    this.leB = false;
    this.mAppId = "";
    this.leC = -1L;
    this.leD = 0;
    this.leE = false;
    com.tencent.mm.plugin.appbrand.permission.c.Uy("joinVoIPChat");
    AppMethodBeat.o(46680);
  }
  
  protected static Map<String, Object> A(ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> paramArrayList)
  {
    AppMethodBeat.i(222616);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    if (!bu.ht(paramArrayList))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localArrayList.add(((com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b)paramArrayList.next()).openId);
      }
    }
    localHashMap.put("openIdList", localArrayList);
    AppMethodBeat.o(222616);
    return localHashMap;
  }
  
  protected static void b(Map<String, Object> paramMap, int paramInt)
  {
    AppMethodBeat.i(222618);
    paramMap.put("errCode", Integer.valueOf(paramInt));
    AppMethodBeat.o(222618);
  }
  
  protected static Map<String, Object> d(HashMap<String, LinkedList> paramHashMap)
  {
    AppMethodBeat.i(222617);
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
    AppMethodBeat.o(222617);
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
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.ad.c.b.c)paramc.getRuntime().as(com.tencent.mm.plugin.appbrand.jsapi.ad.c.b.c.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.ad.c.b.c)localObject).bqv();
      if (!bu.isNullOrNil((String)localObject))
      {
        ae.e(TAG, "can not join voip chat now, message:%s", new Object[] { localObject });
        paramc.h(paramInt, "fail: can not join voip chat now");
        Toast.makeText(paramc.getContext(), (CharSequence)localObject, 0).show();
        AppMethodBeat.o(46681);
        return;
      }
    }
    this.mAppId = paramc.getAppId();
    b(paramc);
    localObject = paramc.getAppId();
    ae.i(TAG, "hy: appId:" + (String)localObject + ", params:" + paramJSONObject.toString());
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
      this.leD = 0;
      this.leC = bu.HQ();
      if ((paramc.getRuntime() != null) && (paramc.getRuntime().Ee())) {}
      for (int i = 0;; i = 1)
      {
        go(false);
        paramJSONObject = com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.pdY;
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local1 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local2 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local3 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local4 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local5 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        ae.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger join room. %s, %s, %s, %d, %s", new Object[] { localObject, str1, str3, Integer.valueOf(j), str2 });
        paramJSONObject.ad(new p.21(paramJSONObject, (String)localObject, "wx766655dab8fe851b", str1, str3, j, i, k, m, n, str2, str4, local1, local2, local3, local4, local5));
        ae.i(TAG, "hy: JsApiCloudVoiceJoinVoIPChat callbackId:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(46681);
        return;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ae.printErrStackTrace(TAG, paramJSONObject, "handle join voice voip data exception", new Object[0]);
      paramc.h(paramInt, e("fail: param error!", null));
      this.leE = false;
      AppMethodBeat.o(46681);
    }
  }
  
  protected final void b(final com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    AppMethodBeat.i(222615);
    if (this.lez == null) {
      this.lez = new c.a()
      {
        public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
        {
          AppMethodBeat.i(222614);
          ae.i(c.TAG, "hy: is1V1:%b, isIsVoIPTalking:%b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.pdY.pez), Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.pdY.pey) });
          if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.jOd) && (c.this.mAppId.equals(paramAnonymousString)))
          {
            ae.i(c.TAG, "hy: appbrand change to destroy");
            com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.pdY.a(new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {}, p.a.pfL);
            if ((paramc.getRuntime() != null) && (paramc.getRuntime().jzQ != null)) {
              paramc.getRuntime().jzQ.b(c.this.lez);
            }
            q.Ra(paramAnonymousString);
            AppMethodBeat.o(222614);
            return;
          }
          if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.jOb) && (c.this.mAppId.equals(paramAnonymousString)))
          {
            if (c.this.leE) {
              q.QZ(c.this.mAppId);
            }
            c.this.leE = false;
          }
          AppMethodBeat.o(222614);
        }
      };
    }
    if ((paramc.getRuntime() != null) && (paramc.getRuntime().jzQ != null)) {
      paramc.getRuntime().jzQ.a(this.lez);
    }
    AppMethodBeat.o(222615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.c
 * JD-Core Version:    0.7.0.1
 */