package com.tencent.mm.plugin.appbrand.menu.b;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;

final class c$1
  implements Runnable
{
  c$1(g paramg, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(147335);
    Toast.makeText(this.rEL.getContext(), this.val$text, 0).show();
    this.rEL.getRuntime().finish();
    AppMethodBeat.o(147335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b.c.1
 * JD-Core Version:    0.7.0.1
 */