package com.tencent.mm.plugin.fingerprint.b.a;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.c.y;
import com.tencent.soter.a.b.a;
import com.tencent.soter.a.b.e;
import com.tencent.soter.core.c.j;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public String ByC;
  public String ByD;
  public int errCode = -1;
  public String errMsg;
  public int fHa = 0;
  public String fHc;
  public String fHd;
  
  public static c a(a parama)
  {
    AppMethodBeat.i(64400);
    c localc = new c();
    if (parama.isSuccess())
    {
      parama = (j)parama.ZsY;
      if (parama == null) {}
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("json", parama.ZsE);
        localJSONObject.put("signature", parama.signature);
        localc.ByC = parama.ZsE;
        localc.ByD = parama.signature;
        p.ByH.ByL = parama;
        localc.errCode = 0;
        Log.i("MicroMsg.BiometricPayAuthenticationResult", "soter authen result: %s, sign: %s", new Object[] { localc.ByC, localc.ByD });
        AppMethodBeat.o(64400);
        return localc;
      }
      catch (JSONException parama)
      {
        Log.printErrStackTrace("MicroMsg.BiometricPayAuthenticationResult", parama, "", new Object[0]);
        localc.errCode = 3000;
        continue;
      }
      Log.e("MicroMsg.BiometricPayAuthenticationResult", "signature result is null");
      localc.errCode = 3000;
      continue;
      if ((parama.errCode == 1007) || (parama.errCode == 1027) || (parama.errCode == 1018))
      {
        Log.i("MicroMsg.BiometricPayAuthenticationResult", "init error, maybe key invalid. remove former key and give suggestion");
        localc.errCode = 2007;
        p.ByH.ByJ = true;
      }
      else if ((parama.errCode == 1021) || (parama.errCode == 1022))
      {
        Log.i("MicroMsg.BiometricPayAuthenticationResult", "too many trial");
        localc.errCode = 10308;
      }
      else if (parama.errCode == 1020)
      {
        Log.i("MicroMsg.BiometricPayAuthenticationResult", "user cancelled");
        localc.errCode = 2000;
      }
      else if (parama.errCode == 1023)
      {
        Log.e("MicroMsg.BiometricPayAuthenticationResult", "add authenticate task failed");
        localc.errCode = 2009;
      }
      else
      {
        localc.errCode = 2005;
      }
    }
  }
  
  public static c ak(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(64401);
    c localc = new c();
    localc.errCode = paramInt1;
    localc.fHa = paramInt2;
    String str1 = d.getUserId();
    String str2 = q.auM();
    String str3 = y.iiR();
    localc.fHc = FingerPrintAuth.genPayFPEncrypt(d.gf(MMApplicationContext.getContext()), str1, str2, String.valueOf(paramInt2), str3, paramString, Build.MODEL);
    localc.fHd = FingerPrintAuth.genOpenFPSign(d.gf(MMApplicationContext.getContext()), d.getUserId(), q.auM(), localc.fHc);
    AppMethodBeat.o(64401);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.c
 * JD-Core Version:    0.7.0.1
 */