package com.tencent.mm.plugin.location.ui.impl;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$6
  implements Runnable
{
  i$6(i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(113744);
    if (this.ohX.ofs)
    {
      if (this.ohX.eeN != null) {
        this.ohX.eeN.dismiss();
      }
      this.ohX.bMv();
    }
    this.ohX.ofs = false;
    AppMethodBeat.o(113744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.i.6
 * JD-Core Version:    0.7.0.1
 */