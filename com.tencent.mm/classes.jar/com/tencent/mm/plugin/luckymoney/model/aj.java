package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aj
  extends ak
{
  public aj(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(42407);
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", String.valueOf(paramString1));
    localHashMap.put("offset", String.valueOf(paramInt2));
    localHashMap.put("type", String.valueOf(paramInt1));
    localHashMap.put("receiveId", paramString2);
    localHashMap.put("ver", paramString3);
    setRequestData(localHashMap);
    AppMethodBeat.o(42407);
  }
  
  public final String bhG()
  {
    return "/cgi-bin/mmpay-bin/deletelistwxhb";
  }
  
  public final int getType()
  {
    return 1612;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(42408);
    ab.i("NetSceneLuckyMoneyMyRecordDelete", "onGYNetEnd");
    AppMethodBeat.o(42408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.aj
 * JD-Core Version:    0.7.0.1
 */