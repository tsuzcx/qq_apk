package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;

final class n$1
  implements DialogInterface.OnCancelListener
{
  n$1(n paramn, q paramq) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128406);
    h.aGY().a(this.ngt);
    h.aGY().b(145, this.ngu);
    h.aGY().b(132, this.ngu);
    AppMethodBeat.o(128406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.n.1
 * JD-Core Version:    0.7.0.1
 */