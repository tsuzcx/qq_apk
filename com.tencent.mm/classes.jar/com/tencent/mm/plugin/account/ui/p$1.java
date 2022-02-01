package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelfriend.a;

final class p$1
  implements DialogInterface.OnCancelListener
{
  p$1(p paramp, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128422);
    h.aGY().a(this.ndy);
    h.aGY().b(145, this.ngA);
    AppMethodBeat.o(128422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.p.1
 * JD-Core Version:    0.7.0.1
 */