package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.protocal.protobuf.gnm;

public final class i$2
  implements DialogInterface.OnCancelListener
{
  public i$2(i parami, w paramw, gnm paramgnm, Runnable paramRunnable) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(49866);
    i.a(this.uCF, this.qrd, this.uEQ);
    this.uCH.run();
    AppMethodBeat.o(49866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.i.2
 * JD-Core Version:    0.7.0.1
 */