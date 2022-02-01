package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.v;

final class p$2$1
  implements DialogInterface.OnCancelListener
{
  p$2$1(p.2 param2, v paramv) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128423);
    h.aGY().a(this.ngm);
    h.aGY().b(126, this.ngB.ngA);
    AppMethodBeat.o(128423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.p.2.1
 * JD-Core Version:    0.7.0.1
 */