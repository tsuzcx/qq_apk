package com.tencent.mm.plugin.luckymoney.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s$1
  implements DialogInterface.OnCancelListener
{
  public s$1(f paramf) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(163568);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.EAb.cancel();
    AppMethodBeat.o(163568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.s.1
 * JD-Core Version:    0.7.0.1
 */