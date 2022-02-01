package com.tencent.mm.plugin.fts.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;

final class FTSMainUI$13
  implements DialogInterface.OnCancelListener
{
  FTSMainUI$13(FTSMainUI paramFTSMainUI, com.tencent.mm.plugin.messenger.a.g paramg, com.tencent.mm.ak.g paramg1) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(111976);
    com.tencent.mm.kernel.g.agi().a(this.sCk);
    com.tencent.mm.kernel.g.agi().b(106, this.sDD);
    FTSMainUI.g(this.sDB);
    AppMethodBeat.o(111976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.13
 * JD-Core Version:    0.7.0.1
 */