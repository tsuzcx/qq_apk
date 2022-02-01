package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class ar
  extends aq
{
  public ar(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    AppMethodBeat.i(283962);
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    localHashMap.put("limit", "11");
    localHashMap.put("offset", String.valueOf(paramInt));
    if (!Util.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("befortTimestamp", String.valueOf(paramLong));
    localHashMap.put("ver", paramString3);
    localHashMap.put("processContent", paramString4);
    localHashMap.put("union_source", "0");
    Log.i("MicroMsg.NetSceneLuckyMoneyDetailUnion", "sendId: %s, limit: %s，offet: %s, nativeUrl: %s，processContent: %s", new Object[] { paramString1, Integer.valueOf(11), Integer.valueOf(paramInt), paramString2, paramString4 });
    setRequestData(localHashMap);
    AppMethodBeat.o(283962);
  }
  
  public ar(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(283964);
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    localHashMap.put("limit", "11");
    localHashMap.put("offset", String.valueOf(paramInt));
    if (!Util.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("ver", paramString3);
    localHashMap.put("processContent", paramString4);
    localHashMap.put("union_source", "0");
    Log.i("MicroMsg.NetSceneLuckyMoneyDetailUnion", "sendId: %s, limit: %s，offet: %s, nativeUrl: %s，processContent: %s", new Object[] { paramString1, Integer.valueOf(11), Integer.valueOf(paramInt), paramString2, paramString4 });
    setRequestData(localHashMap);
    AppMethodBeat.o(283964);
  }
  
  public ar(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, 0, paramString2, paramString3, "");
  }
  
  public final String drI()
  {
    return "/cgi-bin/mmpay-bin/unionhb/qrydetailunionhb";
  }
  
  public final int getType()
  {
    return 4395;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ar
 * JD-Core Version:    0.7.0.1
 */