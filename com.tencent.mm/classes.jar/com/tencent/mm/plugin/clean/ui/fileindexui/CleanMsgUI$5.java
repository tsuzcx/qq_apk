package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class CleanMsgUI$5
  implements com.tencent.mm.plugin.clean.c.h
{
  CleanMsgUI$5(CleanMsgUI paramCleanMsgUI) {}
  
  public final void cA(int paramInt1, int paramInt2)
  {
    CleanMsgUI.a(this.iDv).setMessage(this.iDv.getString(R.l.clean_progress_tip, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
  }
  
  public final void cZ(long paramLong)
  {
    y.i("MicroMsg.CleanMsgUI", "onDeleteEnd %d ", new Object[] { Long.valueOf(paramLong) });
    ai.d(new CleanMsgUI.5.1(this, paramLong));
    com.tencent.mm.plugin.report.service.h.nFQ.a(714L, 13L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanMsgUI.5
 * JD-Core Version:    0.7.0.1
 */