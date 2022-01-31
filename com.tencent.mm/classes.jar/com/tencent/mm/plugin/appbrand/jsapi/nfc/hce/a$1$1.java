package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1$1
  implements Runnable
{
  a$1$1(a.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(137884);
    if (a.a(this.hUO.hUN) > 10)
    {
      ab.i("MicroMsg.HCEActivityMgr", "alvinluo loop check count exceed max limit: %d", new Object[] { Integer.valueOf(10) });
      a.c(this.hUO.hUN);
      a.d(this.hUO.hUN);
      AppMethodBeat.o(137884);
      return;
    }
    if (d.aEm())
    {
      ab.i("MicroMsg.HCEActivityMgr", "alvinluo loopCheck NFC switch is opened, and cancel task");
      a.c(this.hUO.hUN);
      a.e(this.hUO.hUN);
    }
    AppMethodBeat.o(137884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.1.1
 * JD-Core Version:    0.7.0.1
 */