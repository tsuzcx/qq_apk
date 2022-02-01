package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class an
  extends ak
{
  public String CAf;
  public String KrL;
  public j Ksa;
  public bi Ksc;
  public String Ksd;
  public String KtM;
  public String KtN;
  public int KtQ;
  public String KtR;
  public String KtS;
  public int KtT;
  public int KtW;
  public String KtX;
  public String KtY;
  public int KtZ;
  public String Kua;
  public String Kub;
  public String Kuc;
  public String Kud;
  public String Kue;
  public String Kuf;
  public long Kug;
  public int ihA;
  public String ihx;
  public int ihy;
  public int ihz;
  
  public an()
  {
    this.KtZ = 1;
    this.Kua = null;
    this.Kub = null;
    this.Kuc = null;
    this.Kud = null;
    this.Kue = null;
    this.Kuf = null;
    this.Kug = 0L;
  }
  
  public an(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(65281);
    this.KtZ = 1;
    this.Kua = null;
    this.Kub = null;
    this.Kuc = null;
    this.Kud = null;
    this.Kue = null;
    this.Kuf = null;
    this.Kug = 0L;
    Log.i("MicroMsg.NetSceneLuckyMoneyBusiBase", "sendId:%s nativeUrl:%s way:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    this.ihx = paramString2;
    this.CAf = paramString1;
    this.KtW = paramInt;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    if (!Util.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("way", String.valueOf(paramInt));
    localHashMap.put("channelId", "2");
    localHashMap.put("package", paramString3);
    h.baF();
    long l = ((Long)h.baE().ban().get(at.a.acML, Long.valueOf(0L))).longValue();
    if (l > 0L)
    {
      if (System.currentTimeMillis() >= l) {
        break label237;
      }
      localHashMap.put("agreeDuty", "0");
    }
    for (;;)
    {
      setRequestData(localHashMap);
      AppMethodBeat.o(65281);
      return;
      label237:
      paramString1 = new StringBuilder();
      h.baF();
      localHashMap.put("agreeDuty", (Integer)h.baE().ban().get(at.a.acMM, Integer.valueOf(1)));
    }
  }
  
  public final int drJ()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65282);
    Log.i("MicroMsg.NetSceneLuckyMoneyBusiBase", "errCode：%s errMsg：%s json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    this.Kuf = paramJSONObject.toString();
    this.KtX = paramJSONObject.optString("spidLogo");
    this.KtY = paramJSONObject.optString("spidWishing");
    this.KtM = paramJSONObject.optString("spidName");
    this.KtX = paramJSONObject.optString("spidLogo");
    this.ihz = paramJSONObject.optInt("hbStatus");
    this.ihA = paramJSONObject.optInt("receiveStatus");
    this.KrL = paramJSONObject.optString("statusMess");
    this.KtN = paramJSONObject.optString("hintMess");
    this.Ksd = paramJSONObject.optString("watermark");
    this.CAf = paramJSONObject.optString("sendId");
    this.KtQ = paramJSONObject.optInt("focusFlag");
    this.KtR = paramJSONObject.optString("focusWording");
    this.KtS = paramJSONObject.optString("focusAppidUserName");
    this.KtT = paramJSONObject.optInt("isFocus");
    this.ihy = paramJSONObject.optInt("hbType");
    this.Ksa = new j();
    paramString = paramJSONObject.optJSONObject("atomicFunc");
    if (paramString != null)
    {
      this.Ksa.lTH = paramString.optInt("enable");
      this.Ksa.Krr = paramString.optString("fissionContent");
      this.Ksa.Krq = paramString.optString("fissionUrl");
    }
    paramString = paramJSONObject.optJSONObject("agree_duty");
    if (paramString != null)
    {
      this.Kua = paramString.optString("agreed_flag", "-1");
      this.Kub = paramString.optString("title", "");
      this.Kuc = paramString.optString("service_protocol_wording", "");
      this.Kud = paramString.optString("service_protocol_url", "");
      this.Kue = paramString.optString("button_wording", "");
      this.Kug = paramString.optLong("delay_expired_time", 0L);
    }
    if (this.Kug > 0L)
    {
      h.baF();
      h.baE().ban().set(at.a.acML, Long.valueOf(System.currentTimeMillis() + this.Kug * 1000L));
    }
    this.Ksc = ae.bv(paramJSONObject.optJSONObject("operationTail"));
    AppMethodBeat.o(65282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.an
 * JD-Core Version:    0.7.0.1
 */