package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class ExdeviceRankInfoUI$7
  implements DialogInterface.OnCancelListener
{
  ExdeviceRankInfoUI$7(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(20141);
    if (ExdeviceRankInfoUI.e(this.lPt) != null)
    {
      ExdeviceRankInfoUI.e(this.lPt).dismiss();
      ExdeviceRankInfoUI.f(this.lPt);
    }
    this.lPt.finish();
    AppMethodBeat.o(20141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.7
 * JD-Core Version:    0.7.0.1
 */