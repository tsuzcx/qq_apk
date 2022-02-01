package com.tencent.mm.plugin.fingerprint.mgr.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.model.y;
import com.tencent.soter.a.b.a;
import com.tencent.soter.a.b.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public String Hge;
  public String Hgf;
  public int errCode = -1;
  public String errMsg;
  public String hMA;
  public int hMx = 0;
  public String hMz;
  
  public static c a(a parama)
  {
    AppMethodBeat.i(64400);
    c localc = new c();
    if (parama.isSuccess())
    {
      parama = (com.tencent.soter.core.c.j)parama.ahxM;
      if (parama == null) {}
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("json", parama.ahxs);
        localJSONObject.put("signature", parama.signature);
        localc.Hge = parama.ahxs;
        localc.Hgf = parama.signature;
        com.tencent.mm.plugin.fingerprint.mgr.j.Hgj.Hgn = parama;
        localc.errCode = 0;
        Log.i("MicroMsg.BiometricPayAuthenticationResult", "soter authen result: %s, sign: %s", new Object[] { localc.Hge, localc.Hgf });
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
        com.tencent.mm.plugin.fingerprint.mgr.j.Hgj.Hgl = true;
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
      else if (parama.errCode == 1029)
      {
        Log.e("MicroMsg.BiometricPayAuthenticationResult", "clicked negative button");
        localc.errCode = 2010;
      }
      else
      {
        localc.errCode = 2005;
      }
    }
  }
  
  public static c ar(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(64401);
    c localc = new c();
    localc.errCode = paramInt1;
    localc.hMx = paramInt2;
    String str1 = com.tencent.mm.plugin.fingerprint.mgr.c.getUserId();
    String str2 = q.aPg();
    String str3 = y.jON();
    localc.hMz = FingerPrintAuth.genPayFPEncrypt(com.tencent.mm.plugin.fingerprint.mgr.c.hA(MMApplicationContext.getContext()), str1, str2, String.valueOf(paramInt2), str3, paramString, q.aPo());
    localc.hMA = FingerPrintAuth.genOpenFPSign(com.tencent.mm.plugin.fingerprint.mgr.c.hA(MMApplicationContext.getContext()), com.tencent.mm.plugin.fingerprint.mgr.c.getUserId(), q.aPg(), localc.hMz);
    AppMethodBeat.o(64401);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.a.c
 * JD-Core Version:    0.7.0.1
 */