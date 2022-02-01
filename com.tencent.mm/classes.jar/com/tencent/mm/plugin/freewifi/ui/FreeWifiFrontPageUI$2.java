package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiFrontPageUI$2
  implements DialogInterface.OnClickListener
{
  FreeWifiFrontPageUI$2(FreeWifiFrontPageUI paramFreeWifiFrontPageUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(25019);
    this.tpQ.finish();
    AppMethodBeat.o(25019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.2
 * JD-Core Version:    0.7.0.1
 */