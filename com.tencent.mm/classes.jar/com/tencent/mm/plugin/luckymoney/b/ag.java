package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ag
  extends ab
{
  long bIt;
  public int bvj;
  public String ceb;
  public int cec;
  public int ced;
  public String dQp;
  public String lLm;
  public String lMg;
  public String lNs;
  public int lPR;
  public String lPS;
  public String lPV;
  public int lQd;
  public ai lQj;
  public String lQk;
  public String lQp;
  public String lRI;
  public long lRJ;
  public long lRK;
  public int lRL;
  public String lRM;
  public int lRd = 1;
  public String lRe = null;
  public String lRf = null;
  public String lRg = null;
  public String lRh = null;
  public String lRi = null;
  public long lRj = 0L;
  public int lRt = 0;
  public int msgType = 1;
  String talker;
  
  public ag(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    this.bvj = paramInt1;
    this.lMg = paramString1;
    this.ceb = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", "1");
    localHashMap.put("channelId", String.valueOf(paramInt1));
    localHashMap.put("sendId", paramString1);
    localHashMap.put("inWay", String.valueOf(paramInt2));
    localHashMap.put("ver", paramString3);
    g.DQ();
    long l = ((Long)g.DP().Dz().get(ac.a.usp, Long.valueOf(0L))).longValue();
    if (l > 0L)
    {
      if (System.currentTimeMillis() >= l) {
        break label221;
      }
      localHashMap.put("agreeDuty", "0");
    }
    for (;;)
    {
      if (!bk.bl(paramString2)) {
        localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
      }
      D(localHashMap);
      return;
      label221:
      paramString1 = new StringBuilder();
      g.DQ();
      localHashMap.put("agreeDuty", (Integer)g.DP().Dz().get(ac.a.usq, Integer.valueOf(1)));
    }
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.lRI = paramJSONObject.optString("sendNick");
    this.lPV = paramJSONObject.optString("sendHeadImg");
    this.cec = paramJSONObject.optInt("hbStatus");
    this.ced = paramJSONObject.optInt("receiveStatus");
    this.lPS = paramJSONObject.optString("statusMess");
    this.lLm = paramJSONObject.optString("wishing");
    this.lQd = paramJSONObject.optInt("isSender");
    this.lRJ = paramJSONObject.optLong("sceneAmount");
    this.lRK = paramJSONObject.optLong("sceneRecTimeStamp");
    this.lPR = paramJSONObject.optInt("hbType");
    this.lQk = paramJSONObject.optString("watermark");
    this.lNs = paramJSONObject.optString("externMess");
    this.lQp = paramJSONObject.optString("sendUserName");
    if ((!bk.bl(this.lQp)) && (bk.bl(this.lRI))) {
      this.lRI = ((b)g.r(b.class)).gV(this.lQp);
    }
    this.lQj = m.V(paramJSONObject.optJSONObject("operationTail"));
    this.lRt = paramJSONObject.optInt("scenePicSwitch");
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
    y.i("MicroMsg.NetSceneReceiveLuckyMoney", "scenePicSwitch:" + this.lRt);
    this.lRL = paramJSONObject.optInt("preStrainFlag", 1);
    y.i("MicroMsg.NetSceneReceiveLuckyMoney", "preStrainFlag:" + this.lRL);
    g.DQ();
    g.DP().Dz().c(ac.a.use, Integer.valueOf(this.lRL));
    this.lRM = paramJSONObject.optString("timingIdentifier");
    this.dQp = paramJSONObject.optString("effectResource");
  }
  
  public final String aEz()
  {
    return "/cgi-bin/mmpay-bin/receivewxhb";
  }
  
  public final boolean bfO()
  {
    return this.lQd == 1;
  }
  
  public final int getType()
  {
    return 1581;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.ag
 * JD-Core Version:    0.7.0.1
 */