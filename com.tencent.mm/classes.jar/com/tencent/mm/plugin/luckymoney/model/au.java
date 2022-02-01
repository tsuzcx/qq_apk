package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class au
  extends av
{
  public au(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(65295);
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", String.valueOf(paramString1));
    localHashMap.put("offset", String.valueOf(paramInt2));
    localHashMap.put("type", String.valueOf(paramInt1));
    localHashMap.put("receiveId", paramString2);
    localHashMap.put("ver", paramString3);
    setRequestData(localHashMap);
    AppMethodBeat.o(65295);
  }
  
  public final String czD()
  {
    return "/cgi-bin/mmpay-bin/deletelistwxhb";
  }
  
  public final int getType()
  {
    return 1612;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65296);
    Log.i("NetSceneLuckyMoneyMyRecordDelete", "onGYNetEnd");
    AppMethodBeat.o(65296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.au
 * JD-Core Version:    0.7.0.1
 */