package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class as
  extends am
{
  public int cSM;
  public String dPb;
  public int dPc;
  public int dPd;
  public int dPe;
  public String hBK;
  long msgId;
  public int msgType;
  String talker;
  public String vAE;
  public String vAh;
  public String vAk;
  public int vAs;
  public au vAy;
  public String vAz;
  public int vBX;
  public String vBY;
  public String vBZ;
  public int vCC;
  public String vCK;
  public long vCL;
  public long vCM;
  public int vCN;
  public int vCO;
  public String vCP;
  public aw vCQ;
  public String vCa;
  public String vCb;
  public String vCc;
  public long vCd;
  public String vCg;
  public int vCh;
  public int vCq;
  public String vvw;
  public String vwq;
  public String vxC;
  
  public as(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(65309);
    this.vBX = 1;
    this.vBY = null;
    this.vBZ = null;
    this.vCa = null;
    this.vCb = null;
    this.vCc = null;
    this.vCd = 0L;
    this.vCq = 0;
    this.vCC = 0;
    this.vCO = 0;
    this.msgType = 1;
    this.cSM = paramInt1;
    this.vwq = paramString1;
    this.dPb = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", "1");
    localHashMap.put("channelId", String.valueOf(paramInt1));
    localHashMap.put("sendId", paramString1);
    localHashMap.put("inWay", String.valueOf(paramInt2));
    localHashMap.put("ver", paramString3);
    g.ajS();
    long l = ((Long)g.ajR().ajA().get(am.a.IPq, Long.valueOf(0L))).longValue();
    if (l > 0L)
    {
      if (System.currentTimeMillis() >= l) {
        break label241;
      }
      localHashMap.put("agreeDuty", "0");
    }
    for (;;)
    {
      if (!bu.isNullOrNil(paramString2)) {
        localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
      }
      setRequestData(localHashMap);
      AppMethodBeat.o(65309);
      return;
      label241:
      paramString1 = new StringBuilder();
      g.ajS();
      localHashMap.put("agreeDuty", (Integer)g.ajR().ajA().get(am.a.IPr, Integer.valueOf(1)));
    }
  }
  
  public final String cbJ()
  {
    return "/cgi-bin/mmpay-bin/receivewxhb";
  }
  
  public final int getType()
  {
    return 1581;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65310);
    this.vCK = paramJSONObject.optString("sendNick");
    this.vAk = paramJSONObject.optString("sendHeadImg");
    this.dPd = paramJSONObject.optInt("hbStatus");
    this.dPe = paramJSONObject.optInt("receiveStatus");
    this.vAh = paramJSONObject.optString("statusMess");
    this.vvw = paramJSONObject.optString("wishing");
    this.vAs = paramJSONObject.optInt("isSender");
    this.vCL = paramJSONObject.optLong("sceneAmount");
    this.vCM = paramJSONObject.optLong("sceneRecTimeStamp");
    this.dPc = paramJSONObject.optInt("hbType");
    this.vAz = paramJSONObject.optString("watermark");
    this.vxC = paramJSONObject.optString("externMess");
    this.vAE = paramJSONObject.optString("sendUserName");
    if ((!bu.isNullOrNil(this.vAE)) && (bu.isNullOrNil(this.vCK))) {
      this.vCK = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zP(this.vAE);
    }
    this.vAy = x.aF(paramJSONObject.optJSONObject("operationTail"));
    this.vCq = paramJSONObject.optInt("scenePicSwitch");
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
    ae.i("MicroMsg.NetSceneReceiveLuckyMoney", "scenePicSwitch:" + this.vCq);
    this.vCN = paramJSONObject.optInt("preStrainFlag", 1);
    ae.i("MicroMsg.NetSceneReceiveLuckyMoney", "preStrainFlag:" + this.vCN);
    this.vCC = paramJSONObject.optInt("showYearExpression");
    ae.i("MicroMsg.NetSceneReceiveLuckyMoney", "showYearExpression:%s", new Object[] { Integer.valueOf(this.vCC) });
    this.vCO = paramJSONObject.optInt("showRecNormalExpression");
    ae.i("MicroMsg.NetSceneReceiveLuckyMoney", "showRecNormalExpression:%s", new Object[] { Integer.valueOf(this.vCO) });
    g.ajS();
    g.ajR().ajA().set(am.a.IPf, Integer.valueOf(this.vCN));
    this.vCP = paramJSONObject.optString("timingIdentifier");
    this.hBK = paramJSONObject.optString("effectResource");
    this.vCg = paramJSONObject.optString("expression_md5");
    this.vCh = paramJSONObject.optInt("expression_type");
    ae.i("MicroMsg.NetSceneReceiveLuckyMoney", "expressionmd5:%s expressiontype:%s", new Object[] { this.vCg, Integer.valueOf(this.vCh) });
    paramJSONObject = paramJSONObject.optJSONObject("showSourceRec");
    if (paramJSONObject == null) {
      paramString = null;
    }
    for (;;)
    {
      this.vCQ = paramString;
      g.ajS();
      paramInt = ((Integer)g.ajR().ajA().get(am.a.Jae, Integer.valueOf(0))).intValue();
      int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDX, 0);
      if ((bu.jB(paramInt, 1)) || (bu.jB(i, 1)))
      {
        this.vCO = 1;
        this.vCC = 1;
      }
      ae.i("MicroMsg.NetSceneReceiveLuckyMoney", "localSwitch() showRecNormalExpression:%s showYearExpression:%s", new Object[] { Integer.valueOf(this.vCO), Integer.valueOf(this.vCC) });
      AppMethodBeat.o(65310);
      return;
      paramString = new aw();
      paramString.vCU = x.aG(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.as
 * JD-Core Version:    0.7.0.1
 */