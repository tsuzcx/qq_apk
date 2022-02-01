package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class ExdeviceProfileUI$5
  implements DialogInterface.OnCancelListener
{
  ExdeviceProfileUI$5(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(179604);
    if (ExdeviceProfileUI.d(this.peX) != null)
    {
      ExdeviceProfileUI.d(this.peX).dismiss();
      ExdeviceProfileUI.y(this.peX);
    }
    this.peX.finish();
    AppMethodBeat.o(179604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.5
 * JD-Core Version:    0.7.0.1
 */