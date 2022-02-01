package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;

final class CleanNewUI$2
  implements View.OnClickListener
{
  CleanNewUI$2(CleanNewUI paramCleanNewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22922);
    if (((k)g.ab(k.class)).aqo().cON()) {
      bi.ash();
    }
    ad.i("MicroMsg.CleanNewUI", "%s goto clean chatting ui", new Object[] { CleanNewUI.a(this.nPn) });
    this.nPn.startActivityForResult(new Intent(this.nPn, CleanChattingUI.class), 0);
    h.vKh.idkeyStat(714L, 12L, 1L, false);
    AppMethodBeat.o(22922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.2
 * JD-Core Version:    0.7.0.1
 */