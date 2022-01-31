package com.tencent.mm.plugin.clean.ui.newui;

import android.app.ProgressDialog;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.sdk.platformtools.ai;

final class CleanMsgUI$7
  implements com.tencent.mm.plugin.clean.c.h
{
  CleanMsgUI$7(CleanMsgUI paramCleanMsgUI) {}
  
  public final void cA(int paramInt1, int paramInt2)
  {
    CleanMsgUI.c(this.iEh).setMessage(this.iEh.getString(R.l.clean_progress_tip, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
  }
  
  public final void cZ(final long paramLong)
  {
    ai.d(new Runnable()
    {
      public final void run()
      {
        if (CleanMsgUI.c(CleanMsgUI.7.this.iEh) != null) {
          CleanMsgUI.c(CleanMsgUI.7.this.iEh).dismiss();
        }
        d.cX(d.aDU() + paramLong);
        d.cW(d.aDT() - paramLong);
        CleanMsgUI localCleanMsgUI = CleanMsgUI.7.this.iEh;
        d.aDU();
        CleanMsgUI.a(localCleanMsgUI, d.aDR(), d.aDT(), d.aDS());
      }
    });
    com.tencent.mm.plugin.report.service.h.nFQ.a(282L, 12L, 1L, false);
    com.tencent.mm.plugin.report.service.h.nFQ.a(282L, 13L, paramLong / 1024L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI.7
 * JD-Core Version:    0.7.0.1
 */