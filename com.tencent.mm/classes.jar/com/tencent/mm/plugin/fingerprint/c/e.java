package com.tencent.mm.plugin.fingerprint.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends m
  implements k
{
  public String dwl;
  public String trI;
  public String tsE;
  
  public e(String paramString)
  {
    AppMethodBeat.i(64472);
    this.trI = "";
    this.dwl = "";
    this.tsE = "";
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {
      ae.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is empty");
    }
    for (;;)
    {
      localHashMap.put("encrypted_cert_info", URLEncoder.encode(paramString));
      localHashMap.put("ver", "0x1.0");
      setRequestData(localHashMap);
      AppMethodBeat.o(64472);
      return;
      ae.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is not empty");
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
      this.trI = paramJSONObject.optString("encrypted_device_info");
      this.dwl = paramJSONObject.optString("encrypted_rsa_sign");
      this.tsE = paramJSONObject.optString("cert");
      if (TextUtils.isEmpty(this.trI))
      {
        ae.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is empty");
        if (!TextUtils.isEmpty(this.dwl)) {
          break label106;
        }
        ae.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is empty");
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(this.tsE)) {
          break label116;
        }
        ae.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is empty");
        AppMethodBeat.o(64473);
        return;
        ae.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is not empty");
        break;
        label106:
        ae.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is not empty");
      }
      label116:
      ae.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is not empty");
    }
    AppMethodBeat.o(64473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.e
 * JD-Core Version:    0.7.0.1
 */