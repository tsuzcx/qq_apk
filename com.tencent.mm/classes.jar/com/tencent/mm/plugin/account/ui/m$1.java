package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class m$1
  implements DialogInterface.OnCancelListener
{
  m$1(m paramm, com.tencent.mm.ai.m paramm1) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125234);
    g.Rc().a(this.gGH);
    g.Rc().b(145, this.gGI);
    g.Rc().b(132, this.gGI);
    AppMethodBeat.o(125234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.m.1
 * JD-Core Version:    0.7.0.1
 */