package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.report.service.h;

final class IPCallRechargeUI$2
  implements DialogInterface.OnClickListener
{
  IPCallRechargeUI$2(IPCallRechargeUI paramIPCallRechargeUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(25872);
    h.vKh.idkeyStat(257L, 3L, 1L, true);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("rawUrl", this.sIR);
    paramDialogInterface.putExtra("showShare", false);
    d.b(this.sIQ, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    AppMethodBeat.o(25872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.2
 * JD-Core Version:    0.7.0.1
 */