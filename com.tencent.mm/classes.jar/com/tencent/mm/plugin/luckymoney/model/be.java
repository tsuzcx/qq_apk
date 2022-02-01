package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class be
  extends aw
{
  public int EBI;
  public String EBR;
  public boolean EBS;
  public long EBT;
  public long EBU;
  public int EBV;
  public String EBW;
  public bj EBX;
  public int EBc;
  public String EBd;
  public String EBe;
  public String EBf;
  public String EBg;
  public String EBh;
  public long EBi;
  public String EBm;
  public int EBn;
  public int EBw;
  public String EtJ;
  public String EvN;
  public String EyY;
  public int Eyq;
  public int EzF;
  public String Ezb;
  public int Ezj;
  public bh Ezp;
  public String Ezq;
  public String Ezw;
  public int channelId;
  public String gbn;
  public int gbo;
  public int gbp;
  public int gbq;
  public String lld;
  long msgId;
  public int msgType;
  String talker;
  public String ybP;
  
  public be()
  {
    this.EBS = false;
    this.EBc = 1;
    this.EBd = null;
    this.EBe = null;
    this.EBf = null;
    this.EBg = null;
    this.EBh = null;
    this.EBi = 0L;
    this.EBw = 0;
    this.EBI = 0;
    this.Eyq = 0;
  }
  
  public be(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(232914);
    this.EBS = false;
    this.EBc = 1;
    this.EBd = null;
    this.EBe = null;
    this.EBf = null;
    this.EBg = null;
    this.EBh = null;
    this.EBi = 0L;
    this.EBw = 0;
    this.EBI = 0;
    this.Eyq = 0;
    this.msgType = 1;
    this.channelId = paramInt1;
    this.ybP = paramString1;
    this.gbn = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", "1");
    localHashMap.put("channelId", String.valueOf(paramInt1));
    localHashMap.put("sendId", paramString1);
    localHashMap.put("inWay", String.valueOf(paramInt2));
    localHashMap.put("ver", paramString3);
    h.aHH();
    long l = ((Long)h.aHG().aHp().get(ar.a.Vlr, Long.valueOf(0L))).longValue();
    if (l > 0L)
    {
      if (System.currentTimeMillis() >= l) {
        break label265;
      }
      localHashMap.put("agreeDuty", "0");
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString2)) {
        localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
      }
      localHashMap.put("group_name", paramString4);
      Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "NetSceneReceiveLuckyMoney request");
      setRequestData(localHashMap);
      AppMethodBeat.o(232914);
      return;
      label265:
      paramString1 = new StringBuilder();
      h.aHH();
      localHashMap.put("agreeDuty", (Integer)h.aHG().aHp().get(ar.a.Vls, Integer.valueOf(1)));
    }
  }
  
  public String cOd()
  {
    return "/cgi-bin/mmpay-bin/receivewxhb";
  }
  
  public final void eOI()
  {
    AppMethodBeat.i(232922);
    h.aHH();
    int i = ((Integer)h.aHG().aHp().get(ar.a.Vxa, Integer.valueOf(0))).intValue();
    int j = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDT, 0);
    if ((Util.isEqual(i, 1)) || (Util.isEqual(j, 1)))
    {
      this.Eyq = 1;
      this.EBI = 1;
    }
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "localSwitch() showRecNormalExpression:%s showYearExpression:%s", new Object[] { Integer.valueOf(this.Eyq), Integer.valueOf(this.EBI) });
    AppMethodBeat.o(232922);
  }
  
  public int getType()
  {
    return 1581;
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65310);
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    this.EBR = paramJSONObject.optString("sendNick");
    this.Ezb = paramJSONObject.optString("sendHeadImg");
    this.gbp = paramJSONObject.optInt("hbStatus");
    this.gbq = paramJSONObject.optInt("receiveStatus");
    this.EyY = paramJSONObject.optString("statusMess");
    this.EtJ = paramJSONObject.optString("wishing");
    this.Ezj = paramJSONObject.optInt("isSender");
    this.EBT = paramJSONObject.optLong("sceneAmount");
    this.EBU = paramJSONObject.optLong("sceneRecTimeStamp");
    this.gbo = paramJSONObject.optInt("hbType");
    this.Ezq = paramJSONObject.optString("watermark");
    this.EvN = paramJSONObject.optString("externMess");
    this.Ezw = paramJSONObject.optString("sendUserName");
    if (Util.isNullOrNil(this.EBR)) {
      this.EBS = true;
    }
    if ((!Util.isNullOrNil(this.Ezw)) && (Util.isNullOrNil(this.EBR))) {
      this.EBR = ((com.tencent.mm.plugin.messenger.a.b)h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(this.Ezw);
    }
    this.Ezp = ad.bh(paramJSONObject.optJSONObject("operationTail"));
    this.EBw = paramJSONObject.optInt("scenePicSwitch");
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
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "scenePicSwitch:" + this.EBw);
    this.EBV = paramJSONObject.optInt("preStrainFlag", 1);
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "preStrainFlag:" + this.EBV);
    this.EBI = paramJSONObject.optInt("showYearExpression");
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "showYearExpression:%s", new Object[] { Integer.valueOf(this.EBI) });
    this.Eyq = paramJSONObject.optInt("showRecNormalExpression");
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "showRecNormalExpression:%s", new Object[] { Integer.valueOf(this.Eyq) });
    h.aHH();
    h.aHG().aHp().set(ar.a.Vlg, Integer.valueOf(this.EBV));
    this.EBW = paramJSONObject.optString("timingIdentifier");
    this.lld = paramJSONObject.optString("effectResource");
    this.EBm = paramJSONObject.optString("expression_md5");
    this.EBn = paramJSONObject.optInt("expression_type");
    this.EzF = paramJSONObject.optInt("not_show_avatar", 0);
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "expressionmd5:%s expressiontype:%s", new Object[] { this.EBm, Integer.valueOf(this.EBn) });
    this.EBX = bj.bj(paramJSONObject.optJSONObject("showSourceRec"));
    eOI();
    AppMethodBeat.o(65310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.be
 * JD-Core Version:    0.7.0.1
 */