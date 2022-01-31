package com.tencent.mm.plugin.appbrand.launching;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class w$3
  implements Runnable
{
  w$3(w paramw, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(131890);
    Toast.makeText(ah.getContext(), this.ilO, 0).show();
    AppMethodBeat.o(131890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.w.3
 * JD-Core Version:    0.7.0.1
 */