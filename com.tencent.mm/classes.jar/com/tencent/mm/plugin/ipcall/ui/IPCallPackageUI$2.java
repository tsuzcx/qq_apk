package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;

final class IPCallPackageUI$2
  implements DialogInterface.OnCancelListener
{
  IPCallPackageUI$2(IPCallPackageUI paramIPCallPackageUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(22221);
    try
    {
      if (IPCallPackageUI.a(this.nUs) != null) {
        aw.Rc().a(IPCallPackageUI.a(this.nUs));
      }
      this.nUs.finish();
      AppMethodBeat.o(22221);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ab.e("MicroMsg.IPCallPackageUI", "cancel getPackageProductListNetScene error: %s", new Object[] { paramDialogInterface.getMessage() });
      AppMethodBeat.o(22221);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.2
 * JD-Core Version:    0.7.0.1
 */