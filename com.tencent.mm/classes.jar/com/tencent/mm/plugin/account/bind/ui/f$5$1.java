package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;

final class f$5$1
  implements DialogInterface.OnCancelListener
{
  f$5$1(f.5 param5, ac paramac) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(13754);
    this.gwp.gwn.onDetach();
    g.Rc().a(this.gwo);
    AppMethodBeat.o(13754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.f.5.1
 * JD-Core Version:    0.7.0.1
 */