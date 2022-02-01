package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class al
  extends ai
{
  public String egX;
  public int egY;
  public int egZ;
  public int eha;
  public String yQE;
  public String yVb;
  public bg yVs;
  public String yVt;
  public String yWL;
  public String yWM;
  public int yWP;
  public String yWQ;
  public String yWR;
  public int yWS;
  public int yWU;
  public String yWV;
  public String yWW;
  public int yWX;
  public String yWY;
  public String yWZ;
  public String yXa;
  public String yXb;
  public String yXc;
  public long yXd;
  
  public al(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(65281);
    this.yWX = 1;
    this.yWY = null;
    this.yWZ = null;
    this.yXa = null;
    this.yXb = null;
    this.yXc = null;
    this.yXd = 0L;
    this.egX = paramString2;
    this.yQE = paramString1;
    this.yWU = paramInt;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    if (!Util.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("way", String.valueOf(paramInt));
    localHashMap.put("channelId", "2");
    localHashMap.put("package", paramString3);
    g.aAi();
    long l = ((Long)g.aAh().azQ().get(ar.a.NXr, Long.valueOf(0L))).longValue();
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
      g.aAi();
      localHashMap.put("agreeDuty", (Integer)g.aAh().azQ().get(ar.a.NXs, Integer.valueOf(1)));
    }
  }
  
  public final int czE()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65282);
    this.yWV = paramJSONObject.optString("spidLogo");
    this.yWW = paramJSONObject.optString("spidWishing");
    this.yWL = paramJSONObject.optString("spidName");
    this.yWV = paramJSONObject.optString("spidLogo");
    this.egZ = paramJSONObject.optInt("hbStatus");
    this.eha = paramJSONObject.optInt("receiveStatus");
    this.yVb = paramJSONObject.optString("statusMess");
    this.yWM = paramJSONObject.optString("hintMess");
    this.yVt = paramJSONObject.optString("watermark");
    this.yQE = paramJSONObject.optString("sendId");
    this.yWP = paramJSONObject.optInt("focusFlag");
    this.yWQ = paramJSONObject.optString("focusWording");
    this.yWR = paramJSONObject.optString("focusAppidUserName");
    this.yWS = paramJSONObject.optInt("isFocus");
    this.egY = paramJSONObject.optInt("hbType");
    paramString = paramJSONObject.optJSONObject("agree_duty");
    if (paramString != null)
    {
      this.yWY = paramString.optString("agreed_flag", "-1");
      this.yWZ = paramString.optString("title", "");
      this.yXa = paramString.optString("service_protocol_wording", "");
      this.yXb = paramString.optString("service_protocol_url", "");
      this.yXc = paramString.optString("button_wording", "");
      this.yXd = paramString.optLong("delay_expired_time", 0L);
    }
    if (this.yXd > 0L)
    {
      g.aAi();
      g.aAh().azQ().set(ar.a.NXr, Long.valueOf(System.currentTimeMillis() + this.yXd * 1000L));
    }
    this.yVs = ac.ba(paramJSONObject.optJSONObject("operationTail"));
    AppMethodBeat.o(65282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.al
 * JD-Core Version:    0.7.0.1
 */