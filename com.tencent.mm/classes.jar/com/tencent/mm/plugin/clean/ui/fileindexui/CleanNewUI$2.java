package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class CleanNewUI$2
  implements View.OnClickListener
{
  CleanNewUI$2(CleanNewUI paramCleanNewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(18812);
    ab.i("MicroMsg.CleanNewUI", "%s goto clean msg ui", new Object[] { CleanNewUI.a(this.kIY) });
    h.qsU.idkeyStat(714L, 2L, 1L, false);
    this.kIY.startActivityForResult(new Intent(this.kIY, CleanMsgUI.class), 0);
    AppMethodBeat.o(18812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.2
 * JD-Core Version:    0.7.0.1
 */