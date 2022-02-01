package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aq
  extends ax
{
  public q KtU;
  public String Kuj;
  public String Kuk;
  public int Kul;
  public LuckyMoneyEmojiSwitch Kum;
  long msgId;
  String talker;
  
  public aq()
  {
    this.KtU = null;
  }
  
  public aq(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    this(paramString1, paramInt1, paramInt2, paramString2, paramString3, "");
  }
  
  public aq(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65286);
    this.KtU = null;
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
  
  public aq(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65285);
    this.KtU = null;
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
  
  public String drI()
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
      this.KtU = ae.bt(paramJSONObject);
      this.Kuj = paramJSONObject.optString("processContent");
      this.Kum = LuckyMoneyEmojiSwitch.bs(paramJSONObject);
      Log.i("MicroMsg.NetSceneLuckyMoneyDetail", "luckyMoneyEmojiSwitch:%s", new Object[] { this.Kum.toString() });
      this.Kuk = paramJSONObject.optString("expression_md5");
      this.Kul = paramJSONObject.optInt("expression_type");
      Log.i("MicroMsg.NetSceneLuckyMoneyDetail", "expressionmd5:%s expressiontype:%s", new Object[] { this.Kuk, Integer.valueOf(this.Kul) });
      h.baF();
      paramInt = ((Integer)h.baE().ban().get(at.a.acYL, Integer.valueOf(0))).intValue();
      int i = ((c)h.ax(c.class)).a(c.a.yTa, 0);
      if ((Util.isEqual(paramInt, 1)) || (Util.isEqual(i, 1)))
      {
        if (this.Kum == null) {
          this.Kum = new LuckyMoneyEmojiSwitch();
        }
        this.Kum.Kss = 1;
        this.Kum.Kst = 1;
        this.Kum.Ksu = 1;
        this.Kum.Ksv = 1;
      }
      Log.i("MicroMsg.NetSceneLuckyMoneyDetail", "localSwitch() luckyMoneyEmojiSwitch:%s ", new Object[] { this.Kum.toString() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.aq
 * JD-Core Version:    0.7.0.1
 */