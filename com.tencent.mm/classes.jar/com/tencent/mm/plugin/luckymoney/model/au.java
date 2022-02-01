package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class au
  extends ax
{
  public String wZd;
  
  public au(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(65291);
    HashMap localHashMap = new HashMap();
    localHashMap.put("totalNum", String.valueOf(paramInt1));
    localHashMap.put("totalAmount", String.valueOf(paramLong1));
    localHashMap.put("perValue", String.valueOf(paramLong2));
    localHashMap.put("hbType", String.valueOf(paramInt2));
    localHashMap.put("wishing", URLEncoder.encode(Util.nullAsNil(paramString1)));
    localHashMap.put("currency", String.valueOf(paramInt3));
    if (!Util.isNullOrNil(paramString3)) {
      localHashMap.put("headImg", URLEncoder.encode(paramString3));
    }
    localHashMap.put("nickName", URLEncoder.encode(Util.nullAsNil(paramString4)));
    if (!Util.isNullOrNil(paramString2)) {
      localHashMap.put("username", URLEncoder.encode(paramString2));
    }
    setRequestData(localHashMap);
    AppMethodBeat.o(65291);
  }
  
  public final String drI()
  {
    return "/cgi-bin/mmpay-bin/h5requestwxhb";
  }
  
  public final int drJ()
  {
    return 0;
  }
  
  public final int getType()
  {
    return 1647;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65292);
    Log.i("MicroMsg.NetSceneLuckyMoneyH5Request", "NetSceneLuckyMoneyH5Request response errCode=" + paramInt + " content:" + paramJSONObject.toString());
    if (paramInt == 0) {
      this.wZd = paramJSONObject.optString("payUrl");
    }
    AppMethodBeat.o(65292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.au
 * JD-Core Version:    0.7.0.1
 */