package com.tencent.mm.plugin.fingerprint.c;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends m
  implements k
{
  public f(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(41589);
    HashMap localHashMap = new HashMap();
    localHashMap.put("encrypted_open_info", URLEncoder.encode(paramString1));
    localHashMap.put("encrypted_rsa_sign", URLEncoder.encode(paramString2));
    localHashMap.put("passwd", paramString3);
    setRequestData(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("device_type", Build.MODEL);
    paramString1.put("open_scene", String.valueOf(paramInt));
    setWXRequestData(paramString1);
    AppMethodBeat.o(41589);
  }
  
  public final int getFuncId()
  {
    return 1599;
  }
  
  public final int getTenpayCgicmd()
  {
    return 119;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/androidopentouch";
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41590);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ab.i("MicroMsg.NetSceneTenpayOpenTouch", "open fingerprintpay success");
      e.hJ(true);
      AppMethodBeat.o(41590);
      return;
    }
    ab.e("MicroMsg.NetSceneTenpayOpenTouch", "open fingerprintpay failed");
    AppMethodBeat.o(41590);
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.f
 * JD-Core Version:    0.7.0.1
 */