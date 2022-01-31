package com.tencent.mm.plugin.appbrand.menu;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.i;

final class f$1
  implements Runnable
{
  f$1(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(102130);
    Toast.makeText(this.hTA.getContext(), this.val$text, 0).show();
    this.hTA.getRuntime().finish();
    AppMethodBeat.o(102130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.f.1
 * JD-Core Version:    0.7.0.1
 */