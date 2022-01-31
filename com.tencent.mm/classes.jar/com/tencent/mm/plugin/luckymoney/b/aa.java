package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aa
  extends ab
{
  public aa(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    localHashMap.put("offset", String.valueOf(paramInt2));
    localHashMap.put("type", String.valueOf(paramInt1));
    localHashMap.put("receiveId", paramString2);
    localHashMap.put("ver", paramString3);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("NetSceneLuckyMoneyMyRecordDelete", "onGYNetEnd");
  }
  
  public final String aEz()
  {
    return "/cgi-bin/mmpay-bin/deletelistwxhb";
  }
  
  public final int getType()
  {
    return 1612;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.aa
 * JD-Core Version:    0.7.0.1
 */