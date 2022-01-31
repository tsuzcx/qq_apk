package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class CleanChattingDetailUI$3$1
  implements DialogInterface.OnClickListener
{
  CleanChattingDetailUI$3$1(CleanChattingDetailUI.3 param3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(18768);
    CleanChattingDetailUI.b(this.kIb.kIa);
    h.qsU.idkeyStat(714L, 31L, 1L, false);
    AppMethodBeat.o(18768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI.3.1
 * JD-Core Version:    0.7.0.1
 */