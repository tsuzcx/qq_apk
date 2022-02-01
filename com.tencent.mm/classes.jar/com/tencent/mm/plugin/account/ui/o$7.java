package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;

final class o$7
  implements DialogInterface.OnCancelListener
{
  o$7(o paramo, u paramu) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128428);
    g.agi().a(this.iUg);
    g.agi().b(126, this.iUu);
    AppMethodBeat.o(128428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o.7
 * JD-Core Version:    0.7.0.1
 */