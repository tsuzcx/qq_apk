package com.tencent.mm.bg;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$2
  implements DialogInterface.OnCancelListener
{
  e$2(Runnable paramRunnable) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(78813);
    if (this.fUL != null) {
      this.fUL.run();
    }
    AppMethodBeat.o(78813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bg.e.2
 * JD-Core Version:    0.7.0.1
 */