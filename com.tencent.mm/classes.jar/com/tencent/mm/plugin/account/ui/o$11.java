package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;

final class o$11
  implements DialogInterface.OnCancelListener
{
  o$11(o paramo, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128431);
    g.aiU().a(this.jkF);
    g.aiU().b(145, this.jnD);
    AppMethodBeat.o(128431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o.11
 * JD-Core Version:    0.7.0.1
 */