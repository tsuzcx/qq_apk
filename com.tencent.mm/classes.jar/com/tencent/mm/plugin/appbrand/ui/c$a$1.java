package com.tencent.mm.plugin.appbrand.ui;

import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.preload.ui.BootstrapProgressBar;

final class c$a$1
  implements Runnable
{
  c$a$1(c.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(132943);
    if (c.q(this.iMx.iMp).getVisibility() == 0) {
      c.r(this.iMx.iMp).setProgress(c.a.a(this.iMx));
    }
    AppMethodBeat.o(132943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c.a.1
 * JD-Core Version:    0.7.0.1
 */