package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.account.friend.a.ah;

final class g$1
  implements DialogInterface.OnCancelListener
{
  g$1(g paramg, ah paramah) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(108648);
    com.tencent.mm.kernel.g.Rc().a(this.gAm);
    this.gAn.gAj.f(false, this.gAn.gAl);
    AppMethodBeat.o(108648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.g.1
 * JD-Core Version:    0.7.0.1
 */