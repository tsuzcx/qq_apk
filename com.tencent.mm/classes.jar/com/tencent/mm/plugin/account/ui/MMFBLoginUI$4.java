package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMFBLoginUI$4
  implements DialogInterface.OnClickListener
{
  MMFBLoginUI$4(MMFBLoginUI paramMMFBLoginUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(305251);
    this.qcb.finish();
    AppMethodBeat.o(305251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MMFBLoginUI.4
 * JD-Core Version:    0.7.0.1
 */