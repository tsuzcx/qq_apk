package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ae;

final class h$2
  implements DialogInterface.OnCancelListener
{
  h$2(h paramh, ae paramae) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(108653);
    g.Rc().a(this.gAq);
    this.gAp.gAo.dz(false);
    AppMethodBeat.o(108653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.h.2
 * JD-Core Version:    0.7.0.1
 */