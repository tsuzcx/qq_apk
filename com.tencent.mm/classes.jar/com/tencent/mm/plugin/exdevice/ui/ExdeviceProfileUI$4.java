package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class ExdeviceProfileUI$4
  implements DialogInterface.OnCancelListener
{
  ExdeviceProfileUI$4(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(20026);
    if (ExdeviceProfileUI.d(this.lOl) != null)
    {
      ExdeviceProfileUI.d(this.lOl).dismiss();
      ExdeviceProfileUI.y(this.lOl);
    }
    this.lOl.finish();
    AppMethodBeat.o(20026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.4
 * JD-Core Version:    0.7.0.1
 */