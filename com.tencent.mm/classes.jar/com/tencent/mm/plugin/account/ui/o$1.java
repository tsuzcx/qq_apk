package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;

final class o$1
  implements DialogInterface.OnCancelListener
{
  o$1(o paramo, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128422);
    g.agi().a(this.iRx);
    g.agi().b(145, this.iUu);
    AppMethodBeat.o(128422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o.1
 * JD-Core Version:    0.7.0.1
 */