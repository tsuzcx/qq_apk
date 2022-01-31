package com.tencent.mm.plugin.clean.ui.newui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class CleanMsgUI$7
  implements com.tencent.mm.plugin.clean.c.h
{
  CleanMsgUI$7(CleanMsgUI paramCleanMsgUI) {}
  
  public final void dY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18895);
    CleanMsgUI.c(this.kJo).setMessage(this.kJo.getString(2131298394, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
    AppMethodBeat.o(18895);
  }
  
  public final void iv(long paramLong)
  {
    AppMethodBeat.i(18896);
    al.d(new CleanMsgUI.7.1(this, paramLong));
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(282L, 12L, 1L, false);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(282L, 13L, paramLong / 1024L, false);
    AppMethodBeat.o(18896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI.7
 * JD-Core Version:    0.7.0.1
 */