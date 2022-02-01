package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ao
  extends am
{
  public String vAq;
  public String vvw;
  
  public ao(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65300);
    this.vAq = paramString3;
    this.vvw = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    localHashMap.put("receiveId", paramString3);
    localHashMap.put("wishing", URLEncoder.encode(bu.nullAsNil(paramString2)));
    localHashMap.put("ver", paramString4);
    setRequestData(localHashMap);
    AppMethodBeat.o(65300);
  }
  
  public final String cbJ()
  {
    return "/cgi-bin/mmpay-bin/wishwxhb";
  }
  
  public final int getType()
  {
    return 1682;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ao
 * JD-Core Version:    0.7.0.1
 */