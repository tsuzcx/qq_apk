package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.e.f;
import com.tencent.mm.protocal.protobuf.cva;

final class IPCallPackageUI$a$1$1
  implements DialogInterface.OnClickListener
{
  IPCallPackageUI$a$1$1(IPCallPackageUI.a.1 param1, cva paramcva) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(22224);
    paramDialogInterface = IPCallPackageUI.b(IPCallPackageUI.a.a(this.nUw.nUu));
    paramDialogInterface.nPy += 1;
    IPCallPackageUI.a(IPCallPackageUI.a.a(this.nUw.nUu), this.nUv.ProductID);
    AppMethodBeat.o(22224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.a.1.1
 * JD-Core Version:    0.7.0.1
 */