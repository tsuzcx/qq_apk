package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ar
  extends ak
{
  public ar(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(42423);
    HashMap localHashMap = new HashMap();
    localHashMap.put("username", paramString1);
    localHashMap.put("sendId", paramString2);
    localHashMap.put("channelId", "1");
    localHashMap.put("ver", paramString3);
    localHashMap.put("sendUserName", r.Zn());
    setRequestData(localHashMap);
    AppMethodBeat.o(42423);
  }
  
  public final String bhG()
  {
    return "/cgi-bin/mmpay-bin/sharewxhb";
  }
  
  public final int getType()
  {
    return 1668;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ar
 * JD-Core Version:    0.7.0.1
 */