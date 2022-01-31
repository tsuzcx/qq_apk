package com.tencent.mm.plugin.appbrand.appcache;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class q$4
  implements Runnable
{
  q$4(q paramq, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(129357);
    Toast.makeText(ah.getContext(), this.val$message, 1).show();
    this.gUt.quit();
    AppMethodBeat.o(129357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.q.4
 * JD-Core Version:    0.7.0.1
 */