package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;

final class IPCallRechargeUI$2
  implements DialogInterface.OnClickListener
{
  IPCallRechargeUI$2(IPCallRechargeUI paramIPCallRechargeUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.a(257L, 3L, 1L, true);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("rawUrl", this.lxK);
    paramDialogInterface.putExtra("showShare", false);
    d.b(this.lxJ, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.2
 * JD-Core Version:    0.7.0.1
 */