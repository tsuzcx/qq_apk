package com.tencent.mm.plugin.appbrand.launching;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class ax$1
  implements Runnable
{
  ax$1(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(47313);
    Toast.makeText(MMApplicationContext.getContext(), this.val$text, 0).show();
    AppMethodBeat.o(47313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ax.1
 * JD-Core Version:    0.7.0.1
 */