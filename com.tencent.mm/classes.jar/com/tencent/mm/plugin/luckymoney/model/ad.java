package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ad
  extends aa
{
  public String cMO;
  public int cMP;
  public int cMQ;
  public int cMR;
  public String ojA;
  public as onH;
  public String onI;
  public String onq;
  public String ooG;
  public String ooH;
  public int ooK;
  public String ooL;
  public String ooM;
  public int ooN;
  public int ooP;
  public String ooQ;
  public String ooR;
  public int ooS;
  public String ooT;
  public String ooU;
  public String ooV;
  public String ooW;
  public String ooX;
  public long ooY;
  
  public ad(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(42393);
    this.ooS = 1;
    this.ooT = null;
    this.ooU = null;
    this.ooV = null;
    this.ooW = null;
    this.ooX = null;
    this.ooY = 0L;
    this.cMO = paramString2;
    this.ojA = paramString1;
    this.ooP = paramInt;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    if (!bo.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("way", String.valueOf(paramInt));
    localHashMap.put("channelId", "2");
    localHashMap.put("package", paramString3);
    g.RM();
    long l = ((Long)g.RL().Ru().get(ac.a.yCp, Long.valueOf(0L))).longValue();
    if (l > 0L)
    {
      if (System.currentTimeMillis() >= l) {
        break label206;
      }
      localHashMap.put("agreeDuty", "0");
    }
    for (;;)
    {
      setRequestData(localHashMap);
      AppMethodBeat.o(42393);
      return;
      label206:
      paramString1 = new StringBuilder();
      g.RM();
      localHashMap.put("agreeDuty", (Integer)g.RL().Ru().get(ac.a.yCq, Integer.valueOf(1)));
    }
  }
  
  public final int bhH()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(42394);
    this.ooQ = paramJSONObject.optString("spidLogo");
    this.ooR = paramJSONObject.optString("spidWishing");
    this.ooG = paramJSONObject.optString("spidName");
    this.ooQ = paramJSONObject.optString("spidLogo");
    this.cMQ = paramJSONObject.optInt("hbStatus");
    this.cMR = paramJSONObject.optInt("receiveStatus");
    this.onq = paramJSONObject.optString("statusMess");
    this.ooH = paramJSONObject.optString("hintMess");
    this.onI = paramJSONObject.optString("watermark");
    this.ojA = paramJSONObject.optString("sendId");
    this.ooK = paramJSONObject.optInt("focusFlag");
    this.ooL = paramJSONObject.optString("focusWording");
    this.ooM = paramJSONObject.optString("focusAppidUserName");
    this.ooN = paramJSONObject.optInt("isFocus");
    this.cMP = paramJSONObject.optInt("hbType");
    paramString = paramJSONObject.optJSONObject("agree_duty");
    if (paramString != null)
    {
      this.ooT = paramString.optString("agreed_flag", "-1");
      this.ooU = paramString.optString("title", "");
      this.ooV = paramString.optString("service_protocol_wording", "");
      this.ooW = paramString.optString("service_protocol_url", "");
      this.ooX = paramString.optString("button_wording", "");
      this.ooY = paramString.optLong("delay_expired_time", 0L);
    }
    if (this.ooY > 0L)
    {
      g.RM();
      g.RL().Ru().set(ac.a.yCp, Long.valueOf(System.currentTimeMillis() + this.ooY * 1000L));
    }
    this.onH = v.ag(paramJSONObject.optJSONObject("operationTail"));
    AppMethodBeat.o(42394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ad
 * JD-Core Version:    0.7.0.1
 */