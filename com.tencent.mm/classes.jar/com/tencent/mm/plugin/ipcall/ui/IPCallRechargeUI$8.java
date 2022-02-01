package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.ad;

final class IPCallRechargeUI$8
  implements DialogInterface.OnCancelListener
{
  IPCallRechargeUI$8(IPCallRechargeUI paramIPCallRechargeUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(25879);
    try
    {
      if (this.uTj.uTi != null) {
        ba.aiU().a(this.uTj.uTi);
      }
      this.uTj.finish();
      AppMethodBeat.o(25879);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ad.e("MicroMsg.IPCallRechargeUI", "cancel getProductListScene error: %s", new Object[] { paramDialogInterface.getMessage() });
      AppMethodBeat.o(25879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.8
 * JD-Core Version:    0.7.0.1
 */