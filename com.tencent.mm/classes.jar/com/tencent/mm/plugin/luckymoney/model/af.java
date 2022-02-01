package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class af
  extends ac
{
  public String dNL;
  public int dNM;
  public int dNN;
  public int dNO;
  public String vkl;
  public String voc;
  public au vot;
  public String vou;
  public String vpG;
  public String vpH;
  public int vpK;
  public String vpL;
  public String vpM;
  public int vpN;
  public int vpP;
  public String vpQ;
  public String vpR;
  public int vpS;
  public String vpT;
  public String vpU;
  public String vpV;
  public String vpW;
  public String vpX;
  public long vpY;
  
  public af(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(65281);
    this.vpS = 1;
    this.vpT = null;
    this.vpU = null;
    this.vpV = null;
    this.vpW = null;
    this.vpX = null;
    this.vpY = 0L;
    this.dNL = paramString2;
    this.vkl = paramString1;
    this.vpP = paramInt;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    if (!bt.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("way", String.valueOf(paramInt));
    localHashMap.put("channelId", "2");
    localHashMap.put("package", paramString3);
    g.ajD();
    long l = ((Long)g.ajC().ajl().get(al.a.IuS, Long.valueOf(0L))).longValue();
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
      g.ajD();
      localHashMap.put("agreeDuty", (Integer)g.ajC().ajl().get(al.a.IuT, Integer.valueOf(1)));
    }
  }
  
  public final int cav()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65282);
    this.vpQ = paramJSONObject.optString("spidLogo");
    this.vpR = paramJSONObject.optString("spidWishing");
    this.vpG = paramJSONObject.optString("spidName");
    this.vpQ = paramJSONObject.optString("spidLogo");
    this.dNN = paramJSONObject.optInt("hbStatus");
    this.dNO = paramJSONObject.optInt("receiveStatus");
    this.voc = paramJSONObject.optString("statusMess");
    this.vpH = paramJSONObject.optString("hintMess");
    this.vou = paramJSONObject.optString("watermark");
    this.vkl = paramJSONObject.optString("sendId");
    this.vpK = paramJSONObject.optInt("focusFlag");
    this.vpL = paramJSONObject.optString("focusWording");
    this.vpM = paramJSONObject.optString("focusAppidUserName");
    this.vpN = paramJSONObject.optInt("isFocus");
    this.dNM = paramJSONObject.optInt("hbType");
    paramString = paramJSONObject.optJSONObject("agree_duty");
    if (paramString != null)
    {
      this.vpT = paramString.optString("agreed_flag", "-1");
      this.vpU = paramString.optString("title", "");
      this.vpV = paramString.optString("service_protocol_wording", "");
      this.vpW = paramString.optString("service_protocol_url", "");
      this.vpX = paramString.optString("button_wording", "");
      this.vpY = paramString.optLong("delay_expired_time", 0L);
    }
    if (this.vpY > 0L)
    {
      g.ajD();
      g.ajC().ajl().set(al.a.IuS, Long.valueOf(System.currentTimeMillis() + this.vpY * 1000L));
    }
    this.vot = x.aF(paramJSONObject.optJSONObject("operationTail"));
    AppMethodBeat.o(65282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.af
 * JD-Core Version:    0.7.0.1
 */