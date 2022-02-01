package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class as
  extends am
{
  public int cSc;
  public String dNL;
  public int dNM;
  public int dNN;
  public int dNO;
  public String hyW;
  long msgId;
  public int msgType;
  String talker;
  public String vjr;
  public String vkl;
  public String vlx;
  public String voc;
  public String vof;
  public int von;
  public au vot;
  public String vou;
  public String voz;
  public int vpS;
  public String vpT;
  public String vpU;
  public String vpV;
  public String vpW;
  public String vpX;
  public long vpY;
  public String vqF;
  public long vqG;
  public long vqH;
  public int vqI;
  public int vqJ;
  public String vqK;
  public aw vqL;
  public String vqb;
  public int vqc;
  public int vql;
  public int vqx;
  
  public as(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(65309);
    this.vpS = 1;
    this.vpT = null;
    this.vpU = null;
    this.vpV = null;
    this.vpW = null;
    this.vpX = null;
    this.vpY = 0L;
    this.vql = 0;
    this.vqx = 0;
    this.vqJ = 0;
    this.msgType = 1;
    this.cSc = paramInt1;
    this.vkl = paramString1;
    this.dNL = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", "1");
    localHashMap.put("channelId", String.valueOf(paramInt1));
    localHashMap.put("sendId", paramString1);
    localHashMap.put("inWay", String.valueOf(paramInt2));
    localHashMap.put("ver", paramString3);
    g.ajD();
    long l = ((Long)g.ajC().ajl().get(al.a.IuS, Long.valueOf(0L))).longValue();
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
      g.ajD();
      localHashMap.put("agreeDuty", (Integer)g.ajC().ajl().get(al.a.IuT, Integer.valueOf(1)));
    }
  }
  
  public final String cau()
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
    this.vqF = paramJSONObject.optString("sendNick");
    this.vof = paramJSONObject.optString("sendHeadImg");
    this.dNN = paramJSONObject.optInt("hbStatus");
    this.dNO = paramJSONObject.optInt("receiveStatus");
    this.voc = paramJSONObject.optString("statusMess");
    this.vjr = paramJSONObject.optString("wishing");
    this.von = paramJSONObject.optInt("isSender");
    this.vqG = paramJSONObject.optLong("sceneAmount");
    this.vqH = paramJSONObject.optLong("sceneRecTimeStamp");
    this.dNM = paramJSONObject.optInt("hbType");
    this.vou = paramJSONObject.optString("watermark");
    this.vlx = paramJSONObject.optString("externMess");
    this.voz = paramJSONObject.optString("sendUserName");
    if ((!bt.isNullOrNil(this.voz)) && (bt.isNullOrNil(this.vqF))) {
      this.vqF = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf(this.voz);
    }
    this.vot = x.aF(paramJSONObject.optJSONObject("operationTail"));
    this.vql = paramJSONObject.optInt("scenePicSwitch");
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
    ad.i("MicroMsg.NetSceneReceiveLuckyMoney", "scenePicSwitch:" + this.vql);
    this.vqI = paramJSONObject.optInt("preStrainFlag", 1);
    ad.i("MicroMsg.NetSceneReceiveLuckyMoney", "preStrainFlag:" + this.vqI);
    this.vqx = paramJSONObject.optInt("showYearExpression");
    ad.i("MicroMsg.NetSceneReceiveLuckyMoney", "showYearExpression:%s", new Object[] { Integer.valueOf(this.vqx) });
    this.vqJ = paramJSONObject.optInt("showRecNormalExpression");
    ad.i("MicroMsg.NetSceneReceiveLuckyMoney", "showRecNormalExpression:%s", new Object[] { Integer.valueOf(this.vqJ) });
    g.ajD();
    g.ajC().ajl().set(al.a.IuH, Integer.valueOf(this.vqI));
    this.vqK = paramJSONObject.optString("timingIdentifier");
    this.hyW = paramJSONObject.optString("effectResource");
    this.vqb = paramJSONObject.optString("expression_md5");
    this.vqc = paramJSONObject.optInt("expression_type");
    ad.i("MicroMsg.NetSceneReceiveLuckyMoney", "expressionmd5:%s expressiontype:%s", new Object[] { this.vqb, Integer.valueOf(this.vqc) });
    paramJSONObject = paramJSONObject.optJSONObject("showSourceRec");
    if (paramJSONObject == null) {
      paramString = null;
    }
    for (;;)
    {
      this.vqL = paramString;
      g.ajD();
      paramInt = ((Integer)g.ajC().ajl().get(al.a.IFE, Integer.valueOf(0))).intValue();
      int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwX, 0);
      if ((bt.jx(paramInt, 1)) || (bt.jx(i, 1)))
      {
        this.vqJ = 1;
        this.vqx = 1;
      }
      ad.i("MicroMsg.NetSceneReceiveLuckyMoney", "localSwitch() showRecNormalExpression:%s showYearExpression:%s", new Object[] { Integer.valueOf(this.vqJ), Integer.valueOf(this.vqx) });
      AppMethodBeat.o(65310);
      return;
      paramString = new aw();
      paramString.vqP = x.aG(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.as
 * JD-Core Version:    0.7.0.1
 */