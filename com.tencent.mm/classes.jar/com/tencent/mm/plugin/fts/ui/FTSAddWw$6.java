package com.tencent.mm.plugin.fts.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.n;

final class FTSAddWw$6
  implements DialogInterface.OnCancelListener
{
  FTSAddWw$6(FTSAddWw paramFTSAddWw, n paramn) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(61758);
    g.Rc().a(this.mWF);
    g.Rc().b(372, FTSAddWw.h(this.mWE));
    FTSAddWw.i(this.mWE);
    AppMethodBeat.o(61758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddWw.6
 * JD-Core Version:    0.7.0.1
 */