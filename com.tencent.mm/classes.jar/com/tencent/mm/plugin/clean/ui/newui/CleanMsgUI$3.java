package com.tencent.mm.plugin.clean.ui.newui;

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
    AppMethodBeat.i(18890);
    this.kJo.startActivityForResult(new Intent(this.kJo, CleanChattingUI.class), 0);
    h.qsU.idkeyStat(282L, 4L, 1L, false);
    AppMethodBeat.o(18890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI.3
 * JD-Core Version:    0.7.0.1
 */