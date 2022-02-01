package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aj
  extends am
{
  public String phy;
  
  public aj(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(65291);
    HashMap localHashMap = new HashMap();
    localHashMap.put("totalNum", String.valueOf(paramInt1));
    localHashMap.put("totalAmount", String.valueOf(paramLong1));
    localHashMap.put("perValue", String.valueOf(paramLong2));
    localHashMap.put("hbType", String.valueOf(paramInt2));
    localHashMap.put("wishing", URLEncoder.encode(bu.nullAsNil(paramString1)));
    localHashMap.put("currency", String.valueOf(paramInt3));
    if (!bu.isNullOrNil(paramString3)) {
      localHashMap.put("headImg", URLEncoder.encode(paramString3));
    }
    localHashMap.put("nickName", URLEncoder.encode(bu.nullAsNil(paramString4)));
    if (!bu.isNullOrNil(paramString2)) {
      localHashMap.put("username", URLEncoder.encode(paramString2));
    }
    setRequestData(localHashMap);
    AppMethodBeat.o(65291);
  }
  
  public final String cbJ()
  {
    return "/cgi-bin/mmpay-bin/h5requestwxhb";
  }
  
  public final int cbK()
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
    ae.i("MicroMsg.NetSceneLuckyMoneyH5Request", "NetSceneLuckyMoneyH5Request response errCode=".concat(String.valueOf(paramInt)));
    if (paramInt == 0) {
      this.phy = paramJSONObject.optString("payUrl");
    }
    AppMethodBeat.o(65292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.aj
 * JD-Core Version:    0.7.0.1
 */