package com.tencent.mm.plugin.exdevice.model;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;

final class i$1
  implements DialogInterface.OnCancelListener
{
  i$1(i parami, o paramo, i.a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(19295);
    aw.Rc().a(this.lFj);
    if (i.a(this.lFl) != null) {
      i.a(this.lFl).dismiss();
    }
    i.b(this.lFl);
    if (this.lFk != null) {
      this.lFk.hd(false);
    }
    i.c(this.lFl);
    AppMethodBeat.o(19295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.i.1
 * JD-Core Version:    0.7.0.1
 */