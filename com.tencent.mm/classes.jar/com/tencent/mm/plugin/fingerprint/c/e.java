package com.tencent.mm.plugin.fingerprint.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends m
  implements k
{
  public String cwm;
  public String mGG;
  public String mGa;
  
  public e(String paramString)
  {
    AppMethodBeat.i(41587);
    this.mGa = "";
    this.cwm = "";
    this.mGG = "";
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {
      ab.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is empty");
    }
    for (;;)
    {
      localHashMap.put("encrypted_cert_info", URLEncoder.encode(paramString));
      localHashMap.put("ver", "0x1.0");
      setRequestData(localHashMap);
      AppMethodBeat.o(41587);
      return;
      ab.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is not empty");
    }
  }
  
  public final int getFuncId()
  {
    return 1598;
  }
  
  public final int getTenpayCgicmd()
  {
    return 118;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/getopentouchcert";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(41588);
    if (paramJSONObject != null)
    {
      this.mGa = paramJSONObject.optString("encrypted_device_info");
      this.cwm = paramJSONObject.optString("encrypted_rsa_sign");
      this.mGG = paramJSONObject.optString("cert");
      if (TextUtils.isEmpty(this.mGa))
      {
        ab.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is empty");
        if (!TextUtils.isEmpty(this.cwm)) {
          break label106;
        }
        ab.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is empty");
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(this.mGG)) {
          break label116;
        }
        ab.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is empty");
        AppMethodBeat.o(41588);
        return;
        ab.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is not empty");
        break;
        label106:
        ab.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is not empty");
      }
      label116:
      ab.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is not empty");
    }
    AppMethodBeat.o(41588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.e
 * JD-Core Version:    0.7.0.1
 */