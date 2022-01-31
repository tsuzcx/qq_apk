package com.tencent.mm.plugin.appbrand.game.f;

import android.app.Activity;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.o;

final class c$2
  implements Runnable
{
  c$2(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(130241);
    if ((this.htH.getContext() instanceof Activity))
    {
      Window localWindow = ((Activity)this.htH.getContext()).getWindow();
      if (localWindow != null) {
        o.a(localWindow, c.a(this.htH));
      }
    }
    AppMethodBeat.o(130241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.c.2
 * JD-Core Version:    0.7.0.1
 */