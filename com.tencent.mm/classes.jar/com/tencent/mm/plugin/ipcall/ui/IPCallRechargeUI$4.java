package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.br.c;

final class IPCallRechargeUI$4
  implements DialogInterface.OnClickListener
{
  IPCallRechargeUI$4(IPCallRechargeUI paramIPCallRechargeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(25874);
    this.JOI.finish();
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("rawUrl", this.JOI.getString(R.l.gKq));
    paramDialogInterface.putExtra("showShare", false);
    c.b(this.JOI, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    AppMethodBeat.o(25874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.4
 * JD-Core Version:    0.7.0.1
 */