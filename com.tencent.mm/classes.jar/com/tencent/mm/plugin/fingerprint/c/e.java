package com.tencent.mm.plugin.fingerprint.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends m
  implements k
{
  public String dvg;
  public String tgP;
  public String thL;
  
  public e(String paramString)
  {
    AppMethodBeat.i(64472);
    this.tgP = "";
    this.dvg = "";
    this.thL = "";
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {
      ad.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is empty");
    }
    for (;;)
    {
      localHashMap.put("encrypted_cert_info", URLEncoder.encode(paramString));
      localHashMap.put("ver", "0x1.0");
      setRequestData(localHashMap);
      AppMethodBeat.o(64472);
      return;
      ad.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is not empty");
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
    AppMethodBeat.i(64473);
    if (paramJSONObject != null)
    {
      this.tgP = paramJSONObject.optString("encrypted_device_info");
      this.dvg = paramJSONObject.optString("encrypted_rsa_sign");
      this.thL = paramJSONObject.optString("cert");
      if (TextUtils.isEmpty(this.tgP))
      {
        ad.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is empty");
        if (!TextUtils.isEmpty(this.dvg)) {
          break label106;
        }
        ad.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is empty");
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(this.thL)) {
          break label116;
        }
        ad.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is empty");
        AppMethodBeat.o(64473);
        return;
        ad.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is not empty");
        break;
        label106:
        ad.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is not empty");
      }
      label116:
      ad.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is not empty");
    }
    AppMethodBeat.o(64473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.e
 * JD-Core Version:    0.7.0.1
 */