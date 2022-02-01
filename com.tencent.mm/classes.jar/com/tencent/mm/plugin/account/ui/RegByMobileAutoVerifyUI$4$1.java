package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.v;

final class RegByMobileAutoVerifyUI$4$1
  implements DialogInterface.OnCancelListener
{
  RegByMobileAutoVerifyUI$4$1(RegByMobileAutoVerifyUI.4 param4, v paramv) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(222010);
    h.aGY().a(this.ngm);
    AppMethodBeat.o(222010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.4.1
 * JD-Core Version:    0.7.0.1
 */