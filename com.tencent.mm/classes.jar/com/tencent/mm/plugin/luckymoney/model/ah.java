package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  public l uni;
  public String unu;
  public String unv;
  public int unw;
  public LuckyMoneyEmojiSwitch unx;
  
  public ah(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    this(paramString1, paramInt1, paramInt2, paramString2, paramString3, "");
  }
  
  public ah(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65286);
    this.uni = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    localHashMap.put("limit", String.valueOf(paramInt1));
    localHashMap.put("offset", String.valueOf(paramInt2));
    if (!bs.isNullOrNil(paramString2)) {
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
    this.uni = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    localHashMap.put("limit", "11");
    localHashMap.put("offset", String.valueOf(paramInt));
    if (!bs.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("befortTimestamp", String.valueOf(paramLong));
    localHashMap.put("ver", paramString3);
    localHashMap.put("processContent", paramString4);
    setRequestData(localHashMap);
    AppMethodBeat.o(65285);
  }
  
  public final String bVR()
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
      this.uni = x.au(paramJSONObject);
      this.unu = paramJSONObject.optString("processContent");
      this.unx = LuckyMoneyEmojiSwitch.at(paramJSONObject);
      ac.i("MicroMsg.NetSceneLuckyMoneyDetail", "luckyMoneyEmojiSwitch:%s", new Object[] { this.unx.toString() });
      this.unv = paramJSONObject.optString("expression_md5");
      this.unw = paramJSONObject.optInt("expression_type");
      ac.i("MicroMsg.NetSceneLuckyMoneyDetail", "expressionmd5:%s expressiontype:%s", new Object[] { this.unv, Integer.valueOf(this.unw) });
      g.agS();
      paramInt = ((Integer)g.agR().agA().get(ah.a.GSZ, Integer.valueOf(0))).intValue();
      int i = ((b)g.ab(b.class)).a(b.a.pSw, 0);
      if ((bs.jl(paramInt, 1)) || (bs.jl(i, 1)))
      {
        if (this.unx == null) {
          this.unx = new LuckyMoneyEmojiSwitch();
        }
        this.unx.ulX = 1;
        this.unx.ulY = 1;
        this.unx.ulZ = 1;
        this.unx.uma = 1;
      }
      ac.i("MicroMsg.NetSceneLuckyMoneyDetail", "localSwitch() luckyMoneyEmojiSwitch:%s ", new Object[] { this.unx.toString() });
      AppMethodBeat.o(65287);
      return;
    }
    catch (JSONException paramString)
    {
      ac.w("MicroMsg.NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
      AppMethodBeat.o(65287);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ah
 * JD-Core Version:    0.7.0.1
 */