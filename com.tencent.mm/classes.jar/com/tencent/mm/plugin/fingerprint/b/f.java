package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.fingerprint.mgr.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends m
{
  public f(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(64474);
    HashMap localHashMap = new HashMap();
    localHashMap.put("encrypted_open_info", URLEncoder.encode(paramString1));
    localHashMap.put("encrypted_rsa_sign", URLEncoder.encode(paramString2));
    localHashMap.put("passwd", paramString3);
    setRequestData(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("device_type", q.aPo());
    paramString1.put("open_scene", String.valueOf(paramInt));
    setWXRequestData(paramString1);
    AppMethodBeat.o(64474);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(64475);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.i("MicroMsg.NetSceneTenpayOpenTouch", "open fingerprintpay success");
      c.vw(true);
      AppMethodBeat.o(64475);
      return;
    }
    Log.e("MicroMsg.NetSceneTenpayOpenTouch", "open fingerprintpay failed");
    AppMethodBeat.o(64475);
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.f
 * JD-Core Version:    0.7.0.1
 */