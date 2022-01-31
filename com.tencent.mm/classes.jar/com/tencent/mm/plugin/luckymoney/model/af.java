package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class af
  extends ak
{
  long cpO;
  public k ooO;
  public String opa;
  public String opb;
  public int opc;
  public LuckyMoneyEmojiSwitch opd;
  String talker;
  
  public af(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    this(paramString1, paramInt1, paramInt2, paramString2, paramString3, "");
  }
  
  public af(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(42398);
    this.ooO = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    localHashMap.put("limit", String.valueOf(paramInt1));
    localHashMap.put("offset", String.valueOf(paramInt2));
    if (!bo.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("ver", paramString3);
    localHashMap.put("processContent", paramString4);
    setRequestData(localHashMap);
    AppMethodBeat.o(42398);
  }
  
  public af(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    AppMethodBeat.i(42397);
    this.ooO = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    localHashMap.put("limit", "11");
    localHashMap.put("offset", String.valueOf(paramInt));
    if (!bo.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("befortTimestamp", String.valueOf(paramLong));
    localHashMap.put("ver", paramString3);
    localHashMap.put("processContent", paramString4);
    setRequestData(localHashMap);
    AppMethodBeat.o(42397);
  }
  
  public final String bhG()
  {
    return "/cgi-bin/mmpay-bin/qrydetailwxhb";
  }
  
  public final int getType()
  {
    return 1585;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(42399);
    try
    {
      this.ooO = v.ae(paramJSONObject);
      this.opa = paramJSONObject.optString("processContent");
      this.opd = LuckyMoneyEmojiSwitch.ad(paramJSONObject);
      ab.i("MicroMsg.NetSceneLuckyMoneyDetail", "luckyMoneyEmojiSwitch:%s", new Object[] { this.opd.toString() });
      this.opb = paramJSONObject.optString("expression_md5");
      this.opc = paramJSONObject.optInt("expression_type");
      ab.i("MicroMsg.NetSceneLuckyMoneyDetail", "expressionmd5:%s expressiontype:%s", new Object[] { this.opb, Integer.valueOf(this.opc) });
      g.RM();
      paramInt = ((Integer)g.RL().Ru().get(ac.a.yLJ, Integer.valueOf(0))).intValue();
      int i = ((a)g.E(a.class)).a(a.a.lVp, 0);
      if ((bo.hl(paramInt, 1)) || (bo.hl(i, 1)))
      {
        if (this.opd == null) {
          this.opd = new LuckyMoneyEmojiSwitch();
        }
        this.opd.onR = 1;
        this.opd.onS = 1;
        this.opd.onT = 1;
        this.opd.onU = 1;
      }
      ab.i("MicroMsg.NetSceneLuckyMoneyDetail", "localSwitch() luckyMoneyEmojiSwitch:%s ", new Object[] { this.opd.toString() });
      AppMethodBeat.o(42399);
      return;
    }
    catch (JSONException paramString)
    {
      ab.w("MicroMsg.NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
      AppMethodBeat.o(42399);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.af
 * JD-Core Version:    0.7.0.1
 */