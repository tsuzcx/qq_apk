package com.tencent.mm.plugin.appbrand.launching;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class ah$1
  implements Runnable
{
  ah$1(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(131951);
    Toast.makeText(ah.getContext(), this.val$text, 0).show();
    AppMethodBeat.o(131951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ah.1
 * JD-Core Version:    0.7.0.1
 */