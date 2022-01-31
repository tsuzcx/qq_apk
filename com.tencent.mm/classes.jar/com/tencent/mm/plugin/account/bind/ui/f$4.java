package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$4
  implements DialogInterface.OnClickListener
{
  f$4(f paramf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13753);
    this.gwn.gwf = null;
    this.gwn.onDetach();
    this.gwn.apV();
    AppMethodBeat.o(13753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.f.4
 * JD-Core Version:    0.7.0.1
 */