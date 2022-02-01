package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ah
  extends am
{
  long msgId;
  String talker;
  public l vBT;
  public String vCf;
  public String vCg;
  public int vCh;
  public LuckyMoneyEmojiSwitch vCi;
  
  public ah(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    this(paramString1, paramInt1, paramInt2, paramString2, paramString3, "");
  }
  
  public ah(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65286);
    this.vBT = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    localHashMap.put("limit", String.valueOf(paramInt1));
    localHashMap.put("offset", String.valueOf(paramInt2));
    if (!bu.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("ver", paramString3);
    localHashMap.put("processContent", paramString4);
    setRequestData(localHashMap);
    AppMethodBeat.o(65286);
  }
  
  public ah(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65285);
    this.vBT = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    localHashMap.put("limit", "11");
    localHashMap.put("offset", String.valueOf(paramInt));
    if (!bu.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("befortTimestamp", String.valueOf(paramLong));
    localHashMap.put("ver", paramString3);
    localHashMap.put("processContent", paramString4);
    setRequestData(localHashMap);
    AppMethodBeat.o(65285);
  }
  
  public final String cbJ()
  {
    return "/cgi-bin/mmpay-bin/qrydetailwxhb";
  }
  
  public final int getType()
  {
    return 1585;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65287);
    try
    {
      this.vBT = x.aD(paramJSONObject);
      this.vCf = paramJSONObject.optString("processContent");
      this.vCi = LuckyMoneyEmojiSwitch.aC(paramJSONObject);
      ae.i("MicroMsg.NetSceneLuckyMoneyDetail", "luckyMoneyEmojiSwitch:%s", new Object[] { this.vCi.toString() });
      this.vCg = paramJSONObject.optString("expression_md5");
      this.vCh = paramJSONObject.optInt("expression_type");
      ae.i("MicroMsg.NetSceneLuckyMoneyDetail", "expressionmd5:%s expressiontype:%s", new Object[] { this.vCg, Integer.valueOf(this.vCh) });
      g.ajS();
      paramInt = ((Integer)g.ajR().ajA().get(am.a.Jae, Integer.valueOf(0))).intValue();
      int i = ((b)g.ab(b.class)).a(b.a.qDX, 0);
      if ((bu.jB(paramInt, 1)) || (bu.jB(i, 1)))
      {
        if (this.vCi == null) {
          this.vCi = new LuckyMoneyEmojiSwitch();
        }
        this.vCi.vAI = 1;
        this.vCi.vAJ = 1;
        this.vCi.vAK = 1;
        this.vCi.vAL = 1;
      }
      ae.i("MicroMsg.NetSceneLuckyMoneyDetail", "localSwitch() luckyMoneyEmojiSwitch:%s ", new Object[] { this.vCi.toString() });
      AppMethodBeat.o(65287);
      return;
    }
    catch (JSONException paramString)
    {
      ae.w("MicroMsg.NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
      AppMethodBeat.o(65287);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ah
 * JD-Core Version:    0.7.0.1
 */