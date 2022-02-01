package com.tencent.mm.plugin.luckymoney.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.ap;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends ap
{
  public d(String paramString1, int paramInt1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2)
  {
    AppMethodBeat.i(267621);
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    localHashMap.put("limit", "11");
    localHashMap.put("offset", String.valueOf(paramInt1));
    if (!Util.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("befortTimestamp", String.valueOf(paramLong));
    localHashMap.put("ver", paramString3);
    localHashMap.put("processContent", paramString4);
    localHashMap.put("liveid", paramString5);
    localHashMap.put("liveattach", paramString6);
    if (paramInt2 > 0) {
      localHashMap.put("channellive_sender_flag", String.valueOf(paramInt2));
    }
    Log.i("MicroMsg.NetSceneLiveQryLuckyMoneyDetail", "sendId: %s, limit: %s，offet: %s, nativeUrl: %s，processContent: %s", new Object[] { paramString1, Integer.valueOf(11), Integer.valueOf(paramInt1), paramString2, paramString4 });
    setRequestData(localHashMap);
    AppMethodBeat.o(267621);
  }
  
  public d(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2)
  {
    AppMethodBeat.i(267622);
    HashMap localHashMap = new HashMap();
    localHashMap.put("sendId", paramString1);
    localHashMap.put("limit", "11");
    localHashMap.put("offset", String.valueOf(paramInt1));
    if (!Util.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    localHashMap.put("ver", paramString3);
    localHashMap.put("processContent", paramString4);
    localHashMap.put("liveid", paramString5);
    localHashMap.put("liveattach", paramString6);
    if (paramInt2 > 0) {
      localHashMap.put("channellive_sender_flag", String.valueOf(paramInt2));
    }
    Log.i("MicroMsg.NetSceneLiveQryLuckyMoneyDetail", "sendId: %s, limit: %s，offet: %s, nativeUrl: %s，processContent: %s", new Object[] { paramString1, Integer.valueOf(11), Integer.valueOf(paramInt1), paramString2, paramString4 });
    setRequestData(localHashMap);
    AppMethodBeat.o(267622);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this(paramString1, 0, paramString2, paramString3, "", paramString4, paramString5, paramInt);
  }
  
  public final String cOd()
  {
    return "/cgi-bin/mmpay-bin/ftfhb/channelliveqrydetailwxhb";
  }
  
  public final int getType()
  {
    return 4339;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.a.d
 * JD-Core Version:    0.7.0.1
 */