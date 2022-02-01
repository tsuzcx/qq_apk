package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.protocal.protobuf.ffc;

public final class f$2
  implements DialogInterface.OnCancelListener
{
  public f$2(f paramf, q paramq, ffc paramffc, Runnable paramRunnable) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(49866);
    f.a(this.oqB, this.kzl, this.Iae);
    this.oqD.run();
    AppMethodBeat.o(49866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f.2
 * JD-Core Version:    0.7.0.1
 */