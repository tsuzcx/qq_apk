package com.tencent.mm.plugin.choosemsgfile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.a.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;

final class ChooseMsgFileShowUI$4$1
  implements u.g
{
  ChooseMsgFileShowUI$4$1(ChooseMsgFileShowUI.4 param4) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(123407);
    params.c(0, this.wRc.wRa.getString(a.h.retransmit));
    params.c(3, this.wRc.wRa.getString(a.h.files_enter_float_ball));
    params.c(1, this.wRc.wRa.getString(a.h.choose_app));
    params.c(4, this.wRc.wRa.getString(a.h.export_to_mobile));
    AppMethodBeat.o(123407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI.4.1
 * JD-Core Version:    0.7.0.1
 */