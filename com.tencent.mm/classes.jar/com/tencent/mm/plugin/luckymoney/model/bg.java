package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class bg
  extends bf
{
  public bg(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(283977);
    this.msgType = 1;
    this.channelId = paramInt1;
    this.CAf = paramString1;
    this.ihx = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", "1");
    localHashMap.put("channelId", String.valueOf(paramInt1));
    localHashMap.put("sendId", paramString1);
    localHashMap.put("inWay", String.valueOf(paramInt2));
    localHashMap.put("ver", paramString3);
    localHashMap.put("union_source", "0");
    h.baF();
    long l = ((Long)h.baE().ban().get(at.a.acML, Long.valueOf(0L))).longValue();
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
      AppMethodBeat.o(283977);
      return;
      label210:
      paramString1 = new StringBuilder();
      h.baF();
      localHashMap.put("agreeDuty", (Integer)h.baE().ban().get(at.a.acMM, Integer.valueOf(1)));
    }
  }
  
  public final String drI()
  {
    return "/cgi-bin/mmpay-bin/unionhb/receiveunionhb";
  }
  
  public final int getType()
  {
    return 4536;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(283988);
    Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    this.KuS = paramJSONObject.optString("sendNick");
    this.KrO = paramJSONObject.optString("sendHeadImg");
    this.ihz = paramJSONObject.optInt("hbStatus");
    this.ihA = paramJSONObject.optInt("receiveStatus");
    this.KrL = paramJSONObject.optString("statusMess");
    this.Kmq = paramJSONObject.optString("wishing");
    this.KrW = paramJSONObject.optInt("isSender");
    this.KuU = paramJSONObject.optLong("sceneAmount");
    this.KuV = paramJSONObject.optLong("sceneRecTimeStamp");
    this.ihy = paramJSONObject.optInt("hbType");
    this.Ksd = paramJSONObject.optString("watermark");
    this.Kov = paramJSONObject.optString("externMess");
    this.Ksi = paramJSONObject.optString("sendUserName");
    this.Ksc = ae.bv(paramJSONObject.optJSONObject("operationTail"));
    this.Kuu = paramJSONObject.optInt("scenePicSwitch");
    paramString = paramJSONObject.optJSONObject("agree_duty");
    if (paramString != null)
    {
      this.Kua = paramString.optString("agreed_flag", "-1");
      this.Kub = paramString.optString("title", "");
      this.Kuc = paramString.optString("service_protocol_wording", "");
      this.Kud = paramString.optString("service_protocol_url", "");
      this.Kue = paramString.optString("button_wording", "");
      this.Kug = paramString.optLong("delay_expired_time", 0L);
    }
    if (this.Kug > 0L)
    {
      h.baF();
      h.baE().ban().set(at.a.acML, Long.valueOf(System.currentTimeMillis() + this.Kug * 1000L));
    }
    Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "scenePicSwitch:" + this.Kuu);
    this.KuW = paramJSONObject.optInt("preStrainFlag", 1);
    Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "preStrainFlag:" + this.KuW);
    this.KuI = paramJSONObject.optInt("showYearExpression");
    Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "showYearExpression:%s", new Object[] { Integer.valueOf(this.KuI) });
    this.Krd = paramJSONObject.optInt("showRecNormalExpression");
    Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "showRecNormalExpression:%s", new Object[] { Integer.valueOf(this.Krd) });
    h.baF();
    h.baE().ban().set(at.a.acMA, Integer.valueOf(this.KuW));
    this.KuX = paramJSONObject.optString("timingIdentifier");
    this.nPS = paramJSONObject.optString("effectResource");
    this.Kuk = paramJSONObject.optString("expression_md5");
    this.Kul = paramJSONObject.optInt("expression_type");
    Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "expressionmd5:%s expressiontype:%s", new Object[] { this.Kuk, Integer.valueOf(this.Kul) });
    this.KuY = bk.bz(paramJSONObject.optJSONObject("showSourceRec"));
    fXl();
    AppMethodBeat.o(283988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bg
 * JD-Core Version:    0.7.0.1
 */