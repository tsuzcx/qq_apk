package com.tencent.mm.plugin.clean.ui.newui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.clean.c.d;
import java.util.ArrayList;

final class CleanChattingUI$6
  implements DialogInterface.OnClickListener
{
  CleanChattingUI$6(CleanChattingUI paramCleanChattingUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(18879);
    if ((d.bgQ() != null) && (d.bgQ().size() == 0)) {
      this.kJl.finish();
    }
    AppMethodBeat.o(18879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanChattingUI.6
 * JD-Core Version:    0.7.0.1
 */