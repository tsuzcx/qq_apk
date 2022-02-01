package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiEntryUI$3
  implements DialogInterface.OnClickListener
{
  FreeWifiEntryUI$3(FreeWifiEntryUI paramFreeWifiEntryUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(25012);
    this.wRp.finish();
    AppMethodBeat.o(25012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiEntryUI.3
 * JD-Core Version:    0.7.0.1
 */