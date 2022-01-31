package com.tencent.mm.plugin.appbrand.ui;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$3
  implements Runnable
{
  f$3(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(102313);
    this.iNc.setVisibility(8);
    if (this.iNc.getParent() != null) {
      ((ViewGroup)this.iNc.getParent()).removeView(this.iNc);
    }
    AppMethodBeat.o(102313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.f.3
 * JD-Core Version:    0.7.0.1
 */