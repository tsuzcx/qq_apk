package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class CleanChattingUI$3$1
  implements DialogInterface.OnClickListener
{
  CleanChattingUI$3$1(CleanChattingUI.3 param3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(18780);
    CleanChattingUI.b(this.kIj.kIi);
    h.qsU.idkeyStat(714L, 22L, 1L, false);
    AppMethodBeat.o(18780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.3.1
 * JD-Core Version:    0.7.0.1
 */