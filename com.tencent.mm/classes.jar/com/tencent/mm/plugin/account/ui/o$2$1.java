package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;

final class o$2$1
  implements DialogInterface.OnCancelListener
{
  o$2$1(o.2 param2, u paramu) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125251);
    g.Rc().a(this.gGA);
    g.Rc().b(126, this.gGP.gGO);
    AppMethodBeat.o(125251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o.2.1
 * JD-Core Version:    0.7.0.1
 */