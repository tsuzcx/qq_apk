package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class bd
  extends av
{
  public int channelId;
  public String egX;
  public int egY;
  public int egZ;
  public int eha;
  public String ivQ;
  long msgId;
  public int msgType;
  String talker;
  public String yPK;
  public String yQE;
  public String yRQ;
  public int yUt;
  public String yVb;
  public String yVe;
  public int yVm;
  public bg yVs;
  public String yVt;
  public String yVy;
  public int yWX;
  public String yWY;
  public String yWZ;
  public int yXD;
  public String yXN;
  public long yXO;
  public long yXP;
  public int yXQ;
  public String yXR;
  public bi yXS;
  public String yXa;
  public String yXb;
  public String yXc;
  public long yXd;
  public String yXh;
  public int yXi;
  public int yXr;
  
  public bd()
  {
    this.yWX = 1;
    this.yWY = null;
    this.yWZ = null;
    this.yXa = null;
    this.yXb = null;
    this.yXc = null;
    this.yXd = 0L;
    this.yXr = 0;
    this.yXD = 0;
    this.yUt = 0;
  }
  
  public bd(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(213329);
    this.yWX = 1;
    this.yWY = null;
    this.yWZ = null;
    this.yXa = null;
    this.yXb = null;
    this.yXc = null;
    this.yXd = 0L;
    this.yXr = 0;
    this.yXD = 0;
    this.yUt = 0;
    this.msgType = 1;
    this.channelId = paramInt1;
    this.yQE = paramString1;
    this.egX = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", "1");
    localHashMap.put("channelId", String.valueOf(paramInt1));
    localHashMap.put("sendId", paramString1);
    localHashMap.put("inWay", String.valueOf(paramInt2));
    localHashMap.put("ver", paramString3);
    g.aAi();
    long l = ((Long)g.aAh().azQ().get(ar.a.NXr, Long.valueOf(0L))).longValue();
    if (l > 0L)
    {
      if (System.currentTimeMillis() >= l) {
        break label260;
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
      AppMethodBeat.o(213329);
      return;
      label260:
      paramString1 = new StringBuilder();
      g.aAi();
      localHashMap.put("agreeDuty", (Integer)g.aAh().azQ().get(ar.a.NXs, Integer.valueOf(1)));
    }
  }
  
  public String czD()
  {
    return "/cgi-bin/mmpay-bin/receivewxhb";
  }
  
  public final void efk()
  {
    AppMethodBeat.i(213330);
    g.aAi();
    int i = ((Integer)g.aAh().azQ().get(ar.a.OiK, Integer.valueOf(0))).intValue();
    int j = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXc, 0);
    if ((Util.isEqual(i, 1)) || (Util.isEqual(j, 1)))
    {
      this.yUt = 1;
      this.yXD = 1;
    }
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "localSwitch() showRecNormalExpression:%s showYearExpression:%s", new Object[] { Integer.valueOf(this.yUt), Integer.valueOf(this.yXD) });
    AppMethodBeat.o(213330);
  }
  
  public int getType()
  {
    return 1581;
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65310);
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    this.yXN = paramJSONObject.optString("sendNick");
    this.yVe = paramJSONObject.optString("sendHeadImg");
    this.egZ = paramJSONObject.optInt("hbStatus");
    this.eha = paramJSONObject.optInt("receiveStatus");
    this.yVb = paramJSONObject.optString("statusMess");
    this.yPK = paramJSONObject.optString("wishing");
    this.yVm = paramJSONObject.optInt("isSender");
    this.yXO = paramJSONObject.optLong("sceneAmount");
    this.yXP = paramJSONObject.optLong("sceneRecTimeStamp");
    this.egY = paramJSONObject.optInt("hbType");
    this.yVt = paramJSONObject.optString("watermark");
    this.yRQ = paramJSONObject.optString("externMess");
    this.yVy = paramJSONObject.optString("sendUserName");
    if ((!Util.isNullOrNil(this.yVy)) && (Util.isNullOrNil(this.yXN))) {
      this.yXN = ((com.tencent.mm.plugin.messenger.a.b)g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.yVy);
    }
    this.yVs = ac.ba(paramJSONObject.optJSONObject("operationTail"));
    this.yXr = paramJSONObject.optInt("scenePicSwitch");
    paramString = paramJSONObject.optJSONObject("agree_duty");
    if (paramString != null)
    {
      this.yWY = paramString.optString("agreed_flag", "-1");
      this.yWZ = paramString.optString("title", "");
      this.yXa = paramString.optString("service_protocol_wording", "");
      this.yXb = paramString.optString("service_protocol_url", "");
      this.yXc = paramString.optString("button_wording", "");
      this.yXd = paramString.optLong("delay_expired_time", 0L);
    }
    if (this.yXd > 0L)
    {
      g.aAi();
      g.aAh().azQ().set(ar.a.NXr, Long.valueOf(System.currentTimeMillis() + this.yXd * 1000L));
    }
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "scenePicSwitch:" + this.yXr);
    this.yXQ = paramJSONObject.optInt("preStrainFlag", 1);
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "preStrainFlag:" + this.yXQ);
    this.yXD = paramJSONObject.optInt("showYearExpression");
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "showYearExpression:%s", new Object[] { Integer.valueOf(this.yXD) });
    this.yUt = paramJSONObject.optInt("showRecNormalExpression");
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "showRecNormalExpression:%s", new Object[] { Integer.valueOf(this.yUt) });
    g.aAi();
    g.aAh().azQ().set(ar.a.NXg, Integer.valueOf(this.yXQ));
    this.yXR = paramJSONObject.optString("timingIdentifier");
    this.ivQ = paramJSONObject.optString("effectResource");
    this.yXh = paramJSONObject.optString("expression_md5");
    this.yXi = paramJSONObject.optInt("expression_type");
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "expressionmd5:%s expressiontype:%s", new Object[] { this.yXh, Integer.valueOf(this.yXi) });
    this.yXS = bi.bc(paramJSONObject.optJSONObject("showSourceRec"));
    efk();
    AppMethodBeat.o(65310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bd
 * JD-Core Version:    0.7.0.1
 */