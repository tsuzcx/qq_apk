package com.tencent.mm.plugin.luckymoney.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.luckymoney.model.bf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class e
  extends bf
{
  public e(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3)
  {
    AppMethodBeat.i(283894);
    this.msgType = 1;
    this.channelId = paramInt1;
    this.CAf = paramString1;
    this.ihx = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", "1");
    localHashMap.put("channelId", String.valueOf(paramInt1));
    localHashMap.put("sendId", paramString1);
    localHashMap.put("inWay", String.valueOf(paramInt2));
    localHashMap.put("ver", paramString3);
    h.baF();
    long l = ((Long)h.baE().ban().get(at.a.acML, Long.valueOf(0L))).longValue();
    if (l > 0L)
    {
      if (System.currentTimeMillis() >= l) {
        break label254;
      }
      localHashMap.put("agreeDuty", "0");
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString2)) {
        localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
      }
      localHashMap.put("group_name", paramString4);
      localHashMap.put("liveid", paramString5);
      localHashMap.put("liveattach", paramString6);
      if (paramInt3 > 0) {
        localHashMap.put("channellive_sender_flag", String.valueOf(paramInt3));
      }
      Log.i("MicroMsg.NetSceneLiveReceiveLuckyMoney", "NetSceneReceiveLuckyMoney request");
      setRequestData(localHashMap);
      AppMethodBeat.o(283894);
      return;
      label254:
      paramString1 = new StringBuilder();
      h.baF();
      localHashMap.put("agreeDuty", (Integer)h.baE().ban().get(at.a.acMM, Integer.valueOf(1)));
    }
  }
  
  public final String drI()
  {
    return "/cgi-bin/mmpay-bin/ftfhb/channellivereceivewxhb";
  }
  
  public final int getType()
  {
    return 4717;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.a.e
 * JD-Core Version:    0.7.0.1
 */