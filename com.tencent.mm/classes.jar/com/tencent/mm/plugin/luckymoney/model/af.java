package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class af
  extends ac
{
  public String dDM;
  public int dDN;
  public int dDO;
  public int dDP;
  public String sZn;
  public String tdh;
  public au tdy;
  public String tdz;
  public String teL;
  public String teM;
  public int teP;
  public String teQ;
  public String teR;
  public int teS;
  public int teU;
  public String teV;
  public String teW;
  public int teX;
  public String teY;
  public String teZ;
  public String tfa;
  public String tfb;
  public String tfc;
  public long tfd;
  
  public af(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(65281);
    this.teX = 1;
    this.teY = null;
    this.teZ = null;
    this.tfa = null;
    this.tfb = null;
    this.tfc = null;
    this.tfd = 0L;
    this.dDM = paramString2;
    this.sZn = paramString1;
    this.teU = paramInt;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    if (!bt.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("way", String.valueOf(paramInt));
    localHashMap.put("channelId", "2");
    localHashMap.put("package", paramString3);
    g.afC();
    long l = ((Long)g.afB().afk().get(ae.a.FkL, Long.valueOf(0L))).longValue();
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
      g.afC();
      localHashMap.put("agreeDuty", (Integer)g.afB().afk().get(ae.a.FkM, Integer.valueOf(1)));
    }
  }
  
  public final int bOC()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65282);
    this.teV = paramJSONObject.optString("spidLogo");
    this.teW = paramJSONObject.optString("spidWishing");
    this.teL = paramJSONObject.optString("spidName");
    this.teV = paramJSONObject.optString("spidLogo");
    this.dDO = paramJSONObject.optInt("hbStatus");
    this.dDP = paramJSONObject.optInt("receiveStatus");
    this.tdh = paramJSONObject.optString("statusMess");
    this.teM = paramJSONObject.optString("hintMess");
    this.tdz = paramJSONObject.optString("watermark");
    this.sZn = paramJSONObject.optString("sendId");
    this.teP = paramJSONObject.optInt("focusFlag");
    this.teQ = paramJSONObject.optString("focusWording");
    this.teR = paramJSONObject.optString("focusAppidUserName");
    this.teS = paramJSONObject.optInt("isFocus");
    this.dDN = paramJSONObject.optInt("hbType");
    paramString = paramJSONObject.optJSONObject("agree_duty");
    if (paramString != null)
    {
      this.teY = paramString.optString("agreed_flag", "-1");
      this.teZ = paramString.optString("title", "");
      this.tfa = paramString.optString("service_protocol_wording", "");
      this.tfb = paramString.optString("service_protocol_url", "");
      this.tfc = paramString.optString("button_wording", "");
      this.tfd = paramString.optLong("delay_expired_time", 0L);
    }
    if (this.tfd > 0L)
    {
      g.afC();
      g.afB().afk().set(ae.a.FkL, Long.valueOf(System.currentTimeMillis() + this.tfd * 1000L));
    }
    this.tdy = x.av(paramJSONObject.optJSONObject("operationTail"));
    AppMethodBeat.o(65282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.af
 * JD-Core Version:    0.7.0.1
 */