package com.tencent.mm.plugin.location.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l$5
  implements DialogInterface.OnClickListener
{
  public l$5(l paraml, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(113557);
    if (this.oen.oem != null) {
      this.oen.oem.yc(this.bHS);
    }
    AppMethodBeat.o(113557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.l.5
 * JD-Core Version:    0.7.0.1
 */