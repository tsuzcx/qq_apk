package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;

final class n$2
  implements DialogInterface.OnCancelListener
{
  n$2(n paramn, z paramz) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128417);
    g.aiU().a(this.jaO);
    g.aiU().b(132, this.jnA);
    AppMethodBeat.o(128417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.n.2
 * JD-Core Version:    0.7.0.1
 */