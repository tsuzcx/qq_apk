package com.tencent.mm.plugin.location.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l$3
  implements DialogInterface.OnClickListener
{
  public l$3(l paraml) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(113555);
    if (this.oen.oem != null) {
      this.oen.oem.bLW();
    }
    AppMethodBeat.o(113555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.l.3
 * JD-Core Version:    0.7.0.1
 */