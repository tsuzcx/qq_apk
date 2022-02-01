package com.tencent.mm.plugin.fingerprint.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

final class e$a
  implements o.a
{
  private e$a(e parame) {}
  
  public final void Pr(final String paramString)
  {
    AppMethodBeat.i(64319);
    this.tgJ.tgI.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64318);
        if (TextUtils.isEmpty(paramString)) {
          ad.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "rsaKey is null");
        }
        com.tencent.mm.plugin.fingerprint.c.e locale = new com.tencent.mm.plugin.fingerprint.c.e(paramString);
        g.ajD();
        g.ajB().gAO.a(locale, 0);
        AppMethodBeat.o(64318);
      }
    });
    AppMethodBeat.o(64319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.e.a
 * JD-Core Version:    0.7.0.1
 */