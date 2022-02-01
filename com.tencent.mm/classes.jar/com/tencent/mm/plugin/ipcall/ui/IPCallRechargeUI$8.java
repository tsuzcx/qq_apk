package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;

final class IPCallRechargeUI$8
  implements DialogInterface.OnCancelListener
{
  IPCallRechargeUI$8(IPCallRechargeUI paramIPCallRechargeUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(25879);
    try
    {
      if (this.JOI.JOH != null) {
        bh.aZW().a(this.JOI.JOH);
      }
      this.JOI.finish();
      AppMethodBeat.o(25879);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      Log.e("MicroMsg.IPCallRechargeUI", "cancel getProductListScene error: %s", new Object[] { paramDialogInterface.getMessage() });
      AppMethodBeat.o(25879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.8
 * JD-Core Version:    0.7.0.1
 */