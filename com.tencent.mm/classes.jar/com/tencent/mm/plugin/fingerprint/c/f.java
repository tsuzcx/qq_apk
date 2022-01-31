package com.tencent.mm.plugin.fingerprint.c;

import android.os.Build;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends j
  implements k
{
  public f(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("encrypted_open_info", URLEncoder.encode(paramString1));
    localHashMap.put("encrypted_rsa_sign", URLEncoder.encode(paramString2));
    localHashMap.put("passwd", paramString3);
    D(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("device_type", Build.MODEL);
    paramString1.put("open_scene", String.valueOf(paramInt));
    aC(paramString1);
  }
  
  public final int HH()
  {
    return 1599;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      y.i("MicroMsg.NetSceneTenpayOpenTouch", "open fingerprintpay success");
      e.gh(true);
      return;
    }
    y.e("MicroMsg.NetSceneTenpayOpenTouch", "open fingerprintpay failed");
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject) {}
  
  public final int aEC()
  {
    return 119;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/androidopentouch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.f
 * JD-Core Version:    0.7.0.1
 */