package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class b$1$1
  implements DialogInterface.OnCancelListener
{
  b$1$1(b.1 param1, m paramm) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(124715);
    g.Rc().a(this.ckS);
    AppMethodBeat.o(124715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.b.1.1
 * JD-Core Version:    0.7.0.1
 */