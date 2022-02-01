package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.q;

final class ExdeviceProfileUI$5
  implements DialogInterface.OnCancelListener
{
  ExdeviceProfileUI$5(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(179604);
    if (ExdeviceProfileUI.c(this.rJu) != null)
    {
      ExdeviceProfileUI.c(this.rJu).dismiss();
      ExdeviceProfileUI.t(this.rJu);
    }
    this.rJu.finish();
    AppMethodBeat.o(179604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.5
 * JD-Core Version:    0.7.0.1
 */