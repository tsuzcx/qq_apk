package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class bg
  extends aw
{
  public bg(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65311);
    HashMap localHashMap = new HashMap();
    localHashMap.put("username", paramString1);
    localHashMap.put("sendId", paramString2);
    localHashMap.put("channelId", "1");
    localHashMap.put("ver", paramString3);
    localHashMap.put("sendUserName", z.bcZ());
    setRequestData(localHashMap);
    AppMethodBeat.o(65311);
  }
  
  public final String cOd()
  {
    return "/cgi-bin/mmpay-bin/sharewxhb";
  }
  
  public final int getType()
  {
    return 1668;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bg
 * JD-Core Version:    0.7.0.1
 */