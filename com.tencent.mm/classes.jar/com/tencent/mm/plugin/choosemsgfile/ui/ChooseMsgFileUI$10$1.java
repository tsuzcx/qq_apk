package com.tencent.mm.plugin.choosemsgfile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.e.c;

final class ChooseMsgFileUI$10$1
  implements e.c
{
  ChooseMsgFileUI$10$1(ChooseMsgFileUI.10 param10) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(54453);
    ab.i("MicroMsg.ChooseMsgFileUI", "bOk:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      ChooseMsgFileUI.d(this.kGp.kGm);
    }
    AppMethodBeat.o(54453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI.10.1
 * JD-Core Version:    0.7.0.1
 */