package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;

final class CleanChattingDetailUI$3
  implements View.OnClickListener
{
  CleanChattingDetailUI$3(CleanChattingDetailUI paramCleanChattingDetailUI) {}
  
  public final void onClick(View paramView)
  {
    h.a(this.iEb, this.iEb.getString(R.l.confirm_delete_file), "", this.iEb.getString(R.l.delete), this.iEb.getString(R.l.cancel), new CleanChattingDetailUI.3.1(this), new CleanChattingDetailUI.3.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanChattingDetailUI.3
 * JD-Core Version:    0.7.0.1
 */