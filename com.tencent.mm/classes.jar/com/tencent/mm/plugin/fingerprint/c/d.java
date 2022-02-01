package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.wallet_core.tenpay.model.m
  implements com.tencent.mm.network.m
{
  public d(int paramInt)
  {
    AppMethodBeat.i(64469);
    HashMap localHashMap = new HashMap();
    Object localObject = com.tencent.mm.plugin.soter.d.d.flM();
    String str = ((e)localObject).FhU;
    localObject = ((e)localObject).hFF;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(64471);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    paramString = (a)g.af(a.class);
    if (paramString.dJO()) {
      h.CyF.a(13686, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    while ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramString.pj(false);
      paramString.pk(false);
      Log.e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi success!");
      AppMethodBeat.o(64471);
      return;
      if (paramString.dJR()) {
        h.CyF.a(16994, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      }
    }
    Log.e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi failed!");
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
      ((i)g.af(i.class)).q(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(64470);
      return;
      Log.e("MicroMsg.NetSceneTenpayCloseTouchPay", "do close fingerprint cgi failed!");
      AppMethodBeat.o(64470);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.d
 * JD-Core Version:    0.7.0.1
 */