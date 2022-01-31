package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.a;
import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$a
  implements a
{
  private b$a(b paramb) {}
  
  public final void bE(String paramString1, String paramString2)
  {
    y.i("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND send to AppBrand, appId: %s, command: %s", new Object[] { paramString1, paramString2 });
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      y.e("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND invalid appId or command when send request command to AppBrand");
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putString("key_apdu_command", paramString2);
      this.gyB.b(paramString1, 31, localBundle);
      b.a(this.gyB);
      if (!b.b(this.gyB))
      {
        b.c(this.gyB);
        b.a(this.gyB, false);
        b.cA(System.currentTimeMillis());
        n.DS().k(new b.a.1(this), b.d(this.gyB));
        return;
      }
    } while (!b.g(this.gyB));
    y.w("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND TimeExceeded, just return default command");
    b.a(this.gyB, b.ajK(), true, b.f(this.gyB));
    b.a(this.gyB, false);
  }
  
  public final void bF(String paramString1, String paramString2)
  {
    if ((b.h(this.gyB) == null) || (!b.h(this.gyB).equals(paramString1)) || (bk.bl(paramString2)))
    {
      y.e("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND not the same appId, or invalid response command, mAppId: %s, appId: %s, responseCommand: %s", new Object[] { b.h(this.gyB), paramString1, paramString2 });
      return;
    }
    byte[] arrayOfByte = Base64.decode(paramString2, 2);
    y.i("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND response from AppBrand, appId: %s, command in base64: %s, send to system: %s, hasCommandNotResponded: %b", new Object[] { paramString1, paramString2, c.P(arrayOfByte), Boolean.valueOf(b.e(this.gyB)) });
    b.a(this.gyB, arrayOfByte, false, b.f(this.gyB));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b.a
 * JD-Core Version:    0.7.0.1
 */