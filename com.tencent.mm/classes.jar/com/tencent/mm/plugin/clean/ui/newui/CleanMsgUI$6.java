package com.tencent.mm.plugin.clean.ui.newui;

import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;

final class CleanMsgUI$6
  implements h.d
{
  CleanMsgUI$6(CleanMsgUI paramCleanMsgUI) {}
  
  public final void bF(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return;
    }
    long l = CleanMsgUI.aEi();
    if (l > 0L)
    {
      h.a(this.iEh, this.iEh.getString(R.l.clean_three_month_res, new Object[] { bk.cm(l) }), "", this.iEh.getString(R.l.delete), this.iEh.getString(R.l.cancel), new CleanMsgUI.6.1(this), null);
      return;
    }
    Toast.makeText(this.iEh, R.l.no_three_month_res, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI.6
 * JD-Core Version:    0.7.0.1
 */