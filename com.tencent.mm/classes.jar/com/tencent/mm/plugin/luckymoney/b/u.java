package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class u
  extends r
{
  public String ceb;
  public int cec;
  public int ced;
  public String lMg;
  public int lPR;
  public String lPS;
  public String lQR;
  public String lQS;
  public int lQV;
  public String lQW;
  public String lQX;
  public int lQY;
  public ai lQj;
  public String lQk;
  public int lRa;
  public String lRb;
  public String lRc;
  public int lRd = 1;
  public String lRe = null;
  public String lRf = null;
  public String lRg = null;
  public String lRh = null;
  public String lRi = null;
  public long lRj = 0L;
  
  public u(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.ceb = paramString2;
    this.lMg = paramString1;
    this.lRa = paramInt;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    if (!bk.bl(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("way", String.valueOf(paramInt));
    localHashMap.put("channelId", "2");
    localHashMap.put("package", paramString3);
    g.DQ();
    long l = ((Long)g.DP().Dz().get(ac.a.usp, Long.valueOf(0L))).longValue();
    if (l > 0L)
    {
      if (System.currentTimeMillis() >= l) {
        break label196;
      }
      localHashMap.put("agreeDuty", "0");
    }
    for (;;)
    {
      D(localHashMap);
      return;
      label196:
      paramString1 = new StringBuilder();
      g.DQ();
      localHashMap.put("agreeDuty", (Integer)g.DP().Dz().get(ac.a.usq, Integer.valueOf(1)));
    }
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.lRb = paramJSONObject.optString("spidLogo");
    this.lRc = paramJSONObject.optString("spidWishing");
    this.lQR = paramJSONObject.optString("spidName");
    this.lRb = paramJSONObject.optString("spidLogo");
    this.cec = paramJSONObject.optInt("hbStatus");
    this.ced = paramJSONObject.optInt("receiveStatus");
    this.lPS = paramJSONObject.optString("statusMess");
    this.lQS = paramJSONObject.optString("hintMess");
    this.lQk = paramJSONObject.optString("watermark");
    this.lMg = paramJSONObject.optString("sendId");
    this.lQV = paramJSONObject.optInt("focusFlag");
    this.lQW = paramJSONObject.optString("focusWording");
    this.lQX = paramJSONObject.optString("focusAppidUserName");
    this.lQY = paramJSONObject.optInt("isFocus");
    this.lPR = paramJSONObject.optInt("hbType");
    paramString = paramJSONObject.optJSONObject("agree_duty");
    if (paramString != null)
    {
      this.lRe = paramString.optString("agreed_flag", "-1");
      this.lRf = paramString.optString("title", "");
      this.lRg = paramString.optString("service_protocol_wording", "");
      this.lRh = paramString.optString("service_protocol_url", "");
      this.lRi = paramString.optString("button_wording", "");
      this.lRj = paramString.optLong("delay_expired_time", 0L);
    }
    if (this.lRj > 0L)
    {
      g.DQ();
      g.DP().Dz().c(ac.a.usp, Long.valueOf(System.currentTimeMillis() + this.lRj * 1000L));
    }
    this.lQj = m.V(paramJSONObject.optJSONObject("operationTail"));
  }
  
  public final int aEA()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.u
 * JD-Core Version:    0.7.0.1
 */