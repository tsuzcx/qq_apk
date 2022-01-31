package com.tencent.mm.plugin.choosemsgfile.ui;

import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.d.a;

final class ChooseMsgFileListUI$4
  implements Runnable
{
  ChooseMsgFileListUI$4(ChooseMsgFileListUI paramChooseMsgFileListUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(54415);
    Button localButton = ChooseMsgFileListUI.c(this.kFZ);
    if (ChooseMsgFileListUI.a(this.kFZ).getSelectCount() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      AppMethodBeat.o(54415);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI.4
 * JD-Core Version:    0.7.0.1
 */