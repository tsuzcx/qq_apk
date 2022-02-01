package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ao
  extends av
{
  long msgId;
  String talker;
  public q yWT;
  public String yXg;
  public String yXh;
  public int yXi;
  public LuckyMoneyEmojiSwitch yXj;
  
  public ao()
  {
    this.yWT = null;
  }
  
  public ao(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    this(paramString1, paramInt1, paramInt2, paramString2, paramString3, "");
  }
  
  public ao(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65286);
    this.yWT = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    localHashMap.put("limit", String.valueOf(paramInt1));
    localHashMap.put("offset", String.valueOf(paramInt2));
    if (!Util.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("ver", paramString3);
    localHashMap.put("processContent", paramString4);
    Log.i("MicroMsg.NetSceneLuckyMoneyDetail", "sendId: %s, limit: %s，offet: %s, nativeUrl: %s，processContent: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2, paramString4 });
    setRequestData(localHashMap);
    AppMethodBeat.o(65286);
  }
  
  public ao(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65285);
    this.yWT = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    localHashMap.put("limit", "11");
    localHashMap.put("offset", String.valueOf(paramInt));
    if (!Util.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("befortTimestamp", String.valueOf(paramLong));
    localHashMap.put("ver", paramString3);
    localHashMap.put("processContent", paramString4);
    Log.i("MicroMsg.NetSceneLuckyMoneyDetail", "sendId: %s, limit: %s，offet: %s, nativeUrl: %s，processContent: %s", new Object[] { paramString1, Integer.valueOf(11), Integer.valueOf(paramInt), paramString2, paramString4 });
    setRequestData(localHashMap);
    AppMethodBeat.o(65285);
  }
  
  public String czD()
  {
    return "/cgi-bin/mmpay-bin/qrydetailwxhb";
  }
  
  public int getType()
  {
    return 1585;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65287);
    Log.i("MicroMsg.NetSceneLuckyMoneyDetail", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    try
    {
      this.yWT = ac.aY(paramJSONObject);
      this.yXg = paramJSONObject.optString("processContent");
      this.yXj = LuckyMoneyEmojiSwitch.aX(paramJSONObject);
      Log.i("MicroMsg.NetSceneLuckyMoneyDetail", "luckyMoneyEmojiSwitch:%s", new Object[] { this.yXj.toString() });
      this.yXh = paramJSONObject.optString("expression_md5");
      this.yXi = paramJSONObject.optInt("expression_type");
      Log.i("MicroMsg.NetSceneLuckyMoneyDetail", "expressionmd5:%s expressiontype:%s", new Object[] { this.yXh, Integer.valueOf(this.yXi) });
      g.aAi();
      paramInt = ((Integer)g.aAh().azQ().get(ar.a.OiK, Integer.valueOf(0))).intValue();
      int i = ((b)g.af(b.class)).a(b.a.rXc, 0);
      if ((Util.isEqual(paramInt, 1)) || (Util.isEqual(i, 1)))
      {
        if (this.yXj == null) {
          this.yXj = new LuckyMoneyEmojiSwitch();
        }
        this.yXj.yVG = 1;
        this.yXj.yVH = 1;
        this.yXj.yVI = 1;
        this.yXj.yVJ = 1;
      }
      Log.i("MicroMsg.NetSceneLuckyMoneyDetail", "localSwitch() luckyMoneyEmojiSwitch:%s ", new Object[] { this.yXj.toString() });
      AppMethodBeat.o(65287);
      return;
    }
    catch (JSONException paramString)
    {
      Log.w("MicroMsg.NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
      AppMethodBeat.o(65287);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ao
 * JD-Core Version:    0.7.0.1
 */