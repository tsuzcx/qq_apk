package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bk;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class y
  extends ab
{
  public String iHO;
  
  public y(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("totalNum", String.valueOf(paramInt1));
    localHashMap.put("totalAmount", String.valueOf(paramLong1));
    localHashMap.put("perValue", String.valueOf(paramLong2));
    localHashMap.put("hbType", String.valueOf(paramInt2));
    localHashMap.put("wishing", URLEncoder.encode(bk.pm(paramString1)));
    localHashMap.put("currency", String.valueOf(paramInt3));
    if (!bk.bl(paramString3)) {
      localHashMap.put("headImg", URLEncoder.encode(paramString3));
    }
    localHashMap.put("nickName", URLEncoder.encode(bk.pm(paramString4)));
    if (!bk.bl(paramString2)) {
      localHashMap.put("username", URLEncoder.encode(paramString2));
    }
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneLuckyMoneyH5Request", "NetSceneLuckyMoneyH5Request response errCode=" + paramInt);
    if (paramInt == 0) {
      this.iHO = paramJSONObject.optString("payUrl");
    }
  }
  
  public final int aEA()
  {
    return 0;
  }
  
  public final String aEz()
  {
    return "/cgi-bin/mmpay-bin/h5requestwxhb";
  }
  
  public final int getType()
  {
    return 1645;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.y
 * JD-Core Version:    0.7.0.1
 */