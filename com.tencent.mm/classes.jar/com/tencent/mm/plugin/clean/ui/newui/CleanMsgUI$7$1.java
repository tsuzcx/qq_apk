package com.tencent.mm.plugin.clean.ui.newui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.clean.c.d;

final class CleanMsgUI$7$1
  implements Runnable
{
  CleanMsgUI$7$1(CleanMsgUI.7 param7, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(18894);
    if (CleanMsgUI.c(this.kJr.kJo) != null) {
      CleanMsgUI.c(this.kJr.kJo).dismiss();
    }
    d.it(d.bgU() + this.kIc);
    d.is(d.bgT() - this.kIc);
    CleanMsgUI localCleanMsgUI = this.kJr.kJo;
    d.bgU();
    CleanMsgUI.a(localCleanMsgUI, d.bgR(), d.bgT(), d.bgS());
    AppMethodBeat.o(18894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI.7.1
 * JD-Core Version:    0.7.0.1
 */