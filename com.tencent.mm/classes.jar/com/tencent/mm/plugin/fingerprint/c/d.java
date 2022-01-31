package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(41584);
    HashMap localHashMap = new HashMap();
    Object localObject = com.tencent.mm.plugin.soter.d.d.cyc();
    String str = ((e)localObject).son;
    localObject = ((e)localObject).kbP;
    localHashMap.put("cpu_id", str);
    localHashMap.put("uid", localObject);
    localHashMap.put("soter_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(41584);
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
    AppMethodBeat.i(41586);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    paramString = (l)g.E(l.class);
    if (paramString.byS()) {
      h.qsU.e(13686, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    while ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramString.hH(false);
      paramString.hI(false);
      ab.e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi success!");
      AppMethodBeat.o(41586);
      return;
      if (paramString.byV()) {
        h.qsU.e(16994, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      }
    }
    ab.e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi failed!");
    AppMethodBeat.o(41586);
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(41585);
    if (paramInt == 0) {
      if (paramJSONObject == null) {
        break label61;
      }
    }
    label61:
    for (paramInt = paramJSONObject.optInt("clear_rsa_key_level", 0);; paramInt = 0)
    {
      a.byD();
      a.byE();
      ((l)g.E(l.class)).bzi();
      AppMethodBeat.o(41585);
      return;
      ab.e("MicroMsg.NetSceneTenpayCloseTouchPay", "do close fingerprint cgi failed!");
      AppMethodBeat.o(41585);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.d
 * JD-Core Version:    0.7.0.1
 */