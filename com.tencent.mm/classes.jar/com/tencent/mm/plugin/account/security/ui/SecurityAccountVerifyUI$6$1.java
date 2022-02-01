package com.tencent.mm.plugin.account.security.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;

final class SecurityAccountVerifyUI$6$1
  implements DialogInterface.OnCancelListener
{
  SecurityAccountVerifyUI$6$1(SecurityAccountVerifyUI.6 param6, q paramq) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125603);
    h.aGY().a(this.nbz);
    AppMethodBeat.o(125603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.6.1
 * JD-Core Version:    0.7.0.1
 */