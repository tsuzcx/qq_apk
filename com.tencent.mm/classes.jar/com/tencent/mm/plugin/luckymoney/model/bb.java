package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class bb
  extends ba
{
  public bb(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3, String paramString7, String paramString8, int paramInt4, int paramInt5, String paramString9, String paramString10, int paramInt6)
  {
    AppMethodBeat.i(213328);
    this.qwe = paramInt1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("totalNum", String.valueOf(paramInt1));
    localHashMap.put("totalAmount", String.valueOf(paramLong1));
    localHashMap.put("perValue", String.valueOf(paramLong2));
    localHashMap.put("hbType", String.valueOf(paramInt2));
    localHashMap.put("wishing", URLEncoder.encode(Util.nullAsNil(paramString1)));
    localHashMap.put("sendUserName", paramString5);
    if (!Util.isNullOrNil(paramString8)) {
      localHashMap.put("unique_id", paramString8);
    }
    localHashMap.put("user_confirm_jump", String.valueOf(paramInt4));
    localHashMap.put("unpay_type", String.valueOf(paramInt5));
    localHashMap.put("cancel_sendid", paramString9);
    localHashMap.put("expression_md5", paramString10);
    localHashMap.put("expression_type", String.valueOf(paramInt6));
    if (!Util.isNullOrNil(paramString3)) {
      localHashMap.put("username", paramString3);
    }
    if (!Util.isNullOrNil(paramString2))
    {
      localHashMap.put("headImg", URLEncoder.encode(paramString2));
      localHashMap.put("nickName", URLEncoder.encode(Util.nullAsNil(paramString6)));
      if (!Util.isNullOrNil(paramString4)) {
        localHashMap.put("receiveNickName", URLEncoder.encode(paramString4));
      }
    }
    localHashMap.put("inWay", String.valueOf(paramInt3));
    if ((paramInt3 == 0) || (paramInt3 == 1) || (paramInt3 == 7)) {
      localHashMap.put("needSendToMySelf", "0");
    }
    localHashMap.put("showSourceMac", URLEncoder.encode(paramString7));
    localHashMap.put("scene", "20");
    localHashMap.put("union_source", "0");
    Log.i("MicroMsg.NetScenePrepareLuckyMoneyUnion", "NetScenePrepareLuckyMoneyUnion request :uniqueId:%s, userConfiremJump:%s, unpayType:%s, cancelSendId:%s", new Object[] { paramString8, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Util.nullAsNil(paramString9) });
    setRequestData(localHashMap);
    AppMethodBeat.o(213328);
  }
  
  public final String czD()
  {
    return "/cgi-bin/mmpay-bin/unionhb/requestunionhb";
  }
  
  public final int getType()
  {
    return 4915;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bb
 * JD-Core Version:    0.7.0.1
 */