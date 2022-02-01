package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class af
  extends ac
{
  public int dBA;
  public int dBB;
  public String dBy;
  public int dBz;
  public String uhB;
  public au ulN;
  public String ulO;
  public String ulw;
  public String una;
  public String unb;
  public int une;
  public String unf;
  public String ung;
  public int unh;
  public int unj;
  public String unk;
  public String unl;
  public int unm;
  public String unn;
  public String uno;
  public String unp;
  public String unq;
  public String unr;
  public long uns;
  
  public af(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(65281);
    this.unm = 1;
    this.unn = null;
    this.uno = null;
    this.unp = null;
    this.unq = null;
    this.unr = null;
    this.uns = 0L;
    this.dBy = paramString2;
    this.uhB = paramString1;
    this.unj = paramInt;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    if (!bs.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("way", String.valueOf(paramInt));
    localHashMap.put("channelId", "2");
    localHashMap.put("package", paramString3);
    g.agS();
    long l = ((Long)g.agR().agA().get(ah.a.GIA, Long.valueOf(0L))).longValue();
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
      g.agS();
      localHashMap.put("agreeDuty", (Integer)g.agR().agA().get(ah.a.GIB, Integer.valueOf(1)));
    }
  }
  
  public final int bVS()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65282);
    this.unk = paramJSONObject.optString("spidLogo");
    this.unl = paramJSONObject.optString("spidWishing");
    this.una = paramJSONObject.optString("spidName");
    this.unk = paramJSONObject.optString("spidLogo");
    this.dBA = paramJSONObject.optInt("hbStatus");
    this.dBB = paramJSONObject.optInt("receiveStatus");
    this.ulw = paramJSONObject.optString("statusMess");
    this.unb = paramJSONObject.optString("hintMess");
    this.ulO = paramJSONObject.optString("watermark");
    this.uhB = paramJSONObject.optString("sendId");
    this.une = paramJSONObject.optInt("focusFlag");
    this.unf = paramJSONObject.optString("focusWording");
    this.ung = paramJSONObject.optString("focusAppidUserName");
    this.unh = paramJSONObject.optInt("isFocus");
    this.dBz = paramJSONObject.optInt("hbType");
    paramString = paramJSONObject.optJSONObject("agree_duty");
    if (paramString != null)
    {
      this.unn = paramString.optString("agreed_flag", "-1");
      this.uno = paramString.optString("title", "");
      this.unp = paramString.optString("service_protocol_wording", "");
      this.unq = paramString.optString("service_protocol_url", "");
      this.unr = paramString.optString("button_wording", "");
      this.uns = paramString.optLong("delay_expired_time", 0L);
    }
    if (this.uns > 0L)
    {
      g.agS();
      g.agR().agA().set(ah.a.GIA, Long.valueOf(System.currentTimeMillis() + this.uns * 1000L));
    }
    this.ulN = x.aw(paramJSONObject.optJSONObject("operationTail"));
    AppMethodBeat.o(65282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.af
 * JD-Core Version:    0.7.0.1
 */