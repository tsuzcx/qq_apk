package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class CleanMsgUI$3
  implements View.OnClickListener
{
  CleanMsgUI$3(CleanMsgUI paramCleanMsgUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(18800);
    this.kIC.startActivityForResult(new Intent(this.kIC, CleanChattingUI.class), 0);
    h.qsU.idkeyStat(714L, 12L, 1L, false);
    AppMethodBeat.o(18800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanMsgUI.3
 * JD-Core Version:    0.7.0.1
 */