package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.a;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class b$a
  implements a
{
  private b$a(b paramb) {}
  
  public final void cn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137913);
    ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND send to AppBrand, appId: %s, command: %s", new Object[] { paramString1, paramString2 });
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      ab.e("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND invalid appId or command when send request command to AppBrand");
      AppMethodBeat.o(137913);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_apdu_command", paramString2);
    this.hVb.b(paramString1, 31, localBundle);
    b.a(this.hVb);
    if (!b.b(this.hVb))
    {
      b.c(this.hVb);
      b.a(this.hVb, false);
      b.access$502(System.currentTimeMillis());
      m.aNS().o(new b.a.1(this), b.d(this.hVb));
      AppMethodBeat.o(137913);
      return;
    }
    if (b.g(this.hVb))
    {
      ab.w("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND TimeExceeded, just return default command");
      b.a(this.hVb, b.aEi(), true, b.f(this.hVb));
      b.a(this.hVb, false);
    }
    AppMethodBeat.o(137913);
  }
  
  public final void co(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137914);
    if ((b.h(this.hVb) == null) || (!b.h(this.hVb).equals(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      ab.e("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND not the same appId, or invalid response command, mAppId: %s, appId: %s, responseCommand: %s", new Object[] { b.h(this.hVb), paramString1, paramString2 });
      AppMethodBeat.o(137914);
      return;
    }
    byte[] arrayOfByte = Base64.decode(paramString2, 2);
    ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND response from AppBrand, appId: %s, command in base64: %s, send to system: %s, hasCommandNotResponded: %b", new Object[] { paramString1, paramString2, c.aj(arrayOfByte), Boolean.valueOf(b.e(this.hVb)) });
    b.a(this.hVb, arrayOfByte, false, b.f(this.hVb));
    AppMethodBeat.o(137914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b.a
 * JD-Core Version:    0.7.0.1
 */