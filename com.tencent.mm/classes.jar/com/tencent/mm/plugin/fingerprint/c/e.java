package com.tencent.mm.plugin.fingerprint.c;

import android.text.TextUtils;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends j
  implements k
{
  public String bOV = "";
  public String klP = "";
  public String klm = "";
  
  public e(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {
      y.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is empty");
    }
    for (;;)
    {
      localHashMap.put("encrypted_cert_info", URLEncoder.encode(paramString));
      localHashMap.put("ver", "0x1.0");
      D(localHashMap);
      return;
      y.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is not empty");
    }
  }
  
  public final int HH()
  {
    return 1598;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.klm = paramJSONObject.optString("encrypted_device_info");
      this.bOV = paramJSONObject.optString("encrypted_rsa_sign");
      this.klP = paramJSONObject.optString("cert");
      if (!TextUtils.isEmpty(this.klm)) {
        break label86;
      }
      y.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is empty");
      if (!TextUtils.isEmpty(this.bOV)) {
        break label96;
      }
      y.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is empty");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.klP)) {
        break label106;
      }
      y.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is empty");
      return;
      label86:
      y.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is not empty");
      break;
      label96:
      y.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is not empty");
    }
    label106:
    y.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is not empty");
  }
  
  public final int aEC()
  {
    return 118;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/getopentouchcert";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.e
 * JD-Core Version:    0.7.0.1
 */