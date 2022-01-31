package com.tencent.mm.plugin.choosemsgfile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.e.c;

final class ChooseMsgFileListUI$3$1
  implements e.c
{
  ChooseMsgFileListUI$3$1(ChooseMsgFileListUI.3 param3) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(54413);
    ab.i("MicroMsg.ChooseMsgFileListUI", "bOk:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      ChooseMsgFileListUI.b(this.kGa.kFZ);
    }
    AppMethodBeat.o(54413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI.3.1
 * JD-Core Version:    0.7.0.1
 */