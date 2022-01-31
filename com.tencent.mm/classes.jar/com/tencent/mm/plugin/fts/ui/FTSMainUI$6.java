package com.tencent.mm.plugin.fts.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class FTSMainUI$6
  implements DialogInterface.OnCancelListener
{
  FTSMainUI$6(FTSMainUI paramFTSMainUI, com.tencent.mm.plugin.messenger.a.f paramf, com.tencent.mm.ai.f paramf1) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(61871);
    g.Rc().a(this.mWB);
    g.Rc().b(106, this.mYj);
    FTSMainUI.p(this.mYi);
    AppMethodBeat.o(61871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.6
 * JD-Core Version:    0.7.0.1
 */