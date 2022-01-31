package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;

final class IPCallRechargeUI$8
  implements DialogInterface.OnCancelListener
{
  IPCallRechargeUI$8(IPCallRechargeUI paramIPCallRechargeUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(22259);
    try
    {
      if (this.nUW.nUV != null) {
        aw.Rc().a(this.nUW.nUV);
      }
      this.nUW.finish();
      AppMethodBeat.o(22259);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ab.e("MicroMsg.IPCallRechargeUI", "cancel getProductListScene error: %s", new Object[] { paramDialogInterface.getMessage() });
      AppMethodBeat.o(22259);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.8
 * JD-Core Version:    0.7.0.1
 */