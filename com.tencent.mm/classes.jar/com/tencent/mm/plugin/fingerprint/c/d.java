package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends j
  implements com.tencent.mm.network.k
{
  public d()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = com.tencent.mm.plugin.soter.d.d.bKR();
    String str = ((e)localObject).psl;
    localObject = ((e)localObject).psm;
    localHashMap.put("cpu_id", str);
    localHashMap.put("uid", localObject);
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1597;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    h.nFQ.f(13686, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramString = (com.tencent.mm.pluginsdk.k)g.r(com.tencent.mm.pluginsdk.k.class);
      paramString.gf(false);
      paramString.gg(false);
      y.e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi success!");
      return;
    }
    y.e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi failed!");
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramInt == 0) {
      if (paramJSONObject == null) {
        break label46;
      }
    }
    label46:
    for (paramInt = paramJSONObject.optInt("clear_rsa_key_level", 0);; paramInt = 0)
    {
      a.aSf();
      a.aSg();
      ((com.tencent.mm.pluginsdk.k)g.r(com.tencent.mm.pluginsdk.k.class)).aSN();
      return;
      y.e("MicroMsg.NetSceneTenpayCloseTouchPay", "do close fingerprint cgi failed!");
      return;
    }
  }
  
  public final int aEC()
  {
    return 116;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/closetouchpay";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.d
 * JD-Core Version:    0.7.0.1
 */