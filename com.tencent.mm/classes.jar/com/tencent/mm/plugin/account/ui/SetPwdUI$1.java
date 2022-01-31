package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class SetPwdUI$1
  implements DialogInterface.OnCancelListener
{
  SetPwdUI$1(SetPwdUI paramSetPwdUI, m paramm) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125566);
    g.Rc().a(this.ckS);
    AppMethodBeat.o(125566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SetPwdUI.1
 * JD-Core Version:    0.7.0.1
 */