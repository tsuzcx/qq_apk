package com.tencent.mm.plugin.game.f;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1
  implements DialogInterface.OnCancelListener
{
  c$1(Dialog paramDialog) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(112293);
    this.nEd.setOnCancelListener(null);
    AppMethodBeat.o(112293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.c.1
 * JD-Core Version:    0.7.0.1
 */