package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;

final class n$1
  implements DialogInterface.OnCancelListener
{
  n$1(n paramn, q paramq) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128406);
    g.azz().a(this.koB);
    g.azz().b(145, this.koC);
    g.azz().b(132, this.koC);
    AppMethodBeat.o(128406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.n.1
 * JD-Core Version:    0.7.0.1
 */