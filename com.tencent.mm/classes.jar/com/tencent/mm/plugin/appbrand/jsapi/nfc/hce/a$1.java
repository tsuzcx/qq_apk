package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.sdk.platformtools.y;
import java.util.TimerTask;

final class a$1
  extends TimerTask
{
  a$1(a parama) {}
  
  public final void run()
  {
    y.i("MicroMsg.HCEActivityMgr", "alvinluo loop check NFC switch currentCount: %d", new Object[] { Integer.valueOf(a.a(this.gyo)) });
    a.b(this.gyo);
    n.runOnUiThread(new a.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.1
 * JD-Core Version:    0.7.0.1
 */