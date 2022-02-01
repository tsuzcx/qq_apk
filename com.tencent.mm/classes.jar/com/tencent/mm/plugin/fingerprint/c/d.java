package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends m
  implements k
{
  public d(int paramInt)
  {
    AppMethodBeat.i(64469);
    HashMap localHashMap = new HashMap();
    Object localObject = com.tencent.mm.plugin.soter.d.d.ejm();
    String str = ((e)localObject).AXb;
    localObject = ((e)localObject).AXc;
    localHashMap.put("cpu_id", str);
    localHashMap.put("uid", localObject);
    localHashMap.put("soter_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(64469);
  }
  
  public final int getFuncId()
  {
    return 1597;
  }
  
  public final int getTenpayCgicmd()
  {
    return 116;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/closetouchpay";
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(64471);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    paramString = (a)com.tencent.mm.kernel.g.ab(a.class);
    if (paramString.cRT()) {
      com.tencent.mm.plugin.report.service.g.yxI.f(13686, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    while ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramString.mC(false);
      paramString.mD(false);
      ae.e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi success!");
      AppMethodBeat.o(64471);
      return;
      if (paramString.cRW()) {
        com.tencent.mm.plugin.report.service.g.yxI.f(16994, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      }
    }
    ae.e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi failed!");
    AppMethodBeat.o(64471);
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(64470);
    if (paramInt == 0) {
      if (paramJSONObject == null) {
        break label64;
      }
    }
    label64:
    for (paramInt = paramJSONObject.optInt("clear_rsa_key_level", 0);; paramInt = 0)
    {
      ((i)com.tencent.mm.kernel.g.ab(i.class)).q(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(64470);
      return;
      ae.e("MicroMsg.NetSceneTenpayCloseTouchPay", "do close fingerprint cgi failed!");
      AppMethodBeat.o(64470);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.d
 * JD-Core Version:    0.7.0.1
 */