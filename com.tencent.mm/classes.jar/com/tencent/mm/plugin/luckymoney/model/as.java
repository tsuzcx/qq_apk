package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class as
  extends am
{
  public int cGY;
  public int dBA;
  public int dBB;
  public String dBy;
  public int dBz;
  public String hgN;
  long msgId;
  public int msgType;
  String talker;
  public String ugH;
  public String uhB;
  public String uiP;
  public int ulH;
  public au ulN;
  public String ulO;
  public String ulT;
  public String ulw;
  public String ulz;
  public int unF;
  public int unR;
  public int unm;
  public String unn;
  public String uno;
  public String unp;
  public String unq;
  public String unr;
  public long uns;
  public String unv;
  public int unw;
  public String uob;
  public long uoc;
  public long uod;
  public int uoe;
  public int uof;
  public String uog;
  public aw uoh;
  
  public as(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(65309);
    this.unm = 1;
    this.unn = null;
    this.uno = null;
    this.unp = null;
    this.unq = null;
    this.unr = null;
    this.uns = 0L;
    this.unF = 0;
    this.unR = 0;
    this.uof = 0;
    this.msgType = 1;
    this.cGY = paramInt1;
    this.uhB = paramString1;
    this.dBy = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", "1");
    localHashMap.put("channelId", String.valueOf(paramInt1));
    localHashMap.put("sendId", paramString1);
    localHashMap.put("inWay", String.valueOf(paramInt2));
    localHashMap.put("ver", paramString3);
    g.agS();
    long l = ((Long)g.agR().agA().get(ah.a.GIA, Long.valueOf(0L))).longValue();
    if (l > 0L)
    {
      if (System.currentTimeMillis() >= l) {
        break label241;
      }
      localHashMap.put("agreeDuty", "0");
    }
    for (;;)
    {
      if (!bs.isNullOrNil(paramString2)) {
        localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
      }
      setRequestData(localHashMap);
      AppMethodBeat.o(65309);
      return;
      label241:
      paramString1 = new StringBuilder();
      g.agS();
      localHashMap.put("agreeDuty", (Integer)g.agR().agA().get(ah.a.GIB, Integer.valueOf(1)));
    }
  }
  
  public final String bVR()
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
    this.uob = paramJSONObject.optString("sendNick");
    this.ulz = paramJSONObject.optString("sendHeadImg");
    this.dBA = paramJSONObject.optInt("hbStatus");
    this.dBB = paramJSONObject.optInt("receiveStatus");
    this.ulw = paramJSONObject.optString("statusMess");
    this.ugH = paramJSONObject.optString("wishing");
    this.ulH = paramJSONObject.optInt("isSender");
    this.uoc = paramJSONObject.optLong("sceneAmount");
    this.uod = paramJSONObject.optLong("sceneRecTimeStamp");
    this.dBz = paramJSONObject.optInt("hbType");
    this.ulO = paramJSONObject.optString("watermark");
    this.uiP = paramJSONObject.optString("externMess");
    this.ulT = paramJSONObject.optString("sendUserName");
    if ((!bs.isNullOrNil(this.ulT)) && (bs.isNullOrNil(this.uob))) {
      this.uob = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk(this.ulT);
    }
    this.ulN = x.aw(paramJSONObject.optJSONObject("operationTail"));
    this.unF = paramJSONObject.optInt("scenePicSwitch");
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
    ac.i("MicroMsg.NetSceneReceiveLuckyMoney", "scenePicSwitch:" + this.unF);
    this.uoe = paramJSONObject.optInt("preStrainFlag", 1);
    ac.i("MicroMsg.NetSceneReceiveLuckyMoney", "preStrainFlag:" + this.uoe);
    this.unR = paramJSONObject.optInt("showYearExpression");
    ac.i("MicroMsg.NetSceneReceiveLuckyMoney", "showYearExpression:%s", new Object[] { Integer.valueOf(this.unR) });
    this.uof = paramJSONObject.optInt("showRecNormalExpression");
    ac.i("MicroMsg.NetSceneReceiveLuckyMoney", "showRecNormalExpression:%s", new Object[] { Integer.valueOf(this.uof) });
    g.agS();
    g.agR().agA().set(ah.a.GIp, Integer.valueOf(this.uoe));
    this.uog = paramJSONObject.optString("timingIdentifier");
    this.hgN = paramJSONObject.optString("effectResource");
    this.unv = paramJSONObject.optString("expression_md5");
    this.unw = paramJSONObject.optInt("expression_type");
    ac.i("MicroMsg.NetSceneReceiveLuckyMoney", "expressionmd5:%s expressiontype:%s", new Object[] { this.unv, Integer.valueOf(this.unw) });
    paramJSONObject = paramJSONObject.optJSONObject("showSourceRec");
    if (paramJSONObject == null) {
      paramString = null;
    }
    for (;;)
    {
      this.uoh = paramString;
      g.agS();
      paramInt = ((Integer)g.agR().agA().get(ah.a.GSZ, Integer.valueOf(0))).intValue();
      int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSw, 0);
      if ((bs.jl(paramInt, 1)) || (bs.jl(i, 1)))
      {
        this.uof = 1;
        this.unR = 1;
      }
      ac.i("MicroMsg.NetSceneReceiveLuckyMoney", "localSwitch() showRecNormalExpression:%s showYearExpression:%s", new Object[] { Integer.valueOf(this.uof), Integer.valueOf(this.unR) });
      AppMethodBeat.o(65310);
      return;
      paramString = new aw();
      paramString.uol = x.ax(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.as
 * JD-Core Version:    0.7.0.1
 */