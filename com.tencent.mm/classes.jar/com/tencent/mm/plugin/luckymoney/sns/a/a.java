package com.tencent.mm.plugin.luckymoney.sns.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends m
{
  public int vDU;
  
  public a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(65406);
    this.vDU = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("flag", String.valueOf(paramInt));
    localHashMap.put("passwd", paramString1);
    localHashMap.put("req_key", String.valueOf(paramString2));
    this.vDU = paramInt;
    setRequestData(localHashMap);
    AppMethodBeat.o(65406);
  }
  
  public final int getFuncId()
  {
    return 1697;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1697;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/snspaymanage";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65407);
    ae.i("MicroMsg.NetSceneSnsPayManage", " errCode: " + paramInt + " errMsg :" + paramString);
    if (paramInt == 0)
    {
      if (this.vDU == 1)
      {
        com.tencent.mm.plugin.luckymoney.sns.b.a.JM(1);
        ae.i("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() setIsOpenSnsPay with 1");
        AppMethodBeat.o(65407);
        return;
      }
      com.tencent.mm.plugin.luckymoney.sns.b.a.JM(0);
      ae.i("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() setIsOpenSnsPay with 0");
      AppMethodBeat.o(65407);
      return;
    }
    ae.e("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() NetSceneSnsPayManage is false!");
    AppMethodBeat.o(65407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.a.a
 * JD-Core Version:    0.7.0.1
 */