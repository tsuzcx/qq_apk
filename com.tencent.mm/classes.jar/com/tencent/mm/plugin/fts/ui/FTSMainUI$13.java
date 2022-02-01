package com.tencent.mm.plugin.fts.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;

final class FTSMainUI$13
  implements DialogInterface.OnCancelListener
{
  FTSMainUI$13(FTSMainUI paramFTSMainUI, com.tencent.mm.plugin.messenger.a.g paramg, com.tencent.mm.al.g paramg1) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(111976);
    com.tencent.mm.kernel.g.aeS().a(this.rtq);
    com.tencent.mm.kernel.g.aeS().b(106, this.ruL);
    FTSMainUI.g(this.ruJ);
    AppMethodBeat.o(111976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.13
 * JD-Core Version:    0.7.0.1
 */