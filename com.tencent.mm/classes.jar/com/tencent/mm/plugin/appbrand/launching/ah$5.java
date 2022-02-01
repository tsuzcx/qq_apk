package com.tencent.mm.plugin.appbrand.launching;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class ah$5
  implements Runnable
{
  ah$5(ah paramah, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(174996);
    Toast.makeText(MMApplicationContext.getContext(), this.mVA, 0).show();
    AppMethodBeat.o(174996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ah.5
 * JD-Core Version:    0.7.0.1
 */