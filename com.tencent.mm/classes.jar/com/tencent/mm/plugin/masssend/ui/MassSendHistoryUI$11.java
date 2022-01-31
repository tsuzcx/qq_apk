package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class MassSendHistoryUI$11
  implements View.OnClickListener
{
  MassSendHistoryUI$11(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.mbC, MassSendSelectContactUI.class);
    this.mbC.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.11
 * JD-Core Version:    0.7.0.1
 */