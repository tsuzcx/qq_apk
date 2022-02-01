package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class be
  extends bd
{
  public be(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(213331);
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
    localHashMap.put("union_source", "0");
    g.aAi();
    long l = ((Long)g.aAh().azQ().get(ar.a.NXr, Long.valueOf(0L))).longValue();
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
      AppMethodBeat.o(213331);
      return;
      label210:
      paramString1 = new StringBuilder();
      g.aAi();
      localHashMap.put("agreeDuty", (Integer)g.aAh().azQ().get(ar.a.NXs, Integer.valueOf(1)));
    }
  }
  
  public final String czD()
  {
    return "/cgi-bin/mmpay-bin/unionhb/receiveunionhb";
  }
  
  public final int getType()
  {
    return 4536;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(213332);
    Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
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
    Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "scenePicSwitch:" + this.yXr);
    this.yXQ = paramJSONObject.optInt("preStrainFlag", 1);
    Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "preStrainFlag:" + this.yXQ);
    this.yXD = paramJSONObject.optInt("showYearExpression");
    Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "showYearExpression:%s", new Object[] { Integer.valueOf(this.yXD) });
    this.yUt = paramJSONObject.optInt("showRecNormalExpression");
    Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "showRecNormalExpression:%s", new Object[] { Integer.valueOf(this.yUt) });
    g.aAi();
    g.aAh().azQ().set(ar.a.NXg, Integer.valueOf(this.yXQ));
    this.yXR = paramJSONObject.optString("timingIdentifier");
    this.ivQ = paramJSONObject.optString("effectResource");
    this.yXh = paramJSONObject.optString("expression_md5");
    this.yXi = paramJSONObject.optInt("expression_type");
    Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "expressionmd5:%s expressiontype:%s", new Object[] { this.yXh, Integer.valueOf(this.yXi) });
    this.yXS = bi.bc(paramJSONObject.optJSONObject("showSourceRec"));
    efk();
    AppMethodBeat.o(213332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.be
 * JD-Core Version:    0.7.0.1
 */