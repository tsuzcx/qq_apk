package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bk;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ac
  extends ab
{
  public String lLm;
  public String lQb;
  
  public ac(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.lQb = paramString3;
    this.lLm = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    localHashMap.put("receiveId", paramString3);
    localHashMap.put("wishing", URLEncoder.encode(bk.pm(paramString2)));
    localHashMap.put("ver", paramString4);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject) {}
  
  public final String aEz()
  {
    return "/cgi-bin/mmpay-bin/wishwxhb";
  }
  
  public final int getType()
  {
    return 1682;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.ac
 * JD-Core Version:    0.7.0.1
 */