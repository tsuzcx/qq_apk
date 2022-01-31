package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;

final class IPCallMyGiftCardUI$3
  implements DialogInterface.OnCancelListener
{
  IPCallMyGiftCardUI$3(IPCallMyGiftCardUI paramIPCallMyGiftCardUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(22211);
    try
    {
      if (IPCallMyGiftCardUI.a(this.nUb) != null) {
        aw.Rc().a(IPCallMyGiftCardUI.a(this.nUb));
      }
      this.nUb.finish();
      AppMethodBeat.o(22211);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ab.e("MicroMsg.IPCallMyGiftCardUI", "cancel getProductListScene error: %s", new Object[] { paramDialogInterface.getMessage() });
      AppMethodBeat.o(22211);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI.3
 * JD-Core Version:    0.7.0.1
 */