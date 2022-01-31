package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

final class m$2$1
  implements DialogInterface.OnCancelListener
{
  m$2$1(m.2 param2, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125235);
    g.Rc().a(this.gDI);
    g.Rc().b(701, this.gGJ.gGI);
    g.Rc().b(252, this.gGJ.gGI);
    AppMethodBeat.o(125235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.m.2.1
 * JD-Core Version:    0.7.0.1
 */