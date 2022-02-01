package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class bf
  extends ax
{
  public String CAf;
  public String Kmq;
  public String Kov;
  public String KrL;
  public String KrO;
  public int KrW;
  public int Krd;
  public bi Ksc;
  public String Ksd;
  public String Ksi;
  public int Ksr;
  public int KtZ;
  public int KuI;
  public aa KuL;
  public String KuS;
  public boolean KuT;
  public long KuU;
  public long KuV;
  public int KuW;
  public String KuX;
  public bk KuY;
  public String Kua;
  public String Kub;
  public String Kuc;
  public String Kud;
  public String Kue;
  public long Kug;
  public String Kuk;
  public int Kul;
  public int Kuu;
  public int channelId;
  public int ihA;
  public String ihx;
  public int ihy;
  public int ihz;
  long msgId;
  public int msgType;
  public String nPS;
  String talker;
  
  public bf()
  {
    this.KuT = false;
    this.KtZ = 1;
    this.Kua = null;
    this.Kub = null;
    this.Kuc = null;
    this.Kud = null;
    this.Kue = null;
    this.Kug = 0L;
    this.Kuu = 0;
    this.KuI = 0;
    this.Krd = 0;
  }
  
  public bf(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(283979);
    this.KuT = false;
    this.KtZ = 1;
    this.Kua = null;
    this.Kub = null;
    this.Kuc = null;
    this.Kud = null;
    this.Kue = null;
    this.Kug = 0L;
    this.Kuu = 0;
    this.KuI = 0;
    this.Krd = 0;
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
    h.baF();
    long l = ((Long)h.baE().ban().get(at.a.acML, Long.valueOf(0L))).longValue();
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
      AppMethodBeat.o(283979);
      return;
      label265:
      paramString1 = new StringBuilder();
      h.baF();
      localHashMap.put("agreeDuty", (Integer)h.baE().ban().get(at.a.acMM, Integer.valueOf(1)));
    }
  }
  
  public String drI()
  {
    return "/cgi-bin/mmpay-bin/receivewxhb";
  }
  
  public final void fXl()
  {
    AppMethodBeat.i(283994);
    h.baF();
    int i = ((Integer)h.baE().ban().get(at.a.acYL, Integer.valueOf(0))).intValue();
    int j = ((c)h.ax(c.class)).a(c.a.yTa, 0);
    if ((Util.isEqual(i, 1)) || (Util.isEqual(j, 1)))
    {
      this.Krd = 1;
      this.KuI = 1;
    }
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "localSwitch() showRecNormalExpression:%s showYearExpression:%s", new Object[] { Integer.valueOf(this.Krd), Integer.valueOf(this.KuI) });
    AppMethodBeat.o(283994);
  }
  
  public final boolean fXn()
  {
    return this.KrW == 1;
  }
  
  public int getType()
  {
    return 1581;
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65310);
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
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
    if (Util.isNullOrNil(this.KuS)) {
      this.KuT = true;
    }
    if ((!Util.isNullOrNil(this.Ksi)) && (Util.isNullOrNil(this.KuS))) {
      this.KuS = ((b)h.ax(b.class)).getDisplayName(this.Ksi);
    }
    this.Ksc = ae.bv(paramJSONObject.optJSONObject("operationTail"));
    this.KuL = ae.bw(paramJSONObject.optJSONObject("new_year_cover_config"));
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
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "scenePicSwitch:" + this.Kuu);
    this.KuW = paramJSONObject.optInt("preStrainFlag", 1);
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "preStrainFlag:" + this.KuW);
    this.KuI = paramJSONObject.optInt("showYearExpression");
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "showYearExpression:%s", new Object[] { Integer.valueOf(this.KuI) });
    this.Krd = paramJSONObject.optInt("showRecNormalExpression");
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "showRecNormalExpression:%s", new Object[] { Integer.valueOf(this.Krd) });
    h.baF();
    h.baE().ban().set(at.a.acMA, Integer.valueOf(this.KuW));
    this.KuX = paramJSONObject.optString("timingIdentifier");
    this.nPS = paramJSONObject.optString("effectResource");
    this.Kuk = paramJSONObject.optString("expression_md5");
    this.Kul = paramJSONObject.optInt("expression_type");
    this.Ksr = paramJSONObject.optInt("not_show_avatar", 0);
    Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "expressionmd5:%s expressiontype:%s", new Object[] { this.Kuk, Integer.valueOf(this.Kul) });
    this.KuY = bk.bz(paramJSONObject.optJSONObject("showSourceRec"));
    fXl();
    AppMethodBeat.o(65310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bf
 * JD-Core Version:    0.7.0.1
 */