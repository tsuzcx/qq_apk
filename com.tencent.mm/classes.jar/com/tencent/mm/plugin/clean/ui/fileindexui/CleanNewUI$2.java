package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class CleanNewUI$2
  implements View.OnClickListener
{
  CleanNewUI$2(CleanNewUI paramCleanNewUI) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.CleanNewUI", "%s goto clean msg ui", new Object[] { CleanNewUI.a(this.iDR) });
    h.nFQ.a(714L, 2L, 1L, false);
    this.iDR.startActivityForResult(new Intent(this.iDR, CleanMsgUI.class), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.2
 * JD-Core Version:    0.7.0.1
 */