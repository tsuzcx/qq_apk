package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class bh
  extends ax
{
  public bh(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65311);
    HashMap localHashMap = new HashMap();
    localHashMap.put("username", paramString1);
    localHashMap.put("sendId", paramString2);
    localHashMap.put("channelId", "1");
    localHashMap.put("ver", paramString3);
    localHashMap.put("sendUserName", z.bAM());
    setRequestData(localHashMap);
    AppMethodBeat.o(65311);
  }
  
  public final String drI()
  {
    return "/cgi-bin/mmpay-bin/sharewxhb";
  }
  
  public final int getType()
  {
    return 1668;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bh
 * JD-Core Version:    0.7.0.1
 */