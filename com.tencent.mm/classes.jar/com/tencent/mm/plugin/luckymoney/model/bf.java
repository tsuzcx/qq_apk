package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class bf
  extends be
{
  public bf(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(268366);
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
    localHashMap.put("union_source", "0");
    h.aHH();
    long l = ((Long)h.aHG().aHp().get(ar.a.Vlr, Long.valueOf(0L))).longValue();
    if (l > 0L)
    {
      if (System.currentTimeMillis() >= l) {
        break label210;
      }
      localHashMap.put("agreeDuty", "0");
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString2)) {
        localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
      }
      Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "NetSceneReceiveLuckyMoneyUnion request");
      setRequestData(localHashMap);
      AppMethodBeat.o(268366);
      return;
      label210:
      paramString1 = new StringBuilder();
      h.aHH();
      localHashMap.put("agreeDuty", (Integer)h.aHG().aHp().get(ar.a.Vls, Integer.valueOf(1)));
    }
  }
  
  public final String cOd()
  {
    return "/cgi-bin/mmpay-bin/unionhb/receiveunionhb";
  }
  
  public final int getType()
  {
    return 4536;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(268367);
    Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
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
    Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "scenePicSwitch:" + this.EBw);
    this.EBV = paramJSONObject.optInt("preStrainFlag", 1);
    Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "preStrainFlag:" + this.EBV);
    this.EBI = paramJSONObject.optInt("showYearExpression");
    Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "showYearExpression:%s", new Object[] { Integer.valueOf(this.EBI) });
    this.Eyq = paramJSONObject.optInt("showRecNormalExpression");
    Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "showRecNormalExpression:%s", new Object[] { Integer.valueOf(this.Eyq) });
    h.aHH();
    h.aHG().aHp().set(ar.a.Vlg, Integer.valueOf(this.EBV));
    this.EBW = paramJSONObject.optString("timingIdentifier");
    this.lld = paramJSONObject.optString("effectResource");
    this.EBm = paramJSONObject.optString("expression_md5");
    this.EBn = paramJSONObject.optInt("expression_type");
    Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "expressionmd5:%s expressiontype:%s", new Object[] { this.EBm, Integer.valueOf(this.EBn) });
    this.EBX = bj.bj(paramJSONObject.optJSONObject("showSourceRec"));
    eOI();
    AppMethodBeat.o(268367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bf
 * JD-Core Version:    0.7.0.1
 */