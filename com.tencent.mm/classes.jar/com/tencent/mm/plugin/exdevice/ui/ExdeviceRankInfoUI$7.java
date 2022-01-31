package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.base.p;

final class ExdeviceRankInfoUI$7
  implements DialogInterface.OnCancelListener
{
  ExdeviceRankInfoUI$7(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (ExdeviceRankInfoUI.e(this.jFV) != null)
    {
      ExdeviceRankInfoUI.e(this.jFV).dismiss();
      ExdeviceRankInfoUI.f(this.jFV);
    }
    this.jFV.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.7
 * JD-Core Version:    0.7.0.1
 */