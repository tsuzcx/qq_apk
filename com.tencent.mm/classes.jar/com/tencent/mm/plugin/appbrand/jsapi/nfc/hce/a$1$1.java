package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.sdk.platformtools.y;

final class a$1$1
  implements Runnable
{
  a$1$1(a.1 param1) {}
  
  public final void run()
  {
    if (a.a(this.gyp.gyo) > 10)
    {
      y.i("MicroMsg.HCEActivityMgr", "alvinluo loop check count exceed max limit: %d", new Object[] { Integer.valueOf(10) });
      a.c(this.gyp.gyo);
      a.d(this.gyp.gyo);
    }
    while (!d.ajN()) {
      return;
    }
    y.i("MicroMsg.HCEActivityMgr", "alvinluo loopCheck NFC switch is opened, and cancel task");
    a.c(this.gyp.gyo);
    a.e(this.gyp.gyo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.1.1
 * JD-Core Version:    0.7.0.1
 */