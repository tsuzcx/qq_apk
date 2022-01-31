package com.tencent.mm.plugin.luckymoney.sns.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends j
{
  public int lTN = 0;
  
  public a(int paramInt, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("flag", String.valueOf(paramInt));
    localHashMap.put("passwd", paramString1);
    localHashMap.put("req_key", paramString2);
    this.lTN = paramInt;
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1697;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneSnsPayManage", " errCode: " + paramInt + " errMsg :" + paramString);
    if (paramInt == 0)
    {
      if (this.lTN == 1)
      {
        com.tencent.mm.plugin.luckymoney.sns.b.a.tp(1);
        y.i("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() setIsOpenSnsPay with 1");
        return;
      }
      com.tencent.mm.plugin.luckymoney.sns.b.a.tp(0);
      y.i("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() setIsOpenSnsPay with 0");
      return;
    }
    y.e("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() NetSceneSnsPayManage is false!");
  }
  
  public final int aEC()
  {
    return 1697;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/snspaymanage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.a.a
 * JD-Core Version:    0.7.0.1
 */