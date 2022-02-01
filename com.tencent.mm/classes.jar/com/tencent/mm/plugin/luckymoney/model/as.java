package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class as
  extends am
{
  public int cJR;
  public String dDM;
  public int dDN;
  public int dDO;
  public int dDP;
  public String gGm;
  long msgId;
  public int msgType;
  public String sYt;
  public String sZn;
  public String taA;
  String talker;
  public String tdE;
  public String tdh;
  public String tdk;
  public int tds;
  public au tdy;
  public String tdz;
  public int teX;
  public String teY;
  public String teZ;
  public int tfC;
  public String tfM;
  public long tfN;
  public long tfO;
  public int tfP;
  public int tfQ;
  public String tfR;
  public aw tfS;
  public String tfa;
  public String tfb;
  public String tfc;
  public long tfd;
  public String tfg;
  public int tfh;
  public int tfq;
  
  public as(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(65309);
    this.teX = 1;
    this.teY = null;
    this.teZ = null;
    this.tfa = null;
    this.tfb = null;
    this.tfc = null;
    this.tfd = 0L;
    this.tfq = 0;
    this.tfC = 0;
    this.tfQ = 0;
    this.msgType = 1;
    this.cJR = paramInt1;
    this.sZn = paramString1;
    this.dDM = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", "1");
    localHashMap.put("channelId", String.valueOf(paramInt1));
    localHashMap.put("sendId", paramString1);
    localHashMap.put("inWay", String.valueOf(paramInt2));
    localHashMap.put("ver", paramString3);
    g.afC();
    long l = ((Long)g.afB().afk().get(ae.a.FkL, Long.valueOf(0L))).longValue();
    if (l > 0L)
    {
      if (System.currentTimeMillis() >= l) {
        break label241;
      }
      localHashMap.put("agreeDuty", "0");
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramString2)) {
        localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
      }
      setRequestData(localHashMap);
      AppMethodBeat.o(65309);
      return;
      label241:
      paramString1 = new StringBuilder();
      g.afC();
      localHashMap.put("agreeDuty", (Integer)g.afB().afk().get(ae.a.FkM, Integer.valueOf(1)));
    }
  }
  
  public final String bOB()
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
    this.tfM = paramJSONObject.optString("sendNick");
    this.tdk = paramJSONObject.optString("sendHeadImg");
    this.dDO = paramJSONObject.optInt("hbStatus");
    this.dDP = paramJSONObject.optInt("receiveStatus");
    this.tdh = paramJSONObject.optString("statusMess");
    this.sYt = paramJSONObject.optString("wishing");
    this.tds = paramJSONObject.optInt("isSender");
    this.tfN = paramJSONObject.optLong("sceneAmount");
    this.tfO = paramJSONObject.optLong("sceneRecTimeStamp");
    this.dDN = paramJSONObject.optInt("hbType");
    this.tdz = paramJSONObject.optString("watermark");
    this.taA = paramJSONObject.optString("externMess");
    this.tdE = paramJSONObject.optString("sendUserName");
    if ((!bt.isNullOrNil(this.tdE)) && (bt.isNullOrNil(this.tfM))) {
      this.tfM = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh(this.tdE);
    }
    this.tdy = x.av(paramJSONObject.optJSONObject("operationTail"));
    this.tfq = paramJSONObject.optInt("scenePicSwitch");
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
    ad.i("MicroMsg.NetSceneReceiveLuckyMoney", "scenePicSwitch:" + this.tfq);
    this.tfP = paramJSONObject.optInt("preStrainFlag", 1);
    ad.i("MicroMsg.NetSceneReceiveLuckyMoney", "preStrainFlag:" + this.tfP);
    this.tfC = paramJSONObject.optInt("showYearExpression");
    ad.i("MicroMsg.NetSceneReceiveLuckyMoney", "showYearExpression:%s", new Object[] { Integer.valueOf(this.tfC) });
    this.tfQ = paramJSONObject.optInt("showRecNormalExpression");
    ad.i("MicroMsg.NetSceneReceiveLuckyMoney", "showRecNormalExpression:%s", new Object[] { Integer.valueOf(this.tfQ) });
    g.afC();
    g.afB().afk().set(ae.a.FkA, Integer.valueOf(this.tfP));
    this.tfR = paramJSONObject.optString("timingIdentifier");
    this.gGm = paramJSONObject.optString("effectResource");
    this.tfg = paramJSONObject.optString("expression_md5");
    this.tfh = paramJSONObject.optInt("expression_type");
    ad.i("MicroMsg.NetSceneReceiveLuckyMoney", "expressionmd5:%s expressiontype:%s", new Object[] { this.tfg, Integer.valueOf(this.tfh) });
    paramJSONObject = paramJSONObject.optJSONObject("showSourceRec");
    if (paramJSONObject == null) {
      paramString = null;
    }
    for (;;)
    {
      this.tfS = paramString;
      g.afC();
      paramInt = ((Integer)g.afB().afk().get(ae.a.Fvf, Integer.valueOf(0))).intValue();
      int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.poL, 0);
      if ((bt.iY(paramInt, 1)) || (bt.iY(i, 1)))
      {
        this.tfQ = 1;
        this.tfC = 1;
      }
      ad.i("MicroMsg.NetSceneReceiveLuckyMoney", "localSwitch() showRecNormalExpression:%s showYearExpression:%s", new Object[] { Integer.valueOf(this.tfQ), Integer.valueOf(this.tfC) });
      AppMethodBeat.o(65310);
      return;
      paramString = new aw();
      paramString.tfW = x.aw(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.as
 * JD-Core Version:    0.7.0.1
 */