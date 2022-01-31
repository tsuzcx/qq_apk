package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class CleanMsgUI$5
  implements com.tencent.mm.plugin.clean.c.h
{
  CleanMsgUI$5(CleanMsgUI paramCleanMsgUI) {}
  
  public final void dY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18802);
    CleanMsgUI.a(this.kIC).setMessage(this.kIC.getString(2131298394, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
    AppMethodBeat.o(18802);
  }
  
  public final void iv(final long paramLong)
  {
    AppMethodBeat.i(18803);
    ab.i("MicroMsg.CleanMsgUI", "onDeleteEnd %d ", new Object[] { Long.valueOf(paramLong) });
    al.d(new Runnable()
    {
      public final void run()
      {
        long l2 = 0L;
        AppMethodBeat.i(18801);
        if (CleanMsgUI.a(CleanMsgUI.5.this.kIC) != null) {
          CleanMsgUI.a(CleanMsgUI.5.this.kIC).dismiss();
        }
        long l3 = j.bhb().kGt;
        long l1 = j.bhb().kGt - paramLong;
        if (l1 < 0L) {}
        for (l1 = j.bhb().kGr - l3;; l1 = l3)
        {
          j.bhb().kGt = l2;
          j.bhb().kGr = l1;
          CleanMsgUI.a(CleanMsgUI.5.this.kIC, j.bhb().kGr, j.bhb().kGs, j.bhb().kGt);
          AppMethodBeat.o(18801);
          return;
          l3 = j.bhb().kGr - paramLong;
          l2 = l1;
        }
      }
    });
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(714L, 13L, 1L, false);
    AppMethodBeat.o(18803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanMsgUI.5
 * JD-Core Version:    0.7.0.1
 */