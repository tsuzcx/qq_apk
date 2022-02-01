package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.12;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  extends h
{
  public static final int CTRL_INDEX = 516;
  public static final String NAME = "joinVoIPChat";
  private static String TAG = "MicroMsg.OpenVoice.JsApiCloudVoiceJoinVoIPChat";
  protected k kEC;
  protected l kED;
  protected n kEE;
  protected m kEF;
  protected c.a kEG;
  protected o kEH;
  protected volatile boolean kEI;
  protected long kEJ;
  protected int kEK;
  protected String mAppId;
  
  public c()
  {
    AppMethodBeat.i(46680);
    this.kEC = new k();
    this.kED = new l();
    this.kEE = new n();
    this.kEF = new m();
    this.kEG = null;
    this.kEH = new o();
    this.kEI = false;
    this.mAppId = "";
    this.kEJ = -1L;
    this.kEK = 0;
    com.tencent.mm.plugin.appbrand.permission.c.Qk("joinVoIPChat");
    AppMethodBeat.o(46680);
  }
  
  protected static Map<String, Object> B(ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> paramArrayList)
  {
    AppMethodBeat.i(186722);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    if (!bs.gY(paramArrayList))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localArrayList.add(((com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b)paramArrayList.next()).openId);
      }
    }
    localHashMap.put("openIdList", localArrayList);
    AppMethodBeat.o(186722);
    return localHashMap;
  }
  
  protected static void b(Map<String, Object> paramMap, int paramInt)
  {
    AppMethodBeat.i(186724);
    paramMap.put("errCode", Integer.valueOf(paramInt));
    AppMethodBeat.o(186724);
  }
  
  protected static Map<String, Object> d(HashMap<String, LinkedList> paramHashMap)
  {
    AppMethodBeat.i(186723);
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
    AppMethodBeat.o(186723);
    return localHashMap;
  }
  
  protected static int dQ(int paramInt1, int paramInt2)
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
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.z.c.b.c)paramc.getRuntime().as(com.tencent.mm.plugin.appbrand.jsapi.z.c.b.c.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.z.c.b.c)localObject).bma();
      if (!bs.isNullOrNil((String)localObject))
      {
        ac.e(TAG, "can not join voip chat now, message:%s", new Object[] { localObject });
        paramc.h(paramInt, "fail: can not join voip chat now");
        Toast.makeText(paramc.getContext(), (CharSequence)localObject, 0).show();
        AppMethodBeat.o(46681);
        return;
      }
    }
    this.mAppId = paramc.getAppId();
    b(paramc);
    localObject = paramc.getAppId();
    ac.i(TAG, "hy: appId:" + (String)localObject + ", params:" + paramJSONObject.toString());
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
      this.kEK = 0;
      this.kEJ = bs.Gn();
      if ((paramc.getRuntime() != null) && (paramc.getRuntime().CC())) {}
      for (int i = 0;; i = 1)
      {
        gl(false);
        paramJSONObject = com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.otZ;
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local1 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local2 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local3 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local4 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local5 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        ac.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger join room. %s, %s, %s, %d, %s", new Object[] { localObject, str1, str3, Integer.valueOf(j), str2 });
        paramJSONObject.ag(new p.12(paramJSONObject, (String)localObject, "wx766655dab8fe851b", str1, str3, j, i, k, m, n, str2, str4, local1, local2, local3, local4, local5));
        ac.i(TAG, "hy: JsApiCloudVoiceJoinVoIPChat callbackId:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(46681);
        return;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ac.printErrStackTrace(TAG, paramJSONObject, "handle join voice voip data exception", new Object[0]);
      paramc.h(paramInt, e("fail: param error!", null));
      AppMethodBeat.o(46681);
    }
  }
  
  protected final void b(final com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    AppMethodBeat.i(186721);
    if (this.kEG == null) {
      this.kEG = new c.a()
      {
        public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
        {
          AppMethodBeat.i(186720);
          ac.i(c.TAG, "hy: is1V1:%b, isIsVoIPTalking:%b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.otZ.ouB), Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.otZ.ouA) });
          if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.b.b.jqX) && (c.this.mAppId.equals(paramAnonymousString)))
          {
            ac.i(c.TAG, "hy: appbrand change to destroy");
            com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.otZ.a(new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {}, p.a.ovM);
            if ((paramc.getRuntime() != null) && (paramc.getRuntime().jdK != null)) {
              paramc.getRuntime().jdK.b(c.this.kEG);
            }
            p.MU(paramAnonymousString);
          }
          AppMethodBeat.o(186720);
        }
      };
    }
    if ((paramc.getRuntime() != null) && (paramc.getRuntime().jdK != null)) {
      paramc.getRuntime().jdK.a(this.kEG);
    }
    AppMethodBeat.o(186721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.c
 * JD-Core Version:    0.7.0.1
 */