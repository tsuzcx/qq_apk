package com.tencent.mm.plugin.luckymoney.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class s$1
  implements DialogInterface.OnCancelListener
{
  s$1(s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(42339);
    this.oov.forceCancel();
    AppMethodBeat.o(42339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.s.1
 * JD-Core Version:    0.7.0.1
 */