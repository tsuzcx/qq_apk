package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  public l vpO;
  public String vqa;
  public String vqb;
  public int vqc;
  public LuckyMoneyEmojiSwitch vqd;
  
  public ah(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    this(paramString1, paramInt1, paramInt2, paramString2, paramString3, "");
  }
  
  public ah(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65286);
    this.vpO = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    localHashMap.put("limit", String.valueOf(paramInt1));
    localHashMap.put("offset", String.valueOf(paramInt2));
    if (!bt.isNullOrNil(paramString2)) {
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
    this.vpO = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    localHashMap.put("limit", "11");
    localHashMap.put("offset", String.valueOf(paramInt));
    if (!bt.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("befortTimestamp", String.valueOf(paramLong));
    localHashMap.put("ver", paramString3);
    localHashMap.put("processContent", paramString4);
    setRequestData(localHashMap);
    AppMethodBeat.o(65285);
  }
  
  public final String cau()
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
      this.vpO = x.aD(paramJSONObject);
      this.vqa = paramJSONObject.optString("processContent");
      this.vqd = LuckyMoneyEmojiSwitch.aC(paramJSONObject);
      ad.i("MicroMsg.NetSceneLuckyMoneyDetail", "luckyMoneyEmojiSwitch:%s", new Object[] { this.vqd.toString() });
      this.vqb = paramJSONObject.optString("expression_md5");
      this.vqc = paramJSONObject.optInt("expression_type");
      ad.i("MicroMsg.NetSceneLuckyMoneyDetail", "expressionmd5:%s expressiontype:%s", new Object[] { this.vqb, Integer.valueOf(this.vqc) });
      g.ajD();
      paramInt = ((Integer)g.ajC().ajl().get(al.a.IFE, Integer.valueOf(0))).intValue();
      int i = ((b)g.ab(b.class)).a(b.a.qwX, 0);
      if ((bt.jx(paramInt, 1)) || (bt.jx(i, 1)))
      {
        if (this.vqd == null) {
          this.vqd = new LuckyMoneyEmojiSwitch();
        }
        this.vqd.voD = 1;
        this.vqd.voE = 1;
        this.vqd.voF = 1;
        this.vqd.voG = 1;
      }
      ad.i("MicroMsg.NetSceneLuckyMoneyDetail", "localSwitch() luckyMoneyEmojiSwitch:%s ", new Object[] { this.vqd.toString() });
      AppMethodBeat.o(65287);
      return;
    }
    catch (JSONException paramString)
    {
      ad.w("MicroMsg.NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
      AppMethodBeat.o(65287);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ah
 * JD-Core Version:    0.7.0.1
 */