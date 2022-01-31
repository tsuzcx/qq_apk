package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.base.p;

final class ExdeviceProfileUI$4
  implements DialogInterface.OnCancelListener
{
  ExdeviceProfileUI$4(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (ExdeviceProfileUI.d(this.jEM) != null)
    {
      ExdeviceProfileUI.d(this.jEM).dismiss();
      ExdeviceProfileUI.y(this.jEM);
    }
    this.jEM.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.4
 * JD-Core Version:    0.7.0.1
 */