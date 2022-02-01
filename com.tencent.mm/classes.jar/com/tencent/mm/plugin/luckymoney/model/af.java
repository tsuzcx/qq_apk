package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class af
  extends ac
{
  public String dPb;
  public int dPc;
  public int dPd;
  public int dPe;
  public String vAh;
  public au vAy;
  public String vAz;
  public String vBL;
  public String vBM;
  public int vBP;
  public String vBQ;
  public String vBR;
  public int vBS;
  public int vBU;
  public String vBV;
  public String vBW;
  public int vBX;
  public String vBY;
  public String vBZ;
  public String vCa;
  public String vCb;
  public String vCc;
  public long vCd;
  public String vwq;
  
  public af(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(65281);
    this.vBX = 1;
    this.vBY = null;
    this.vBZ = null;
    this.vCa = null;
    this.vCb = null;
    this.vCc = null;
    this.vCd = 0L;
    this.dPb = paramString2;
    this.vwq = paramString1;
    this.vBU = paramInt;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    if (!bu.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("way", String.valueOf(paramInt));
    localHashMap.put("channelId", "2");
    localHashMap.put("package", paramString3);
    g.ajS();
    long l = ((Long)g.ajR().ajA().get(am.a.IPq, Long.valueOf(0L))).longValue();
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
      AppMethodBeat.o(65281);
      return;
      label206:
      paramString1 = new StringBuilder();
      g.ajS();
      localHashMap.put("agreeDuty", (Integer)g.ajR().ajA().get(am.a.IPr, Integer.valueOf(1)));
    }
  }
  
  public final int cbK()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65282);
    this.vBV = paramJSONObject.optString("spidLogo");
    this.vBW = paramJSONObject.optString("spidWishing");
    this.vBL = paramJSONObject.optString("spidName");
    this.vBV = paramJSONObject.optString("spidLogo");
    this.dPd = paramJSONObject.optInt("hbStatus");
    this.dPe = paramJSONObject.optInt("receiveStatus");
    this.vAh = paramJSONObject.optString("statusMess");
    this.vBM = paramJSONObject.optString("hintMess");
    this.vAz = paramJSONObject.optString("watermark");
    this.vwq = paramJSONObject.optString("sendId");
    this.vBP = paramJSONObject.optInt("focusFlag");
    this.vBQ = paramJSONObject.optString("focusWording");
    this.vBR = paramJSONObject.optString("focusAppidUserName");
    this.vBS = paramJSONObject.optInt("isFocus");
    this.dPc = paramJSONObject.optInt("hbType");
    paramString = paramJSONObject.optJSONObject("agree_duty");
    if (paramString != null)
    {
      this.vBY = paramString.optString("agreed_flag", "-1");
      this.vBZ = paramString.optString("title", "");
      this.vCa = paramString.optString("service_protocol_wording", "");
      this.vCb = paramString.optString("service_protocol_url", "");
      this.vCc = paramString.optString("button_wording", "");
      this.vCd = paramString.optLong("delay_expired_time", 0L);
    }
    if (this.vCd > 0L)
    {
      g.ajS();
      g.ajR().ajA().set(am.a.IPq, Long.valueOf(System.currentTimeMillis() + this.vCd * 1000L));
    }
    this.vAy = x.aF(paramJSONObject.optJSONObject("operationTail"));
    AppMethodBeat.o(65282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.af
 * JD-Core Version:    0.7.0.1
 */