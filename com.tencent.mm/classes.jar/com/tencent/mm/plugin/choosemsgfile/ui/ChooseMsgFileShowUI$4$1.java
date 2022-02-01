package com.tencent.mm.plugin.choosemsgfile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.a.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;

final class ChooseMsgFileShowUI$4$1
  implements q.f
{
  ChooseMsgFileShowUI$4$1(ChooseMsgFileShowUI.4 param4) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(123407);
    paramo.d(0, this.tNM.tNK.getString(a.h.retransmit));
    paramo.d(3, this.tNM.tNK.getString(a.h.files_enter_float_ball));
    paramo.d(1, this.tNM.tNK.getString(a.h.choose_app));
    paramo.d(4, this.tNM.tNK.getString(a.h.export_to_mobile));
    AppMethodBeat.o(123407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI.4.1
 * JD-Core Version:    0.7.0.1
 */