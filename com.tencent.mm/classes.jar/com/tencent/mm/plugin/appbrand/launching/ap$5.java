package com.tencent.mm.plugin.appbrand.launching;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

final class ap$5
  implements Runnable
{
  ap$5(ap paramap, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(174996);
    Toast.makeText(aj.getContext(), this.kLo, 0).show();
    AppMethodBeat.o(174996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ap.5
 * JD-Core Version:    0.7.0.1
 */