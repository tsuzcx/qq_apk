package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.s;

final class ExdeviceProfileUI$4
  implements DialogInterface.OnCancelListener
{
  ExdeviceProfileUI$4(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(24098);
    if (ExdeviceProfileUI.c(this.vpc) != null)
    {
      ExdeviceProfileUI.c(this.vpc).dismiss();
      ExdeviceProfileUI.t(this.vpc);
    }
    this.vpc.finish();
    AppMethodBeat.o(24098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.4
 * JD-Core Version:    0.7.0.1
 */