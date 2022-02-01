package com.tencent.mm.plugin.fingerprint.b.a;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.wallet_core.c.y;
import com.tencent.soter.a.b.a;
import com.tencent.soter.a.b.e;
import com.tencent.soter.core.c.j;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public int dlI = 0;
  public String dlK;
  public String dlL;
  public int errCode = -1;
  public String errMsg;
  public String rck;
  public String rcl;
  
  public static c a(a parama)
  {
    AppMethodBeat.i(64400);
    c localc = new c();
    if (parama.isSuccess())
    {
      parama = (j)parama.Ivv;
      if (parama == null) {}
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("json", parama.Iva);
        localJSONObject.put("signature", parama.signature);
        localc.rck = parama.Iva;
        localc.rcl = parama.signature;
        p.rcp.rct = parama;
        localc.errCode = 0;
        ad.i("MicroMsg.BiometricPayAuthenticationResult", "soter authen result: %s, sign: %s", new Object[] { localc.rck, localc.rcl });
        AppMethodBeat.o(64400);
        return localc;
      }
      catch (JSONException parama)
      {
        ad.printErrStackTrace("MicroMsg.BiometricPayAuthenticationResult", parama, "", new Object[0]);
        localc.errCode = 3000;
        continue;
      }
      ad.e("MicroMsg.BiometricPayAuthenticationResult", "signature result is null");
      localc.errCode = 3000;
      continue;
      if ((parama.errCode == 1007) || (parama.errCode == 1027) || (parama.errCode == 1018))
      {
        ad.i("MicroMsg.BiometricPayAuthenticationResult", "init error, maybe key invalid. remove former key and give suggestion");
        localc.errCode = 2007;
        p.rcp.rcr = true;
      }
      else if ((parama.errCode == 1021) || (parama.errCode == 1022))
      {
        ad.i("MicroMsg.BiometricPayAuthenticationResult", "too many trial");
        localc.errCode = 10308;
      }
      else if (parama.errCode == 1020)
      {
        ad.i("MicroMsg.BiometricPayAuthenticationResult", "user cancelled");
        localc.errCode = 2000;
      }
      else if (parama.errCode == 1023)
      {
        ad.e("MicroMsg.BiometricPayAuthenticationResult", "add authenticate task failed");
        localc.errCode = 2009;
      }
      else
      {
        localc.errCode = 2005;
      }
    }
  }
  
  public static c ac(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(64401);
    c localc = new c();
    localc.errCode = paramInt1;
    localc.dlI = paramInt2;
    String str1 = d.getUserId();
    String str2 = q.Xa();
    String str3 = y.fjW();
    localc.dlK = FingerPrintAuth.genPayFPEncrypt(d.eM(aj.getContext()), str1, str2, String.valueOf(paramInt2), str3, paramString, Build.MODEL);
    localc.dlL = FingerPrintAuth.genOpenFPSign(d.eM(aj.getContext()), d.getUserId(), q.Xa(), localc.dlK);
    AppMethodBeat.o(64401);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.c
 * JD-Core Version:    0.7.0.1
 */