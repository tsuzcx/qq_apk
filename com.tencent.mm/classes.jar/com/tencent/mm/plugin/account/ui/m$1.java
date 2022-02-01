package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;

final class m$1
  implements DialogInterface.OnCancelListener
{
  m$1(m paramm, n paramn) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128406);
    g.aiU().a(this.jnw);
    g.aiU().b(145, this.jnx);
    g.aiU().b(132, this.jnx);
    AppMethodBeat.o(128406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.m.1
 * JD-Core Version:    0.7.0.1
 */