package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aq
  extends ak
{
  public int bWu;
  public String cMO;
  public int cMP;
  public int cMQ;
  public int cMR;
  long cpO;
  public String ffX;
  public int msgType;
  public String oiG;
  public String ojA;
  public String okM;
  public int onB;
  public as onH;
  public String onI;
  public String onN;
  public String onq;
  public String ont;
  public int ooS;
  public String ooT;
  public String ooU;
  public String ooV;
  public String ooW;
  public String ooX;
  public long ooY;
  public String opH;
  public long opI;
  public long opJ;
  public int opK;
  public int opL;
  public String opM;
  public au opN;
  public String opb;
  public int opc;
  public int opl;
  public int opx;
  String talker;
  
  public aq(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(42421);
    this.ooS = 1;
    this.ooT = null;
    this.ooU = null;
    this.ooV = null;
    this.ooW = null;
    this.ooX = null;
    this.ooY = 0L;
    this.opl = 0;
    this.opx = 0;
    this.opL = 0;
    this.msgType = 1;
    this.bWu = paramInt1;
    this.ojA = paramString1;
    this.cMO = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", "1");
    localHashMap.put("channelId", String.valueOf(paramInt1));
    localHashMap.put("sendId", paramString1);
    localHashMap.put("inWay", String.valueOf(paramInt2));
    localHashMap.put("ver", paramString3);
    g.RM();
    long l = ((Long)g.RL().Ru().get(ac.a.yCp, Long.valueOf(0L))).longValue();
    if (l > 0L)
    {
      if (System.currentTimeMillis() >= l) {
        break label241;
      }
      localHashMap.put("agreeDuty", "0");
    }
    for (;;)
    {
      if (!bo.isNullOrNil(paramString2)) {
        localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
      }
      setRequestData(localHashMap);
      AppMethodBeat.o(42421);
      return;
      label241:
      paramString1 = new StringBuilder();
      g.RM();
      localHashMap.put("agreeDuty", (Integer)g.RL().Ru().get(ac.a.yCq, Integer.valueOf(1)));
    }
  }
  
  public final String bhG()
  {
    return "/cgi-bin/mmpay-bin/receivewxhb";
  }
  
  public final int getType()
  {
    return 1581;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(42422);
    this.opH = paramJSONObject.optString("sendNick");
    this.ont = paramJSONObject.optString("sendHeadImg");
    this.cMQ = paramJSONObject.optInt("hbStatus");
    this.cMR = paramJSONObject.optInt("receiveStatus");
    this.onq = paramJSONObject.optString("statusMess");
    this.oiG = paramJSONObject.optString("wishing");
    this.onB = paramJSONObject.optInt("isSender");
    this.opI = paramJSONObject.optLong("sceneAmount");
    this.opJ = paramJSONObject.optLong("sceneRecTimeStamp");
    this.cMP = paramJSONObject.optInt("hbType");
    this.onI = paramJSONObject.optString("watermark");
    this.okM = paramJSONObject.optString("externMess");
    this.onN = paramJSONObject.optString("sendUserName");
    if ((!bo.isNullOrNil(this.onN)) && (bo.isNullOrNil(this.opH))) {
      this.opH = ((b)g.E(b.class)).nE(this.onN);
    }
    this.onH = v.ag(paramJSONObject.optJSONObject("operationTail"));
    this.opl = paramJSONObject.optInt("scenePicSwitch");
    paramString = paramJSONObject.optJSONObject("agree_duty");
    if (paramString != null)
    {
      this.ooT = paramString.optString("agreed_flag", "-1");
      this.ooU = paramString.optString("title", "");
      this.ooV = paramString.optString("service_protocol_wording", "");
      this.ooW = paramString.optString("service_protocol_url", "");
      this.ooX = paramString.optString("button_wording", "");
      this.ooY = paramString.optLong("delay_expired_time", 0L);
    }
    if (this.ooY > 0L)
    {
      g.RM();
      g.RL().Ru().set(ac.a.yCp, Long.valueOf(System.currentTimeMillis() + this.ooY * 1000L));
    }
    ab.i("MicroMsg.NetSceneReceiveLuckyMoney", "scenePicSwitch:" + this.opl);
    this.opK = paramJSONObject.optInt("preStrainFlag", 1);
    ab.i("MicroMsg.NetSceneReceiveLuckyMoney", "preStrainFlag:" + this.opK);
    this.opx = paramJSONObject.optInt("showYearExpression");
    ab.i("MicroMsg.NetSceneReceiveLuckyMoney", "showYearExpression:%s", new Object[] { Integer.valueOf(this.opx) });
    this.opL = paramJSONObject.optInt("showRecNormalExpression");
    ab.i("MicroMsg.NetSceneReceiveLuckyMoney", "showRecNormalExpression:%s", new Object[] { Integer.valueOf(this.opL) });
    g.RM();
    g.RL().Ru().set(ac.a.yCe, Integer.valueOf(this.opK));
    this.opM = paramJSONObject.optString("timingIdentifier");
    this.ffX = paramJSONObject.optString("effectResource");
    this.opb = paramJSONObject.optString("expression_md5");
    this.opc = paramJSONObject.optInt("expression_type");
    ab.i("MicroMsg.NetSceneReceiveLuckyMoney", "expressionmd5:%s expressiontype:%s", new Object[] { this.opb, Integer.valueOf(this.opc) });
    paramJSONObject = paramJSONObject.optJSONObject("showSourceRec");
    if (paramJSONObject == null) {
      paramString = null;
    }
    for (;;)
    {
      this.opN = paramString;
      g.RM();
      paramInt = ((Integer)g.RL().Ru().get(ac.a.yLJ, Integer.valueOf(0))).intValue();
      int i = ((a)g.E(a.class)).a(a.a.lVp, 0);
      if ((bo.hl(paramInt, 1)) || (bo.hl(i, 1)))
      {
        this.opL = 1;
        this.opx = 1;
      }
      ab.i("MicroMsg.NetSceneReceiveLuckyMoney", "localSwitch() showRecNormalExpression:%s showYearExpression:%s", new Object[] { Integer.valueOf(this.opL), Integer.valueOf(this.opx) });
      AppMethodBeat.o(42422);
      return;
      paramString = new au();
      paramString.opR = v.ah(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.aq
 * JD-Core Version:    0.7.0.1
 */