package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;

final class CleanChattingUI$3
  implements View.OnClickListener
{
  CleanChattingUI$3(CleanChattingUI paramCleanChattingUI) {}
  
  public final void onClick(View paramView)
  {
    h.a(this.iEe, this.iEe.getString(R.l.confirm_delete_chatting), "", this.iEe.getString(R.l.delete), this.iEe.getString(R.l.cancel), new CleanChattingUI.3.1(this), new CleanChattingUI.3.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanChattingUI.3
 * JD-Core Version:    0.7.0.1
 */