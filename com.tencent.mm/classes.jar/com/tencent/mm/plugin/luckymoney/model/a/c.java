package com.tencent.mm.plugin.luckymoney.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.bb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends bb
{
  public c(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3, String paramString6, String paramString7, int paramInt4, int paramInt5, String paramString8, String paramString9, int paramInt6, String paramString10, String paramString11, String paramString12, int paramInt7)
  {
    AppMethodBeat.i(208780);
    Log.i("MicroMsg.NetSceneLivePrepareLuckyMoney", "NetScenePrepareLuckyMoney() uniqueId:%s, userConfiremJump:%s, unpayType:%s, cancelSendId:%s", new Object[] { paramString7, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Util.nullAsNil(paramString8) });
    this.tVd = paramInt1;
    HashMap localHashMap = new HashMap();
    if (paramInt2 == 3) {
      localHashMap.put("totalNum", "1");
    }
    for (;;)
    {
      localHashMap.put("totalAmount", String.valueOf(paramLong1));
      localHashMap.put("perValue", String.valueOf(paramLong2));
      localHashMap.put("hbType", String.valueOf(paramInt2));
      localHashMap.put("wishing", URLEncoder.encode(Util.nullAsNil(paramString1)));
      localHashMap.put("sendUserName", paramString4);
      if (!Util.isNullOrNil(paramString7)) {
        localHashMap.put("unique_id", paramString7);
      }
      localHashMap.put("user_confirm_jump", String.valueOf(paramInt4));
      localHashMap.put("unpay_type", String.valueOf(paramInt5));
      localHashMap.put("cancel_sendid", paramString8);
      localHashMap.put("expression_md5", paramString9);
      localHashMap.put("expression_type", String.valueOf(paramInt6));
      if (!Util.isNullOrNil(paramString2))
      {
        localHashMap.put("headImg", URLEncoder.encode(paramString2));
        localHashMap.put("nickName", URLEncoder.encode(Util.nullAsNil(paramString5)));
        if (!Util.isNullOrNil(paramString3)) {
          localHashMap.put("receiveNickName", URLEncoder.encode(paramString3));
        }
      }
      localHashMap.put("inWay", String.valueOf(paramInt3));
      if ((paramInt3 == 0) || (paramInt3 == 1) || (paramInt3 == 7)) {
        localHashMap.put("needSendToMySelf", "0");
      }
      localHashMap.put("showSourceMac", URLEncoder.encode(paramString6));
      localHashMap.put("exclusiveRecvUsername", paramString10);
      localHashMap.put("liveid", paramString11);
      localHashMap.put("liveattach", paramString12);
      if (paramInt7 > 0) {
        localHashMap.put("channellive_sender_flag", String.valueOf(paramInt7));
      }
      localHashMap.put("scene", "23");
      setRequestData(localHashMap);
      AppMethodBeat.o(208780);
      return;
      localHashMap.put("totalNum", String.valueOf(paramInt1));
    }
  }
  
  public final String cOd()
  {
    return "/cgi-bin/mmpay-bin/ftfhb/channelliverequestwxhb";
  }
  
  public final int getType()
  {
    return 4373;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.a.c
 * JD-Core Version:    0.7.0.1
 */