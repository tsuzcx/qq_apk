package com.tencent.mm.plugin.exdevice.model;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ac$2$1
  implements Runnable
{
  ac$2$1(ac.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(19374);
    if (this.lFX.lFV.lFU.isShowing()) {
      this.lFX.lFV.lFU.dismiss();
    }
    AppMethodBeat.o(19374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ac.2.1
 * JD-Core Version:    0.7.0.1
 */