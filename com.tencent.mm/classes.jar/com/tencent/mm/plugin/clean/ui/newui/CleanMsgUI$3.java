package com.tencent.mm.plugin.clean.ui.newui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

final class CleanMsgUI$3
  implements View.OnClickListener
{
  CleanMsgUI$3(CleanMsgUI paramCleanMsgUI) {}
  
  public final void onClick(View paramView)
  {
    this.iEh.startActivityForResult(new Intent(this.iEh, CleanChattingUI.class), 0);
    h.nFQ.a(282L, 4L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI.3
 * JD-Core Version:    0.7.0.1
 */