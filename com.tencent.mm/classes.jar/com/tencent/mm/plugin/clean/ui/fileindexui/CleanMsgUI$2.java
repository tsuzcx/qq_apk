package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;

final class CleanMsgUI$2
  implements View.OnClickListener
{
  CleanMsgUI$2(CleanMsgUI paramCleanMsgUI) {}
  
  public final void onClick(View paramView)
  {
    h.a(this.iDv, this.iDv.getString(R.l.clean_other_acc_tips, new Object[] { bk.ht(j.aEb().iBm) }), "", this.iDv.getString(R.l.app_ok), this.iDv.getString(R.l.app_cancel), new CleanMsgUI.2.1(this), null, R.e.red);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanMsgUI.2
 * JD-Core Version:    0.7.0.1
 */