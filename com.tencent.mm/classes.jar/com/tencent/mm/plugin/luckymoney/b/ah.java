package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.model.q;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ah
  extends ab
{
  public ah(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("username", paramString1);
    localHashMap.put("sendId", paramString2);
    localHashMap.put("channelId", "1");
    localHashMap.put("ver", paramString3);
    localHashMap.put("sendUserName", q.Gj());
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject) {}
  
  public final String aEz()
  {
    return "/cgi-bin/mmpay-bin/sharewxhb";
  }
  
  public final int getType()
  {
    return 1668;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.ah
 * JD-Core Version:    0.7.0.1
 */