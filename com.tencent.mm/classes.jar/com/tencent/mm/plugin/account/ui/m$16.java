package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelfriend.a;

final class m$16
  implements DialogInterface.OnCancelListener
{
  m$16(m paramm, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128315);
    h.aGY().a(this.ndy);
    AppMethodBeat.o(128315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.m.16
 * JD-Core Version:    0.7.0.1
 */