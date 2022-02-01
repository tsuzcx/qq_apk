package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.w;

final class ExdeviceProfileUI$4
  implements DialogInterface.OnCancelListener
{
  ExdeviceProfileUI$4(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(24098);
    if (ExdeviceProfileUI.c(this.yBy) != null)
    {
      ExdeviceProfileUI.c(this.yBy).dismiss();
      ExdeviceProfileUI.t(this.yBy);
    }
    this.yBy.finish();
    AppMethodBeat.o(24098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.4
 * JD-Core Version:    0.7.0.1
 */