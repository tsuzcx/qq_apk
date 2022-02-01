package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class am
  extends aj
{
  public String EAP;
  public String EAQ;
  public int EAT;
  public String EAU;
  public String EAV;
  public int EAW;
  public int EAZ;
  public String EBa;
  public String EBb;
  public int EBc;
  public String EBd;
  public String EBe;
  public String EBf;
  public String EBg;
  public String EBh;
  public long EBi;
  public String EyY;
  public bh Ezp;
  public String Ezq;
  public String gbn;
  public int gbo;
  public int gbp;
  public int gbq;
  public String ybP;
  
  public am(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(65281);
    this.EBc = 1;
    this.EBd = null;
    this.EBe = null;
    this.EBf = null;
    this.EBg = null;
    this.EBh = null;
    this.EBi = 0L;
    this.gbn = paramString2;
    this.ybP = paramString1;
    this.EAZ = paramInt;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    if (!Util.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("way", String.valueOf(paramInt));
    localHashMap.put("channelId", "2");
    localHashMap.put("package", paramString3);
    h.aHH();
    long l = ((Long)h.aHG().aHp().get(ar.a.Vlr, Long.valueOf(0L))).longValue();
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
      h.aHH();
      localHashMap.put("agreeDuty", (Integer)h.aHG().aHp().get(ar.a.Vls, Integer.valueOf(1)));
    }
  }
  
  public final int cOe()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65282);
    this.EBa = paramJSONObject.optString("spidLogo");
    this.EBb = paramJSONObject.optString("spidWishing");
    this.EAP = paramJSONObject.optString("spidName");
    this.EBa = paramJSONObject.optString("spidLogo");
    this.gbp = paramJSONObject.optInt("hbStatus");
    this.gbq = paramJSONObject.optInt("receiveStatus");
    this.EyY = paramJSONObject.optString("statusMess");
    this.EAQ = paramJSONObject.optString("hintMess");
    this.Ezq = paramJSONObject.optString("watermark");
    this.ybP = paramJSONObject.optString("sendId");
    this.EAT = paramJSONObject.optInt("focusFlag");
    this.EAU = paramJSONObject.optString("focusWording");
    this.EAV = paramJSONObject.optString("focusAppidUserName");
    this.EAW = paramJSONObject.optInt("isFocus");
    this.gbo = paramJSONObject.optInt("hbType");
    paramString = paramJSONObject.optJSONObject("agree_duty");
    if (paramString != null)
    {
      this.EBd = paramString.optString("agreed_flag", "-1");
      this.EBe = paramString.optString("title", "");
      this.EBf = paramString.optString("service_protocol_wording", "");
      this.EBg = paramString.optString("service_protocol_url", "");
      this.EBh = paramString.optString("button_wording", "");
      this.EBi = paramString.optLong("delay_expired_time", 0L);
    }
    if (this.EBi > 0L)
    {
      h.aHH();
      h.aHG().aHp().set(ar.a.Vlr, Long.valueOf(System.currentTimeMillis() + this.EBi * 1000L));
    }
    this.Ezp = ad.bh(paramJSONObject.optJSONObject("operationTail"));
    AppMethodBeat.o(65282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.am
 * JD-Core Version:    0.7.0.1
 */