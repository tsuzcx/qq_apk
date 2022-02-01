package com.tencent.mm.plugin.fingerprint.mgr;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class GenFingerPrintRsaKeyEventListener$a
  implements i.a
{
  private GenFingerPrintRsaKeyEventListener$a(GenFingerPrintRsaKeyEventListener paramGenFingerPrintRsaKeyEventListener) {}
  
  public final void aal(final String paramString)
  {
    AppMethodBeat.i(64319);
    this.HfI.HfH.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64318);
        if (TextUtils.isEmpty(paramString)) {
          Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "rsaKey is null");
        }
        e locale = new e(paramString);
        h.baF();
        h.baD().mCm.a(locale, 0);
        AppMethodBeat.o(64318);
      }
    });
    AppMethodBeat.o(64319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.GenFingerPrintRsaKeyEventListener.a
 * JD-Core Version:    0.7.0.1
 */